/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Reader;
import entity.User;
import java.util.Scanner;

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
        System.out.println("Input role: ");
        user.setRole(scanner.nextLine());
        user.setReader(reader);
        return user;
    }
    
    public void addUserToArray(User user, User[] users){
        for (int j = 0; j < users.length; j++) {
            if (users[j] == null) {
                users[j] = user;
                break;
            }
        }
    }
    
    public void printListUsers(User[] users) {
        int y = 0;
        for (User r : users) {
            if(r != null){
                System.out.println(y+1+". "+r.toString());
                y++;
            }
        }
    }

    public User getCheckInUser(User[] users) {
        System.out.println("Logging in...");
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (int i = 0; i < users.length; i++){
            if (users[i] != null && users[i].getLogin().equals(login)){
                for (int j = 0; j < 2; j++) {
                    if (users[i].getPassword().equals(password)) {
                        System.out.println("Login successful.");
                        return users[i];
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
