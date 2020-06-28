
var numberOfPersonsReference = 1;
var ingredientsTableReference;
var instructionsListReference;
var headlineReference;
var imageReference;

window.addEventListener('DOMContentLoaded', () => {
    ingredientsTableReference = document.getElementById("ingredientsTable");
    instructionsListReference = document.getElementById("instructions");
    headlineReference = document.getElementById("headline");
    imageReference = document.getElementById("recipe-image-detail")

    numberOfPersonsReference = document.getElementById("numberOfPersons");
    headlineReference.innerHTML = mealObject.headline;
    imageReference.src = mealObject.image;
});

function calculateAmount() {

    for (var i = 0; i < mealObject.ingredients.length; i++) {
        var numberOfPersonsValue = numberOfPersonsReference.value;
        var amountReference = document.getElementById("amount" + i);
        var ingredientObject = mealObject.ingredients[i];

        amountReference.innerHTML = (ingredientObject.amount * numberOfPersonsValue).toString();
    }
}