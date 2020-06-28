let numberOfPersonsReference;
let singleAmountsArray;
let amountHTMLReferenceArray;

window.addEventListener('DOMContentLoaded', () => {
    numberOfPersonsReference = document.getElementById("numberOfPersons");
    amountHTMLReferenceArray = Array.from(document.getElementById("ingredientsTable")
        .getElementsByClassName("amount"));
    singleAmountsArray = amountHTMLReferenceArray.map(amount => parseFloat(amount.innerHTML));
});

function calculateIngredientsAmount() {
    amountHTMLReferenceArray.forEach(calculateAndUpdateSingleIngredient)
}

function calculateAndUpdateSingleIngredient(amount, index) {
    amount.innerHTML = (singleAmountsArray[index] * numberOfPersonsReference.value).toFixed(1);
}