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
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>FAQ - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="../images/bg/wood-wallpaper.jpg" alt="bg-image">
    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper error-content">
        <div class="regular-top-content-block white-bg" id="top-text">
            <h1 class="centered">Hoppla!</h1>
            <div class="error-code">404</div>
            <img id="error-image" src="../images/error.png" alt="bg-image">

            <h1 class="error-message">Da ist wohl gerade etwas schief gelaufen... :(</h1>
        </div>
    </div>

    <%@include file="include/static/footer.jsp"%>
</div>
</body>
</html>