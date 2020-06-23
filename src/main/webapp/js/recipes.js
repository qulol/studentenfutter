//
// fetch('./categories.jsp',
//     {
//         method: 'get',
//         headers: {
//             'Accept': 'application/json',
//             'Content-Type': 'application/json'
//         },
//     })
//     .then(function (recipes) {
//
//         console.log(recipes);
//
//     })
//     .catch(function (error) {
//         console.error(error);
//     });


var recipeOverviewObject = {
    recipes: [
        {
            id: 1,
            headline: "Einfacher Pfannkuchen",
            image: "images/foodpictures/pfannkuchen.jpg",
        },
        {
            id: 2,
            headline: "Kartoffel-Brokkoli-Auflauf",
            image: "images/foodpictures/brokkoli-kartoffel-auflauf.jpg",
        },
        {
            id: 3,
            headline: "Pasta mit Frühlingszwiebeln",
            image: "images/foodpictures/pasta-fruehlingszwiebeln.jpg",
        },
        {
            id: 4,
            headline: "Käsespätzle",
            image: "images/foodpictures/kaesespaetzle.jpg",
        },
        {
            id: 5,
            headline: "Spinat mit Kartoffeln und Spiegelei",
            image: "images/foodpictures/spinat-kartoffeln-ei.jpg",
        },
        {
            id: 6,
            headline: "Pasta mit Spinat, Mozzarella und Kirschtomaten",
            image: "images/foodpictures/pasta-spinat-tomaten.jpg",
        },
        {
            id: 7,
            headline: "Pesto-Nudeln",
            image: "images/foodpictures/pestonudeln.jpg",
        },
        {
            id: 8,
            headline: "Tomate-Mozzarella-Salat",
            image: "images/foodpictures/tomate-mozzarella-salat.jpg",
        },
        {
            id: 9,
            headline: "Unterschiedliche Soßen - beliebig zu Kombinieren",
            image: "images/foodpictures/soße.jpg",
        }
    ]
}

// ----------------------------------

var recipeOverviewReference;

window.addEventListener('DOMContentLoaded', () => {
    recipeOverviewReference = document.getElementById("recipes");
    recipeOverviewReference.innerHTML = buildRecipesOverview(recipeOverviewObject);
});

function buildRecipesOverview(recipeOverviewObject) {
    var recipesOverview = "";

    for (i = 0; i < recipeOverviewObject.recipes.length; i++) {
        var currentRecipe = recipeOverviewObject.recipes[i];

        recipesOverview +=

            "<a href='../jsp/recipe_detail.jsp#ingredientsTab'>" +
            "<div class='single-recipe-block'><img src='" + currentRecipe.image +"' id='recipe-image'>" +
            "<h5>" + currentRecipe.headline + "</h5></div></a>"
    }

    return recipesOverview;
}