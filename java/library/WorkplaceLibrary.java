package library;

import java.util.*;

import org.javatuples.*;

import constant.SHOP_SORT_TYPE;
import entity.EmployeeObject;
import entity.ProductObject;
import entity.ShopObject;
import objects.*;
import utility.Utilities;
import utility.Utilities_date;

public class WorkplaceLibrary {
	public static ArrayList<String> viewWorkplaceList(
			Octet<	ArrayList<ShopObject>,
			Integer, 
			HashMap<Integer,Integer>, 
			HashMap<Integer,Integer>, 
			HashMap<Pair<String,Integer>,Integer> ,
			HashMap<Pair<String,Integer>,Integer>,
			HashMap<Triplet<Integer,Integer,String>,
					Triplet<ProductObject,Integer,Integer>>,
			HashMap<Integer,EmployeeObject>> datas, 
					
			Sextet<	EmployeeObject, 
					ShopObject, 
					Short, 
					Byte ,
					SHOP_SORT_TYPE,
					Boolean> infors, byte isOpenModal , String url){
		ArrayList<String> view = new ArrayList<String>();
		StringBuilder tmp = new StringBuilder();
		StringBuilder modal = new StringBuilder();
		
		ArrayList<ShopObject> wpItems = datas.getValue0(); 
		int wpTotal = datas.getValue1();
		
		EmployeeObject currentUser = infors.getValue0();
		ShopObject similar = infors.getValue1();
		short wpPage = infors.getValue2(); 
		byte wpPerPage = infors.getValue3();
		tmp.append("<form action=\"/home/workplace/list\" method=\"post\">");
		if (wpPerPage>3) {				
			tmp.append("<table id=\"workplace-list-table\" class=\"table table-striped dataTable mt-4\" role=\"grid\" aria-describedby=\"user-list-page-info\">");
			tmp.append("<thead>");
			tmp.append("<tr class=\"ligth\" role=\"row\">");
			tmp.append("<th>");
			tmp.append("Tên");
			tmp.append("</th>");
			tmp.append("<th>Số điện thoại</th>");
			tmp.append("<th>Ngày khởi tạo</th>");
			tmp.append("<th>Địa chỉ</th>");
			tmp.append("<th>Trạng thái</th>");
			tmp.append("<th style=\"min-width: 120px\">Hành động</th>");
			tmp.append("</tr>");
			tmp.append("</thead>");
			tmp.append("<tbody>"); 
			
			wpItems.forEach(item -> {
				tmp.append("<tr>");		
				tmp.append("<td>"+item.getWorkplace_name()+"</td>");
				tmp.append("<td>(760) 756 7568</td>");
				tmp.append("<td>"+item.getWorkplace_created_date()+"</td>");
				tmp.append("<td>"+item.getWorkplace_address()+"</td>");
				tmp.append("<td><span class=\"badge bg-primary\">Active</span></td>");
				tmp.append("<td style=\"min-width: 120px\">");
				tmp.append("<div class=\"d-flex align-items-center justify-content-around list-user-action\">");
				tmp.append("<a class=\"btn btn-sm bg-primary\" href=\""+url+"?Modal=1&page="+wpPage+"&id="+item.getWorkplace_id()+"\"> ");
				tmp.append("<i class=\"fa-regular fa-eye\"></i></a>");
				if (item.isWorkplace_deleted()) {
					tmp.append("<td class=\"align-middle\">"+item.getWorkplace_last_modified_date()+"</td>");
					tmp.append("<td class=\"align-middle\"><a href=\"#\" class=\"btn btn-primary btn-sm\"><i class=\"bi bi-reply\"></i></a></td>");
					tmp.append("<td class=\"align-middle\"><button class=\"btn btn-danger btn-sm\" \r\n"
							+ " data-bs-toggle=\"modal\" data-bs-target=\"#delUser"+item.getWorkplace_id()+"\"><i class=\"bi bi-trash3\"></i></button></td>");
					modal.append(WorkplaceLibrary.viewWorkplaceDeletingModal(item));
					
				} else {									
					if (item.getWorkplace_manager_id()==currentUser.getEmployee_id()) {
						tmp.append("<a class=\"btn btn-sm bg-secondary\" href=\"/home/workplace/edit?id="+item.getWorkplace_id()+"\">");
						tmp.append("<i class=\"ri-pencil-line mr-0\"  data-toggle=\"tooltip\" data-placement=\"top\" title=\"\" data-original-title=\"Edit\"></i>");
						tmp.append("</a>");
						
						tmp.append("<button type=\"button\" class=\"btn btn-sm bg-danger\" data-toggle=\"modal\" data-target=\"#delUser"+item.getWorkplace_id()+"\" data-bs-toggle=\"modal\" data-bs-target=\"#delUser"+item.getWorkplace_id()+"\">");
						tmp.append("<i class=\"ri-delete-bin-line mr-0\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"\" data-original-title=\"Delete\"></i>");
						tmp.append("</button>");
					} else {
						if (currentUser.getUser_permission()>=4) {
							tmp.append("<a class=\"btn btn-sm bg-secondary\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"\" data-original-title=\"Edit\" href=\"/home/workplace/edit?id="+item.getWorkplace_id()+"\">");
							tmp.append("<i class=\"ri-pencil-line mr-0\"></i>");
							tmp.append("</a>");
							
							tmp.append("<button type=\"button\" class=\"btn btn-sm bg-danger\" data-toggle=\"modal\" data-target=\"#delUser"+item.getWorkplace_id()+"\" data-bs-toggle=\"modal\" data-bs-target=\"#delUser"+item.getWorkplace_id()+"\">");
							tmp.append("<i class=\"ri-delete-bin-line mr-0\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"\" data-original-title=\"Delete\"></i>");
							tmp.append("</button>");
							modal.append(WorkplaceLibrary.viewWorkplaceDeletingModal(item));
						} else {
							if (item.getWorkplace_manager_id()==currentUser.getEmployee_id()) {
								tmp.append("<a class=\"btn btn-sm bg-secondary\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"\" data-original-title=\"Edit\" href=\"/home/workplace/user-profile-edit.jsp\">");
								tmp.append("<i class=\"ri-pencil-line mr-0\"></i>");
								tmp.append("</a>");
							} else {
								tmp.append("<a class=\"btn btn-sm bg-secondary\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"\" data-original-title=\"Edit\" disabled >");
								tmp.append("<i class=\"ri-pencil-line mr-0\"></i>");
								tmp.append("</a>");
							}
							tmp.append("<a class=\"btn btn-sm bg-danger\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"\" data-original-title=\"Delete\" disabled > ");
							tmp.append("<i class=\"ri-delete-bin-line mr-0\"></i>");
							tmp.append("</a>");
						}
					}	
				}//List				
//				tmp.append("<div class=\"d-flex align-items-center justify-content-around list-user-action\">");
//				tmp.append("<a class=\"btn btn-sm bg-primary\" href=\""+url+"?Modal=1&page="+wpPage+"&id="+item.getWorkplace_id()+"\"> ");
//				tmp.append("<i class=\"fa-regular fa-eye\"></i></a>");		
//				tmp.append("<a class=\"btn btn-sm bg-secondary\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"\" data-original-title=\"Edit\" disabled>");
//				tmp.append("<i class=\"ri-pencil-line mr-0\"></i>");
//				tmp.append("</a>");
//				tmp.append("<a class=\"btn btn-sm bg-danger\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"\"");
//				tmp.append("data-original-title=\"Delete\" href=\"/home/workplace/user-profile-edit.jsp\"><i class=\"ri-delete-bin-line mr-0\"></i></a>");
				tmp.append("</div>");
				tmp.append("</td>");
				tmp.append("</tr>");
				
			});		
			tmp.append("</tbody>");
			tmp.append("</table>");//end-table
			
			
			switch (isOpenModal) {
				case 1:
					if (similar.getWorkplace_id()<=0) {
						modal.append(WorkplaceLibrary.viewWorkplaceOverviewModal(wpItems.get(wpItems.size()-1), datas, wpPage, wpPerPage, wpTotal, url));
						modal.append("<script>");
						modal.append("window.onload = function() {");
						modal.append("$(\"#Workplace"+wpItems.get(wpItems.size()-1).getWorkplace_id()+"\").modal('show');");
						modal.append("};");
						modal.append("</script>");
					} else {
						wpItems.forEach(item -> {	
							if (item.getWorkplace_id()==similar.getWorkplace_id()) {
//								tmp.append("<button id=\"Workplace"+item.getWorkplace_id()+"\" type=\"button\" data-toggle=\"modal\"  data-target=\"#Workplace"+item.getWorkplace_id()+"\" style=\"height:95%\" hidden>");
//								tmp.append("</button>");
								modal.append(WorkplaceLibrary.viewWorkplaceOverviewModal(item, datas, wpPage, wpPerPage, wpTotal, url));
								modal.append("<script>");
								modal.append("window.onload = function() {");
								modal.append("$(\"#Workplace"+similar.getWorkplace_id()+"\").modal('show');");
								modal.append("};");
								modal.append("</script>");
							}
						});
					}	
					break;
				case 2:
					if (similar.getWorkplace_id()<=0) {
						modal.append(WorkplaceLibrary.viewWorkplaceOverviewModal(wpItems.get(0), datas, wpPage, wpPerPage, wpTotal, url));
						modal.append("<script>");
						modal.append("window.onload = function() {");
						modal.append("$(\"#Workplace"+wpItems.get(0).getWorkplace_id()+"\").modal('show');");
						modal.append("};");
						modal.append("</script>");
					} else {
						wpItems.forEach(item -> {	
							if (item.getWorkplace_id()==similar.getWorkplace_id()) {
//								tmp.append("<button id=\"Workplace"+item.getWorkplace_id()+"\" type=\"button\" data-toggle=\"modal\"  data-target=\"#Workplace"+item.getWorkplace_id()+"\" style=\"height:95%\" hidden>");
//								tmp.append("</button>");
								modal.append(WorkplaceLibrary.viewWorkplaceOverviewModal(item, datas, wpPage, wpPerPage, wpTotal, url));
								modal.append("<script>");
								modal.append("window.onload = function() {");
								modal.append("$(\"#Workplace"+similar.getWorkplace_id()+"\").modal('show');");
								modal.append("};");
								modal.append("</script>");
							}
						});
					}
				default:
					break;
			}
			
		} else {
			tmp.append("<div class=\"col-sm-12 px-3 pt-3 row\">");
//			tmp.append("<div class=\"d-flex\" style=\"align-items: stretch;\">");
			
			wpItems.forEach(item -> {
				tmp.append("<div class=\"col-sm-4 mb-3\">");
				tmp.append("<a class=\"card border-primary top-right shadow-showcase \" href=\""+url+"?Modal=true&page="+wpPage+"&id="+item.getWorkplace_id()+"\">");
				tmp.append("<img src=\""+item.getWorkplace_images()+"\" class=\"card-img-top\" alt=\"#\" height=\"200px\" width=\"400px\">");
				tmp.append("<div class=\"card-body\">");
				tmp.append("<h4 class=\"card-title\">"+item.getWorkplace_name()+"</h4>");
				tmp.append("<p class=\"card-text\">Địa chỉ: "+item.getWorkplace_address()+"</p>");	
//				tmp.append("<div class=\"card-text\" id=\"chart"+item.getWorkplace_id()+"\"></div>");
//				tmp.append(WorkplaceLibrary.viewChartOverviewModal(item,datas,"chart"+item.getWorkplace_id()).toString());		
				tmp.append("</div>");
				tmp.append("</a>");//card
				tmp.append("</div>");
			});
			
//			tmp.append("</div>");//card-columns
			tmp.append("</div>");//col-sm-12	
			
			
			switch (isOpenModal) {
			case 1:
				if (similar.getWorkplace_id()<=0) {
					modal.append(WorkplaceLibrary.viewWorkplaceOverviewModal(wpItems.get(wpItems.size()-1), datas, wpPage, wpPerPage, wpTotal, url));
					modal.append("<script>");
					modal.append("window.onload = function() {");
					modal.append("$(\"#Workplace"+wpItems.get(0).getWorkplace_id()+"\").modal('show');");
					modal.append("};");
					modal.append("</script>");
				} else {
					wpItems.forEach(item -> {	
						if (item.getWorkplace_id()==similar.getWorkplace_id()) {
//							tmp.append("<button id=\"Workplace"+item.getWorkplace_id()+"\" type=\"button\" data-toggle=\"modal\"  data-target=\"#Workplace"+item.getWorkplace_id()+"\" style=\"height:95%\" hidden>");
//							tmp.append("</button>");
							modal.append(WorkplaceLibrary.viewWorkplaceOverviewModal(item, datas, wpPage, wpPerPage, wpTotal, url));
							modal.append("<script>");
							modal.append("window.onload = function() {");
							modal.append("$(\"#Workplace"+similar.getWorkplace_id()+"\").modal('show');");
							modal.append("};");
							modal.append("</script>");
						}
					});
				}	
				break;
			case 2:
				if (similar.getWorkplace_id()<=0) {
					modal.append(WorkplaceLibrary.viewWorkplaceOverviewModal(wpItems.get(0), datas, wpPage, wpPerPage, wpTotal, url));
					modal.append("<script>");
					modal.append("window.onload = function() {");
					modal.append("$(\"#Workplace"+wpItems.get(0).getWorkplace_id()+"\").modal('show');");
					modal.append("};");
					modal.append("</script>");
				} else {
					wpItems.forEach(item -> {	
						if (item.getWorkplace_id()==similar.getWorkplace_id()) {
//							tmp.append("<button id=\"Workplace"+item.getWorkplace_id()+"\" type=\"button\" data-toggle=\"modal\"  data-target=\"#Workplace"+item.getWorkplace_id()+"\" style=\"height:95%\" hidden>");
//							tmp.append("</button>");
							modal.append(WorkplaceLibrary.viewWorkplaceOverviewModal(item, datas, wpPage, wpPerPage, wpTotal, url));
							modal.append("<script>");
							modal.append("window.onload = function() {");
							modal.append("$(\"#Workplace"+similar.getWorkplace_id()+"\").modal('show');");
							modal.append("};");
							modal.append("</script>");
						}
					});
				}	
			default:
				break;
		}
		}
		tmp.append("</form>");
		
		view.add(tmp.toString());
		view.add((WorkplaceLibrary.viewWorkplaceListPagination(url,wpPage,wpPerPage,wpTotal).toString()));
		modal.append(WorkplaceLibrary.viewWorkplaceAddingModal(datas.getValue6(),datas.getValue7()));
		view.add(modal.toString());
		return view;
	}
	
