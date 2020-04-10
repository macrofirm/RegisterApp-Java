document.addEventListener("DOMContentLoaded", () => {
	const okayButtonElement = getokayButtonElement();
	if (okayButtonElement != null) {
		okayButtonElement.addEventListener("click", okayButtonClickHandler);
	}
});


//getters
function getOkayButtonElement() {
    return document.getElementById("startOkayButton");
}