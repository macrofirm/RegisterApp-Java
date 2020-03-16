let hideEmployeeSavedAlertTimer = undefined;
document.addEventListener("DOMContentLoaded", () => {
    getSaveButtonElement().addEventListener("click", saveActionClick);
    //detect if there is an active user or not
    /*
    const getUserUrl = ("../../../java/edu/uark/registerapp/commands/employees")
    if(user is active){
        get data of active user
        activeUser = true;
    }
    else{
        activeUser = false;
    }
    */
});

//save the active user
function saveActionClick(event){
    if(!validateSave()){
        return;
    }

    const saveActionElement = getSaveButtonElement();
    saveActionElement.disabled = true;
    console.log("Save function called. ");

    firstName = getFirstNameElement();
    lastName = getLastNameElement();
    password = getPasswordElement();
    employeeType = getEmployeeTypeElement();
    //Testing the set methods
    displayEmployeeIdRecord(69);
    setFirstNameElement("Steve");
    setLastNameElement("Johnson");
    setPasswordElement("password");
    setConfirmElement("password");
    setEmployeeTypeElement("Shift Manager");
    //ToDo: finish code for saving here
    //Use Ajax methods to save the values
    //POST method if employee is new, ie no active user
    /*
    if(activeUser){
        const saveActionUrl = ("api/Employee/");
        const saveEmployeeRequest = {
            id: 0,
            firstName: getFirstNameElement().value,
            lastName: getLastNameElement().value,
            password: getPasswordElement().value,
            active: true,
            classification: getEmployeeTypeElement().value,
        }
        ajaxPost(saveActionUrl, saveEmployeeRequest, (callbackResponse) => {
            saveActionElement.disabled = false;
            if(isSuccessResponses(callbackResponse)) {
                displayEmployeeSavedAlertModal();
            }
        });
    //}
    */
    //PATCH method if employee exists in database, ie is active user
    /*
    saveActionUrl = ("api/Employee/" + getEmployeeIdElement().value);
    const saveEmployeeRequest = {
        id: getEmployeeIdElement().value,
        firstName: getFirstNameElement().value,
        lastName: getLastNameElement().value,
        password: getPasswordElement().value,
        active: true,
        classification: getEmployeeTypeElement().value,
    }
    else{
        ajaxPatch(saveActionUrl, saveEmployeeRequest, (callbackResponse) => {
            saveActionElement.disabled = false;
            if(isSuccessResponses(callbackResponse)){
                displayEmployeeSavedAlertModal();
            }
        });
    //}

    */
}

function validateSave(){
    firstName = getFirstNameElement();
    lastName = getLastNameElement();
    password = getPasswordElement();
    confirm = getConfirmElement();
    employeeType = getEmployeeTypeElement();
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
    else if(employeeType.value != "Cashier" && employeeType.value != "Shift Manager" && employeeType.value != "General Manager"){
        displayError("Employee Type Error.");
        valid = false;
    }
    else{
        clearError();
        valid = true;
    }
    return valid;
}

function displayEmployeeSavedAlertModal(){
    if(hideEmployeeSavedAlertTimer){
        clearTimeout(hideEmployeeSavedAlertTimer);
    }

    const savedAlertModalElement = getSavedAlertModalElement();
    savedAlertModalElement.style.display = "none";
    savedAlertModalElement.style.display = "block";

    hideEmployeeSavedAlertTimer(hideEmployeeSavedAlertModal, 1200);
}

function hideEmployeeSavedAlertModal(){
    if(hideEmployeeSavedAlertTimer){
        clearTimeout(hideEmployeeSavedAlertTimer);
    }
    getSavedAlertModalElement().style.display = "none";
}

function displayEmployeeIdRecord(employeeId){
    const employeeIdRowElement = getEmployeeIdRowElement();
    const employeeIdElement = getEmployeeIdElement();

    employeeIdElement.value = employeeId;
    if(employeeIdRowElement.classList.contains("hidden")){
        employeeIdRowElement.classList.remove("hidden");
    }
}
//end save active user functions

//Setters
function setFirstNameElement(firstName){
    const firstNameElement = getFirstNameElement();
    firstNameElement.value = firstName;
}

function setLastNameElement(lastName){
    const lastNameElement = getLastNameElement();
    lastNameElement.value = lastName;
}

function setPasswordElement(password){
    const passwordElement = getPasswordElement();
    passwordElement.value = password;
}

function setConfirmElement(confirm){
    const confirmElement = getConfirmElement();
    confirmElement.value = confirm;
}

function setEmployeeTypeElement(employeeType){
    const employeeTypeElement = getEmployeeTypeElement();
    employeeTypeElement.value = employeeType;
}

//Getters
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

function getEmployeeTypeElement(){
    return document.getElementById("employeeType");
}

function getEmployeeIdRowElement(){
    return document.getElementById("employeeIdRow");
}

function getEmployeeIdElement(){
    return document.getElementById("employeeId");
}

function getSaveButtonElement(){
    return document.getElementById("saveButton");
}

function getSignOutActionElement(){
    return document.getElementById("signOutImage");
}

function getSavedAlertModalElement(){
    return document.getElementById("employeeSavedAlertModal");
}