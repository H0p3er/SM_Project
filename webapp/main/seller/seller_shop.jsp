<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../component/header.jsp" flush="true"></jsp:include>

 <div class="section best-deal">
    <div class="container">
      <div class="row">
        <div class="col-lg-4">
          <div class="section-heading">
            <h6>| Gian hàng của bạn</h6>
            <h2 id="shop-name"></h2>
          </div>
        </div>
        <div class="col-lg-12">
          <div class="tabs-content">
            <div class="row">
              <div class="nav-wrapper ">
                <ul class="nav nav-tabs" role="tablist">
                  <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="appartment-tab" data-bs-toggle="tab" data-bs-target="#shop_profile" type="button" role="tab" aria-controls="appartment" aria-selected="true">Thông tin chung</button>
                  </li>
                  <li class="nav-item" role="presentation">
                    <button class="nav-link" id="villa-tab" data-bs-toggle="tab" data-bs-target="#shop_statistic" type="button" role="tab" aria-controls="villa" aria-selected="false">Thống kê</button>
                  </li>
                  <li class="nav-item" role="presentation">
                    <button class="nav-link" id="penthouse-tab" data-bs-toggle="tab" data-bs-target="#shop_product" type="button" role="tab" aria-controls="penthouse" aria-selected="false">Sản phẩm</button>
                  </li>
                </ul>
              </div>              
              <div class="tab-content" id="myTabContent">
              	<jsp:include page="seller_shop_profile.jsp" flush="true"></jsp:include>
              
				<jsp:include page="seller_shop_statistic.jsp" flush="true"></jsp:include>
                
                <jsp:include page="seller_shop_product.jsp" flush="true"></jsp:include>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

<jsp:include page="../component/footer.jsp" flush="true"></jsp:include>