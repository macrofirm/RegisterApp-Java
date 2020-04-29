document.addEventListener("DOMContentLoaded", () => {
	
	if (getOkayButtonElement() != null) {
		getOkayButtonElement().addEventListener("click", okayButtonClickHandler);
	}
}); 

function okayButtonClickHandler() {

	location.assign("/mainMenu");
	return;
	} 

//getters
function getOkayButtonElement() {
    return document.getElementById("okayButton");
}