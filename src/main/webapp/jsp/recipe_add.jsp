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
    <script src="../js/categories.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Übersicht - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="../images/bg/wood-wallpaper.jpg" alt="bg-image">
    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block-text" id="top-text">
            <h1 class="centere">Rezept Hinzufügen</h1>

            <div class="create-recipe">
                <form method="post" action="index.jsp" enctype="multipart/form-data">
                    <label for="name"></label>
                    <input type="text" id="name" name="name" placeholder="Name"><br><br>
                    <input type="file" name="img" accept="image/*"><br><br>
                    <label for="category">Kategorie:</label><br>
                    <select id="category" name="category">
                        <option value="Frühstück">Frühstück</option>
                        <option value="Mittagessen">Mittagessen</option>
                        <option value="Abendessen">Abendessen</option>
                        <option value="Snack">Snack</option>
                    </select><br><br>

                    <div class="ingredient">
                        <label for="amount"></label>
                        <input type="text" id="amount" name="amount" placeholder="amount">
                        <label for="unit"></label>
                        <select id="unit" name="unit">
                            <option value="g">g</option>
                            <option value="kg">kg</option>
                        </select>
                        <label for="ingredient"></label>
                        <input type="text" id="ingredient" name="ingredient" placeholder="ingredient">
                        <input type="button" value="+">
                    </div>

                    <h3>Anleitung</h3>
                    <div class="description">
                        <label for="description">1</label><br>
                        <textarea id="description" cols="40" rows="4"></textarea>
                        <input type="button" value="+">
                        <br><br>
                    </div>
                    <input type="submit" value="Save">
                </form>
            </div>
        </div>
    </div>

    <%@include file="include/static/footer.jsp"%>
</div>

</body>
</html>
