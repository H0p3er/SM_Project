package service.productService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionPool;
import constant.PRODUCT_EDIT_TYPE;
import controller.ProductControl;
import dto.product.Product_DTO;
import entity.UserObject;
import utility.Utilities_date;

/**
 * Servlet implementation class ProductDR
 */
@WebServlet("/product/dr")
public class ProductDR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserObject user = (UserObject)request.getSession().getAttribute("userLogined");
		if (user!=null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
		}
			
	}
	
	private void view(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
		// TODO Auto-generated method stub
		short id = utility.Utilities.getShortParam(request, "id");
		String url = request.getRequestURI();

		if(user != null && id>0) {

			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			ProductControl pc = new ProductControl(cp);
			Product_DTO sProduct = new Product_DTO();
			sProduct.setId(id);
			sProduct.setLast_modified(Utilities_date.getCurrentDate());
			

			String isStopedCell = request.getParameter("t");
			String isRestore = request.getParameter("r");
			if(isRestore != null) {
				sProduct.setDeleted((byte)1);
			} else {
				sProduct.setDeleted((byte)0);
			}
			
			boolean result;
			String status;
			if(isStopedCell == null) {
				result = pc.delProduct(sProduct);
				url += "?trash";
			} else {
				result = pc.editProduct(sProduct, PRODUCT_EDIT_TYPE.DELETED);
			}
			pc.releaseConnection();
			if(result) {
//					status = "succ";
				response.sendRedirect(url);
			} else {
//					status = "err";
				response.sendRedirect(url + "&err=notok");
			}
//			} else {
//				response.sendRedirect("/home/product/product-list.jsp?err=nopermis");
//			}
		} else {
			response.sendRedirect("/home/product/product-list.jsp?err=del");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
