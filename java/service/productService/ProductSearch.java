package service.productService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
import controller.PCControl;
import controller.ProductControl;
import dto.product.Product_DTO;
import entity.UserObject;
import utility.Utilities;
import utility.Utilities_text;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/product/search")
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearch() {
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
		ProductControl productControl = new ProductControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", productControl.getCP());
		}
		
		// Lấy từ khóa tìm kiếm;
		short page = Utilities.getShortParam(request, "page");
		if(page < 1) {
			page = 1;
		}		
		
		Map<String, String> multiConditions = new HashMap<String, String>();
		
		if (Utilities_text.checkValidString(request, "search")) {
			String search = utility.Utilities.getStringParam(request, "search");
			multiConditions.put("search", search);
			request.setAttribute("product-name", search);
		}
		if (Utilities_text.checkValidString(request, "pc")) {
			String category = utility.Utilities.getStringParam(request, "pc");
			multiConditions.put("category", category);
		}
		if (Utilities_text.checkValidString(request, "max")) {
			String max = utility.Utilities.getStringParam(request, "max");
			multiConditions.put("max", max);
		}
		if (Utilities_text.checkValidString(request, "min")) {
			String min = utility.Utilities.getStringParam(request, "min");
			multiConditions.put("min", min);
		}
		System.out.println(multiConditions);

		Quintet<Short, Byte,  Map<String,String>,  Map<String,String>,  Map<String,String>> infors 
		= new Quintet<>(page, (byte) 6,
				utility.Utilities.getMapParam(request, null), 
				multiConditions,
				utility.Utilities.getMapParam(request, "orderby")
				);

		Map<String,String> viewSearchProduct = 
				productControl.viewSearchProduct(infors, request.getRequestURI());

		// Trả về kết nối
		productControl.releaseCP();
		
		PCControl pcControl = new PCControl(cp);
		
		Map<String,String> viewSearchPC = pcControl.viewSearchPC(infors, request.getRequestURI());
		
		HashMap<String,String> data = new HashMap<String,String>();
		data.putAll(viewSearchProduct);
		data.putAll(viewSearchPC);
		
		request.setAttribute("product-search", data);
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/product/search.jsp");
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
