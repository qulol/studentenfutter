var recipeListObject = {
    recipes: [
        {
            id: 1,
            headline: "Einfacher Pfannkuchen",
            image: "../images/foodpictures/pfannkuchen.jpg",
            text: "blablablabla",
            author: "Muh",
        },
        {
            id: 2,
            headline: "Kartoffel-Brokkoli-Auflauf",
            image: "../images/foodpictures/brokkoli-kartoffel-auflauf.jpg",
            text: "blablablabla",
            author: "Muh",
        },
        {
            id: 3,
            headline: "Pasta mit Frühlingszwiebeln",
            image: "../images/foodpictures/pasta-fruehlingszwiebeln.jpg",
            text: "blablablabla",
            author: "Muh",
        },
        {
            id: 4,
            headline: "Käsespätzle",
            image: "../images/foodpictures/kaesespaetzle.jpg",
            text: "blablablabla",
            author: "Muh",
        },
        {
            id: 5,
            headline: "Spinat mit Kartoffeln und Spiegelei",
            image: "../images/foodpictures/spinat-kartoffeln-ei.jpg",
            text: "blablablabla",
            author: "Muh",
        },
        {
            id: 6,
            headline: "Pasta mit Spinat, Mozzarella und Kirschtomaten",
            image: "../images/foodpictures/pasta-spinat-tomaten.jpg",
        },
        {
            id: 7,
            headline: "Pesto-Nudeln",
            image: "../images/foodpictures/pestonudeln.jpg",
        },
        {
            id: 8,
            headline: "Tomate-Mozzarella-Salat",
            image: "../images/foodpictures/tomate-mozzarella-salat.jpg",
        },
        {
            id: 9,
            headline: "Unterschiedliche Soßen - beliebig zu Kombinieren",
            image: "../images/foodpictures/sosse.jpg",
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

            "<div class='single-recipe-block filtered-list'>" +
            "<img src='" + currentRecipe.image + "' class='recipe-list-image'>" +
            "<div class='recipe-list-text'>" + currentRecipe.text + "</div>" +
            "<div class='recipe-list-author'>" + currentRecipe.author + "</div>" +
            "<a href='../jsp/recipe_detail.jsp#ingredientsTab" + [i] +"'>"  +
            "<h5 class='recipe-list-headline'>" + currentRecipe.headline + "</h5></a></div>"
    }

    // recipesOverview +=  ----------> Reminder
    //
    //
    //     "<div class='single-recipe-block'><img src='" + currentRecipe.image +"' id='recipe-image'>" +
    //     "<h5>" + currentRecipe.headline + "</h5></div></a>"

    return recipeList;
}