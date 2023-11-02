package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.entities.Offre;

import java.util.List;

@Stateless
public class OffreBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();

    public void create(Offre offre) {
        em.persist(offre);
    }

    public void update(Offre offre) {
        em.merge(offre);
    }

    public void delete(Offre offre) {
        if (em.contains(offre)) {
            em.remove(offre);
        } else {
            em.remove(em.merge(offre));
        }
    }

    public List<Offre> findAll() {
        TypedQuery<Offre> query = em.createNamedQuery("Offre.findAll", Offre.class);
        return query.getResultList();
    }

    public List<Offre> findByExigences(String exigences) {
        TypedQuery<Offre> query = em.createNamedQuery("Offre.findByExigences", Offre.class);
        query.setParameter("exigences", exigences);
        return query.getResultList();
    }

    public List<Offre> findByRemarques(String remarques) {
        TypedQuery<Offre> query = em.createNamedQuery("Offre.findByRemarques", Offre.class);
        query.setParameter("remarques", remarques);
        return query.getResultList();
    }

    public List<Offre> findByEcole(Ecole ecole) {
        TypedQuery<Offre> query = em.createNamedQuery("Offre.findByEcole", Offre.class);
        query.setParameter("raisonsociale", ecole.getRaisonSociale());
        return query.getResultList();
    }

    public Offre findById(Integer id) {
        return em.find(Offre.class, id);
    }

}