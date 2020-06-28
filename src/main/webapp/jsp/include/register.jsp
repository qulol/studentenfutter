<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="register">
    <form method="post" action="${pageContext.request.contextPath}/register" >
        <label for="username">Benutzername:</label><br>
        <input type="text" id="username" name="username" value=""><br>
        <c:if test="${requestScope.username_exists_error}">
            Es existiert bereits ein Benutzer mit dem Namen.
        </c:if>
        <label for="password">Passwort:</label><br>
        <input type="password" id="password" name="password" value=""><br>
        <label for="password_repeat">Passwort wiederholen:</label><br>
        <input type="password" id="password_repeat" name="password_repeat" value=""><br>
        <c:if test="${requestScope.password_repeat_error}">
            Passwörter stimmen nicht überein.
        </c:if>
        <br>
        <input type="submit" value="Registrieren"><br><br>
    </form>
</div>