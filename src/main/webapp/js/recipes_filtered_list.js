var recipeListObject = {
    recipes: [
        {
            id: 1,
            headline: "Einfacher Pfannkuchen",
            image: "images/foodpictures/pfannkuchen.jpg",
            text: "blablablabla",
            author: "Muh",
        },
        {
            id: 2,
            headline: "Kartoffel-Brokkoli-Auflauf",
            image: "images/foodpictures/brokkoli-kartoffel-auflauf.jpg",
            text: "blablablabla",
            author: "Muh",
        },
        {
            id: 3,
            headline: "Pasta mit Frühlingszwiebeln",
            image: "images/foodpictures/pasta-fruehlingszwiebeln.jpg",
            text: "blablablabla",
            author: "Muh",
        },
        {
            id: 4,
            headline: "Käsespätzle",
            image: "images/foodpictures/kaesespaetzle.jpg",
            text: "blablablabla",
            author: "Muh",
        },
        {
            id: 5,
            headline: "Spinat mit Kartoffeln und Spiegelei",
            image: "images/foodpictures/spinat-kartoffeln-ei.jpg",
            text: "blablablabla",
            author: "Muh",
        }
    ]
}

// ----------------------------------

var recipeListReference;

window.addEventListener('DOMContentLoaded', () => {
    recipeListReference = document.getElementById("recipes-filtered-list");
    recipeListReference.innerHTML = buildRecipesOverview(recipeListObject);
});

function buildRecipesOverview(recipeListObject) {
    var recipeList = "";

    for (i = 0; i < recipeListObject.recipes.length; i++) {
        var currentRecipe = recipeListObject.recipes[i];

        recipeList +=

            "<img src='" + currentRecipe.image + "' class='recipe-list-image'>" +
            "<div class='recipe-list-text'>" + currentRecipe.text + "</div>" +
            "<div class='recipe-list-author'>" + currentRecipe.author + "</div>" +
            "<h5 class='recipe-list-headline'>" + currentRecipe.headline + "</h5>"
    }

    return recipeList;
}