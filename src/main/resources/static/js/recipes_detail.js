// var mealObject = {
//     id: 1,
//     headline: "Spaghetti",
//     image: "./images/foodpictures/noodles.png",
//     ingredients: ["Nudeln", "passierte Tomaten", "Parmesan", "Zwiebel(n)"],
//     amount: [500, 500, 50, 0.5],
//     unit: ["g", "ml", "g", "Stk."],
//     seasons: ["Salz", "Pfeffer", "Oregano", "Thymian", "Knoblauchpulver"],
//     steps: ["1. Schritt", "Wasser kochen", "2. Schritt", "Nudeln reinwerfen", "3. Schritt", "Wenn Nudeln gar -> abschütten", "4. Schritt", "Mampf"]
// };
var mealObject = {
    id: 1,
    headline: "Spaghetti",
    image: "./images/foodpictures/noodles.png",
    ingredients: [
        {
            name: "Nudeln",
            amount: 500,
            unit: "g",
        },
        {
            name: "passierte Tomaten",
            amount: 500,
            unit: "ml"
        },
        {
            name: "Parmesan",
            amount: 50,
            unit: "g"
        },
        {
            name: "Zwiebel(n)",
            amount: 0.5,
            unit: "Stk."
        }
    ],
    seasons: ["Salz", "Pfeffer", "Oregano", "Thymian", "Knoblauchpulver"],
    steps: ["1. Schritt", "Wasser kochen", "2. Schritt", "Nudeln reinwerfen", "3. Schritt", "Wenn Nudeln gar -> abschütten", "4. Schritt", "Mampf"]
}
// ----------------------------


var numberOfPersonsReference = 1;
var ingredientReference;
var tableIngredientsReference;

window.addEventListener('DOMContentLoaded', (event) => {
    tableIngredientsReference = document.getElementById("tableIngredients");
    tableIngredientsReference.innerHTML = buildTable(mealObject);

    ingredientReference = document.getElementsByClassName("ingredient");

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

function addIngredientsToShoppingList() {

}

// --------------------------------------------
/*
fetch('',
    {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            title: 'Beispielprojekt',
            url: 'http://www.example.com',
        })
    })
    .then(function (response) {
        console.log(response);
    })
    .catch(function (error) {
        console.error(error);
    });
    */

function buildTable(mealObject) {
    var table = "";

    for (var i = 0; i < mealObject.ingredients.length; i++) {
        var currentIngredient = mealObject.ingredients[i];
        table += "<tr>" +
            "<td id='amount" + i + "'>" + currentIngredient.amount + "</td>" +
            "<td id='unit" + i + "'>" + currentIngredient.unit + "</td>" +
            "<td id=" + i + "'singleIngredient'>" + currentIngredient.name + "</td>" +
            "</tr>";
    }
    return table; // sonst kommt nichts zurück :)
}
