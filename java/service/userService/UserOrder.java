package service.userService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
import controller.BillControl;
import controller.ProductControl;
import dto.bd.BD_DTO;
import dto.bd.BD_viewOrderDTO;
import dto.bill.Bill_DTO;
import dto.bill.Bill_viewOrderDTO;
import dto.product.Product_DTO;
import entity.UserObject;
import utility.Utilities;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/user/order")
public class UserOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOrder() {
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
		PrintWriter out = response.getWriter();
		
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng
		ProductControl pc = new ProductControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", pc.getCP());
		}
		// Trả về kết nối
		pc.releaseCP();
		// Tạo đối tượng thực hiện xuất nội dung
		request.setAttribute("product-order", "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
		if (user!=null) {
			add(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
			response.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
		}
	}

	
	private void add(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
		// Xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);
		
		// Thiết lập tập ký tự cần lấy. Việc thiết lập này cần xác định từ đầu
		request.setCharacterEncoding("utf-8");	
		PrintWriter out = response.getWriter();
		
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng
		BillControl billControl = new BillControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", billControl.getCP());
		}
		
		
		Bill_viewOrderDTO bill_viewOrderDTO = new Bill_viewOrderDTO();
		bill_viewOrderDTO.setBill_creator_id(user.getUser_id());
		bill_viewOrderDTO.setBill_delivery_id(Utilities.getIntParam(request, "delivery"));
		
		BD_viewOrderDTO bd_DTO = new BD_viewOrderDTO();
		
		bd_DTO.setId(Utilities.getIntParam(request, "id"));
		bd_DTO.setId(Utilities.getIntParam(request, "id"));
		List<BD_DTO> bd_DTOs = new ArrayList<BD_DTO>();
		
		// Trả về kết nối
		billControl.releaseConnection();
		// Tạo đối tượng thực hiện xuất nội dung
		request.setAttribute("product-order", "");
	}
}
