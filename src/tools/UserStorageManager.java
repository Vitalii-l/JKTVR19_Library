/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import entity.Book;
import entity.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author pupil
 */
public class UserStorageManager {
    String fileName = "users.txt";

    public void saveUsersToFile(User[] users) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Input/output error occured");
        }
    }


    public User[] loadUsersFromFile() {
        User[] users = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            return (User[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Input/output error occured");
        } catch (ClassNotFoundException ex) {
            System.out.println("The class does not exist");
        }
        return users;
    }
    
}
