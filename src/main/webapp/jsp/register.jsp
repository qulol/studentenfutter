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
    <script src="../js/categories.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Übersicht - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <%@include file="include/static/background-default.jsp"%>
    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block-text" id="top-text">
            <h1 class="centered">Anmelden</h1>
            <div class="register">
                <form method="post" action="register" >
                    <label for="username">Benutzername:</label><br>
                    <input type="text" id="username" name="username" value=""><br>
                    <c:if test="${requestScope.username_exists_error}">
                        Es existiert bereits ein Benutzer mit dem Namen.
                    </c:if>
                    <label for="password">Passwort:</label><br>
                    <input type="password" id="password" name="password" value=""><br>
                    <label for="password_repeat">Passwort wiederholen:</label><br>
                    <input type="password" id="password_repeat" name="password_repeat" value=""><br>
                    <c:if test="${requestScope.password_repeat_error}">
                        Passwörter stimmen nicht überein.
                    </c:if>
                    <br>
                    <input type="submit" value="Registrieren"><br><br>
                </form>
            </div>
        </div>
    </div>

    <%@include file="include/static/footer.jsp"%>
</div>

</body>
</html>