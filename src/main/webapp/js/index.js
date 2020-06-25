var topText;
var firstIcon;
var secondIcon;
var firstStep;
var secondStep;
var middleContent;
var currentYPosition;
var counter;

var windowHeight = window.screen.availHeight
    || document.body.clientHeight
    || document.body.clientHeight;

var windowWidth = window.screen.availWidth
    || document.body.clientWidth
    || document.body.clientWidth;

window.addEventListener('DOMContentLoaded', () => {
    currentYPosition = document.body.scrollTop;

    if (currentYPosition > 0) {
        window.scrollBy({top: -currentYPosition, left: 0, behavior: "smooth"});
    }

    topText = document.getElementById("topContentBlock");
    firstIcon = document.getElementById("firstIcon");
    secondIcon = document.getElementById("secondIcon");
    firstStep = document.getElementById("firstStep");
    secondStep = document.getElementById("secondStep");
    middleContent = document.getElementById("middleContent");
    firstIcon.style.background = "radial-gradient(circle, forestgreen 50%, rgba(73, 133, 30, 0) 100%)";
    secondIcon.style.background = "transparent";
    secondStep.style.display = "none";
    document.body.style.setProperty('height', windowHeight + "px");
    document.body.style.setProperty('width', windowWidth + "px");

    window.onscroll = function () {
        currentYPosition = document.body.scrollTop;
        hideTopText(currentYPosition);
        highlightIcons(currentYPosition);
    }

});

hideTopText = function (currentYPosition) {
    if (!topText) {
        return;
    }
    if (currentYPosition > windowHeight * 0.4) {
        topText.style.display = "none";
    } else {
        topText.style.display = "block";
    }
}


highlightIcons = function (currentYPosition) {

    var secondStepHidden = secondStep.style.display === "none";
    var secondStepVisible = secondStep.style.display === "block";
    var pageStart = currentYPosition < windowHeight * 0.1;
    var pageAfterStart = currentYPosition > windowHeight * 0.1;

    if (!firstIcon || !secondIcon) {
        return;
    }

    if (secondStepHidden && pageStart) {
        firstIcon.style.background = "radial-gradient(circle, forestgreen 50%, rgba(73, 133, 30, 0) 100%)";
        secondIcon.style.background = "transparent";
        secondStep.style.display = "none";
    }
    if (secondStepHidden && pageAfterStart) {
        firstIcon.style.background = "transparent";
        secondIcon.style.background = "radial-gradient(circle, forestgreen 50%, rgba(73, 133, 30, 0) 100%)";
        secondStep.style.display = "block";
    }
    else if (secondStepVisible && pageStart) {
        firstIcon.style.background = "transparent";
        secondIcon.style.background = "transparent";
        secondStep.style.display = "block";
    }
}






