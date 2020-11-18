package ui;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import entity.controllers.BookController;
import entity.controllers.UserController;
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
    private UserCardManager userCardManager = new UserCardManager();
    private BookManager bookManager = new BookManager();
    private UserManager userManager = new UserManager();
    private ReaderManager readerManager = new ReaderManager();
    
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
    
    public void printManagerUI(){
        boolean repeat = true;
        do {
            System.out.println("\n1. List of books");
            System.out.println("2. Check out a book");
            System.out.println("3. Check in a book");
            System.out.println("4. List of book at home");
            System.out.println("5. Add new book");
            System.out.println("6. Add new reader");
            System.out.println("7. List reader");
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
                    bookManager.printListBooks();
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
                case "5":
                    System.out.println("--- 5. Add new book ---");
                    Book book = bookManager.createBook();
                    BookController bc = new BookController();
                    bc.create(book);
                    break;
                case "6":
                    System.out.println("--- 5. Add new reader ---");
                    UserManager userManager = new UserManager();
                    User user = userManager.createUser();
                    UserController uc = new UserController();
                    uc.create(user);
                    break;
                case "7":
                    System.out.println("7. Readers list");
                    readerManager.printListReaders();
            }
        } while (repeat);
    }
}
