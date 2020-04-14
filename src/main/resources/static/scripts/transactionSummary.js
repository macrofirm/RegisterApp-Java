document.addEventListener("DOMContentLoaded", () => {
	const okayButtonElement = getokayButtonElement();
	if (okayButtonElement != null) {
		okayButtonElement.addEventListener("click", okayButtonClickHandler);
	}
});

function okayButtonClickHandler() {

		location.assign("/mainMenu");
		return;
}

//getters
function getOkayButtonElement() {
    return document.getElementById("startOkayButton");
}