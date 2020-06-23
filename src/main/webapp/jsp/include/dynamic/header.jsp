<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23.06.2020
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<a href="${pageContext.request.contextPath}/index"><img class="logo" src="../../../images/icons_logo/logo.png" alt="logo"></a>
<header>
    <div class="navbar">
        <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page"/>
        <c:set var="isLogged" value="${sessionScope.user != null}" scope="page"/>
        <c:choose>
            <c:when test="${isLogged}">
                <a href="${contextPath}/profile">Profil</a>
            </c:when>
            <c:otherwise>
                <a href="${contextPath}/login">Anmelden</a>
            </c:otherwise>
        </c:choose>
        <a href="${contextPath}/jsp/categories.jsp">Kategorien</a>
        <a href="${contextPath}/jsp/create_recipe.jsp">Rezept hinzufügen</a>
        <a href="${contextPath}/jsp/shopping_list.jsp">Einkaufsliste</a>
        <c:if test="${isLogged}">
            <a href="${contextPath}/logout">Abmelden</a>
        </c:if>
        <input type="search" class="search" id="search" placeholder="Suchbegriff eingeben"><label for="search"><i
            class="fas fa-search"></i></label>
    </div>
    <a href="http://lieferando.de" target="_blank" title="PANIC - Lieferando ist dein Freund :) ">"<img
            class="panicbutton"
            src="../../../images/icons_logo/panicbutton.png"
            alt="PanicButtonImage"></a>
</header>
