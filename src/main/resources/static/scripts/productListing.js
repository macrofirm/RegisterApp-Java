document.addEventListener("DOMContentLoaded", () => {
	const productListElements = document.getElementById("productsListing").children;
	if(getReturnToCartButtonElement() != null){
<<<<<<< HEAD
		getReturnToCartButtonElement().addEventListener("click", returnToCart);
	}
	if(getAddToCartButtonElement() != null){
		getAddToCartButtonElement().addEventListener("click", addToCart);
=======
		getReturnToCartButtonElement().addEventListener("click", cartRedirect);
>>>>>>> 5923f4d04cf0b531cd3bc19b7f17f23eab26614e
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

<<<<<<< HEAD
function returnToCart(event){
	window.location.assign("shoppingCart.html");
=======
function cartRedirect(){
	location.assign("/shoppingCart");
	//alert("Functionality is not yet implemented.  Will redirect to the shopping cart.");
>>>>>>> 5923f4d04cf0b531cd3bc19b7f17f23eab26614e
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

function getAddToCartButtonElement(){
	return document.getElementById("addToCartButton");
}

function getReturnToCartButtonElement(){
	return document.getElementById("returnToCartButton");
}

function getNumberOfItemsElement(){
	return document.getElementById("numberOfItems");
}