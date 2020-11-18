/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.facade;

import entity.Book;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luchinskii
 */
public class BookFacade extends AbstractFacade<Book>{

    public BookFacade() {
        super(Book.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        ConnectSingleton connect = ConnectSingleton.getInstance();
        return connect.getEntityManager();
    }
    
    

    
}
