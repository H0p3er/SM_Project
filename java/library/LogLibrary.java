package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.javatuples.*;

import constant.LOG_SORT_TYPE;
import entity.BillObject;
import entity.EmployeeObject;
import entity.LogObject;
import utility.Utilities;
import utility.Utilities_date;


public class LogLibrary {
	
	public static ArrayList<String> viewLog(
			Pair<ArrayList<LogObject>,Integer> datas, 
			Sextet<EmployeeObject, 
			LogObject, 
			Short, 
			Byte ,
			LOG_SORT_TYPE,
			Boolean> infors, String url){
		ArrayList<String> view = new ArrayList<String>();
	
		int lTotal = datas.getValue1();
		short lPage = infors.getValue2(); 
		byte lPerPage = infors.getValue3();
		
		ArrayList<LogObject> lItems = datas.getValue0(); 

		StringBuilder tmp = new StringBuilder();
		tmp.append("<div class=\"iq-timeline0 m-0 d-flex align-items-center justify-content-between position-relative\">");
		tmp.append("<ul class=\"list-inline p-0 m-0\">");
		lItems.forEach((item)-> {
			String summary ="";
			String icon="";
			String notes =item.getLog_username()+" đã ";
			switch (item.getLog_action()) {
				case 1:
					notes=notes+"thêm ";
					icon="<div class=\"timeline-dots1 border-primary text-primary\"><i class=\"ri-login-circle-line\"></i></div>";
				break;
				
				case 2:
					notes=notes+"sửa ";
					icon="<div class=\"timeline-dots1 border-warning text-warning\"><i class=\"ri-book-open-fill\"></i></div>";
				break;
				
				case 3:
					notes=notes+"xóa ";
					icon="<div class=\"timeline-dots1 border-danger text-danger\"><i class=\"ri-delete-bin-line mr-0\" ></i></div>";
				break;
			}
			
			switch (item.getLog_position()) {
				case 1:
					notes+="1 hóa đơn";
					summary="Bảng hóa đơn";
				break;
				
				case 2:
					notes+="bảng";
					summary="Bảng chi tiết hóa đơn";					
				break;
				
				case 3:
					notes+="1 nhân viên";
					summary="Bảng nhân viên";
				break;
				
				case 4:
					notes+="bảng";
					summary="Bảng chi tiết hóa đơn";
				break;
				
				case 5:
					notes+="1 sản phẩm";
					summary="Bảng sản phẩm";
				break;
				
				case 6:
					notes+="bảng ";
					summary="Bảng nhà cung cấp";
				break;
				
				case 7:
					notes+="1 người dùng ";
					summary="Bảng người dùng";
				break;
				
				case 8:
					notes+="1 chi nhánh";
					summary="Bảng chi nhánh";
				break;			
			}
			tmp.append("<li>");
			tmp.append(icon);
			tmp.append("<h6 class=\"float-left mb-1\">"+summary+"</h6>");
			tmp.append("<small class=\"float-right mt-1\">"+item.getLog_created_date()+"</small>");
			tmp.append("<div class=\"d-inline-block w-100\">");
			tmp.append("<p>"+notes+"</p>");
			tmp.append("</div>");
			tmp.append("</li>");
		});
		tmp.append("</ul>");
		tmp.append("</div>");
		
		view.add(tmp.toString());
		
		view.add((LogLibrary.viewLogListPage(url,lPage,lPerPage,lTotal).toString()));

		view.add(LogLibrary.viewLogNotification(datas, infors, url).toString());
		return view;
	}
	
