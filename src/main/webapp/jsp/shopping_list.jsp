<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 22.06.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/general_styling.css">
    <link rel="stylesheet" href="fontawesome/css/all.css">
    <script src="js/shopping_list.js"></script>
    <link rel="icon" href="images/icons_logo/icon.png" type="image/png">
    <title>Einkaufsliste - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="images/bg/wood-wallpaper.jpg" alt="bg-image">
    <a href="index.html"><img class="logo" src="images/icons_logo/logo.png" alt="logo"></a>
    <header>
        <div class="navbar">
            <a href="login.html">Login</a>
            <a href="recipes.html">Kategorien</a>
            <a href="create_recipe.html ">Rezept hinzufügen</a>
            <a href="shopping_list.html">Einkaufsliste</a>
            <input type="search" class="search" id="search" placeholder="Suchbegriff eingeben"><label for="search"><i
                class="fas fa-search"></i></label>

        </div>
        <a href="http://lieferando.de" target="_blank" title="PANIC - Lieferando ist dein Freund :) ">"<img
                class="panicbutton"
                src="images/icons_logo/panicbutton.png"
                alt="PanicButtonImage"></a>
    </header>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block white-bg scrollbar" id="top-text">
            <h1 class="centered">Einkaufsliste</h1>
            <button class="buttonPrintShoppingList" id="printShoppingList"
                    onClick=printShoppingList()>
                Einkaufsliste drucken
            </button>
            <div class="shoppingListTableWrapper" id="toPrint">
                <table class="ingredientsTable">
                    <thead class="th-fixed">
                    <tr class="shopping-list">
                        <td class="amount header" id="amount"><b>Menge</b></td>
                        <td class="unit header" id="unit"><b>Einheit</b></td>
                        <td class="singleIngredient header" id="singleIngredient"><b>Zutat</b></td>
                    </tr>
                    </thead>

                    <tbody class="with-margin-top" id="shoppingList">
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="footer-content-wrapper">
        <footer class="footer-content-block">
            <a href="faq.html">FAQ</a>
            <a href="legal_notice.html">Impressum</a>
            <a href="dataprotection.html">Datenschutz</a>
        </footer>
    </div>
</div>

</body>
</html>