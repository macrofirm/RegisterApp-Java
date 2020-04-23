document.addEventListener("DOMContentLoaded", () => {
	
	if (getOkayButtonElement() != null) {
		getOkayButtonElement().addEventListener("click", okayButtonClickHandler);
	}
});

var quantity;
var $amountInput = $('td.amount > input[type="number"]');
$amountInput.on('input', updateTotal);
		
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
		
function updateTotal(){
	
	var$thisInput = $(e.target);
	var amount = $thisInput.val();

	amount = parseInt(amount);
	if(!amount || amount < 0)
		return;
		
	var $parentRow = $thisInput.parent().parent();
	var $siblingTotal = $parentRow.find('.total');
	var siblingCost = $parentRow.find('.cost');

	cost = parseFloat(cost);
	var total = amount * cost;
	total  = total.toFixed(2);

	$siblingTotal.text(total);


} 

function okayButtonClickHandler() {

	location.assign("/mainMenu");
	return;
	} 

//getters
function getOkayButtonElement() {
    return document.getElementById("okayButton");
}