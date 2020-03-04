document.addEventListener("DOMContentLoaded", () => {
    getSaveButtonElement().addEventListener("click", saveActionClick);

});

function saveActionClick(event){
    if(!validateSave()){
        return;
    }

    const saveActionElement = event.target;
    saveActionElement.disabled = true;
    console.log("Save function called.");
    //ToDo: finish code for saving here
    //Use Ajax methods to save the values
}

function validateSave(){
    firstName = getFirstNameElement();
    lastName = getLastNameElement();
    password = getPasswordElement();
    confirm = getConfirmElement();
    employeeType = getEmployeeType();
    valid = true;
    if(firstName.value == ""){
        displayError("First Name field is blank.");
        valid = false;
    }
    else if(lastName.value == ""){
        displayError("Last Name field is blank.");
        valid = false;
    }
    else if(password.value == ""){
        displayError("Password field is blank.");
        valid = false;
    }
    else if(confirm.value == ""){
        displayError("Confirm Password field is blank.");
        valid = false;
    }
    else if(password.value != confirm.value){
        displayError("Passwords must match.");
        valid = false;
    }
    else if(employeeType != "Cashier" && employeeType != "Shift Manager" && employeeType != "General Manager"){
        displayError("Employee Type Error.");
        valid = false;
    }
    else{
        displayError();
        valid = true;
    }
    return valid;
}

//getters
function getFirstNameElement() {
	return document.getElementById("firstName");
}

function getLastNameElement() {
    return document.getElementById("lastName");
}

function getPasswordElement(){
    return document.getElementById("password");
}

function getConfirmElement(){
    return document.getElementById("confirm");
}

function getEmployeeType(){
    return document.getElementById("employeeType");
}

function getSaveButtonElement(){
    return document.getElementById("saveButton");
}