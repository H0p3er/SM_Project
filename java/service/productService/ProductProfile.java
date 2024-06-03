package service.productService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Quartet;
import org.javatuples.Quintet;

import com.google.gson.Gson;

import connection.*;
import controller.PCControl;
import controller.ProductControl;
import dto.product.Product_DTO;
import dto.product.Product_viewProductDTO;
import dto.productAttribute.Product_AttributeDTO;
import entity.UserObject;
import library.ProductLibrary;
import utility.Utilities;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/product/profile")
public class ProductProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
		view(request, response, user);
	}
	
	private void view(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
		// Xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		
		// Thiết lập tập ký tự cần lấy. Việc thiết lập này cần xác định từ đầu
		request.setCharacterEncoding("utf-8");

		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng
		ProductControl productControl = new ProductControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", productControl.getCP());
		}
		
		// Lấy từ khóa tìm kiếm
		int id = Utilities.getIntParam(request, "id");
		Product_viewProductDTO product_viewProductDTO = productControl.getProduct_DTOById(id);
		productControl.releaseCP();
		
		PCControl pcControl = new PCControl(cp);
		
		pcControl.getProductAttribute(product_viewProductDTO);
		
		pcControl.releaseCP();
		Map<String,String> viewProduct = ProductLibrary.viewProductProfile(product_viewProductDTO) ;

		// Trả về kết nối
		productControl.releaseCP();
		// Tạo đối tượng thực hiện xuất nội dung
		request.setAttribute("product-profile", viewProduct);
	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/product/productprofile.jsp");
	    requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
