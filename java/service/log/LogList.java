package service.log;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Sextet;


import connection.ConnectionPool;
import constant.LOG_SORT_TYPE;
import controller.LogControl;
import entity.EmployeeObject;
import entity.LogObject;
import entity.WpsdObject;
import objects.*;
import utility.Utilities;
import log.*;

/**
 * Servlet implementation class LogList
 */
@WebServlet("/logList")
public class LogList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Dinh nghia kieu noi dung xuat ve trinh khach
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogList() {
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
		String url =  request.getRequestURI();
		
		short wpPage = (short) Utilities.getShortParam(request, "page");

		if (wpPage<0){
			wpPage = 1;
		}
		
		byte wpPerPage = (byte) Utilities.getByteParam(request, "wpperpage");
		if (wpPerPage<=0){
			wpPerPage = 5;
		}						

		String key = request.getParameter("key");
		String saveKey = (key!=null && !key.isBlank()) ? key.trim(): "";
		if (!saveKey.isBlank()) {
			url = url+"?key="+saveKey;
		}
		
		
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		
		LogControl wpc = new LogControl(cp);
		
		if (cp==null) {
			getServletContext().setAttribute("CPool", wpc.getCP());			
		}
		
		Sextet<EmployeeObject, 
		LogObject, 
		Short, 
		Byte ,
		LOG_SORT_TYPE, Boolean> infors = new Sextet<>(currentUser, null ,(short) wpPage, (byte) wpPerPage, LOG_SORT_TYPE.CREATED, false);
		

		ArrayList<String> view = wpc.viewLogs(infors, url);
		
		wpc.releaseConnection();//Tra ve ket noi
		
		// Xac dinh kieu noi dung xuat ve trinh khach
		response.setContentType(CONTENT_TYPE);
		
		StringBuilder out = new StringBuilder();
		
		
		out.append(view.get(0));
		out.append(view.get(1));

		//Tạo đối tượng thực hiện xuất nội dung
		
        request.setAttribute("currentPageData", out.toString());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/log/log-list.jsp");
        
        if (dispatcher!=null) {
        	dispatcher.forward(request, response);
        } else {
        	response.sendRedirect("/err?err=404NotFound");
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeObject currentUser = (EmployeeObject) request.getSession().getAttribute("userLogined");

		request.setCharacterEncoding("utf-8");//Thiết lập tập kí tự
		
		String logName = request.getParameter("logName");
		byte logType = utility.Utilities.getByteParam(request, "logType");
		int logManager = utility.Utilities.getIntParam(request, "logManager");
		String logAddress = request.getParameter("logAddress");
		String logPhoneNumber = request.getParameter("logPhoneNumber");
		String logEmail = request.getParameter("logEmail");
		String logNotes = request.getParameter("logNotes");
		if (logName!=null && !logName.isBlank()
			&& 	logManager>0 && logType>=0
			
			){
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
				
				LogControl wpc = new LogControl(cp);
				
				if (cp==null) {
					request.setAttribute("CPool", wpc.getCP());
				}
				
				LogObject similar = new LogObject();
				

				
				ArrayList<LogObject> similarList = new ArrayList<LogObject>();
				similarList.add(similar);
				ArrayList<WpsdObject> storage = new ArrayList<WpsdObject>();
				
			
				
				wpc.releaseConnection();
				
			
			} else {
				
				String logSearch = request.getParameter("logSearch");	
				
				response.sendRedirect("/home/LogList?key="+logSearch+"");	
			}
		
		
	}

}
