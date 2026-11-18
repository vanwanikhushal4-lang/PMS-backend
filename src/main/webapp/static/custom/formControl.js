
var username = $("#userName").val();
//alert("username "+username)


$(document).ready ( function(){
	////////////////// THEME DATA //////////////
	 $('body').addClass('text-sm')
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getThemeData";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',

        success: function (data) {

            var HEADER_COLOR = data[0]["HEADER_COLOR"];
            var SIDEBAR_COLOR = data[0]["SIDEBAR_COLOR"];
            var SMALL_FONT = data[0]["SMALL_FONT"];
//           alert(HEADER_COLOR)
//            alert(SIDEBAR_COLOR)
            
//            alert(SMALL_FONT)
            
            
      if(HEADER_COLOR !="")
		{
	     var $main_header = $('.main-header')
	     $main_header.removeClass('navbar-dark').removeClass('navbar-light')
	     $main_header.addClass(HEADER_COLOR);
	     var getColor = HEADER_COLOR.replace(/^(?:[^\-]*\-){2}\s*/, '');
	     var $logoutBtn = $('.userexpand')
	     $logoutBtn.removeClass('bg-dark')
	     $logoutBtn.addClass('bg-'+getColor)
		}
      if(SIDEBAR_COLOR !="")
		{
    	 var $main_sidebar = $('.main-sidebar')
 	     $main_sidebar.removeClass('sidebar-dark-info')
 	     $main_sidebar.addClass(SIDEBAR_COLOR);
    	 
    	 if(SIDEBAR_COLOR.includes("dark")){
    		 var $logo = $('.brand-link') 
    		 $logo.removeClass('navbar-dark').removeClass('navbar-light')
    		 $logo.addClass('navbar-dark');
    		 var $HDlogo = $('.sidebarHDLogo')
    		    $HDlogo.removeClass('sidebarHDLogoLight')
    	 }
    	 else if (SIDEBAR_COLOR.includes("light")){
    		 var $logo = $('.brand-link') 
    		 $logo.removeClass('navbar-dark').removeClass('navbar-light')
    		 $logo.addClass('navbar-light');
    		 var $HDlogo = $('.sidebarHDLogo')
    		    $HDlogo.addClass('sidebarHDLogoLight')
    	 }
		}
      if(SMALL_FONT !="")
		{
    	  if(SMALL_FONT==="True")
    		  {
    		  $('.nav-sidebar').removeClass('text-sm')
    	    	$('.nav-sidebar').addClass('text-xs')
    	    	$('.content-wrapper').removeClass('text-sm')
    	    	$('.content-wrapper').addClass('text-xs')
    		  }
    	  else if(SMALL_FONT==="False")
    	  	{
    		  $('.nav-sidebar').removeClass('text-xs')
    	    	$('.nav-sidebar').addClass('text-sm')
    	    	$('.content-wrapper').removeClass('text-xs')
    	    	$('.content-wrapper').addClass('text-sm')
    	  	}
		}
        }
    });
	
	
   
/////////////////////////////////////////////////
	 
	$(".form-control").addClass("form-control-sm");
     $(".multiselect-search").removeClass("form-control-sm");
     
//////////////////////// AUTO SCROLL CODE ////////////     
     var url = window.location;
     // for single sidebar menu
     $('ul.nav-sidebar a').filter(function () {
         return this.href == url;
     }).addClass('active scrollto');

     // for sidebar menu and treeview
     $('ul.nav-treeview a').filter(function () {
         return this.href == url;
     }).parentsUntil(".nav-sidebar > .nav-treeview")
         .css({'display': 'block'})
         .addClass('menu-open').prev('a')
         .addClass('active');
     loadScroll();
     
//////////////ADJUST FOOTER HEIGHT //////////
	 var containerHeight= document.getElementsByClassName('content-wrapper')[0].clientHeight;
	 var newHeight = containerHeight + 30;
	 document.getElementsByClassName('content-wrapper')[0].style.minHeight = newHeight+"px";
	 
/////////////////////// SIDEBAR SEARCH CODE //////////////
	 var url1 = window.location;
	 $(".search-menu-box").on('input', function() {
			var filter = $(this).val();
	
			$(".sidebar-menu li").each(function() {
				if ($(this).text().search(new RegExp(filter, "i")) < 0) {
					$(this).hide();
				} else {
					if(filter.length!==0){
						$(this).show();
					}
					else{
//						alert(filter.length)
						$("#navigation").load(location.href+" #navigation>*","");
						setTimeout(
								  function() 
								  {
									  // for single sidebar menu
									     $('ul.nav-sidebar a').filter(function () {
									         return this.href == url;
									     }).addClass('active scrollto');

										// for treeview which is like a submenu
									     $('ul.nav-treeview a').filter(function () {
									         return this.href == url;
									     }).parentsUntil(".nav-sidebar > .nav-treeview")
									         .css({'display': 'block'})
									         .addClass('menu-open').prev('a')
									         .addClass('active');
//									     loadScroll();
									    
								  }, 1000);
					 
					}
				}
			});
		
			
		});
	 
	
		////////////////////// SIDEBAR SEARCH CODE END //////////////
 });

/////////////  Login History   ///////////



const clickedLinks = [];
document.addEventListener("DOMContentLoaded", function() {

    document.querySelectorAll('.nav-link').forEach(link => {
        link.addEventListener('click', function(event) {
//            event.preventDefault();

            const linkText = this.querySelector('p').textContent.trim();
                
            
            if (!clickedLinks.includes(linkText)) {
                clickedLinks.push(linkText);
            }
            
            var l = window.location;
         	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         	var serviceUrl = base_url + "/Master/updateUserActivity";
         	
         	 $.ajax({
                 type: 'POST',
                 url: serviceUrl, 
                 data: 'username=' + username
                 		+'&activities=' + clickedLinks ,
             }).done(function(data) {
//                  alert("response: "+data);

             });
            
        });
    });
});



////////////DOCUMENT READY ENDS ////////////////////

function loadScroll() {
	setTimeout(function(){ 
		var instance = OverlayScrollbars(document.getElementsByClassName("sidebar"), { });
		var scrollInfo = instance.scroll();
			instance.scroll($(".scrollto"), 700);
		},0);
	}

//$("body").click(function() {
//	
//    if ($("body").hasClass("control-sidebar-slide-open")) {
//        $("body").removeClass("control-sidebar-slide-open");
//    }
//});

function loadDatatablesScroll(){
//	var instance = $('.dataTables_scrollBody').overlayScrollbars({});
}

