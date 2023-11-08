<%--Formulaire ecole--%>
<div x-show="accountType === 'ecole'">
    <div class="form-group">
        <label for="raison">Raison Social</label>
        <input type="text" id="raison" x-model="raison">
        <span x-show="errors.raison" style="color: red; font-size: small" x-text="errors.raison"></span>
    </div>
</div>
