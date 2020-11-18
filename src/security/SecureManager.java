package security;

import entity.Reader;
import entity.User;
import entity.facade.UserFacade;
import java.util.List;
import java.util.Scanner;
import library.App;
import tools.ReaderManager;
import tools.savers.FileManager;
import tools.savers.StorageManagerInterface;
import tools.UserManager;

public class SecureManager {
    private UserManager userManager = new UserManager();
    private ReaderManager readerManager = new ReaderManager();
    private Scanner scanner = new Scanner(System.in);
//    private FileManager sm = new FileManager();
   
    
    public static enum role{READER,MANAGER}
    
    public User checkInLogin(StorageManagerInterface sm) {
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
                    System.out.println("1. Register new user");
                    User user = userManager.createUser();
                    UserFacade userFacade = new UserFacade(User.class);
                    userFacade.create(user);
                    break;
                case "2":
                    User checkInUser = userManager.getCheckInUser();
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
