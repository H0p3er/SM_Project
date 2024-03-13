<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<jsp:include page="../components/header.jsp" flush="true"></jsp:include>
<% 
	//request.getRequestDispatcher("/home/workplace/edit"); 
	
	String data = (String) request.getAttribute("currentPageData"); 
	
	/* <!-- Data table--> */
		out.append(data);
	
	/* <!---Phân trang---> */
	//out.append(data.get(1));
		
%>
<jsp:include page="../components/footer.jsp" flush="true"></jsp:include>