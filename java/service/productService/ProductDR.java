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
import entity.EmployeeObject;
import entity.ProductObject;
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
		EmployeeObject user = (EmployeeObject)request.getSession().getAttribute("userLogined");
		short id = utility.Utilities.getShortParam(request, "id");
		String url = "/home/product/product-list.jsp";
//		System.out.println("permis: "+ user.getUser_permission());
		if(user != null && id>0) {
			// Náº¿u user lÃ  admin hoáº·c user lÃ  cha cá»§a ngÆ°á»�i dÃ¹ng muá»‘n xÃ³a
//			if(user.getUser_permission() >= 4) {
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			ProductControl pc = new ProductControl(cp);
			ProductObject sProduct = new ProductObject();
			sProduct.setProduct_id(id);
			sProduct.setProduct_last_modified(Utilities_date.getCurrentDate());
			
			// Ä‘ang á»Ÿ trong danh sÃ¡ch Ä‘Ã£ dá»«ng kinh doanh hay ko. Náº¿u á»Ÿ trong thÃ¬ lÃ  null
			String isStopedCell = request.getParameter("t");
			String isRestore = request.getParameter("r");
			if(isRestore != null) {
				sProduct.setProduct_deleted(false);
			} else {
				sProduct.setProduct_deleted(true);
			}
			
			boolean result;
			String status;
			if(isStopedCell == null) {
				result = pc.delProduct(sProduct);
				// Chuyá»ƒn Ä‘áº¿n danh sÃ¡ch sáº£n pháº©m Ä‘Ã£ ngá»«ng kinh doanh
				url += "?trash";
			} else {
				result = pc.editProduct(sProduct, PRODUCT_EDIT_TYPE.DELETE);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
