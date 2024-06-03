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
import dto.bd.BD_manageBillDTO;
import dto.bill.Bill_DTO;
import dto.bill.Bill_manageBillDTO;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");

	    if ("addBill".equals(action)) {
            UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
            String paymentMethod = request.getParameter("paymentMethod");
            if (paymentMethod != null && paymentMethod.equals("1")) {
                addCODBill(request, response, user);
            } else if(paymentMethod != null && paymentMethod.equals("2")) {
                addOnlineBill(request, response, user);
            } 
        } else if ("cancelOrder".equals(action)) {
            cancelOrder(request, response);
        }
	}

	protected void cancelOrder(HttpServletRequest request, HttpServletResponse response)
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
	            billDTOToEdit.setStatus((byte) 4);

	            boolean success = billControl.editBill(billDTOToEdit, BILL_EDIT_TYPE.GENERAL);
	            if (success) {
	                response.sendRedirect(request.getContextPath() + "/user/bills");
	            } else {
	                response.getWriter().println("CANT UPDATE");
	            }
	        } else {
	            response.getWriter().println("NOT AVAILABLE BILL ID");
	        }
	    }
	}

	protected void addCODBill(HttpServletRequest request, HttpServletResponse response, UserObject user)
            throws ServletException, IOException {
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
        BillControl billControl = new BillControl(cp);

        Bill_manageBillDTO billDTOToAdd = new Bill_manageBillDTO();
        billDTOToAdd.setCreator_id(user.getUser_id());
        billDTOToAdd.setStatus((byte) 0);

        boolean addSuccess = billControl.addBill(billDTOToAdd);

        if (addSuccess) {
            response.getWriter().println("Đơn hàng của bạn đã được ghi nhận! Vui lòng chờ xác nhận trên giao diện và \"ĐÃ ADD BILL MỚI\" trên console.");
        
            response.sendRedirect(request.getContextPath() + "/user/bills");
        } else {
            response.getWriter().println("Failed to add COD Bill!");
        }
    }

	protected void addOnlineBill(HttpServletRequest request, HttpServletResponse response, UserObject user)
            throws ServletException, IOException {
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
        BillControl billControl = new BillControl(cp);

        String transactionStatus = request.getParameter("vnp_TransactionStatus");
        String createdDate = request.getParameter("vnp_PayDate");
        int creatorId = user.getUser_id();

        byte billStatus = 0;
        if ("00".equals(transactionStatus)) {
            billStatus = 3;
        } else {
            billStatus = 2;
        }

        Bill_manageBillDTO billDTOToAdd = new Bill_manageBillDTO();
        billDTOToAdd.setCreated_date(createdDate);
        billDTOToAdd.setCreator_id(creatorId);
        billDTOToAdd.setStatus(billStatus);

        boolean addSuccess = billControl.addBill(billDTOToAdd);

        if (addSuccess) {
            if (billStatus == 3) {
                response.getWriter().println("Bill added successfully! Bill_status = 3");
            } else {
                response.getWriter().println("Bill added successfully! Bill_status = 1");
            }
        } else {
            response.getWriter().println("Failed to add Online Bill!");
        }
    }
}
