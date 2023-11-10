package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.security.Group;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
public class UtilisateurBean extends AbstractBean<Utilisateur> {

    public Utilisateur findById(Object id) {
        return em.find(Utilisateur.class, id);
    }

    public List<Utilisateur> findAll() {
        return em.createNamedQuery("Utilisateur.findAll", Utilisateur.class).getResultList();
    }

    public Utilisateur findByUsername(String username) {
        return em.createNamedQuery("Utilisateur.findByUsername", Utilisateur.class)
                .setParameter("username", username)
                .getResultStream().findFirst().orElse(null);
    }

    public List<Utilisateur> findByIsAdmin(Boolean isAdmin) {
        return em.createNamedQuery("Utilisateur.findByIsAdmin", Utilisateur.class)
                .setParameter("isAdmin", isAdmin)
                .getResultList();
    }

    public List<Utilisateur> findByIsValid(Boolean isValid) {
        return em.createNamedQuery("Utilisateur.findByIsValid", Utilisateur.class)
                .setParameter("isValid", isValid)
                .getResultList();
    }

    public List<Utilisateur> findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        return em.createNamedQuery("Utilisateur.findByUsernameAndStatus", Utilisateur.class)
                .setParameter("username", username)
                .setParameter("isAdmin", isAdmin)
                .setParameter("isValid", isValid)
                .getResultList();
    }

    public Set<Group> computeGroups(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return Set.of(Group.GUEST);
        }

        Set<Group> groups = new HashSet<>();

        groups.add(Group.USER);

        if (utilisateur.getIsValid()) {
            groups.add(Group.VALID_USER);
        }

        if (utilisateur.getIsAdmin()) {
            groups.add(Group.ADMIN);
        }

        if (utilisateur.getEcole() != null) {
            groups.add(Group.ECOLE);
        }

        if (utilisateur.getEnseignant() != null) {
            groups.add(Group.ENSEIGNANT);
        }

        return groups;
    }
}
