package service.ShopService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EmployeeObject;

/**
 * Servlet implementation class error
 */
@WebServlet("/wpSearch")
public class WorkplaceSearching extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkplaceSearching() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Tìm thông tin đăng nhập
		EmployeeObject user = (EmployeeObject) request.getSession().getAttribute("userLogined");
		
		if (user!=null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/home/login");
		}
	}
	
	protected void view(HttpServletRequest request, HttpServletResponse response, EmployeeObject currentUser) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		
		PrintWriter out = response.getWriter();
		out.append("<form class=\"mr-3 position-relative\" id=\"workplaceSearchForm\" method=\"post\" action=\"/home/workplace/list\" >");	
		out.append("<div class=\"form-group mb-0\">");
		out.append("<input type=\"search\" class=\"form-control\" id=\"workplaceSearch\" name=\"workplaceSearch\" placeholder=\"Search\" aria-controls=\"user-list-table\">");
		out.append("</div>");
		out.append("</form>");
		out.append("<script>");
		out.append("");
		out.append("document.getElementById('workplaceSearch').addEventListener('keypress', function (e) {");
		out.append("if (e.key === 'Enter') {");
		out.append("e.preventDefault();       ");
		out.append("document.getElementById('workplaceSearchForm').submit();");
		out.append("}");
		out.append("});");
		out.append("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
