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
    <script src="../js/recipe_add.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Rezept hinzufügen - Trail-Mix</title>
</head>

<body class="scrollbar">
<div class="wrapper" id="wrapper">
    <%@include file="include/static/background-default.jsp" %>
    <jsp:include page="include/dynamic/header.jsp"/>

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
                        <h3>Zutaten</h3>
                        <div class="ingredientContainer" id="ingredientContainer">
                            <div class="ingredientRow" id="ingredientRow0">
                                <label for="amount0"></label>
                                <input type="number" id="amount0" name="amount0" min="0.1" max="5000" step="0.1" placeholder="Menge">

                                <label for="unit0"></label>
                                <select id="unit0" name="unit0">
                                    <option value="g">g</option>
                                    <option value="ml">ml</option>
                                    <option value="Stk.">Stk.</option>
                                </select>

                                <label for="ingredient0"></label>
                                <input type="text" id="ingredient0" name="ingredient0" placeholder="Zutat">
                            </div>
                        </div>
                        <input type="button" id="ingredientButton" onClick="addIngredientRow()" value="+">

                        <h3>Benötigte Gewürze (bitte mit Komma trennen)</h3>
                        <div class="SeasonRow">
                            <label for="seasonsList"></label><br>
                            <textarea id="seasonsList" name="seasons" cols="100" rows="1"></textarea>

                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="instructionWrapper">
                        <h3>Anleitung</h3>
                        <div class="instructionContainer" id="instructionContainer">
                            <div class="instructionRow" id="instructionRow0">
                                <label for="instructionStep0">1. Schritt</label>
                                <br>
                                <textarea id="instructionStep0" name="instructionStep0" cols="40" rows="4"></textarea>
                            </div>
                        </div>
                        <input type="button" id="instructionButton" onclick="addInstructionRow()" value="+">
                        <input type="button" onClick="removeInstructionRow()" value="-">';
                    </div>

                    <input type="submit" value="Save">

                </form>

            </div>
        </div>
    </div>

    <%@include file="include/static/footer.jsp" %>
</div>

</body>
</html>
