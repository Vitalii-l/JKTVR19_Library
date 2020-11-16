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
import tools.BaseManager;
import tools.FileManager;
import tools.StorageManagerInterface;
import ui.UserInterface;


/**
 *
 * @author pupil
 */
public class App {
        
    public static enum storageFiles{BOOKS, READERS, USERS, HISTORIES};
    
//    private List<Reader> listReaders = new ArrayList<>();
//    private List<Book> listBooks = new ArrayList<>();
//    private List<History> listHistories = new ArrayList<>();
//    private List<User> listUsers = new ArrayList<>();
    
    //private StorageManagerInterface sm = new FileManager();
    private StorageManagerInterface sm = new BaseManager();
    
    public static User loggedInUser;
    
    public App(String flag) {
       
//       List<Reader> loadReaders = sm.load(App.storageFiles.READERS.toString());
//       if (loadReaders !=null){
//           listReaders = loadReaders;
//       }
//       
//       List<Book> loadBooks = sm.load(App.storageFiles.BOOKS.toString());
//       if (loadBooks !=null){
//           listBooks = loadBooks;
//       }
//
//       List<History> loadStories = sm.load(App.storageFiles.HISTORIES.toString());
//       if (loadStories != null){
//           listHistories = loadStories;
//       }
//       
//       List<User> loaderUsers = sm.load(App.storageFiles.USERS.toString());
//       if (loaderUsers != null){
//           listUsers = loaderUsers;
//       }
    }
        
    public void run() {
        System.out.println("--- Library");
        System.out.println("Menu:");
        SecureManager secureManager = new SecureManager();
        App.loggedInUser = secureManager.checkInLogin();
        UserInterface userInterface = new UserInterface();
        if (App.loggedInUser == null){
            System.out.println("Нет прав доступа");
            return;
        }
        
        if (SecureManager.role.MANAGER.toString().toLowerCase().equals(App.loggedInUser.getRole().toLowerCase())) {
            // Manager interface
            System.out.println("Admin user logged in");
            userInterface.printManagerUI(listUsers, listReaders, listBooks, listHistories,sm);
        } else if (SecureManager.role.READER.toString().toLowerCase().equals(App.loggedInUser.getRole().toLowerCase())) {
            // Reader interface
            System.out.println("User user logged in");
            userInterface.printReaderUI(listUsers, listReaders, listBooks, listHistories,sm);
        }
    }
}
