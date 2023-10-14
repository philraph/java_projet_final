package net.efrei.java_projet_final;

import net.efrei.java_projet_final.beans.UtilisateurBean;
import net.efrei.java_projet_final.entities.UtilisateurEntity;

public class test {
    public static void main(String[] args) {

        var utilisateur = new UtilisateurEntity();
        utilisateur.setUsername("admin");
        utilisateur.setPassword("admin");
        utilisateur.setIsAdmin(true);
        utilisateur.setIsValid(true);

        new UtilisateurBean().create(utilisateur);
    }
}
