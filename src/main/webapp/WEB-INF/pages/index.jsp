<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Page d'accueil</title>
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
</head>
<body class="bg-light p-4">
<div class="container mx-auto">
    <h1 class="text-dark mb-4">AMiRE</h1>
    <p class="text-muted mb-4">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus lacinia odio vitae
        vestibulum. Donec in efficitur leo. Morbi efficitur, odio vitae dictum placerat, sem libero volutpat orci, ac
        vehicula justo leo a est. Vivamus suscipit tortor eget felis porttitor volutpat.</p>
    <a href="${pageContext.request.contextPath}/auth/login" class="btn btn-primary">Se connecter</a>
</div>
</body>
</html>
