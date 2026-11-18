
//$(function ()
//{
//   
//    var getBranch='getActionType';
//    $.ajax({
//        type: "POST",
//        url: getBranch,
//        
//        dataType:'json',
//        success: function(html1){
//
//            var d = html1;
//            //alert("1st val:"+d);
//            var length=d.length;
//            var html ="";
//            var html2 ="";
//            var allowLogon ="";
//            var changeSystem ="";
//            var increaseWorkingSet ="";
//            //var html ="<select id= 'usersmultiselected8' name='acm' class='form-control' data-toogle='tooltip'   multiple='multiple'>";
//            for (var i = 0; i < length; i++) {
//
//                html += '<option value="' +d[i]+ '">' + d[i]
//                + '</option>';
//            
//                if(d[i]=="agsuser01"){
//                
//                    html2 += '<option value="' +d[i]+ '" selected>' + d[i]+'</option>'; 
//                    allowLogon += '<option value="' +d[i]+ '" selected>' + d[i]+'</option>';
//                    changeSystem += '<option value="' +d[i]+ '" selected>' + d[i]+'</option>'; 
//                    increaseWorkingSet += '<option value="' +d[i]+ '" selected>' + d[i]+'</option>'; 
//                }else if(d[i]=="agsuser00"){
//                    allowLogon += '<option value="' +d[i]+ '" selected>' + d[i]+'</option>'; 
//                    changeSystem += '<option value="' +d[i]+ '" selected>' + d[i]+'</option>';
//                }else if(d[i]=="agsuser02"){
//                    allowLogon += '<option value="' +d[i]+ '" selected>' + d[i]+'</option>'; 
//                    increaseWorkingSet += '<option value="' +d[i]+ '" selected>' + d[i]+'</option>';
//                }else{
//                    
//                    html2 += '<option value="' +d[i]+ '">' + d[i]+'</option>';
//                    allowLogon += '<option value="' +d[i]+ '">' + d[i]+'</option>'; 
//                    changeSystem += '<option value="' +d[i]+ '">' + d[i]+'</option>';
//                    increaseWorkingSet += '<option value="' +d[i]+ '" >' + d[i]+'</option>';
//                }
//            }
//            
//            // html+="</select>";
//            //alert(html);
//            document.getElementById("usersmultiselected8").innerHTML=html;
//            document.getElementById("usersmultiselected9").innerHTML=html;
//            document.getElementById("usersmultiselected10").innerHTML=html;
//            document.getElementById("usersmultiselected51").innerHTML=html;
//            document.getElementById("usersmultiselected11").innerHTML=html2;
//            document.getElementById("usersmultiselected12").innerHTML=allowLogon;
//            document.getElementById("usersmultiselected13").innerHTML=html;
//            document.getElementById("usersmultiselected14").innerHTML=html2;
//            document.getElementById("usersmultiselected15").innerHTML=allowLogon;
//            document.getElementById("usersmultiselected16").innerHTML=changeSystem;
//            document.getElementById("usersmultiselected17").innerHTML=changeSystem;
//            document.getElementById("usersmultiselected18").innerHTML=html2;
//            document.getElementById("usersmultiselected19").innerHTML=html;
//            document.getElementById("usersmultiselected20").innerHTML=html;
//            document.getElementById("usersmultiselected21").innerHTML=html;
//            document.getElementById("usersmultiselected22").innerHTML=html2;
//            document.getElementById("usersmultiselected23").innerHTML=html;
//            document.getElementById("usersmultiselected24").innerHTML=html;
//            document.getElementById("usersmultiselected25").innerHTML=html;
//            document.getElementById("usersmultiselected26").innerHTML=html;
//            document.getElementById("usersmultiselected27").innerHTML=html;
//            document.getElementById("usersmultiselected28").innerHTML=html;
//            document.getElementById("usersmultiselected29").innerHTML=html;
//            document.getElementById("usersmultiselected30").innerHTML=html;
//            document.getElementById("usersmultiselected31").innerHTML=html;
//            document.getElementById("usersmultiselected32").innerHTML=html2;
//            document.getElementById("usersmultiselected33").innerHTML=increaseWorkingSet;
//            document.getElementById("usersmultiselected34").innerHTML=html2;
//            document.getElementById("usersmultiselected35").innerHTML=html2;
//            document.getElementById("usersmultiselected36").innerHTML=html;
//            document.getElementById("usersmultiselected37").innerHTML=html;
//            document.getElementById("usersmultiselected38").innerHTML=html;
//            document.getElementById("usersmultiselected39").innerHTML=html;
//            document.getElementById("usersmultiselected40").innerHTML=html;
//            document.getElementById("usersmultiselected41").innerHTML=html2;
//            document.getElementById("usersmultiselected42").innerHTML=html2;
//            document.getElementById("usersmultiselected43").innerHTML=html2;
//            document.getElementById("usersmultiselected44").innerHTML=html2;
//            document.getElementById("usersmultiselected45").innerHTML=html2;
//            document.getElementById("usersmultiselected46").innerHTML=html;
//            document.getElementById("usersmultiselected47").innerHTML=allowLogon;
//            document.getElementById("usersmultiselected48").innerHTML=html;
//            document.getElementById("usersmultiselected49").innerHTML=html;
//            document.getElementById("usersmultiselected50").innerHTML=html;
//                           
//            multi();
//
//
//        }
//    });
//    
//});


function multi() {
    //alert(")");
    $("#usersmultiselected8").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected9").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected10").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected11").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected12").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected13").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected14").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected15").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected16").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected17").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected18").multiselect({
        includeSelectAllOption: true
    });
    $("#usersmultiselected19").multiselect({
        includeSelectAllOption: true
    });
    $("#usersmultiselected20").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected21").multiselect({
        includeSelectAllOption: true
    });

    $("#usersmultiselected22").multiselect({
        includeSelectAllOption: true
    });
    $('#usersmultiselected23').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100,
        maxWidth: 100
    });
    $('#usersmultiselected24').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected25').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected26').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected27').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected28').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected29').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected30').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected31').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected32').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected33').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected34').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected35').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected36').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected37').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected38').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    })
            ;
    $('#usersmultiselected39').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected40').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected41').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected42').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected43').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected44').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected45').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected46').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected47').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected48').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected49').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });
    $('#usersmultiselected50').multiselect({
        includeSelectAllOption: true,
        maxHeight: 100
    });

    $("#usersmultiselected51").multiselect({
        includeSelectAllOption: true
    });
}

