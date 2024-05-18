<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
 <jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>
 
   <%@ page import="java.util.*" %>
	<%@ page import="dto.product.*" %>
	<%@ page import="java.io.*" %>
    <% Map<String,String> map = (Map<String,String>) request.getAttribute("product-cart"); %>
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
                          	<%=map.get("product-cart")  %>

                          </tbody>
                        </table>
                        <div class="row">
                          <div class="best-deal bg-white">
                            <div class="info-table bg-white offset-lg-0 offset-7" style="box-shadow: 0 0 0;">
                              <ul>
                                <li class="text-black">Tổng cộng<span id="total_price">0</span></li>
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