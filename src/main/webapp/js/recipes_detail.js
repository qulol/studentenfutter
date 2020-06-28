
var numberOfPersonsReference = 1;

window.addEventListener('DOMContentLoaded', () => {
    numberOfPersonsReference = document.getElementById("numberOfPersons");
});

function calculateAmount() {
    for (var i = 0; i < mealObject.ingredients.length; i++) {
        var numberOfPersonsValue = numberOfPersonsReference.value;
        var amountReference = document.getElementById("amount" + i);
        var ingredientObject = mealObject.ingredients[i];

        amountReference.innerHTML = (ingredientObject.amount * numberOfPersonsValue).toString();
    }
}