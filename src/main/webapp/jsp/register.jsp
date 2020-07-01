<%--@elvariable id="contextPath" type="java.lang.String"--%>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28.06.2020
  Time: 05:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/general_styling.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome/css/all.css">
    <link rel="icon" href="${pageContext.request.contextPath}/images/icons_logo/icon.png" type="image/png">
    <title>
        Registrieren - Trail-Mix
    </title>
</head>
<body>
    <div class="wrapper" id="wrapper">
        <%@include file="include/background-default.jsp"%>
        <jsp:include page="include/header.jsp"/>
        <div class="regular-top-content-wrapper">
            <h1 class="centered">Registrieren</h1>
            <div class="regular-top-content-block white-bg" id="top-text">

                <img class="user-image" src="${contextPath}/images/other_pictures/user_image.png" alt="Benutzerbild">
                <div class="login-wrapper">
                    <form class="login" action="${pageContext.request.contextPath}/register" method="post">

                        <label for="username" class="login-form"></label>
                        <input class="login-form-input" type="text" id="username" name="username"
                               placeholder="Benutzername">
                        <label for="password" class="login-form"></label>
                        <input class="login-form-input" type="password" id="password" name="password"
                               placeholder="Passwort">

                        <label for="password_repeat" class="login-form"></label>
                        <input class="login-form-input" type="password" id="password_repeat" name="password_repeat"
                               placeholder="Passwort wiederholen">

                        <div class="login-message fadeIn fadeOut">
                            <c:if test="${requestScope.username_exists_error}">
                                <div class="login-error-message">
                                    Der Benutzername ist bereits vergeben.
                                </div>
                            </c:if>
                            <c:if test="${requestScope.password_repeat_error}">
                                <div class="login-error-message">
                                    Passwörter stimmen nicht überein.
                                </div>
                            </c:if>
                        </div>

                        <input class="buttonLogin" type="submit" value="Registrieren">

                    </form>
                </div>
            </div>
           <%@include file="include/footer.jsp" %>
    </div>
</body>
</html>
