<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
<jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>
<%@ page import="connection.*, entity.*"%>
<%
// check thông báo thành công?
String success = request.getParameter("success");
String errorMessage = request.getParameter("err");
if (success != null && success.equals("1")) {
%>
<div class="col-lg-6 offset-lg-3 mb-5 text-bg-light">
	<div class="alert alert-success alert-dismissible fade show"
		role="alert">
		<i class="fa-solid fa-check-circle"></i> Cập nhật thông tin thành công!
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
</div>
<%
} else if (errorMessage != null && errorMessage.equals("failed")) {
%>
<div class="col-lg-6 offset-lg-3 mb-5 text-bg-light">
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<i class="fa-solid fa-circle-exclamation"></i><strong> Error:</strong>
		Cập nhật thông tin thất bại!
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
</div>
<%
} else if (errorMessage != null && errorMessage.equals("failedPass")) {
%>
<div class="col-lg-6 offset-lg-3 mb-5 text-bg-light">
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<i class="fa-solid fa-circle-exclamation"></i><strong> Error:</strong>
		Mật khẩu cũ không đúng, đổi mật khẩu thất bại!
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
</div>
<%
}
%>

<div class="best-deal mt-5">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 mb-5">
				<div class="section-heading">
					<h6>| Thông tin người dùng</h6>
					<%
					// Lấy thông tin người dùng từ session
					UserObject user = (UserObject) session.getAttribute("userLogined");
					String txtgender = user.getUser_gender() == 1 ? "Nam" : user.getUser_gender() == 0 ? "Nữ" : "Không xác định";
					String txtbirthday = (user.getUser_created_date() != null) ? user.getUser_created_date() : "Chưa cập nhật";
					String txtnickname = user.getUser_nickname() != null ? user.getUser_nickname() : "Chưa cập nhật";
					String txttel = user.getUser_phone() != null ? user.getUser_phone() : "Chưa cập nhật";
					String txtnote = user.getUser_notes() != null ? user.getUser_notes() : "";
					%>
					<h2>
						<i class="fa-solid fa-circle-user"></i></i>
						<%=user.getUser_fullname()%></h2>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="tabs-content">
					<div class="row">
						<div class="nav-wrapper ">
							<ul class="nav nav-tabs" role="tablist">
								<li class="nav-item" role="presentation">
									<button class="nav-link active" id="userprofile-tab"
										data-bs-toggle="tab" data-bs-target="#userprofile"
										type="button" role="tab" aria-controls="userprofile"
										aria-selected="true">Thông tin chung</button>
								</li>
								<li class="nav-item" role="presentation">
									<button class="nav-link" id="editprofileform-tab"
										data-bs-toggle="tab" data-bs-target="#editprofileform"
										type="button" role="tab" aria-controls="editprofileform"
										aria-selected="false">Sửa thông tin</button>
								</li>
								<li class="nav-item" role="presentation">
									<button class="nav-link" id="changepasswordform-tab"
										data-bs-toggle="tab" data-bs-target="#changepasswordform"
										type="button" role="tab" aria-controls="changepasswordform"
										aria-selected="false">Đổi mật khẩu</button>
								</li>
							</ul>

						</div>
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade show active" id="userprofile"
								role="tabpanel" aria-labelledby="userprofile-tab">
								<div class="row">
									<div class="contact py-3">
										<div class="container">
											<div class="row">
												<div class="col-lg-6 offset-lg-3">
													<div class="section-heading text-center">
														<h1>Thông tin cá nhân</h1>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-8 offset-lg-2 mt-1">
										<div class="info-table">
											<ul>
												<li>Họ và tên <span><%=user.getUser_fullname()%></span></li>
												<li>Nickname <span><%=txtnickname%></span></li>
												<li>Ngày sinh <span><%=txtbirthday%></span></li>
												<li>Giới tính <span><%=txtgender%></span></li>
												<li>Điện thoại <span><%=txttel%></span></li>
												<li>Email <span><%=user.getUser_email()%></span></li>
												<li>Địa chỉ <span><%=user.getUser_address()%></span></li>
											</ul>
										</div>
									</div>
									<div class="col-12 mt-md-5">
										<h4 class="mt-1">Note</h4>
										<p>[note] Lorem ipsum dolor sit amet, consectetur
											adipiscing elit, do eiusmod tempor pack incididunt ut labore
											et dolore magna aliqua quised ipsum suspendisse.</p>

									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="editprofileform" role="tabpanel"
								aria-labelledby="editprofileform-tab">
								<div class="contact py-3">
									<div class="container">
										<div class="row">
											<div class="col-lg-6 offset-lg-3">
												<div class="section-heading text-center">
													<h1>Cập nhật thông tin</h1>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="contact-content mt-1">
									<div class="container">
										<div class="row justify-content-center">
											<div class="col-lg-9">
												<form id="contact-form"
													action="/home/user/user_profile?action=updateProfile"
													method="post">
													<div class="row">
														<div class="col-lg-12">
															<fieldset>
																<label for="name">Họ và tên</label> <input type="text"
																	name="name" id="full" placeholder="Họ và tên"
																	value="<%=user.getUser_fullname()%>" maxlength="70">
															</fieldset>
														</div>
														<div class="col-lg-12">
															<fieldset>
																<label for="nickname">Nickname</label> <input
																	type="text" name="nickname" id="address"
																	placeholder="Nickname" value="<%=txtnickname%>"
																	maxlength="35">
															</fieldset>
														</div>
														<div class="col-lg-8">
															<fieldset>
																<label for="birtday">Ngày sinh</label> <input
																	type="date" name="birthday" id="birtday"
																	placeholder="Ngày sinh" value="<%=txtbirthday%>">
															</fieldset>
														</div>
														<div class="col-lg-4">
															<fieldset>
																<label for="gender">Giới tính</label> <select
																	name="gender" id="gender">
																	<option value="Nam"
																		<%=user.getUser_gender() == 1 ? "selected" : ""%>>Nam</option>
																	<option value="Nữ"
																		<%=user.getUser_gender() == 0 ? "selected" : ""%>>Nữ</option>
																</select>
															</fieldset>
														</div>
														<div class="col-lg-5">
															<fieldset>
																<label for="phone">Điện thoại</label> <input type="text"
																	name="txttel" id="phone" placeholder="Điện thoại"
																	value="<%=txttel%>" inputmode=" numeric" required
																	pattern="[0-9]{10}"
																	title="Số điện thoại phải gồm 10 chữ số">
																<div id="telRegexError"
																	style="color: red; display: none;">Sdt không hợp
																	lệ</div>
															</fieldset>
														</div>
														<div class="col-lg-7">
															<fieldset>
																<label for="email">Email</label> <input type="email"
																	name="email" id="email" placeholder="Email"
																	value="<%=user.getUser_email()%>" maxlength="50">
															</fieldset>
														</div>
														<div class="col-lg-12">
															<fieldset>
																<label for="address">Địa chỉ</label> <input type="text"
																	name="address" id="address" placeholder="Địa chỉ"
																	value="<%=user.getUser_address()%>">
															</fieldset>
														</div>
														<div class="col-lg-12">
															<fieldset>
																<label for="note">Note</label>
																<textarea name="note" id="note" placeholder="" rows="3">
																	<%=txtnote%>
																</textarea>
															</fieldset>
														</div>
														<div class="col-lg-12">
															<fieldset>
																<button type="submit" id="form-submit"
																	class="orange-button">Cập nhập thông tin</button>
															</fieldset>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="changepasswordform"
								role="tabpanel" aria-labelledby="changepasswordform-tab">
								<div class="contact py-3">
									<div class="container">
										<div class="row">
											<div class="col-lg-6 offset-lg-3">
												<div class="section-heading text-center">
													<h1>Đổi mật khẩu</h1>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="contact-content mt-1">
									<div class="container">
										<div class="row justify-content-center">
											<div class="col-lg-9">
												<form id="contact-form"
													action="/home/user/user_profile?action=changePassword"
													method="post" onsubmit="return validForm()">
													<div class="row">
														<div class="col-lg-12">
															<fieldset>
																<label for="currentpassword">Nhập mật khẩu cũ</label> <input
																	type="password" name="txtpass" id="oldpass"
																	placeholder="Mật khẩu cũ" required maxlength="20"
																	autocomplete="no">
															</fieldset>
														</div>
														<div class="col-lg-12">
															<fieldset>
																<label for="password">Mật khẩu mới</label> <input
																	type="password" name="txtpassword" id="password"
																	placeholder="Mật khẩu mới" required maxlength="20"
																	autocomplete="no">
																<div id="regexError" style="color: red; display: none;">Mật
																	khẩu mới phải chứa ít nhất một ký tự chữ cái viết hoa,
																	một ký tự chữ cái viết thường và một số</div>
															</fieldset>
														</div>
														<div class="col-lg-12">
															<fieldset>
																<label for="cfpassword">Xác nhận mật khẩu mới</label> <input
																	type="password" name="txtcfpassword"
																	id="retypepassword" placeholder="Nhập lại mật khẩu mới"
																	required maxlength="20" autocomplete="no">
																<div id="passwordError"
																	style="color: red; display: none;">Mật khẩu không
																	trùng khớp</div>
															</fieldset>
														</div>

														<div class="col-lg-12">
															<fieldset>
																<button type="submit" id="form-submit"
																	class="orange-button">Đổi mật khẩu</button>
															</fieldset>
														</div>
													</div>
												</form>
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
</div>
<script>
</script>
<jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include>