	public static StringBuilder viewLogNotification(
			Pair<ArrayList<LogObject>,Integer> datas, 
			Sextet<EmployeeObject, 
			LogObject, 
			Short, 
			Byte ,
			LOG_SORT_TYPE,
			Boolean> infors, String url){
		
		
		
		ArrayList<LogObject> lItems = datas.getValue0();
		int lTotal = datas.getValue1();
		StringBuilder tmp = new StringBuilder();
		
		
		tmp.append("<div class=\"cust-title p-3\">");
		tmp.append("<div class=\"d-flex align-items-center justify-content-between\">");
		tmp.append("<h5 class=\"mb-0\">Thông báo</h5>");
		tmp.append("<a class=\"badge badge-primary badge-card\" href=\"#\">"+lTotal+"</a>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("<div class=\"px-3 pt-0 pb-0 sub-card\">");
		lItems.forEach((item)->{
			tmp.append("<a href=\"#\" class=\"iq-sub-card\">");
			tmp.append("<div class=\"media align-items-center cust-card py-3 border-bottom\">");
			tmp.append("<div class=\"\">");
			tmp.append("<img class=\"avatar-50 rounded-small\"");
			tmp.append("src=\"/home/images/user/01.jpg\" alt=\"01\">");
			tmp.append("</div>");
			tmp.append("<div class=\"media-body ml-3\">");
			tmp.append("<div class=\"d-flex align-items-center justify-content-between\">");
			tmp.append("<h6 class=\"mb-0\">"+item.getLog_username()+"</h6>");		
			tmp.append("</div>");
			tmp.append("<div class=\"d-flex align-items-center justify-content-between\">");	
			tmp.append("<small class=\"text-dark\"><b>"+item.getLog_created_date()+"</b></small>");
			tmp.append("</div>");
			String notes =item.getLog_username()+" đã ";
			switch (item.getLog_action()) {
				case 1:
					notes=notes+"thêm mới ";
				break;
				
				case 2:
					notes=notes+"chỉnh sửa ";
				break;
				
				case 3:
					notes=notes+"xóa ";
				break;
			}
			
			
			switch (item.getLog_position()) {
				case 1:
					notes=notes+"1 hóa đơn";
				break;
				
				case 2:
					notes=notes+"1 nhân viên";
				break;
				
				case 3:
					notes=notes+"bảng";
				break;
				
				case 4:
					notes=notes+"bảng";
				break;
				
				case 5:
					notes=notes+"1 sản phẩm";
				break;
				
				case 6:
					notes=notes+"bảng";
				break;
				
				case 7:
					notes=notes+"1 người dùng ";
				break;
				
				case 8:
					notes=notes+"1 chi nhánh";
				break;			
			}
			
			tmp.append("<small class=\"mb-0\">"+notes+"</small>");
			tmp.append("</div>");
			tmp.append("</div>");
			tmp.append("</a>");
			tmp.append("");
		});
		tmp.append("</div>");
		tmp.append("<a class=\"right-ic btn btn-primary btn-block position-relative p-2\" href=\"/home/logList\"");
		tmp.append("role=\"button\">");
		tmp.append("Xem tất cả ("+lTotal+")");
		tmp.append("</a>");
		return tmp;
	}
	
	

	private static StringBuilder viewLogStatisticChart(Sextet<	ArrayList<LogObject>,
			Integer, 
			HashMap<Integer,Integer>, 
			HashMap<Integer,Integer>, 
			HashMap<Pair<String,Integer>,Integer> ,
			HashMap<Pair<String,Integer>,Integer>> datas, String chartName){	
		
		ArrayList<LogObject> workplaceList = datas.getValue0();
		HashMap<Integer,Integer> workplaceIncome = datas.getValue2();
		StringBuilder tmp = new StringBuilder();			
		StringBuilder NameString = new StringBuilder();
		StringBuilder IncomeString = new StringBuilder();		

		Iterator<LogObject> iterator = workplaceList.iterator();			
		while (iterator.hasNext()) {

			LogObject item = iterator.next();
			IncomeString.append(workplaceIncome.get(item.getLog_id()));
			NameString.append("'"+Utilities.decode(item.getLog_name())).append(" (").append(item.getLog_created_date()).append(")'");
			
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

	private static StringBuilder viewLogListPage(String url, short lPage, byte lPerPage ,int lTotal){
		StringBuilder tmp = new StringBuilder();
		
		int lTotalPage= lTotal/lPerPage;
			
		if ((lTotal%lPerPage!=0)) {
			lTotalPage++;
		}
		
		tmp.append("<div class=\"row justify-content-between my-3\">");
		tmp.append("<div id=\"user-list-page-info\" class=\"col-md-6\">");
		tmp.append("<span>Hiển thị "+lPerPage+" bản ghi trên "+lTotal+" bản ghi</span>");
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
		
		for (int i = lPage-1; i>0; i--) {
			leftCurrent = "<li class=\"page-item\"><a class=\"page-link\" href=\""+url+"?page="+i+"\">"+i+"</a></li>" + leftCurrent;
			if (++count>=2) {
				break;
			}
		}
		
		if (lPage>=4) {
			leftCurrent = "<li class=\"page-item\"><a class=\"page-link\" href=\"#\">...</a></li>" + leftCurrent;
			//		if (page>1) {
			//			leftCurrent = ("<li class=\"page-item\"><a class=\"page-link\" href=\""+()+"\"><span aria-hidden=\"true\">&laquo;</span></a></li>") + leftCurrent;
			//		}
		}
		tmp.append(leftCurrent);
		
		tmp.append("<li class=\"page-item active\" aria-current=\"page\"><a class=\"page-link\" href=\"#\">"+lPage+"</a></li>");
		
		//Right Current
		String rightCurrent = "";
		count=0;
		for (int i = lPage+1; i<=lTotalPage; i++) {
			rightCurrent += "<li class=\"page-item\"><a class=\"page-link\" href=\""+url+"?page="+i+"\">"+i+"</a></li>";
			if (++count>=2) {
				break;
			}
		}
		
		if (lTotalPage> lPage+4) {
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
	

}
