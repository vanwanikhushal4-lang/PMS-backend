$("#onclickbellicon").click(function(){
	 $("#counter").hide();
	$("#loaderid").show();
	// $("#notificationsContainer").empty();
//	alert("in notification")

	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/NotificationConfig/getUserNotification";
	
//  var serviceUrl = "getUserNotification";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data) {
        	 $("#counter").show();
        		$("#loaderid").hide();
//             alert(data)
//              var T_ID = data[0]["T_ID"];
//              alert(T_ID);

var hreflink="";
var calloutColor="";
       var notifications = new Array();
       for (var i = 0; i < data.length; i++) {
//           console.log("T_ID is: "+data[i]["T_ID"]);
          if(data[i]["STATUS"]==="New")
          {
           hreflink='<a href="'+getContextPath()+'/User/ViewUserTickets">'; 
           calloutColor='callout-info';
          }
          else if(data[i]["STATUS"]==="Hold" || data[i]["STATUS"]==="Awaiting User Information" || data[i]["STATUS"] ==="Pending With Vendor" || data[i]["STATUS"] === "Waiting for Spare" )
          {
              hreflink='<a href="'+getContextPath()+'/User/ViewUserTickets">'; 
              calloutColor='callout-danger';
          }
          else if(data[i]["STATUS"]==="Work in Progress")
          {
              hreflink='<a href="'+getContextPath()+'/User/ViewUserTickets">'; 
              calloutColor='callout-warning';
          }
          else if(data[i]["STATUS"]==="Resolved")
          {
              hreflink='<a href="'+getContextPath()+'/User/ResolveUserTickets">'; 
              calloutColor='callout-success';
          }
          else if(data[i]["STATUS"]==="Closed")
          {
              hreflink='<a href="'+getContextPath()+'/User/CloseUserTickets">'; 
              calloutColor='callout-success';
          }
          else if(data[i]["STATUS"]==="Reopened")
          {
              hreflink='<a href="'+getContextPath()+'/User/ViewUserTickets">'; 
              calloutColor='callout-danger';
          }
           else if(data[i]["STATUS"]==="Assigned")
          {
              hreflink='<a href="'+getContextPath()+'/User/ViewUserTickets">'; 
              calloutColor='callout-warning';
          }
           else if(data[i]["STATUS"]==="Re-Assigned")
          {
              hreflink='<a href="'+getContextPath()+'/User/ViewUserTickets">'; 
              calloutColor='callout-warning';
          }
          
          
  notifications.push({
   href1: "<a href="+data[i]["T_ID"]+">",
   callout: calloutColor,
     tid1: data[i]["T_ID"],
     status1: data[i]["STATUS"],
    href1: hreflink,
    tid: data[i]["T_ID"],
    image: data[i]["STATUS"],
//    texte: data[i]["MESSAGE"],
    date: data[i]["ACTIVITY_DATE"],
     href2: "<a>"
  });
  var template = $('#notificationTemplate').html();
  		template = template.replace("{{callout}}", notifications[i].callout);
           template = template.replace("{{tid1}}", notifications[i].tid1);
           template = template.replace("{{status1}}", notifications[i].status1);
          template = template.replace("{{href1}}", notifications[i].href1);
          template = template.replace("{{tid}}", notifications[i].tid);
          template = template.replace("{{image}}", notifications[i].image);
//          template = template.replace("{{texte}}", notifications[i].texte);
          template = template.replace("{{date}}", notifications[i].date);
          template = template.replace("{{href2}}", notifications[i].href2);

          $('#notificationsContainer').append(template);
           
       }
     
     var count = data[0]["COUNTER"];
  var lastCount = 0;
  $("#counter").html(count);
  $("#counter1").html(count);
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

$(".dropdown-menu-right").click(function(e){
	   e.stopPropagation();
})


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
//   setTimeout(function () {
//var notifications = new Array();
//        // TEMP : pour le template
//        for ( var i = 0; i < count; i++) {
//
//          
//        }
//
//        // On bind le marquage comme lue
//      
//
//        // On réactive le bouton
//        $("#notifications-dropdown").prop("disabled", false);
//      }, 1000);
  // Pour la maquette
//  var notifications = new Array();
//  notifications.push({
//    href: "#",
//    image: "Modification",
//    texte: "Votre incident " + makeBadge("17-0253") + " a été modifié",
//    date: "Mercredi 10 Mai, à 9h53"
//  });
//  notifications.push({
//    href: "#",
//    image: "Horloge",
//    texte: "Vous avez " + makeBadge("13") + " incidents en retards",
//    date: "Mercredi 10 Mai, à 8h00"
//  });
//  notifications.push({
//    href: "#",
//    image: "Visible",
//    texte: "Un nouvel incident dans votre groupe " + makeBadge("réseau"),
//    date: "Mardi 9 Mai, à 18h12"
//  });
//  notifications.push({
//    href: "#",
//    image: "Ajout",
//    texte: "Ouverture du problème " + makeBadge("17-0008"),
//    date: "Mardi 9 Mai, à 15h23"
//  });
//  notifications.push({
//    href: "#",
//    image: "Annulation",
//    texte: "Clotûre du problème " + makeBadge("17-0007"),
//    date: "Mardi 9 Mai, à 12h16"
//  });
//  notifications.push({
//    href: "#",
//    image: "Recherche",
//    texte: "Ouverture de l'incident " + makeBadge("17-1234") + " depuis le portail web",
//    date: "Mardi 9 Mai, à 10h14"
//  });

  function makeBadge(texte) {
    return "<span class=\"badge badge-default\">" + texte + "</span>";
  }

  appNotifications = {

    // Initialisation
    init: function () {
      // On masque les éléments
      $("#notificationsBadge").hide();
      $("#notificationAucune").hide();

      // On bind le clic sur les notifications
      $("#notifications-dropdown").on('click', function () {

        var open = $("#notifications-dropdown").attr("aria-expanded");

        // Vérification si le menu est ouvert au moment du clic
        if (open === "false") {
          appNotifications.loadAll();
        }

      });

      // On charge les notifications
      appNotifications.loadAll();

      // Polling
      // Toutes les 3 minutes on vérifie si il n'y a pas de nouvelles notifications
      setInterval(function () {
        appNotifications.loadNumber();
      }, 180000);

      // Binding de marquage comme lue desktop
      $('.notification-read-desktop').on('click', function (event) {
        appNotifications.markAsReadDesktop(event, $(this));
      });

    },

    // Déclenche le chargement du nombre et des notifs
    loadAll: function () {

      // On ne charge les notifs que si il y a une différence
      // Ou si il n'y a aucune notifs
      if (count !== lastCount || count === 0) {
        appNotifications.load();
      }
      appNotifications.loadNumber();

    },

    // Masque de chargement pour l'icône et le badge
    badgeLoadingMask: function (show) {
      if (show === true) {
        $("#notificationsBadge").html(appNotifications.badgeSpinner);
        $("#notificationsBadge").show();
        // Mobile
        $("#notificationsBadgeMobile").html(count);
        $("#notificationsBadgeMobile").show();
      }
      else {
        $("#notificationsBadge").html(count);
        if (count > 0) {
          $("#notificationsIcon").removeClass("fa-bell-o");
          $("#notificationsIcon").addClass("fa-bell");
          $("#notificationsBadge").show();
          // Mobile
          $("#notificationsIconMobile").removeClass("fa-bell-o");
          $("#notificationsIconMobile").addClass("fa-bell");
          $("#notificationsBadgeMobile").show();
        }
        else {
          $("#notificationsIcon").addClass("fa-bell-o");
          $("#notificationsBadge").hide();
          // Mobile
          $("#notificationsIconMobile").addClass("fa-bell-o");
          $("#notificationsBadgeMobile").hide();
        }

      }
    },

    // Indique si chargement des notifications
    loadingMask: function (show) {

      if (show === true) {
        $("#notificationAucune").hide();
        $("#notificationsLoader").show();
      } else {
        $("#notificationsLoader").hide();
        if (count > 0) {
          $("#notificationAucune").hide();
        }
        else {
          $("#notificationAucune").show();
        }
      }

    },

    // Chargement du nombre de notifications
    loadNumber: function () {
      appNotifications.badgeLoadingMask(true);

      // TODO : API Call pour récupérer le nombre

      // TEMP : pour le template
      setTimeout(function () {
        $("#notificationsBadge").html(count);
        appNotifications.badgeLoadingMask(false);
      }, 1000);
    },

    // Chargement de notifications
    load: function () {
      appNotifications.loadingMask(true);

      // On vide les notifs
      $('#notificationsContainer').html("");

      // Sauvegarde du nombre de notifs
      lastCount = count;

      // TEMP : pour le template
     
    },

    // Marquer une notification comme lue
    markAsRead: function (event, elem) {
      // Permet de garde la liste ouverte
      event.preventDefault();
      event.stopPropagation();

      // Suppression de la notification
      elem.parent('.dropdown-notification').remove();

      // TEMP : pour le template
      count--;

      // Mise à jour du nombre
      appNotifications.loadAll();
    },

    // Marquer une notification comme lue version bureau
    markAsReadDesktop: function (event, elem) {
      // Permet de ne pas change de page
      event.preventDefault();
      event.stopPropagation();

      // Suppression de la notification
      elem.parent('.dropdown-notification').removeClass("notification-unread");
      elem.remove();

      // On supprime le focus
      if (document.activeElement) {
        document.activeElement.blur();
      }

      // TEMP : pour le template
      count--;

      // Mise à jour du nombre
      appNotifications.loadAll();
    },

    add: function () {
      lastCount = count;
      count++;
    },

    // Template du badge
    badgeSpinner: '<i class="fa fa-spinner fa-pulse fa-fw" aria-hidden="true"></i>'
  };

  appNotifications.init();


