<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../component/seller_header.jsp" flush="true"></jsp:include>
<jsp:include page="../component/seller_navigation-bar.jsp" flush="true"></jsp:include>

<%@ page import="java.util.List"%>
<%@ page import="dto.bill.Bill_manageBillDTO"%>
<%@ page import="dto.bd.BD_manageBillDTO"%>
<%@ page import="entity.*, model.*"%>
<%@ page import="connection.ConnectionPool"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Đơn hàng</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="/home/main/seller/shopmanage.jsp">Shop</a></li>
				<li class="breadcrumb-item active">Đơn hàng</li>
			</ol>
		</nav>
	</div>
	<!-- End Page Title -->

	<!-- Sales -->
	<div class="col-12">
		<div class="card recent-sales overflow-auto">
			<div class="card-body">
				<h5 class="card-title">Đơn Hàng Chờ Xử Lý</h5>

				<table class="table table-borderless datatable">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Khách hàng</th>
							<th scope="col">Địa chỉ</th>
							<th scope="col">Sản phẩm</th>
							<th scope="col">Giá trị</th>
							<th scope="col">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Bill_manageBillDTO> billList = (List<Bill_manageBillDTO>) request.getAttribute("billList");
						ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
						UserModel userModel = new UserModel(cp);
						Set<Integer> processedBills = new HashSet<>();
						if (billList != null) {
							int count = 0;
							for (Bill_manageBillDTO billDTO : billList) {
								if (billDTO.getStatus() == 0) {
							if (!processedBills.contains(billDTO.getId())) {
								processedBills.add(billDTO.getId());
								UserObject userObject = userModel.getUserObject(billDTO.getCustommer().getId());
						%>
						<tr>
							<th scope="row"><a href="#"><%=billDTO.getId()%></a></th>
							<td><%=userObject.getUser_fullname()%></td>
							<td><%=userObject.getUser_address()%></td>
							<td>
								<ul class="ps-0" style="list-style-type: none;">
									<%
									List<BD_manageBillDTO> bdList = billDTO.getBd();
									for (BD_manageBillDTO bdDTO : bdList) {
									%>
									<li><%=bdDTO.getProduct_quantity()%>x<a href=""><%=bdDTO.getProduct().getName()%></a></li>
									<%
									}
									%>
								</ul>
							</td>
							<td>
								<div>
									<%
									double totalPrice = 0;
									if (bdList != null && !bdList.isEmpty()) {
										for (BD_manageBillDTO bdDTO : bdList) {
											totalPrice += bdDTO.getProduct().getPrice() * bdDTO.getProduct_quantity();
										}
									}
									Locale locale = new Locale("vi", "VN");
									NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
									String formattedPrice = currencyFormatter.format(totalPrice);
									out.println(formattedPrice);
									%>
								</div>
							</td>
							<td>
								<form id="confirmForm<%=count%>"
									action="<%=request.getContextPath()%>/seller/shop/bills"
									method="post">
									<input type="hidden" name="action" value="confirmOrder">
									<input type="hidden" name="orderId"
										value="<%=billDTO.getId()%>">
									<button type="submit" class="btn btn-success">
										<i class="ri-check-fill"></i>
									</button>
								</form>

								<form id="cancelForm<%=count%>"
									action="<%=request.getContextPath()%>/seller/shop/bills"
									method="post"
									onsubmit="return confirm('Bạn có chắc chắn muốn hủy đơn hàng này không?')">
									<input type="hidden" name="action" value="cancelOrder">
									<input type="hidden" name="orderId"
										value="<%=billDTO.getId()%>">
									<button type="submit" class="btn btn-danger">
										<i class="ri-close-fill"></i>
									</button>
								</form>
							</td>
						</tr>
						<%
						}
						count++;
						}
						}
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- End Sales -->

	<!-- Completed Sales -->
	<div class="col-12">
		<div class="card recent-sales overflow-auto">
			<div class="card-body">
				<h5 class="card-title">Danh sách đơn hàng đã xử lý</h5>
				<table class="table table-borderless datatable">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Khách hàng</th>
							<th scope="col">Sản phẩm</th>
							<th scope="col">Giá trị</th>
							<th scope="col">Trạng thái</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (billList != null) {
							for (Bill_manageBillDTO billDTO : billList) {
								if (billDTO.getStatus() != 0) {
							if (!processedBills.contains(billDTO.getId())) {
								processedBills.add(billDTO.getId());
								UserObject userObject = userModel.getUserObject(billDTO.getCustommer().getId());
						%>
						<tr>
							<th scope="row"><a href="#"><%=billDTO.getId()%></a></th>
							<td><%=userObject.getUser_fullname()%></td>
							<td>
								<ul class="ps-0" style="list-style-type: none;">
									<%
									List<BD_manageBillDTO> bdList = billDTO.getBd();
									for (BD_manageBillDTO bdDTO : bdList) {
									%>
									<li><%=bdDTO.getProduct_quantity()%>x<a href=""><%=bdDTO.getProduct().getName()%></a></li>
									<%
									}
									%>
								</ul>
							</td>
							<td>
								<div>
									<%
									double totalPrice = 0;
									if (bdList != null && !bdList.isEmpty()) {
										for (BD_manageBillDTO bdDTO : bdList) {
											totalPrice += bdDTO.getProduct().getPrice() * bdDTO.getProduct_quantity();
										}
									}
									Locale locale = new Locale("vi", "VN");
									NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
									String formattedPrice = currencyFormatter.format(totalPrice);
									out.println(formattedPrice);
									%>
								</div>
							</td>
							<td>
								<%
								byte status = billDTO.getStatus();
								switch (status) {
								case 1:
									out.println("<span class=\"badge bg-warning\">Chờ thanh toán</span>");
									break;
								case 2:
									out.println("<span class=\"badge bg-success\">Đã xác nhận</span>");
									break;
								case 3:
									out.println("<span class=\"badge bg-success\">Đã thanh toán</span>");
									break;
								case 4:
									out.println("<span class=\"badge bg-danger\">Đã hủy</span>");
									break;
								case 5:
									out.println("<span class=\"badge bg-info\">Hoàn thành</span>");
									break;
								}
								%>
							</td>
						</tr>
						<%
						}
						userModel.releaseCP();
						}
						}
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- End Completed Sales -->

</main>
<!-- End #main -->
<jsp:include page="../component/seller_footer.jsp" flush="true"></jsp:include>
