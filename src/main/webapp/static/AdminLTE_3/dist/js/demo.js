
/**
 * AdminLTE Demo Menu
 * ------------------
 * You should not use this file in production.
 * This file is for demo purposes only.
 */

var roleType = $("#role").val();
//alert("roleType "+roleType)

if(roleType === "Support_Manager" || roleType === "Head_Projects" || roleType === "Implementor" || roleType === "MD") {
	$("#navLinksSuppport").show(); 
	$("#SupportLogo").show(); 
	
} else if(roleType === "Developer" || roleType === "Tester") {
	$("#navLinksUser").show(); 
	$("#SupportLogo").show(); 

} else { 

	$("#MainLogo").show(); 
}

var designation = $("#designation").val();
var SIDEBARSCOPE = $("#SIDEBARSCOPE").val();

//var allowedRoles = ["MD", "Admin", "Sales_Initiator", "Sales_Manager", "Collection_Manager","Account_Manager","HR","Account","Sales","Head_Projects"];
var allowedRoles = ["Developer", "Tester", "Support", "Support_Manager", "Implementor"];


	if (allowedRoles.includes(roleType)) {
	  
	    $("#notification_icon").show();
	} else {
		$("#notification_icon").hide();
	}
	
	
var allowedRolesNotification = ["Developer","Tester","Support"];
var allowedDesignationNotification = ["Team Leader","Jr. Team Leader","Sr Team Leader"];
	if(allowedRolesNotification.includes(roleType) && !(allowedDesignationNotification.includes(designation)))
	{
		$("#revise_dates").hide();
		$("#reactivate_account").hide();
		$("#formC").hide();
		
	}
	else if(allowedRolesNotification.includes(roleType) && (allowedDesignationNotification.includes(designation)))
	{
		$("#formC").hide();
	}
	


