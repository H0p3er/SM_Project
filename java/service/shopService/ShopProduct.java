package service.shopService;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
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
import javax.servlet.http.Part;

import org.javatuples.Quintet;

import com.google.gson.Gson;

import connection.ConnectionPool;
import constant.PRODUCT_EDIT_TYPE;
import controller.ProductControl;
import controller.ShopControl;
import dto.pc.PC_DTO;
import dto.product.Product_DTO;
import entity.UserObject;
import utility.Utilities_date;


@WebServlet("/seller/shop/product")
public class ShopProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "application/json; charset=utf-8";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopProduct() {
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
			response.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
		}
		
	}

	private void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {	
		response.setContentType(CONTENT_TYPE);		
		ConnectionPool connectionPool= (ConnectionPool) getServletContext().getAttribute("CPool");	
		ShopControl shopControl = new ShopControl(connectionPool);	
		if (connectionPool == null) {
			getServletContext().setAttribute("CPool", shopControl.getCP());
		} 
		Quintet<Short, Byte,  Map<String,String>,  Map<String,String>,  Map<String,String>> productInfors = 
		new Quintet<>
		((short) 0,(byte) 0, 
				utility.Utilities.getMapParam(request, null), 
				utility.Utilities.getMapParam(request, null),
				utility.Utilities.getMapParam(request, null));
		
		
		
		Map<String,String> data = shopControl.displaySeller_ShopProduct(productInfors,user);	
		shopControl.releaseCP();
		System.out.print(data);
		request.setAttribute("shop-product", data);	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/seller/shop_products.jsp");
		// Tạo đối tượng thực hiện xuất nội dung
	    requestDispatcher.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
		if (user!=null) {
			add(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
			response.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
		}
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//Thiết lập tập kí tự
		String name = request.getParameter("productName");
		if(name != null && !name.isBlank()) {	
			Product_DTO product_DTO = new Product_DTO();
			product_DTO.setName(name);
			product_DTO.setPc(new PC_DTO(utility.Utilities.getIntParam(request, "productPc")));
			product_DTO.setQuantity(utility.Utilities.getIntParam(request, "productQuantity"));
			product_DTO.setCreated_date(Utilities_date.getCurrentDate());
			product_DTO.setNotes(utility.Utilities.encode(request.getParameter("productNote")));
			
			// Lưu thay đổi vào csdl
			ConnectionPool cp = (ConnectionPool)getServletContext().getAttribute("CPool");
			ProductControl productControl = new ProductControl(cp);
			if(cp == null) {
				cp = productControl.getCP();
				getServletContext().setAttribute("CPool", cp);
			}
			boolean editSuccess = productControl.addProduct(product_DTO);
			if(editSuccess) {
				response.sendRedirect("/home/seller/shop/product?type=add&status=succ");
				
			} else {
				response.sendRedirect("/home/seller/shop/product?type=add&status=err");
			}
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserObject user = (UserObject)request.getSession().getAttribute("userLogined");
		if (user!=null) {
			update(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
			response.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//Thiết lập tập kí tự
		
		String name = request.getParameter("productName");
		if(name != null && !name.isBlank()) {
			Product_DTO product_DTO = new Product_DTO();
			product_DTO.setName(name);
			product_DTO.setPc(new PC_DTO(utility.Utilities.getIntParam(request, "productPc")));
			product_DTO.setQuantity(utility.Utilities.getIntParam(request, "productQuantity"));
			product_DTO.setCreated_date(Utilities_date.getCurrentDate());
			product_DTO.setNotes(utility.Utilities.encode(request.getParameter("productNote")));
			
			// Lưu thay đổi vào csdl
			ConnectionPool cp = (ConnectionPool)getServletContext().getAttribute("CPool");
			ProductControl productControl = new ProductControl(cp);
			if(cp == null) {
				cp = productControl.getCP();
				getServletContext().setAttribute("CPool", cp);
			}
			boolean editSuccess = productControl.editProduct(product_DTO, PRODUCT_EDIT_TYPE.GENERAL);
			if(editSuccess) {
				response.sendRedirect("/home/seller/shop/product?type=edit&status=succ");
				
			} else {
				response.sendRedirect("/home/seller/shop/product/add?type=edit&status=err");
			}
		}
	}	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserObject user = (UserObject)request.getSession().getAttribute("userLogined");
		if (user!=null) {
			delete(request, response, user);
		} else {
			response.sendRedirect("/home/homepage");
			response.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
		}
			
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
		// TODO Auto-generated method stub
		short id = utility.Utilities.getShortParam(request, "id");
		String url = request.getRequestURI();

		if(user != null && id>0) {

			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			ProductControl pc = new ProductControl(cp);
			Product_DTO sProduct = new Product_DTO();
			sProduct.setId(id);
			sProduct.setLast_modified(Utilities_date.getCurrentDate());
			

			String isStopedCell = request.getParameter("t");
			String isRestore = request.getParameter("r");
			if(isRestore != null) {
				sProduct.setDeleted((byte)1);
			} else {
				sProduct.setDeleted((byte)0);
			}
			
			boolean result;
			String status;
			if(isStopedCell == null) {
				result = pc.delProduct(sProduct);
				url += "?trash";
			} else {
				result = pc.editProduct(sProduct, PRODUCT_EDIT_TYPE.DELETED);
			}
			pc.releaseConnection();
			if(result) {
//					status = "succ";
				response.sendRedirect(url);
			} else {
//					status = "err";
				response.sendRedirect(url + "&err=notok");
			}
//			} else {
//				response.sendRedirect("/home/product/product-list.jsp?err=nopermis");
//			}
		} else {
			response.sendRedirect("/home/seller/shop/product?type=del&status=err");
		}
		
	}


}
