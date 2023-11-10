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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>

    <style>
        .container {
            max-width: 550px;
            margin: 50px auto;
            padding: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        button:hover {
            background-color: #0056b3;
        }

        .container {
            max-width: 550px;
            margin: 100px auto;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        .alert {
            background: red;
            color: white;
            padding: 20px 15px;
            border-radius:15px ;
            margin: 15px 0;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Connexion</h2>
    <form x-on:submit.prevent="submitForm" x-data="loginForm()">
        <div x-show="error" class="alert">
            <span x-text="error" class="error"></span>
        </div>
        <div class="form-group">
            <label for="username">Nom d'utilisateur</label>
            <input type="text" id="username"  x-model="username" required>
        </div>

        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" id="password"  x-model="password" required>
        </div>

        <div class="form-group">
            <button type="submit">Se connecter</button>
        </div>

        <p>Pas encore de compte ? <a href="/auth/register">S'inscrire</a></p>
    </form>
</div>


<script>
    function loginForm() {
        return {
            username: '',
            password: '',
            error : '',
            submitForm() {
                let formData = new FormData();
                formData.append('username', this.username);
                formData.append('password', this.password);

                const querystring = new URLSearchParams(formData).toString()

                fetch('/api/login?' + querystring, {
                    method: 'POST',
                    body: formData
                })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error(response.statusText);
                        }
                        return response.json();
                    })
                    .then((response) => {
                        if(response.status === "error") {
                            this.error = response.message;
                        } else {
                            window.location.href = "/dashboard";
                        }
                    })
                    .catch(error => this.error = error.message);
            }
        }
    }
</script>

</body>
</html>

