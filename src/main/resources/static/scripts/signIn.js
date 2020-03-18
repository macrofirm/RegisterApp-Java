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
	employeeId = getEmployeeIdElement();
	password = getEmployeePasswordElement();
	if(isNaN(Number(employeeId.value)) || (Number(employeeId.value) <= 0)) {
		displayError("Invalid ID.");
		return false;
	}
	if((password.value == null) || (password.value.trim() === "")) {
		displayError("Invalid Password.")
		return false;
	}
	return true;
}
