<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 22.06.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <script src="../js/recipes.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Übersicht - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="../images/bg/wood-wallpaper.jpg" alt="bg-image">
    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block-text" id="top-text">
            <h1 class="centere">Login</h1>
            <div class="login">
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <label for="username">Username:</label><br>
                    <input type="text" id="username" name="username" value=""><br>
                    <label for="password">Password:</label><br>
                    <input type="password" id="password" name="password" value=""><br>
                    <c:choose>
                        <c:when test="${requestScope.login_error}">
                            Falscher Benutzername/Passwort
                        </c:when>
                        <c:when test="${requestScope.register_success}">
                            Registierung erfolgreich
                        </c:when>
                    </c:choose><br>
                    <input type="submit" value="Login"><br><br>
                    <a href="${pageContext.request.contextPath}/register">Du bist noch nicht Registriert? Dann klicke Hier!</a><br>
                </form>
            </div>
        </div>
    </div>

    <%@include file="include/static/footer.jsp"%>
</div>

</body>
</html>