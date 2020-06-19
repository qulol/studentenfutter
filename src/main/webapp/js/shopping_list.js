var shoppingListObject = {
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
    seasons: ["Salz", "Pfeffer", "Oregano", "Thymian", "Knoblauchpulver"]
}

// --------------------------------

var shoppingListReference;

window.addEventListener('DOMContentLoaded', () => {
    shoppingListReference = document.getElementById("shoppingList");
    shoppingListReference.innerHTML = buildShoppingListTable(shoppingListObject);

});

function buildShoppingListTable(shoppingListObject) {
    var shoppingListTable = "";

    for (var i = 0; i < shoppingListObject.ingredients.length; i++) {
        var currentIngredient = shoppingListObject.ingredients[i];

        shoppingListTable += "<tr>" +
            "<td class='amount' id='amount" + i + "'>" + currentIngredient.amount + "</td>" +
            "<td class='unit' id='unit" + i + "'>" + currentIngredient.unit + "</td>" +
            "<td class='singleIngredient' id=" + i + "'singleIngredient'>" + currentIngredient.name + "</td>" +
            "</tr>";
    }

    for (i = 0; i < shoppingListObject.seasons.length; i++) {
        var currentSeason = shoppingListObject.seasons[i];
        shoppingListTable += "<tr>" +
            "<td></td><td></td><td id='seasons'>" + currentSeason + "</td>" +
        "</tr>"
    }
    return shoppingListTable;
}

function printShoppingList() {
        var printWindow = window.open();

        printWindow.document.write('<html><head><title>' + document.title  + '</title>');
        printWindow.document.write('</head><body >');
        printWindow.document.write('<h1>' + document.title  + '</h1>');
        printWindow.document.write(document.getElementById("toPrint").innerHTML);
        printWindow.document.write('</body></html>');

        printWindow.document.close(); // necessary for IE >= 10
        printWindow.focus(); // necessary for IE >= 10

        printWindow.print();
        printWindow.close();
}