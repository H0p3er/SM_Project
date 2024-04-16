package service.userService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import connection.ConnectionPool;
import controller.UserControl;
import entity.*;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/user/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Dinh nghia kieu noi dung xuat ve trinh khach
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Thuong duoc dung de cung cap mot giao dien(GUI) (Cau truc HTML)
	 * Duoc goi trong 2 truong hop:<br>
	 * - thong qua URL/ URI <br>
	 * - thong qua su kien cua Form (method = "get"), 
	 * 
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * @param request - luu tru cac yeu cau xu ly, cac du lieu duoc gui len boi client
	 * @param response - lưu trữ các đáp ứng dữ liệu được trả về cho client
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Thường được dùng để xử lý dữ liệu do doGet gửi cho<br>
	 * Được gửi trong sự kiện của form (method = "post")
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//Lay thong tin tai khoan
		
		String username = request.getParameter("txtname");
		String userpass = request.getParameter("txtpass");
		
		if (username !=null && userpass !=null) {
			username = username.trim();
			userpass = userpass.trim();
			
			if (!username.isBlank() && !userpass.isBlank()) {
				
				//Ngữ cảnh ứng dụng: là 1 không gian bộ nhớ tồn tại ở server, chứa các đối tượng để phục vụ hoạt động của web 
				//Tham chiếu Ngữ cảnh ứng dụng: định vị không gian
				ServletContext application = getServletConfig().getServletContext();
				
				//Tìm bộ quản lí kết nối trong không gian ngữ cảnh
				ConnectionPool cp = (ConnectionPool)application.getAttribute("CPool");
				
				//Tạo đối tượng thực thi chức năng
				UserControl uc = new UserControl(cp);
				
				if (cp==null) {
					//
					application.setAttribute("CPool", uc.getCP());
				}
				
				//Thực hiện đăng nhập
				UserObject user = uc.getUserObject(username, userpass);
				
				//Trả về kêt nối
				uc.releaseConnection();
				
				if (user!=null) {
					//Tham chiếu phiên làm việc (session): là một kết nối giữa máy tính client và server. Chiếm dụng bộ nhớ bên client ,Đại diện cho 1 người
					//Khởi tạo phiên làm việc mới
					HttpSession session = request.getSession(true);
					
					
					//Đưa thông tin đăng nhập vào phiên
					session.setAttribute("userLogined", user);
					
					//Trở về giao diện chính
					response.sendRedirect("/home/main/home.jsp");
					
				} else {
					response.sendRedirect("/home/main/guest/login.jsp?err=notOk");
				}
				
			} else {
				response.sendRedirect("/home/main/guest/login.jsp?err=value");
			}
		} else {			
			//sendRedirect: vi tri tra ve 
			response.sendRedirect("/home/main/guest/login.jsp?err=param");
		}
	}

}
