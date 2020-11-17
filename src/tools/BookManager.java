/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import entity.Book;
import entity.controllers.BookController;
import java.util.List;
import java.util.Scanner;
import library.App;

/**
 *
 * @author pupil
 */
public class BookManager {
   
    
    public Book createBook(){
        Book book = new Book();
        System.out.println("--- Adding new book ---");
        System.out.println("Input book name: ");
        Scanner scanner = new Scanner(System.in);
        book.setName(scanner.nextLine());
        System.out.println("Input author: ");
        book.setAuthor(scanner.nextLine());
        //book.setPublishedYear(scanner.nextInt());
        do {
            System.out.println("Input publish year: ");
            String strPublishedYear = scanner.nextLine();
            try {
                book.setPublishedYear(Integer.parseInt(strPublishedYear));
                break;
            } catch (Exception e){
                System.out.println("Input year as a number");
            }
        } while (true);
        return book;
    }

    public void addBookToArray(Book book, List<Book> listBooks, StorageManagerInterface storageManager) {
        listBooks.add(book);
        storageManager.save(listBooks, App.storageFiles.BOOKS.toString());
    }

    public boolean printListBooks() {
        System.out.println("Вывод списка книг");
        BookController bc = new BookController();
        List<Book> listBooks = bc.findAll();
        if (listBooks == null || listBooks.size() < 1){
            System.out.println("Книг нет");
            return false;
        }
        
        int i = 0;
        for (Book b : listBooks) {
            if(b != null){
                System.out.println(b.getId()+". "+b.toString());
                i++;}
        }
        return true;
    }
}
