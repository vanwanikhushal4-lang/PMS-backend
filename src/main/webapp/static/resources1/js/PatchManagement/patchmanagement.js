//window.onload = function() {
//$(function()
//{
//$('#search-input').on('keyup', function () {
//                ////alert('hiii')
//                var searchString = $(this).val();
//                ////alert(searchString)
//                $('#showSummaryDataS').jstree('search', searchString);
//                // $('#showSummaryDataS').jstreenode('search',searchString);
//            })
//});





function checkSizeCompare()
{

    var pkt = $('#pktsize').val();
    var file = $('#uploadsize').val();
    var newpkt;
    var newfile;
    console.log(pkt)
    console.log(file)
    if (pkt.includes('Gb') && file.includes('Gb'))
    {
        console.log('1')
        newpkt = pkt.split('>');
        newfile = file.split('>');
        console.log(newpkt[0])
        console.log(newfile[0])
        if (newpkt[0] < newfile[0])

        {
            return false;
        }
        else {
            return true;
        }

    }
    else if (pkt.includes('Gb') && file.includes('Mb'))
    {
        console.log('2')
        return false;
    }
    else if (pkt.includes('Gb') && file.includes('Kb'))
    {
        console.log('3')
        return false;
    }
    else if (pkt.includes('Tb') && file.includes('Mb'))
    {
        console.log('4')
        return false;
    }
    else if (pkt.includes('Tb') && file.includes('Gb'))
    {
        console.log('5')
        return false;
    }
    else if (pkt.includes('Mb') && file.includes('Kb'))
    {
        console.log('6')
        return false;

    }
    else if (pkt.includes('Mb') && file.includes('Mb'))
    {
        console.log('7')
        newpkt = pkt.split('>');
        newfile = file.split('>');
        console.log(newpkt[0])
        console.log(newfile[0])
        if (newpkt[0] < newfile[0])
        {
            return false;
        } else {
            return true;
        }

    } else if (pkt.includes('Kb') && file.includes('Kb'))
    {
        console.log('8')
        newpkt = pkt.split('>');
        newfile = file.split('>');
        console.log(newpkt[0])
        console.log(newfile[0])
        console.log(newpkt[0] < newfile[0])
        if (newpkt[0] < newfile[0])
        {
            console.log('inside if' + newpkt[0] < newfile[0])
            return false;
        }
        else {
            return true;
        }

    } else if (pkt.includes('Bytes') && file.includes('Bytes'))
    {
        console.log('9')
        newpkt = pkt.split('>');
        newfile = file.split('>');
        console.log(newpkt[0])
        console.log(newfile[0])

        if (newpkt[0] < newfile[0])
        {
            return false;
        }
        else {
            return true;
        }

    }

    else
    {
        console.log('9')
        return true;
    }
}

$("#empPic").change(function()

{
    console.log('empic change');
    var iSize = ($("#empPic")[0].files[0].size / 1024);
    console.log('size:=' + iSize)
    if (iSize / 1024 > 1)

    {
        console.log('empic gb size');
        if (((iSize / 1024) / 1024) > 1)

        {

            iSize = (Math.round(((iSize / 1024) / 1024) * 100) / 100);

            $("#fileuploadsize").html(iSize + "Gb");
            $('#uploadsize').val(iSize + ">Gb");
        }

        else if (((iSize / 1024)) > 1)

        {

            iSize = (Math.round((iSize / 1024) * 100) / 100)

            $("#fileuploadsize").html(iSize + "Mb");
            $('#uploadsize').val(iSize + ">Mb");
        }

    }

    else

    {

        iSize = (Math.round(iSize * 100) / 100)

        $("#fileuploadsize").html(iSize + "kb");
        $('#uploadsize').val(iSize + ">Kb");
    }

});


