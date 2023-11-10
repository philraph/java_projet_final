<%--Formulaire ecole--%>
    <div>
        <div class="form-group">
            <label for="raison">Raison Social <span style="color: red">*</span></label>
            <input type="text" id="raison" x-model="raison">
            <span x-show="errors.raison" style="color: red; font-size: small" x-text="errors.raison"></span>
        </div>
    </div>
