/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class ConnectSingleton {

    private EntityManager em;
    private EntityManagerFactory emf;
    private static ConnectSingleton instance;
    
    public ConnectSingleton() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTVR19_LibraryPU");
        EntityManager em = emf.createEntityManager();
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
    
    public static ConnectSingleton getInstance(){
        if(instance == null){
            instance = new ConnectSingleton();
        }
        return instance;
    }
    
}
