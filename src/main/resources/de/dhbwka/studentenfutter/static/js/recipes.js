/*
fetch('./recipes.html',
    {
        method: 'get',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    })
    .then(function (response) {

        console.log(response);
    })
    .catch(function (error) {
        console.error(error);
    });
    */

var recipeOverviewObject = {
    recipes: [
        {
            id: 1,
            headline: "Nudeln",
            image: "images/foodpictures/noodles.png",
        },
        {
            id: 2,
            headline: "Nudelferz2",
            image: "images/foodpictures/noodles.jpg",
        },
        {
            id: 3,
            headline: "Nudelferz3",
            image: "images/foodpictures/noodles.jpg",
        },
        {
            id: 4,
            headline: "Nudelferz4",
            image: "images/foodpictures/noodles.jpg",
        },
        {
            id: 5,
            headline: "Nudelferz5",
            image: "images/foodpictures/noodles.jpg",
        },
        {
            id: 6,
            headline: "Nudelferz6",
            image: "images/foodpictures/noodles.jpg",
        },
        {
            id: 7,
            headline: "Nudelferz7",
            image: "images/foodpictures/noodles.jpg",
        },
        {
            id: 8,
            headline: "Nudelferz8",
            image: "images/foodpictures/noodles.jpg",
        },
        {
            id: 9,
            headline: "Nudelferz9",
            image: "images/foodpictures/noodles.jpg",
        }
    ]
}

// ----------------------------------

var recipeOverviewReference;

window.addEventListener('DOMContentLoaded', (event) => {
    recipeOverviewReference = document.getElementById("recipes");
    recipeOverviewReference.innerHTML = buildRecipesOverview(recipeOverviewObject);
});

function buildRecipesOverview(recipeOverviewObject) {
    var recipesOverview = "";

    for (i = 0; i < recipeOverviewObject.recipes.length; i++) {
        var currentRecipe = recipeOverviewObject.recipes[i];

        recipesOverview +=

            "<a href='recipes_detail.html#ingredientsTab'>" +
            "<div class='recipes'><img src='" + currentRecipe.image +"' id='recipe-image'>" +
            "<h5>" + currentRecipe.headline + "</h5></div></a>"
    }

    return recipesOverview;
}