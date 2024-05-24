package library;

import java.util.*;

import dto.bd.BD_viewBillDTO;
import dto.bill.Bill_viewBillDTO;

public class BillLibrary {
    public static Map<String, String> viewBill_Details(Bill_viewBillDTO billDTO) {
        Map<String, String> view = new HashMap<String, String>();
        viewBillDetails(billDTO, view);
        return view;
    }

    private static void viewBillDetails(Bill_viewBillDTO billDTO, Map<String, String> view) {
        StringBuilder tmp = new StringBuilder();
        
        // Hiển thị tiêu đề hóa đơn
        tmp.append("<h2>Hóa đơn #" + billDTO.getId() + "</h2>");
        view.put("bill-title", tmp.toString());
        tmp.setLength(0);

        // Hiển thị ngày tạo hóa đơn
        tmp.append("<div>Ngày tạo: " + billDTO.getCreated_date() + "</div>");
        view.put("bill-created-date", tmp.toString());
        tmp.setLength(0);

        // Hiển thị trạng thái hóa đơn
        byte status = billDTO.getStatus();
        switch (status) {
            case 0:
                tmp.append("<span class=\"badge bg-warning\">Chờ xác nhận</span>");
                break;
            case 1:
                tmp.append("<span class=\"badge bg-warning\">Chờ thanh toán</span>");
                break;
            case 2:
                tmp.append("<span class=\"badge bg-success\">Đã xác nhận</span>");
                break;
            case 3:
                tmp.append("<span class=\"badge bg-success\">Đã thanh toán</span>");
                break;
            case 4:
                tmp.append("<span class=\"badge bg-danger\">Đã hủy</span>");
                break;
            case 5:
                tmp.append("<span class=\"badge bg-info\">Hoàn thành</span>");
                break;
            default:
                tmp.append("<span class=\"badge bg-secondary\">Trạng thái không xác định</span>");
                break;
        }
        view.put("bill-status", tmp.toString());
        tmp.setLength(0);

        // Hiển thị danh sách sản phẩm trong hóa đơn
        List<BD_viewBillDTO> bdList = billDTO.getBd();
        if (bdList != null && !bdList.isEmpty()) {
            int index = 1;
            for (BD_viewBillDTO bdDTO : bdList) {
                tmp.append("<tr>");
                tmp.append("<td>" + (index++) + "</td>");
                tmp.append("<td>" + bdDTO.getProduct().getName() + "</td>");
                tmp.append("<td>" + bdDTO.getProduct().getPrice() + "</td>");
                tmp.append("<td>");
                switch (status) {
                    case 0:
                        tmp.append("Chờ xác nhận");
                        break;
                    case 1:
                        tmp.append("Chờ thanh toán");
                        break;
                    case 2:
                        tmp.append("Đã xác nhận");
                        break;
                    case 3:
                        tmp.append("Đã thanh toán");
                        break;
                    case 4:
                        tmp.append("Đã hủy");
                        break;
                    case 5:
                        tmp.append("Hoàn thành");
                        break;
                    default:
                        tmp.append("Trạng thái không xác định");
                        break;
                }
                tmp.append("</td>");
                tmp.append("<td>");
                if (status >= 0 && status <= 3) {
                    tmp.append("<button class=\"btn btn-danger\" onclick=\"cancelOrder('" + billDTO.getId() + "')\">Hủy đơn</button>");
                }
                tmp.append("</td>");
                tmp.append("</tr>");
            }
        } else {
            tmp.append("<tr><td colspan=\"5\">Không có sản phẩm trong hóa đơn.</td></tr>");
        }
        view.put("product-list", tmp.toString());
    }

    public static Map<String, String> viewBill_Summary(List<Bill_viewBillDTO> billDTOs) {
        Map<String, String> view = new HashMap<>();
        StringBuilder tmp = new StringBuilder();

        if (billDTOs != null && !billDTOs.isEmpty()) {
            for (Bill_viewBillDTO billDTO : billDTOs) {
                tmp.append("<tr>");
                tmp.append("<td>" + billDTO.getId() + "</td>");
                tmp.append("<td>" + billDTO.getCreated_date() + "</td>");
                tmp.append("<td>");
                switch (billDTO.getStatus()) {
                    case 0:
                        tmp.append("Chờ xác nhận");
                        break;
                    case 1:
                        tmp.append("Chờ thanh toán");
                        break;
                    case 2:
                        tmp.append("Đã xác nhận");
                        break;
                    case 3:
                        tmp.append("Đã thanh toán");
                        break;
                    case 4:
                        tmp.append("Đã hủy");
                        break;
                    case 5:
                        tmp.append("Hoàn thành");
                        break;
                    default:
                        tmp.append("Trạng thái không xác định");
                        break;
                }
                tmp.append("</td>");
                tmp.append("<td>");
                if (billDTO.getStatus() >= 0 && billDTO.getStatus() <= 3) {
                    tmp.append("<button class=\"btn btn-danger\" onclick=\"cancelOrder('" + billDTO.getId() + "')\">Hủy đơn</button>");
                }
                tmp.append("</td>");
                tmp.append("</tr>");
            }
        } else {
            tmp.append("<tr><td colspan=\"4\">Không có hóa đơn.</td></tr>");
        }

        view.put("bill-summary", tmp.toString());
        return view;
    }
}
