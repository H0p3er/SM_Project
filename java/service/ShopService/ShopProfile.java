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

import org.javatuples.Pair;
import org.javatuples.Quintet;

import com.google.gson.Gson;

import connection.ConnectionPool;
import controller.PCControl;
import controller.ProductControl;
import controller.ShopControl;
import dto.product.Product_viewShopDTO;
import dto.shop.Shop_viewShopDTO;
import entity.UserObject;
import library.ShopLibrary;
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
		if (user == null) {
			user = new UserObject();
		}
		view(request, response, user);
	}

	protected void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType(CONTENT_TYPE);
		/* EmployeeObject similar = new EmployeeObject(); */
		ShopObject similar = new ShopObject();

		ConnectionPool connectionPool= (ConnectionPool) getServletContext().getAttribute("CPool");
		ShopControl shopControl = new ShopControl(connectionPool);
		// TODO Auto-generated constructor stub
		if (connectionPool == null) {
			getServletContext().setAttribute("CPool", shopControl.getCP());
		} 

		PrintWriter out = response.getWriter();

		// Xac dinh kieu noi dung xuat ve trinh khach
		Quintet<Short, Byte,  Map<String,String>,  Map<String,String>,  Map<String,String>> productInfors = 
		new Quintet<>
		((short) 0,(byte) 0, 
				utility.Utilities.getMapParam(request, null), 
				utility.Utilities.getMapParam(request, null),
				utility.Utilities.getMapParam(request, null));

		Shop_viewShopDTO shop_viewShopDTO = shopControl.getShopDTOById(productInfors,utility.Utilities.getIntParam(request, "id"), user);
		shopControl.releaseCP();
		
		ProductControl productControl = new ProductControl(connectionPool);
		Pair<ArrayList<Product_viewShopDTO>, Integer> product_viewShopDTO = productControl.getProduct_viewShopDTO(productInfors, shop_viewShopDTO);
		productControl.releaseCP();
		
		PCControl pcControl = new PCControl(connectionPool);
		product_viewShopDTO.getValue0().forEach(product->{
			pcControl.getProductAttribute(product);
		});
		pcControl.releaseCP();
		
		shop_viewShopDTO.setStorage(product_viewShopDTO);
		
		Map<String,String> data = ShopLibrary.viewShop_Profile(shop_viewShopDTO, user);
		
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