	private static StringBuilder viewWorkplaceListPagination(String url, short wpPage, byte wpPerPage ,int wpTotal){
		StringBuilder tmp = new StringBuilder();
		
		int wpTotalPage= wpTotal/wpPerPage;
			
		if ((wpTotal%wpPerPage!=0)) {
			wpTotalPage++;
		}
		
		tmp.append("<div class=\"row justify-content-between my-3\">");
		tmp.append("<div id=\"user-list-page-info\" class=\"col-md-6\">");
		tmp.append("<span>Hiển thị "+wpPerPage+" bản ghi trên "+wpTotal+" bản ghi</span>");
		tmp.append("</div>");
		tmp.append("<div class=\"col-md-6\">");
		tmp.append("<nav aria-label=\"Page navigation example\">");
		tmp.append("<ul class=\"pagination justify-content-end mb-0\">");
		tmp.append("<li class=\"page-item disabled\">");
		tmp.append("<a class=\"page-link\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Previous</a>");
		tmp.append("</li>");
		
		//Left Current
		String leftCurrent = "";
		int count = 0;
		
		for (int i = wpPage-1; i>0; i--) {
			leftCurrent = "<li class=\"page-item\"><a class=\"page-link\" href=\""+url+"?page="+i+"\">"+i+"</a></li>" + leftCurrent;
			if (++count>=2) {
				break;
			}
		}
		
		if (wpPage>=4) {
			leftCurrent = "<li class=\"page-item\"><a class=\"page-link\" href=\"#\">...</a></li>" + leftCurrent;
			//		if (page>1) {
			//			leftCurrent = ("<li class=\"page-item\"><a class=\"page-link\" href=\""+()+"\"><span aria-hidden=\"true\">&laquo;</span></a></li>") + leftCurrent;
			//		}
		}
		tmp.append(leftCurrent);
		
		tmp.append("<li class=\"page-item active\" aria-current=\"page\"><a class=\"page-link\" href=\"#\">"+wpPage+"</a></li>");
		
		//Right Current
		String rightCurrent = "";
		count=0;
		for (int i = wpPage+1; i<=wpTotalPage; i++) {
			rightCurrent += "<li class=\"page-item\"><a class=\"page-link\" href=\""+url+"?page="+i+"\">"+i+"</a></li>";
			if (++count>=2) {
				break;
			}
		}
		
		if (wpTotalPage> wpPage+4) {
			rightCurrent += "<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\">...</a></li>";
		}
		tmp.append(rightCurrent);

		tmp.append("<li class=\"page-item\">");
		tmp.append("<a class=\"page-link\" href=\"#\">Next</a>");
		tmp.append("</li>");
		tmp.append("</ul>");
		tmp.append("</nav>");
		tmp.append("</div>");
		tmp.append("</div>");
		
		return tmp;
	}
	
	
//	private static ArrayList<String> createWorkplaceChartList(Sextet<	ArrayList<WorkplaceObject>,
//			Integer, 
//			HashMap<Integer,Integer>, 
//			HashMap<Integer,Integer>, 
//			HashMap<Integer, Pair<String,Integer>> ,
//			HashMap<Integer, Pair<String,Integer>>> datas){	
//		ArrayList<String> view = new ArrayList<String>();
//		
//		return view;		
//	}

