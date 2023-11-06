package net.efrei.java_projet_final.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import net.efrei.java_projet_final.utils.TransactionalOperation;

public abstract class AbstractBean<T> {

    T entity;

    protected EntityManagerFactory emf;
    protected EntityManager em;

    @PostConstruct
    private void init() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    @PreDestroy
    private void destroy() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    public void create(T entity) {
        TransactionalOperation.execute(em, () -> em.persist(entity));
    }

    public void update(T entity) {
        TransactionalOperation.execute(em, () -> em.merge(entity));
    }

    public void delete(T entity) {
        TransactionalOperation.execute(em, () -> {
            if (em.contains(entity)) {
                em.remove(entity);
            } else {
                em.remove(em.merge(entity));
            }
        });
    }
}