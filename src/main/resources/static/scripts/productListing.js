document.addEventListener("DOMContentLoaded", () => {
	const productListElements = document.getElementById("productsListing").children;
	if(getReturnToCartButtonElement() != null){
		getReturnToCartButtonElement().addEventListener("click", cartRedirect);
	}
	for (let i = 0; i < productListElements.length; i++) {
		productListElements[i].addEventListener("click", productClick);
	}
	const pathnameString = window.location.pathname;
	if(pathnameString == "/productListing"){
		getAddToCartButtonElement().hidden = true;
		getAddToCartButtonElement().disabled = true;
		getReturnToCartButtonElement().hidden = true;
		getReturnToCartButtonElement().disabled = true;
	}
	// TODO: Check this code against products with a count of 0
	// EDIT: Does not work
	/*for (let i = 0; i < productListElements.length; i++) {
		if(document.getElementsByClassName("productCountDisplay")[i] == "0") {
			productListElements[i].productCountDisplay = "Out of Stock";
		}
	}*/
});

addToCartButtonPressed = false;

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

function productClick(event) {
	let listItem = findClickedListItemElement(event.target);
	if(!addToCartButtonPressed) {
		window.location.assign(
			"/productDetail/"
			+ listItem.querySelector("input[name='productId'][type='hidden']").value);
	} else {
		const addToCartUrl = "/api/transactionEntry/";
		const addtoCartRequest = {
			transactionId: getTransactionId(),
			productId: listItem.querySelector("input[name='productId'][type='hidden']").value,
			lookupCode: listItem.querySelector("span[class='productLookupCodeDisplay']").value,
			quantity: 1,
			stock: listItem.querySelector("span[class='productCountDisplay']").value,
			price: listItem.querySelector("span[class='productPriceDisplay']").value,
			createdOn: listItem.querySelector("span[class='productCreatedOnDisplay']").value
		};
		ajaxPost(addToCartUrl, addtoCartRequest, (callbackResponse) => {
			if(isSuccessResponse(callbackResponse)) {
				location.assign("/productListing");
				window.location.replace(callbackResponse.data.redirectUrl);
			}
		});
		addToCartButtonPressed = false;
	}
}

function cartRedirect(){
	location.assign("/shoppingCart/" + getTransactionId());
}

function addToCartClick(){
	addToCartButtonPressed = true;
}

// getters
function getAddToCartButtonElement(){
	return document.getElementById("addToCartButton");
}

function getReturnToCartButtonElement(){
	return document.getElementById("returnToCartButton");
}

function getTransactionId(){
	return document.getElementById("transactionId").value;
}