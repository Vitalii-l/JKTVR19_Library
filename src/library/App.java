/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import tools.SystemTools;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import security.SecureManager;
import tools.StorageManager;
import ui.UserInterface;


/**
 *
 * @author pupil
 */
public class App {
    
//    private Reader[] readers = new Reader[10];
//    private Book[] books = new Book[10];
//    private History[] stories = new History[10];
//    private User[] users = new User[10];
    
    public static enum storageFiles{BOOKS, READERS, USERS, HISTORIES};
    
    private List<Reader> listReaders = new ArrayList<>();
    private List<Book> listBooks = new ArrayList<>();
    private List<History> listHistories = new ArrayList<>();
    private List<User> listUsers = new ArrayList<>();
    
    private StorageManager sm = new StorageManager();
    
    private SystemTools clearCon = new SystemTools();
    public static User loggedInUser;
    
    public App() {
       
       List<Reader> loadReaders = sm.loadFromFile(App.storageFiles.READERS.toString());
       if (loadReaders !=null){
           listReaders = loadReaders;
       }
       
       List<Book> loadBooks = sm.loadFromFile(App.storageFiles.BOOKS.toString());
       if (loadBooks !=null){
           listBooks = loadBooks;
       }

       List<History> loadStories = sm.loadFromFile(App.storageFiles.HISTORIES.toString());
       if (loadStories != null){
           listHistories = loadStories;
       }
       
       List<User> loaderUsers = sm.loadFromFile(App.storageFiles.USERS.toString());
       if (loaderUsers != null){
           listUsers = loaderUsers;
       }
    }
        
    public void run() {
        System.out.println("--- Library");
        System.out.println("Menu:");
        SecureManager secureManager = new SecureManager();
        this.loggedInUser = secureManager.checkInLogin(listUsers,listReaders);
        UserInterface userInterface = new UserInterface();
        
        if (SecureManager.role.MANAGER.toString().toLowerCase().equals(App.loggedInUser.getRole().toLowerCase())) {
            // Manager interface
            System.out.println("Admin user logged in");
            userInterface.printManagerUI(listUsers, listReaders, listBooks, listHistories);
        } else if (SecureManager.role.READER.toString().toLowerCase().equals(App.loggedInUser.getRole().toLowerCase())) {
            // Reader interface
            System.out.println("User user logged in");
            userInterface.printReaderUI(listUsers, listReaders, listBooks, listHistories);
        }
    }
}
