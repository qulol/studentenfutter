var recipeOverviewObject = {
    recipes: [
        {
            id: 1,
            headline: "Frühstück",
            image: "../images/foodpictures/breakfast.jpg",
        },
        {
            id: 2,
            headline: "Mittagessen",
            image: "../images/foodpictures/lunch.jpeg",
        },
        {
            id: 3,
            headline: "Abendessen",
            image: "../images/foodpictures/dinner.jpg",
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

            "<a href='../jsp/recipes_list.jsp'>" +
            "<div class='categories-block'><img src='" + currentRecipe.image +"' id='recipe-image'>" +
            "<h5>" + currentRecipe.headline + "</h5></div></a>"
    }

    return recipesOverview;
}