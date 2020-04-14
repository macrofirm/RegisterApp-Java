document.addEventListener("DOMContentLoaded", () => {
	const okayButtonElement = getokayButtonElement();
	if (okayButtonElement != null) {
		okayButtonElement.addEventListener("click", okayButtonClickHandler);
	}
});

var quantity;
		
function incrementValue(){

    quantity = parseInt(document.getElementById('number').value, 10);
   	quantity = isNaN(quantity) ? 0 : quantity;
	quantity++;
	document.getElementById('number').value = quantity;
			
}

function decrementValue(){

	quantity = parseInt(document.getElementById('number').value, 10);
	quantity = isNaN(quantity) ? 0 : quantity;
	if(quantity > 0)
		quantity--;
	else
		quantity = 0;
	document.getElementById('number').value = quantity;
}
		
function totalPrice(){
	quantity = parstInt(document.getElementById('total').value, 10);
	quantity = isNaN(quantity) ? 0 : quantity;
	quantity = quantity * 4;
	document.getElementById('total').value = quantity;

} 

function okayButtonClickHandler() {

	location.assign("/mainMenu");
	return;
	} 

//getters
function getOkayButtonElement() {
    return document.getElementById("startOkayButton");
}