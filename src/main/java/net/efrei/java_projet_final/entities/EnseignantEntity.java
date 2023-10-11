package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = EnseignantEntity.TABLE_NAME)
public class EnseignantEntity implements Serializable {
    public static final String TABLE_NAME = "Enseignant";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name = "idUtilisateur", nullable = false, unique = true)
    private UtilisateurEntity utilisateur;

    public Integer getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getCentreInterets() {
        return centreInterets;
    }

    public String getExtra() {
        return extra;
    }

    public String getMail() {
        return mail;
    }

    public String getSites() {
        return sites;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setCentreInterets(String centreInterets) {
        this.centreInterets = centreInterets;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    @Override
    public String toString() {
        return "EnseignantEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", centreInterets='" + centreInterets + '\'' +
                ", sites='" + sites + '\'' +
                ", typeContrat='" + typeContrat + '\'' +
                ", extra='" + extra + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnseignantEntity)) return false;
        EnseignantEntity that = (EnseignantEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(mail, that.mail) && Objects.equals(telephone, that.telephone) && Objects.equals(centreInterets, that.centreInterets) && Objects.equals(sites, that.sites) && Objects.equals(typeContrat, that.typeContrat) && Objects.equals(extra, that.extra) && Objects.equals(utilisateur, that.utilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, mail, telephone, centreInterets, sites, typeContrat, extra, utilisateur);
    }
}
