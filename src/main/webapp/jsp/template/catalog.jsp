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
        <c:choose>
            <c:when test="${requestScope.onRegister}">
                Registrieren - Trail-Mix
            </c:when>
            <c:otherwise>
                Login - Trail-Mix
            </c:otherwise>
        </c:choose>
    </title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <%@include file="../include/background-default.jsp"%>
    <jsp:include page="../include/header.jsp"/>
    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block-text" id="top-text">
            <h1 class="centered">
                <c:choose>
                    <c:when test="${requestScope.onRegister}">
                        Registrieren
                    </c:when>
                    <c:otherwise>
                        Login
                    </c:otherwise>
                </c:choose>
             </h1>
            <img class="user-image" src="${contextPath}/images/other_pictures/user_image.png" alt="Benutzerbild">
            <c:choose>
                <c:when test="${requestScope.onRegister}">
                    <jsp:include page="../include/register.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="../include/login.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <%@include file="../include/footer.jsp" %>
</div>

</body>
</html>
