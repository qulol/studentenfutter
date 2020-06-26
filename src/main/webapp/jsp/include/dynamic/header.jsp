<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23.06.2020
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page"/>
<a href="${pageContext.request.contextPath}/index">
    <img class="logo" src="${contextPath}/images/icons_logo/logo.png" alt="logo">
</a>
<header>
    <div class="navbar">
        <c:set var="isLogged" value="${sessionScope.user != null}" scope="page"/>
        <c:choose>
            <c:when test="${isLogged}">
                <a href="${contextPath}/profile">Profil</a>
            </c:when>
            <c:otherwise>
                <a href="${contextPath}/login">Anmelden</a>
            </c:otherwise>
        </c:choose>
        <a href="${contextPath}/jsp/categories.jsp">Rezepte</a>
        <a href="${contextPath}/add">Rezept hinzufügen</a>
        <a href="${contextPath}/jsp/shopping_list.jsp">Einkaufsliste</a>
        <c:if test="${isLogged}">
            <a class="logout" href="${contextPath}/logout">Abmelden</a>
        </c:if>

        <form action="${pageContext.request.contextPath}/search" method="post">
            <label for="searchbar"></label>
        <input type="search" class="search" id="searchbar" placeholder="Suchbegriff eingeben">
            <button type="submit" class="search-button">
                <i class="fas fa-search"></i>
            </button>
        </form>

    </div>
    <a href="http://lieferando.de" target="_blank" title="PANIC - Lieferando ist dein Freund :) ">
        <img class="panicbutton" src="${contextPath}/images/icons_logo/panicbutton.png" alt="PanicButtonImage">
    </a>
</header>
