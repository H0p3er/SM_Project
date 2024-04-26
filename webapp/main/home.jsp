<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.google.gson.*" %>
   
<jsp:include page="component/header.jsp" flush="true"></jsp:include> 
<jsp:include page="component/navigation-bar.jsp" flush="true"></jsp:include>
  <div class="properties section">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 offset-lg-4">
          <div class="section-heading text-center">
            <h6>| Properties</h6>
            <h2>We Provide The Best Property You Like</h2>
          </div>
        </div>
      </div>
      <div class="row" id="home_product_list">
      	<% 

//      		Gson gson = new Gson();
//       		Map<String,String> map = gson.fromJson((String) request.getAttribute("home-page"), Map.class);
 
			Map<String,String> map = (Map<String,String>) request.getAttribute("home-page");
      		if (map!=null){
      			out.append(map.get("home_product_list"));
      		} else {
      			out.append("Lỗi kết nối");
      		}
      	%>
      </div>
    </div>
  </div>
  
  <jsp:include page="component/footer.jsp" flush="true"></jsp:include> 