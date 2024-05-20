package service.userService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connection.*;
import controller.ProductControl;
import dto.product.Product_DTO;
import entity.UserObject;
import utility.Utilities;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/user/cart")
public class UserCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCart() {
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
		ProductControl pc = new ProductControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", pc.getCP());
		}
		try {
			TreeMap<Product_DTO,Integer> product_DTOs = (TreeMap<Product_DTO,Integer>) request.getSession().getAttribute("product-cart");
			
			if (product_DTOs==null) {
				product_DTOs = new TreeMap<Product_DTO,Integer>();
			}
			request.setAttribute("product-cart", pc.viewCart(product_DTOs));
			System.out.println("get:"+product_DTOs);
		} catch (ClassCastException e) {
			TreeMap<Product_DTO,Integer> product_DTOs = new TreeMap<Product_DTO,Integer>();
			request.setAttribute("product-cart", pc.viewCart(product_DTOs));
		}
		
	   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/user/cart.jsp");
	   requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);
	
		// Thiết lập tập ký tự cần lấy. Việc thiết lập này cần xác định từ đầu
		request.setCharacterEncoding("utf-8");
		
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng
		ProductControl pc = new ProductControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", pc.getCP());
		}
		
		// Lấy từ khóa tìm kiếm
		int id = Utilities.getIntParam(request, "id");

		Product_DTO product_DTO = pc.getProduct_DTOById(id);
		
		try {
			TreeMap<Product_DTO,Integer> product_DTOs = (TreeMap<Product_DTO,Integer>) request.getSession().getAttribute("product-cart");
			
			if (product_DTOs==null) {
				product_DTOs = new TreeMap<Product_DTO,Integer>();
				product_DTOs.put(product_DTO,1);
				System.out.println("post new from null:"+product_DTOs);
			} else {
				if (product_DTOs.containsKey(product_DTO)) {		
					product_DTOs.replace(product_DTO,product_DTOs.get(product_DTO)+1);
					System.out.println("post update:"+product_DTOs);
				} else {
					product_DTOs.put(product_DTO,1);
					System.out.println("post new:"+product_DTOs);
				}
				
			}	
			request.getSession().setAttribute("product-cart", product_DTOs);
		} catch (ClassCastException e) {
			TreeMap<Product_DTO,Integer> product_DTOs = new TreeMap<Product_DTO,Integer>();
			product_DTOs.put(product_DTO,1);
			System.out.println("post error:"+product_DTOs);
			request.getSession().setAttribute("product-cart", product_DTOs);
			
		}	
		// Trả về kết nối
		pc.releaseConnection();
	}

}
 