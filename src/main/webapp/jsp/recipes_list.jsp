<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23.06.2020
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Mittagessen - Trail-Mix</title>
</head>
<body>
<div class="wrapper" id="wrapper">
    <%@include file="include/background-default.jsp" %>
    <jsp:include page="include/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <% String searchedWord = request.getParameter("search"); %>

        <% if (searchedWord.equals("Fruehstueck") | searchedWord.equals("Mittagessen") | searchedWord.equals("Abendessen")) { %>
        <h1 class="centered">${requestScope.search}</h1>
        <% } else { %>
        <h1 class="centered">Suchergebnisse für: ${requestScope.search}</h1>
        <% } %>

        <div class="regular-top-content-block scrollbar" id="top-text">
            <div class="recipes-overview-wrapper">

                <c:if test="${empty requestScope.recipeSearchResult}">
                    <h2 class="search-result-header">
                        <img class="nothing-found" src="${pageContext.request.contextPath}/images/no_recipe_found.png"
                             alt="Kein Rezept gefunden">
                    </h2>
                </c:if>



                <c:forEach var="recipeSearchResult" items="${requestScope.recipeSearchResult}">

                <% if (searchedWord.equals("Fruehstueck") | searchedWord.equals("Mittagessen") | searchedWord.equals("Abendessen")) { %>

                <% } else { %>

                    <h2 class="search-result-header">
                        Gefunden unter <c:out value="${recipeSearchResult.prettyColumnName}"/> :
                    </h2>

                    <% } %>



                    <div id="recipes-filtered-list">
                        <c:forEach var="recipe" items="${recipeSearchResult.recipeCards}">
                            <jsp:include page="/jsp/include/recipe_card.jsp">
                                <jsp:param name="id" value="${recipe.id}"/>
                                <jsp:param name="name" value="${recipe.name}"/>
                                <jsp:param name="previewText" value="${recipe.previewText}"/>
                                <jsp:param name="author" value="${recipe.author}"/>
                            </jsp:include>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <%@include file="include/footer.jsp" %>
</div>

</body>
</html>