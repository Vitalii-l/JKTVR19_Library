/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import java.util.Scanner;
import entity.Reader;

/**
 *
 * @author pupil
 */
public class ReaderManager {

    public Reader addReader() {
        Reader reader = new Reader();
        System.out.println("--- Readrer registration ---");
        System.out.println("Input name: ");
        Scanner scanner = new Scanner(System.in);
        reader.setFirstName(scanner.nextLine());
        System.out.println("Input last name: ");
        reader.setLastName (scanner.nextLine());
        System.out.println("Input phone: ");
        reader.setPhone(scanner.nextLine());
        
        return reader;
    }
    
}
