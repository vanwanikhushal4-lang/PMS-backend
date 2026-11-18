/**
 * 
 */
$(function() {
alert("inside onload")

    var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/"
				+ l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Dashboard/WhitelistPieChart";
    $.ajax(
            {
                type: 'POST',
                url: serviceUrl,
                dataType: 'json'

            }).done(function (data1) {
  alert(data1)

        var total_IpAddress =  data1[0]['total_IpAddress'];
  			alert("total_IpAddress: "+total_IpAddress)
        var total_learning = data1[0]['total_learning'];
  			alert("total_learning: "+total_learning)
        var total_protected = data1[0]['total_protected'];
  			alert("total_protected: "+total_protected)
        var total_unconfigure = +total_IpAddress - (+total_learning + +total_protected);
          alert("total_unconfigure: "+total_unconfigure)
var data=[];
if(total_protected!=0)
{
    data.push({y: total_protected, label: "Protected", color: "green", x: "protected"});
}
if(total_learning!=0)
{
    data.push({y: total_learning, label: "Learning", color: "orange", x: "learning"});
}
if(total_unconfigure!=0)
{
    data.push({y: total_unconfigure, label: "Notconfigured", color: "#ffc107", x: "unconfigured"});
}
console.log(data);
        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2",
            animationEnabled: true,
            //ngIf: "chartContainer.show",
            title: {
                text: "Whitelisted ATMs",
            },
            subtitles: [{
                    text: "Total ATM:" + total_IpAddress + "  Notconfigured:" + total_unconfigure + " Learning:" + total_learning + "  Protected:" + total_protected,
                    fontSize: 14
                }],
            data: [{
                    type: "pie",
                    indexLabelFontSize: 12,
                    radius: 75,
                    indexLabel: "{label}- {y}",
                    yValueFormatString: "###0\"\"",
                    
                    
                    dataPoints: 
                        data
//                        {y: total_unconfigure, label: "Notconfigured", color: "#ffc107", x: "unconfigured"},
//                        {y: total_protected, label: "Protected", color: "green", x: "protected"},
//                        {y: total_learning, label: "Learning", color: "orange", x: "learning"}


                    
                }]

        });
        
        chart.render();
    });



});