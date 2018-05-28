package org.rp.sandboxmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoEntityManagerFactory {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRM");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
