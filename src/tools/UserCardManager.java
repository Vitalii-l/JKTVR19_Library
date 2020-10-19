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
import library.App;
 /*
 * @author pupil
 */
public class UserCardManager {
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    Scanner scanner = new Scanner(System.in);

    public History checkOutBook(Book[] books, Reader[] readers) {
        System.out.println("--- List of books ---");
        int bookNumber = 0;
        do {
            bookManager.printListBooks(books);
            System.out.println("--- Choose a book ---");
            String bookNumberStr = scanner.nextLine();
            try {
                bookNumber = Integer.parseInt(bookNumberStr);
                if(bookNumber < 1 && bookNumber <= books.length){
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Choose number from the list");
            }
        } while (true);
        
        Book book = books[bookNumber-1];
        Reader reader = null;
        System.out.println("--- List of readers ---");
        if ("MANAGER".equals(App.loggedInUser.getRole())) {
            int readerNumber = 0;
            do {
                readerManager.printListReaders(readers);
                System.out.println("--- Choose a reader ---");
                String readerNumberStr = scanner.nextLine();
                try {
                    readerNumber = Integer.parseInt(readerNumberStr);
                    if (readerNumber < 1 && readerNumber <= readers.length){
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Input number between 1 and "+readers.length);
                }
            } while (true);
            Scanner scanner = new Scanner(System.in);
            readerNumber = scanner.nextInt();
            reader = readers[readerNumber-1];
        } else if ("READER".equals(App.loggedInUser.getRole())) {
            reader = App.loggedInUser.getReader();
        }

        Calendar calendar = new GregorianCalendar();
// v1       history.setBook(book);
//        history.setReader(reader);
//        history.setTakeOnDate(calendar.getTime());
// v2        History history = new History(book, reader, calendar.getTime(), null);
        
        return new History(book, reader, calendar.getTime(), null); // v3
    }

    public void addHistoryToArray(History history, History[] stories) {
        for (int j = 0; j < stories.length; j++) {
            if (stories[j] == null) {
                stories[j] = history;
                break;
            }
        }
    }

    public void printListReadBooks(History[] stories) {
        int y = 0;
        for (History h : stories) {
            if(h != null){
                System.out.println(y+1+". "+h.toString());
                y++;}
        }
    }

    public void checkInBook(History[] stories) {
        int n = 0;
        for (History h: stories) {
            if (h != null && h.getReturnDate() == null){
                System.out.printf("%d Книгу %s читает %s %s%n"
                    ,n+1
                    ,h.getBook().getName()
                    ,h.getReader().getFirstName()
                    ,h.getReader().getLastName()
                );
                n++;
            }
        }
    }
    
}
