<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 22.06.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <script src="../js/recipes_detail.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Details - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <%@include file="include/static/background-default.jsp"%>
    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block black-bg" id="top-text">
            <h1 class="centered" id="headline">Überschrift Rezept</h1>
            <div class="recipe-detail-image-wrapper">
                <img id="recipe-image-detail" src="../images/foodpictures/noodles.jpg" alt="recipe-image-detail">
            </div>
            <div class="recipe-detail">


                <article class="infobox">
                    <div class="tab" id="ingredientsTab">
                        <h4><a href="#ingredientsTab">Zutaten</a></h4>
                        <div class="calculateIngredientsAmount">
                            <form action="${pageContext.request.contextPath}/addtoshoppingcard" method="post">
                                <input type="hidden" name="redirect" value="${pageContext.request.requestURL}">
                                <label for="numberOfPersons">Portionen: </label>
                                <input name="numberOfPersons" id="numberOfPersons"
                                       oninput="calculateAmount()" placeholder="1"
                                       type="number" min="1" step="1">
                                <input class="buttonAddToShoppingList" id="addIngredientsToShoppingList" type="submit"
                                       value="Zutaten zur Einkaufsliste hinzufügen">

                            </form>
                        </div>

                        <div class="ingredientsTableWrapper">
                            <table class="ingredientsTable">
                                <thead>
                                <tr>
                                    <td class="amount header" id="amount"><b>Menge</b></td>
                                    <td class="unit header" id="unit"><b>Einheit</b></td>
                                    <td class="singleIngredient header" id="singleIngredient"><b>Zutat</b></td>
                                </tr>
                                </thead>

                                <tbody id="ingredientsTable">
                                </tbody>
                            </table>
                        </div>
                        <div class="seasonsListWrapper">
                            <h6>Benötigte Gewürze:</h6>
                            <div id="seasonsList">
                            </div>
                        </div>
                    </div>

                    <div class="tab" id="instructionsTab">
                        <h4><a href="#instructionsTab">Anleitung</a></h4>
                        <div class="instructionsListWrapper">
                            <div class="instructionsList" id="instructionsList">
                                <ol class="instructions" id="instructions">
                                </ol>
                            </div>
                        </div>
                    </div>
                </article>
            </div>
        </div>
    </div>

    <%@include file="include/static/footer.jsp" %>
</div>

</body>
</html>