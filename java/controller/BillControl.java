package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import constant.BILL_EDIT_TYPE;
import constant.BILL_SORT_TYPE;
import dto.bd.BD_DTO;
import dto.bd.BD_manageBillDTO;
import dto.bill.Bill_DTO;
import dto.bill.Bill_manageBillDTO;
import dto.bill.Bill_viewBillDTO;
import dto.shop.Shop_manageShopDTO;
import entity.BDObject;
import entity.BillObject;
import entity.ShopObject;
import entity.UserObject;
import library.ShopLibrary;
import model.BillModel;
import model.ShopModel;

public class BillControl {
    private BillModel billModel;
    private ShopModel shopModel;

    public BillControl(ConnectionPool cp) {
        this.billModel = new BillModel(cp);
        this.shopModel = new ShopModel(cp);

    }

    public ConnectionPool getCP() {
        return this.billModel.getCP();
    }

    public void releaseConnection() {
        this.billModel.releaseConnection();
    }

    public boolean addBill(Bill_DTO bill_DTO) {
        return this.billModel.addBill(bill_DTO);
    }

    public boolean editBill(Bill_DTO item, BILL_EDIT_TYPE et) {
        return this.billModel.editBill(item, et);
    }

    public boolean delBill(Bill_DTO item) {
        return this.billModel.delBill(item);
    }

    public BillObject getBill_DTOById(int billId) {
        return this.billModel.getBill_DTOById(billId);
    }

    public List<Bill_viewBillDTO> getBillDTOByUser(UserObject currentUser) {
        return billModel.getBillDTOByUser(currentUser);
    }

    public List<Bill_manageBillDTO> getBillDTOByShop(ShopObject shopObject) {
        return this.billModel.getBillDTOByShop(shopObject);
    }

    public List<Bill_manageBillDTO> getBillDTOByShop(UserObject currentUser) {
        return this.billModel.getBillDTOByShop(currentUser);
    }

    public void setShopModel(ShopModel shopModel) {
        this.shopModel = shopModel;
    }

    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPoolImpl();
        BillControl billControl = new BillControl(cp);

        // Tạo một đối tượng UserObject để làm người tạo hóa đơn
        UserObject currentUser = new UserObject();
        currentUser.setUser_id(1); // Giả sử người tạo có id là 1

        // Tạo một đối tượng Bill_manageBillDTO mới và gán các trường dữ liệu
        Bill_manageBillDTO billDTO = new Bill_manageBillDTO();
        billDTO.setCreator_id(1); // Giả sử id người tạo là 1
        billDTO.setDelivery_id(2); // Giả sử id người giao là 2
        billDTO.setStatus((byte) 1); // Giả sử trạng thái là 1

        // Tạo danh sách các mặt hàng trong hóa đơn và gán vào đối tượng Bill_manageBillDTO
        List<BD_manageBillDTO> bdList = new ArrayList<>();

        // Tạo một mặt hàng đầu tiên và gán thông tin sản phẩm và số lượng
        BD_manageBillDTO bdDTO1 = new BD_manageBillDTO();
        bdDTO1.setId(1); // Giả sử sản phẩm có id là 1
        bdDTO1.setProduct_quantity(2); // Số lượng sản phẩm
        bdList.add(bdDTO1);

        // Tạo một mặt hàng thứ hai và gán thông tin sản phẩm và số lượng
        BD_manageBillDTO bdDTO2 = new BD_manageBillDTO();
        bdDTO2.setId(2); // Giả sử sản phẩm có id là 2
        bdDTO2.setProduct_quantity(1); // Số lượng sản phẩm
        bdList.add(bdDTO2);

        // Gán danh sách mặt hàng vào đối tượng Bill_manageBillDTO
        billDTO.setBd(bdList);

        // Gọi phương thức addBill để thêm hóa đơn vào cơ sở dữ liệu
        boolean added = billControl.addBill(billDTO);

        // Kiểm tra kết quả và in ra thông báo tương ứng
        if (added) {
            System.out.println("Bill added successfully!");
        } else {
            System.out.println("Failed to add bill.");
        }

        // Giải phóng kết nối sau khi sử dụng xong
        billControl.releaseConnection();
    }
}
