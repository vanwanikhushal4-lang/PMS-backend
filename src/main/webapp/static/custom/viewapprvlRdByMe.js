window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/viewapprvlRdByMe";
	
	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : "crno=" + $('#crnoo').val() + '&uid=' + $("#uid").val()
	}).done(function(data) {
		

		console.log(data)

		$('#functionName').val(decodeURIComponent(data[0][0]));
		$('#designation').val(decodeURIComponent(data[0][1]));
		$('#username').val(decodeURIComponent(data[0][2]));
		$('#userid').val(decodeURIComponent(data[0][3]));
		$('#description').val(decodeURIComponent(data[0][4]));

	});

}