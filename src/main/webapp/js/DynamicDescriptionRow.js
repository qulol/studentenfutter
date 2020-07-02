let descriptionContainer;
let descriptionRow;
let maxDescriptionCount;
let currentDescriptionCount;
let descriptions = [];


window.addEventListener('DOMContentLoaded', () => {
    descriptionContainer = document.getElementById("descriptionContainer");
    currentDescriptionCount = document.getElementById("descriptionCount")
    currentDescriptionCount.value = 0;
    maxDescriptionCount = Number.parseInt(descriptionContainer.getAttribute("data-maxCount"));
    addDescription();
    });

function addDescription() {
    descriptionRow = descriptionContainer.appendChild(document.createElement("div"));
    descriptionRow.setAttribute("class", "descriptionRow");

    const index = descriptions.push(descriptionRow);
    currentDescriptionCount.value = index;

    const descriptionField = descriptionRow
        .appendChild(document.createElement("label"))
        .appendChild(document.createElement("textarea"));
    descriptionField.setAttribute("class", "descriptionRow");
    descriptionField.setAttribute("name", "description" + index)
    descriptionField.setAttribute("placeholder", "Schritt " + index);
    descriptionField.setAttribute("required", "true");

    if (index === 1) { //just added the first one, so we can delete
        document.getElementById("removeDescriptionButton").disabled = false;
    }
    else if (index === maxDescriptionCount) {
        document.getElementById("addDescriptionButton").disabled = true;
    }
}

function removeDescription() {
    let toRemove = descriptions.pop();
    currentDescriptionCount.value = descriptions.length;
    toRemove.parentNode.removeChild(toRemove);

    if (descriptions.length === maxDescriptionCount - 1) { //we can add new
        document.getElementById("addDescriptionButton").disabled = false;
    }
    if (descriptions.length === 0) {
        document.getElementById("removeDescriptionButton").disabled = true;
    }
}