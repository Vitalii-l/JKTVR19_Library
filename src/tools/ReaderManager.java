/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import java.util.Scanner;
import entity.Reader;
import java.util.List;

/**
 *
 * @author pupil
 */
public class ReaderManager {

    public Reader createReader() {
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

    public void addReaderToArray(Reader reader, List<Reader> listReaders) {
//        for (int j = 0; j < readers.size(); j++) {
//            if (readers(j) == null) {
//                readers(j) = reader;
//                break;
//            }
//        }
        listReaders.add(reader);
        
    }

    public void printListReaders(List<Reader> readers) {
        int y = 0;
        for (Reader r : readers) {
            if(r != null){
                System.out.println(y+1+". "+r.toString());
                y++;
            }
        }
    }
    
}
