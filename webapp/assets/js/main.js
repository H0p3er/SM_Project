document.addEventListener("DOMContentLoaded", function(){
$().ready(function() {
	if (document.getElementById("donutChart")!==null){
   
	  var chart = new ApexCharts(document.querySelector("#donutChart"), {
	    series: [],
	    chart: {
	      height: 350,
	      type: 'donut',
	      toolbar: {
	        show: true
	      }
	    },
	    labels: [],
	    noData: {
	    	text: 'Loading...'
	  	}
	  }).render();
	}
	
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
				 	$("#shop-name").html(data.at(0)); // Update content without reloading
				}
				
				if (document.getElementById("shop-images")!==null){
				 	$("#shop-notes").html(data.at(1)); // Update content without reloading
				}
				
				if (document.getElementById("shop-notes")!==null){
				 	$("#shop-notes").html(data.at(2)); // Update content without reloading
				}
				
						
				if (document.getElementById("shop_statistic_overview")!==null){
				 	$("#shop_statistic_overview").html(data.at(5)); // Update content without reloading
				}    
				
				if (document.getElementById("product-list")!==null){
				 	$("#product-list").html(data.at(6)); // Update content without reloading
				}
				
		   
            }
        });
    }
    // Call fetchData() initially to load data on page load
    fetchData();
    
    // Call fetchData() every 30 seconds to refresh content
    setInterval(fetchData, 300000); // 30 seconds
});
	
});
	
  