$("#packetsize").change(function()

{
    //console.log('packetsize change');


    var iSize = $('#packetsize').val()
    var pktsize;
    var correctsize;
    //console.log('size:=' + iSize)
    if (iSize < 1024)

    {
        correctsize = iSize + " >Bytes";
    }

    else if (iSize < 1048576)
    {
        correctsize = (iSize / 1024).toFixed(3) + " >Kb";

    }
    else if (iSize < 1073741824)
    {
        correctsize = (iSize / 1048576).toFixed(3) + " >Mb";
    }
    else
    {
        correctsize = (iSize / 1073741824).toFixed(3) + " >Gb";
    }
    //console.log(correctsize)
    $('#pktsize').val(correctsize);

});

function progressbar()
{

    console.log('inside porgress bar')
    var interval = setInterval(function() {
        console.log('inside porgress bar before ajax')
        $.ajax({
            url: 'patchprogress',
            type: 'post',
            dataType: 'JSON',
            data: "ip=" + $('#patchip1').val(),
            success: function(data5) {
                var current_progress;
                console.log('inside porgress bar ajax return' + data5)
                if (data5.length == 0)
                {
                    console.log('inside data length 0')
                    $('#modelProgress').modal('hide');
                }
                else if (data5[0].timeout == "timeout")
                {
                    console.log('inside timeout')
                    $('#modelProgress').modal('hide');

//                    clearInterval(interval);
                }

                else
                {

                    console.log('inside else before for loop')
                    var per = "";
                    var totalsendfile = "";
                    var time = "";
                    var transmitrate = "";
                    var filesize = "";
                    var status = "";
                    var multicast = "";


                    for (var i = 0; i < data5.length; i++)
                    {

                        console.log('inside for loop')
                        per = data5[i].percentage;
                        totalsendfile = data5[i].totalfilesend;
                        time = data5[i].time;
                        transmitrate = data5[i].transmitratee;
                        filesize = data5[i].filesizee;
                        status = data5[i].status;
                        multicast = data5[i].multicastid;

                    }
                    if (status === "false")
                    {
                        per = 100;
                    }
                    if (status === "false")
                    {
                        console.log('inside status false for progressbar')
                        $('#modelProgress').modal('hide');



                    }
                    else
                    {
                        console.log('inside porgress bar show')
                        current_progress = Math.round(per * 100) / 100;
                        document.getElementById("file").value = multicast;

                        $("#dynamic").css("width", current_progress + "%").attr(
                                "aria-valuenow", current_progress).text(
                                current_progress + "% Complete");
                        $("#filesize").html("<b>File Size:</b> " + filesize);
                        $("#filename").html("<b>File Name: </b> " + multicast + "");
                        $("#transmitsize").html("<b>Transmit Rate: </b>" + transmitrate);
                        $("#totalfilesend").html("<b>Total File Send:</b> " + totalsendfile);
                        $("#time").html("<b>Elapsed Time:</b> " + time + " ");
                        $('#modelProgress').modal('show');

                    }


                }


            }
        });


//        if (current_progress <= 100)
//            clearInterval(interval);
    }, 1000);




}





//}



