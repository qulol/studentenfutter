<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28.06.2020
  Time: 05:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href='${pageContext.request.contextPath}/recipedetail?id=${param.id}#ingredientsTab'>
    <div class='single-recipe-block filtered-list'>
        <img src="${pageContext.request.contextPath}/files/images/recipe?id=${param.id}" class='recipe-list-image' alt='Rezeptbild'>
        <div class='recipe-list-text'><c:out value="${param.previewText}"/></div>
        <div class='recipe-list-author'>von:<br><c:out value="${param.author}"/></div>
        <h5 class='recipe-list-headline'><c:out value="${param.name}"/></h5>
    </div>
</a>