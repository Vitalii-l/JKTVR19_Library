/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class UserCardManager {

    public History giveBook(Book[] books, Reader[] readers) {
        History history = null;
        System.out.println("--- List of readers ---");
        int y = 0;
        for (Reader r : readers) {
            if(r != null){
                System.out.println(y+1+". "+r.toString());
                y++;
            }
        }
        System.out.println("--- Choose a reader ---");
        Scanner scanner = new Scanner(System.in);
        int readerNumber = scanner.nextInt();
        Reader reader = readers[readerNumber-1]; 
        int y2 = 0;
        for (Reader r : readers) {
            if(r != null){
                System.out.println(y2+1+". "+r.toString());
                y2++;
            }
        }
        System.out.println("Choose a book");
        int bookNumber = scanner.nextInt();
        Book book = books[bookNumber-1];
        Calendar calendar = new GregorianCalendar();
        history.setBook(book);
        history.setReader(reader);
        history.setTakeOnDate(calendar.getTime());
        
        
        return history;
    }
    
}