(function ($) {
	bellNotification()
	
//	var roleType1 = $("#role").val();
//
//	var designation1 = $("#designation").val();
//
////	var allowedRoles = ["MD", "Admin", "Sales_Initiator", "Sales_Manager", "Collection_Manager", "Implementor", "Support_Manager","Account_Manager"];
//	var allowedRoles1 = ["MD", "Admin", "Sales_Initiator", "Sales_Manager", "Collection_Manager","Account_Manager","HR","Account","Sales","Head_Projects"];
//	
//	if (allowedRoles1.includes(roleType1) && 
//	        (SIDEBARSCOPE.includes("Home") || 
//	         SIDEBARSCOPE.includes("PMS") || 
//	         SIDEBARSCOPE.includes("View Login Activities") || 
//	         SIDEBARSCOPE.includes("Download Masked PO") || 
//	         SIDEBARSCOPE.includes("Update Profile") || 
//	         SIDEBARSCOPE.contains("Reset Password")))
//	{
//		alert("inside")
//		$("#notification_icon").hide();
//	}
	
	
  'use strict'

  var $sidebar   = $('.control-sidebar')
  var $container = $('<div />', {
    class: 'p-3 control-sidebar-content'
  })

  $sidebar.append($container)

  var navbar_dark_skins = [
    'navbar-primary',
    'navbar-secondary',
    'navbar-info',
    'navbar-success',
    'navbar-danger',
    'navbar-indigo',
    'navbar-purple',
    'navbar-pink',
    'navbar-navy',
    'navbar-lightblue',
    'navbar-teal',
    'navbar-cyan',
    'navbar-dark',
//    'navbar-gray-dark',
    'navbar-gray',
  ]

  var navbar_light_skins = [
//    'navbar-light',
    'navbar-warning',
//    'navbar-white',
    'navbar-orange',
  ]

  $container.append(
    '<h5>Customize UI</h5><hr class="mb-2"/>'
  )



  var $text_sm_body_checkbox = $('<input />', {
    type   : 'checkbox',
    value  : 1,
    checked: $('.nav-sidebar').hasClass('text-xs'),
    'class': 'mr-1'
  }).on('click', function () {
    if ($(this).is(':checked')) {
    	$('.nav-sidebar').removeClass('text-sm')
    	$('.nav-sidebar').addClass('text-xs')
    	$('.content-wrapper').removeClass('text-sm')
    	$('.content-wrapper').addClass('text-xs')
    	updateTheme("SmallBody","True");
    } else {
    	$('.nav-sidebar').removeClass('text-xs')
    	$('.nav-sidebar').addClass('text-sm')
    	$('.content-wrapper').removeClass('text-xs')
    	$('.content-wrapper').addClass('text-sm')
    	updateTheme("SmallBody","False");
    }
  })
  var $text_sm_body_container = $('<div />', {'class': 'mb-1'}).append($text_sm_body_checkbox).append('<span style="font-weight: 500; color: #fff; font-size: initial;">Body Small Text</span>')
  $container.append($text_sm_body_container)
  $container.append('<br>')

 

  $container.append('<h6>Header Variants</h6>')

  var $navbar_variants        = $('<div />', {
    'class': 'd-flex'
  })
  var navbar_all_colors       = navbar_dark_skins.concat(navbar_light_skins)
  var $navbar_variants_colors = createSkinBlock(navbar_all_colors, function (e) {
    var color = $(this).data('color')
    var $main_header = $('.main-header')
    $main_header.removeClass('navbar-dark').removeClass('navbar-light')
    navbar_all_colors.map(function (color) {
      $main_header.removeClass(color)
    })
    if (navbar_dark_skins.indexOf(color) > -1) {
      $main_header.addClass('navbar-dark')
      updateTheme("NavBar",'navbar-dark '+color);
    } else {
      $main_header.addClass('navbar-light')
      updateTheme("NavBar",'navbar-light '+color);
    }

    $main_header.addClass(color)
    
  })

  $navbar_variants.append($navbar_variants_colors)

  $container.append($navbar_variants)

  var sidebar_colors = [
    'bg-primary',
    'bg-warning',
    'bg-info',
    'bg-danger',
    'bg-success',
    'bg-indigo',
    'bg-lightblue',
    'bg-navy',
    'bg-purple',
    'bg-fuchsia',
    'bg-pink',
    'bg-maroon',
    'bg-orange',
    'bg-lime',
    'bg-teal',
    'bg-olive'
  ]

  var accent_colors = [
    'accent-primary',
    'accent-warning',
    'accent-info',
    'accent-danger',
    'accent-success',
    'accent-indigo',
    'accent-lightblue',
    'accent-navy',
    'accent-purple',
    'accent-fuchsia',
    'accent-pink',
    'accent-maroon',
    'accent-orange',
    'accent-lime',
    'accent-teal',
    'accent-olive'
  ]

  var sidebar_skins = [
    'sidebar-dark-primary',
    'sidebar-dark-warning',
    'sidebar-dark-info',
    'sidebar-dark-danger',
    'sidebar-dark-success',
    'sidebar-dark-indigo',
    'sidebar-dark-lightblue',
    'sidebar-dark-navy',
    'sidebar-dark-purple',
    'sidebar-dark-fuchsia',
    'sidebar-dark-pink',
    'sidebar-dark-maroon',
    'sidebar-dark-orange',
    'sidebar-dark-lime',
    'sidebar-dark-teal',
    'sidebar-dark-olive',
    'sidebar-light-primary',
    'sidebar-light-warning',
    'sidebar-light-info',
    'sidebar-light-danger',
    'sidebar-light-success',
    'sidebar-light-indigo',
    'sidebar-light-lightblue',
    'sidebar-light-navy',
    'sidebar-light-purple',
    'sidebar-light-fuchsia',
    'sidebar-light-pink',
    'sidebar-light-maroon',
    'sidebar-light-orange',
    'sidebar-light-lime',
    'sidebar-light-teal',
    'sidebar-light-olive'
  ]



  $container.append('<h6>Dark Sidebar Variants</h6>')
  var $sidebar_variants_dark = $('<div />', {
    'class': 'd-flex'
  })
  $container.append($sidebar_variants_dark)
  $container.append(createSkinBlock(sidebar_colors, function () {
    var color         = $(this).data('color')
    var sidebar_class = 'sidebar-dark-' + color.replace('bg-', '')
    var $sidebar      = $('.main-sidebar')
    sidebar_skins.map(function (skin) {
      $sidebar.removeClass(skin)
    })
    $sidebar.addClass(sidebar_class)
    /////////// FOR SAME SIDEBAR LOGO BG //////////
    var $logo = $('.brand-link')
    logo_skins.map(function (skin) {
      $logo.removeClass(skin)
    })
    $logo.addClass("navbar-dark");
    var $HDlogo = $('.sidebarHDLogo')
    $HDlogo.removeClass("sidebarHDLogoLight")
    /////////////////////////////////
    updateTheme("SideBar",sidebar_class);
  }))

  $container.append('<h6>Light Sidebar Variants</h6>')
  var $sidebar_variants_light = $('<div />', {
    'class': 'd-flex'
  })
  $container.append($sidebar_variants_light)
  $container.append(createSkinBlock(sidebar_colors, function () {
    var color         = $(this).data('color')
    var sidebar_class = 'sidebar-light-' + color.replace('bg-', '')
    var $sidebar      = $('.main-sidebar')
    sidebar_skins.map(function (skin) {
      $sidebar.removeClass(skin)
    })
    $sidebar.addClass(sidebar_class)
/////////// FOR SAME SIDEBAR LOGO BG //////////
    var $logo = $('.brand-link')
    logo_skins.map(function (skin) {
      $logo.removeClass(skin)
    })
    $logo.addClass("navbar-light");
    var $HDlogo = $('.sidebarHDLogo')
    $HDlogo.addClass('sidebarHDLogoLight')
    //////////////////////////////////
    updateTheme("SideBar",sidebar_class);
  }))

  var logo_skins = navbar_all_colors

  function createSkinBlock(colors, callback) {
    var $block = $('<div />', {
      'class': 'd-flex flex-wrap mb-3'
    })

    colors.map(function (color) {
      var $color = $('<div />', {
        'class': (typeof color === 'object' ? color.join(' ') : color).replace('navbar-', 'bg-').replace('accent-', 'bg-') + ' elevation-2'
      })

      $block.append($color)

      $color.data('color', color)

      $color.css({
        width       : '40px',
        height      : '20px',
        borderRadius: '25px',
        marginRight : 10,
        marginBottom: 10,
        opacity     : 0.8,
        cursor      : 'pointer'
      })

      $color.hover(function () {
        $(this).css({ opacity: 1 }).removeClass('elevation-2').addClass('elevation-4')
      }, function () {
        $(this).css({ opacity: 0.8 }).removeClass('elevation-4').addClass('elevation-2')
      })

      if (callback) {
        $color.on('click', callback)
      }
    })

    return $block
  }

  $('.product-image-thumb').on('click', function() {
    const image_element = $(this).find('img');
    $('.product-image').prop('src', $(image_element).attr('src'))
    $('.product-image-thumb.active').removeClass('active');
    $(this).addClass('active');
  });
})(jQuery)

