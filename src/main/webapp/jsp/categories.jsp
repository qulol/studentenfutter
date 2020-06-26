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
    <script src="../js/categories.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Rezept-Kategorien - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <%@include file="include/static/background-default.jsp"%>
    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block" id="top-text">
            <h1 class="centered">Rezept-Kategorien</h1>
            <div class="recipes-overview-wrapper">
                <div class="categories-block">
                    <div class="categories-block" id="recipes">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="include/static/footer.jsp"%>
</div>

</body>
</html>