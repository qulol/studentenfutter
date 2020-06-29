<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="login-wrapper">
    <form action="${pageContext.request.contextPath}/login" method="post">

        <label for="username" class="login-form"></label>
        <input class="login-form-input" type="text" id="username" name="username"
               placeholder="Benutzername">
        <label for="password" class="login-form"></label>
        <input class="login-form-input" type="password" id="password" name="password"
               placeholder="Passwort">

        <div class="login-message fadeIn fadeOut">
            <c:choose>
                <c:when test="${requestScope.login_error}">
                    <div class="login-error-message">
                        Falscher Benutzername/Passwort
                    </div>
                </c:when>

                <c:when test="${requestScope.register_success}">
                    <div class="login-success-message">
                        Registierung erfolgreich
                    </div>
                </c:when>
            </c:choose>
        </div>

        <input class="buttonLogin" type="submit" value="Login">
        <a href="${pageContext.request.contextPath}/register">Du bist noch nicht Registriert? Dann klicke
            Hier!</a>
    </form>
</div>