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
    <title>FAQ - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <%@include file="include/background-default.jsp" %>
    <jsp:include page="include/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <h1 class="centered">FAQ - Übersicht</h1>
        <div class="regular-top-content-block scrollbar white-bg" id="top-text">

            <div class="text-paragraph faq-content">
                <a href="#faq-1"><h1 class="centered faq-headlines overview">Erste Übersicht der Funktionen -
                    Header</h1></a>
                <a href="#faq-2"><h1 class="centered faq-headlines overview">Erste Übersicht der Funktionen -
                    Footer</h1></a>
                <a href="#faq-3"><h1 class="centered faq-headlines overview">Wie kann ich mich anmelden?</h1></a>
                <a href="#faq-4"><h1 class="centered faq-headlines overview">Wieso sollte ich mich überhaupt
                    registrieren?</h1></a>
                <a href="#faq-5"><h1 class="centered faq-headlines overview">Welche Rezept-Kategorien sind
                    vorhanden?</h1></a>
                <a href="#faq-6"><h1 class="centered faq-headlines overview">Wie komme ich nun zu der
                    Rezept-Detailseite?</h1></a>
                <a href="#faq-7"><h1 class="centered faq-headlines overview">Kann ich auch eigene Rezepte
                    hinzufügen?</h1></a>
                <a href="#faq-8"><h1 class="centered faq-headlines overview">Wie ist die Detail-Ansicht der Rezepte
                    aufgebaut?</h1></a>
                <a href="#faq-9"><h1 class="centered faq-headlines overview">Meine Einkaufsliste ist nun also fertig...
                    was nun?</h1></a>
                <a href="#faq-10"><h1 class="centered faq-headlines overview">Hilfe, es hat mit dem Kochen trotzdem
                    nicht funktioniert!</h1></a>

                <h1 id="faq-1" class="centered faq-headlines">Erste Übersicht der Funktionen - Header</h1>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/header.png"
                     alt="FAQ image">
                <div class="faq-text">
                    <p>
                        Im Header befinden sich die wichtigsten Funktionen zusammengefasst...
                    </p>
                    <p class="faq-text-head">
                        <b>1. Anmelden:</b>
                    </p>
                    <p>Um alle Funktionen, wie zum Beispiel die Einkaufsliste, nutzen zu können, solltest
                        du
                        dich anmelden.
                    </p>
                    <p class="faq-text-head">
                        <b>2. Rezepte:</b>
                    </p>
                    <p>Hier kannst du über die Kategorien Frühstück, Mittagessen und Abendessen dein
                        gewünschtes Rezept suchen.
                    </p>
                    <p class="faq-text-head">
                        <b>3. Rezept hinzufügen:</b>
                    </p>
                    <p>
                        Die vorhandenen Rezepte reichen dir nicht aus? Natürlich kannst du auch
                        eigene
                        Rezepte zum Rezeptpool hinzufügen!
                    </p>
                    <p class="faq-text-head">
                        <b>4. Suchfunktion:</b>
                    </p>
                    <p>
                        Wenn es ganz schnell gehen soll oder du nach bestimmten Autoren suchst, kannst
                        du
                        für die
                        Rezeptsuche natürlich auch die Suchfunktion verwenden.
                    </p>
                    <p class="faq-text-head">
                        <b>5. Panic-Button:</b>
                    </p>
                    <p>
                        Zu jeder Zeit der Retter in der Not, falls das Kochvorhaben doch scheitern
                        sollte
                        <i class="far fa-smile"></i>
                    </p>
                </div>

                <h1 id="faq-2" class="centered faq-headlines">Erste Übersicht der Funktionen - Footer</h1>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/footer.png"
                     alt="FAQ image">
                <p>
                    Im Footer findest du den Link zum Impressum und zum Thema Datenschutz.
                </p>

                <h1 id="faq-3" class="centered faq-headlines">Wie kann ich mich anmelden?</h1>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/login.png"
                     alt="FAQ image">
                <p>
                    Über die Navigationsleiste kommst du zum Login, solltest du dich aber noch nicht registriert haben,
                    kannst du über den unten befindlichen Link die Möglichkeit zur Registrierung finden.
                </p>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/register.png"
                     alt="FAQ image">
                <h1 id="faq-4" class="centered faq-headlines">Wieso sollte ich mich überhaupt registrieren?</h1>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/header-loggedin.png"
                     alt="FAQ image">
                <p>
                    <b>1.</b> Der volle Funktionsumfang (Nutzung der Einkaufsliste) ist nur im angemeldeten Zustand
                    möglich!
                    Wir empfehlen darum, euch zu Beginn einen Account anzulegen.
                </p>
                <p>
                    <b>2.</b> Ausloggen kannst du dich natürlich zu jeder Zeit, solltest du unseren Service an einem
                    öffentlichen Computer nutzen.
                </p>

                <h1 id="faq-5" class="centered faq-headlines">Welche Rezept-Kategorien sind vorhanden?</h1>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/categories.png"
                     alt="FAQ image">
                <p>
                    Wenn ihr dem Link "Rezepte" gefolgt seit, erhaltet ihr eine Übersicht der vorhandenen Kategorien.
                </p>
                <p>
                    Um die zugeordneten Rezepte anzuzeigen, einfach auf die gewünschte Kategorie klicken.
                </p>

                <h1 id="faq-6" class="centered faq-headlines">Wie komme ich nun zu der Rezept-Detailseite?</h1>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/recipe-detail.png"
                     alt="FAQ image">
                <p>
                    Eure gefilterte Liste enthält alle vorhandenen Rezepte, die ihr auch wieder per Klick erreichen
                    könnt.
                </p>
                <p>
                    In dieser Übersicht ist bereits eine kurze Beschreibung, der Autor, Titel und
                    - falls ein Bild bereitgestellt wurde - ein kleines Vorschaubild zu finden.
                </p>

                <h1 id="faq-7" class="centered faq-headlines">Kann ich auch eigene Rezepte hinzufügen?</h1>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/recipe-add.png"
                     alt="FAQ image">
                <p>
                    Wenn du eigene Rezepte hinzufügen möchtest, musst du das Formular in "Rezept hinzufügen" ausfüllen.
                </p>
                <p class="faq-text-head">
                    <b>1. Rezeptinformationen</b>
                </p>
                <p>
                    Hier musst du einen Rezepttitel, eine kurze Beschreibung für die Übersichts-Liste, die gewünschte
                    Kategorie eingetragen und, falls gewünscht, ein Bild von eurem PC hochgeladen werden.
                </p>
                <p class="faq-text-head">
                    <b>2. Die benötigten Zutaten</b>
                </p>
                <p>
                    Trage die benötigte Menge und die Zutat ein. Danach musst du nur die passende Einheit per Dropdown
                    auswählen.
                </p>
                <p>
                    Die Zutaten reichen nicht aus? Natürlich kannst du links mit Hilfe der Buttons jederzeit neue
                    Zutaten hinzufügen oder auch wieder entfernen.
                </p>
                <p class="faq-text-head">
                    <b>3. Zubereitungsschritte</b>
                </p>
                <p>
                    Natürlich darf die Schritt für Schritt Arbeitsanweisung nicht fehlen...
                </p>
                <p>
                    Trage bitte jeden Arbeitsschritt einzelnd ein und erweitert/kürzt diese auch hier wieder per
                    Plus/Minus.
                </p>
                <p class="faq-text-head">
                    <b>4. Rezept speichern</b>
                </p>
                <p>
                    Zum Schluss muss das Rezept nur noch gespeichert werden.. ihr werden daraufhin direkt auf die
                    Detailseite umgeleitet.
                </p>

                <h1 id="faq-8" class="centered faq-headlines">Wie ist die Detail-Ansicht der Rezepte aufgebaut?</h1>
                <p class="faq-text-head">
                    <b>1. Auswahl der benötigten Menge</b>
                </p>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/ingredient-tab.png"
                     alt="FAQ image">
                <p>
                    Auf der Detailseite kannst du nun das Rezept auf die gewünschte Portionsanzahl umrechnen lassen.
                </p>
                <p>
                    Willst du die gewählte Menge zur Einkaufsliste hinzufügen, musst du dies nur noch per "Zur
                    Einkaufsliste hinzufügen" bestätigen.
                </p>
                <p>
                    Daraufhin wirst du zur Einkaufsliste umgeleitet.
                </p>
                <p class="faq-text-head">
                    <b>2. Anleitung</b>
                </p>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/description-tab.png"
                     alt="FAQ image">
                <p>
                    Über die oberhalb befindlichen Reiter kannst du jederzeit zwischen Zutatenliste und der Schritt für
                    Schritt Anleitung hin und her wechseln.
                </p>


                <h1 id="faq-9" class="centered faq-headlines">Meine Einkaufsliste ist nun also fertig... was nun?</h1>
                <img class="faq-image" src="${pageContext.request.contextPath}/images/faq/shoppingcart.png"
                     alt="FAQ image">
                <p>
                    Navigiere einfach über die Navigationsleiste zur Einkaufsliste und lass dir deine bisher
                    gespeicherten
                    Zutaten anzeigen.
                </p>
                <p>
                    Diese Liste kannst du zum Schluss natürlich auch ausdrucken und bei deinem nächsten Einkauf
                    mitnehmen.
                </p>
                <p>
                    Sollte sie nicht mehr benötigt werden, kannst du sie natürlich auch wieder löschen und für deinen
                    nächsten Einkauf sammeln!
                </p>

                <h1 id="faq-10" class="centered faq-headlines">Hilfe, es hat mit dem Kochen trotzdem nicht
                    funktioniert!</h1>
                <a href="http://lieferando.de" target="_blank" title="PANIC - Lieferando ist dein Freund :) ">
                    <img class="faq-panic-button"
                         src="${pageContext.request.contextPath}/images/icons_logo/panicbutton.png"
                         alt="FAQ image">
                </a>
                <p class="faq-panic-button-text">
                    Dann denk daran... Lieferando ist dein Freund <i class="far fa-smile"></i>
                </p>


            </div>
        </div>
    </div>

    <%@include file="include/footer.jsp" %>
</div>
</body>
</html>
