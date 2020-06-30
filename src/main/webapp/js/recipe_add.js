var ingredientContainer;
var ingredientRow;
var instructionContainer;
var instructionRow;
var ingredientButton;
var descriptionButton;
var ingredientCount;
var descriptionCount;

let maxIngredientCount;
let maxDescriptionCount;

window.addEventListener('DOMContentLoaded', () => {
    ingredientButton = document.getElementById("ingredientButton");
    descriptionButton = document.getElementById("instructionButton");
    maxIngredientCount = document.getElementById("ingredientContainer")
        .getAttribute("data-maxCount");
    maxDescriptionCount = document.getElementById("instructionContainer")
        .getAttribute("data-maxCount");
    ingredientCount = 1;
    descriptionCount = 1;
});

function addIngredientRow() {
    ingredientContainer = document.getElementById("ingredientContainer");
    ingredientRow = document.createElement("div");
    ingredientRow.setAttribute("class", "ingredientRow");
    ingredientRow.setAttribute("id", "ingredientRow" + ingredientCount);

    ingredientRow.innerHTML =
        '        <label for="amount' + ingredientCount + '"></label>' +
        '        <input type="number" id="amount' + ingredientCount + '" name="amount' + ingredientCount + '" min="0.1" max="5000" step="0.1" placeholder="Menge">' +
        '        <label for="unit' + ingredientCount + '"></label>' +
        '        <select id="unit' + ingredientCount + '" name="unit' + ingredientCount + '">' +
        '        <option value="g">g</option>' +
        '        <option value="ml">ml</option>' +
        '        <option value="Stk.">Stk.</option>' +
        '        </select>' +
        '        <label for="ingredient' + ingredientCount + '"></label>' +
        '        <input type="text" id="ingredient' + ingredientCount + '" name="ingredient' + ingredientCount + '" placeholder="Zutat">' +
        '        <input type="button" onClick="removeIngredientRow(' + ingredientCount + ')" value="-">';

    ingredientContainer.appendChild(ingredientRow);
    ingredientCount++;

    if (ingredientCount >= maxIngredientCount) {
        ingredientButton.style.display = "none";
    }
}

function addDescriptionRow() {
    instructionContainer = document.getElementById("instructionContainer");
    instructionRow = document.createElement("div");
    instructionRow.setAttribute("class", "instructionRow");
    instructionRow.setAttribute("id", "instructionRow" + descriptionCount);

    instructionRow.innerHTML =
        '        <label for="instructionStep' + descriptionCount + '">' + (descriptionCount + 1) + '. Schritt</label><br>' +
        '        <textarea id="instructionStep' + descriptionCount + '" name="instructionStep' + descriptionCount + '" cols="40" rows="4"></textarea>';

    instructionContainer.appendChild(instructionRow);
    descriptionCount++;

    if (descriptionCount >= maxDescriptionCount) {
        descriptionButton.style.display = "none";
    }
}

function removeIngredientRow(rowId) {
    ingredientRow = document.getElementById("ingredientRow" + rowId);
    ingredientRow.parentNode.removeChild(ingredientRow);
    ingredientCount--;
}

function removeDescriptionRow() {
    var instructionList = document.querySelectorAll('.instructionContainer .instructionRow');
    var lastElement = instructionList[instructionList.length - 1];
    lastElement.parentNode.removeChild(lastElement);
    descriptionCount--;
}