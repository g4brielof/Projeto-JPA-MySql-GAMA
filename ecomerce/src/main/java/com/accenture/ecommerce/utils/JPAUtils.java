package com.accenture.ecommerce.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    public static EntityManager getEntity(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommercejpa");
        return entityManagerFactory.createEntityManager();
    }
}
