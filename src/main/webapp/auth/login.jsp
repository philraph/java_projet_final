<%--
  Created by IntelliJ IDEA.
  User: raphaelbarriet
  Date: 12/10/2023
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Login</title>
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="/resources/css/styles.css"/>
</head>
<body>

<div class="container">
    <h2>Connexion</h2>
    <form x-on:submit.prevent="submitForm" x-data="loginForm()">
        <div class="form-group">
            <label for="username">Nom d'utilisateur</label>
            <input type="text" id="username" name="username" x-model="username" required>
        </div>

        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password" x-model="password" required>
        </div>

        <div class="form-group">
            <button type="submit">Se connecter</button>
        </div>

        <p>Pas encore de compte ? <a href="/auth/register.jsp">S'inscrire</a></p>
    </form>
</div>


<script>
    function loginForm() {
        return {
            formData: {
                username: '',
                password: ''
            },
            submitForm() {
                let formData = new FormData();
                formData.append('username', this.username);
                formData.append('password', this.password);

                fetch('/api/login', {
                    method: 'POST',
                    body: formData
                })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error(response.statusText);
                        }
                        return response.json();
                    })
                    .then(() => window.location.href = '/dashboard')
                    .catch(error => console.error('Error:', error));
            }
        }
    }
</script>

</body>
</html>