function Validate5()
{

    // var isValid = /^(([a-zA-Z]\:)|(\\))(\\{1}|((\\{1})[^\\]([^/:*?<>""|]*))+)$/;

    var isValid = /^([a-zA-Z]:)?(\|\/)?([a-zA-Z0-9\\s_@-^!#$%&+={}\[\]]+(\|\/)?)+(\.xml+)?$/;
    var foldervalid = /^[a-zA-Z][://|\\][\\\S|*\S]+?.*$/

    // var isValid =/^([a-zA-Z]:)?(\\[^<>:"/\\|?*]+)+\\?$/;

    $('#spinner2').show();
    var alphaExp = /^[a-zA-Z]+$/;
    ////alert("test"+alphaExp.test($('#packetsize').val()))
    indexError = 0;

    if ($('#packetsize').val().trim() === '') {
        callToolTip231('packetsize', 'show');
        indexError = indexError + 1;
    }

    else if (alphaExp.test($('#packetsize').val()))
    {
        ////alert('inside wrong packetsize')
        callToolTip231('packetsize1', 'show');
        indexError = indexError + 1;
    }
    if ($('#intervaltime').val().trim() === '') {
        callToolTip231('intervaltime', 'show');
        indexError = indexError + 1;
    }
    else if (alphaExp.test($('#intervaltime').val()))
    {
        ////alert('inside interval time')
        callToolTip231('intervaltime1', 'show');
        indexError = indexError + 1;
    }
    if ($('#timeout').val().trim() === '') {
        callToolTip231('timeout', 'show');
        indexError = indexError + 1;
    }
    else if (alphaExp.test($('#timeout').val()))
    {
        // //alert('inside  timeout')
        callToolTip231('timeout1', 'show');
        indexError = indexError + 1;
    }
    if ($('#empPic').val().trim() === '') {
        callToolTip231('empPic', 'show');
        indexError = indexError + 1;
    }
    if ($('#despath').val().trim() === '') {
        callToolTip231('despath', 'show');
        indexError = indexError + 1;
    }

    else if (!(foldervalid.test($('#despath').val())))
    {

        callToolTip231('despath1', 'show');
        indexError = indexError + 1;
    }

    if (!checkSizeCompare())
    {

        swal({
            title: "Fail!",
            text: "Packet size  must be less than File Size",
            type: "warning",
            width: 300,
            showCancelButton: !0,
            confirmButtonClass: "btn btn-success",
            cancelButtonClass: "btn btn-danger m-l-10",
            preConfirm: function() {
                var l = window.location;
                var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                window.location.href = base_url + "/ATM/parameter/PatchManagement.jsp";
            }
        })
        indexError = indexError + 1;
    }


    $('#spinner2').hide();

    if (indexError > 0)
    {
        return false;
    }

    else
    {

        $.ajax({
            url: 'checksendingstatus',
            type: 'post',
            data: "ip=" + $('#patchip1').val(),
        }).done(function(data) {

            if (data === "already") {
                console.log('inside already sending')

                swal({
                    title: "Fail!",
                    text: "File sending already",
                    type: "warning",
                    width: 300,
                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-success",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    allowOutsideClick: false,
                    closeOnConfirm: false,
                    preConfirm: function() {
                        swal({
                            title: "Fail!",
                            text: "File sending already",
                            type: "warning",
                            width: 300,
                            showCancelButton: !0,
                            confirmButtonClass: "btn btn-success",
                            cancelButtonClass: "btn btn-danger m-l-10",
                            allowOutsideClick: false,
                            closeOnConfirm: false,
                            preConfirm: function() {

                                var l = window.location;
                                var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                                window.location.href = base_url + "/ATM/parameter/PatchManagement.jsp";

                            }
                        })
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/ATM/parameter/PatchManagement.jsp";

                    }
                })
                event.prevemtDefault();
                return false;

            }
            else
            {
                console.log('inside already not sending')
                $('#spinner2').show();
                progressbar();
                return true;

            }
        });

    }

}




var callToolTip231 = function(fieldName, status) {

    if (fieldName == "patchid") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Patch ID<span>";
    } else if (fieldName == "packetsize") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Packet Size<span>";
    }
    else if (fieldName == "packetsize1") {
        $("#packetsize").tooltip('destroy');
        fieldName = "packetsize"
        var errorMessage = "<span>Please Enter valid Packet Size<span>";
    }
    else if (fieldName == "intervaltime") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Interval Time<span>";
    }
    else if (fieldName == "intervaltime1") {
        $("#intervaltime").tooltip('destroy');
        fieldName = "intervaltime"
        var errorMessage = "<span>Please Enter valid Interval Time<span>";
    }
    else if (fieldName == "timeout") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Timeout<span>";
    }
    else if (fieldName == "timeout1") {
        $("#timeout").tooltip('destroy');
        fieldName = "timeout"
        var errorMessage = "<span>Please Enter Timeout<span>";
    }
    else if (fieldName == "empPic") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select File<span>";
    }
    else if (fieldName == "despath") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Destination Path<span>";
    }
    else if (fieldName == "despath1") {

        $("#despath").tooltip('destroy');
        fieldName = "despath"
        var errorMessage = "<span>Please Enter valid Destination Path<span>";
    }

    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });

    if (status == "show") {

        $("#" + fieldName).tooltip('show');

    } else {
        $("#" + fieldName).tooltip('hide');
    }



}


