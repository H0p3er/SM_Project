document.addEventListener("DOMContentLoaded", function(){
	$().ready(function() {

	    function fetchData() {
	        $.ajax({
	            url: "/home/shop/order",
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
	
let search_element = document.getElementById("search");
let search_button_element = document.getElementById("search-button");

if (search_element!=null && search_button_element!=null){
	search_element.addEventListener("change",()=>{
		console.log(search_element.value);
		search_element.value = "search:"+search_element.value+";";
	});
}
