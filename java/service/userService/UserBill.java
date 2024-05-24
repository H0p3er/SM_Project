package service.userService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionPool;
import constant.BILL_EDIT_TYPE;
import controller.BillControl;
import dto.bill.Bill_DTO;
import dto.bill.Bill_viewBillDTO;
import entity.BDObject;
import entity.BillObject;
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/main/user/bills.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        if (orderId != null && !orderId.isEmpty()) {
            int orderIdInt = Integer.parseInt(orderId);
            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
            BillControl billControl = new BillControl(cp);
            BillObject billObject = new BillObject();
    		ArrayList<BDObject> bdObjects = new ArrayList<BDObject>();
            Bill_DTO bill_DTO = null;
            bill_DTO.ApplyToEntity(billObject, bdObjects);
            boolean success = billControl.editBill(bill_DTO, BILL_EDIT_TYPE.GENERAL);
            if (success) {
            	billObject.setBill_status((byte)4);
                bill_DTO.ApplyToEntity(billObject, null);
                boolean updateSuccess = billControl.editBill(bill_DTO, BILL_EDIT_TYPE.GENERAL);
                if (updateSuccess) {
                    response.sendRedirect(request.getContextPath() + "/user/bills");
                    return;
                } else {
                    response.getWriter().println("Không thể cập nhật trạng thái đơn hàng. Vui lòng thử lại sau.");
                    return;
                }
            } else {
                response.getWriter().println("Không thể hủy đơn hàng. Vui lòng thử lại sau.");
                return;
            }
        }
        // Tiếp tục xử lý các trường hợp khác nếu cần
        // Ví dụ: hiển thị danh sách đơn hàng, vv.
    }

}
