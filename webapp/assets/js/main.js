if (document.getElementById("product-list")!==null){
	$().ready(function() {
	    // Function to fetch data without reloading the page
	    function fetchData() {
	        $.ajax({
	            url: "/home/shop/product",
	            method: "GET",
	            success: function(response) {
	                $("#product-list").html(response); // Update content without reloading
	            }
	        });
	    }
	
	    // Call fetchData() initially to load data on page load
	    fetchData();
	
	    // Call fetchData() every 5 seconds to refresh content
	    setInterval(fetchData, 5000); // 5 seconds
	});
}

  