//focus out
$('#patchid').on('focusout', function() {
    var usertype = $('#patchid').val();

    if (usertype.trim() == "") {
        callToolTip231('patchid', 'show');
    }
    else {
        callToolTip231('patchid', 'hide');
    }
});
$('#packetsize').on('focusout', function() {
    var usertype = $('#packetsize').val();

    if (usertype.trim() == "") {
        callToolTip231('packetsize', 'show');
    }
    else {
        callToolTip231('packetsize', 'hide');
    }
});
$('#intervaltime').on('focusout', function() {
    var usertype = $('#intervaltime').val();

    if (usertype.trim() == "") {
        callToolTip231('intervaltime', 'show');
    }
    else {
        callToolTip231('intervaltime', 'hide');
    }
});
$('#timeout').on('focusout', function() {
    var usertype = $('#timeout ').val();

    if (usertype.trim() == "") {
        callToolTip231('timeout', 'show');
    }
    else {
        callToolTip231('timeout', 'hide');
    }
});
$('#empPic').on('focusout', function() {
    var usertype = $('#browse ').val();

    if (usertype == "") {
        callToolTip231('empPic', 'show');
    }
    else {
        callToolTip231('empPic', 'hide');
    }
});
$('#despath').on('focusout', function() {
    var usertype = $('#despath ').val();

    if (usertype.trim() == "") {
        callToolTip231('despath', 'show');
    }
    else {
        callToolTip231('despath', 'hide');
    }
});


$('#patchid').on('focus', function() {
    callToolTip231('patchid', 'destroy');
});

$('#packetsize').on('focus', function() {
    callToolTip231('packetsize', 'destroy');
});
$('#intervaltime').on('focus', function() {
    callToolTip231('intervaltime', 'destroy');
});
$('#timeout').on('focus', function() {
    callToolTip231('timeout', 'destroy');
});
$('#empPic').on('focus', function() {
    callToolTip231('empPic', 'destroy');
});
$('#despath').on('focus', function() {
    callToolTip231('despath', 'destroy');
});


