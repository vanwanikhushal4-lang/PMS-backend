/**
 * Theme: Appzia Admin
 * Form Advanced
 */

!function(e){
    "use strict";
    var t=function(){};

    t.prototype.init=function(){
        jQuery("#timepicker").timepicker({
            showMeridian:!1,
            format: "hh:ii:ss"
            }),jQuery("#timepicker2").timepicker({
            showMeridian:!1
            }),jQuery("#timepicker4").timepicker({
          showMeridian:!1
            }),jQuery("#timepicker5").timepicker({
            showMeridian:!1
            }),jQuery("#timepicker6").timepicker({
           showMeridian:!1
            }),jQuery("#timepicker7").timepicker({
           showMeridian:!1
            }),jQuery("#timepicker8").timepicker({
          showMeridian:!1
            }),jQuery("#timepicker3").timepicker({
            minuteStep:15
        }),e("input[name='demo2']").TouchSpin({
            min:-1e9,
            max:1e9,
            stepinterval:50,
            maxboostedstep:1e7,
            prefix:"$"
        }),e("input[name='demo3']").TouchSpin(),e("input[name='demo3_21']").TouchSpin({
            initval:40
        }),e("input[name='demo3_22']").TouchSpin({
            initval:40
        }),e("input[name='demo5']").TouchSpin({
            prefix:"pre",
            postfix:"post"
        }),e("input[name='demo0']").TouchSpin({})
        },e.AdvancedForm=new t,e.AdvancedForm.Constructor=t
    }(window.jQuery),function(e){
    "use strict";
    e.AdvancedForm.init()
    }(window.jQuery);