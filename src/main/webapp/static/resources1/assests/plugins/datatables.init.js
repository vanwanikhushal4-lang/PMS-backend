/*
 Template Name: Upcube - Bootstrap 4 Admin Dashboard
 Author: Themesdesign
 Website: www.themesdesign.in
 File: Datatable js
 */

$(document).ready(function(){

    $("#datatable").DataTable();


    $.ajax({
        url:'downLinkAction',
        type:'post',
        dataType:'json',
        success: function(myBooks) {

            var a=$("#datatable-buttons").DataTable(
            {
                lengthChange:!1,
                "pageLength" : 10,
                data: myBooks,
                columns: [
                {
                    title: "Sr No"
                },
                {
                    title: "IP Address"
                },
                {
                    title: "Down Since"
                },
                {
                    title: "Interval"
                },
                {
                    title: "Customer"
                },
                {
                    title: "Project"
                }

                ],
                buttons:["copy","excel","pdf","colvis"],
                "oLanguage" : { // the caption next to the search box
                    "sSearch" : "Search:"
                }
            });

            a.buttons().container().appendTo("#datatable-buttons_wrapper .col-md-6:eq(0)")

        }
    });





});

  