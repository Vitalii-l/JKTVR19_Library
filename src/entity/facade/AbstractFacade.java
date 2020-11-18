/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.facade;

import entity.Book;
import entity.History;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Luchinskii
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    
    
    protected abstract EntityManager getEntityManager();
    
    public void create(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }
    public List<T> findAll() {
        try {
            return getEntityManager().createQuery("SELECT b FROM "+entityClass.getName()+" b").getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public T find(Long id) {
        try {
            return (T) getEntityManager().createQuery("SELECT b FROM "+entityClass.getName()+" b WHERE b.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void edit(T entity){
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }
}