function getrightassignvalues() {
    // alert($('#oemtype').val())

    var getuser = 'getrightassign';
    $.ajax({
        url: getuser,
        type: 'POST',
        // dataType:'json',
        data: "oemtype=" + $('#oemtype').val()
    }).done(function (data) {
        $('#showw').show();
       
        var pollingHost = data;
        var d = pollingHost.split(",");
        var length = d.length - 1;

        var html8 = "";
        var html9 = "";
        var html10 = "";
        var html11 = "";
        var html12 = "";
        var html13 = "";
        var html14 = "";
        var html15 = "";
        var html16 = "";
        var html17 = "";
        var html18 = "";
        var html19 = "";
        var html20 = "";
        var html21 = "";
        var html22 = "";
        var html23 = "";
        var html24 = "";
        var html25 = "";
        var html26 = "";
        var html27 = "";
        var html28 = "";
        var html29 = "";
        var html30 = "";
        var html31 = "";
        var html32 = "";
        var html33 = "";
        var html34 = "";
        var html35 = "";
        var html36 = "";
        var html37 = "";
        var html38 = "";
        var html39 = "";
        var html40 = "";
        var html41 = "";
        var html42 = "";
        var html43 = "";
        var html44 = "";
        var html45 = "";
        var html46 = "";
        var html47 = "";
        var html48 = "";
        var html49 = "";
        var html50 = "";
        var html51 = "";


        html8 += " <select class='form-control'  id='usersmultiselected8' name='usersmultiselected8'  multiple='multiple'>";
        html9 += " <select class='form-control'  id='usersmultiselected9' name='usersmultiselected9'  multiple='multiple'>";
        html10 += " <select class='form-control'  id='usersmultiselected10' name='usersmultiselected10'  multiple='multiple'>";
        html11 += " <select class='form-control'  id='usersmultiselected11' name='usersmultiselected11'  multiple='multiple'>";
        html12 += " <select class='form-control'  id='usersmultiselected12' name='usersmultiselected12'  multiple='multiple'>";
        html13 += " <select class='form-control'  id='usersmultiselected13' name='usersmultiselected13'  multiple='multiple'>";
        html14 += " <select class='form-control'  id='usersmultiselected14' name='usersmultiselected14'  multiple='multiple'>";
        html15 += " <select class='form-control'  id='usersmultiselected15' name='usersmultiselected15'  multiple='multiple'>";
        html16 += " <select class='form-control'  id='usersmultiselected16' name='usersmultiselected16'  multiple='multiple'>";
        html17 += " <select class='form-control'  id='usersmultiselected17' name='usersmultiselected17'  multiple='multiple'>";

        html18 += " <select class='form-control'  id='usersmultiselected18' name='usersmultiselected18'  multiple='multiple'>";
        html19 += " <select class='form-control'  id='usersmultiselected19' name='usersmultiselected19'  multiple='multiple'>";
        html20 += " <select class='form-control'  id='usersmultiselected20' name='usersmultiselected20'  multiple='multiple'>";
        html21 += " <select class='form-control'  id='usersmultiselected21' name='usersmultiselected21'  multiple='multiple'>";
        html22 += " <select class='form-control'  id='usersmultiselected22' name='usersmultiselected22'  multiple='multiple'>";
        html23 += " <select class='form-control'  id='usersmultiselected23' name='usersmultiselected23'  multiple='multiple'>";
        html24 += " <select class='form-control'  id='usersmultiselected24' name='usersmultiselected24'  multiple='multiple'>";
        html25 += " <select class='form-control'  id='usersmultiselected25' name='usersmultiselected25'  multiple='multiple'>";
        html26 += " <select class='form-control'  id='usersmultiselected26' name='usersmultiselected26'  multiple='multiple'>";
        html27 += " <select class='form-control'  id='usersmultiselected27' name='usersmultiselected27'  multiple='multiple'>";

        html28 += " <select class='form-control'  id='usersmultiselected28' name='usersmultiselected28'  multiple='multiple'>";
        html29 += " <select class='form-control'  id='usersmultiselected29' name='usersmultiselected29'  multiple='multiple'>";
        html30 += " <select class='form-control'  id='usersmultiselected30' name='usersmultiselected30'  multiple='multiple'>";
        html31 += " <select class='form-control'  id='usersmultiselected31' name='usersmultiselected31'  multiple='multiple'>";
        html32 += " <select class='form-control'  id='usersmultiselected32' name='usersmultiselected32'  multiple='multiple'>";
        html33 += " <select class='form-control'  id='usersmultiselected33' name='usersmultiselected33'  multiple='multiple'>";
        html34 += " <select class='form-control'  id='usersmultiselected34' name='usersmultiselected34'  multiple='multiple'>";
        html35 += " <select class='form-control'  id='usersmultiselected35' name='usersmultiselected35'  multiple='multiple'>";
        html36 += " <select class='form-control'  id='usersmultiselected36' name='usersmultiselected36'  multiple='multiple'>";
        html37 += " <select class='form-control'  id='usersmultiselected37' name='usersmultiselected37'  multiple='multiple'>";

        html38 += " <select class='form-control'  id='usersmultiselected38' name='usersmultiselected38'  multiple='multiple'>";
        html39 += " <select class='form-control'  id='usersmultiselected39' name='usersmultiselected39'  multiple='multiple'>";
        html40 += " <select class='form-control'  id='usersmultiselected40' name='usersmultiselected40'  multiple='multiple'>";
        html41 += " <select class='form-control'  id='usersmultiselected41' name='usersmultiselected41'  multiple='multiple'>";
        html42 += " <select class='form-control'  id='usersmultiselected42' name='usersmultiselected42'  multiple='multiple'>";
        html43 += " <select class='form-control'  id='usersmultiselected43' name='usersmultiselected43'  multiple='multiple'>";
        html44 += " <select class='form-control'  id='usersmultiselected44' name='usersmultiselected44'  multiple='multiple'>";
        html45 += " <select class='form-control'  id='usersmultiselected45' name='usersmultiselected45'  multiple='multiple'>";
        html46 += " <select class='form-control'  id='usersmultiselected46' name='usersmultiselected46'  multiple='multiple'>";
        html47 += " <select class='form-control'  id='usersmultiselected47' name='usersmultiselected47'  multiple='multiple'>";

        html48 += " <select class='form-control'  id='usersmultiselected48' name='usersmultiselected48'  multiple='multiple'>";
        html49 += " <select class='form-control'  id='usersmultiselected49' name='usersmultiselected49'  multiple='multiple'>";
        html50 += " <select class='form-control'  id='usersmultiselected50' name='usersmultiselected50'  multiple='multiple'>";
        html51 += " <select class='form-control'  id='usersmultiselected51' name='usersmultiselected51'  multiple='multiple'>";
       







        for (var i = 0; i < length; i++) {
            html8 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html9 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html10 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html11 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html12 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html13 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html14 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html15 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html16 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html17 += '<option value="' + d[i] + '">' + d[i] + '</option>';

            html18 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html19 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html20 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html21 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html22 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html23 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html24 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html25 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html26 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html27 += '<option value="' + d[i] + '">' + d[i] + '</option>';

            html28 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html29 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html30 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html31 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html32 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html33 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html34 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html35 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html36 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html37 += '<option value="' + d[i] + '">' + d[i] + '</option>';

            html38 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html39 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html40 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html41 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html42 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html43 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html44 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html45 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html46 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html47 += '<option value="' + d[i] + '">' + d[i] + '</option>';

            html48 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html49 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html50 += '<option value="' + d[i] + '">' + d[i] + '</option>';
            html51 += '<option value="' + d[i] + '">' + d[i] + '</option>';
//             d[i]="";
//           alert(html8)
        }

        //  $('#usersmultiselected8').replaceWith(html8);
        document.getElementById("um8").innerHTML = html8;
        document.getElementById("um9").innerHTML = html9;
        document.getElementById("um10").innerHTML = html10;
        document.getElementById("um51").innerHTML = html11;
        document.getElementById("um11").innerHTML = html12;
        document.getElementById("um12").innerHTML = html13;
        document.getElementById("um13").innerHTML = html14;
        document.getElementById("um14").innerHTML = html15;
        document.getElementById("um15").innerHTML = html16;
        document.getElementById("um16").innerHTML = html17;
        document.getElementById("um17").innerHTML = html18;
        document.getElementById("um18").innerHTML = html19;
        document.getElementById("um19").innerHTML = html20;
        document.getElementById("um20").innerHTML = html21;
        document.getElementById("um21").innerHTML = html22;
        document.getElementById("um22").innerHTML = html23;
        document.getElementById("um23").innerHTML = html24;
        document.getElementById("um24").innerHTML = html25;
        document.getElementById("um25").innerHTML = html26;
        document.getElementById("um26").innerHTML = html27;
        document.getElementById("um27").innerHTML = html28;
        document.getElementById("um28").innerHTML = html29;
        document.getElementById("um29").innerHTML = html30;
        document.getElementById("um30").innerHTML = html31;
        document.getElementById("um31").innerHTML = html32;
        document.getElementById("um32").innerHTML = html33;
        document.getElementById("um33").innerHTML = html34;
        document.getElementById("um34").innerHTML = html35;
        document.getElementById("um35").innerHTML = html36;
        document.getElementById("um36").innerHTML = html37;
        document.getElementById("um37").innerHTML = html38;
        document.getElementById("um38").innerHTML = html39;
        document.getElementById("um39").innerHTML = html40;
        document.getElementById("um40").innerHTML = html41;
        document.getElementById("um41").innerHTML = html42;
        document.getElementById("um42").innerHTML = html43;
        document.getElementById("um43").innerHTML = html44;
        document.getElementById("um44").innerHTML = html45;
        document.getElementById("um45").innerHTML = html46;
        document.getElementById("um46").innerHTML = html47;
        document.getElementById("um47").innerHTML = html48;
        document.getElementById("um48").innerHTML = html49;
        document.getElementById("um49").innerHTML = html50;
        document.getElementById("um50").innerHTML = html51;
       
        multi();

    });

   

}



