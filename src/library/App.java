/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import tools.SystemTools;
import tools.HistoryStorageManager;

import tools.BooksStorageManager;
import tools.ReadersStorageManager;
import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import security.SecureManager;
import tools.UserStorageManager;
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
    
    private List<Reader> listReaders = new ArrayList<>();
    private List<Book> listBooks = new ArrayList<>();
    private List<History> listHistories = new ArrayList<>();
    private List<User> listUsers = new ArrayList<>();
    
    private ReadersStorageManager rsm = new ReadersStorageManager();
    private BooksStorageManager bsm = new BooksStorageManager();
    private HistoryStorageManager hsm = new HistoryStorageManager();
    private UserStorageManager userStorageManager = new UserStorageManager();
    private SystemTools clearCon = new SystemTools();
    public static User loggedInUser;
    
    public App() {
       
       List<Reader> loadReaders = rsm.loadReadersFromFile();
       if (loadReaders !=null){
           listReaders = loadReaders;
       }
       
       List<Book> loadBooks = bsm.loadBooksFromFile();
       if (loadBooks !=null){
           listBooks = loadBooks;
       }
       
//       History[] loadHistory = hsm.loadHistoryFromFile();
//       if (loadHistory != null){
//           stories = loadHistory;
//       }
       
       List<History> loadStories = hsm.loadHistoryFromFile();
       if (loadStories != null){
           listHistories = loadStories;
       }
       
       List<User> loaderUsers = userStorageManager.loadUsersFromFile();
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
        
        if ("MANAGER".toLowerCase().equals(App.loggedInUser.getRole().toLowerCase())) {
            // Manager interface
            userInterface.printManagerUI(users, readers, books, stories);
        } else if ("READER".toLowerCase().equals(App.loggedInUser.getRole().toLowerCase())) {
            // Reader interface
            userInterface.printReaderUI(users, readers, books, stories);
        }
    }
}
