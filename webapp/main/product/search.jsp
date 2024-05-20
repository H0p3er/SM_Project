
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
<jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>
<% 

	Map<String, String> map = new HashMap<String,String>();
try {
	map = (HashMap<String,String>) request.getAttribute("product-search"); 
} catch (ClassCastException e){
	
}


%>
  <div class="properties section">
    <div class="container">
      <nav aria-label="breadcrumb" class="ms-lg-5">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item"><a href="#">Library</a></li>
          <li class="breadcrumb-item active" aria-current="page">Data</li>
        </ol>
      </nav>
      <div class="row">
        <div class="col-3 d-lg-block d-none">
          <div class="best-deal p-0">
            <div class="info-table">
              <ul>
              	<li>Danh mục
                  <ul class="ms-4 mt-2">
                  <%= map.getOrDefault("product-filter", "") %>
<!--                     <li><a class="text-black" href="">Acer</a></li>
                    <li><a class="text-black" href="">AOC</a></li>
                    <li><a class="text-black" href="">Asus</a></li>
                    <li><a class="text-black" href="">BenQ</a></li>
                    <li><a class="text-black" href="">Dell</a></li>
                    <li><a class="text-black" href="">Gigabyte</a></li>
                    <li><a class="text-black" href="">HP</a></li>
                    <li><a class="text-black" href="">LG</a></li>
                    <li><a class="text-black" href="">MSI</a></li>
                    <li><a class="text-black" href="">Samsung</a></li>
                    <li><a class="text-black" href="">ViewSonic</a></li> -->
                  </ul>
                </li>
              
 <!--                <li>Hãng sản xuất
                  <ul class="ms-4 mt-2">
                    <li><a class="text-black" href="">Acer</a></li>
                    <li><a class="text-black" href="">AOC</a></li>
                    <li><a class="text-black" href="">Asus</a></li>
                    <li><a class="text-black" href="">BenQ</a></li>
                    <li><a class="text-black" href="">Dell</a></li>
                    <li><a class="text-black" href="">Gigabyte</a></li>
                    <li><a class="text-black" href="">HP</a></li>
                    <li><a class="text-black" href="">LG</a></li>
                    <li><a class="text-black" href="">MSI</a></li>
                    <li><a class="text-black" href="">Samsung</a></li>
                    <li><a class="text-black" href="">ViewSonic</a></li>
                  </ul>
                </li>
                <li>Kích thước
                  <ul class="ms-4 mt-2">
                    <li><a href="" class="text-black">
                        <19 inch</a>
                    </li>
                    <li><a href="" class="text-black">21.5 Inch</a></li>
                    <li><a href="" class="text-black">23.5 - 25 Inch</a></li>
                    <li><a href="" class="text-black">27 Inch</a></li>
                    <li><a href="" class="text-black">28 - 30 Inch</a></li>
                    <li><a href="" class="text-black">32 Inch</a></li>
                    <li><a href="" class="text-black">>32Inch</a></li>
                  </ul>
                </li>

                <li>Mục đích sử dụng
                  <ul class="ms-4 mt-2">
                    <li><a href="" class="text-black">Gaming</a></li>
                    <li><a href="" class="text-black">Văn phòng</a></li>
                    <li><a href="" class="text-black">Đồ họa</a></li>
                  </ul>
                </li>
                <li>Độ phân giải
                  <ul class="ms-4 mt-2">
                    <li><a href="" class="text-black">Full HD</a></li>
                    <li><a href="" class="text-black">2K QHD</a></li>
                    <li><a href="" class="text-black">4K UHD</a></li>
                  </ul>
                </li>
                <li>Tần số quét
                  <ul class="ms-4 mt-2">
                    <li><a href="" class="text-black">60 - 75Hz</a></li>
                    <li><a href="" class="text-black">100Hz</a></li>
                    <li><a href="" class="text-black">144Hz - 175Hz</a></li>
                    <li><a href="" class="text-black">240Hz - 360Hz</a></li>
                  </ul>
                </li> -->
              </ul>
            </div>
          </div>
        </div>
        <div class="col-lg-9">
          <div class="row">
			<%= map.getOrDefault("product-search", "<p>Không tồn tại sản phẩm</p>") %>			
          </div>
          <div class="row">
	        <div class="col-lg-12">
	          <ul class="pagination">
	          
	       		 <%=map.get("product-search-pagination") %>	
	          </ul>
	        </div>
	      </div>
        </div>
      </div>

    </div>
  </div>
  <jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include>