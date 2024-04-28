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
           <li><a href="https://x.com/minthu" target="_blank"><i class="fab fa-twitter"></i></a></li>
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
                   <a href="/home/main/home.jsp" class="logo">
                       <img height="120px" width="200" src="/home/assets/images/sm.png" alt="">
                   </a>

               </nav>
           </div>
       </div>
   </div>
 </header>
  <div class="contact-content mt-2">
    <div class="container">
      <div class="row">
        <div class="d-flex justify-content-center">
          <div class="col-lg-6">
          <form id="contact-form"  action="" method="post">
            <h1 class="my-5">Đăng ký</h1>
            <div class="row">
            <div class="col-lg-12">
                <fieldset>
                  <label for="username">Tên tài khoản</label>
                  <input type="text" name="username" id="username" placeholder="Username" required maxlength="30">
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="name">Họ và tên</label>
                  <input type="text" name="name" id="name" placeholder="Name" required maxlength="30">
                </fieldset>
              </div>
              <div class="col-lg-8">
              	<fieldset>
                	<label for="birtday">Ngày sinh</label>
                    <input type="date" class="datefield" name="birthday" id="birtday" placeholder="Ngày sinh" >
                </fieldset>
               </div>
              <div class="col-lg-4">
              	<fieldset>
                	<label for="gender">Giới tính</label>
                    <select name="gender" id="gender">
                    	<option value="Nam" selected>Nam</option>
                        <option value="Nữ">Nữ</option>
                    </select>              
                </fieldset>
              </div>
              <div class="col-lg-5">
              	<fieldset>
              		<label for="phone">Điện thoại</label>
              		<input type="text" name="tel" id="phone" placeholder="Điện thoại" inputmode="numeric" minlength="10" maxlength="12" required>
              	</fieldset>
              </div>
              <div class="col-lg-7">
              	<fieldset>
              		<label for="email">Email</label>
              		<input type="email" name="email" id="email" placeholder="Email" maxlength="60" required>
              	</fieldset>
              </div>
              <div class="col-lg-12">
                   <fieldset>
                       <label for="address">Địa chỉ</label>
                       <input type="text" name="address" id="address" placeholder="Địa chỉ"  required>
                   </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="password">Mật khẩu</label>
                  <input type="password" name="password" id="password" placeholder="Password"
                    required maxlength="20" autocomplete="no">
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="cfpassword">Xác nhận mật khẩu</label>
                  <input type="password" name="cfpassword" id="retypepassword" placeholder="Re-type Password"
                    required maxlength="20" autocomplete="no">
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <button type="submit" id="form-submit" class="orange-button">Đăng ký</button>
                </fieldset>
              </div>
              <div class="col-lg-12 mt-4">
              	Đã có tài khoản? <a href="/home/main/guest/login.jsp">Đăng nhập</a>
              </div>
            </div>
          </form>
        </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include> 