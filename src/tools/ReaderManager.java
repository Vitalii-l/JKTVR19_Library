/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import tools.savers.StorageManagerInterface;
import java.util.Scanner;
import entity.Reader;
import entity.facade.ReaderFacade;
import java.util.List;
import tools.savers.FileManager;

/**
 *
 * @author pupil
 */
public class ReaderManager {

    private ReaderFacade readerFacade = new ReaderFacade(Reader.class);
        
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
        readerFacade.create(reader);
        return reader;
    }

    public void addReaderToArray(Reader reader, List<Reader> listReaders, StorageManagerInterface storageManager) {
//        for (int j = 0; j < readers.size(); j++) {
//            if (readers(j) == null) {
//                readers(j) = reader;
//                break;
//            }
//        }
        listReaders.add(reader);
        
    }

    public void printListReaders(List<Reader> readers) {
        List<Reader> listReaders = readerFacade.findAll();
        if (listReaders == null){
            System.out.println("Нет читателей");
            return;
        }
        for (Reader r : readers) {
            if(r != null){
                System.out.println(r.getId()+". "+r.toString());
            }
        }
    }
    
}
