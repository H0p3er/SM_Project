<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>

<div class="sub-header">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-8">
				<ul class="info">
					<li><i class="fa fa-envelope"></i> info@sm.vn</li>
				</ul>
			</div>
			<div class="col-lg-4 col-md-4">
				<ul class="social-links">
					<li><a href="#"><i class="fab fa-facebook"></i></a></li>
					<li><a href="https://x.com/minthu" target="_blank"><i
							class="fab fa-twitter"></i></a></li>
					<li><a href="#"><i class="fab fa-linkedin"></i></a></li>
					<li><a href="#"><i class="fab fa-instagram"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<header class="header-area header-sticky">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<nav class="main-nav">
					<!-- ***** Logo Start ***** -->
					<a href="/home/homepage" class="logo"> <img height="120px"
						width="200" src="/home/assets/images/sm.png" alt="">
					</a>
				</nav>
			</div>
		</div>
	</div>
</header>
<div class="contact-content mt-3">
	<div class="container">
		<div class=" row d-flex justify-content-center">
			<div class="col-lg-6">
				<%
				String errorMessage = request.getParameter("err");
				if (errorMessage != null && errorMessage.equals("failed")) {
				%>
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					<strong>Error:</strong> Tên tài khoản đã tồn tại! Vui lòng chọn một
					tên tài khoản khác.
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
				<%
				}
				%>
				<form id="contact-form" action="/home/guest/register" method="post"
					onsubmit="return validForm()">
					<h1 class="mb-5">Đăng ký</h1>
					<div class="row">
						<div class="col-lg-12">
							<fieldset>
								<label for="username">Tên tài khoản</label> <input type="text"
									name="txtusername" id="username" placeholder="Tên tài khoản"
									required maxlength="30">
							</fieldset>
						</div>
						<div class="col-lg-12">
							<fieldset>
								<label for="name">Họ và tên</label> <input type="text"
									name="txtname" id="name" placeholder="Họ tên đầy đủ" required
									maxlength="30">
							</fieldset>
						</div>
						<div class="col-lg-3">
							<fieldset>
								<label for="gender">Giới tính</label> <select name="txtgender"
									id="gender">
									<option value="1" selected>Nam</option>
									<option value="0">Nữ</option>
								</select>
							</fieldset>
						</div>
						<div class="col-lg-4">
							<fieldset>
								<label for="phone">Điện thoại</label> <input type="text"
									name="txttel" id="phone" placeholder="Điện thoại"
									inputmode="numeric" required pattern="[0-9]{10}"
									title="Số điện thoại phải gồm 10 chữ số">
								<div id="telRegexError" style="color: red; display: none;">Sdt
									không hợp lệ</div>
							</fieldset>
						</div>
						<div class="col-lg-5">
							<fieldset>
								<label for="email">Email</label> <input type="email"
									name="txtemail" id="email" placeholder="Email" maxlength="60"
									required>
							</fieldset>
						</div>
						<div class="col-lg-12">
							<fieldset>
								<label for="address">Địa chỉ</label> <input type="text"
									name="txtaddress" id="address" placeholder="Địa chỉ" required>
							</fieldset>
						</div>
						<div class="col-lg-12">
							<fieldset>
								<label for="password">Mật khẩu</label> <input type="password"
									name="txtpassword" id="password" placeholder="Mật khẩu"
									required maxlength="20" autocomplete="no">
								<div id="regexError" style="color: red; display: none;">Mật
									khẩu phải chứa ít nhất một ký tự chữ cái viết hoa, một ký tự
									chữ cái viết thường và một số</div>
							</fieldset>
						</div>
						<div class="col-lg-12">
							<fieldset>
								<label for="cfpassword">Xác nhận mật khẩu</label> <input
									type="password" name="txtcfpassword" id="retypepassword"
									placeholder="Nhập lại mật khẩu" required maxlength="20"
									autocomplete="no">
								<div id="passwordError" style="color: red; display: none;">Mật
									khẩu không trùng khớp</div>
							</fieldset>
						</div>
						<div class="col-lg-12">
							<fieldset>
								<button type="submit" id="form-submit" class="orange-button">Đăng
									ký</button>
							</fieldset>
						</div>
						<div class="col-lg-12 mt-4">
							Đã có tài khoản? <a href="/home/main/guest/login.jsp">Đăng
								nhập</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</div>
<jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include>
<script>
	
</script>