//
//   // $('#custom_image_content_up').hide();
//    $.ajax({
//        url:'itInfraDashboard',
//        type:'post',
//        dataType: 'json',
//        success: function(data) {
//            $('#itinfraloading').hide();
//            $('#itinfra').jstree({
//                "core" : {
//                    'data' : data
//                },
//                "default" : {
//                    "valid_children" : ["default","file"]
//                }
//            })
//
//            .on('hover_node.jstree', function(e, data) {
//                ////alert("hii" )
//                var $node = $("#" + data.node.id);
//                //  var url = $node.find('a').attr('href');
//                var ip_address = data.node.text.toString();
//                if(ip_address.indexOf(".")!==-1){
//                    //  document.getElementById('mlblName').innerHTML = ip_address;
//                    document.getElementById('mlblName2').innerHTML = ip_address;
//                    var temp=new Array()
//                    $.ajax({
//                        type: "POST",
//                        url: "jquery_getdata/getrestrictapp.jsp",
//                        data: "r_ip="+ip_address,
//                        success: function(html){
//                            temp=html.toString().split("^")
//                            document.getElementById('mapp').innerHTML = $.trim(temp[0]);
//                            document.getElementById('mbranch').innerHTML = $.trim(temp[1]);
//                            // document.getElementById('mpktloss_bar').innerHTML = $.trim(temp[1]);
//                            document.getElementById('mlblName').innerHTML = $.trim(temp[2]);
//                            document.getElementById('mlblName1').innerHTML = $.trim(temp[2]);
//                        }
//                    });
//                    $('#custom_image_content_up')
//                    .css('position', 'absolute')
//                    .css('top', $node.position().top + 20) // Add about 20 to ensure the div is not hovered when we re-position it.
//                    .css('left', $node.position().left)
//                    .css('top', mouse_y)
//                    .css('left', mouse_x)
//                    .show();
//                }
//            })
//            .on('dehover_node.jstree', function() {
//                $('#custom_image_content_up').hide(); // Need to hide tooltip after we change hover targets.
//            })
//            .on('changed.jstree', function (e, data) {
//                var i, j, r = [];
//                for(i = 0, j = data.selected.length; i < j; i++) {
//                    r.push(data.instance.get_node(data.selected[i]).id);
//                }
//
//                var data =  r.join(', ') ,
//                substring = "~";
//                //  console.log();
//
//                if(data.indexOf(substring)!==-1){
//
//
//                    var devicetype=data.substring(0, data.indexOf("~"));
//
//                    var ip = data.substring(data.indexOf("^")+1);
//
//
//                    if(devicetype=="ATM")
//                    {
//
//                        var jspcall = "ATMDetailsPage.jsp?ip_address="+ip;
//                        window.location.href = jspcall;
//                    }
//                    else if(devicetype=="Biometric")
//                    {
//
//                        var jspcall1 = "BiometricDetailPage.jsp?ip_address="+ip;
//                        window.location.href = jspcall1;
//                    }else if(devicetype=="Pendrive")
//                    {
//
//                        var jspcall2 = "PendriveDetailsPage.jsp?ip_address="+ip;
//                        window.location.href = jspcall2;
//                    }else
//                    {
//
//                        var jspcall3 = "IPDetailsPage.jsp?ip_address="+ip;
//                        window.location.href = jspcall3;
//                    }
//                }
//
//
//            //                if(data.indexOf(substring)!==-1){
//            //                    data = data.substring(data.indexOf("T")+17, data.lastIndexOf("?"));
//            //                    var jspcall = "IPDetailsPage.jsp?ip_address="+data;
//            //                    window.location.href = jspcall;
//            //                }
//
//            //                else {
//            //            }
//            });
//
//        }
//
//    });
//});




$(function()
{
    console.log("In dashboard");
    $.ajax({
        url: 'patchmgmt',
        type: 'post',
        dataType: 'json',
        success: function(data) {

            $('#itinfraloading').hide();
            $('#itinfra').jstree({
                "core": {
                    'data': data
                },
                "plugins": ["contextmenu", "dnd", "search"],
                "search": {
                    "case_sensitive": false,
                    "show_only_matches": true,
                },
                "default": {
                    "valid_children": ["default", "file"]
                },
                "contextmenu": {
                    items: customMenu
                }

            }).on('select_node.jstree', function(e, data) {
                console.log(data)
                var ip_address = data.node.original.managed_name.toString();

//                $('#forms').show();
//                $('#patchdiv').hide();
//                $('#ip').val(ip_address);
//                $('#patchip').val(ip_address);
//                $('#patchip1').val(ip_address);
//                $('#patchip2').val(ip_address);
//                $('#pathdate').html('');


            })
            //.bind("loaded.jstree", function(event, data) {
//                $(this).jstree("open_all");
//            });


        }
    });

});

$('#pushpatchform').click(function()
{
    $('#pushpatch').show();
    $('#checkpatch').hide();
    $('#discoverpatch').hide();
    $('#patchdiv').hide();
});



