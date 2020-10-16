/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import tools.SystemTools;
import tools.HistoryStorageManager;
import tools.UserCardManager;
import tools.BooksStorageManager;
import tools.ReadersStorageManager;
import tools.BookManager;
import tools.ReaderManager;
import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;
import security.SecureManager;


/**
 *
 * @author pupil
 */
class App {
    private Scanner scanner = new Scanner(System.in);
    private Reader[] readers = new Reader[10];
    private Book[] books = new Book[10];
    private History[] stories = new History[10];
    private User[] users = new User[10];
    private BookManager bookManager = new BookManager();
    private ReadersStorageManager rsm = new ReadersStorageManager();
    private ReadersStorageManager readersStorageManager = new ReadersStorageManager();
    private UserCardManager userCardManager = new UserCardManager();
    private ReaderManager readerManager = new ReaderManager();
    private BooksStorageManager bsm = new BooksStorageManager();
    private BooksStorageManager booksStorageManager = new BooksStorageManager();
    private HistoryStorageManager hsm = new HistoryStorageManager();
    private HistoryStorageManager historyStorageManager = new HistoryStorageManager();
    private SystemTools clearCon = new SystemTools();
    
    private User loggedInUser;
    
    public App() {
       
       Reader[] loadReaders = rsm.loadReadersFromFile();
       if (loadReaders !=null){
           readers = loadReaders;
       }
       
       Book[] loadBooks = bsm.loadBooksFromFile();
       if (loadBooks !=null){
           books = loadBooks;
       }
       
       History[] loadHistory = hsm.loadHistoryFromFile();
       if (loadHistory != null){
           stories = loadHistory;
       }
       
       History[] loaderStories = historyStorageManager.loadHistoryFromFile();
       if (loaderStories != null){
           stories = loaderStories;
       }
    }
        
    public void run() {
        System.out.println("--- Library");
        System.out.println("Menu:");
        SecureManager secureManager = new SecureManager();
        this.loggedInUser = secureManager.checkInLogin(users,readers);
        boolean repeat = true;
        do {
            clearCon.clearConsole();
            System.out.println("\n1. List of books");
            System.out.println("2. List of readers");
            System.out.println("3. List of books given out");
            System.out.println("4. Give a book");        
            System.out.println("5. Take a book");
            System.out.println("6. Add book");
            System.out.println("7. Add readrer");
            
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
                case "2":
                    System.out.println("2. List of readers");
                    readerManager.printListReaders(readers);
                    break;
                case "3":
                    System.out.println("--- 3. List of checked out books ---");
                    userCardManager.printListReadBooks (stories);
                    break;
                case "4":
                    System.out.println("--- 4. Check out a book ---");
                    History history = userCardManager.checkOutBook(books, readers);
                    userCardManager.addHistoryToArray(history, stories);
                    historyStorageManager.saveHistoryToFile(stories);
                    break;
                case "5":
                    System.out.println("--- 5. Check in a book ---");
                    userCardManager.checkInBook (stories);
                    System.out.println("Выберите номер возвращаемой книги:");
                    int historyNumber = scanner.nextInt();
                    History history1 = stories[historyNumber - 1];
                    history1.setReturnDate(new GregorianCalendar().getTime());
                    
                    historyStorageManager.saveHistoryToFile(stories);
                    break;
                case "6":
                    System.out.println("--- 6. Add book ---");
                    Book book = bookManager.createBook();
                    bookManager.addBookToArray(book,books);
                    booksStorageManager.saveBooksToFile(books);
                    System.out.println("Book name:"+book.getName());
                    System.out.println(book.toString());
                    break;
                case "7":
                    System.out.println("--- 7. Add readrer ---");
                    Reader reader = readerManager.createReader();
                    readerManager.addReaderToArray(reader,readers);
                    readersStorageManager.saveReadersToFile(readers);
//                    System.out.println("Reader: " + reader.getFirstName()+" "+reader.getLastName());
//                    System.out.println(reader.toString());
                    break;           
            } 
        }while (repeat);

    }
    
    
}
