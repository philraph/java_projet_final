<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html data-theme="dark">
<jsp:include page="/WEB-INF/components/partials/head.jsp"/>
<body>
<jsp:include page="/WEB-INF/components/partials/header.jsp"/>
<main class="container">
    <jsp:include page="/WEB-INF/components/partials/nav.jsp"/>
    <div role="document">
        <h1>Bienvenue sur AMiRE,</h1>
        <p>${header}</p>
        <jsp:include page="/WEB-INF/components/offers.jsp"/>
    </div>
</main>
</body>
</html>
