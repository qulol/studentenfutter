<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 22.06.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>FAQ - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="../images/bg/wood-wallpaper.jpg" alt="bg-image">
    <a href="index.jsp"><img class="logo" src="../images/icons_logo/logo.png" alt="logo"></a>
    <header>
        <div class="navbar">
            <a href="login.jsp">Login</a>
            <a href="recipes.jsp">Kategorien</a>
            <a href="create_recipe.jsp ">Rezept hinzufügen</a>
            <a href="shopping_list.jsp">Einkaufsliste</a>
            <input type="search" class="search" id="search" placeholder="Suchbegriff eingeben"><label for="search"><i
                class="fas fa-search"></i></label>

        </div>
    </header>

    <div class="regular-top-content-wrapper error-content">
        <div class="regular-top-content-block white-bg" id="top-text">
            <h1 class="centered">Hoppla!</h1>
            <img id="error-image" src="../images/error.png" alt="bg-image">
            <h1 class="error-message">Da ist wohl gerade etwas schief gelaufen... :(</h1>
        </div>
    </div>

    <div class="footer-content-wrapper">
        <footer class="footer-content-block">
            <a href="faq.jsp">FAQ</a>
            <a href="legal_notice.jsp">Impressum</a>
            <a href="dataprotection.jsp">Datenschutz</a>
        </footer>
    </div>
</div>
</body>
</html>