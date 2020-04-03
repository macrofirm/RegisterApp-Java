document.addEventListener("DOMContentLoaded", () => {
	const productListElements = document.getElementById("productsListing").children;
	if(getReturnToCartButtonElement() != null){
		getReturnToCartButton().addEventListener("click", cartRedirect);
	}
	for (let i = 0; i < productListElements.length; i++) {
		productListElements[i].addEventListener("click", productClick);
	}
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
	alert("Functionality is not yet implemented.  Will redirect to the shopping cart.");
}

function addToCart (){
	if(!validateNumber()){
		return;
	}
	alert("Functionality is not yet implemented.  Will add product to cart.");
}

function validateNumber(){
	const number = getAddToCartButtonElement();
	valid = true;
	if(number == ""){
		alert("Must enter number of items");
		valid = false;
	}
	else if(number.value() <= 0){
		alert("Number of items must be greater than 0");
		valid = false;
	}
	else{
		valid = true;
	}
	return valid;
}

function getAddToCartButtonElement(){
	return document.getElementById("addToCartButton");
}

function getReturnToCartButtonElement(){
	return document.getElementById("returnToCartButton");
}