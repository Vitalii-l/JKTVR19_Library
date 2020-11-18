/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.facade.BookFacade;
import entity.facade.HistoryFacade;
import entity.facade.ReaderFacade;
import factory.FacadeFactory;
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
    private BookFacade bookFacade = FacadeFactory.getBookFacade();
    private ReaderFacade readerFacade = FacadeFactory.getReaderFacade();
    private HistoryFacade historyFacade = FacadeFactory.getHistoryFacade();

    public History checkOutBook() {
        System.out.println("--- List of books ---");
        Long bookNumber;
        do {
            if (!bookManager.printListBooks()){
                return null;
            }
            bookManager.printListBooks();
            System.out.println("--- Choose a book ---");
            String bookNumberStr = scanner.nextLine();
            try {
                bookNumber = Long.parseLong(bookNumberStr);
                break;
            } catch (Exception e) {
                System.out.println("Choose number from the list");
            }
        } while (true);
        
        Book book = bookFacade.find(bookNumber);
        Reader reader = null;
        
        if (SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())) {
            Long readerNumber;
            do {
                System.out.println("--- List of readers ---");
                readerManager.printListReaders();
                System.out.println("--- Choose a reader ---");
                String readerNumberStr = scanner.nextLine();
                try {
                    readerNumber = Long.parseLong(readerNumberStr);
                    break;
                } catch (Exception e) {
                    System.out.println("Input number");
                }
            } while (true);
            reader = readerFacade.
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
