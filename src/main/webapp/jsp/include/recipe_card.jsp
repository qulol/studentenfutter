<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28.06.2020
  Time: 05:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href='${pageContext.request.contextPath}/recipedetail?id=1'>
    <div class='single-recipe-block filtered-list'>
        <img src="${pageContext.request.contextPath}/images/default_recipe_image.jpg" class='recipe-list-image' alt='Rezeptbild'>
        <div class='recipe-list-text'>${param.previewText}</div>
        <div class='recipe-list-author'>${param.author}</div>
        <h5 class='recipe-list-headline'>${param.name}</h5>
    </div>
</a>