 /* global Highcharts */

window.onload = function() {
    
    $("#form1").show();
    $("#dataSet1").hide();

    getmultiselect();
    gettidmulti();
    
 ////////////////////////GETTING ONLOAD COMPANY STARTS//////////////   
 
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/getCompany"; 
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        
         dataType: 'json',
    }).done(function(data) {
    	 
    	var html = "   <select class='form-control' tabindex='2' id='companyname' name='companyname'  multiple='multiple'  onchange='onchangecompany()'>";
        var ind, ip, atmid, len;
        for (var i = 0; i < data.length; i++) {

            ip = data[i];
    //    alert(ip)
            html += '<option value="' + ip + '">' + ip
                    + '</option>';
        }

        html += "</select>";
            
        document.getElementById("companydiv1").innerHTML = html;
     
        getmultiselect();

    });
    
    ////////////////////////GETTING ONLOAD COMPANY END//////////////   

 };
 
 
 function getmultiselect(){
	    $("#companyname").multiselect({
	        includeSelectAllOption: true,
	        buttonWidth: '100%',
	        enableCaseInsensitiveFiltering: true,
	      //  enableFiltering: true,
	        maxHeight: 200,
	        onDropdownShow : function() {
				ToolTip('companydiv1', 'destroy');
			},
			onDropdownHide : function() {
				if ($('#companyname').find(":selected").text() === "") {
					ToolTip('companydiv1', 'show');
			    } else {
			    	ToolTip('companydiv1', 'hide');
			    }
			}
	    });
 }
 

 function gettidmulti(){
	    $("#tid").multiselect({
	        includeSelectAllOption: true,
	        buttonWidth: '100%',
	        enableCaseInsensitiveFiltering: true,
	      //  enableFiltering: true,
	        maxHeight: 200,
	        onDropdownShow : function() {
				ToolTip('tiddiv', 'destroy');
			},
			onDropdownHide : function() {
				if ($('#tid').find(":selected").text() === "") {
					ToolTip('tiddiv', 'show');
			    } else {
			    	ToolTip('tiddiv', 'hide');
			    }
			}
	    });
 }
 


	 

	 /////////////getting location bases on compamy starst////////////
 function onchangecompany()
 {
	 var FromDate = $("#FromDate").val();
	    var ToDate = $("#ToDate").val();
//	 alert("hi");
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/getProblemTicketId";
	    

	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',	
	        data:"companyis="+encodeURIComponent($("#companyname").val())+
	         '&FromDate=' + FromDate
                + "&ToDate=" + ToDate,
   
 
 
	    }).done(function(data) {

	      var html = " <select class='form-control' tabindex='2' id='tid' name='tid'  multiple='multiple' >";
	      var ind, ip, atmid, len;
	      for (var i = 0; i < data.length; i++) {

	          ip = data[i];

	          html += '<option value="' + ip + '">' + ip
	                  + '</option>';
	      }

	      html += "</select>";

	      document.getElementById("tiddiv").innerHTML = html;
	      gettidmulti();

	  });

	
 
 
 }
//from Date picker
    $('#FromDate').datetimepicker({
    	
        autoclose: true,
        format: 'dd-mm-yyyy hh:ii',
        todayHighlight: !0,
        orientation:"bottom",
        endDate: new Date()
        
   }).on('change', function() {
//     callToolTip59('ToDate', 'hide');
	   $(this).focus();
	       });

    // to Date picker 
    
    $('#ToDate').datetimepicker({
        autoclose: true,
        format: 'dd-mm-yyyy hh:ii',
        todayHighlight: !0,
         orientation:"bottom",
         endDate: new Date()
    }).on('change', function() {
//      callToolTip59('ToDate', 'hide');
    	$(this).focus();
    	    });

$("#submit-btn").click(function() {
////     alert("dgfsgf");
    if (!ValidateGetUserReport()) {
//        alert("in invalid");
        event.preventDefault();
    } else {

        getUserReport();
    }
	
	
});

//Get Report Of CPU Device

