<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>
 <%@ page import="java.util.*" %>
<% Map<String, String> map = (HashMap<String,String>) request.getAttribute("shop-profile"); %>
  <div class="best-deal bg-white mt-5">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 mb-5">
          <div class="section-heading">
            <h6>| Gian hàng</h6>
            <!-- shop-name -->
            <%=map.get("shop-name") %>
            
            <!-- shop-status -->
           <%=map.get("shop-status") %>
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
                       	<!-- shop-attribute -->
                         <%=map.get("shop-attribute") %>
                        </ul>
                      </div>
                    </div>
                    <div class="col-12 mt-md-5">
                      <h4 class="mt-1">Extra Info About Shop</h4>
                      <!-- shop-note -->
                      <%=map.get("shop-note") %>
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