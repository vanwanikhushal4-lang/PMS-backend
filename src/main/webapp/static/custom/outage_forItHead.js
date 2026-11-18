$(function () {
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/NotificationConfig/getITHeadOutage";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data) {
//        	 alert(data[0]["MESSAGE"])
var counter=0;
var calloutColor="";
       var notifications = new Array();
       for (var i = 0; i < data.length; i++) {
    	   counter=counter+1;
    	   
          if(data[i]["SEVERITY"]==="Low")
          {
           calloutColor='callout-info';
          } 
          else if(data[i]["SEVERITY"]==="Medium")
          {
           calloutColor='callout-warning';
          }
          else if(data[i]["SEVERITY"]==="High")
          {
           calloutColor='callout-high';
          }
          else if(data[i]["SEVERITY"]==="Critical")
          {
           calloutColor='callout-danger';
          }
                    
  notifications.push({
   callout: calloutColor,
   USERNAME: data[i]["USERNAME"],
   MESSAGE: data[i]["MESSAGE"],
   SEVERITY: data[i]["SEVERITY"],
   TIMESTAMP: data[i]["TIMESTAMP"],
  });
  
  var template = $('#outageTemplate').html();
  		template = template.replace("{{callout}}", notifications[i].callout);
           template = template.replace("{{USERNAME}}", notifications[i].USERNAME);
           template = template.replace("{{MESSAGE}}", notifications[i].MESSAGE);
          template = template.replace("{{SEVERITY}}", notifications[i].SEVERITY);
          template = template.replace("{{TIMESTAMP}}", notifications[i].TIMESTAMP);

          $('#outageContainer').append(template);
           
       }
     
  $("#outageCounter").html(counter);
  $("#outageCounter1").html(counter);
             },
     complete: function (data) {
    	 shortenText();
        }
      
     });

     OverlayScrollbars(document.querySelectorAll(".dropdown-item1"), 
    		 { 
    	 className : "os-theme-light" ,
    		 
    		 scrollbars : {
    		        visibility       : "auto",
    		        autoHide         : "leave",
    		        autoHideDelay    : 800,
    		        dragScrolling    : true,
    		        clickScrolling   : true,
    		        touchSupport     : true
    		    },
    		 });
     
});

function shortenText()
{
	/////////////////// SHORTEN TEXT ////////////////////
$('.expandMessage').each(function(){
	
	var text = $(this).text().trim();
    var word = "";
    var count = 0;
    var index = 0;
    
    for(var i=0;i<text.length;i++){ // we count the Real words and store the index of last word
    	if(text[i] == ' ' || text[i] == ',' || text[i] == '.'){
            if(word.trim() != ""){ // if we actually have a word (this avoids multiple white spaces)
                count++;
                word = "";
                index = i;
                if(count == 16) break; // we reached 6 real words, stop
            }
        }else{
        	word+=text[i];
        }
        
    }
    
    if(count == 16 && index+1 != text.length){ // we found 6 words and there is extra text
         html = '<span">' + text.substring(0,index)+'</span>' +'<span class="more_text" style="display:none;"> '+text.substring(index, text.length)+'</span>' + '<a href="#" class="read_more" style="color:inherit;font-weight: normal;font-style: normal;">[Read More]</a>'
    
         $(this).html(html)
    
    	$(this).find('a.read_more').click(function(event){
            $(this).toggleClass("less");
            event.preventDefault();
            if($(this).hasClass("less")){
            	$(this).html("[Read Less]")
                $(this).parent().find(".more_text").show();
            }else{
            	$(this).html("[Read More]")
                $(this).parent().find(".more_text").hide();
            }
        })
    
    }
	    
	})
}


$(".dropdown-menu-right").click(function(e){
	   e.stopPropagation();
})



