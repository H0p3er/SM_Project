package service.userService;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionPool;
import controller.BillControl;
import dto.bill.Bill_viewBillDTO;
import entity.UserObject;

@WebServlet("/user/bills")
public class UserBill extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserBill() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Servlet UserBill: Đã vào phương thức doGet.");
        UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
        view(request, response, user);
    }

    protected void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
        BillControl billControl = new BillControl(cp);
        List<Bill_viewBillDTO> billDTOs = billControl.getBillDTOByUser(user);

        request.setAttribute("billDTOs", billDTOs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home/main/user/bills.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
