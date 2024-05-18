<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>
  <%@ page import="java.util.*" %>

    <% Map<String, String> map = (HashMap<String,String>) request.getAttribute("product-profile"); %>
        <div class="section best-deal pt-0 mt-2">
          <div class="container">
            <div class="row">
              <nav aria-label="breadcrumb" class="ms-lg-5">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Home</a></li>
                  <li class="breadcrumb-item"><a href="#">Library</a></li>
                  <li class="breadcrumb-item active" aria-current="page">Data</li>
                </ol>
              </nav>
              <div class="col-lg-12">
                <div class="tabs-content">
                  <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="appartment" role="tabpanel"
                      aria-labelledby="appartment-tab">
                      <div class="row">
                        <div class="col-md-4">

                          <!-- product-image -->
                          <%=map.getOrDefault("product-image", "") %>
                            <div class="properties">
                              <div class="item p-3 mb-0 ">
                                <ul class="border-bottom-0 mb-0 pb-0">
                                  <!-- product-attribute -->
                                  <%=map.getOrDefault("product-attribute", "Không tồn tại") %>
                                </ul>

                              </div>
                            </div>
                        </div>
                        <div class="col-md-8">
                          <div class="contact-page">
                            <div class="item email p-4">
                              <!-- product-name -->
                              <%=map.getOrDefault("product-name", "Không tồn tại tên") %>
                                <div>$0 Bình luận |$0 Đã bán </div>

                                <!-- product-price -->
                                <%=map.getOrDefault("product-price", "") %>

                                  <div class="row justify-content-between">
                                    <!-- product-area -->
                                    <div class="mb-3 col-7">Khu vực: Thanh Xuân, Hà Nội</div>
                                    <!-- product-left -->
                                    <%=map.get("product-left") %>
                                  </div>

                                  <h6 class="row align-items-center" style="line-height: 1.5;">
                                    <i class="fa fa-user fs-3 col-1 pe-0"></i>

                                    <!-- seller-name -->
                                    <%=map.getOrDefault("seller-name", "Người bán hàng không tồn tại hoặc đã bị xóa") %>

									<!-- product-shop -->
                                   <%=map.getOrDefault("product-shop", "") %>

                                      <br></br>

                                      <!-- product-notes -->
                                      <%=map.get("product-notes") %>
                                  </h6>
                                  <div class="icon-button">
                                  	<!-- product-notes -->
                                    <button class="add-cart" type="button" id="6" href=""><i class="fa fa-calendar"></i>Thêm vào giỏ hàng</button>
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