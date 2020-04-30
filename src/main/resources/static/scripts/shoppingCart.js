var productListElements;
var total = 0;
document.addEventListener("DOMContentLoaded", () => {
    productListElements = document.getElementById("productsListing").children;
    if(getCheckoutButtonElement() != null) {
        getCheckoutButtonElement().addEventListener("click", checkout);
    }
    if(getClearCartButtonElement() != null) {
        getClearCartButtonElement().addEventListener("click",clearCart);
    }
    if(getContinueShoppingButtonElement() != null) {
        getContinueShoppingButtonElement().addEventListener("click", continueShopping);
    }
    var list = document.getElementsByClassName("productPriceDisplay");
	for(let i = 0; i<list.length; i++){
		var x = list[i].innerHTML;
		var len = x.length;
		var pos = x.indexOf(".");
		if(pos == -1){
			x += ".";
			pos = x.indexOf(".");
		}
		var diff = len - pos;
		var newText = "$" + x;
		for(let j = diff; j<3; j++){
			newText += "0"
		}
		list[i].innerHTML = newText;
	}
    calculateTotal();
});

function checkout() {
    location.assign("/transactionSummary/" + getTransactionId());
    return;
}

function clearCart() {
    var clearCartUrl = "/api/transactionEntry//" + getTransactionId();
    ajaxDelete(clearCartUrl, (callbackResponse) => {
        if (isSuccessResponse(callbackResponse)) {
            window.location.replace("/shoppingCart/" + getTransactionId());
        }
    });
}

function getNumUnits() {
// TODO add details when shopping cart storage is worked out.
}

function removeItem(listItem) {
    var removeItemUrl = "/api/transactionEntry/" + listItem.querySelector("input[name='transactionEntryId']").value;

    ajaxDelete(removeItemUrl, (callbackResponse) => {
        if (isSuccessResponse(callbackResponse)) {
            window.location.replace("/shoppingCart/" + getTransactionId());
        }
    });
}

function findClickedListItemElement(clickedTarget) {
	if (clickedTarget.tagName.toLowerCase() === "li") {
		return clickedTarget;
	} else {
		let ancestorIsListItem = false;
		let ancestorElement = clickedTarget.parentElement;

		while (!ancestorIsListItem && (ancestorElement != null)) {
			ancestorIsListItem = (ancestorElement.tagName.toLowerCase() === "li");

			if (!ancestorIsListItem) {
				ancestorElement = ancestorElement.parentElement;
			}
		}

		return (ancestorIsListItem ? ancestorElement : null);
	}
}

function continueShopping() {
    location.assign("/productListing/" + getTransactionId());
    return;
}

function calculateTotal(){
    var quantityList = document.getElementsByClassName("productCountDisplay");
    var priceList = document.getElementsByClassName("productPriceDisplay");
    var num = 0;
    for(let i = 0; i<priceList.length; i++){
        var str = priceList[i].innerHTML;
        var newStr = "";
        for(let i = 0; i < str.length; i++){
			if(str[i] != '$' && str[i] != ','){
				newStr += str[i];
			}
        }
        var num1 = Number(quantityList[i].innerHTML);
        var num2 = Number(newStr);
        var newNum = num1 * num2;
        num += newNum;
    }
    total = num;
    num += "";
    var len = num.length;
    var pos = num.indexOf(".");
    if(pos == -1){
        num += ".";
        pos = num.indexOf(".");
        len = num.length;
    }
    var diff = len - pos;
    var newText = "$" + num;
    for(let j = diff; j<3; j++){
        newText += "0"
    }
    num = newText;
    getTotalDisplayElement().innerHTML = ("Total: " + num);
}

// Getters

function getCheckoutButtonElement() {
    return document.getElementById("checkoutButton");
}

function getClearCartButtonElement() {
    return document.getElementById("clearCartButton");
}

function getContinueShoppingButtonElement() {
    return document.getElementById("continueShoppingButton");
}

function getTransactionId(){
	return document.getElementById("transactionId").value;
}

function updateQuantity() {
    const updateQuantityUrl = "/api/transactionEntry/";
    const data =  {
        quantity: listItem.querySelector("input[name='quantitySelect'][type='number']").value
    };
    ajaxPut(updateQuantityUrl, data, (callbackResponse) => {
        if (isSuccessResponse(callbackResponse)) {
            window.location.replace(callbackResponse.data.redirectUrl);
        }
    });
    return;
}
function getTotalDisplayElement(){
    return document.getElementById("totalDisplay");
}

function getProductList(){
	return document.getElementById("productsListing");
}