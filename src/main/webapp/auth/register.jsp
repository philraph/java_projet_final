<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Register</title>
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="/resources/css/styles.css"/>
</head>
<body>

<div class="container">
    <h2>Inscription</h2>
    <form action="${pageContext.request.contextPath}/api/register" method="post" x-data="{
    accountType: '',
    acceptedTerms: false,
    password: '',
    passwordConfirm: '',
    validatePasswords() { return this.password === this.passwordConfirm && this.password !== '' && this.passwordConfirm !== '' }
}">
        <div class="form-group">
            <label for="username">Nom d'utilisateur</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div class="form-group">
            <label for="passwordConfirm">Confirmer le mot de passe</label>
            <input x-model="passwordConfirm" type="password" id="passwordConfirm" name="passwordConfirm" required>
            <span x-show="password !== '' || passwordConfirm !== '' || !validatePasswords()" style="color: red; font-size: small">Les mots de passe ne correspondent pas.</span>
        </div>

        <div class="form-group">
            <label for="accountType">Type de compte</label>
            <select x-model="accountType" required name="accountType" id="accountType">
                <option selected disabled value="">
                    Sélectionner un type de compte
                </option>
                <option value="enseignant">
                    Je suis un enseignant
                </option>
                <option value="ecole">
                    Je suis une école
                </option>
                <option value="admin">
                    Je suis un administrateur
                </option>
            </select>
        </div>

        <jsp:include page="/WEB-INF/views/registerEcole.jsp"/>
        <jsp:include page="/WEB-INF/views/registerEnseignant.jsp"/>

        <div class="form-group" x-show="accountType !== ''">
            <fieldset>
                <label for="terms">
                    <input type="checkbox" id="terms" name="terms" x-model="acceptedTerms" required>
                    J'accepte les Conditions Generales d'Utilisation <span style="color: red">*</span>
                </label>
            </fieldset>
            <button type="submit" :disabled="!acceptedTerms || !validatePasswords())">S'inscrire</button>
        </div>

    </form>
</div>

</body>
</html>