function getUserReport() {
//alert("in getUserReport");
    $("#form1").hide();
    $("#dataSet1").show();

    var FromDate = $("#FromDate").val();
    var ToDate = $("#ToDate").val();
 
 
    
     var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/TPActivity/GetTicketTrackingReportInProblem";
   //  alert($("#tid").val());

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'FromDate=' + FromDate
                + "&ToDate=" + ToDate
               + '&tid=' + encodeURIComponent($("#tid").val()),
               
        success: function(data5) {
            console.log(data5)
            $('#loading').hide();
            $("#preLoader").hide();
        	$("#Listing_Userwise").removeClass("d-none");
            document.getElementById("fromD").innerHTML = FromDate;
            document.getElementById("toD").innerHTML = ToDate;
            var table = $('#Listing_Userwise').DataTable({
               //                lengthChange: false,
               "lengthMenu":[
                    [5,10,25,50,-1],
                    [5,10,25,50,'Show all']
                ],
                data: data5,
                dom: 'Bflrtip',
                destroy: true,
                scrollX: true,
                buttons: [
                    {
                        extend: 'print',
                        exportOptions: {
                            columns: ':visible',
                            search: 'applied',
                            order: 'applied'
                        }
                    },
                    {
                        extend: 'copy',
                        exportOptions: {
                            columns: ':visible',
                            search: 'applied',
                            order: 'applied'
                        }
                    },
                    {
						extend: 'excel',
						title:'',
						exportOptions: {
							columns: ':visible',
							search: 'applied',
							order: 'applied'
						} 
					   
					},
                    {
                        extend: 'pdf',
                        pageSize: 'A4',
                        orientation: 'landscape', //landscape
                        messageTop: '',
                        filename: function() {

                            return 'Ticket Tracking Report';

                        }, customize: function(doc) {
                            doc.content.splice(0, 1);
                            var now = new Date();
                            var jsDate = now.getDate() + '-' + (now.getMonth() + 1) + '-' + now.getFullYear();
                            var logo = 'data:image/jpeg;base64,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MC666CISZW2m11w2LZHonmEIrusiIkQiEaZMmcI111zTbmwA119//S7ff/myd2X+/PmICNf9/Kd74hV3iG19y0wmI67rrTXHcbBtm379+lFWtuctOXurv7u7aGcPjEajgV/Ax9HHHKuuvfZaLMsim82yceNGlixZsqfHvU34km530Z2P60dY/rsXQn3dFnn11VcpKytDKcWpp55KeUUfBVDZr78677zz0HUd0zSpr6/nlb+/tFtC1Tu+1ycdAt/c3MxLL73Eyy+/zNtvv/2JPLP0HS+6+FJ1+OGHE41GOeyww/ja174WnLdhwwYee+wxnnvuOVauXBn8/XOfP0addtpphEIhRo0axUUXXbRbx7czay0UCmEYni8Y6MRY9hTTAwJ/ez6fx7KsTmP7V5HNZnnllVdYvnw577zzDrlsuselb2zrW8ZiMZVIJNTVV1/NpEmTqKys5MILL9zuvVKpT6byzX8y04MSjc+yLPL5PLqudzKLfPGLX+T3v/89GzZswLIsXn755d0+kJ0NKtgRdpYB9gS89dZbgeSnlOLQQw9td/zII4+ktbWVWCyGZVm8//77273fjqS21tZWKS8v73R8RyaW3S0NiuMQMgxc10XX9U/EZFX6jpl0UmJxT8r+cMVH/PmutkAQy7KIx+Pkcp52V4orr7ySn8z/qVqxYgVDhw7dqednMhnZXaYsEScQWLUetuQ1TcMwDASFaZq7/f75fJ54JEqyuQXlSreZfCaTklhs99GbXUXHvXTuuedu93yfRnY35akXXSPQ+OLxOCIShByXIlFWoWbMmIGmaYRCIZYsWdLtmnvZbLZb5+0uplc69r2N8S1btox4PE42myWRSNC3b992x2PlFWrfffelUCigaRorVqzY5r0ymcwOmVNHppdMJrs1YbtbGjQMA9u2A19yd5hed9dVKbYlLftMryvE43FaWlrQNK2dJQTaNKkdSeHpdGctZFtMr7vfoBSu6+K6bltgSw+C4zjB+JRSpFOt/9Km7GSNcNzSY9u9tlQb3BWm9++whOzqXtpVprcr++Y/EcEusSyLQqHQaXP7GDVqFIVCgUKhwNq1a4luY+HU1tbKokWLpKamRqB7H7aUcGzvw2QyGVmyZIl88MEH0hUxAY/xlf50RZSSyaQ0NDTI4sWLpaGhQbZHbDou9hUrVkhNTc12r2ltbZXa2lpZunSp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';
                           doc.pageMargins = [20, 50, 20, 40];
                            doc.defaultStyle.fontSize = 9;
                            doc.styles.tableHeader.fontSize = 9;
                            doc['header'] = (function() {
                                return {
                                    columns: [
                                        {
                                            image: logo,
                                            width: 55
                                        },
                                        {
                                            alignment: 'center',
                                            italics: true,
                                            text: 'User Wise Report',
                                            fontSize: 18,
                                            margin: [10, 0]
                                        },
                                        {
                                            alignment: 'right',
                                            fontSize: 14,
                                            text: jsDate
                                        }
                                    ],
                                    margin: 20
                                }
                            });
                            doc['footer'] = (function(page, pages) {
                                return {
                                    columns: [
                                        {
                                            alignment: 'left',
                                            text: ['Created on: ', {text: jsDate.toString()}]
                                        },
                                        {
                                            alignment: 'right',
                                            text: ['page ', {text: page.toString()}, ' of ', {text: pages.toString()}]
                                        }
                                    ],
                                    margin: 12
                                }
                            });
                            var objLayout = {};
                            objLayout['hLineWidth'] = function(i) {
                                return .5;
                            };
                            objLayout['vLineWidth'] = function(i) {
                                return .5;
                            };
                            objLayout['hLineColor'] = function(i) {
                                return '#aaa';
                            };
                            objLayout['vLineColor'] = function(i) {
                                return '#aaa';
                            };
                            objLayout['paddingLeft'] = function(i) {
                                return 4;
                            };
                            objLayout['paddingRight'] = function(i) {
                                return 4;
                            };
                            doc.content[0].layout = objLayout;
                        },
                        exportOptions: {
                            columns: ':visible',
                            search: 'applied',
                            order: 'applied'
                        }
                    }, "colvis"]
            });

            table.buttons().container()
                    .appendTo('#Listing_Userwise_wrapper .col-sm-6:eq(0)');
//                        .appendTo( $('.col-sm-6:eq(0)', table.table().container() ) );

        }

    });
}

