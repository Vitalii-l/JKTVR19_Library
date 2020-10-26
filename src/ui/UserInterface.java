package ui;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import library.App;
import tools.BookManager;
import tools.ReaderManager;
import tools.StorageManager;
import tools.UserCardManager;
import tools.UserManager;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private StorageManager sm = new StorageManager();
    private UserCardManager userCardManager = new UserCardManager();
    private BookManager bookManager = new BookManager();
    private UserManager userManager = new UserManager();
    private ReaderManager readerManager = new ReaderManager();
    
    public void printReaderUI(List<User> listUsers, List<Reader> listReaders, List<Book> listBooks, List<History> listStories) {
        boolean repeat = true;
        do {
            System.out.println("\n1. List of my books");
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
                    sm.saveToFile(listStories, App.storageFiles.HISTORIES.toString());
                    break;
                case "3":
                    System.out.println("--- 3. Check in a book ---");
                    userCardManager.checkInBook (listStories);
                    System.out.println("Выберите номер возвращаемой книги:");
                    int historyNumber = scanner.nextInt();
                    History history1 = listStories.get(historyNumber-1);
                    history1.setReturnDate(new GregorianCalendar().getTime());
                    sm.saveToFile(listStories, App.storageFiles.HISTORIES.toString());
                    break;
                case "4":
                    System.out.println("--- 4. List of checked out books ---");
                    userCardManager.printListReadBooks (listStories);
                    break;
            } 
        } while (repeat);
    }
    
    public void printManagerUI(List<User> listUsers, List<Reader> listReaders, List<Book> listBooks, List<History> listStories){
        boolean repeat = true;
        do {
            System.out.println("\n1. List of books");
            System.out.println("2. Check out a book");
            System.out.println("3. Check in a book");
            System.out.println("4. List of book at home");
            System.out.println("5. Add new book");
            System.out.println("6. Add new reader");
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
                    sm.saveToFile(listStories, App.storageFiles.HISTORIES.toString());
                    break;
                case "3":
                    System.out.println("--- 3. Check in a book ---");
                    userCardManager.checkInBook (listStories);
                    System.out.println("Выберите номер возвращаемой книги:");
                    int historyNumber = scanner.nextInt();
                    History history1 = listStories.get(historyNumber-1);
                    history1.setReturnDate(new GregorianCalendar().getTime());
                    sm.saveToFile(listStories, App.storageFiles.HISTORIES.toString());
                    break;
                case "4":
                    System.out.println("--- 4. List of checked out books ---");
                    userCardManager.printListReadBooks (listStories);
                    break;
                case "5":
                    System.out.println("--- 5. Add new book ---");
                    Book book = bookManager.createBook();
                    bookManager.addBookToArray(book, listBooks);
                    break;
                case "6":
                    System.out.println("--- 5. Add new reader ---");
                    User user = userManager.createUser();
                    userManager.addUserToArray(user, listUsers);
                    readerManager.addReaderToArray(user.getReader(), listReaders);
                    sm.saveToFile(listReaders, App.storageFiles.READERS.toString());
                    sm.saveToFile(listUsers, App.storageFiles.USERS.toString());
                    break;
            }
        } while (repeat);
    }
}
