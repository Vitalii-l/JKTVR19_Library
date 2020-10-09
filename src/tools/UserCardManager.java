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
//        History history = new History();
        
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
//        y = 0;
//        for (Reader r : readers) {
//            if(r != null){
//                System.out.println(y+1+". "+r.toString());
//                y++;
//            }
//        }
        System.out.println("--- Choose a book ---");
        y = 0;
        for (Book b : books) {
            if(b != null){
                System.out.println(y+1+". "+b.toString());
                y++;
            }
        }
        System.out.println("Choose a book");
        int bookNumber = scanner.nextInt();
        Book book = books[bookNumber-1];
             
        Calendar calendar = new GregorianCalendar();
// v1       history.setBook(book);
//        history.setReader(reader);
//        history.setTakeOnDate(calendar.getTime());
// v2        History history = new History(book, reader, calendar.getTime(), null);
        
        return new History(book, reader, calendar.getTime(), null); // v3
    }
    
}
