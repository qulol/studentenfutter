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
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Übersicht - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="../images/bg/wood-wallpaper.jpg" alt="bg-image">
    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block-text" id="top-text">
            <h1 class="centered">Variable Überschrift</h1>
            <img class="user-image" src="../images/other_pictures/user_image.png" alt="Benutzerbild">

            <c:set var="newUser" value="0" scope="page"/>
            <c:choose>
                <c:when test="${newUser}">
                    <jsp:include page="register_test.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="login_test.jsp"/>
                </c:otherwise>
            </c:choose>

            <div class="login-message fadeIn fadeOut">
                <c:choose>
                    <c:when test="${requestScope.login_error}">
                        <div class="login-error-message">
                            Falscher Benutzername/Passwort
                        </div>
                    </c:when>

                    <c:when test="${requestScope.register_success}">
                        <div class="login-success-message">
                            Registierung erfolgreich
                        </div>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>
</div>

<%@include file="include/static/footer.jsp" %>
</div>

</body>
</html>