<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="login-wrapper">
    <form class="login" action="${pageContext.request.contextPath}/register" method="post">

        <label for="username" class="login-form"></label>
        <input class="login-form-input" type="text" id="username" name="username"
               placeholder="Benutzername">
        <label for="password" class="login-form"></label>
        <input class="login-form-input" type="password" id="password" name="password"
               placeholder="Passwort">

        <label for="password_repeat" class="login-form"></label>
        <input class="login-form-input" type="password" id="password_repeat" name="password_repeat"
               placeholder="Passwort wiederholen">

        <div class="login-message fadeIn fadeOut">
            <c:if test="${requestScope.username_exists_error}">
                <div class="login-error-message">
                    Der Benutzername ist bereits vergeben.
                </div>
            </c:if>
            <c:if test="${requestScope.password_repeat_error}">
            <div class="login-error-message">
                Passwörter stimmen nicht überein.
            </div>
                </c:if>
        </div>

        <input class="buttonLogin" type="submit" value="Registrieren">

    </form>
</div>