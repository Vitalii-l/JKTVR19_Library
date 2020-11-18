package ui;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import entity.facade.BookFacade;
import entity.facade.UserFacade;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import library.App;
import tools.BookManager;
import tools.ReaderManager;
import tools.savers.FileManager;
import tools.savers.StorageManagerInterface;
import tools.UserCardManager;
import tools.UserManager;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    //private FileManager sm = new FileManager();
    //private UserManager userManager = new UserManager();
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    private UserCardManager userCardManager = new UserCardManager();
    
    
    
    public void printReaderUI() {
        boolean repeat = true;
        do {
            System.out.println("\n1. List of books");
            System.out.println("2. Check out a book");
            System.out.println("3. Check in a book");
            System.out.println("4. List of book at home");
            System.out.println("0. Exit");
            System.out.println("");
            String task = scanner.nextLine();
            switch (task){
                case "0":
                    System.out.println("--- The End ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- 1. List of books ---");
                    bookManager.printListBooks(listBooks);
                    break;
                case "2":
                    System.out.println("--- 2. Check out a book ---");
                    History history = userCardManager.checkOutBook(listBooks, listReaders);
                    userCardManager.addHistoryToArray(history, listStories);
                    sm.save(listStories, App.storageFiles.HISTORIES.toString());
                    break;
                case "3":
                    System.out.println("--- 3. Check in a book ---");
                    userCardManager.checkInBook (listStories);
                    System.out.println("Выберите номер возвращаемой книги:");
                    int historyNumber = scanner.nextInt();
                    History history1 = listStories.get(historyNumber-1);
                    history1.setReturnDate(new GregorianCalendar().getTime());
                    sm.save(listStories, App.storageFiles.HISTORIES.toString());
                    break;
                case "4":
                    System.out.println("--- 4. List of checked out books ---");
                    userCardManager.printListReadBooks (listStories);
                    break;
            }
        } while (repeat);
    }
    
    public void printManagerUI(User[] users, Reader[] readers, Book[] books, History[] histories) {
        boolean repeat = true; 
        do {
            System.out.println("\n1. List of books");
            System.out.println("1. Add new book");
            System.out.println("2. Books list");
            System.out.println("6. Add new reader");
            System.out.println("7. Readers list");
            System.out.println("2. Check out a book");
            System.out.println("3. Check in a book");
            System.out.println("4. List of issued books (выданные книги)");
            System.out.println("0. Exit");
            System.out.println();
            String task = scanner.nextLine();
            switch (task){
                case "0":
                    System.out.println("--- The End ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- 1. Add new book ---");
                    Book book = bookManager.createBook();
                    bookManager.addBookToArray(book, books);
                    break;
                    userCardManager.printListReadBooks (listStories);
                    break;                
                case "2":
                    System.out.println("--- 2. List of books ---");
                    bookManager.printListBooks();
                    break;
                case "3":
                    System.out.println("--- 3. Add new reader ---");
                    UserManager userManager = new UserManager();
                    User user = userManager.createUser();
                    break;
                case "4":
                    System.out.println("--- 4. Readers list ---");
                    readerManager.printListReaders();
                case "5":
                    System.out.println("--- 5. Check out a book ---");
                    History history = userCardManager.checkOutBook(listBooks, listReaders);
                    userCardManager.addHistoryToArray(history, listStories);
                    sm.save(listStories, App.storageFiles.HISTORIES.toString());
                    break;
                case "6":
                    System.out.println("--- 6. Check in a book ---");
                    userCardManager.checkInBook (listStories);
                    System.out.println("Выберите номер возвращаемой книги:");
                    int historyNumber = scanner.nextInt();
                    History history1 = listStories.get(historyNumber-1);
                    history1.setReturnDate(new GregorianCalendar().getTime());
                    sm.save(listStories, App.storageFiles.HISTORIES.toString());
                    break;
                case "7":
                    System.out.println("--- 7. List of checked out books ---");
                default:
                    System.out.println("Task doesn't exist");
            }
        } while (repeat);
    }
}
