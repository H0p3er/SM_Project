document.addEventListener("DOMContentLoaded", function(){
	$().ready(function() {
		let series = new Array();
		let label = new Array();
	    // Function to fetch data without reloading the page
	    function fetchData() {
	        $.ajax({
	            url: "/home/shop/profile",
	            method: "GET",
	            dataType: "json",
	            success: function(response) {
					let data = response;
					console.log(data);
					if (document.getElementById("shop-name")!==null){
						if (data.shop_name===null || data.shop_name==="" || data.shop_name==="null"){
							$("#product-list").html("Tên không tồn tại");
						} else {
							$("#shop-name").html(data.shop_name);  // Update content without reloading
						}
	
					}
					
					if (document.getElementById("shop-images")!==null){
					 	$("#shop-images").html(data.shop_image); // Update content without reloading
					}
					
					if (document.getElementById("shop-notes")!==null){
					 	$("#shop-notes").html(data.shop_note); // Update content without reloading
					}	
					
					if (document.getElementById("shop_statistic_overview")!==null){
					 	$("#shop_statistic_overview").html(data.statistic_overview); // Update content without reloading
					}	
			
					series = JSON.parse(data.series);
					label = JSON.parse(data.label);
				
								
					if (document.getElementById("donutChart")!==null){
						
					var chart = new ApexCharts(document.querySelector("#donutChart"), {
					  series: series,
					  chart: {
						height: 350,
						type: 'donut',
						toolbar: {
						  show: true
						}
					  },
					  labels: label,
					  noData: {
						  text: 'Loading...'
						}
					}).render();
				  }
									
					
					if (document.getElementById("product-list")!==null){
						if (data.product_list===null || data.product_list===""){
							$("#product-list").html("<p>Không tìm được dữ liệu</p>");
						} else {
							$("#product-list").html(data.product_list); // Update content without reloading
						}
					}
					
			   
	            }
	        });
	        
	        let product_edit_action = document.getElementsByClassName("product-edit-action");    
	        for (var item of product_edit_action){
				item.addEventListener("click",()=>{
					$.ajax({
						url: "/home/shop/profile?edit=?",
						method: "POST",
						dataType: "json",
						success: function(response) {
							let data = response;			
						},
						false: function(response){
				
						},
					});
				});
			}

			let product_del_action = document.getElementsByClassName("product-edit-action");
			for (var item of product_del_action){
				item.addEventListener("click",()=>{
					$.ajax({
						url: "/home/shop/profile?del=?",
						method: "POST",
						dataType: "json",
						success: function(response) {
							let data = response;			
						},
						false: function(response){
				
						},
					});
				});
			}
			
	    }
	
	    // Call fetchData() initially to load data on page load
	    fetchData();
	    
	    // Call fetchData() every 30 seconds to refresh content
	    setInterval(fetchData, 300000); // 30 seconds
	});
	
	
	// forEach(element => {
	// 	element.addEventListener("",)
	// });

});
	
  
