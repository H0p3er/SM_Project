package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;

import com.google.gson.Gson;

import connection.ConnectionPool;
import controller.PCControl;
import controller.ProductControl;
import dto.product.Product_DTO;
import dto.product.Product_viewProductDTO;
import entity.UserObject;
import library.ProductLibrary;
import utility.Utilities;

/**
 * Servlet implementation class Home
 */
@WebServlet("/homepage")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		String key = request.getParameter("key");
		String saveKey = (key != null && !key.equalsIgnoreCase("")) ? key.trim() : "";
		
		
		// Tìm tham số xác định loại danh sách

		short page = Utilities.getShortParam(request, "page");
		if(page < 1) {
			page = 1;
		}
		// Lấy cấu trúc
		Pair<ArrayList<Product_viewProductDTO>,ArrayList<Product_viewProductDTO>> viewProductsList = productControl.viewHomeProduct();
		productControl.releaseCP();

		PCControl pcControl = new PCControl(cp);
		viewProductsList.getValue0().forEach(product->{
			pcControl.getProductAttribute(product);
		});
		viewProductsList.getValue1().forEach(product->{
			pcControl.getProductAttribute(product);
		});
		
		pcControl.releaseCP();
		
		Map<String,String> datas = ProductLibrary.viewHomeProduct(viewProductsList);
		// Trả về kết nối
		
	    
	    request.setAttribute("home-page",datas);
	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/home.jsp");
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
