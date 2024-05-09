document.addEventListener("DOMContentLoaded", function(){
	$().ready(function() {

	    function fetchData() {
	        $.ajax({
				
	            url: "/home/product/",
	            method: "GET",
	            dataType: "json",
	            success: function(response) {
					let data = response;
							
	            }
	        });
			
	    }
	
	    // Call fetchData() initially to load data on page load
	    fetchData();
	    
	    // Call fetchData() every 30 seconds to refresh content
	    setInterval(fetchData, 300000); // 30 seconds
	});
});



