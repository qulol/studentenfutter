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

<body class="scrollbar">
<div class="wrapper" id="wrapper">
    <%@include file="include/background-default.jsp" %>
    <jsp:include page="include/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block-text" id="top-text">
            <h1 class="centered">Rezept Hinzufügen</h1>
            <div class="create-recipe">

                <form method="post" action="${pageContext.request.contextPath}/add" enctype="multipart/form-data">
                    <label for="name"></label>
                    <input type="text" id="name" name="name" placeholder="Name"><br><br>
                    <input type="file" name="img" accept="image/*"><br><br>
                    <h3>Kategorie</h3>
                    <label for="category"></label><br>
                    <select id="category" name="category">
                        <option value="Frühstück">Frühstück</option>
                        <option value="Mittagessen">Mittagessen</option>
                        <option value="Abendessen">Abendessen</option>
                    </select><br><br>

                    <div class="ingredientsWrapper">
                        <input type="hidden" id="ingredientCount" name="ingredientCount">
                        <h3>Zutaten</h3>
                        <input type="button" class="add-recipe-quantify-button-block" id="addIngredientButton" onClick="addIngredient()" value="+">
                        <div class="ingredientContainer" id="ingredientContainer" data-maxCount="${requestScope.maxIngredientCount}">
<%--                            filled dynmic from script--%>
                        </div>

                        <input type="button" class="add-recipe-quantify-button-block" id="removeIngredientButton" onClick="removeIngredient()" value="-">
                    </div>
                    <br>
                    <br>
                    <div class="descriptionWrapper">
                        <input type="hidden" id="descriptionCount" name="descriptionCount">
                        <h3>Anleitung</h3>
                        <input type="button" class="add-recipe-quantify-button-block" id="addDescriptionButton" onclick="addDescription()" value="+">
                        <div class="descriptionContainer" id="descriptionContainer" data-maxCount="${requestScope.maxDescriptionCount}">
<%--                            filled dynamic from script--%>
                        </div>
                        <input type="button" class="add-recipe-quantify-button-block" id="removeDescriptionButton" onClick="removeDescription()" value="-">
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
