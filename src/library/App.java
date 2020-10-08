/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import tools.UserCardManager;
import tools.BooksStorageManager;
import tools.ReadersStorageManager;
import entity.Reader;
import tools.BookManager;
import tools.ReaderManager;
import entity.Book;
import entity.History;
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
    }
        
    public void run() {
        System.out.println("--- Library");
        System.out.println("Menu:");
        boolean repeat = true;
        
        do {
            System.out.println("\n1. Add book");
            System.out.println("2. List of books");
            System.out.println("3. Give a book");        
            System.out.println("4. Take a book");
            System.out.println("5. Add readrer");
            System.out.println("6. List of readers");
            System.out.println("7. List of books given out");
            System.out.println("0. Exit");
            System.out.println("");
            String task = scanner.nextLine();
            switch (task){
                case "0":
                    System.out.println("--- The End ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- 1. Add book ---");
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
                case "5":
                    System.out.println("--- 5. Add readrer ---");
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
                case "2":
                    System.out.println("--- 2. List of books ---");
//                    Book book2 = new Book("Master i Magrarita", "M. Bulgakov", 2010);
//                    Book book3 = new Book("Master i Magrarita", "M. Bulgakov", 2010);
//                    books[1] = book2;
//                    books[2] = book3;
                    int i = 0;
                    for (Book r : books) {
                        if(r != null){
                            System.out.println(i+1+". "+r.toString());
                            i++;
                        }
                    }
                    break;
                case "3":
                    System.out.println("--- 3. Give a book ---");
                    UserCardManager userCardManager = new UserCardManager();
                    History history = userCardManager.giveBook(books, readers);
                    for (int j = 0; j < stories.length; j++) {
                        if (stories[j] == null) {
                            stories[j] = history;
                            break;
                        }
                    }
                    break;
                case "4":
                    System.out.println("--- 4. Take a book ---");
                    break;
                
                case "6":
                    System.out.println("6. List of readers");
                    int y = 0;
                    for (Reader r : readers) {
                        if(r != null){
                            System.out.println(y+1+". "+r.toString());
                            y++;
                        }
                    }
                    break;
                case "7":
                    System.out.println("--- 7. List of books given out ---");
                    n = 0;
                    for (History h : stories) {
                        
                    }

                    break;            
            } 
        }while (repeat);

    }
}
