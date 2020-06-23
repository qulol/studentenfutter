<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23.06.2020
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <script src="../js/recipes_filtered_list.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Übersicht - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="../images/bg/wood-wallpaper.jpg" alt="bg-image">
    <a href="index.jsp"><img class="logo" src="../images/icons_logo/logo.png" alt="logo"></a>

    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block" id="top-text">
            <h1 class="centered">Übersicht unserer studentenfreundlichen Rezepte</h1>
            <div class="recipes-overview-wrapper">
                <div class="single-recipe-block filtered-list">

                    <div id="recipes-filtered-list">
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="footer-content-wrapper">
        <%@include file="include/static/footer.jsp"%>
    </div>
</div>

</body>
</html>