	private static StringBuilder viewWorkplaceAddingModal(
			HashMap<Triplet<Integer,Integer,String>,
					Triplet<ProductObject,Integer,Integer>> datas, 
			HashMap<Integer,EmployeeObject> manager) {
		StringBuilder tmp = new StringBuilder();
		tmp.append("<div id=\"addWorkplace\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"gridModalLabel\" aria-hidden=\"true\">");
		tmp.append("<div class=\"modal-dialog modal-xl w-100\">");
		tmp.append("<div class=\"modal-content\">");
		tmp.append("<div class=\"modal-header px-4 bg-primary\">");
		tmp.append("<h5 class=\"modal-title text-white\">Thêm đơn vị</h5>");
		tmp.append("<button type=\"button\" class=\"close btn-close-white\" data-dismiss=\"modal\" aria-label=\"Close\">");
		tmp.append("<span aria-hidden=\"true\">×</span>");
		tmp.append("</button>");
		tmp.append("</div>");//modal-header
		tmp.append("");
		tmp.append("<form action=\"/home/workplace/list\" method=\"post\">");
		tmp.append("<div class=\"modal-body mt-3 overflow-auto max-vh-70\">");
		
		//Input ảnh

		
		//Input tên
		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceName\" class=\"col-md-3 col-lg-2 text-lg-right col-form-label \">Tên chi nhánh:</label>");
			tmp.append("<div class=\"col-md-9 col-lg-10\">");
			tmp.append("<input class=\" form-control\" type=\"text\" placeholder=\"VD: Đơn vị 12\" name=\"workplaceName\" id=\"workplaceName\">");
			tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("");
		
		//Input Phân loại và mã đơn vị
		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
			tmp.append("<label for=\"workplaceType\" class=\"col-md-3 col-lg-2 text-lg-right mb-3 mb-lg-1 col-form-label \">Phân loại:");
			tmp.append("</label>");
			tmp.append("<div class=\"col-lg-3 col-md-9 mb-3 mb-lg-0\">");
			tmp.append("<select class=\"form-control\" name=\"workplaceType\" id=\"workplaceType\">");
			tmp.append("<option value=\"0\">Kho hàng</option>");
			tmp.append("<option value=\"1\">Cửa hàng</option>");
			tmp.append("</select>");
			tmp.append("</div>");

			tmp.append("<label for=\"workplaceCode\" class=\"col-md-3 col-lg-2 text-lg-right col-form-label \">Mã đơn vị:");
			tmp.append("</label>");
			tmp.append("<div class=\"col-lg-5 col-md-9 \">");
			tmp.append("<input class=\"form-control\" type=\"text\" placeholder=\"VD: Đơn vị 12\" id=\"workplaceCode\">");
			tmp.append("</div>");
		tmp.append("</div>");

		//Input người quản lý
		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceManager\" class=\"col-md-3 col-lg-2 text-lg-right col-form-label \">Người quản lý:</label>");
		tmp.append("<div class=\"col-lg-6 col-md-9\">");
		tmp.append("<select class=\"form-control\" id=\"workplaceManager\" name=\"workplaceManager\">");
		manager.forEach((eKey,eItem)->{
			tmp.append("<option class=\"form-control\" value=\""+eKey+"\">"+eItem.getUser_fullname()+"</option>");
		});
		tmp.append("</select>");
		tmp.append("</div>");
		tmp.append("</div>");
		
		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceContact\" class=\"col-md-3 col-lg-2 text-lg-right mb-3 mb-lg-1 col-form-label \">Địa chỉ:</label>");
		tmp.append("<div class=\"col-lg-10 col-md-9\">");
		tmp.append("<div class=\"input-group\">");
		tmp.append("<input class=\" form-control\" type=\"text\" placeholder=\"Địa chỉ\" id=\"workplacelocation\">");
		tmp.append("<input class=\" form-control\" type=\"text\" placeholder=\"Quận/Huyện\" id=\"workplaceadministrative_area_level_2\">");
		tmp.append("<input class=\" form-control\" type=\"text\" placeholder=\"Thành phố\" id=\"workplaceadministrative_area_level_1\">");
		tmp.append("<input class=\" form-control\" type=\"text\" name=\"workplaceAddress\" id=\"workplaceAddress\" hidden>");
		tmp.append("</div>");//input-group
		tmp.append("</div>");//col-lg-10 col-md-9
		tmp.append("</div>");//row mb-3 mr-lg-5 align-items-center
		
		tmp.append("<div class=\"card-container justify-content-center\">");
		tmp.append("<div class=\"map w-75\" id=\"gmp-map\"></div>");
		tmp.append("</div>");//card-container justify-content-center
		
		
		
		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceContact\" class=\"col-md-3 col-lg-2 text-lg-right mb-3 mb-lg-1 col-form-label \">Liên hệ:");
		tmp.append("</label>");
		tmp.append("<div class=\"col-lg-10 col-md-9\">");
		tmp.append("<div class=\"input-group\">");
		tmp.append("<input class=\" form-control\" type=\"text\" placeholder=\"SDT\" name=\"workplacePhoneNumber\" id=\"workplacePhoneNumber\">");
		tmp.append("<input class=\" form-control\" type=\"text\" placeholder=\"Email\" name=\"workplaceEmail\" id=\"workplaceEmail\">");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");

		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceNotes\"");
		tmp.append("class=\"col-md-3 col-lg-2 text-lg-right mb-3 mb-lg-1 col-form-label \">Ghi chú:</label>");
		tmp.append("<div class=\"col-lg-10 col-md-9\">");
		tmp.append("<textarea class=\"form-control\" type=\"text\" placeholder=\"VD: workplace@example.com\" name=\"workplaceNotes\" id=\"workplaceNotes\"></textarea>");
		tmp.append("</div>");
		tmp.append("</div>");

		
		tmp.append("<div class=\"row align-items-center border-bottom border-top border-secondary-subtle\">");
//		tmp.append("<div class=\"w-100\">");
//		tmp.append("<div class=\"card card-widget task-card mb-2 w-100\">");
//		tmp.append("<div class=\"card-body\">");
		tmp.append("<div class=\"col-12 d-flex flex-wrap align-items-center justify-content-between pt-2 pb-2\">");
		tmp.append("<h5>Sản phẩm cho chi nhánh</h5>");
		tmp.append("<div class=\"media align-items-center\">");
		tmp.append("<a class=\"btn bg-primary-light\" data-toggle=\"collapse\" href=\"#collapseEdit3\" role=\"button\"");
		tmp.append("aria-expanded=\"false\" aria-controls=\"collapseEdit3\"><i class=\"ri-edit-box-line m-0\"></i></a>");
		tmp.append("</div>");//media align-items-center
		tmp.append("</div>");//d-flex flex-wrap align-items-center justify-content-between
		
		
		tmp.append("<div class=\"collapse w-100 border-top border-secondary-subtle\" id=\"collapseEdit3\">");
		tmp.append("<div class=\"card card-list task-card\">");
//		tmp.append("<div class=\"card-body\">");
//		tmp.append("<div class=\"card mb-3\">");
		tmp.append("<div class=\"card-body\">");
		tmp.append("<div class=\"w-100\">");
		tmp.append("<table id=\"myTable\" class=\"display table-striped data-table dataTable\">");
		tmp.append("<thead>");
		tmp.append("<tr>");
		tmp.append("<th></th>");
		tmp.append("<th>Tên sản phẩm</th>");
		tmp.append("<th>Mã sản phẩm</th>");
		tmp.append("<th>Số lượng</th>");
		tmp.append("<th>Giá nhập</th>");
		tmp.append("</tr>");
		tmp.append("</thead>");
		tmp.append("<tbody>");
		
		datas.forEach((key,value)->{
			tmp.append("<tr>");
			tmp.append("<td>");
//			tmp.append("<input class=\"form-check-input\" type=\"checkbox\" value=\""+key+"\">");
			tmp.append("</td>");
			tmp.append("<td>"+value.getValue0().getProduct_name()+"</td>");
			tmp.append("<td>"+key.getValue0()+"</td>");
			tmp.append("<td>");
			tmp.append("<input class=\"form-control addWpsd\" name=\"product"+key.getValue0()+"\" type=\"number\">");
			tmp.append("</td>");
			tmp.append("<td>"+value.getValue1()+"</td>");
			tmp.append("</tr>");
		});
		tmp.append("</tbody>");
		tmp.append("</table>");
		tmp.append("</div>");//w-100
		tmp.append("</div>");//card-body
