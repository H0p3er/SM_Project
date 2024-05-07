package service.shopService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Quintet;

import com.google.gson.Gson;

import connection.ConnectionPool;
import controller.ProductControl;
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
	private ShopControl shopControl;
	private ProductControl productControl;
	private ConnectionPool connectionPool;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopProfile() {
		super();
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		this.shopControl.releaseCP();
		this.productControl.releaseConnection();
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
		view(request, response, user);
	}

	protected void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType(CONTENT_TYPE);
		/* EmployeeObject similar = new EmployeeObject(); */
		ShopObject similar = new ShopObject();

		this.connectionPool = (ConnectionPool) getServletContext().getAttribute("CPool");
		this.shopControl = new ShopControl(connectionPool);
		// TODO Auto-generated constructor stub
		if (connectionPool == null) {
			getServletContext().setAttribute("CPool", this.shopControl.getCP());
		} 

		PrintWriter out = response.getWriter();

		// Xac dinh kieu noi dung xuat ve trinh khach
		Quintet<Short, Byte,  Map<String,String>,  Map<String,String>,  Map<String,String>> productInfors = 
		new Quintet<>
		((short) 0,(byte) 0, 
				utility.Utilities.getMapParam(request, null), 
				utility.Utilities.getMapParam(request, null),
				utility.Utilities.getMapParam(request, null));

		Map<String,String> data = shopControl.displayShop_Profile(productInfors,utility.Utilities.getIntParam(request, "id"));
		
		this.shopControl.releaseCP();
		
		request.setAttribute("shop-profile", data);
	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/shop/shop_profile.jsp");
		// Tạo đối tượng thực hiện xuất nội dung
	    requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
