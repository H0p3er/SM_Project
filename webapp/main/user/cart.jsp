<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <jsp:include page="../component/header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/navigation-bar.jsp" flush="true"></jsp:include>
  <div class="best-deal bg-white mt-2">
    <div class="container">
      <div class="row">
        <div class="col-4">
          <div class="section-heading">
            <h6>| Giỏ hàng</h6>
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
                              <th scope="col">#</th>
                              <th scope="col">Tên sản phẩm</th>
                              <th scope="col">SL</th>
                              <th scope="col">Giá bán</th>
                              <th scope="col" colspan="2" class="text-center"></th>
                            </tr>
                          </thead>
                          <tbody id="product-list">
                          </tbody>

                        </table>
                        <div class="row">
                          <div class="best-deal bg-white">
                            <div class="info-table bg-white offset-lg-0 offset-7" style="box-shadow: 0 0 0;">
                              <ul>
                                <li class="text-black">Tổng cộng<span>0đ</span></li>
                              </ul>
                            </div>
                          </div>
                          <div class="main-button">
                            <a class="float-end" href="../payment">Mua hàng</a>
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
  </div>

  <jsp:include page="../component/footer.jsp" flush="true"></jsp:include>