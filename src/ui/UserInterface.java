package ui;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.BookManager;
import tools.HistoryStorageManager;
import tools.UserCardManager;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private BookManager bookManager = new BookManager();
    private UserCardManager userCardManager = new UserCardManager();
    private HistoryStorageManager historyStorageManager = new HistoryStorageManager();
    
    public void printReaderUI(User[] users, Reader[] readers, Book[] books, History[] stories) {
        boolean repeat = true;
        do {
            //clearCon.clearConsole();
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
                    bookManager.printListBooks(books);
                    break;
                
                case "4":
                    System.out.println("--- 4. List of checked out books ---");
                    userCardManager.printListReadBooks (stories);
                    break;
                case "2":
                    System.out.println("--- 2. Check out a book ---");
                    History history = userCardManager.checkOutBook(books, readers);
                    userCardManager.addHistoryToArray(history, stories);
                    historyStorageManager.saveHistoryToFile(stories);
                    break;
                case "3":
                    System.out.println("--- 3. Check in a book ---");
                    userCardManager.checkInBook (stories);
                    System.out.println("Выберите номер возвращаемой книги:");
                    int historyNumber = scanner.nextInt();
                    History history1 = stories[historyNumber - 1];
                    history1.setReturnDate(new GregorianCalendar().getTime());
                    
                    historyStorageManager.saveHistoryToFile(stories);
                    break;
            } 
        } while (repeat);
    }
    
    public void printManagerUI(User[] users, Reader[] readers, Book[] books, History[] stories){
        
    }
}
