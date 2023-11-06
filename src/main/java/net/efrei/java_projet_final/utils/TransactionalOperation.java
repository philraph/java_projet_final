package net.efrei.java_projet_final.utils;

import jakarta.persistence.EntityManager;

public class TransactionalOperation {

    public static void execute(EntityManager em, Runnable operation) {
        em.getTransaction().begin();
        try {
            operation.run();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
