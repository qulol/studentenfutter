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
    <%@include file="include/background-default.jsp"%>
    <jsp:include page="include/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block" id="top-text">
            <h1 class="centered">Übersicht unserer studentenfreundlichen Rezepte</h1>
            <div class="recipes-overview-wrapper scrollbar">
                <div id="recipes-filtered-list">
                    <c:forEach var="recipe" items="${requestScope.recipes}">
                        <jsp:include page="/jsp/include/recipe_card.jsp">
                            <jsp:param name="id" value="${recipe.id}"/>
                            <jsp:param name="name" value="${recipe.name}"/>
                            <jsp:param name="previewText" value="${recipe.previewText}"/>
                            <jsp:param name="author" value="${recipe.author}"/>
                        </jsp:include>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <%@include file="include/footer.jsp" %>
</div>

</body>
</html>