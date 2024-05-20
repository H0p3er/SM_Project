<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.google.gson.*" %>
<jsp:include page="component/user_header.jsp" flush="true"></jsp:include>
<jsp:include page="component/user_navigation-bar.jsp" flush="true"></jsp:include>

<% 
Map<String, String> map = new HashMap<String,String>();
try {
	map = (HashMap<String,String>) request.getAttribute("home-page"); 
} catch (ClassCastException e){
	
}



%>

        <div class="contact bg-black">
    <div class="container">
      <div class="row">
        <div class="section-heading text-center">
          <h2>Welcome to SM Marketplace</h2>
          <br>
          <h6>Nous n'avons pas ce dont vous avez besoin ici !</h6>
          <h6>这里什么都没有</h6>
        </div>
      </div>
    </div>
  </div>
  <div class="properties section">
    <div id="bestsaler">
      <div class="container">
        <div class="row">
          <div class="section-heading">
            <h6 class="fs-2">| Sản phẩm bán chạy</h6>
          </div>
        </div>
      </div>
      <div id="carouselExampleIndicators" class="carousel carousel-dark slide" data-bs-interval="false">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
            aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
            aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
            aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container">
              <div class="row">
					<%=map.getOrDefault("home_most_sold_carousel_1", "") %>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container">
	            <div class="row">
					<%=map.getOrDefault("home_most_sold_carousel_2", "") %>
	            </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container">
	            <div class="row">
					<%=map.getOrDefault("home_most_sold_carousel_3", "") %>
	            </div>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
          data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
          data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>

      </div>
    </div>

    <div class="container mt-5">
      <div class="row">
        <div class="section-heading">
          <h6 class="fs-2">| Sản phẩm mới</h6>
        </div>
      </div>
      <div class="row">


			<%=map.getOrDefault("home_newest_product","") %>	
      </div>
    </div>
  </div>
      

      <jsp:include page="component/user_footer.jsp" flush="true"></jsp:include>