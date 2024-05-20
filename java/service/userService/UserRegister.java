package service.userService;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionPool;
import controller.UserControl;
import entity.UserObject;
import repository.UserImpl;

@WebServlet("/guest/register")
public class UserRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserRegister() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("txtusername");
        String name = request.getParameter("txtname");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("txtgender");
        String tel = request.getParameter("txttel");
        String email = request.getParameter("txtemail");
        String address = request.getParameter("txtaddress");
        String password = request.getParameter("txtpassword");
        String cfpassword = request.getParameter("txtcfpassword");
        
        UserObject user = new UserObject();
        user.setUser_name(username);
        user.setUser_fullname(name);
        user.setUser_gender(Byte.parseByte(gender));
        user.setUser_phone(tel);
        user.setUser_email(email);
        user.setUser_address(address);
        user.setUser_pass(password);
        user.setUser_created_date(utility.Utilities_date.getCurrentDate());
  
        ServletContext application = getServletConfig().getServletContext();
		ConnectionPool cp = (ConnectionPool)application.getAttribute("CPool");
        UserControl uc = new UserControl(cp);
        boolean success = uc.addUser(user);
        uc.releaseConnection();
        
        if (success) {
            response.sendRedirect("/home/guest/login?success=1");
        } else {
            response.sendRedirect("/home/main/guest/register.jsp?err=failed");
        }
    }
}
