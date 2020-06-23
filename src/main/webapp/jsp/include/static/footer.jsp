<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="footer-content-wrapper">
    <footer class="footer-content-block">
        <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page"/>
        <a href="${contextPath}/jsp/faq.jsp">FAQ</a>
        <a href="${contextPath}/jsp/legal_notice.jsp">Impressum</a>
        <a href="${contextPath}/jsp/dataprotection.jsp">Datenschutz</a>
    </footer>
</div>