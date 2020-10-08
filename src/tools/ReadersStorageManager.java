/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pupil
 */
public class ReadersStorageManager {

    public void saveReadersToFile(Reader[] readers) {
        String fileName = "readers.txt";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Input/output error occured");
        }
    }
    
    public Reader[] loadReadersFromFile(){
        //Reader[] readers = new Reader[10]; //Как вариант инициализирования массива на случай, если файл не существует
        Reader[] readers = null;
        String fileName = "readers.txt";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            return (Reader[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Input/output error occured");
        } catch (ClassNotFoundException ex) {
            System.out.println("The class does not exist");
        }
        return readers;
    }
    
    

}