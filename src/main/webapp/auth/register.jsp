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
    <form x-on:submit.prevent="submitForm" method="post" x-data="registerForm()">
        <div x-show="errors.server" class="alert">
            <span x-text="errors.server" class="error"></span>
        </div>
        <div class="form-group">
            <label for="username">Nom d'utilisateur</label>
            <input type="text" id="username" x-model="username">
            <span x-show="errors.username" style="color: red; font-size: small" x-text="errors.username"></span>
        </div>

        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" id="password" x-model="password">
        </div>

        <div class="form-group">
            <label for="passwordConfirm">Confirmer le mot de passe</label>
            <input x-model="passwordConfirm" type="password" id="passwordConfirm" name="passwordConfirm">
            <span x-show="errors.passwordConfirm" style="color: red; font-size: small" x-text="errors.passwordConfirm"></span>
        </div>

        <div class="form-group">
            <label for="accountType">Type de compte</label>
            <select x-model="accountType" required id="accountType">
                <option selected disabled value="">
                    Sélectionner un type de compte
                </option>
                <option value="enseignant">
                    Je suis un enseignant
                </option>
                <option value="ecole">
                    Je suis une école
                </option>
            </select>
            <span x-show="errors.accountType" style="color: red; font-size: small" x-text="errors.accountType"></span>
        </div>

        <jsp:include page="/WEB-INF/views/registerEcole.jsp"/>
        <jsp:include page="/WEB-INF/views/registerEnseignant.jsp"/>

        <div class="form-group">
            <fieldset>
                <label for="terms">
                    <input type="checkbox" id="terms" x-model="acceptedTerms" required>
                    J'accepte les Conditions Generales d'Utilisation <span style="color: red">*</span>
                </label>
                <span x-show="errors.acceptedTerms" style="color: red; font-size: small" x-text="errors.acceptedTerms"></span>
            </fieldset>
            <button type="submit">S'inscrire</button>
        </div>

    </form>
</div>

<script>
    function registerForm() {
        return {
            username: '',
            accountType: '',
            acceptedTerms: false,
            password: '',
            passwordConfirm: '',
            raison: '',
            name: '',
            prenom: '',
            email: '',
            telephone: '',
            centreInteret: '',
            site: '',
            contrat: '',
            extra: '',
            errors: {
                username: '',
                passwordConfirm: '',
                raison: '',
                name: '',
                prenom: '',
                email: '',
                telephone: '',
                centreInteret: '',
                site: '',
                contrat: '',
                extra: '',
                server: '',
                acceptedTerms: ''
            },
            validatePasswords() {
                return this.password === this.passwordConfirm && this.password !== '' && this.passwordConfirm !== ''
            },
            submitForm() {

                // Reset errors
                Object.keys(this.errors).forEach(key => this.errors[key] = '');

                if (!this.validatePasswords()) {
                    this.errors.passwordConfirm = 'Les mots de passe ne correspondent pas.';
                }

                if (!this.acceptedTerms) {
                    this.errors.acceptedTerms = 'Vous devez accepter les conditions générales d\'utilisation.';
                }

                const required = ['username', 'password', 'accountType'];

                if (this.accountType === 'ecole') {
                    required.push('raison');
                } else if (this.accountType === 'enseignant') {
                    required.push('name', 'prenom', 'email', 'telephone', 'centreInteret', 'site', 'contrat', 'extra');
                }

                required.forEach(field => {
                    if (this[field] === '') {
                        this.errors[field] = 'Ce champ est requis.';
                    }
                });

                if (Object.values(this.errors).some(error => error !== '')) {
                    return;
                }

                let formData = new FormData();
                formData.append('username', this.username);
                formData.append('password', this.password);
                formData.append('terms', this.acceptedTerms);
                formData.append('accountType', this.accountType);

                switch (this.accountType) {
                    case 'ecole' :
                        formData.append('raison', this.raison);
                        break;
                    case 'enseignant' :
                        formData.append('name', this.name);
                        formData.append('prenom', this.prenom);
                        formData.append('email', this.email);
                        formData.append('telephone', this.telephone);
                        formData.append('centreInteret', this.centreInteret);
                        formData.append('site', this.site);
                        formData.append('contrat', this.contrat);
                        formData.append('extra', this.extra);
                        break;
                    default:
                        break;
                }

                const queryString = new URLSearchParams(formData).toString();

                fetch('/api/register?' + queryString, {
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
                            this.error.server = response.message;
                        } else {
                            window.location.href = "/dashboard.jsp";
                        }
                    })
                    .catch(error => this.errors.server = error.message);
            }
        }
    }
</script>

</body>
</html>