//$("a[data-target=#modal-whitelistmodel1]").click(function(ev) {
//    ev.preventDefault();
//  
//   
//});
//$('#modal-whitelistmodel1').on('hidden.bs.modal', function () {
// location.reload();
//})


function onRighAssgmClick() {


    $('#modal-whitelistmodel').modal({
        show: true
    });

//    var Usergrid = $("#jqGrid");
//    var jwindowsUserData = Usergrid.jqGrid('getGridParam', 'data');
//    document.getElementById('windowsUserData').value=jwindowsUserData;
//                          
//    document.getElementById('serval').value=data;
//                            
//    var Groupgrid = $("#jqGridGroup");
//    var jwindowsGroupData = Groupgrid.jqGrid('getGridParam', 'data');
//                            
//    var JsonParams = JSON.stringify(jwindowsUserData);
//    var JsonGroupParams = JSON.stringify(jwindowsGroupData);
//    console.log(jwindowsGroupData);
//    var html="";                     
//    for(var i in jwindowsGroupData)
//    {
//        var id = jwindowsGroupData[i].NewGroup;
//        html+="<option value='"+id+"'>"+id+"</option>"
//        var name = jwindowsGroupData[i].NewGroup; 
//    }
//    
//    var html2="";   
//    
//    for(var i1 in jwindowsGroupData)
//    {
//        var id1 = jwindowsGroupData[i1].NewGroup;
//        if(id1=="agsuser01"){
//            html2+="<option value='"+id1+"' selected>"+id1+"</option>"
//        }else{
//            html2+="<option value='"+id1+"'>"+id1+"</option>"
//        }     
//        
//    }
//    var html3="";
//    var html4="";
//    var html5="";
//    var html7="";
//    for(var i2 in jwindowsGroupData)
//    {
//        var id2 = jwindowsGroupData[i2].NewGroup;
//        if(id2=="agsuser01"){
//            html7="<option value='"+id2+"' selected>"+id2+"</option>"
//        }else if(id2=="agsuser00"){
//            html4="<option value='"+id2+"' selected>"+id2+"</option>"
//        }else if(id2=="agsuser02"){
//            html5="<option value='"+id2+"' selected>"+id2+"</option>"
//        }
//        else {
//            html3+="<option value='"+id2+"'>"+id2+"</option>"
//        }     
//        
//    }
//    
//    var html10="";
//    var html11="";
//    var html14="";
//    for(var i3 in jwindowsGroupData)
//    {
//        var id3 = jwindowsGroupData[i3].NewGroup;
//        if(id3=="agsuser01"){
//            html10="<option value='"+id3+"' selected>"+id3+"</option>"
//            html14="<option value='"+id3+"'>"+id3+"</option>"
//        }
//        else {
//            html11+="<option value='"+id3+"'>"+id3+"</option>"
//        }     
//        
//    }
//    console.log(html3+"html3"); 
//    var html9=html10+html11;
//    var html6=html4+html7+html3;
//    var html8=html4+html7+html5+html3;
//    var html12=html4+html14+html5+html3
//    console.log(html6+"html6");  
//    document.getElementById('usersmultiselected8').innerHTML=html;
//    document.getElementById('usersmultiselected9').innerHTML=html;
//    document.getElementById('usersmultiselected10').innerHTML=html;
//    document.getElementById('usersmultiselected11').innerHTML=html9;
//    document.getElementById('usersmultiselected12').innerHTML=html8;
//    document.getElementById('usersmultiselected13').innerHTML=html;
//    document.getElementById('usersmultiselected14').innerHTML=html9;
//    document.getElementById('usersmultiselected15').innerHTML=html8;
//    document.getElementById('usersmultiselected16').innerHTML=html6;
//    document.getElementById('usersmultiselected17').innerHTML=html6;
//    document.getElementById('usersmultiselected18').innerHTML=html9;
//    document.getElementById('usersmultiselected19').innerHTML=html;
//    document.getElementById('usersmultiselected20').innerHTML=html9;
//    document.getElementById('usersmultiselected21').innerHTML=html;
//    document.getElementById('usersmultiselected22').innerHTML=html9;
//    document.getElementById('usersmultiselected23').innerHTML=html9;
//    document.getElementById('usersmultiselected24').innerHTML=html;
//    document.getElementById('usersmultiselected25').innerHTML=html;
//    document.getElementById('usersmultiselected26').innerHTML=html;
//    document.getElementById('usersmultiselected27').innerHTML=html;
//    document.getElementById('usersmultiselected28').innerHTML=html;
//    document.getElementById('usersmultiselected29').innerHTML=html;
//    document.getElementById('usersmultiselected30').innerHTML=html;
//    document.getElementById('usersmultiselected31').innerHTML=html;
//    document.getElementById('usersmultiselected32').innerHTML=html9;
//    document.getElementById('usersmultiselected33').innerHTML=html12;
//    document.getElementById('usersmultiselected34').innerHTML=html9;
//    document.getElementById('usersmultiselected35').innerHTML=html9;
//    document.getElementById('usersmultiselected36').innerHTML=html;
//    document.getElementById('usersmultiselected37').innerHTML=html;
//    document.getElementById('usersmultiselected38').innerHTML=html;
//    document.getElementById('usersmultiselected39').innerHTML=html9;
//    document.getElementById('usersmultiselected40').innerHTML=html;
//    document.getElementById('usersmultiselected41').innerHTML=html9;
//    document.getElementById('usersmultiselected42').innerHTML=html9;
//    document.getElementById('usersmultiselected43').innerHTML=html9;
//    document.getElementById('usersmultiselected44').innerHTML=html9;
//    document.getElementById('usersmultiselected45').innerHTML=html9;
//    document.getElementById('usersmultiselected46').innerHTML=html;
//    document.getElementById('usersmultiselected47').innerHTML=html9;
//    document.getElementById('usersmultiselected48').innerHTML=html6;
//    document.getElementById('usersmultiselected49').innerHTML=html;
//    document.getElementById('usersmultiselected50').innerHTML=html;
//    document.getElementById('usersmultiselected51').innerHTML=html;




//$('#usersmultiselected8').val(html);


//  $('#usersmultiselected8').multiselect({
//                        maxHeight: 100
//                    });
//
//                    $('#usersmultiselected9').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected10').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected11').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected12').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected13').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected14').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected15').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected16').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected17').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected18').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected19').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected20').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected21').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected22').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected23').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected24').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected25').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected26').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected27').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected28').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected29').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected30').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected31').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected32').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected33').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected34').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected35').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected36').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected37').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected38').multiselect({
//                        maxHeight: 100
//                    })
//                    ;$('#usersmultiselected39').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected40').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected41').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected42').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected43').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected44').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected45').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected46').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected47').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected48').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected49').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected50').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#usersmultiselected51').multiselect({
//                        maxHeight: 100
//                    });
//                    $('#example-multiple-selected1').multiselect({
//                        maxHeight: 100
//                    })
}


