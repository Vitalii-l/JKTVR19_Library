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
import java.util.List;
import java.util.Scanner;
import library.App;
import security.SecureManager;
 /*
 * @author pupil
 */
public class UserCardManager {
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    Scanner scanner = new Scanner(System.in);

    public History checkOutBook(List<Book> listBooks, List<Reader> listReaders) {
        System.out.println("--- List of books ---");
        int bookNumber = 0;
        do {
            bookManager.printListBooks(listBooks);
            System.out.println("--- Choose a book ---");
            String bookNumberStr = scanner.nextLine();
            try {
                bookNumber = Integer.parseInt(bookNumberStr);
                if(bookNumber < 1 && bookNumber <= listBooks.size()){
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Choose number from the list");
            }
        } while (true);
        
        Book book = listBooks.get(bookNumber-1);
        Reader reader = null;
        if (SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())) {
            int readerNumber = 0;
            do {
                System.out.println("--- List of readers ---");
                readerManager.printListReaders(listReaders);
                System.out.println("--- Choose a reader ---");
                String readerNumberStr = scanner.nextLine();
                try {
                    readerNumber = Integer.parseInt(readerNumberStr);
                    if (readerNumber < 1 && readerNumber <= listReaders.size()){
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Input number between 1 and "+listReaders.size());
                }
            } while (true);
            reader = listReaders.get(readerNumber-1);
        } else if (SecureManager.role.READER.toString().equals(App.loggedInUser.getRole())) {
            reader = App.loggedInUser.getReader();
        }

        Calendar calendar = new GregorianCalendar();
// v1       history.setBook(book);
//        history.setReader(reader);
//        history.setTakeOnDate(calendar.getTime());
// v2        History history = new History(book, reader, calendar.getTime(), null);
        
        return new History(book, reader, calendar.getTime(), null); // v3
    }

    public void addHistoryToArray(History history, List<History> listStories) {
        listStories.add(history);
    }

    public void printListReadBooks(List<History> listStories) {
        int y = 0;
        for (History h : listStories) {
            if(h != null){
                System.out.println(y+1+". "+h.toString());
                y++;}
        }
    }

    public void checkInBook(List<History> listStories) {
        int n = 0;
            for (History h: listStories) {
                if (h != null && h.getReturnDate() == null){
                    try {
                        if (h.getReader() == null){
                            throw new Exception();}
                        System.out.println("Reader: "+h.getReader());
                        System.out.printf("%d Книгу %s читает %s %s%n"
                            ,n+1
                            ,h.getBook().getName()
                            ,h.getReader().getFirstName()
                            ,h.getReader().getLastName()
                        );
                    } catch (Exception e) {
                    }
                    n++;
                }
            }
    }
    
}
