window.onload = function() {
    // alert("ggggg")
      //$('#listing').hide();

	 var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/getCompositecompanyDetails";
//	      var serviceUrl = "getDepartmentDetails";
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
//	         data: 'companyname=' + $("#cname").val(),
	         success: function(data4) {
//	             alert(data4)
//	            var pollingHost = data4;
//	                    var d = pollingHost.split(",");
//	                    var length = d.length - 1;
	        	 var html = "<option value=''>-- Please Select --</option>";
	                    for (var i = 0; i < data4.length; i++) {
//	                        alert(data4[i]);
	                        html += '<option value="' + data4[i] + '">' + data4[i]
	                                + '</option>';
	                    }

	                    document.getElementById("cname").innerHTML = html;
	                    document.getElementById("cnameupdate").innerHTML = html;
	             }

	             
	     });
	     
	     var table = $('#datatype').DataTable({
             lengthChange: false,
//             data: data4,
             scrollX: true,
             scrollY: true,
//             columnDefs: [
//                 { "orderable": false, "targets": 'no-sort' }
//             ],
//              "pageLength": 5,
         });
	     
//	     var l = window.location;
//		  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		  	var serviceUrl = base_url + "/Master/ViewAllADUsers";
////		     var serviceUrl = "CompanyDetails";
//		     $.ajax({
//		         type: 'POST',
//		         url: serviceUrl,
//		         dataType: 'json',
//		         data: 'companyname=' + $("#cname").val(),
//		       
//		         success: function(data4) {
//		        	 $("#datatype").DataTable().destroy()
//		             var table = $('#datatype').DataTable({
//		                 lengthChange: false,
//		                 data: data4,
//		                 scrollX: true,
//		                 scrollY: true,
//		                 columnDefs: [
//		                     { "orderable": false, "targets": 'no-sort' }
//		                 ],
//		                  "pageLength": 5,
//		             });
//
//		             table.buttons().container()
//		                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');
//
//		         }
//
//		     });

 };
// function getuserDetails() {
////   alert($("#cname").val());
//	  var l = window.location;
//	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	 	var serviceUrl = base_url + "/Master/getUserDetails";
// 
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json',
//        data: 'companyname=' + $("#cname").val(),
//        success: function(data4) {
////            alert(data4)
////           var pollingHost = data4;
////                   var d = pollingHost.split(",");
////                   var length = d.length - 1;
//                   var html = "  <option value=''> -- Please Select --</option>";
//                   html += "  <option value='all'>All</option>";
//                
//                   for (var i = 0; i < data4.length; i++) {
////                       alert(data4[i]);
//                       html += '<option value="' + data4[i] + '">' + data4[i]
//                               + '</option>';
//                   }
//
//                   document.getElementById("uname").innerHTML = html;
//            }
//
//            
//    });
//   
//}
 function getlistDetails() {
  //alert($("#cname").val());
  //alert($("#uname").val());
	 //$('#listing').show();
	 var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/ViewAllADUsers";
//	     var serviceUrl = "CompanyDetails";
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
	         data: 'companyname=' + encodeURIComponent($("#cname").val()),
	       
	         success: function(data4) {
	        	 $("#datatype").DataTable().destroy()
	             var table = $('#datatype').DataTable({
	                 lengthChange: false,
	                 data: data4,
	                 scrollX: true,
	                 scrollY: true,
	                 columnDefs: [
	                     { "orderable": false, "targets": 'no-sort' }
	                 ],
	                  "pageLength": 5,
	             });

	             table.buttons().container()
	                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

	         }

	     });
   
}

 var sr;
 function EditUser(srno,username,name,utypes,email,phone,cname)
 {
	 sr=srno;
	// alert(srno+"--"+username+"--"+name+"--"+email+"--"+phone)
	 $('#username').val(username);
	 $('#name').val(name);
	 $('#mail').val(email);
	 $('#contact').val(phone);
	 $('#cnameupdate').val(cname);
	 $("#modeledituser").modal("show");
	 
	 
	 
 }
 
 
 function updateuser()
 {
	 //alert("hii="+sr);
	 var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/updateuser";
	 
	 $.ajax({
         type: 'POST',
         url: serviceUrl,
         data: 'id=' + sr 
         +'&utype=' + $('#utype').val() 
         +'&name=' + $('#name').val() 
         +'&mail=' + $('#mail').val() 
         +'&contact=' + $('#contact').val() 
         +'&username=' + $('#username').val() 
         +'&cname=' + encodeURIComponent($('#cnameupdate').val()) 
        
     }).done(function (data) {
    	// alert("data="+data)
         if (data == "success") {
             swal({
                 title: "Successfully!",
                 text: "User Type Set Succussfull",
                 type: "success",
                 width: 300,
                 height: 200,
              
                 confirmButtonClass: "btn btn-success",
              
                 confirmButtonText: "OK",
                 preConfirm: function () {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/manageAduser";
                 }
             })
         }


         else if (data == "duplicate") {
             swal({
                 title: "Exist!",
                 text: "Data Already Exist!",
                 type: "warning",
                 width: 300,
                 height: 200,
                 showCancelButton: !0,
                 confirmButtonClass: "btn btn-success",
                 cancelButtonClass: "btn btn-danger m-l-10",
                 confirmButtonText: "OK",
                 preConfirm: function () {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/manageAduser";
                 }
             })
         }


         else {

             swal({
                 title: "Unsuccessfull!",
                 text: "Record not updated!",
                 type: "error",
                 width: 300,
                 height: 200,
                 showCancelButton: !0,
                 confirmButtonClass: "btn btn-danger",
                 cancelButtonClass: "btn btn-danger m-l-10",
                 confirmButtonText: "OK",
                 preConfirm: function () {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/manageAduser";
                 }
             })
         }

     });
	 
 }