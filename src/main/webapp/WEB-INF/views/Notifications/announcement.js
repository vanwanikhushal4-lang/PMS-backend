$(function () {

  var serviceUrl = "getAnnouncementNotification";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data) {
//             alert(data[0]["CDATE"])
//             alert(data[0]["CTIME"])
//              var T_ID = data[0]["T_ID"];
//              alert(T_ID);


       var announcements = new Array();
       for (var i = 0; i < data.length; i++) {
//           console.log("T_ID is: "+data[i]["T_ID"]);
         
  //  SR_NO,DATA,FROM_USER,TO_USER,CDATE,CTIME        
  announcements.push({
//   href1: "<a href="+data[i]["T_ID"]+">",

    msgfrom: data[i]["FROM_USER"],
    announcement: data[i]["DATA"],
    date: data[i]["CDATE"],
    time: data[i]["CTIME"]
    
  });
  var template = $('#announcementTemplate').html();

          template = template.replace("{{msgfrom}}", announcements[i].msgfrom);
          template = template.replace("{{announcement}}", announcements[i].announcement);
          template = template.replace("{{date}}", announcements[i].date);
          template = template.replace("{{time}}", announcements[i].time);


          $('#announcementsContainer').append(template);
           
       }
     
     var count = data[0]["COUNTER"];
  var lastCount = 0;
  $("#counter").html(count);
  $("#counterr").html(count);
             }
      
     });

  
});

function getContextPath() {
//   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                        window.location.path = base_url + "/ATM/AddUser.jsp";
                        var linkstring= window.location.stringname= base_url;
                        return linkstring;
}

function clicker(tid1,status1){
//  alert("Ticket ID: "+tid1+" & Status is: "+status1);
}







