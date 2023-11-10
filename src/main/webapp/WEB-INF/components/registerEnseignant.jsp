<%--Formulaire Enseignant--%>
<div>
        <div class="form-group">
            <label for="name">Nom <span style="color: red">*</span></label>
            <input type="text" id="name" x-model="name">
            <span x-show="errors.acceptedTerms" style="color: red; font-size: small"
                  x-text="errors.acceptedTerms"></span>
        </div>

        <div class="form-group">
            <label for="prenom">Prenom <span style="color: red">*</span></label>
            <input type="text" id="prenom" x-model="prenom">
            <span x-show="errors.acceptedTerms" style="color: red; font-size: small"
                  x-text="errors.acceptedTerms"></span>
        </div>

        <div class="form-group">
            <label for="email">Email <span style="color: red">*</span></label>
            <input type="email" id="email" x-model="email" placeholder="Adresse Email">
            <span x-show="errors.acceptedTerms" style="color: red; font-size: small"
                  x-text="errors.acceptedTerms"></span>
        </div>

        <div class="form-group">
            <label for="telephone">Telephone <span style="color: red">*</span></label>
            <input type="text" id="telephone" x-model="telephone">
            <span x-show="errors.acceptedTerms" style="color: red; font-size: small"
                  x-text="errors.acceptedTerms"></span>
        </div>

        <div class="form-group">
            <label for="centreInteret">Centre d'Interet :</label><br>
            <textarea id="centreInteret" x-model="centreInteret" rows="10" cols="50"></textarea><br>
        </div>

        <div class="form-group">
            <label for="site">Site(s) web</label>
            <input type="text" id="site" x-model="site">
            <span x-show="errors.acceptedTerms" style="color: red; font-size: small"
                  x-text="errors.acceptedTerms"></span>
        </div>

        <div class="form-group">
            <label for="contrat">Type de contrat <span style="color: red">*</span></label>
            <input type="text" id="contrat" x-model="contrat">
            <span x-show="errors.acceptedTerms" style="color: red; font-size: small"
                  x-text="errors.acceptedTerms"></span>
        </div>

        <div class="form-group">
            <label for="extra">Information supplementaire :</label><br>
            <textarea id="extra" x-model="extra" rows="10" cols="50"></textarea><br>
        </div>
    </div>
