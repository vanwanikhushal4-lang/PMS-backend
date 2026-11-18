var saveRegistrationService = getBaseURL() + "register/do"

function myFunction() {
	var firstName = document.getElementById("firstName").value;
	var lastName = document.getElementById("lastName").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var termsCheckBox = document.getElementById("termsCheckBox").value;
	var womenCheckBox = document.getElementById("womenCheckBox").value;
	// Returns successful data submission message when the entered information is stored in database.
	var dataString = 'name1=' + fisrtName + '&email1=' + email + '&password1=' + password;
	if (fisrtName == '' || lastName == '' || email == '' || password == '') {
	alert("Please Fill All Fields");
	} else {
	// AJAX code to submit form.
	$.ajax({
	type: "POST",
	url: saveRegistrationService,
	data: dataString,
	cache: false,
	success: function(html) {
	alert(html);
	}
	});
	}
	return false;
	}