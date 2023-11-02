package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Enseignant", schema = "projet")
@NamedQueries({
        @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
        @NamedQuery(name = "Enseignant.findByNom", query = "SELECT e FROM Enseignant e WHERE e.nom = :nom"),
        @NamedQuery(name = "Enseignant.findByPrenom", query = "SELECT e FROM Enseignant e WHERE e.prenom = :prenom"),
        @NamedQuery(name = "Enseignant.findByMail", query = "SELECT e FROM Enseignant e WHERE e.mail = :mail"),
        @NamedQuery(name = "Enseignant.findByTelephone", query = "SELECT e FROM Enseignant e WHERE e.telephone = :telephone"),
        @NamedQuery(name = "Enseignant.findByCentreInterets", query = "SELECT e FROM Enseignant e WHERE e.centreInterets = :centreInterets"),
        @NamedQuery(name = "Enseignant.findBySites", query = "SELECT e FROM Enseignant e WHERE e.sites = :sites"),
        @NamedQuery(name = "Enseignant.findByTypeContrat", query = "SELECT e FROM Enseignant e WHERE e.typeContrat = :typeContrat"),
        @NamedQuery(name = "Enseignant.findByExtra", query = "SELECT e FROM Enseignant e WHERE e.extra = :extra"),
        @NamedQuery(name = "Enseignant.findByUsername", query = "SELECT e FROM Enseignant e WHERE e.idUtilisateur.username = :username"),
        @NamedQuery(name = "Enseignant.findByUsernameAndStatus", query = "SELECT e FROM Enseignant e WHERE e.idUtilisateur.username = :username AND e.idUtilisateur.isAdmin = :isAdmin AND e.idUtilisateur.isValid = :isValid")
})
public class Enseignant {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "centreInterets")
    private String centreInterets;

    @Column(name = "sites")
    private String sites;

    @Column(name = "typeContrat", nullable = false)
    private String typeContrat;

    @Column(name = "extra")
    private String extra;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUtilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCentreInterets() {
        return centreInterets;
    }

    public void setCentreInterets(String centreInterets) {
        this.centreInterets = centreInterets;
    }

    public String getSites() {
        return sites;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

}