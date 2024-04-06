package service.workplaceService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionPool;
import constant.SHOP_EDIT_TYPE;
import controller.LogControl;
import controller.WorkplaceControl;
import entity.EmployeeObject;
import entity.LogObject;
import entity.UserObject;
import entity.ShopObject;
import library.*;
import utility.Utilities;
import utility.Utilities_date;

/**
 * Servlet implementation class DelWorkplace
 */
@WebServlet("/wpDel")
public class ShopDeleting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopDeleting() {
        super();
        // TODO Auto-generated constrwptor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeObject currentUser = (EmployeeObject) request.getSession().getAttribute("userLogined");
		int wpid = Utilities.getIntParam(request, "wpid");
		int wpmid = Utilities.getIntParam(request, "wpmid");
		
		if (currentUser!=null && wpid>0) {
			if (currentUser.getUser_id()!= wpid) {
				if (currentUser.getUser_permission()>=4 || currentUser.getUser_id()==wpmid) {
					
					ConnectionPool cp = (ConnectionPool)getServletContext().getAttribute("CPool");
					
					WorkplaceControl wc = new WorkplaceControl(cp);
					ShopObject wpDel = new ShopObject();
					wpDel.setWorkplace_id(wpid);
					wpDel.setWorkplace_manager_id(wpmid);
					wpDel.setWorkplace_last_modified_date(Utilities_date.getCurrentDate());
					
					//Tìm tham số xác định xóa
					String trash = request.getParameter("t");
					String url = "/home/workplace/list";
					boolean result;
					
					ArrayList<ShopObject> wpDelList = new ArrayList<ShopObject>();
					wpDelList.add(wpDel);
					if (trash==null) {
						result = wc.delWorkplace(wpDelList, currentUser);
						url += "?trash"; 
					} else {
						result = wc.editWorkplace(wpDelList, null ,SHOP_EDIT_TYPE.TRASH ,currentUser);				
					}
					
					wc.releaseConnection();
					
					if (result) {
						response.sendRedirect(url);
						LogControl lc = new LogControl(cp);
						
						if (cp==null) {
							request.setAttribute("CPool", lc.getCP());
						}
						
						wpDelList.forEach(item->{					
							LogObject log = new LogObject();
							log.setLog_user_id(currentUser.getEmployee_id());
							log.setLog_username(currentUser.getUser_name());
							log.setLog_user_permission(currentUser.getUser_permission());
							log.setLog_action((byte)3);
							log.setLog_position((byte) 8);
							log.setLog_notes(Utilities.encode(""));
							log.setLog_created_date(Utilities_date.getCurrentDateTime());
							lc.addLog(log);
						});
						
						lc.releaseConnection();
					} else {
						response.sendRedirect(url+"&err=notOk");
					}
					
				} else {
					response.sendRedirect("/home/workplace/list?err=noPermis");
				}
				
			} else {
				response.sendRedirect("/home/workplace/list?err=delUc");
			}		
			
		} else {
			response.sendRedirect("/home/workplace/list?err=delete");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
