package com.curso_java.manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Manager {
    private static EntityManager em = null; 

    public static EntityManager getEntityManager(){
        if (em == null){ 
            em = Persistence.createEntityManagerFactory("curso").createEntityManager();
        }
        return em; 
    }
}
