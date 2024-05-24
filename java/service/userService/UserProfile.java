package service.userService;

import controller.UserControl;
import entity.UserObject;
import utility.Utilities;
import utility.Utilities_date;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import connection.ConnectionPool;
import constant.USER_EDIT_TYPE;

@WebServlet("/user/user_profile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserProfile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserObject user = (UserObject) session.getAttribute("userLogined");

		if (user == null) {
			response.sendRedirect("/home/guest/login"); // Redirect to login if user is not logged in
			return;
		}

		request.getRequestDispatcher("/user_profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
		HttpSession session = request.getSession();
		UserObject user = (UserObject) session.getAttribute("userLogined");

		if (user == null) {
			response.sendRedirect("/home/guest/login"); // Redirect to login if user is not logged in
			return;
		}

		String action = request.getParameter("action");

		if ("updateProfile".equals(action)) {
			updateProfile(request, response, user);
		} else if ("changePassword".equals(action)) {
			changePassword(request, response, user);
		}
	}

	private void updateProfile(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
		String fullname = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("txttel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String note = request.getParameter("note");

		// Update user object
		user.setUser_fullname(fullname);
		user.setUser_nickname(nickname);
		if(birthday != null && !birthday.isEmpty()) {
			user.setUser_created_date(Utilities_date.getDateFormat(birthday));
		}
		user.setUser_gender("Nam".equals(gender) ? (byte) 1 : (byte) 0);
		user.setUser_phone(tel);
		user.setUser_email(email);
		user.setUser_address(address);
		user.setUser_notes(note);

		ServletContext application = getServletConfig().getServletContext();
		ConnectionPool cp = (ConnectionPool) application.getAttribute("CPool");
		UserControl uc = new UserControl(cp);
		boolean success = uc.editUser(user, USER_EDIT_TYPE.GENERAL);
		uc.releaseConnection();

		// Update user info in the database
		if (!success) {
			response.sendRedirect("/home/main/user/user_profile.jsp?err=failed");
		} else {
			response.sendRedirect("/home/main/user/user_profile.jsp?success=1");
		}
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response, UserObject user)
	        throws IOException, ServletException {
	    String currentPassword = request.getParameter("txtpass");
	    String newPassword = request.getParameter("txtpassword");

	    ServletContext application = getServletConfig().getServletContext();
	    ConnectionPool cp = (ConnectionPool) application.getAttribute("CPool");

	    try {
	        // Mã hóa mật khẩu hiện tại
	        String hashedCurrentPassword = encryptPassword(currentPassword);

	        // So sánh mật khẩu đã mã hóa với mật khẩu đã lưu
	        if (!user.getUser_pass().equals(hashedCurrentPassword)) {
	            response.sendRedirect("/home/main/user/user_profile.jsp?err=failedPass");
	            return;
	        }

	        // Nếu mật khẩu hiện tại là chính xác, cập nhật mật khẩu mới
	        user.setUser_pass(newPassword);

	        UserControl uc = new UserControl(cp);
	        boolean success = uc.editUser(user, USER_EDIT_TYPE.PASS);
	        uc.releaseConnection();

	        if (!success) {
	            response.sendRedirect("/home/main/user/user_profile.jsp?err=failed");
	        } else {
	            response.sendRedirect("/home/main/user/user_profile.jsp?success=1");
	        }
		} catch (NoSuchAlgorithmException e) {
			// Xử lý ngoại lệ nếu thuật toán MD5 không được hỗ trợ
			// Bạn có thể redirect hoặc hiển thị thông báo lỗi
	        e.printStackTrace();
	        response.sendRedirect("/home/main/user/user_profile.jsp?err=failed");
	    }
	}

	/**
	 * Mã hóa mật khẩu sử dụng thuật toán MD5.
	 * 
	 * @param password Mật khẩu cần mã hóa
	 * @return Chuỗi hex biểu diễn mật khẩu đã mã hóa
	 * @throws NoSuchAlgorithmException Nếu thuật toán MD5 không được hỗ trợ
	 */
	private String encryptPassword(String password) throws NoSuchAlgorithmException {
        try {
            // Tạo đối tượng MessageDigest với thuật toán MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Mã hóa mật khẩu thành mảng byte
            byte[] messageDigest = md.digest(password.getBytes());
            // Chuyển đổi mảng byte thành chuỗi hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                // Chuyển đổi từng byte thành dạng hex và thêm vào chuỗi
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("Error!");
        }
    }
}
