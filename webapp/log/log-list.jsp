<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:include page="../components/header.jsp" flush="true"></jsp:include>

<div class="content-page">
<div class="container-fluid timeline-page">
   	<div class="row">
   		<div class="col-sm-12">
			<div class="card">
				<div class="card-header d-flex justify-content-between">
					<div class="header-title">
						<h4 class="card-title">Danh sách nơi làm việc</h4>
					</div>
				</div>
				<div class="card-body">
					<% 
						String data = (String) request.getAttribute("currentPageData"); 
					
						/* <!-- Data table--> */
			           	out.append(data);
			
						/* <!---Phân trang---> */
						//out.append(data.get(1));
					
					%>		
				</div><!-- card-body -->
			</div><!-- card -->
		</div><!-- col-sm-12 -->
	</div> <!-- row -->

</div> <!-- container-fluid -->
</div> <!-- contentPage -->

<jsp:include page="../components/footer.jsp" flush="true"></jsp:include>