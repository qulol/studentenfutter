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
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <script src="../js/DynamicIngredientRow.js"></script>
    <script src="../js/DynamicDescriptionRow.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Rezept hinzufügen - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <%@include file="include/background-default.jsp" %>
    <jsp:include page="include/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <h1 class="centered">Rezept Hinzufügen</h1>
        <div class="regular-top-content-block white-bg">

            <div class="create-recipe">
                <form method="post" action="${pageContext.request.contextPath}/add" enctype="multipart/form-data">

                    <h1>Rezeptinfos</h1>
                    <div class="addRecipeHead">
                        <label for="name"></label>
                        <input class="addRecipeTitle" type="text" id="name" name="name" placeholder="Rezepttitel">
                        <input class="addRecipeImage" type="file" name="img" accept="image/*">


                        <label for="category"></label>
                        <select id="category" name="category" class="addRecipeCategory">
                            <option value="Fruehstueck">Frühstück</option>
                            <option value="Mittagessen">Mittagessen</option>
                            <option value="Abendessen">Abendessen</option>
                        </select>
                    </div>

                    <div class="addShortDescription">
                        <label>
                            <textarea class="addShortDescription" name="shortDescription"
                                      placeholder="Kurze Beschreibung des Rezepts"
                                      required></textarea>
                        </label>
                    </div>


                    <h1>Zutaten</h1>
                    <div class="addIngredientsWrapper">
                        <input type="hidden" id="ingredientCount" name="ingredientCount">
                        <input type="button" class="addOrRemoveRecipeIngredientRowButton" id="addIngredientButton"
                               onClick="addIngredient()" value="+">
                        <div class="ingredientContainer scrollbar" id="ingredientContainer"
                             data-maxCount="${requestScope.maxIngredientCount}">
                            <%--                            filled dynmic from script--%>
                        </div>

                        <input type="button" class="addOrRemoveRecipeIngredientRowButton" id="removeIngredientButton"
                               onClick="removeIngredient()" value="-">
                    </div>


                    <h1>Anleitung</h1>
                    <div class="addDescriptionWrapper">
                        <input type="hidden" id="descriptionCount" name="descriptionCount">
                        <input type="button" class="addOrRemoveRecipeIngredientRowButton" id="addDescriptionButton"
                               onclick="addDescription()" value="+">
                        <div class="descriptionContainer scrollbar" id="descriptionContainer"
                             data-maxCount="${requestScope.maxDescriptionCount}">
                            <%--                            filled dynamic from script--%>
                        </div>
                        <input type="button" class="addOrRemoveRecipeIngredientRowButton" id="removeDescriptionButton"
                               onClick="removeDescription()" value="-">
                    </div>
                    <input type="submit" value="Save">

                </form>

            </div>
        </div>
    </div>

    <%@include file="include/footer.jsp" %>
</div>

</body>
</html>
