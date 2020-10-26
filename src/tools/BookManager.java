/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import entity.Book;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    public void addBookToArray(Book book, List<Book> listBooks) {
        listBooks.add(book);
    }

    public void printListBooks(List<Book> listBooks) {
        System.out.println("Вывод списка книг");
        int i = 0;
        for (Book r : listBooks) {
            if(r != null){
                System.out.println(i+1+". "+r.toString());
                i++;}
        }
    }
}
