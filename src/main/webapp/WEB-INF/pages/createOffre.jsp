<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Create Offre</title>
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="/resources/css/styles.css"/>
</head>
<body>

<div class="container">
    <h2>Creation d'une offre</h2>
    <form action="/create/offres" method="post">

        <jsp:include page="/WEB-INF/components/createOffre.jsp"/>

        <button type="submit">Créer l'offre</button>

    </form>
</div>

</body>
</html>

