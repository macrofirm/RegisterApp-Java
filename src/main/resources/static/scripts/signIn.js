document.addEventListener("DOMContentLoaded", function(event){
});

function getEmployeeIdElement() {
	return document.getElementById("employeeID");
}

function getEmployeePasswordElement() {
	return document.getElementById("password");
}

function getSignInActionElement() {
	return document.getElementById("signInButton");
}

function validateSignIn() {
	employeeID = getEmployeeIdElement();
	password = getEmployeePasswordElement();
	invalid = false;
	if(Number.isInteger(employeeID) || employeeID.value == "") {
		displayError("Invalid ID.");
		invalid = true;
	}
	else if(password.value == "") {
		displayError("Invalid Password.")
		invalid = true;
	}
	return invalid;
}
