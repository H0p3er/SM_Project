package service.userService;

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
import org.javatuples.Triplet;

import com.google.gson.Gson;

import connection.ConnectionPool;
import controller.BillControl;
import controller.ProductControl;
import controller.ShopControl;
import controller.UserControl;
import dto.product.Product_manageShopDTO;
import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_statisticDTO;
import entity.UserObject;
import library.ShopLibrary;
import entity.ShopObject;

/**
 * Servlet implementation class WorkplaceProfile
 */
@WebServlet("/user/shop/profile")
public class UserShopProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "application/json; charset=utf-8";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserShopProfile() {
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
		if (user!=null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
		}
		
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
		Shop_manageShopDTO shop_manageShopDTO = shopControl.getShopDTOByUser(productInfors,user);
		
		ProductControl productControl = new ProductControl(connectionPool);
		Triplet<List<Product_manageShopDTO>,Integer, List<Pair<Product_manageShopDTO,Double>>> product_statistic = productControl.getProductStatistic(productInfors, shop_manageShopDTO);
		productControl.releaseCP();
		
		BillControl billControl = new BillControl(connectionPool);
		shop_manageShopDTO.setBill(billControl.getBillDTOByShop(shop_manageShopDTO));
		billControl.releaseConnection();
		
		Triplet<Map<String,Double>, Double, Double> income_statistic = billControl.getIncomeStatisticByShop(shop_manageShopDTO);
		Triplet<Map<String,Integer>,Integer,Integer> order_statistic = billControl.getOrderStatisticByShop(shop_manageShopDTO);
		
		
		UserControl userControl = new UserControl(connectionPool);
		Triplet<Map<String,Integer>,Integer,Integer> customer_statistic = userControl.getCustomerStatisticByShop(shop_manageShopDTO);
		
		
		Shop_statisticDTO shop_StatisticDTO = new Shop_statisticDTO();	
		shop_StatisticDTO.setMost_sold_product_current_month(product_statistic.getValue2());
		
		
		shop_StatisticDTO.setIncome_current_month(income_statistic.getValue0());
		shop_StatisticDTO.setSum_income_current_month(income_statistic.getValue1());
		shop_StatisticDTO.setSum_income_last_month(income_statistic.getValue2());
		
		
		shop_StatisticDTO.setOrder_current_month(order_statistic.getValue0());
		shop_StatisticDTO.setCount_order_current_month(order_statistic.getValue1());
		shop_StatisticDTO.setCount_order_last_month(order_statistic.getValue2());
		
		
		shop_StatisticDTO.setCustomer_current_month(customer_statistic.getValue0());
		shop_StatisticDTO.setCount_customer_current_month(customer_statistic.getValue1());
		shop_StatisticDTO.setCount_customer_last_month(customer_statistic.getValue2());
		
		shop_manageShopDTO.setStatistic(shop_StatisticDTO);
		
		Map<String,String> data = ShopLibrary.viewUser_ShopProfile(shop_manageShopDTO);
		shopControl.releaseCP();

		
		request.setAttribute("shop-profile", data);

		if (data.containsKey("shop-exist")) {
		    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/shop/shop_profile.jsp");
			// Tạo đối tượng thực hiện xuất nội dung
		    requestDispatcher.forward(request, response);	
		} else {	
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/user/shop_create.jsp");
			// Tạo đối tượng thực hiện xuất nội dung
		    requestDispatcher.forward(request, response);
		}
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
