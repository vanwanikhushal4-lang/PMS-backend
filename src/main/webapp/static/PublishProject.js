

window.onload = function()
{
	// Variable to handle the delay in search
	$('#spin12').show();
	var to = false;

	// Event handler for keyup on the input element with id 'ricerca-enti'
	$('#ricerca-enti').keyup(function() {
	  // Clear the previous timeout
	  if (to) {
	    clearTimeout(to);
	  }

	  // Set a new timeout for search after a delay
	  to = setTimeout(function() {
	    // Get the value from the input
	    var v = $('#ricerca-enti').val();
	    
	    // Perform jstree search
	    $('#test').jstree(true).search(v);
	  }, 250);
	});
	
	
	

	// Get the base URL from the window location
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	
//	var serviceUrl = base_url + "/PMS/getProjectDetails";
	var serviceUrl = base_url + "/PMS/getProjectDetails1";

	// AJAX request to get project details
	$.ajax({
	  url: serviceUrl,
	  type: 'post',
	  dataType: 'json',
	  success: function(data) {
//		  alert("success");
		  $('#spin12').hide();
//		alert( JSON.stringify(data))
		
		
		

	
	    // JSTree Initialization
	  $("#test").on("changed.jstree", function(e, data) {}).on("select_node.jstree", function(e, data) {
        // Assuming the project ID is stored in the node's text
    	
		  
		  var text = data.node.text;
		    var customerNameMatch = text.match(/^Customer Name: (.*?) \(/);
		    var customerName = customerNameMatch ? customerNameMatch[1].trim() : '';

		    // Log the extracted customer name
		    console.log("Extracted customer name:", customerName);
    	
//    	 var projectId = decodeURIComponent(data.node.text);
//
//    	    // Accessing other relevant data from the node
//    	    var nodeData = {
//    	        projectId: projectId,
//    	        parent: data.node.parent,
//    	        id: data.node.id,
//    	        // Add other properties you want to capture from the node
//    	    };
		    
	    	 var projectId = decodeURIComponent(customerName);

	    	    // Accessing other relevant data from the node
	    	    var nodeData = {
	    	        projectId: projectId,
	    	        parent: data.node.parent,
	    	        id: data.node.id,
	    	        // Add other properties you want to capture from the node
	    	    };
		  
		  
		  

    	   
    	    // Log the entire data object for the clicked node
//   	    alert("Clicked Node Data:", data.node.parent);
   	 
    	 
//        var projectId = decodeURIComponent(data.node.text);
	      var projectId = decodeURIComponent(customerName);
      
//   alert("nin"+data.node.parent)
//   alert("id"+JSON.stringify(data.node.text))
//        var input = JSON.stringify(data.node.text);
	      var input = JSON.stringify(customerName);
   


     // Split the input string using " : " as the delimiter
     var parts = input.split(" : ");

     // Extract the second part which contains the customer name
     if (parts.length > 1) {
         var customerName = parts[1].trim();
         customerName = customerName.slice(0, -1);
         
        
//         alert("Customer Name: " + customerName);
     } else {
    	 
     }
      

	        // Check if the selected node is a child node tool8

//
//	        if (data.node.parent =='tool1' ||data.node.parent =='product2'||data.node.parent =='product3'||data.node.parent =='tool15'||
//	        		data.node.parent =='product5'||data.node.parent =='product6'||data.node.parent =='tool43'||data.node.parent =='tool22'||
//	        		data.node.parent =='tool36'||data.node.parent =='product8'||data.node.parent =='product9'||data.node.parent =='tool64'||
//	        		data.node.parent =='product11'||data.node.parent =='product12'||data.node.parent =='tool85'||data.node.parent =='product14'||
//	        		data.node.parent =='product15'||data.node.parent =='tool99'||data.node.parent =='tool106'||data.node.parent =='product17'||
//	        		data.node.parent =='product18'||data.node.parent =='tool120'||data.node.parent =='tool127'||data.node.parent =='product20'||
//	        		data.node.parent =='product21'||data.node.parent =='tool141'||data.node.parent =='tool148'||data.node.parent =='product23'||
//	        		data.node.parent =='product24'||data.node.parent =='tool162'||data.node.parent =='tool3'||data.node.parent =='tool2'||
//	        		data.node.parent =='tool8'||data.node.parent =='tool14'||data.node.parent =='tool21'||data.node.parent =='tool4'||
//	        		data.node.parent =='tool8' || data.node.parent =='tool17' || data.node.parent =='tool25') 
	        if(/^tool\d+$/.test(data.node.parent)){
//	        	alert("inside");
	          // Redirect to the JSP page with the selected project ID
	        	var l = window.location;
	        	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	        	var serviceUrl = base_url + "/PMS/getApprovePO";
	        	var custname = customerName;
//	        	alert("custnmae"+custname)

	        	$.ajax({
	        		type : 'POST',
	        		url : serviceUrl,
	        		dataType : 'json',
	        		data : 'approvePO=' + custname,
	        		
	        		success : function(data4) {
//	        			alert("data4"+data4[0][0]);
	        			if(data4[0][0].includes("PO-")){
//	        				alert("in")
	        			window.location.href = base_url + "/User/PMSProjectDetails?projectId=" + customerName;
	        			}
	        			else
	        				{
	        				swal({
	        					title : "Warning",
	        					text : "Data Not Available for this Customer!",
	        					type : "warning",
	        					width : 300,
	        					height : 200,
	        					buttons : false,
	        					allowOutsideClick : false,
//	        					preConfirm : function() {
//	        						var l = window.location;
//	        						var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	        						window.location.href = base_url	+ "/Admin/PMS";
//	        					}

	        				});				
	        				}
	        		}
	        	});
	        	
	          
	        } else {
//	        	alert("inside else");
	        }
	      })
	      .jstree({
    plugins: ['search', 'changed', 'contextmenu'],
    contextmenu: {
        select_node: false,
        items: contextMenu
    },
    checkbox: {
        three_state: false
    },
    search: {
        show_only_matches: true
    },
    core: {
        data: data
    }
})



	    // Context menu function
	    function contextMenu(node) {
	      var items = {};
	      if (node.children.length > 0) {
	        items.selezionaTutti = {
	          action: function(questo) {}
	        };
	      }
	      return items;
	    }
	  }
	});
}
  