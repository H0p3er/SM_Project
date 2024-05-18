<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>
  <div class="best-deal bg-white mt-2">
    <div class="container">
      <div class="row">
        <div class="col-4">
          <div class="section-heading">
            <h6>| Giỏ Hàng</h6>
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
                              <th scope="col">Hình ảnh</th>
                              <th scope="col">Sản phẩm</th>
                              <th scope="col">Số lượng</th>
                              <th scope="col">Giá bán</th>
                              <th scope="col"></th>
                            </tr>

                          </thead>
                          <tbody id="product-list">
                            <tr>
                              <th scope="row">1</th>
                              <td><img height="70px" class="p-0" src="/home/assets/images/product/cpu/cpu.png" alt="">
                              </td>
                              <td><a href="">Logitech Wireless Headphones</a></td>
                              <td>
                                <div class="input-group col-2">
                                  <span class="input-group-btn">
                                    <button type="button" class="btn btn-default btn-number" disabled="disabled"
                                      data-type="minus" data-field="quant[1]">
                                      <i class="fa-solid fa-minus"></i>
                                    </button>
                                  </span>
                                  <input type="text" name="quant[1]" class="form-control input-number" value="1" min="1"
                                    max="99"> <!-- max value is set by query product available quantity -->
                                  <span class="input-group-btn">
                                    <button type="button" class="btn btn-default btn-number" data-type="plus"
                                      data-field="quant[1]">
                                      <i class="fa-solid fa-plus"></i>
                                    </button>
                                  </span>
                                </div>
                              </td>
                              <td><span class="product-price" data-field="quant[1]"  value="32">$32</span></td>
                              <td><i class="fa-solid fa-trash"></i></td>
                            </tr>
                            <tr>
                              <th scope="row">2</th>
                              <td><img height="70px" class="p-0" src="/home/assets/images/product/cpu/cpu.png" alt="">
                              </td>
                              <td><a href="">Logitech Wireless Headphones</a></td>
                              <td>
                                <div class="input-group col-2">
                                  <span class="input-group-btn">
                                    <button type="button" class="btn btn-default btn-number" disabled="disabled"
                                      data-type="minus" data-field="quant[2]">
                                      <i class="fa-solid fa-minus"></i>
                                    </button>
                                  </span>
                                  <input type="text" name="quant[2]" class="form-control input-number" value="1" min="1"
                                    max="99">
                                  <span class="input-group-btn">
                                    <button type="button" class="btn btn-default btn-number" data-type="plus"
                                      data-field="quant[2]">
                                      <i class="fa-solid fa-plus"></i>
                                    </button>
                                  </span>
                                </div>
                              </td>
                              <td><span class="product-price" data-field="quant[2]"  value="67">$67</span></td>
                              <td><i class="fa-solid fa-trash"></i></td>
                            </tr>
                          </tbody>
                        </table>
                        <div class="row">
                          <div class="best-deal bg-white">
                            <div class="info-table bg-white offset-lg-0 offset-7" style="box-shadow: 0 0 0;">
                              <ul>
                                <li class="text-black">Tổng cộng<span id="total-price">12</span></li>
                                <!-- <input id="total-price" type="text" value="100" disabled> -->
                              </ul>
                            </div>
                          </div>
                          <div class="main-button"><a class="float-end" href="../payment">Mua hàng</a></div>

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

  <jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include>