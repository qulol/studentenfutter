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
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Datenschutz - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="../images/bg/wood-wallpaper.jpg" alt="bg-image">
    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper">

        <div class="regular-top-content-block white-bg">
            <h1 class="centered">Datenschutz</h1>
            <div class="text-paragraph">
                <h4>Grundlegendes</h4>
                <p>
                    Diese Datenschutzerklärung soll die Nutzer dieser Website über die Art, den Umfang und den Zweck der
                    Erhebung und Verwendung personenbezogener Daten durch den Websitebetreiber <a
                        href="legal_notice.jsp">[
                    Hier geht's zum Impressum ]</a>
                    informieren.
                </p>
                <p>
                    Der Websitebetreiber nimmt Ihren Datenschutz sehr ernst und verwendet aus diesem Grund keine
                    (ungesunden) Cookies oder ähnliche Datenbomben <i class="far fa-smile"></i>
                </p>
            </div>
            <img src="../images/icons_logo/cookies.png" id="cookie-image" alt="cookie-image">
        </div>
    </div>

    <%@include file="include/static/footer.jsp"%>
</div>
</body>
</html>