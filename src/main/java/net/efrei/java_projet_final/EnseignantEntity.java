package net.efrei.java_projet_final;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "Enseignant", schema = "projet", catalog = "")
public class EnseignantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id", nullable = false)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 255)
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "telephone", nullable = false, length = 255)
    private String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "centreInterets", nullable = true, length = 255)
    private String centreInterets;

    public String getCentreInterets() {
        return centreInterets;
    }

    public void setCentreInterets(String centreInterets) {
        this.centreInterets = centreInterets;
    }

    @Basic
    @Column(name = "sites", nullable = true, length = 255)
    private String sites;

    public String getSites() {
        return sites;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }

    @Basic
    @Column(name = "typeContrat", nullable = false, length = 255)
    private String typeContrat;

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    @Basic
    @Column(name = "extra", nullable = true, length = 255)
    private String extra;

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Basic
    @Column(name = "idUtilisateur", nullable = false)
    private int idUtilisateur;

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnseignantEntity that = (EnseignantEntity) o;

        if (id != that.id) return false;
        if (idUtilisateur != that.idUtilisateur) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (centreInterets != null ? !centreInterets.equals(that.centreInterets) : that.centreInterets != null)
            return false;
        if (sites != null ? !sites.equals(that.sites) : that.sites != null) return false;
        if (typeContrat != null ? !typeContrat.equals(that.typeContrat) : that.typeContrat != null) return false;
        if (extra != null ? !extra.equals(that.extra) : that.extra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (centreInterets != null ? centreInterets.hashCode() : 0);
        result = 31 * result + (sites != null ? sites.hashCode() : 0);
        result = 31 * result + (typeContrat != null ? typeContrat.hashCode() : 0);
        result = 31 * result + (extra != null ? extra.hashCode() : 0);
        result = 31 * result + idUtilisateur;
        return result;
    }
}
