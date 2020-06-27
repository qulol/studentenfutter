var ingredientContainer;
var ingredientRow;
var instructionContainer;
var instructionRow;
var ingredientButton;
var instructionButton;
var displayedIngredientRows;
var displayedInstructionRows;
var i;
var j;
var k;

window.addEventListener('DOMContentLoaded', () => {

    ingredientButton = document.getElementById("ingredientButton");
    instructionButton = document.getElementById("instructionButton");
    i = 1;
    j = 1;
    k = 2;
    displayedIngredientRows = 1;
    displayedInstructionRows = 1;
});

function addIngredientRow() {

    if (displayedIngredientRows < 10) {

        ingredientButton.style.display = "block";

        ingredientContainer = document.getElementById("ingredientContainer");
        ingredientRow = document.createElement("div");
        ingredientRow.setAttribute("class", "ingredientRow");
        ingredientRow.setAttribute("id", "ingredientRow" + i);

        ingredientRow.innerHTML =
            '        <label for="amount' + i + '"></label>' +
            '        <input type="number" id="amount' + i + '" name="amount' + i + '" min="0.1" max="5000" step="0.1" placeholder="Menge">' +
            '        <label for="unit' + i + '"></label>' +
            '        <select id="unit' + i + '" name="unit' + i + '">' +
            '        <option value="g">g</option>' +
            '        <option value="ml">ml</option>' +
            '        <option value="Stk.">Stk.</option>' +
            '        </select>' +
            '        <label for="ingredient' + i + '"></label>' +
            '        <input type="text" id="ingredient' + i + '" name="ingredient' + i + '" placeholder="Zutat">' +
            '        <input type="button" onClick="removeIngredientRow(' + i + ')" value="-">';

        ingredientContainer.appendChild(ingredientRow);
        i++;
        displayedIngredientRows++;

        if (displayedIngredientRows === 10) {
            ingredientButton.style.display = "none";
        }
    }
}

function addInstructionRow() {

    if (displayedInstructionRows < 10) {

        instructionButton.style.display = "block";

        instructionContainer = document.getElementById("instructionContainer");
        instructionRow = document.createElement("div");
        instructionRow.setAttribute("class", "instructionRow");
        instructionRow.setAttribute("id", "instructionRow" + j);

        instructionRow.innerHTML =
            '        <label for="instructionStep' + j + '">' + k + '. Schritt</label><br>' +
            '        <textarea id="instructionStep' + j + '" name="instructionStep' + j + '" cols="40" rows="4"></textarea>';

        instructionContainer.appendChild(instructionRow);
        j++;
        k++;
        displayedInstructionRows++;

        if (displayedInstructionRows === 10) {
            instructionButton.style.display = "none";
        }
    }
}

function removeIngredientRow(rowId) {
    ingredientRow = document.getElementById("ingredientRow" + rowId);
    ingredientRow.parentNode.removeChild(ingredientRow);
    ingredientButton.style.display = "block";
    displayedIngredientRows--;
}

function removeInstructionRow() {
    var instructionList = document.querySelectorAll('.instructionContainer .instructionRow');
    var lastElement = instructionList[instructionList.length - 1];
    lastElement.parentNode.removeChild(lastElement);

    instructionButton.style.display = "block";
    displayedInstructionRows--;
    k--;
}