//		tmp.append("</div>");//card mb-3
//		tmp.append("</div>");//card-body
		tmp.append("</div>");//card card-list task-card
		tmp.append("</div>");//collapse
		
		
//		tmp.append("</div>");//card-body
//		tmp.append("</div>");//card card-widget task-card mb-2 w-100
		
		
		
//		tmp.append("</div>");//w-100
		tmp.append("</div>");//row align-items-center
		tmp.append("</div>");//modal-body
		tmp.append("<div class=\"modal-footer\">");
		tmp.append("<input type=\"text\" class=\"wpsdString\" name=\"wpsdString\" hidden>");
		tmp.append("<button type=\"submit\" class=\"btn btn-primary\">Xác nhận</button>");
		tmp.append("</div>");//modal-footer
		tmp.append("</form>");
		tmp.append("</div>");//modal-content
		tmp.append("</div>");//modal-dialog
		tmp.append("</div>");//modal
		return tmp;
	}
	
	private static StringBuilder viewWorkplaceDeletingModal(ShopObject item) {
		StringBuilder tmp = new StringBuilder();
		
		String title;
		if (item.isWorkplace_deleted()) {
			title = "Xóa vĩnh viễn";
			
		} else {
			title = "Xóa tài khoản";
		}
		
		tmp.append("<div class=\"modal fade\" id=\"delUser"+item.getWorkplace_id()+"\" tabindex=\"-1\" aria-labelledby=\"UserLabel"+item.getWorkplace_id()+"\" aria-hidden=\"true\">");
		tmp.append("<div class=\"modal-dialog modal-lg\">");
		tmp.append("<div class=\"modal-content\">");
		tmp.append("<div class=\"modal-header\">");
		tmp.append("<h1 class=\"modal-title fs-5\" id=\"UserLabel"+item.getWorkplace_id()+"\">"+title+"</h1>");
		tmp.append("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">");
		tmp.append("<span aria-hidden=\"true\">×</span>");
		tmp.append("</button>");
		tmp.append("</div>");
		tmp.append("<div class=\"modal-body\">");
		
		if (item.isWorkplace_deleted()) {
			tmp.append("Bạn có chắc chắn xóa vĩnh viễn tài khoản <b>").append(item.getWorkplace_name()).append("("+item.getWorkplace_name()+")</b><br>");
			tmp.append("Tài khoản không thể phục hồi được nữa.");
		} else {
			tmp.append("Bạn có chắc chắn xóa tài khoản <b>").append(item.getWorkplace_name()).append("("+item.getWorkplace_name()+")</b><br>");
			tmp.append("Hệ thống sẽ tạm thời lưu vào thùng rác, bạn có thể phục hồi trong vòng 30 ngày.");
		}
	
		tmp.append("</div>");
		tmp.append("<div class=\"modal-footer\">");
		
		if (item.isWorkplace_deleted()) {
			tmp.append("<a href=\"/home/wpDel?wpid="+item.getWorkplace_id()+"&wpmid="+item.getWorkplace_manager_id()+"\" class=\"btn btn-danger\">Xóa vĩnh viễn</a>");
		} else {
			tmp.append("<a href=\"/home/wpDel?wpid="+item.getWorkplace_id()+"&t&wpmid="+item.getWorkplace_manager_id()+"\" class=\"btn btn-danger\">Xóa</a>");
		}
		
		tmp.append("<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Hủy</button>");		
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		return tmp;
	}
	
	private static StringBuilder viewChartOverviewModal(ShopObject detail,
			Octet<	ArrayList<ShopObject>,
			Integer, 
			HashMap<Integer,Integer>, 
			HashMap<Integer,Integer>, 
			HashMap<Pair<String,Integer>,Integer> ,
			HashMap<Pair<String,Integer>,Integer>,
			HashMap<Triplet<Integer,Integer,String>,
					Triplet<ProductObject,Integer,Integer>>,
			HashMap<Integer,EmployeeObject>> datas
			,String chartname){
		
		StringBuilder tmp = new StringBuilder();		
		
		StringBuilder ex = new StringBuilder();
		StringBuilder im = new StringBuilder();
		StringBuilder date = new StringBuilder();			
		HashMap<Pair<String,Integer>,Integer> importData = datas.getValue4();
		HashMap<Pair<String,Integer>,Integer> exportData = datas.getValue5();
		ArrayList<String> dateData = new ArrayList<String>();
		
		importData.forEach((key, value)->{
			if (key.getValue0()!=null) {
				if (!dateData.contains(key.getValue0())) {
					dateData.add(key.getValue0());
				}				
			}		
		});
		
		exportData.forEach((key, value)->{
			if (key.getValue0()!=null) {
				if (!dateData.contains(key.getValue0())) {
					dateData.add(key.getValue0());
				}				
			}			
		});
		

		dateData.sort((o1, o2) -> Utilities_date.getDate(o1).compareTo(Utilities_date.getDate(o2)));
		
		dateData.forEach((item)->{		
			Pair<String,Integer> key = new Pair<>(item,detail.getWorkplace_id());
			if (importData.get(key)!=null) {
				im.append(importData.get(key));			
			} else {
				im.append(0);
			}
			
			if (exportData.get(key)!=null) {
				ex.append(exportData.get(key));			
			} else {
				ex.append(0);
			}
			
			date.append("'").append(item).append("'");
			if (dateData.indexOf(item)<dateData.size()-1) {
				ex.append(",");
				im.append(",");
				date.append(",");
			}
		});
		
		System.out.println(ex.toString());
		System.out.println(im.toString());
		System.out.println(date.toString());

//		tmp.append("<script>   ");
//		tmp.append("	var options = {");
//		tmp.append("	  series: [{");
//		tmp.append("	  name: 'Import value',");
//		tmp.append("	  type: 'area',");
//		tmp.append("	  data: ["+im.toString()+"]");
//		tmp.append("	}, {");
//		tmp.append("	  name: 'Export value',");
//		tmp.append("	  type: 'line',");
//		tmp.append("	  data: ["+ex.toString()+"]");
//		tmp.append("	}],");
//		tmp.append("	  chart: {");
//		tmp.append("	  height: 350,");
//		tmp.append("	  type: 'line',");
//		tmp.append("	},");
//		tmp.append("	stroke: {");
//		tmp.append("	  curve: 'smooth'");
//		tmp.append("	},");
//		tmp.append("	fill: {");
//		tmp.append("	  type:'solid',");
//		tmp.append("	  opacity: [0.35, 1],");
//		tmp.append("	},");
//		tmp.append("	labels: ["+date.toString()+"],");
//		tmp.append("	markers: {");
//		tmp.append("	  size: 0");
//		tmp.append("	},");
//		tmp.append("	yaxis: [");
//		tmp.append("	  {");
//		tmp.append("		title: {");
//		tmp.append("		  text: 'VND',");
//		tmp.append("		},");
//		tmp.append("	  },");
//		tmp.append("	  {");
//		tmp.append("		opposite: true,");
//		tmp.append("		title: {");
//		tmp.append("		  text: 'VND',");
//		tmp.append("		},");
//		tmp.append("	  },");
//		tmp.append("	],");
//		tmp.append("	tooltip: {");
//		tmp.append("	  shared: true,");
//		tmp.append("	  intersect: false,");
//		tmp.append("	  y: {");
//		tmp.append("		formatter: function (y) {");
//		tmp.append("		  if(typeof y !== \"undefined\") {");
//		tmp.append("			return  y.toFixed(0) + \" VND\";");
//		tmp.append("		  }");
//		tmp.append("		  return y;");
//		tmp.append("		}");
//		tmp.append("	  }");
//		tmp.append("	}");
//		tmp.append("	};");
//		tmp.append("	var chart = new ApexCharts(document.querySelector(\"#"+chartname+"\"), options);");
//		tmp.append("	chart.render();");
//		tmp.append("</script>");
		
		
		
		
		tmp.append("<script>");		
		tmp.append("if (document.querySelector(\"#"+chartname+"\")!=null) {");
		tmp.append("const options = {");
		tmp.append("chart: {");
		tmp.append("height: 260,");
		tmp.append("type: \"area\"");
		tmp.append("},");
		tmp.append("dataLabels: {");
		tmp.append("enabled: !1");
		tmp.append("},");
		tmp.append("stroke: {");
		tmp.append("curve: \"smooth\"");
		tmp.append("},");
		tmp.append("colors: [\"#4788ff\", \"#ff4b4b\"],");
		tmp.append("series: [{");
		tmp.append("name: \"series1\",");
		tmp.append("data: ["+im.toString()+"]");
		tmp.append("}, {");
		tmp.append("name: \"series2\",");
		tmp.append("data: ["+ex.toString()+"]");
		tmp.append("}],");
		tmp.append("xaxis: {");
		tmp.append("type: \"date\",");
		tmp.append("categories: ["+date.toString()+"]");
		tmp.append("},");
		tmp.append("tooltip: {");
		tmp.append("x: {");
		tmp.append("format: \"dd/MM/yy\"");
		tmp.append("}");
		tmp.append("}");
		tmp.append("};");
		tmp.append("const chart = new ApexCharts(document.querySelector(\"#"+chartname+"\"), options); ");
		tmp.append("chart.render(); ");
		tmp.append("const body = document.querySelector('body'); ");
		tmp.append("if (body.classList.contains('dark')) {");
		tmp.append("apexChartUpdate(chart, {");
		tmp.append("dark: true");
		tmp.append("});");
		tmp.append("}");
		tmp.append("");
		tmp.append("document.addEventListener('ChangeColorMode', function (e) {");
		tmp.append("apexChartUpdate(chart, e.detail);");
		tmp.append("});");
		tmp.append("}");
		tmp.append("</script>");
		return tmp;
	}
	
	
	
	private static StringBuilder viewWorkplaceOverviewModal(ShopObject item,
			Octet<	ArrayList<ShopObject>,
			Integer, 
			HashMap<Integer,Integer>, 
			HashMap<Integer,Integer>, 
			HashMap<Pair<String,Integer>,Integer> ,
			HashMap<Pair<String,Integer>,Integer>,
			HashMap<Triplet<Integer,Integer,String>,
					Triplet<ProductObject,Integer,Integer>>,
			HashMap<Integer,EmployeeObject>> datas, short wpPage, byte wpPerPage ,int wpTotal, String url) {
		StringBuilder tmp = new StringBuilder();		
		tmp.append("<div id=\"Workplace"+item.getWorkplace_id()+"\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"gridModalLabel\" aria-hidden=\"true\">");
		tmp.append("<div class=\"modal-dialog modal-xl w-100 modal-dialog-centered\" role=\"document\">");		
		tmp.append("<div class=\"modal-content\">");	
		tmp.append("<div class=\"modal-header align-items-center\">");
		tmp.append("<h3 class=\"modal-title\" >"+item.getWorkplace_name()+"</h3>");
		tmp.append("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>");
		tmp.append("</div><!--  Modal header -->");
		tmp.append("<div class=\"modal-body overflow-auto max-vh-90\">");
		tmp.append("<div class=\"container-fluid\">"); 
		tmp.append("<div class=\"row\">");
		tmp.append("<div class=\"col-lg-12\">");
		tmp.append("<div class=\"row align-items-start justify-content-around\">");
		tmp.append("<div class=\"col-lg-5\">");
		tmp.append("<img class=\"w-100 mb-5\" src=\""+item.getWorkplace_images()+"\" height=\"200\" width=\"250\" alt=\"...\">");
		tmp.append("<div id=\"detailchart"+item.getWorkplace_id()+"\"></div>");
		tmp.append(WorkplaceLibrary.viewChartOverviewModal(item,datas,"detailchart"+item.getWorkplace_id()).toString());	
		tmp.append("</div> <!--  end col-lg-4 -->");
		tmp.append("<div class=\"col-lg-7 row\">");
		tmp.append("<div class=\"col-lg-6\">");
		tmp.append("<table class=\"table d-table\">");
		tmp.append("<tbody class=\"w-100\">");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-4\">Mã đơn vị</th>");
		tmp.append("<td>"+item.getWorkplace_id()+"</td>");
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-4\">Tên kho hàng</th>");
		tmp.append("<td>"+item.getWorkplace_name()+"</td>");
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-5\">Phân loại</th>");
		if (item.getWorkplace_type()==0) {
			tmp.append("<td>Kho hàng</td>");
		} else {
			tmp.append("<td>Cửa hàng</td>");
		}
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<tr>");
		tmp.append("<th>Liên kết Website</th>");
		tmp.append("<td>"+item.getWorkplace_website_link()+"</td>");
		tmp.append("</tr>");
		tmp.append("</tbody>");
		tmp.append("</table>");
		tmp.append("</div> <!--  end col-lg-4 -->");
		tmp.append("<div class=\"col-lg-6\">");
		tmp.append("<table class=\"table d-table\">");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-6\">Ngày khởi tạo</th>");
		tmp.append("<td>"+item.getWorkplace_created_date()+"</td>");
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-6\">Tình trạng</th>");
		if (item.getWorkplace_status()==0) {
			tmp.append("<td>Đang hoạt động</td>");
		} else {
			tmp.append("<td>Đã ngừng hoạt động</td>");
		}
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-6\">Người quản lý</th>");
		tmp.append("<td>"+datas.getValue7().get(item.getWorkplace_manager_id()).getUser_fullname()+"</td>");
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-6\">Khoản đầu tư</th>");
		tmp.append("<td>12</td>");
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th>Lợi nhuận</th>");
		
		int importValue=0;
		int exportValue=0;
		if (datas.getValue2().get(item.getWorkplace_id())==null) {
			importValue=0;
		} else {
			importValue= datas.getValue2().get(item.getWorkplace_id());
		}
		
		if (datas.getValue3().get(item.getWorkplace_id())==null) {
			exportValue=0;
		} else {
			exportValue= datas.getValue3().get(item.getWorkplace_id());
		}
		
		int benefit=exportValue-importValue;
		
		tmp.append("<td>"+benefit+"</td>");
		tmp.append("</tr>");
		tmp.append("");
		tmp.append("</table>");
		tmp.append("</div> <!--  end col-lg-4 -->");
		tmp.append("<div class=\"col-lg-12\">");
		tmp.append("<table class=\"table d-table\">");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-lg-2 col-6\">Địa chỉ</th>");
		tmp.append("<td>"+item.getWorkplace_address()+"</td>");
		tmp.append("</tr>");
		tmp.append("</table>");
		tmp.append("</div> <!--  end col-lg-12 -->");
		
		tmp.append("<div class=\"col-lg-12\">");
		tmp.append("<table class=\"table d-table\">");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-lg-2 col-6\">Ghi chú</th>");
		tmp.append("<td>");
		tmp.append("<textarea class=\"form-control\">");
		tmp.append(item.getWorkplace_notes());
		tmp.append("</textarea>");
		tmp.append("</td>");
		tmp.append("</tr>");
		tmp.append("</table>");
		tmp.append("</div> <!--  end col-lg-12 -->");
		tmp.append("</div>");
		tmp.append("</div> <!--  end row align-items-start justify-content-around -->");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div><!--  Modal body -->");
		tmp.append("<div class=\"modal-footer justify-content-between\">");
		
		int current = datas.getValue0().indexOf(item);
		int next = 0;
		int before = 0;
		int wpTotalPage= wpTotal/wpPerPage;
		
		
		short changedPage = wpPage;
		
		if ((wpTotal%wpPerPage!=0)) {
			wpTotalPage++;
		}
		
		if (current >= 1 && current<datas.getValue0().size()-1) {
			next = datas.getValue0().get(current+1).getWorkplace_id();
			before =  datas.getValue0().get(current-1).getWorkplace_id();
			
			tmp.append("<a href=\""+url+"?Modal=1&page="+wpPage+"&id="+before+"\">");
			tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-left\"></i></button>");
			tmp.append("</a>");
			
			tmp.append("<a href=\""+url+"?Modal=2&page="+wpPage+"&id="+next+"\">");
			tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-right\"></i></button>");
			tmp.append("</a>");
		} else {					
			if (current<1) {				
				if ((current+wpPerPage*(wpPage-1)+1)==wpTotal) {		
					if (wpPage==1) {
						changedPage = 1;
						tmp.append("<a href=\""+url+"?Modal=1&page="+changedPage+"\">");
						tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-left\"></i></button>");
						tmp.append("</a>");
						
						tmp.append("<a href=\""+url+"?Modal=2&page="+changedPage+"\">");
						tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-right\"></i></button>");
						tmp.append("</a>");
					} else {
						--changedPage ;
						tmp.append("<a href=\""+url+"?Modal=1&page="+changedPage+"\">");
						tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-left\"></i></button>");
						tmp.append("</a>");
						
						changedPage=1;
						tmp.append("<a href=\""+url+"?Modal=2&page="+changedPage+"\">");
						tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-right\"></i></button>");
						tmp.append("</a>");
					}					
				} else {								
					if (wpPage==1) {
						changedPage = (short) wpTotalPage;
						tmp.append("<a href=\""+url+"?Modal=1&page="+changedPage+"\">");
						tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-left\"></i></button>");
						tmp.append("</a>");
					} else {
						--changedPage;
						tmp.append("<a href=\""+url+"?Modal=1&page="+changedPage+"\">");
						tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-left\"></i></button>");
						tmp.append("</a>");
					}
					
					next = datas.getValue0().get(current+1).getWorkplace_id();
					tmp.append("<a href=\""+url+"?Modal=2&page="+wpPage+"&id="+next+"\">");
					tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-right\"></i></button>");
					tmp.append("</a>");
				}											
				
			} else {
				before =  datas.getValue0().get(current-1).getWorkplace_id();
				tmp.append("<a href=\""+url+"?Modal=1&page="+wpPage+"&id="+before+"\">");
				tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-left\"></i></button>");
				tmp.append("</a>");			
				
				if (current == datas.getValue0().size()-1){
					if ((current+wpPerPage*(wpPage-1)+1)==wpTotal) {
						changedPage = 1;
						tmp.append("<a href=\""+url+"?Modal=2&page="+changedPage+"\">");
						tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-right\"></i></button>");
						tmp.append("</a>");
					} else {
						++changedPage;
						tmp.append("<a href=\""+url+"?Modal=2&page="+changedPage+"\">");
						tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-right\"></i></button>");
						tmp.append("</a>");
					}	
				}
			}			
		}
		
