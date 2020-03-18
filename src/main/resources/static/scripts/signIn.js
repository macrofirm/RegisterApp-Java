document.addEventListener("DOMContentLoaded", function(event){
});

function getEmployeeIdElement() {
	return document.getElementById("employeeId");
}

function getEmployeePasswordElement() {
	return document.getElementById("password");
}

function validateSignIn() {
	const employeeId = getEmployeeIdElement();
	const password = getEmployeePasswordElement();
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
