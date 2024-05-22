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
import constant.SHOP_EDIT_TYPE;
import controller.ProductControl;
import controller.ShopControl;
import dto.shop.Shop_DTO;
import dto.shop.Shop_manageShopDTO;
import dto.user.User_DTO;
import dto.user.User_manageShopDTO;
import entity.UserObject;
import entity.ShopObject;

/**
 * Servlet implementation class WorkplaceProfile
 */
@WebServlet("/seller/shop/profile")
public class ShopEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "application/json; charset=utf-8";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopEdit() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserObject user = (UserObject)request.getSession().getAttribute("userLogined");
		if (user!=null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
//			response.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
		}
	}

	private void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		response.setCharacterEncoding("utf-8");
		ConnectionPool connectionPool= (ConnectionPool) getServletContext().getAttribute("CPool");
		ShopControl shopControl = new ShopControl(connectionPool);
		if (connectionPool == null) {
			getServletContext().setAttribute("CPool", shopControl.getCP());
		} 
		// Xac dinh kieu noi dung xuat ve trinh khach
		Quintet<Short, Byte,  Map<String,String>,  Map<String,String>,  Map<String,String>> productInfors = 
		new Quintet<>
		((short) 0,(byte) 0, 
				utility.Utilities.getMapParam(request, null), 
				utility.Utilities.getMapParam(request, null),
				utility.Utilities.getMapParam(request, null));

		Map<String,String> data = shopControl.displaySeller_ShopProfile(productInfors,user);
		
		shopControl.releaseCP();
		
		request.setAttribute("shop-edit", data);
	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/seller/shop_edit.jsp");
		// Tạo đối tượng thực hiện xuất nội dung
	    requestDispatcher.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserObject user = (UserObject)request.getSession().getAttribute("userLogined");
		if (user!=null) {
			edit(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
//			response.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserObject user = (UserObject)request.getSession().getAttribute("userLogined");
		if (user!=null) {
			edit(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
//			response.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		request.setCharacterEncoding("utf-8");

		ConnectionPool connectionPool= (ConnectionPool) getServletContext().getAttribute("CPool");
		ShopControl shopControl = new ShopControl(connectionPool);
		// TODO Auto-generated constructor stub
		if (connectionPool == null) {
			getServletContext().setAttribute("CPool", shopControl.getCP());
		} 
		
		User_DTO user_DTO = new User_manageShopDTO();
		((User_manageShopDTO)user_DTO).setId(user.getUser_id());
		Shop_DTO shop_DTO = new Shop_manageShopDTO();
		((Shop_manageShopDTO)shop_DTO).setId(utility.Utilities.getIntParam(request, "shopId"));
		((Shop_manageShopDTO)shop_DTO).setName(utility.Utilities.getStringParam(request, "shopName"));
		((Shop_manageShopDTO)shop_DTO).setAddress(utility.Utilities.getStringParam(request, "shopAddress"));
		((Shop_manageShopDTO)shop_DTO).setStatus(utility.Utilities.getByteParam(request, "shopStatus"));
	
		((Shop_manageShopDTO)shop_DTO).setEmail(utility.Utilities.getStringParam(request, "shopEmail"));
		((Shop_manageShopDTO)shop_DTO).setPhone(utility.Utilities.getStringParam(request, "shopPhone"));
		((Shop_manageShopDTO)shop_DTO).setNotes(utility.Utilities.getStringParam(request, "shopNotes"));
		((Shop_manageShopDTO)shop_DTO).setUser((User_manageShopDTO) user_DTO);
		boolean result = shopControl.editShop(shop_DTO, SHOP_EDIT_TYPE.GENERAL);
		shopControl.releaseCP();	
		
		if (result) {
			response.sendRedirect("/home/seller/shop/profile?type=edit&status=succ");
		} else {
			response.sendRedirect("/home/seller/shop/profile?type=edit&status=fail");
		}
	
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
