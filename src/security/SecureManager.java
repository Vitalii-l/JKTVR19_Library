/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.Reader;
import entity.User;
import java.util.Scanner;
import tools.ReaderManager;
import tools.ReadersStorageManager;
import tools.UserStorageManager;
import tools.UserManager;

/**
 *
 * @author pupil
 */
public class SecureManager {
    private UserManager userManager = new UserManager();
    private ReaderManager readerManager = new ReaderManager();
    private UserStorageManager userStorageManager = new UserStorageManager();
    private ReadersStorageManager readerStorageManager = new ReadersStorageManager();
    private Scanner scanner = new Scanner(System.in);
    
    public User checkInLogin(User[] users, Reader[] readers) {
        do {
            System.out.println("Choose what to do:");
            System.out.println("0. Exit program");
            System.out.println("1. Register new user");
            System.out.println("2. Log in");
            System.out.println("Enter task number:");
            String task = scanner.nextLine();

            switch (task) {
                case "0":
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;
                case "1":
                    User user = userManager.createUser();
                    userManager.addUserToArray(user, users);
                    readerManager.addReaderToArray(user.getReader(), readers);
                    readerStorageManager.saveReadersToFile(readers);
                    userStorageManager.saveUsersToFile(users);
                    break;
                case "2":
                    User checkInUser = userManager.getCheckInUser(users);
                    if (checkInUser == null) break;
                    return checkInUser;
                default:
                    System.out.println("Task with this number not found");
            }
        } while (true);
    }
    
}
