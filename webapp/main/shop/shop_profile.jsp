<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>


  <div class="best-deal bg-white mt-5">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 mb-5">
          <div class="section-heading">
            <h6>| Gian hàng</h6>
            <h2>@shopname</h2>
            <div class="d-flex align-items-center"><span class="me-3 fs-2 text-success">●</span> <h5>Đang hoạt động</h5></div>
            <div class="d-flex align-items-center"><span class="me-3 fs-2 text-danger">●</span> <h5>Tạm dừng hoạt động</h5></div>
          </div>
        </div>
        <div class="col-lg-12">
          <div class="tabs-content">
            <div class="row">
            <%session=request.getSession(true); if (session.getAttribute("userLogined")!=null) {%>
              <div class="nav-wrapper ">
                <ul class="nav nav-tabs" role="tablist">
                  <li class="nav-item" role="presentation">
                    <a href="/home/main/seller/shopmanage.jsp" class="nav-link active">Quản lý shop</a>
                  </li>
                </ul>
              </div> <%} %>
              <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="appartment" role="tabpanel" aria-labelledby="appartment-tab">
                  <div class="row">
                    <div class="col-lg-4">
                      <img src="/home/assets/images/deal-01.jpg" alt="">
                    </div>
                    <div class="col-lg-8">
                      <div class="info-table">
                        <ul>
                          <li>Tổng sản phẩm <span>185</span></li>
                          <li>Ngày tham gia <span>25/4/2024</span></li>
                          <li>Khu vực <span>Hanoi</span></li>
                          <li>Địa chỉ <span>Yes</span></li>
                          <li>Điện thoại <span>00001111</span></li>
                          <li>Email <span>admin@gmail.com</span></li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-12 mt-md-5">
                      <h4 class="mt-1">Extra Info About Shop</h4>
                      <p> [note] Lorem ipsum dolor sit amet, consectetur adipiscing elit, do eiusmod tempor pack
                        incididunt ut
                        labore et dolore magna aliqua quised ipsum suspendisse.
                        <br><br>When you need free CSS templates, you can simply type TemplateMo in any search engine
                        website. In addition, you can type TemplateMo Portfolio, TemplateMo One Page Layouts, etc.
                      </p>
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











  <jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include>