function updateTheme(type, value){

	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/updateTheme";
 $.ajax({
     url: serviceUrl,
     type: 'post',
     data: 'type=' + type
         + '&value=' + value,
     success: function(data) {
//    	 alert(data)
     }
 });
}



//08/11
function bellNotification() {
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/bellNotification";
	
    $.ajax({
        url:serviceUrl,
        type:'post',
       
        success: function(data) {
        	
        	
//            alert(data);
        	
//            document.getElementById('count').innerHTML=data;
//            document.getElementById('count2').innerHTML=data;
//            document.getElementById('count3').innerHTML=data;
//            document.getElementById('count4').innerHTML=data;
            
            if(data=="error")
            {
            	$('#viewAllDown').hide();
            	
            }
            
        }
        
 });
}
//



//12/11
function renderNotifications() {
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/PMS/renderNotifications";
	
    $.ajax({
        url:serviceUrl,
        type:'post',
       
        success: function(data) {
        	
//        	alert(data)
        	
        	const dataN = JSON.parse(data); 
        	const value = dataN[0][2];
//        	alert(value); 
        	
        	
        	document.getElementById('count1').innerHTML=dataN[0][0];
            document.getElementById('count2').innerHTML=dataN[0][1];
            document.getElementById('count3').innerHTML=dataN[0][2];
            document.getElementById('count4').innerHTML=dataN[0][3];
            document.getElementById('count5').innerHTML=dataN[0][4];

            document.getElementById('count').innerHTML=dataN[0][5];
//            document.getElementById('count4').innerHTML=data;
            
            
            if(dataN[0][0]=="NA" || dataN[0][0]==0)
            {
            	$('#assigned_today').hide();
            }
            if(dataN[0][1]=="NA" || dataN[0][1]==0)
            {
            	$('#revise_dates').hide();
            }
            if(dataN[0][2]=="NA" || dataN[0][2]==0)
            {
            	$('#reactivate_account').hide();
            }
            if(dataN[0][3]=="NA" || dataN[0][3]==0)
            {
            	$('#formC').hide();
            }
            
            if(dataN[0][4]=="NA" || dataN[0][4]==0)
            {
            	$('#customization_act').hide();
            }
            
            if(dataN[0][5]==0)
            {
            	$('#viewAllDown').hide();
            	$('#NoNotification').show();
            	
            }
            
            
            var allowedRolesN = ["Developer","Tester","Support"];
            var manRoles = ["Implementor","Support_Manager"];
            var allowedDesignationN = ["Team Leader","Jr. Team Leader","Sr Team Leader"];
            
//            alert(roleType)
            
            if(allowedRolesN.includes(roleType) && (allowedDesignationN.includes(designation))) {
//         	   alert("allowedRolesN")
        	    $("#viewAllDown").hide();
        	    
        	}
            if(manRoles.includes(roleType))
            {
            	$("#viewAllDown").hide();
            }
            
            
           
        	
        	if (typeof data === "string") {
                try {
                    data = JSON.parse(data); 
                } catch (e) {
                    console.error("Error parsing JSON:", e);
                    return;
                }
            }
        	
        	const notificationContainer = document.getElementById("notification");
            const notificationList = document.getElementById("notificationList");
            
            
            notificationList.innerHTML = '';
        	
            data.forEach(item => {
                const activity = item[0]; 
                
                const notificationItem = document.createElement("a");
                notificationItem.href = "javascript:void(0);";
                notificationItem.classList.add("dropdown-item", "notify-item");
                
              
//                const notifyIcon = document.createElement("div");
//                notifyIcon.classList.add("notify-icon", "bg-secondary");
//                const icon = document.createElement("i");
//                icon.classList.add("fa", "fa-upload"); 
//                notifyIcon.appendChild(icon);

                
//                const notifyDetails = document.createElement("p");
//                notifyDetails.classList.add("notify-details");
//                const boldText = document.createElement("b");
//                boldText.textContent = activity;
//                notifyDetails.appendChild(boldText);
//                const smallText = document.createElement("small");
//                smallText.classList.add("text-muted");
                
//                notificationItem.appendChild(notifyIcon);
//                notificationItem.appendChild(notifyDetails);

                
                notificationList.appendChild(notificationItem);
                
              
                
            });
            
        }
        
 });
}
//