//$('#discoverform').click(function ()
//{
//    
//    console.log("SHital" );
////    $('#checkpatch').hide();
////    $('#pushpatch').hide();
//    $('#patchdiv').show();
//
//    $.ajax({
//        url: 'getpatchlist',
//        type: 'post',
//        dataType: 'json',
//        data: "policyv=" + $('#patchip1').val(),
//        success: function (data) {
//            console.log("patchData" + data);
//            ////alert(data)
//            // $('#spinner').hide();
//
//            // $('#loadingpass5').hide();
//            var temp = new Array();
//
//            temp = data.toString().split(",");
//            console.log(temp[3]);
//            if (data.toString() == "userfail")
//            {
//                ////alert("inside if")
//                $('#pathdate').html('');
//                var table = $('#listing').DataTable();
//                table.clear().draw();
////                 $("#listing").DataTable({
////                    lengthChange: !1,
////                    // "dom": 'rt',
////
////                    data: '',
////                    columns: [
////                        {
////                            title: "Patch ID"
////                        },
////                        {
////                            title: "Patch Type"
////                        },
////                        {
////                            title: "Patch Install Date"
////                        }
////
////                    ],
////                    "bDestroy": true,
////                     "oLanguage" : { // the caption next to the search box
////                                "sSearch" : "Search:"
////                            },
////                          buttons : [ "copy","excel", "pdf", "colvis" ]
////                });
//
//
//                $('#patchdiv').show();
//
//            } else if (data === "clientfail") {
//                swal({
//                    title: "Fail!",
//                    text: "Client is not communicating",
//                    type: "warning",
//                    width: 300,
//                    showCancelButton: !0,
//                    confirmButtonClass: "btn btn-success",
//                    cancelButtonClass: "btn btn-danger m-l-10"
//                })
//            }
//            else {
//
//                ////alert("inside else")
//                $('#patchdiv').show();
//                console.log('inside success')
//                $('#pathdate').html('&nbsp;<b>' + temp[3] + '</b>');
////                $('#patchdetails tbody').replaceWith(data);
//                //document.getElementById('patchdetails').innerHTML=data;
//                $("#listing").DataTable({
//                    lengthChange: !1,
//                    // "dom": 'rt',
//
//                    data: data,
//                    columns: [
//                        {
//                            title: "Patch ID"
//                        },
//                        {
//                            title: "Patch Type"
//                        },
//                        {
//                            title: "Patch Install Date"
//                        }
//
//                    ],
//                    "bDestroy": true,
//                    "oLanguage": {// the caption next to the search box
//                        "sSearch": "Search:"
//                    },
//                    buttons: ["copy", "excel", "pdf", "colvis"]
//                });
//
//
//
//
//            }
//
//
//
//
//        }
//    });
//
//});


$('#checkpatchform').click(function()
{
    $('#pushpatch').hide();
    $('#checkpatch').show();
    $('#discoverpatch').hide();
    $('#patchdiv').hide();
});



$('#subcheckpatch').click(function()
{


    if (checkpatch())
    {

        $('#spinner1').show();
        $.ajax({
            url: 'checkpatch',
            type: 'post',
            data: "policyv=" + $('#patchip').val() +
                    "&patchid=" + $('#patchid').val(),
            success: function(data) {
                console.log("patchData" + data);
                $('#spinner1').hide();

                // $('#loadingpass5').hide();

                if (data == "true") {
                    swal({
                        title: "Success",
                        text: "Patch is present",
                        type: "success",
                        width: 300,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-success",
                        cancelButtonClass: "btn btn-danger m-l-10"
                    })
                    $('#patchid').val('');
                } else if (data == "false")
                {
                    swal({
                        title: "Fail!",
                        text: "Patch is not present",
                        type: "warning",
                        width: 300,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-success",
                        cancelButtonClass: "btn btn-danger m-l-10"
                    })
                    $('#patchid').val('');
                }
                else if (data == "clientfail") {
                    swal({
                        title: "Fail!",
                        text: "Client is not communicating",
                        type: "warning",
                        width: 300,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-success",
                        cancelButtonClass: "btn btn-danger m-l-10"
                    })
                    $('#patchid').val('');
                }
                else if (data.includes("ERROR")) {
                    swal({
                        title: "Fail!",
                        text: "Client is not communicating",
                        type: "warning",
                        width: 300,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-success",
                        cancelButtonClass: "btn btn-danger m-l-10"
                    })
                    $('#patchid').val('');
                }



            }
        });
    }
});


