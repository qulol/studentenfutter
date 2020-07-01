<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <script src="../js/PrintShoppingCart.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Einkaufsliste - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <%@include file="include/background-default.jsp"%>
    <jsp:include page="include/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block white-bg scrollbar" id="top-text">
            <h1 class="centered">Einkaufsliste</h1>
            <button class="buttonPrintShoppingList" id="printShoppingList" data-content="content" onclick="printShoppingList()">
                Einkaufsliste drucken
            </button>
            <form action="${pageContext.request.contextPath}/clearshoppingcart" method="get">
                <button type="submit" class="buttonDeleteShoppingList" id="deleteShoppingList">
                    Einkaufsliste löschen
                </button>
            </form>
            <div class="shoppingListTableWrapper" id="shoppingcart">
                <table class="ingredientsTable">
                    <thead class="th-fixed">
                    <tr class="shopping-list">
                        <td class="amount header" id="amount"><b>Menge</b></td>
                        <td class="unit header" id="unit"><b>Einheit</b></td>
                        <td class="singleIngredient header" id="singleIngredient"><b>Zutat</b></td>
                    </tr>
                    </thead>
                    <tbody class="with-margin-top" id="shoppingList">
                        <c:forEach var="ingredient" items="${sessionScope.user.shoppingCard.ingredients}">
                            <tr>
                                <td class='amount'>${ingredient.amount}</td>
                                <td class='unit'>${ingredient.unit}</td>
                                <td class='singleIngredient'>${ingredient.name}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <%@include file="include/footer.jsp"%>
</div>

</body>
</html>