//Validate Method

function ValidateGetUserReport() {
  
    var a = $('#FromDate').val().split(" ")[0];
    var b = $('#ToDate').val().split(" ")[0];
  
//    alert(a)
//       alert(b)

    indexError = 0;

    var date = a.substring(0, 2);
    var month = a.substring(3, 5);
    var year = a.substring(6, 10);

    var myDate = new Date(year, month - 1, date);
    var today = new Date();
    //  alert(myDate);

    var date1 = new Date(a.split('-')[2], a.split('-')[1], a.split('-')[0]);
    //alert(today);

    var date2 = new Date(b.split('-')[2], b.split('-')[1], b.split('-')[0]);

//alert(date1)
//alert(date2)
    if (date1 > date2) {
//        alert("To Date should be Greater than From Date")
//        $.swal({
//            text: "To Date should be Greater than From Date",
//            width: 200
//        });
         swal({
                    title: "Invalid!",
                    text: "To Date should be Greater than From Date",
                    type: "warning",
                    width: 300,
                    height: 200,
//                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-danger",
//                    cancelButtonClass: "btn btn-danger m-l-10",
                    confirmButtonText: "OK",
                   

                })
        indexError = indexError + 1;
    }


    if ($('#FromDate').val().trim() === '') {
        ToolTip('FromDate', 'show');
        indexError = indexError + 1;
    }

    if ($('#ToDate').val().trim() === '') {
        ToolTip('ToDate', 'show');
        indexError = indexError + 1;
    }

    

    
    if ($('#companyname').val() === '' || $('#companyname').val().length==0) {
        ToolTip('companydiv1', 'show');
        indexError = indexError + 1;
    }
    if ($('#tid').val() === '' || $('#tid').val().length==0) {
        ToolTip('tiddiv', 'show');
        indexError = indexError + 1;
    }


    if (indexError > 0) {
        return false;
    } else {
        return true;
    }

}

//Tooltip Method

function ToolTip(fieldName, status) {

    if (fieldName === "FromDate") {
        var errorMessage = "<span>Please Select From Date<span>";
    }
    if (fieldName === "ToDate") {
        var errorMessage = "<span>Please Select To Date<span>";
    }



    if (fieldName === "companydiv1") {
        var errorMessage = "<span>Please Select Company<span>";
    }


    if (fieldName === "tiddiv") {
        var errorMessage = "<span>Please Select Ticket Id<span>";
    }



    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });

    if (status === "show") {
        $("#" + fieldName).tooltip('show');

    } else {
        $("#" + fieldName).tooltip('hide');
    }
}


$('#FromDate').on('focus', function() {
    ToolTip('FromDate', 'destroy');
});
$('#ToDate').on('focus', function() {
    ToolTip('ToDate', 'destroy');
});

//Reset Button Click

$("#resetbtn").click(function() {
	ToolTip('ToDate', 'destroy');
	ToolTip('FromDate', 'destroy');

	ToolTip('companydiv1', 'destroy');
	 ToolTip('statusid', 'destroy');
	 ToolTip('locationiddiv', 'destroy');
	 ToolTip('user_name1', 'destroy');
	 
	 
  
	$('#FromDate').val("");
	$('#ToDate').val("");
  
	
	$("#tid option:selected").prop("selected", false);
	$("#tid").multiselect('refresh');

	$("#companyname option:selected").prop("selected", false);
	$("#companyname").multiselect('refresh');


});
