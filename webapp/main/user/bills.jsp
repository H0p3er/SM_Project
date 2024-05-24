<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
<jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>
<%@ page import="java.util.List"%>
<%@ page import="dto.bill.Bill_viewBillDTO"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.bd.BD_viewBillDTO"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
														<th scope="col">Tổng tiền</th>
														<th scope="col">Tình trạng</th>
														<th scope="col"></th>
													</tr>
												</thead>
												<tbody id="product-list">
													<%
													List<Bill_viewBillDTO> billDTOs = (List<Bill_viewBillDTO>) request.getAttribute("billDTOs");
													if (billDTOs != null && !billDTOs.isEmpty()) {
														int index = 1;
														for (Bill_viewBillDTO billDTO : billDTOs) {
													%>
													<tr>
														<td><%=index++%></td>
														<td>
															<ul class="ps-0" style="list-style-type: none;">
																<%
																List<BD_viewBillDTO> bdList = billDTO.getBd();
																if (bdList != null && !bdList.isEmpty()) {
																	for (BD_viewBillDTO bdDTO : bdList) {
																%>
																<li><span id="order-product-id"><%=bdDTO.getProduct_quantity()%>x</span><a
																	href=""><%=bdDTO.getProduct().getName()%></a></li>
																<%
																}
																}
																%>
															</ul>
														</td>
														<td>
															<%
															double totalValue = 0;
															if (bdList != null && !bdList.isEmpty()) {
																for (BD_viewBillDTO bdDTO : bdList) {
																	totalValue += bdDTO.getProduct().getPrice() * bdDTO.getProduct_quantity();
																}
															}
															Locale locale = new Locale("vi", "VN");
															NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
															String formattedPrice = currencyFormatter.format(totalValue);
															out.println(formattedPrice);
															%>
														</td>
														<td>
															<%
															byte status = billDTO.getStatus();
															switch (status) {
																case 0 :
															%> <span class="badge bg-warning">Chờ xác nhận</span> <%
 break;
 case 1 :
 %> <span class="badge bg-warning">Chờ thanh toán</span> <%
 break;
 case 2 :
 %> <span class="badge bg-success">Đã xác nhận</span> <%
 break;
 case 3 :
 %> <span class="badge bg-success">Đã thanh toán</span> <%
 break;
 case 4 :
 %> <span class="badge bg-danger">Đã hủy</span> <%
 break;
 case 5 :
 %> <span class="badge bg-info">Hoàn thành</span> <%
 break;
 }
 %>
														</td>
														<td>
															<%
															if (status >= 0 && status <= 3) {
															%>
															<button class="btn btn-danger"
																onclick="cancelBill('<%=billDTO.getId()%>')">Hủy
																đơn</button> <%
 }
 %>
														</td>
													</tr>
													<%
													}
													} else {
													%>
													<tr>
														<td colspan="5">Không có hóa đơn.</td>
													</tr>
													<%
													}
													%>
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
  
	</script>


<jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include>