document.addEventListener('DOMContentLoaded', renderNotifications);


document.getElementById('viewAllDown').addEventListener('click', function() {

	const notificationContainer = document.getElementById("notificationContainer");

    if (notificationContainer.style.display === "none") {
        notificationContainer.style.display = "block";  
    } else {
        notificationContainer.style.display = "none";  
    }
});



$('#viewAllDown').click(function(){
	

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Admin/ActivitiesUploadedToday";
	
})


$('#assigned_today').click(function(){
	
	if((roleType=='Developer') || (roleType=='Tester') || (roleType=='Support') && (designation=='Team Leader') || (designation=='Jr. Team Leader') || (designation=='Sr Team Leader'))
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/Admin/ActivitiesUploadedToday";
	}
	else if((roleType=='Implementor') || (roleType=='Support_Manager'))
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/Admin/ActivitiesUploadedToday";
	}
	
})


$('#customization_act').click(function(){
	
	if((roleType=='Developer') || (roleType=='Tester') || (roleType=='Support') && (designation=='Team Leader') || (designation=='Jr. Team Leader') || (designation=='Sr Team Leader'))
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/Admin/AssignCustomizationTask";
	}
	else if((roleType=='Implementor') )
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/Admin/AssignCustomizationTask";
	}
	
})


$('#revise_dates').click(function(){
	
	if((roleType=='Developer') || (roleType=='Tester') || (roleType=='Support') && (designation=='Team Leader') || (designation=='Jr. Team Leader') || (designation=='Sr Team Leader'))
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/Admin/MultipleDateUpdateMgr";
	}
	else if((roleType=='Implementor') || (roleType=='Support_Manager'))
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/Admin/approvedReviseStartEndDates";
	}
	
	
})


$('#reactivate_account').click(function(){
	
	if((roleType=='Developer') || (roleType=='Tester') || (roleType=='Support') && (designation=='Team Leader') || (designation=='Jr. Team Leader') || (designation=='Sr Team Leader'))
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/PMS/ReactivateAccount";
	}
	else if((roleType=='Implementor') || (roleType=='Support_Manager'))
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/PMS/ReactivateAccount";
	}

	
})



$('#formC').click(function(){
	
	if((roleType=='Developer') || (roleType=='Tester') || (roleType=='Support') && (designation=='Team Leader') || (designation=='Jr. Team Leader') || (designation=='Sr Team Leader'))
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/PMS/ReactivateAccount";
	}
	else if((roleType=='Implementor') || (roleType=='Support_Manager'))
	{
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/User/pendingFORM3";
	}
	
	
})

