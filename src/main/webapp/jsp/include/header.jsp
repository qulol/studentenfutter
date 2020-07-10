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
        <c:choose>
            <c:when test="${sessionScope.user.loggedIn}">
                <span id="helloUser">Hallo <c:out value="${sessionScope.user.username}"/>!</span>
            </c:when>
            <c:otherwise>
                <a href="${contextPath}/login">Anmelden</a>
            </c:otherwise>
        </c:choose>
        <a href="${contextPath}/jsp/categories.jsp">Rezepte</a>
        <a href="${contextPath}/add">Rezept hinzufügen</a>
        <c:if test="${sessionScope.user.loggedIn}">
            <a href="${contextPath}/shoppingcart">Einkaufsliste</a>
            <a class="logout" href="${contextPath}/logout">Abmelden</a>
        </c:if>

        <form action="${pageContext.request.contextPath}/recipes" method="get">
            <label for="searchbar"></label>
            <input type="search" class="search" id="searchbar" name="search" placeholder="Suchbegriff eingeben"
                   required pattern="${applicationScope.recipeSearchVerification.searchVerification.toString()}"
                   title="Ihre Eingabe darf nur Wörter, Zahlen und Leerzeichen enthalten.">
            <button type="submit" class="search-button">
                <i class="fas fa-search"></i>
            </button>
        </form>

    </div>
    <a href="http://lieferando.de" target="_blank" title="PANIC - Lieferando ist dein Freund :) ">
        <img class="panicbutton" src="${contextPath}/images/icons_logo/panicbutton.png" alt="PanicButtonImage">
    </a>
</header>
