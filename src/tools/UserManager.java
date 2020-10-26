/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Reader;
import entity.User;
import java.util.List;
import java.util.Scanner;
import security.SecureManager;

/**
 *
 * @author pupil
 */
public class UserManager {
    Scanner scanner = new Scanner(System.in);
    
    public User createUser(){
        ReaderManager readerManager = new ReaderManager();
        Reader reader = readerManager.createReader();
        User user = new User();
        System.out.println("--- Adding new user ---");
        System.out.println("Input login: ");
        user.setLogin(scanner.nextLine());
        System.out.println("Input password: ");
        user.setPassword(scanner.nextLine());
        int numRole;
        do {
            System.out.println("Roles list:");
            for (int i = 0; i < SecureManager.role.values().length; i++) {
                System.out.printf("%d. %s%n"
                    , i+1
                    , SecureManager.role.values()[i].toString());
            }
            System.out.println("Input role number: ");
            String strNumRole = scanner.nextLine();
            try {
                numRole = Integer.parseInt(strNumRole);
                break;
            } catch (Exception e) {
                System.out.println("Input role number as a numeric value");
            }
        } while (true);
        
        user.setRole(SecureManager.role.values()[numRole-1].toString());
        user.setReader(reader);
        return user;
    }
    
    public void addUserToArray(User user, List<User> listUsers){
        listUsers.add(user);
    }
    
    public void printListUsers(List<User> listUsers) {
        int y = 0;
        for (User r : listUsers) {
            if(r != null){
                System.out.println(y+1+". "+r.toString());
                y++;
            }
        }
    }

    public User getCheckInUser(List<User> users) {
        System.out.println("Logging in...");
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (int i = 0; i < users.size(); i++){
            if (users.get(i) != null && users.get(i).getLogin().equals(login)){
                for (int j = 0; j < 2; j++) {
                    if (users.get(i).getPassword().equals(password)) {
                        System.out.println("Login successful.");
                        return users.get(i);
                    } else {
                        System.out.println("Wrong password. You still have "+(2-j)+" attempt.");
                        password = scanner.nextLine();
                    }
                }
                System.out.println("Get out of here!");
                return null;
            }
        }
        System.out.println("Login not found");
        return null;
    }
}
