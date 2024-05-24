<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
<jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="library.BillLibrary" %>
<%@ page import="dto.bill.Bill_viewBillDTO" %>

<div class="best-deal bg-white mt-2">
    <div class="container">
        <div class="row">
            <div class="col-4">
                <div class="section-heading">
                    <h6>| Đơn Hàng</h6>
                </div>
            </div>
            <div class="col-lg-12 mt-3">
                <div class="tabs-content">
                    <div class="row">
                        <div class="tab-content" id="myTabContent">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">Danh sách sản phẩm</h5>
                                            <table class="table table-sm .datatable">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">STT</th>
                                                        <th scope="col">Sản phẩm</th>
                                                        <th scope="col">Giá trị</th>
                                                        <th scope="col">Tình trạng</th>
                                                        <th scope="col"></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="product-list">
                                                    <% 
                                                        List<Bill_viewBillDTO> billDTOs = (List<Bill_viewBillDTO>) request.getAttribute("billDTOs");
                                                        if (billDTOs != null && !billDTOs.isEmpty()) {
                                                            for (Bill_viewBillDTO billDTO : billDTOs) {
                                                                Map<String, String> billDetails = BillLibrary.viewBill_Details(billDTO);
                                                                out.print(billDetails.get("product-list"));
                                                            }
                                                        } else {
                                                    %>
                                                    <tr>
                                                        <td colspan="5">Không có đơn hàng.</td>
                                                    </tr>
                                                    <% } %>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function cancelOrder(orderId) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "<%=request.getContextPath()%>/user/cancelOrder?orderId=" + orderId, true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                location.reload(); // Refresh trang sau khi hủy đơn thành công
            }
        };
        xhr.send();
    }
</script>

<jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include>
