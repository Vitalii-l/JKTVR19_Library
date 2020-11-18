/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import entity.User;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;
import security.SecureManager;
import tools.savers.BaseManager;
import tools.savers.StorageManagerInterface;
import ui.UserInterface;

/**
 *
 * @author Luchinskii
 */
public class App {
        
    public static enum storageFiles{BOOKS, READERS, USERS, HISTORIES};

    private StorageManagerInterface sm = new BaseManager();
    
    public static User loggedInUser;
        
    public void run() {
        try {
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
                userInterface.printManagerUI();
            } else if (SecureManager.role.READER.toString().toLowerCase().equals(App.loggedInUser.getRole().toLowerCase())) {
                // Reader interface
                System.out.println("User user logged in");
                userInterface.printReaderUI();
            }
        } finally {
            ConnectSingleton connect = ConnectSingleton.getInstance();
            EntityManager em = connect.getEntityManager();
            if(em !=null){
                em.close();
            }
            
        }
        
    }
}
