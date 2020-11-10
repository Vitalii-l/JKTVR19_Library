/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import library.App;

/**
 *
 * @author pupil
 */
public class BaseManager implements StorageManagerInterface{
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTVR19_LibraryPU");
        private EntityManager em = emf.createEntityManager();
        private EntityTransaction tx = em.getTransaction();
    
    @Override
    public void save(List arrayList, String fileName) {
        tx.begin();
        for (int i = 0; i < arrayList.size(); i++) {
            if(Book.class.equals(arrayList.get(i).getClass())){ // Проверяем, если в i-м элементе лежит объект класса Book
                List<Book> listBook = (List<Book>) arrayList; // То делаем типизацию (List<Book>)
                if (listBook.get(i).getId() == null){
                    em.persist(listBook.get(i));
                }
            }
            if(Reader.class.equals(arrayList.get(i).getClass())){ // Проверяем, если в i-м элементе лежит объект класса Book
                List<Reader> listReader = (List<Reader>) arrayList; // То делаем типизацию (List<Book>)
                if (listReader.get(i).getId() == null){
                    em.persist(listReader.get(i));
                }    
            }
            if(User.class.equals(arrayList.get(i).getClass())){ // Проверяем, если в i-м элементе лежит объект класса Book
                List<User> listUsers = (List<User>) arrayList; // То делаем типизацию (List<User>)
                if (listUsers.get(i).getId() == null){
                    em.persist(listUsers.get(i));
                }    
            }
            if(History.class.equals(arrayList.get(i).getClass())){ // Проверяем, если в i-м элементе лежит объект класса Book
                List<History> listHistory = (List<History>) arrayList; // То делаем типизацию (List<Book>)
                if (listHistory.get(i).getId() == null){
                    em.persist(listHistory.get(i));
                } else {
                    em.merge(listHistory.get(i));
                }
            }
            
            
        }
        tx.commit();
    }
    
    public void save (List arrayList){
        this.save(arrayList,null);
    }
    
    @Override
    public List load(String fileName) {
        if(App.storageFiles.BOOKS.toString().equals(fileName)){
            List<Book> listBooks = em.createQuery("SELECT b FROM Book b")
                    .getResultList();
            return listBooks;
        }
        if(App.storageFiles.READERS.toString().equals(fileName)){
            List<Reader> listReaders = em.createQuery("SELECT b FROM Book b")
                    .getResultList();
            return listReaders;
        }
        if(App.storageFiles.USERS.toString().equals(fileName)){
            List<User> listUsers = em.createQuery("SELECT b FROM Book b")
                    .getResultList();
            return listUsers;
        }
        if(App.storageFiles.HISTORIES.toString().equals(fileName)){
            List<History> listHistories = em.createQuery("SELECT b FROM Book b")
                    .getResultList();
            return listHistories;
        }
        return new ArrayList();
    }
    
    

    
}