function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
        vars[key] = value;
    });
    return vars;
}

$(document).ready(function () {
    //  $("#jqGridPager").jqGrid('navGrid','#pager',{},{width:500});
    //alert("jqgrid")
    var id = getUrlVars()["id"];

    jQuery.extend(jQuery.jgrid.edit, {
        closeAfterAdd: true,
        closeAfterEdit: true,
        recreateForm: true
                //...
    });


    var jsondatagroup = [
        {
            "GroupName": "Administrator",
            "NewGroup": "temp@123",
            "Type": "Built-In",
            "Action": ""

        }];



    var jsondata = [
        {
            "UserName": "Administrator",
            "Password": "temp@123",
            "Type": "Build-In",
            "Group": "Administrator",
            "Status": "Active",
            "New UserName": "Administrator",
            "Password Controll": "Build-In",
            "Disable Access": ""
        },
    ];
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var userurl = base_url + "/OS/getuserPolicy";

    
    $("#jqGrid").jqGrid({
        url: userurl,
        editurl: 'clientArray',
        mtype: "GET",
        datatype: "json",
        dataType: 'json',
        postData: {
            polid: id
        },
        page: 1,
        colModel: [
            {
                label: 'Type',
                name: 'Type',
                width: 100,
                editable: true,
                edittype: "custom",
                editoptions: {
                    custom_value: getUserType,
                    custom_element: createUserType
                }

            }, {
                label: 'Username',
                name: 'UserName',
                id: 'UserName',
                edittype: "text",
                editable: true,
                width: 100
            },
            {
                label: 'New Username',
                name: 'New UserName',
                edittype: "text",
                editable: true,
                width: 100
            }, {
                name: 'Password',
                index: 'Password',
                width: 80,
                align: "right",
                editable: true,
                // It is hidden from the table view... 
                hidden: true,
                editrules: {
                    // ...but we can edit it from the panel
                    edithidden: true,
                    // We are using a custom verification
                    custom: true,
                    // This is the function we have created
                    // to verify the passwords
                    custom_func: customPassCheck
                },
                edittype: 'password',
                // Our custom formatter that will blank the 
                // password when editing it
                formatter: customPassFormat,
                editoptions: {
                    // This is where the magic happens: it will add
                    // the password check input on the fly when editing
                    // from the editing panel.
                    dataInit: createPassCheck
                }
            },
            //       {
            //            label: 'Re Enter Password',
            //            name: 'RePassword',
            //            type: 'password' ,
            //            width: 100,
            //            editable: true,
            //            hidden: true,             
            //            editrules: {
            //                edithidden: true
            //            }, 
            //         
            //            hidedlg: true,
            //       
            //            edittype: "password"
            //    
            //        }, 



            {
                label: 'Status',
                name: 'Status',
                width: 100,
                editable: true,
                edittype: "custom",
                editoptions: {
                    custom_value: getFreightElementValue,
                    custom_element: createFreightEditElement
                }
                //                            editoptions: {
                //                                value: "Enable:Enable;Disable:Disable"
                //                            }
            },
            {
                label: 'Group',
                name: 'Group',
                width: 100,
                editable: true,
                edittype: "text"

            },
            {
                label: 'Shell',
                name: 'Shell',
                width: 100,
                editable: true,
                edittype: "text",
                editoptions: {
                    custom_value: customShellCheck,
                }
            },
            {
                label: 'Password Control',
                name: 'Password Control',
                width: 100,
                editable: true,
                edittype: "custom",
                align: "center",
                editoptions: {
                    custom_value: getPassPolicyValue,
                    custom_element: createPassPolicy
                }

            },
            {
                label: 'Disable Access',
                name: 'Disable Access',
                width: 100,
                editable: true,
                edittype: "custom",
                editoptions: {
                    custom_value: getAccessPolicyValue,
                    custom_element: createAccessPolicy
                }
            },
        ],
        loadonce: true,
        viewrecords: true,
        height: 200,
        rowNum: 10,
        width:  650,
        addCaption: 'Contact List',
        pager: "#jqGridPager"

    });

    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var groupurl = base_url + "/OS/getgroupPolicy";
	
	
    $("#jqGridGroup").jqGrid({
        url: groupurl,
        editurl: 'clientArray',
        mtype: "GET",
        datatype: "json",
        data1: jsondatagroup,
        postData: {
            polid: id
        },
        page: 1,
        colModel: [
            {
                label: 'Type',
                name: 'Type',
                width: 100,
                editable: true,
                edittype: "custom",
                editoptions: {
                    custom_value: getGroupType,
                    custom_element: createGroupType
                }
            }, {
                label: 'Group Name',
                name: 'GroupName',
                editable: true,
                key: false,
                width: 100
            },
            {
                label: 'New Group',
                name: 'NewGroup',
                width: 100,
                editable: true,
                edittype: "text"
            },
            {
                label: 'Actions',
                name: 'Actions',
                width: 100,
                visible: true,
                editable: true,
                edittype: "custom",
                editoptions: {
                    custom_value: getgroupStatus,
                    custom_element: groupStatus
                }
            }

        ],
        loadonce: true,
        viewrecords: true,
        height: 200,
        rowNum: 10,
        width: 650,
        pager: "#jqGridPagerGroup"



                //add by rahul



    });



    $("#jqGridGroup").navGrid("#jqGridPagerGroup",
            {
                edit: true,
                add: true,
                del: true,
                search: false,
                refresh: true,
                view: true,
                align: "left"
            },
    // add first custom button

    {
        closeAfterEdit: true,
        focusField: 1
    }
    );



    $("#jqGrid").navGrid("#jqGridPager",
            {
                edit: true,
                add: true,
                del: true,
                search: false,
                refresh: true,
                view: false,
                align: "left"
            },
    {
        closeAfterEdit: true,
        focusField: 1,
        width: 800
    }, {
        closeAfterAdd: true,
        recreateForm: true,
        width: 800,
        addCaption: 'Create/Update User'
    }
    );
    $("#jqGrid").jqGrid('navGrid', '#jqGridPager', {}, {
        width: 700
    });
    function customPassCheck(cellvalue, cellname) {
        // Get a reference to the password check input box. You see
        // the 'tr_passwordCheck' id we are using? We set that id in
        // the function "createPassCheck".
        var passCheckVal = $("#tr_passwordCheck input").val();
        var userName = $("#UserName").val();
        var usertypecheckbox = $("input:radio[name=usertype]:checked").val();
        //var passlenght =   $("#MINPWLEN input").val();
        // alert(passlenght);
        // If both fields are empty or the passwords match
        // we can submit this form.

        var complexityRule = document.getElementById("passcomplexityParam").value;
        if (usertypecheckbox == "Built-In") {
            if (userName != "") {

                if (
                        (cellvalue == "" && passCheckVal == "")
                        ||
                        cellvalue == passCheckVal
                        ) {
                    return [true, ""];
                }
                return [false, "Password and password check don't match."];
            } else {

                return [false, "Enter existing Username."];
            }

        } else if (usertypecheckbox == "Custom") {
            if ((cellvalue == "" && passCheckVal == "")) {

                return [false, "Please provide password for user"];
            }


            if (cellvalue == passCheckVal) {
                if (complexityRule == "Enable") {
                    if (isStrongPwd1(passCheckVal)) {
                        return [true, ""];
                    } else {
                        return [false, "Password must meet complexity rule."];
                    }
                } else {
                    return [true, ""];
                }
            } else {
                return [false, "Password and password check don't match."];

            }

        }



        // Can you guess why we are here?

    }


    function createPassCheck(el) {
        // Create the containing table row
        var passCheck = $("<tr></tr>").addClass("FormData")
                .attr({
                    id: "tr_passwordCheck",
                    rowpos: 20
                });
        // Create a cell for the label and add it to the row
        var passCheckLabelTd = $("<td style='font-weight: 700;'></td>")
                .addClass("CaptionTD").text("Confirm Password");
        passCheck.append(passCheckLabelTd);
        // Prepare the cell for the input box. All
        // the cells have a non breaking space, we add
        // one as well to keep aligned. We then add it to the row.
        var passCheckTd = $("<td>&nbsp;</td>")
                .addClass("DataTD");
        passCheck.append(passCheckTd);
        // Create an input box, and add it to the input cell 
        var passCheckInput = $("<input style='margin-left:-4px; height: 36px; border: 1px solid #d2d6de;'></input>")
                .addClass("FormElement ui-widget-content ui-corner-all")
                .attr({
                    id: "passwordCheck",
                    name: "passwordCheck",
                    role: "textbox",
                    width: "20%",
                    type: "password"
                });
        passCheckTd.append(passCheckInput);
        // Finally append the row to the table, we have been called after
        // the creation of the password row, it will be appended after it.
        var tbodyEl = el.parentNode.parentNode.parentNode;
        tbodyEl.appendChild(passCheck[0]);
    }

    function customPassFormat(cellvalue, options, rowObject) {
        // When asked to format a password for display, simply
        // show a blank. It will make it a bit easier when
        // we editing an object without changing the password.
        return "";
    }





    function groupStatus(value, editOptions) {

        var div = $("<div id='checkboxgroupstatus' style='margin-bottom:5px;margin-top:-10px;'>");
        var label = $("<label>&nbsp&nbsp</label>");
        var radio = $("<input>", {
            type: "radio",
            value: "Active",
            name: "groupstatus",
            id: "activecheckbox",
            checked: (value == "Active" || value == "")
        });
        label.append(radio).append("Active");

        var label2 = $("<label>&nbsp&nbsp</label>");
        var radio2 = $("<input>", {
            type: "radio",
            value: "Delete",
            name: "groupstatus",
            id: "deletecheckbox",
            checked: (value == "Delete")
        });
        label2.append(radio2).append("Delete");


        div.append(label).append(label2).append("</div>");

        return div;
    }

    // The javascript executed specified by JQGridColumn.EditTypeCustomGetValue when EditType = EditType.Custom
    // One parameter passed - the custom element created in JQGridColumn.EditTypeCustomCreateElement
    function getgroupStatus(elem, oper, value) {


        $("#input[name=groupstatus][value='" + value + "']").prop("checked", true);
        if (oper === "set") {
            var radioButton = $(elem).find("input[value='" + value + "']");


            if (radioButton.length > 0) {
                radioButton.prop("checked", true);
            }
            var radioButton = $(elem).find("input[value='" + value + "']");
        }

        if (oper === "get") {

            var checkedValue = new Array();
            //   $("input:radio[name=statuspol]:checked").each(function(){

            // checkedValue.push($(this).val());

            return $(elem).find("input:radio[name=groupstatus]:checked").val();
            //   });
            //return checkedValue;
            //   return "NS" ;
        }
    }


    function isStrongPwd1(password) {

        var regExp = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&*()]).{8,}/;

        var validPassword = regExp.test(password);

        return validPassword;

    }



    function createFreightEditElement(value, editOptions) {
        var checkArrayList = new Array();
        var str_array = value.split(',');
        for (var i = 0; i < str_array.length; i++) {
            str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
            checkArrayList.push(str_array[i]);
        }
        var radio, radio1, radio2, radio3;

        var div = $("<div style='margin-bottom:5px;margin-top:-10px;'></div>");

        var label = $("<label style='font-weight: 500;'>&nbsp&nbsp</label>");
        var label1 = $("<label style='font-weight: 500;'>&nbsp&nbsp</label>");
        var label2 = $("<label style='font-weight: 500;'>&nbsp&nbsp</label>");
        radio = $("<input>", {
            type: "radio",
            value: "Active",
            name: "statuspol",
            id: "Activecheckbox",
            checked: (checkArrayList.includes("Active") || value == "")
        });



        radio1 = $("<input>", {
            type: "radio",
            value: "Disable",
            name: "statuspol",
            id: "Disablecheckbox",
            checked: checkArrayList.includes("Disable")
        });



        radio2 = $("<input>", {
            type: "radio",
            value: "Delete",
            name: "statuspol",
            id: "Deletecheckbox",
            checked: checkArrayList.includes("Delete")
        });

        label.append(radio).append("Active");
        label1.append(radio1).append("Disable");
        label2.append(radio2).append("Delete");
        div.append(label).append(label1).append(label2);

        return div;
    }

    // The javascript executed specified by JQGridColumn.EditTypeCustomGetValue when EditType = EditType.Custom
    // One parameter passed - the custom element created in JQGridColumn.EditTypeCustomCreateElement
    function getFreightElementValue(elem, oper, value) {
        if (oper === "set") {

            var radioButton = $(elem).find("input:radio[value='" + value + "']");
            $("input:radio[name=statuspol][value='" + value + "']").prop("checked", true);

            if (radioButton.length > 0) {
                radioButton.prop("checked", true);
            }
        }

        if (oper === "get") {

            var checkedValue = new Array();
            //   $("input:radio[name=statuspol]:checked").each(function(){

            // checkedValue.push($(this).val());

            return $(elem).find("input:radio[name=statuspol]:checked").val();
            //   });
            //return checkedValue;
            //   return "NS" ;
        }
    }



    function createUserType(value, editOptions) {


        var radio, radio1, radio2, radio3;
        var div = $("<div style='margin-bottom:5px;margin-top:-10px;'></div>");
        var label = $("<label style='font-weight: 500;'>&nbsp&nbsp</label>");
        var label1 = $("<label style='font-weight: 500;'>&nbsp&nbsp</label>");
        var label2 = $("<label style='font-weight: 500;'>&nbsp&nbsp</label>");
        var checkArrayList = new Array();
        var str_array = value.split(',');
        for (var i = 0; i < str_array.length; i++) {
            str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
            checkArrayList.push(str_array[i]);
        }
        console.log(value);



        if (checkArrayList.includes("Built-In")) {

            radio = $("<input>", {
                type: "radio",
                value: "Built-In",
                name: "usertype",
                onclick: "onusertypeClick(this.value)",
                id: "usertypecheckbox1",
                checked: true
            });
        } else {

            if (value != "") {
                radio = $("<input>", {
                    type: "radio",
                    value: "Built-In",
                    name: "usertype",
                    onclick: "onusertypeClick(this.value)",
                    id: "usertypecheckbox1"

                });

            } else {

                radio = $("<input>", {
                    type: "radio",
                    value: "Built-In",
                    name: "usertype",
                    checked: true,
                    onclick: "onusertypeClick(this.value)",
                    id: "usertypecheckbox1"

                });
            }
        }
        if (checkArrayList.includes("Custom")) {
            radio1 = $("<input> ", {
                type: "radio",
                value: "Custom",
                onclick: "onusertypeClick(this.value)",
                checked: true,
                name: "usertype",
                id: "usertypecheckbox22"

            });
        } else {
            radio1 = $("<input> ", {
                type: "radio",
                value: "Custom",
                onclick: "onusertypeClick(this.value)",
                name: "usertype",
                id: "usertypecheckbox22"

            });
        }

        label.append(radio).append("Existing");
        label1.append(radio1).append("Custom");

        div.append(label1).append(label);

        return div;
    }

    function createGroupType(value, editOptions) {

        var div = $("<div style='margin-bottom:5px;margin-top:-10px;'></div>");
        var label = $("<label>&nbsp&nbsp</label>");
        var radio = $("<input>", {
            type: "radio",
            value: "Built-In",
            name: "grouptype",
            onclick: "ongrouptypeClick(this.value)",
            id: "grouptypecheckbox22",
            checked: true
        });
        label.append(radio).append("Existing");

        var label1 = $("<label >&nbsp&nbsp</label>");
        var radio1 = $("<input> ", {
            type: "radio",
            value: "Custom",
            onclick: "ongrouptypeClick(this.value)",
            checked: false,
            name: "grouptype",
            id: "grouptypecheckbox22"

        });
        label1.append(radio1).append("Custom");

        div.append(label1).append(label);

        return div;
    }






    // The javascript executed specified by JQGridColumn.EditTypeCustomGetValue when EditType = EditType.Custom
    // One parameter passed - the custom element created in JQGridColumn.EditTypeCustomCreateElement
    function getUserType(elem, oper, value) {


        if (oper === "set") {

            var radioButton = $(elem).find("input:radio[value='" + value + "']");
            if (radioButton.length > 0) {
                radioButton.prop("checked", true);
            }
        }

        if (oper === "get") {

            var checkedValue = new Array();

            //   $("input:radio[name=statuspol]:checked").each(function(){

            // checkedValue.push($(this).val());

            return $(elem).find("input:radio[name=usertype]:checked").val();
            //   });
            //return checkedValue;
            //   return "NS" ;
        }
    }



    function getGroupType(elem, oper, value) {
        if (oper === "set") {
            var radioButton = $(elem).find("input:radio[value='" + value + "']");


            if (radioButton.length > 0) {
                radioButton.prop("checked", true);
            }
        }

        if (oper === "get") {

            var checkedValue = new Array();
            //   $("input:radio[name=statuspol]:checked").each(function(){

            // checkedValue.push($(this).val());

            return $(elem).find("input:radio[name=grouptype]:checked").val();
            //   });
            //return checkedValue;
            //   return "NS" ;
        }
    }


    function shellcheck(nospace) {

        var re = /^[A-Za-z]+$/;

        var validShell = re.test(nospace);

        return validShell;

    }


    function customShellCheck() {
        var shellvalue = $("#Shell").val();
       
        if (shellcheck(shellvalue)) {
            return [true, ""];
        } else {
            return [false, "Word should not consist space"];
        }
    }


    function createAccessPolicy(value, editOptions) {


        var radio, radio1, radio2, radio3, radio4, radio5, radio6, radio7;
        var div = $("<div style='margin-bottom:5px;margin-top:-10px;'></div>");
        var label = $("<label class='radio-inline'>Command Prompt</label>");
        var label1 = $("<label  class='radio-inline'>Registry</label>");
        var label2 = $("<label  class='radio-inline'>Task Manager</label>");
        var label3 = $("<label  class='radio-inline' >Lock</label>");
        var label4 = $("<label  class='radio-inline' >Shutdown</label>");
        var label6 = $("<label  class='radio-inline' >Log Off</label>");
        var label7 = $("<label  class='radio-inline' >Run</label>");
        var checkArrayList = new Array();
        var str_array = value.split(',');
        for (var i = 0; i < str_array.length; i++) {
            str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
            checkArrayList.push(str_array[i]);
        }

        if (checkArrayList.includes("cmd")) {
            radio = $("<input>", {
                type: "checkbox",
                value: "cmd",
                name: "access",
                checked: true,
                id: "cmdcheckbox"
            });

        } else {
            radio = $("<input>", {
                type: "checkbox",
                value: "cmd",
                name: "access",
                id: "cmdcheckbox"
            });

        }
        if (checkArrayList.includes("registry")) {
            radio1 = $("<input>", {
                type: "checkbox",
                value: "registry",
                name: "access",
                checked: true,
                id: "registrycheckbox"
            });


        } else {
            radio1 = $("<input>", {
                type: "checkbox",
                value: "registry",
                name: "access",
                id: "registrycheckbox"
            });
        }
        if (checkArrayList.includes("taskmanager")) {
            radio2 = $("<input>", {
                type: "checkbox",
                value: "taskmanager",
                name: "access",
                checked: true,
                id: "taskmanagercheckbox"
            });
        } else {
            radio2 = $("<input>", {
                type: "checkbox",
                value: "taskmanager",
                name: "access",
                id: "taskmanagercheckbox"
            });
        }
        if (checkArrayList.includes("lock")) {
            radio3 = $("<input>", {
                type: "checkbox",
                value: "lock",
                name: "access",
                checked: true,
                id: "lockcheckbox"

            });
        } else {
            radio3 = $("<input>", {
                type: "checkbox",
                value: "lock",
                name: "access",
                id: "lockcheckbox"

            });
        }
        if (checkArrayList.includes("shutdown")) {
            radio4 = $("<input>", {
                type: "checkbox",
                value: "shutdown",
                name: "access",
                checked: true,
                id: "shutdowncheckbox"
            });

        } else {
            radio4 = $("<input>", {
                type: "checkbox",
                value: "shutdown",
                name: "access",
                id: "shutdowncheckbox"
            });

        }
        if (checkArrayList.includes("logoff")) {
            radio6 = $("<input>", {
                type: "checkbox",
                value: "logoff",
                name: "access",
                checked: true,
                id: "logoffcheckbox"
            });
        } else {
            radio6 = $("<input>", {
                type: "checkbox",
                value: "logoff",
                name: "access",
                id: "logoffcheckbox"
            });
        }
        if (checkArrayList.includes("run")) {
            radio7 = $("<input>", {
                type: "checkbox",
                value: "run",
                name: "access",
                checked: true,
                id: "runcheckbox"
            });
        } else {
            radio7 = $("<input>", {
                type: "checkbox",
                value: "run",
                name: "access",
                id: "runcheckbox"
            });
        }
        label.append(radio).append("");
        label1.append(radio1).append("");
        label2.append(radio2).append("");
        label3.append(radio3).append("");
        label4.append(radio4).append("");
        label6.append(radio6).append("");
        label7.append(radio7).append("");

        div.append(label).append(label1).append(label2).append(label3).append(label4).append(label6).append(label7);

        return div;
    }

    // The javascript executed specified by JQGridColumn.EditTypeCustomGetValue when EditType = EditType.Custom
    // One parameter passed - the custom element created in JQGridColumn.EditTypeCustomCreateElement
    function getAccessPolicyValue(elem, oper, value) {
        // alert(" checkedddd")
        // console.log(elem+"value rahul:"+oper);

        // $("#cmdcheckbox" ).prop( "checked", true );
        //console.log("after value rahul:"+oper);
        //        if (oper === "set") {
        //            var checkArrayList = new Array();
        //            var str_array = value.split(',');
        //            for(var i = 0; i < str_array.length; i++) {
        //                // Trim the excess whitespace.
        //                str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
        //                // Add additional code here, such as:
        //                checkArrayList.push(str_array[i]); 
        //            // $('input[id='+str_array[i]+'checkbox]').attr('checked', true);
        //             
        //            //  $('#cmdcheckbox').find("input:checkbox[name=access][value='passexpirycheckbox']").prop("checked", true);
        //            }
        //            console.log(checkArrayList.includes("cmd"));
        //            if(checkArrayList.includes("cmd")){
        //                $('input[id=cmdcheckbox]').attr('checked', true);
        //            }else {
        //                $('input[id=cmdcheckbox]').attr('checked', false);
        //            }
        //            if(checkArrayList.includes("registry")){
        //                $('input[id=registryheckbox]').attr('checked', true);
        //            }else {
        //                $('input[id=registrycheckbox]').attr('checked', false);
        //            }
        //            if(checkArrayList.includes("taskmanager")){
        //                $('input[id=taskmanagercheckbox]').attr('checked', true);
        //            }else {
        //                $('input[id=taskmanagercheckbox]').attr('checked', false);
        //            }
        //            if(checkArrayList.includes("lock")){
        //                $('input[id=lockcheckbox]').attr('checked', true);
        //            }else {
        //                $('input[id=lockcheckbox]').attr('checked', false);
        //            }
        //            if(checkArrayList.includes("shutdown")){
        //                $('input[id=shutdowncheckbox]').attr('checked', true);
        //            }else {
        //                $('input[id=shutdowncheckbox]').attr('checked', false);
        //            }
        //            if(checkArrayList.includes("logoff")){
        //                $('input[id=logoffcheckbox]').attr('checked', true);
        //            }else {
        //                $('input[id=logoffcheckbox]').attr('checked', false);
        //            }
        //            checkArrayList=[] ;
        //        }


        if (oper === "get") {
            var checkedValue = new Array();
            $("input:checkbox[name=access]:checked").each(function () {

                checkedValue.push($(this).val());
            });

            if (checkedValue.length > 0) {
                console.log(checkedValue);
                return checkedValue;
            } else {

                return "";
            }
        }
    }


    function createPassPolicy(value, editOptions) {


        var checkArrayList = new Array();
        var str_array = value.split(',');
        for (var i = 0; i < str_array.length; i++) {
            str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
            checkArrayList.push(str_array[i]);
        }



        var radio, radio1;
        var div = $("<div style='margin-bottom:5px;margin-top:-10px;'></div>");
        var label = $("<label class='radio-inline'>Cant Change Password</label>");
        var label1 = $("<label  class='radio-inline'>Password Expires</label>");








        if (checkArrayList.includes("changepass")) {
            radio = $("<input>", {
                type: "checkbox",
                value: "changepass",
                name: "passpol",
                checked: true,
                id: "changepassdcheckbox"
            });
        } else {
            radio = $("<input>", {
                type: "checkbox",
                value: "changepass",
                name: "passpol",
                id: "changepassdcheckbox"
            });
        }
        if (checkArrayList.includes("passexpiry")) {
            radio1 = $("<input>", {
                type: "checkbox",
                value: "passexpiry",
                name: "passpol",
                checked: true,
                id: "passexpirycheckbox"
            });
        } else {
            radio1 = $("<input>", {
                type: "checkbox",
                value: "passexpiry",
                name: "passpol",
                id: "passexpirycheckbox"
            });
        }

        label.append(radio).append("");
        label1.append(radio1).append("");

        div.append(label).append(label1);

        return div;
    }

    // The javascript executed specified by JQGridColumn.EditTypeCustomGetValue when EditType = EditType.Custom
    // One parameter passed - the custom element created in JQGridColumn.EditTypeCustomCreateElement
    function getPassPolicyValue(elem, oper, value) {


        if (oper === "set") {

            $("input:checkbox[name=passpol][value='" + value + "']").prop("selected", true);

        }

        if (oper === "get") {
            var checkedValue = new Array();
            $("input:checkbox[name=passpol]:checked").each(function () {
                checkedValue.push($(this).val());


            });
            if (checkedValue.length > 0) {
                console.log(checkedValue);
                return checkedValue;
            } else {

                return "";
            }
        }
    }






});