document.addEventListener("DOMContentLoaded", () => {
	const productListElements = document.getElementById("productsListing").children;
	if(getReturnToCartButtonElement() != null){
		getReturnToCartButtonElement().addEventListener("click", cartRedirect);
	}
	for (let i = 0; i < productListElements.length; i++) {
		productListElements[i].addEventListener("click", productClick);
	}
	// TODO: Check this code against products with a count of 0
	// EDIT: Does not work
	/*for (let i = 0; i < productListElements.length; i++) {
		if(document.getElementsByClassName("productCountDisplay")[i] == "0") {
			productListElements[i].productCountDisplay = "Out of Stock";
		}
	}*/
});

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
	window.location.assign(
		"/productDetail/"
		+ listItem.querySelector("input[name='productId'][type='hidden']").value);
}

function cartRedirect(){
	location.assign("/shoppingCart/" + getTransactionId());
	//alert("Functionality is not yet implemented.  Will redirect to the shopping cart.");
}

function addToCart(event){
	if(!validateNumber()){
		return;
	}
	alert("Functionality is not yet implemented.  Will add product to cart.");
}

function validateNumber(){
	const num = getNumberOfItemsElement().value;
	valid = true;
	if(num== ""){
		alert("Must enter number of items");
		valid = false;
	}
	else if(num <= 0){
		alert("Number of items must be greater than 0");
		valid = false;
	}
	else{
		valid = true;
	}
	return valid;
}

// getters
function getAddToCartButtonElement(){
	return document.getElementById("addToCartButton");
}

function getReturnToCartButtonElement(){
	return document.getElementById("returnToCartButton");
}

function getNumberOfItemsElement(){
	return document.getElementById("numberOfItems");
}

function getTransactionId(){
	return document.getElementById("transactionId").value;
}