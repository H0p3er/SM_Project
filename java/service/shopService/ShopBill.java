package service.shopService;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import constant.BILL_EDIT_TYPE;
import controller.BillControl;
import dto.bill.Bill_manageBillDTO;
import entity.BillObject;
import entity.UserObject;
import model.BillModel;
import model.ShopModel;
import model.UserModel;

@WebServlet("/seller/shop/bills")
public class ShopBill extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
        if (user != null) {
            viewShopBills(request, response, user);
        } else {
            response.sendRedirect("/home/homepage");
        }
    }

    protected void viewShopBills(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
    	ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
	    BillModel billModel = new BillModel(cp);
	    ShopModel shopModel = new ShopModel(cp); 
	    billModel.setShopModel(shopModel);

        // Lấy danh sách các hóa đơn của cửa hàng đang đăng nhập
        List<Bill_manageBillDTO> billList = billModel.getBillDTOByShop(user);
        
        billModel.releaseConnection();
        shopModel.releaseCP();
        request.setAttribute("billList", billList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/seller/shop_bills.jsp");
        requestDispatcher.forward(request, response);	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("confirmOrder".equals(action)) {
            confirmOrder(request, response);
        } else if ("cancelOrder".equals(action)) {
            cancelOrder(request, response);
        }
    }

    protected void cancelOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        if (orderId != null && !orderId.isEmpty()) {
            int orderIdInt = Integer.parseInt(orderId);

            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
            BillControl billControl = new BillControl(cp);

            BillObject billObject = billControl.getBill_DTOById(orderIdInt);

            if (billObject != null) {
                Bill_manageBillDTO billDTOToEdit = new Bill_manageBillDTO();
                billDTOToEdit.setId(billObject.getBill_id());
                billDTOToEdit.setStatus((byte) 4); // Đặt trạng thái của đơn hàng thành "Đã hủy" (trạng thái 4)

                boolean success = billControl.editBill(billDTOToEdit, BILL_EDIT_TYPE.GENERAL);
                if (success) {
                    response.sendRedirect(request.getContextPath() + "/seller/shop/bills");
                } else {
                    response.getWriter().println("Không thể cập nhật trạng thái đơn hàng.");
                }
            } else {
                response.getWriter().println("Không tìm thấy đơn hàng có ID tương ứng.");
            }
        } else {
            response.getWriter().println("ID đơn hàng không hợp lệ.");
        }
    }

    protected void confirmOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        if (orderId != null && !orderId.isEmpty()) {
            int orderIdInt = Integer.parseInt(orderId);

            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
            BillControl billControl = new BillControl(cp);

            BillObject billObject = billControl.getBill_DTOById(orderIdInt);

            if (billObject != null) {
                Bill_manageBillDTO billDTOToEdit = new Bill_manageBillDTO();
                billDTOToEdit.setId(billObject.getBill_id());
                billDTOToEdit.setStatus((byte) 2); // Đặt trạng thái của đơn hàng thành "ĐÃ XÁC NHẬN" (trạng thái 2)

                boolean success = billControl.editBill(billDTOToEdit, BILL_EDIT_TYPE.GENERAL);
                if (success) {
                    response.sendRedirect(request.getContextPath() + "/seller/shop/bills");
                } else {
                    response.getWriter().println("Không thể cập nhật trạng thái đơn hàng.");
                }
            } else {
                response.getWriter().println("Không tìm thấy đơn hàng có ID tương ứng.");
            }
        } else {
            response.getWriter().println("ID đơn hàng không hợp lệ.");
        }
    }
}