function customMenu(node) {
    // The default set of all items

    var items = {
    };






}

function checkpatch()
{
    indexError = 0;
    if ($('#patchid').val().trim() === '') {
        callToolTip231('patchid', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
function pushpatch()
{
    indexError = 0;
    if ($('#packetsize').val().trim() === '') {
        callToolTip231('packetsize', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#intervaltime').val().trim() === '') {
        callToolTip231('intervaltime', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#timeout').val().trim() === '') {
        callToolTip231('timeout', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#browse').val().trim() === '') {
        callToolTip231('browse', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#despath').val().trim() === '') {
        callToolTip231('despath', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }


    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
$('#resretcheck').click(function()
{
    callToolTip231('patchid', 'destroy');
    $('#patchid').val("");
});


$('#restdata').click(function()
{
    callToolTip231('packetsize', 'destroy');
    callToolTip231('packetsize1', 'destroy');
    callToolTip231('intervaltime', 'destroy');
    callToolTip231('intervaltime1', 'destroy');
    callToolTip231('timeout', 'destroy');
    callToolTip231('timeout1', 'destroy');
    callToolTip231('empPic', 'destroy');
    callToolTip231('despath', 'destroy');
    callToolTip231('despath1', 'destroy');
    $('#packetsize').val("");
    $('#intervaltime').val("");
    $('#timeout').val("");
    $('#empPic').val("");
    $('#despath').val("");
    $('#fileuploadsize').html("");

    if ($('#executee').is(':checked')) {

        document.getElementById("executee").checked = false;


    }


});

$('#subpushpatch').click(function()
{
    if (pushpatch())
    {


        $.ajax({
            url: 'pushpatch',
            type: 'post',
            data: "patchip=" + $('#patchip1').val()
                    + "&packetsize=" + $('#packetsize').val()
                    + "&intervaltime=" + $('#intervaltime').val()
                    + "&timeout=" + $('#timeout').val()
                    + "&browse=" + $('#browse').val()
                    + "&despath=" + $('#despath').val(),
            success: function(data) {
                console.log("patchData" + data);
                $('#spinner1').hide();

                // $('#loadingpass5').hide();

                if (data == "true") {
                    swal({
                        title: "Success",
                        text: "Patch is present",
                        type: "success",
                        width: 300,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-success",
                        cancelButtonClass: "btn btn-danger m-l-10"
                    })
                } else if (data == "false")
                {
                    swal({
                        title: "Fail!",
                        text: "Patch is not present",
                        type: "warning",
                        width: 300,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-success",
                        cancelButtonClass: "btn btn-danger m-l-10"
                    })

                }
                else if (data == "clientfail") {
                    swal({
                        title: "Fail!",
                        text: "Client is not communicating",
                        type: "warning",
                        width: 300,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-success",
                        cancelButtonClass: "btn btn-danger m-l-10"
                    })
                }
                else if (data.includes("ERROR")) {
                    swal({
                        title: "Fail!",
                        text: "Client is not communicating",
                        type: "warning",
                        width: 300,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-success",
                        cancelButtonClass: "btn btn-danger m-l-10"
                    })
                }



            }
        });




    }
});

//
//function getCheckval1()
//{
//	////alert("In Check method")
//    checkboxName= "check2";
//    //var srnoooo = document.getElementById("check1").value;
//    var checkboxes = document.querySelectorAll('input[name="' + checkboxName + '"]:checked'), values = [];
//  
//    Array.prototype.forEach.call(checkboxes, function(el) {
//        values.push("true");
//
//    });
//  
//  }


document.getElementById("executevalue").value = "false";

$("#executee").on('change', function() {
    ////alert("in if" )
    if ($(this).is(':checked')) {
        ////alert("true" )
        $(this).attr('value', 'true');
        document.getElementById("executevalue").value = "true";
    } else {
        ////alert("flase")
        $(this).attr('value', 'false');
        document.getElementById("executevalue").value = "false";
    }


});
