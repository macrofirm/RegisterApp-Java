document.addEventListener("DOMContentLoaded", () => {
    if(getCheckoutButtonElement() != null) {
        getCheckoutButtonElement().addEventListener("click", checkout);
    }
    if(getContinueShoppingButtonElement() != null) {
        getContinueShoppingButtonElement().addEventListener("click", continueShopping);
    }
});

function checkout() {
    location.assign("/transactionSummary");
    return;
}

function clearCart() {
// TODO add details when shopping cart storage is worked out.
}

function getNumUnits() {
// TODO add details when shopping cart storage is worked out.
}

function removeItem(itemID) {

}

function continueShopping() {
    location.assign("/productListing");
    return;
}

function getCheckoutButtonElement() {
    return document.getElementById("checkoutButton");
}
function getClearCartButtonElement() {
    return document.getElementById("clearCartButton");
}
function getContinueShoppingButtonElement() {
    return document.getElementById("continueShoppingButton");
}