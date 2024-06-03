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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import connection.*;
import controller.ProductControl;
import dto.product.Product_DTO;
import dto.product.Product_viewProductDTO;
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
		if (user!=null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
		}
		
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
			TreeMap<Product_viewProductDTO,Integer> product_DTOs = (TreeMap<Product_viewProductDTO,Integer>) request.getSession().getAttribute("product-cart");
			if (product_DTOs==null) {
				product_DTOs = new TreeMap<Product_viewProductDTO,Integer>();
			}
			System.out.println("view:"+product_DTOs);
			request.setAttribute("product-cart", pc.viewCart(product_DTOs));
		} catch (ClassCastException e) {
			TreeMap<Product_viewProductDTO,Integer> product_DTOs = new TreeMap<Product_viewProductDTO,Integer>();
			System.out.println("view:"+product_DTOs);
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
		ProductControl productControl = new ProductControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", productControl.getCP());
		}
		
		// Lấy từ khóa tìm kiếm
		int id = Utilities.getIntParam(request, "id");

		Product_viewProductDTO product_DTO = productControl.getProduct_DTOById(id);
		
		// Trả về kết nối
		productControl.releaseCP();
		
		HttpSession session = request.getSession();
		try {
			TreeMap<Product_viewProductDTO,Integer> product_DTOs = (TreeMap<Product_viewProductDTO,Integer>) session.getAttribute("product-cart");
			Iterator<String> test =  session.getAttributeNames().asIterator();
			while (test.hasNext()) {
				System.out.println("rq.attribute:"+test.next());
			}
//			System.out.println("default:"+session.getAttribute("product-cart"));
			if (product_DTOs==null) {
				product_DTOs = new TreeMap<Product_viewProductDTO,Integer>();
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

			
			session.removeAttribute("product-cart");
			session.setAttribute("product-cart",product_DTOs);
//			System.out.println("default:"+session.getAttribute("product-cart"));
		} catch (ClassCastException e) {
			TreeMap<Product_viewProductDTO,Integer> product_DTOs = new TreeMap<Product_viewProductDTO,Integer>();
			product_DTOs.put(product_DTO,1);
			System.out.println("post error:"+product_DTOs);
			session.removeAttribute("product-cart");
			session.setAttribute("product-cart",product_DTOs);
		}
		

	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
		if (user!=null) {
			delete(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");			
		}
	
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
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
		Product_viewProductDTO product_DTO = new Product_viewProductDTO();
		product_DTO.setId(id);
		
		try {
			TreeMap<Product_viewProductDTO,Integer> product_DTOs = (TreeMap<Product_viewProductDTO,Integer>) request.getSession().getAttribute("product-cart");
			if (product_DTOs==null) {
				product_DTOs = new TreeMap<Product_viewProductDTO,Integer>();
			} else {
				if (product_DTOs.containsKey(product_DTO)) {		
					product_DTOs.remove(product_DTO);
				}	
			}	
			request.getSession().setAttribute("product-cart", product_DTOs);
		} catch (ClassCastException e) {
			TreeMap<Product_viewProductDTO,Integer> product_DTOs = new TreeMap<Product_viewProductDTO,Integer>();
			request.getSession().setAttribute("product-cart", product_DTOs);
		}	
		
		
		pc.releaseCP();
	}
	

}
 