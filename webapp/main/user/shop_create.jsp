<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../component/header.jsp" flush="true"></jsp:include>
<jsp:include page="../component/navigation-bar.jsp" flush="true"></jsp:include>

 <div class="contact py-3 mt-5">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 offset-lg-3">
          <div class="section-heading text-center">
            <h1>Tạo cửa hàng cá nhân của bạn</h1>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="contact-content mt-1">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-9">
          <form id="contact-form" action="" method="post">
            <div class="row">
              <div class="col-lg-12">
                <fieldset>
                  <label for="name">Tên cửa hàng</label>
                  <input type="text" name="name" id="name" placeholder="Tên shop" required maxlength="70">
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="address">Địa chỉ cửa hàng</label>
                  <input type="text" name="address" id="address" pattern="[^ @]*@[^ @]*" placeholder="Địa chỉ cửa hàng" required>
                </fieldset>
              </div>
              <div class="col-lg-4">
                <fieldset>
                  <label for="phone">Số điện thoại cửa hàng</label>
                  <input type="text" name="phone" id="phone" placeholder="SDT" maxlength="12">
                </fieldset>
              </div>
              <div class="col-lg-8">
                <fieldset>
                  <label for="email">Email cửa hàng</label>
                  <input type="email" name="email" id="email" placeholder="Email" maxlength="50">
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="note">Thông tin chi tiết</label>
                  <textarea name="note" id="note" placeholder="Thông tin cửa hàng..." rows="3"></textarea>
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <button type="submit" id="form-submit" class="orange-button">Tạo cửa hàng</button>
                </fieldset>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>











<jsp:include page="../component/footer.jsp" flush="true"></jsp:include> 