/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import tools.HistoryStorageManager;
import tools.UserCardManager;
import tools.BooksStorageManager;
import tools.ReadersStorageManager;
import entity.Reader;
import tools.BookManager;
import tools.ReaderManager;
import entity.Book;
import entity.History;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
class App {
    private Scanner scanner = new Scanner(System.in);
    private Reader[] readers = new Reader[10];
    private Book[] books = new Book[10];
    private History[] stories = new History[10];
    

    public App() {
       ReadersStorageManager rsm = new ReadersStorageManager();
       Reader[] loadReaders = rsm.loadReadersFromFile();
       if (loadReaders !=null){
           readers = loadReaders;
       }
       BooksStorageManager bsm = new BooksStorageManager();
       Book[] loadBooks = bsm.loadBooksFromFile();
       if (loadBooks !=null){
           books = loadBooks;
       }
       HistoryStorageManager hsm = new HistoryStorageManager();
       History[] loadHistory = hsm.loadHistoryFromFile();
       if (loadHistory != null){
           stories = loadHistory;
       }
       HistoryStorageManager historyStorageManager = new HistoryStorageManager();
       History[] loaderStories = historyStorageManager.loadHistoryFromFile();
       if (loaderStories != null){
           stories = loaderStories;
       }
    }
        
    public void run() {
        System.out.println("--- Library");
        System.out.println("Menu:");
        boolean repeat = true;
        
        do {
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
                    int i = 0;
                    for (Book r : books) {
                        if(r != null){
                            System.out.println(i+1+". "+r.toString());
                            i++;
                        }
                    }
                    break;
                case "2":
                    System.out.println("2. List of readers");
                    int y = 0;
                    for (Reader r : readers) {
                        if(r != null){
                            System.out.println(y+1+". "+r.toString());
                            y++;
                        }
                    }
                    break;
                case "3":
                    System.out.println("--- 3. List of books given out ---");
                    y = 0;
                    for (History h : stories) {
                        if(h != null){
                            System.out.println(y+1+". "+h.toString());
                            y++;}
                    }
                    break;
                case "4":
                    System.out.println("--- 4. Give a book ---");
                    UserCardManager userCardManager = new UserCardManager();
                    History history = userCardManager.giveBook(books, readers);
                    for (int j = 0; j < stories.length; j++) {
                        if (stories[j] == null) {
                            stories[j] = history;
                            break;
                        }
                    }
                    HistoryStorageManager historyStorageManager = new HistoryStorageManager();
                    historyStorageManager.saveHistoryToFile(stories);
                    
                    break;
                case "5":
                    System.out.println("--- 5. Take a book ---");
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
                    System.out.println("Выберите номер возвращаемой книги:");
                    int historyNumber = scanner.nextInt();
                    History history1 = stories[historyNumber - 1];
                    history1.setReturnDate(new GregorianCalendar().getTime());
                    HistoryStorageManager historyStorageManager = new HistoryStorageManager();
                    historyStorageManager.saveHistoryToFile(stories);
                    break;
                case "6":
                    System.out.println("--- 6. Add book ---");
                    BookManager bookManager = new BookManager();
                    Book book = bookManager.addBook();
                    for (int j = 0; j < books.length; j++) {
                        if (books[j] == null) {
                            books[j] = book;
                            break;
                        }
                    }
                    BooksStorageManager booksStorageManager = new BooksStorageManager();
                    booksStorageManager.saveBooksToFile(books);
                    System.out.println("Book name:"+book.getName());
                    System.out.println(book.toString());
                    break;
                case "7":
                    System.out.println("--- 7. Add readrer ---");
                    ReaderManager readerManager = new ReaderManager();
                    Reader reader = readerManager.addReader();
                    for (int j = 0; j < readers.length; j++) {
                        if (readers[j] == null) {
                            readers[j] = reader;
                            break;
                        }
                    }
                    ReadersStorageManager readersStorageManager = new ReadersStorageManager();
                    readersStorageManager.saveReadersToFile(readers);
                    System.out.println("Reader: " + reader.getFirstName()+" "+reader.getLastName());
                    System.out.println(reader.toString());
                    break;           
            } 
        }while (repeat);

    }
}
