/**
 * 
 */
$(function () {
    //  alert("inside")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/"
			+ l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Dashboard/USBPieChart";
    $.ajax(
            {
                type: 'POST',
                url: serviceUrl,
                dataType: 'json'

            }).done(function (data1) {
        // alert(data[0][ 'total_IpAddress']+" "+data[0]['total_prevent'])
            	//alert(data)
        var total_IpAddress = data1[0][ 'total_IpAddress'];

        var total_prevent = data1[0]['total_prevent'];

        var total_allow = data1[0]['total_allow'];
        var total_unconfigure = +total_IpAddress - (+total_prevent + +total_allow);
        var data = [];
        if (total_prevent != 0)
        {
            data.push({y: total_prevent, label: "Prevent", color: "green", x: "prevent"});
        }
        if (total_allow != 0)
        {
            data.push({y: total_allow, label: "Allow", color: "Red", x: "allowed"});
        }
        if (total_unconfigure != 0)
        {
            data.push({y: total_unconfigure, label: "Notconfigured", color: "#ffc107", x: "unconfigured"});
        }


        var chart = new CanvasJS.Chart("usbContainer", {
            theme: "light2",
            animationEnabled: true,
            title: {
                text: "USB Protected ATMs"
            },
            subtitles: [{
                    text: "Prevent:" + total_prevent + " Allow:" + total_allow + " Notconfigured:" + total_unconfigure,
                    fontSize: 14
                }],
            data: [{
                    type: "pie",
                    indexLabelFontSize: 12,
                    radius: 75,
                    indexLabel: "{label}- {y}",
                    yValueFormatString: "###0\"\"",
                   
                    dataPoints:
//                            { y:  total_allow, label: "Allow", color:"Red",x:"allowed"},
//                            
//                           
//                            { y: total_prevent, label: "Prevent", color:"green",x:"prevent"},
//                            
//                            { y: total_unconfigure, label: "Notconfigured", color:"#ffc107",x:"unconfigured"},

                            data


                }]

        });
        chart.render();
            });



        });