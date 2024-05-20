<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>
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
                              <th scope="col">#</th>
                              <th scope="col">Sản phẩm</th>
                              <th scope="col">Giá trị</th>
                              <th scope="col">Tình trạng</th>
                              <th scope="col"></th>
                            </tr>
                          </thead>
                          <tbody id="product-list">
                            <tr>
                              <th scope="row">1</th>
                              <td >
                                <ul class="ps-0" style="list-style-type: none;">
                                  <li><span id="order-product-id">3x</span><a href="">Logitech Wireless Headphones</a></li>
                                  <li><a href="">Mechanical_2 USB Tenkeyless Keyboard RGB</a></li>
                                  <li><a href="">Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz</a></li>
                                  <li><a href="">MSI B460 ATX Motherboard</a></li>
                                </ul>
                              </td>
                              <td>2000000VND</td>
                              <td>
                                <span class="badge bg-success">Đã xác nhận</span>  <!-- Chờ xác nhận, đã xác nhận, đã thanh toán, Đã giao hàng-->
                              </td>
                              <td>
                                <div>
                                  <button class="btn btn-danger">Hủy đơn</button>
                                </div>
                                <!-- <button class="btn btn-dark">Nhận hàng</button> -->
                              </td>
                            </tr>
                            <tr>
                              <th scope="row">1</th>
                              <td >
                                <ul class="ps-0" style="list-style-type: none;">
                                  <li><span id="order-product-id">3x</span><a href="">Logitech Wireless Headphones</a></li>
                                  <li><a href="">Mechanical_2 USB Tenkeyless Keyboard RGB</a></li>
                                  <li><a href="">Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz</a></li>
                                  <li><a href="">MSI B460 ATX Motherboard</a></li>
                                </ul>
                              </td>
                              <td>2000000VND</td>
                              <td>
                                <span class="badge bg-success">Đã xác nhận</span>  <!-- Chờ xác nhận, đã xác nhận, đã thanh toán, Đã giao hàng-->
                              </td>
                              <td>
                                  <button class="btn btn-danger">Hủy đơn</button>
                                <!-- <button class="btn btn-dark">Nhận hàng</button> -->
                              </td>
                            </tr>
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

  <jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include>