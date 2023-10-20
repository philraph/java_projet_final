<%--Formulaire Enseignant--%>
<div x-show="accountType === 'enseignant'">
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
</div>
