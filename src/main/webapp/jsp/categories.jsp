<%--@elvariable id="contextPath" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 22.06.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Rezept-Kategorien - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <%@include file="include/background-default.jsp" %>
    <jsp:include page="include/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <h1 class="centered">Rezept-Kategorien</h1>
        <div class="regular-top-content-block" id="top-text">
            <div class="recipes-overview-wrapper">
                <div class="categories-block">
                    <div class="categories-block" id="recipes">
                        <a href='${contextPath}/recipes?search=Frühstück'>
                            <div class='categories-block'>
                                <img src='${contextPath}/images/category/breakfast.jpg' id='breakfast-image' alt="">
                                <h5>Frühstück</h5>
                            </div>
                        </a>
                        <a href='${contextPath}/recipes?search=Mittagessen'>
                            <div class='categories-block'>
                                <img src='${contextPath}/images/category/lunch.jpeg' id='lunch-image' alt="">
                                <h5>Mittagessen</h5>
                            </div>
                        </a>
                        <a href='${contextPath}/recipes?search=Abendessen'>
                            <div class='categories-block'>
                                <img src='${contextPath}/images/category/dinner.jpg' id='dinner-image' alt="">
                                <h5>Abendessen</h5>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="include/footer.jsp" %>
</div>

</body>
</html>