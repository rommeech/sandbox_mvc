package org.rp.sandboxmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DaoEntityManagerFactory {

    private static javax.persistence.EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRM");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
