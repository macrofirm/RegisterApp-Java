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
	if(!addToCartButtonPressed) {
		let listItem = findClickedListItemElement(event.target);
		window.location.assign(
			"/productDetail/"
			+ listItem.querySelector("input[name='productId'][type='hidden']").value);
	}
	addToCartButtonPressed = false;
}

function cartRedirect(){
	location.assign("/shoppingCart/" + getTransactionId());
}

function addToCart(){
	addToCartButtonPressed = true;
	alert("Functionality is not yet implemented.  Will add product to cart.");
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