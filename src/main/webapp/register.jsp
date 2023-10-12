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
    <title>Register</title>
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <style>
        .container {
            max-width: 550px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #eee;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        button {
            background-color: #007BFF;
            color: #fff;
            padding: 8px 15px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Inscription</h2>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Nom d'utilisateur</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password" required>
        </div>

        <fieldset>
            <label for="terms">
                <input type="checkbox" id="terms" name="terms">
                Je represente une ecole
            </label>
        </fieldset>

        <div class="form-group">
            <button type="submit">S'inscrire</button>
        </div>
    </form>
</div>

<%--Formulaire ecole--%>
<div class="container">
    <h2>Inscription</h2>
    <form action="/registerEcole" method="post">
        <div class="form-group">
            <label for="raison">Raison Social</label>
            <input type="text" id="raison" name="raison" required>
        </div>

        <div class="form-group">
            <button type="submit">Confirmer</button>
        </div>
    </form>
</div>

<%--Formulaire Enseignant--%>
<div class="container">
    <h2>Information enseignant</h2>
    <form action="/registerEnseignant" method="post">

        <div class="form-group">
            <label for="name">Nom</label>
            <input type="text" id="name" name="name" required>
        </div>

        <div class="form-group">
            <label for="prenom">Prenom</label>
            <input type="text" id="prenom" name="prenom" required>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="Adresse Email" required>
        </div>

        <div class="form-group">
            <label for="telephone">Telephone</label>
            <input type="text" id="telephone" name="telephone" required>
        </div>

        <div class="form-group">
            <label for="centreInteret">Centre d'Interet :</label><br>
            <textarea id="centreInteret" name="centreInteret" rows="10" cols="50"></textarea><br>
        </div>

        <div class="form-group">
            <label for="site">Site(s) web</label>
            <input type="text" id="site" name="site" required>
        </div>

        <div class="form-group">
            <label for="contrat">Type de contrat</label>
            <input type="text" id="contrat" name="contrat" required>
        </div>

        <div class="form-group">
            <label for="extra">Information supplementaire :</label><br>
            <textarea id="extra" name="extra" rows="10" cols="50"></textarea><br>
        </div>

        <fieldset>
            <label for="terms">
                <input type="checkbox" id="terms" name="terms">
                J'accepte les Conditions Generales d'Utilisation
            </label>
            <label for="notification">
                <input type="checkbox" id="notification" name="notification">
                Je souhaite recevoir des notifications
            </label>
        </fieldset>

        <div class="form-group">
            <button type="submit">Confirmer</button>
        </div>
    </form>
</div>

</body>
</html>

