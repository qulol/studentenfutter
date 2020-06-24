<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/general_styling.css">
    <link rel="stylesheet" type="" href="../fontawesome/css/all.css">
    <script rel="script" src="../js/index.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Trail-Mix: DIY-Omnomnom!</title>
</head>
<body class="index-body">
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="../images/bg/index-top.jpg" alt="bg-image">

    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="index-top-content-wrapper">
        <div class="index-top-content-block" id="topContentBlock">
            <h2>Do it yourself!</h2>
            <h2 class="text-indent">Leckere und einfache Gerichte für jeden Tag!</h2>
        </div>
    </div>

    <div class="index-middle-content-wrapper" id="middleContent">
        <div class="firstStep fadeIn">
            <h1>1. Schritt</h1>
            <p>
                Kochen, so einfach wie nie! Einfach in unserer Datenbank die gewünschten
                (students-and-dummy-proofed <i class="far fa-smile"></i> ) Rezepte heraussuchen, die Menge pro Rezept
                online berechnen und die
                Zutaten der Einkaufsliste hinzufügen
            </p>
        </div>
        <div class="index-middle-content-block" id="middle-icons">
            <img class="icons" id="firstIcon" src="../images/icons_logo/book.png" alt="book-icon">
            <img class="icons" id="right-arrow" src="../images/icons_logo/right-arrow.png" alt="right-arrow-icon">
            <img class="icons" id="secondIcon" src="../images/icons_logo/list.png" alt="list-icon">
        </div>
        <div class="secondStep fadeIn" id="secondStep">
            <h1>2. Schritt</h1>
            <p>
                Öffne die Einkaufsliste, drucke sie aus und erledige deinen Einkauf...<br>
                Danach hast du alles in der Hand, um die Rezepte nachzukochen.<br>
                Versprochen!
            </p>
        </div>
    </div>


    <div class="index-bottom-content-wrapper">
        <div class="index-bottom-content-block" id="bottom-text">
            <h2 class="rotate">Auch du schaffst es! :) </h2>

        </div>
    </div>

    <%@include file="include/static/footer.jsp" %>

</div>

</body>
</html>
