$(document).ready(function () {

    loadAssignedSelfTasks();

});

function loadAssignedSelfTasks() {

    var l = window.location;

    var base_url =
        l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];

    var serviceUrl =
        base_url + "/PMS/getTaskAssignedBySELF";

    if ($.fn.DataTable.isDataTable('#DevDelaysTableDetails')) {

        $('#DevDelaysTableDetails').DataTable().destroy();
    }

    $('#DevDelaysTableDetails').DataTable({

        processing: true,

        serverSide: true,

        destroy: true,

        pageLength: 10,

        scrollX: true,

        autoWidth: false,

        ordering: false,

        searching: true,

        ajax: function (data, callback, settings) {

            $("#spin12").show();

            $.ajax({

                url: serviceUrl,

                type: "GET",

                dataType: "json",

                data: {

                    start: data.start,

                    length: data.length
                },

                success: function (response) {

                    $("#spin12").hide();

                    var rows = [];

                    $.each(response, function (index, value) {

                        rows.push([

                            data.start + index + 1,

                            value.DEVELOPER_NAME || 'NA',

                            value.FUNCTION_NAME || 'NA',

                            value.END_DATE || 'NA',

                            value.MANAGER_NAME || 'NA',

                            value.MODULE_NAME || 'NA',

                            value.REMARK || 'NA',

                            value.RESPONSIBILITY || 'NA',

                            value.START_DATE || 'NA',

                            value.STATUS || 'NA',

                            value.TEAM_LEADER || 'NA',

                            value.CUSTOMERNAME || 'NA',

                            value.DESCRIPTION || 'NA',

                            value.PRIORITY || 'NA',

                            value.PRODUCTSUIT || 'NA',

                            value.PRODUCTTOOL || 'NA',

                            value.SUB_MODULE_NAME || 'NA',

                            value.WEIGHTAGE || 'NA',

                            value.ASSIGNBY || 'NA',

                            value.TESTER_NAME || 'NA',

                            value.Assign_date || 'NA',

                            value.TaskUpdateDate || 'NA',

                            value.Task_ID || 'NA',

                            value.dateUpdateBy || 'NA',

                            value.updateDateCount || 'NA',

                            value.updateDate_Status || 'NA',

                            value.updateEnd_Date || 'NA',

                            value.updateTimeDate || 'NA',

                            value.updateDates_Reason || 'NA',

                            value.updateStarts_Date || 'NA',

                            value.ONE_TIME || 'NA',

                            value.REQUESTED_DATE_REVISE || 'NA',

                            value.Assign_time || 'NA'

                            
                        ]);
                    });

                    callback({

                        draw: data.draw,

                        recordsTotal: 5000,

                        recordsFiltered: 5000,

                        data: rows
                    });
                },

                error: function (xhr, status, error) {

                    $("#spin12").hide();

                    console.log(error);

                    alert("Failed to load data");
                }
            });
        },

        dom: 'Blfrtip',

		buttons: [
		    {
		        extend: 'excel',
		        text: 'Export Excel',
		        filename: 'Self_Task_Report'
		    }
		]
    });
}