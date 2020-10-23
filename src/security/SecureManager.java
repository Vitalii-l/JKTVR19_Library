package security;

import entity.Reader;
import entity.User;
import java.util.List;
import java.util.Scanner;
import tools.ReaderManager;
import tools.ReadersStorageManager;
import tools.UserStorageManager;
import tools.UserManager;

public class SecureManager {
    private UserManager userManager = new UserManager();
    private ReaderManager readerManager = new ReaderManager();
    private UserStorageManager userStorageManager = new UserStorageManager();
    private ReadersStorageManager readerStorageManager = new ReadersStorageManager();
    private Scanner scanner = new Scanner(System.in);
    
    public static enum role{READER,MANAGER}
    
    public User checkInLogin(List<User> listUsers, List<Reader> listReaders) {
        do {
            System.out.println("Choose what to do:");
            System.out.println("0. Exit program");
            System.out.println("1. Register new user");
            System.out.println("2. Log in");
            System.out.println("3. List users");
            System.out.println("Enter task number:");
            String task = scanner.nextLine();

            switch (task) {
                case "0":
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;
                case "1":
                    User user = userManager.createUser();
                    userManager.addUserToArray(user, listUsers);
                    readerManager.addReaderToArray(user.getReader(), listReaders);
                    readerStorageManager.saveReadersToFile(listReaders);
                    userStorageManager.saveUsersToFile(listUsers);
                    break;
                case "2":
                    User checkInUser = userManager.getCheckInUser(listUsers);
                    if (checkInUser == null) break;
                    return checkInUser;
                case "3":
                    userManager.printListUsers(listUsers);
                    break;
                default:
                    System.out.println("Task with this number not found");
            }
        } while (true);
    }
    
}
