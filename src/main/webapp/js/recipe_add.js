var ingredientContainer;
var ingredientRow;
var instructionContainer;
var instructionRow;
var i;
var j;
var k;

window.addEventListener('DOMContentLoaded', () => {
    i = 1;
    j = 1;
    k = 2;
});

function addIngredientRow() {
    ingredientContainer = document.getElementById("ingredientContainer");
    ingredientRow = document.createElement("div");
    ingredientRow.setAttribute("class", "ingredientRow");
    ingredientRow.setAttribute("id", "ingredientRow" + i);

    ingredientRow.innerHTML =
        '        <label for="amount' + i + '"></label>' +
        '        <input type="text" id="amount' + i + '" name="amount' + i + '" placeholder="Menge">' +
        '        <label for="unit' + i + '"></label>' +
        '        <select id="unit' + i + '" name="unit' + i + '">' +
        '        <option value="g">g</option>' +
        '        <option value="kg">kg</option>' +
        '        </select>' +
        '        <label for="ingredient' + i + '"></label>' +
        '        <input type="text" id="ingredient' + i + '" name="ingredient' + i + '" placeholder="Zutat">' +
        '        <input type="button" onClick="removeIngredientRow(' + i + ')" value="-">';

    ingredientContainer.appendChild(ingredientRow);
    i++;
}

function addInstructionRow() {
    instructionContainer = document.getElementById("instructionContainer");
    instructionRow = document.createElement("div");
    instructionRow.setAttribute("class", "instructionRow");
    instructionRow.setAttribute("id", "instructionRow" + j);

    instructionRow.innerHTML =
        '        <label for="instructionStep' + j + '">' + k + '. Schritt</label><br>' +
        '        <textarea id="instructionStep' + j + '" cols="40" rows="4"></textarea>' +
        '        <input type="button" onClick="removeInstructionRow(' + j + ')" value="-">';

    instructionContainer.appendChild(instructionRow);
    j++;
    k++;
}

function removeIngredientRow(rowId) {
    ingredientRow = document.getElementById("ingredientRow" + rowId);
    ingredientRow.parentNode.removeChild(ingredientRow);
}

function removeInstructionRow(rowId) {
    instructionRow = document.getElementById("instructionRow" + rowId);
    instructionRow.parentNode.removeChild(instructionRow);
}