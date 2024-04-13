package service.ShopService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Triplet;

import com.google.gson.Gson;

import connection.ConnectionPool;
import controller.ShopControl;
import entity.UserObject;
import entity.ShopObject;

/**
 * Servlet implementation class WorkplaceProfile
 */
@WebServlet("/shop/profile")
public class ShopProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "application/json; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Tìm thông tin đăng nhập
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
		
		 if (user!=null) { 
			 view(request, response, user); 
		 
		 } else {
			 user = new UserObject();
			 user.setUser_id(2);
			 view(request, response, user);
//			 response.sendRedirect("/home/login"); 
		 }
	}

	protected void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType(CONTENT_TYPE);
		/* EmployeeObject similar = new EmployeeObject(); */
		ShopObject similar = new ShopObject();

		ConnectionPool connectionPool = (ConnectionPool) getServletContext().getAttribute("CPool");

		ShopControl shopControl = new ShopControl(connectionPool);

		if (connectionPool == null) {
			getServletContext().setAttribute("CPool", shopControl.getCP());
		}

		shopControl.releaseCP();// Tra ve ket noi

		PrintWriter out = response.getWriter();
		// Xac dinh kieu noi dung xuat ve trinh khach
		Triplet<String, Short, Byte> infors = new Triplet<String, Short, Byte>("",(short) 0,(byte) 0);
		List<String> data = shopControl.displaySellerShopProfile(infors,user);
		Gson gson = new Gson();
	    String jsonData = gson.toJson(data);
		out.append(jsonData);
		// Tạo đối tượng thực hiện xuất nội dung
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WorkplaceProfile");

		if (dispatcher != null) {
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/error?err=404NotFound");
		}
	}

}