//		if (before == 0) {
//			tmp.append("<a href=\""+url+"?Modal=true&?page="+wpPage+"\">");
//		} else {
//			tmp.append("<a href=\""+url+"?Modal=true&?page="+wpPage+"&?id="+before+"\">");
//		}
		
//		tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-left\"></i></button>");
//		tmp.append("</a>");	
//		
//		if (next == 0) {
//			tmp.append("<a href=\""+url+"?Modal=true&?page="+wpPage+"\">");
//		} else {
//			tmp.append("<a href=\""+url+"?Modal=true&?page="+wpPage+"&?id="+next+"\">");
//		}
		
//		tmp.append("<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-angle-right\"></i></button>");
//		tmp.append("</a>");
		tmp.append("</div><!--  Modal footer -->");
		tmp.append("</div><!--  Modal content -->");
		tmp.append("</div><!--  Modal dialog -->");
		tmp.append("</div> <!--  Modal -->");
		return tmp;
	}
	
	private static StringBuilder viewWorkplaceStatisticChart(Sextet<	ArrayList<ShopObject>,
			Integer, 
			HashMap<Integer,Integer>, 
			HashMap<Integer,Integer>, 
			HashMap<Pair<String,Integer>,Integer> ,
			HashMap<Pair<String,Integer>,Integer>> datas, String chartName){	
		
		ArrayList<ShopObject> workplaceList = datas.getValue0();
		HashMap<Integer,Integer> workplaceIncome = datas.getValue2();
		StringBuilder tmp = new StringBuilder();			
		StringBuilder NameString = new StringBuilder();
		StringBuilder IncomeString = new StringBuilder();		

		Iterator<ShopObject> iterator = workplaceList.iterator();			
		while (iterator.hasNext()) {

			ShopObject item = iterator.next();
			IncomeString.append(workplaceIncome.get(item.getWorkplace_id()));
			NameString.append("'"+Utilities.decode(item.getWorkplace_name())).append(" (").append(item.getWorkplace_created_date()).append(")'");
			
			if (iterator.hasNext()) {
				IncomeString.append(",");
				NameString.append(",");
			}
		}
		
		tmp.append("<div id=\""+chartName+"\"></div>");
		tmp.append("");
		tmp.append("<script>");
		tmp.append("");
		tmp.append("var options = {");
		tmp.append("series: [{data: ["+IncomeString.toString()+"], name:'VND'}],");
		tmp.append("chart: {type: 'bar', height: 350},");
		tmp.append("plotOptions: {");
		tmp.append("bar: { borderRadius: 4, borderRadiusApplication: 'end', horizontal: true,}");
		tmp.append("},");
		tmp.append("dataLabels: {enabled: false},");
		tmp.append("xaxis: {categories: ["+NameString.toString()+"],}");
		tmp.append("};");
		tmp.append("");
		tmp.append("var chart = new ApexCharts(document.querySelector('#"+chartName+"'), options);");
		tmp.append("chart.render();");
		tmp.append("");
		tmp.append("</script>");
		tmp.append("");
		tmp.append("");
		return tmp;
	}
	
	public static ArrayList<String> viewWorkplaceEdit(
			Octet<	ArrayList<ShopObject>,
			Integer, 
			HashMap<Integer,Integer>, 
			HashMap<Integer,Integer>, 
			HashMap<Pair<String,Integer>,Integer> ,
			HashMap<Pair<String,Integer>,Integer>,
			HashMap<Triplet<Integer,Integer,String>,
					Triplet<ProductObject,Integer,Integer>>,
			HashMap<Integer,EmployeeObject>> datas, 
					
			Sextet<	EmployeeObject, 
					ShopObject, 
					Short, 
					Byte ,
					SHOP_SORT_TYPE,
					Boolean> infors, byte isOpenModal , String url){
		ShopObject eWorkplace = datas.getValue0().get(0);
		EmployeeObject eEmployee = datas.getValue7().get(eWorkplace.getWorkplace_manager_id());
		ArrayList<String> view = new ArrayList<String>();
		StringBuilder tmp = new StringBuilder();
		
		tmp.append("<div class=\"row position-relative\">");
		tmp.append("<div class=\"col-lg-12 max-vh-40\">");
		tmp.append("<div class=\"card car-transparent\">");
		tmp.append("<div class=\"card-body p-0\">");
		tmp.append("<div class=\"profile-image\">");
		tmp.append("<img src=\""+eWorkplace.getWorkplace_images()+"\" class=\"img-fluid rounded w-100\" alt=\"profile-image\">");
		tmp.append("</div>");
		tmp.append("</div>");//card-body p-0
		tmp.append("</div>");//card car-transparent
		tmp.append("</div>");//col-lg-12
		tmp.append("</div>");//row	
		view.add(tmp.toString());
		
		view.add(WorkplaceLibrary.viewWorkplaceManagerProfile(eWorkplace, eEmployee, url).toString());
		view.add(WorkplaceLibrary.viewWorkplaceProfile(datas,eWorkplace, url).toString());
		view.add(WorkplaceLibrary.viewWorkplaceEditProfile(eWorkplace, datas.getValue7(), url).toString());
		view.add(WorkplaceLibrary.viewWorkplaceStorage(datas).toString());
		return view;
	}
	
	private static StringBuilder viewWorkplaceManagerProfile(ShopObject eWorkplace, EmployeeObject eEmployee , String url){
		StringBuilder tmp = new StringBuilder();

		if (eEmployee!=null) {
			tmp.append("<div class=\"col-lg-4 card-profile\">");
			tmp.append("<div class=\"card card-block card-stretch card-height\">");
			
			tmp.append("<div class=\"card-header d-flex justify-content-between\">");
			tmp.append("<div class=\"header-title\">");
			tmp.append("<h4 class=\"card-title\">Thông tin người quản lý</h4>");
			tmp.append("</div>");//card-header d-flex justify-content-between
			tmp.append("</div>");//header-title
			
			
			tmp.append("<div class=\"card-body\">");
			tmp.append("<div class=\"d-flex align-items-center mb-3\">");
			tmp.append("<div class=\"profile-img position-relative\">");
			tmp.append("<img src=\""+eEmployee.getUser_images()+"\" class=\"img-fluid rounded avatar-110\" alt=\"profile-image\">");
			tmp.append("</div>");
			tmp.append("<div class=\"ml-3\">");
			tmp.append("<h4 class=\"mb-1\">"+eEmployee.getUser_fullname()+"</h4>");
			String roles="";
			switch (eEmployee.getEmployee_role()) {
				case 1:
					roles="nhân viên";
				break;
				
				case 2:
					roles="quản lý";
				break;
					
				case 3:
					roles="quản trị cấp cao";
				break;
			}
			tmp.append("<p class=\"mb-2\">"+roles+"</p>");
			tmp.append("<a href=\"#\" class=\"btn btn-primary font-size-14\">Liên hệ</a>");
			tmp.append("</div>");
			tmp.append("</div>");//d-flex align-items-center mb-3
			tmp.append("<p>");
			tmp.append(eEmployee.getUser_notes());
			tmp.append("</p>");
			tmp.append("<ul class=\"list-inline p-0 m-0\">");
			tmp.append("<li class=\"mb-2\">");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z\" />");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M15 11a3 3 0 11-6 0 3 3 0 016 0z\" />");
			tmp.append("</svg>");
			tmp.append("<p class=\"mb-0\">"+eEmployee.getUser_address()+"</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("<li class=\"mb-2\">");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M21 13.255A23.931 23.931 0 0112 15c-3.183 0-6.22-.62-9-1.745M16 6V4a2 2 0 00-2-2h-4a2 2 0 00-2 2v2m4 6h.01M5 20h14a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z\" />");
			tmp.append("</svg>");
			
			tmp.append("<p class=\"mb-0\">"+eWorkplace.getWorkplace_name()+"</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("<li class=\"mb-2\">");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M21 15.546c-.523 0-1.046.151-1.5.454a2.704 2.704 0 01-3 0 2.704 2.704 0 00-3 0 2.704 2.704 0 01-3 0 2.704 2.704 0 00-3 0 2.704 2.704 0 01-3 0 2.701 2.701 0 00-1.5-.454M9 6v2m3-2v2m3-2v2M9 3h.01M12 3h.01M15 3h.01M21 21v-7a2 2 0 00-2-2H5a2 2 0 00-2 2v7h18zm-3-9v-2a2 2 0 00-2-2H8a2 2 0 00-2 2v2h12z\" />");
			tmp.append("</svg>");
			tmp.append("<p class=\"mb-0\">"+eEmployee.getUser_created_date()+"</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("<li class=\"mb-2\">");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M3 5a2 2 0 012-2h3.28a1 1 0 01.948.684l1.498 4.493a1 1 0 01-.502 1.21l-2.257 1.13a11.042 11.042 0 005.516 5.516l1.13-2.257a1 1 0 011.21-.502l4.493 1.498a1 1 0 01.684.949V19a2 2 0 01-2 2h-1C9.716 21 3 14.284 3 6V5z\" />");
			tmp.append("</svg>");
			tmp.append("<p class=\"mb-0\">"+eEmployee.getUser_office_phone()+"</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("<li>");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z\" />");
			tmp.append("</svg>");
			tmp.append("<p class=\"mb-0\">"+eEmployee.getUser_email()+"</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("</ul>");
			tmp.append("</div>");//card-body
			tmp.append("</div>");//card card-block card-stretch card-height
			tmp.append("</div>");//col-lg-4 card-profile
		} else {
			tmp.append("<div class=\"col-lg-4 card-profile\">");
			tmp.append("<div class=\"card card-block card-stretch card-height\">");
			tmp.append("<div class=\"card-body\">");
			tmp.append("<div class=\"d-flex align-items-center mb-3\">");
			tmp.append("<div class=\"profile-img position-relative\">");
			tmp.append("<img src=\"../assets/images/user/1.jpg\" class=\"img-fluid rounded avatar-110\" alt=\"profile-image\">");
			tmp.append("</div>");
			tmp.append("<div class=\"ml-3\">");
			tmp.append("<h4 class=\"mb-1\">Ruben Dokidis</h4>");
			tmp.append("<p class=\"mb-2\">UI/UX Designer</p>");
			tmp.append("<a href=\"#\" class=\"btn btn-primary font-size-14\">Contact</a>");
			tmp.append("</div>");
			tmp.append("</div>//d-flex align-items-center mb-3");
			tmp.append("<p>");
			tmp.append("I’m a Ux/UI designer. I spend my whole day, ");
			tmp.append("practically every day, experimenting with new ");
			tmp.append("designs, making illustartion, and animation.");
			tmp.append("</p>");
			tmp.append("<ul class=\"list-inline p-0 m-0\">");
			tmp.append("<li class=\"mb-2\">");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z\" />");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M15 11a3 3 0 11-6 0 3 3 0 016 0z\" />");
			tmp.append("</svg>");
			tmp.append("<p class=\"mb-0\">Calefornia, U.S.A</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("<li class=\"mb-2\">");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M21 13.255A23.931 23.931 0 0112 15c-3.183 0-6.22-.62-9-1.745M16 6V4a2 2 0 00-2-2h-4a2 2 0 00-2 2v2m4 6h.01M5 20h14a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z\" />");
			tmp.append("</svg>");
			tmp.append("<p class=\"mb-0\">SMCE Corp. Lead UI/UX Designer</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("<li class=\"mb-2\">");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M21 15.546c-.523 0-1.046.151-1.5.454a2.704 2.704 0 01-3 0 2.704 2.704 0 00-3 0 2.704 2.704 0 01-3 0 2.704 2.704 0 00-3 0 2.704 2.704 0 01-3 0 2.701 2.701 0 00-1.5-.454M9 6v2m3-2v2m3-2v2M9 3h.01M12 3h.01M15 3h.01M21 21v-7a2 2 0 00-2-2H5a2 2 0 00-2 2v7h18zm-3-9v-2a2 2 0 00-2-2H8a2 2 0 00-2 2v2h12z\" />");
			tmp.append("</svg>");
			tmp.append("<p class=\"mb-0\">March 25</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("<li class=\"mb-2\">");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M3 5a2 2 0 012-2h3.28a1 1 0 01.948.684l1.498 4.493a1 1 0 01-.502 1.21l-2.257 1.13a11.042 11.042 0 005.516 5.516l1.13-2.257a1 1 0 011.21-.502l4.493 1.498a1 1 0 01.684.949V19a2 2 0 01-2 2h-1C9.716 21 3 14.284 3 6V5z\" />");
			tmp.append("</svg>");
			tmp.append("<p class=\"mb-0\">+91 01234 56789</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("<li>");
			tmp.append("<div class=\"d-flex align-items-center\">");
			tmp.append("<svg class=\"svg-icon mr-3\" height=\"16\" width=\"16\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">");
			tmp.append("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z\" />");
			tmp.append("</svg>");
			tmp.append("<p class=\"mb-0\">JoanDuo@property.com</p>   ");
			tmp.append("</div>");
			tmp.append("</li>");
			tmp.append("</ul>");
			tmp.append("</div>");//card-body
			tmp.append("</div>");//card card-block card-stretch card-height
			tmp.append("</div>");//col-lg-4 card-profile
		}			
		return tmp;
	}
	
	private static StringBuilder viewWorkplaceProfile(
			Octet<	ArrayList<ShopObject>,
			Integer, 
			HashMap<Integer,Integer>, 
			HashMap<Integer,Integer>, 
			HashMap<Pair<String,Integer>,Integer> ,
			HashMap<Pair<String,Integer>,Integer>,
			HashMap<Triplet<Integer,Integer,String>,
					Triplet<ProductObject,Integer,Integer>>,
			HashMap<Integer,EmployeeObject>> datas, ShopObject eWorkplace, String url){
		StringBuilder tmp = new StringBuilder();		
		tmp.append("<div class=\"container-fluid\">"); 
		tmp.append("<div class=\"row\">");
		tmp.append("<div class=\"col-lg-12\">");
		tmp.append("<div class=\"row align-items-start justify-content-around\">");
	
		tmp.append("<div class=\"col-lg-12 row\">");
		tmp.append("<div class=\"col-lg-6\">");
		tmp.append("<table class=\"table d-table\">");
		tmp.append("<tbody class=\"w-100\">");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-4\">Mã đơn vị</th>");
		tmp.append("<td>"+eWorkplace.getWorkplace_id()+"</td>");
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-4\">Tên kho hàng</th>");
		tmp.append("<td>"+eWorkplace.getWorkplace_name()+"</td>");
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-5\">Phân loại</th>");
		if (eWorkplace.getWorkplace_type()==0) {
			tmp.append("<td>Kho hàng</td>");
		} else {
			tmp.append("<td>Cửa hàng</td>");
		}
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<tr>");
		tmp.append("<th>Liên kết Website</th>");
		tmp.append("<td>"+eWorkplace.getWorkplace_website_link()+"</td>");
		tmp.append("</tr>");
		tmp.append("</tbody>");
		tmp.append("</table>");
		tmp.append("</div> <!--  end col-lg-4 -->");
		tmp.append("<div class=\"col-lg-6\">");
		tmp.append("<table class=\"table d-table\">");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-6\">Ngày khởi tạo</th>");
		tmp.append("<td>"+eWorkplace.getWorkplace_created_date()+"</td>");
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-6\">Tình trạng</th>");
		if (eWorkplace.getWorkplace_status()==0) {
			tmp.append("<td>Đang hoạt động</td>");
		} else {
			tmp.append("<td>Đã ngừng hoạt động</td>");
		}
		tmp.append("</tr>");

		tmp.append("<tr>");
		tmp.append("<th class=\"col-6\">Khoản đầu tư</th>");
		tmp.append("<td>12</td>");
		tmp.append("</tr>");
		tmp.append("<tr>");
		tmp.append("<th>Lợi nhuận</th>");
		
		int importValue=0;
		int exportValue=0;
		if (datas.getValue2().get(eWorkplace.getWorkplace_id())==null) {
			importValue=0;
		} else {
			importValue= datas.getValue2().get(eWorkplace.getWorkplace_id());
		}
		
		if (datas.getValue3().get(eWorkplace.getWorkplace_id())==null) {
			exportValue=0;
		} else {
			exportValue= datas.getValue3().get(eWorkplace.getWorkplace_id());
		}
		
		int benefit=exportValue-importValue;
		
		tmp.append("<td>"+benefit+"</td>");
		tmp.append("</tr>");
		tmp.append("");
		tmp.append("</table>");
		tmp.append("</div> <!--  end col-lg-4 -->");
		tmp.append("<div class=\"col-lg-12\">");
		tmp.append("<table class=\"table d-table\">");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-lg-2 col-6\">Địa chỉ</th>");
		tmp.append("<td>"+eWorkplace.getWorkplace_address()+"</td>");
		tmp.append("</tr>");
		tmp.append("</table>");
		tmp.append("</div> <!--  end col-lg-12 -->");
		
		tmp.append("<div class=\"col-lg-12\">");
		tmp.append("<table class=\"table d-table\">");
		tmp.append("<tr>");
		tmp.append("<th class=\"col-lg-2 col-6\">Ghi chú</th>");
		tmp.append("<td>");
		tmp.append("<textarea class=\"form-control\">");
		tmp.append(eWorkplace.getWorkplace_notes());
		tmp.append("</textarea>");
		tmp.append("</td>");
		tmp.append("</tr>");
		tmp.append("</table>");
		tmp.append("</div> <!--  end col-lg-12 -->");
		tmp.append("</div>");
		tmp.append("</div> <!--  end row align-items-start justify-content-around -->");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		
		return tmp;
	}
	
	private static StringBuilder viewWorkplaceEditProfile(ShopObject eWorkplace, HashMap<Integer,EmployeeObject> managers , String url){
		StringBuilder tmp = new StringBuilder();		
		//Input tên
		
		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceName\" class=\"col-md-3 col-lg-2 text-lg-right col-form-label \">Tên chi nhánh:</label>");
			tmp.append("<div class=\"col-md-9 col-lg-10\">");
			tmp.append("<input class=\" form-control\" type=\"text\" value=\""+eWorkplace.getWorkplace_name()+"\" name=\"workplaceName\" id=\"workplaceName\">");
			tmp.append("</div>");
		tmp.append("</div>");

		
		//Input Phân loại và mã đơn vị
		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
			tmp.append("<label for=\"workplaceType\" class=\"col-md-3 col-lg-2 text-lg-right mb-3 mb-lg-1 col-form-label \">Phân loại:");
			tmp.append("</label>");
			tmp.append("<div class=\"col-lg-3 col-md-9 mb-3 mb-lg-0\">");
			tmp.append("<select class=\"form-control\" name=\"workplaceType\" id=\"workplaceType\">");
			tmp.append("<option value=\"0\">Kho hàng</option>");
			tmp.append("<option value=\"1\">Cửa hàng</option>");
			tmp.append("</select>");
			tmp.append("</div>");

			tmp.append("<label for=\"workplaceCode\" class=\"col-md-3 col-lg-2 text-lg-right col-form-label \">Mã đơn vị:");
			tmp.append("</label>");
			tmp.append("<div class=\"col-lg-5 col-md-9 \">");
			tmp.append("<input class=\"form-control\" type=\"text\"  id=\"workplaceCode\">");
			tmp.append("</div>");
		tmp.append("</div>");

		//Input người quản lý
		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceManager\" class=\"col-md-3 col-lg-2 text-lg-right col-form-label \">Người quản lý:</label>");
		tmp.append("<div class=\"col-lg-6 col-md-9\">");
		tmp.append("<select class=\"form-control\" id=\"workplaceManager\" name=\"workplaceManager\">");
		managers.forEach((eKey,eItem)->{
			if (eKey==eWorkplace.getWorkplace_manager_id()){
				tmp.append("<option class=\"form-control\" value=\""+eKey+"\" selected>"+eItem.getUser_fullname()+"</option>");
			} else {		
				tmp.append("<option class=\"form-control\" value=\""+eKey+"\">"+eItem.getUser_fullname()+"</option>");
			}
			
		});
		tmp.append("</select>");
		tmp.append("</div>");
		tmp.append("</div>");
		

		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceAddress\" class=\"col-md-3 col-lg-2 text-lg-right col-form-label \">Địa chỉ:</label>");
		tmp.append("<div class=\"col-md-9 col-lg-10\">");
		tmp.append("<input class=\" form-control\" type=\"text\" value=\""+eWorkplace.getWorkplace_address()+"\" name=\"workplaceAddress\" id=\"workplaceAddress\">");
		tmp.append("</div>");
		tmp.append("</div>");
	
		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceContact\" class=\"col-md-3 col-lg-2 text-lg-right mb-3 mb-lg-1 col-form-label \">Liên hệ:");
		tmp.append("</label>");
		tmp.append("<div class=\"col-lg-10 col-md-9\">");
		tmp.append("<div class=\"input-group\">");
		tmp.append("<input class=\" form-control\" type=\"text\" value=\""+eWorkplace.getWorkplace_phone()+"\" name=\"workplacePhoneNumber\" id=\"workplacePhoneNumber\">");
		tmp.append("<input class=\" form-control\" type=\"text\" value=\""+eWorkplace.getWorkplace_email()+"\" name=\"workplaceEmail\" id=\"workplaceEmail\">");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");

		tmp.append("<div class=\"row mb-3 mr-lg-5 align-items-center\">");
		tmp.append("<label for=\"workplaceNotes\"");
		tmp.append("class=\"col-md-3 col-lg-2 text-lg-right mb-3 mb-lg-1 col-form-label \">Ghi chú:</label>");
		tmp.append("<div class=\"col-lg-10 col-md-9\">");
		tmp.append("<textarea class=\"form-control\" type=\"text\" value=\""+eWorkplace.getWorkplace_notes()+"\" name=\"workplaceNotes\" id=\"workplaceNotes\"></textarea>");
		tmp.append("</div>");
		tmp.append("</div>");
		
		tmp.append("<button type=\"submit\" class=\"btn btn-primary\">Xác nhận</button>");
		return tmp;
	}
	
	private static StringBuilder viewWorkplaceStorage(
			Octet<	ArrayList<ShopObject>,
			Integer, 
			HashMap<Integer,Integer>, 
			HashMap<Integer,Integer>, 
			HashMap<Pair<String,Integer>,Integer> ,
			HashMap<Pair<String,Integer>,Integer>,
			HashMap<Triplet<Integer,Integer,String>,
					Triplet<ProductObject,Integer,Integer>>,
			HashMap<Integer,EmployeeObject>> datas){
		StringBuilder tmp = new StringBuilder();		
		//Input tên	
		tmp.append("<table id=\"myTable\" class=\"display table-striped data-table dataTable\">");
		tmp.append("<thead>");
		tmp.append("<tr>");
		tmp.append("<th></th>");
		tmp.append("<th>Tên sản phẩm</th>");
		tmp.append("<th>Mã sản phẩm</th>");
		tmp.append("<th>Giá bán</th>");
		tmp.append("<th>Số lượng</th>");
		tmp.append("</tr>");
		tmp.append("</thead>");
		tmp.append("<tbody>");
		
		datas.getValue6().forEach((key,value)->{
			tmp.append("<tr>");
			tmp.append("<td>");
//			tmp.append("<input class=\"form-check-input\" type=\"checkbox\" value=\""+key+"\">");
			tmp.append("</td>");
			tmp.append("<td>"+value.getValue0().getProduct_name()+"</td>");
			tmp.append("<td>"+key.getValue0()+"</td>");
			tmp.append("<td>"+value.getValue1()+"</td>");
			tmp.append("<td>"+value.getValue2()+"</td>");
			tmp.append("</tr>");
		});
		tmp.append("</tbody>");
		tmp.append("</table>");	
		tmp.append("<input type=\"text\" class=\"wpsdString\" name=\"wpsdString\" hidden>");
		tmp.append("<button type=\"submit\" class=\"btn btn-primary\">Xác nhận</button>");
		return tmp;
	}
}
