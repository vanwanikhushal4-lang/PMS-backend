/**
 * 
 */
$(function () {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/"
			+ l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Dashboard/UpDownPieChart";
    $.ajax(
            {
                type: 'POST',
                url: serviceUrl,
                dataType: 'json'

            }).done(function (data1) {


        var total_IpAddress = data1[0]['total_usb'];

        var total_prevent = data1[0]['total_prevent'];

        var total_allow = data1[0]['total_allow'];
        //  var a="<span id='totals' onclick='totoalnumber();' value='"+total_IpAddress+"'></span>";


var data=[];
if(total_prevent!=0)
{
    data.push({y: total_prevent, label: "Up", color: "green", x: "Up"});
}
if(total_allow!=0)
{
    data.push({y: total_allow, label: "Down", color: "Red", x: "Down"});
}


        // var total_unconfigure=+total_IpAddress - (+total_prevent + +total_allow);


        var chart = new CanvasJS.Chart("updownpiechart", {
            theme: "light2",
            animationEnabled: true,
            title: {
                text: "Up & Down ATMs"
            },
            subtitles: [{
                    text: "Total Atms:" + total_IpAddress + " Up :" + total_prevent + " Down:" + total_allow,
                    fontSize: 14
                }],
            data: [{
                    type: "pie",
                    indexLabelFontSize: 12,
                    radius: 75,
                    indexLabel: "{label}- {y}",
                    yValueFormatString: "###0\"\"",
                   
                    dataPoints: data
//                            [
//                        {y: total_prevent, label: "Up", color: "green", x: "Up"},
//                        {y: total_allow, label: "Down", color: "Red", x: "Down"},
//                    ]
                }]

        });
        chart.render();
            });



});