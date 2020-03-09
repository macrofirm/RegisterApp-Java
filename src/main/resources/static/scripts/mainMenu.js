document.addEventListener("DOMContentLoaded", () => {
    if(getTransactionButtonElement() != null) {
        getTransactionButtonElement().addEventListener("click", tempDisplayError);
    }
    if(getViewProductsButtonElement() != null) {
        getViewProductsButtonElement().addEventListener("click", viewProductsClick);
    }
    if(getCreateEmployeeButtonElement() != null) {
        getCreateEmployeeButtonElement().addEventListener("click", createEmployeeClick);
    }
    if(getSalesReportButtonElement() != null) {
        getSalesReportButtonElement().addEventListener("click", tempDisplayError);
    }
    if(getCashierReportButtonElement() != null) {
        getCashierReportButtonElement().addEventListener("click", tempDisplayError);
    }
    if(getSignOutActionElement() != null) {
        getSignOutActionElement().addEventListener("click", signOutActionClickHandler)
    }
});

//events
function viewProductsClick(event) {
    location.assign("/productListing/");
    return;
}

function createEmployeeClick(event) {
    location.assign("/employeeView/");
    return;
}

function tempDisplayError(event) {
    displayError("Functionality has not yet been implemented");
    return;
}

//getters
function getTransactionButtonElement() {
    return document.getElementById("startTransactionButton");
}

function getViewProductsButtonElement() {
    return document.getElementById("viewProductsButton");
}

function getCreateEmployeeButtonElement() {
    return document.getElementById("createEmployeeButton");
}

function getSalesReportButtonElement() {
    return document.getElementById("salesReportButton");
}

function getCashierReportButtonElement() {
    return document.getElementById("cashierReportButton");
}

function getSignOutActionElement() {
    return document.getElementById("signOutImage");
}