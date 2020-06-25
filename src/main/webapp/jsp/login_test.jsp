<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page"/>
<div class="login">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="username" class="login-form"></label>
        <input class="login-form-input" type="text" id="username" name="username"
               placeholder="Benutzername">
        <label for="password" class="login-form"></label>
        <input class="login-form-input" type="password" id="password" name="password"
               placeholder="Passwort">
        <input class="buttonLogin" type="submit" value="Login">
        <a href="${pageContext.request.contextPath}/register">
            Du bist noch nicht Registriert? Dann klicke Hier!</a>
    </form>
</div>

