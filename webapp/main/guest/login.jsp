<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
 <jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
 <jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>
      	<% 
    		Gson gson = new Gson();
    		String map = gson.fromJson((String) request.getAttribute("err"), String.class);
    		if (map!=null){
    			out.append(map);
    		}
    	%>
  <div class="contact-content mt-5">
    <div class="container mt-5">
      <div class="row">
        <div class="d-flex justify-content-center">
          <div class="col-lg-6">
          <form id="contact-form"  action="/home/guest/login" method="post">
            <h1 class="my-5">Login</h1>
            <div class="row">
              <div class="col-lg-12">
                <fieldset>
                  <label for="name">Tên đăng nhập</label>
                  <input type="text" name="txtname" id="txtname" placeholder="Username" autocomplete="on" required>
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="email">Mật khẩu</label>
                  <input type="password" name="txtpass" id="txtpass" placeholder="Password" required>
                </fieldset>
              </div>
              <div class="row align-items-center">
              <div class="col-lg-5">
                <fieldset>
                  <button type="submit" id="form-submit" class="orange-button">Đăng nhập</button>
                </fieldset>
              </div>
              <div class="col-lg-7 mt-3 mt-lg-0">
              	Chưa có tài khoản? <a href="/home/main/guest/register.jsp">Đăng ký</a>
              </div>
              </div>
            </div>
          </form>
        </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include> 