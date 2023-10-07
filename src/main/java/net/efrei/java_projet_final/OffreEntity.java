package net.efrei.java_projet_final;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "Offre", schema = "projet", catalog = "")
public class OffreEntity {
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
    @Column(name = "exigences", nullable = true, length = 255)
    private String exigences;

    public String getExigences() {
        return exigences;
    }

    public void setExigences(String exigences) {
        this.exigences = exigences;
    }

    @Basic
    @Column(name = "remarques", nullable = true, length = 255)
    private String remarques;

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    @Basic
    @Column(name = "idDispo", nullable = false)
    private int idDispo;

    public int getIdDispo() {
        return idDispo;
    }

    public void setIdDispo(int idDispo) {
        this.idDispo = idDispo;
    }

    @Basic
    @Column(name = "idEcole", nullable = false)
    private int idEcole;

    public int getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(int idEcole) {
        this.idEcole = idEcole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffreEntity that = (OffreEntity) o;

        if (id != that.id) return false;
        if (idDispo != that.idDispo) return false;
        if (idEcole != that.idEcole) return false;
        if (exigences != null ? !exigences.equals(that.exigences) : that.exigences != null) return false;
        if (remarques != null ? !remarques.equals(that.remarques) : that.remarques != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (exigences != null ? exigences.hashCode() : 0);
        result = 31 * result + (remarques != null ? remarques.hashCode() : 0);
        result = 31 * result + idDispo;
        result = 31 * result + idEcole;
        return result;
    }
}
