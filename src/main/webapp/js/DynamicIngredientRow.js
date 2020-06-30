let ingredientContainer;
let ingredientRow;
let maxIngredientCount;
let currentIngredientCount;
let ingredients = [];

window.addEventListener('DOMContentLoaded', () => {
    ingredientContainer = document.getElementById("ingredientContainer");
    currentIngredientCount = document.getElementById("ingredientCount");
    currentIngredientCount.value = 0;
    maxIngredientCount = Number.parseInt(ingredientContainer.getAttribute("data-maxCount"));
});

function addIngredient() {
    ingredientRow = ingredientContainer.appendChild(document.createElement("div"));
    ingredientRow.setAttribute("class", "ingredientRow");
    ingredientRow.setAttribute("id", "ingredientRow");

    const index = ingredients.push(ingredientRow);
    currentIngredientCount.value = index;

    let amountInput = ingredientRow
        .appendChild(document.createElement("label"))
        .appendChild(document.createElement("input"));

    amountInput.setAttribute("type", "number");
    amountInput.setAttribute("name", "amount" + index);
    amountInput.setAttribute("min", "0.1");
    amountInput.setAttribute("max", "5000");
    amountInput.setAttribute("step", "0.1");
    amountInput.setAttribute("placeholder", "Menge");
    amountInput.setAttribute("required", "true");

    let unitInput = ingredientRow
        .appendChild(document.createElement("label"))
        .appendChild(document.createElement("select"));
    unitInput.setAttribute("name", "unit" + index)
    unitInput.appendChild(createSelectOption("g", "g"))
    unitInput.appendChild(createSelectOption("ml", "ml"))
    unitInput.appendChild(createSelectOption("stk.", "stk."))

    let nameInput = ingredientRow
        .appendChild(document.createElement("label"))
        .appendChild(document.createElement("input"));
    nameInput.setAttribute("type", "text");
    nameInput.setAttribute("name", "ingredient" + index);
    nameInput.setAttribute("placeholder", "Zutat");
    nameInput.setAttribute("required", "true");

    if (index === 1) { //just added the first one, so we can delete
        document.getElementById("removeIngredientButton").style.display = "block";
    }
    else if (index === maxIngredientCount) {
        document.getElementById("addIngredientButton").style.display = "none";
    }
}

function removeIngredient() {
    let toRemove = ingredients.pop();
    currentIngredientCount.value = ingredients.length;
    toRemove.parentNode.removeChild(toRemove);

    if (ingredients.length === maxIngredientCount - 1) { //we can add new
        document.getElementById("addIngredientButton").style.display = "block";
    }
    if (ingredients.length === 0) {
        document.getElementById("removeIngredientButton").style.display = "none";
    }
}

function createSelectOption(value, displayText) {
    let option = document.createElement("option");
    option.setAttribute("value", value);
    option.text = displayText;
    return option;
}
