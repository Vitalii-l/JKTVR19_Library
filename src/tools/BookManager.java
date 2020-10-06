/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import entity.Book;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class BookManager {
    public Book addBook(){
        Book book = new Book();
        System.out.println("--- Adding new book ---");
        System.out.println("Input book name: ");
        Scanner scanner = new Scanner(System.in);
        book.setName(scanner.nextLine());
        System.out.println("Input author: ");
        book.setAuthor(scanner.nextLine());
        System.out.println("Input year: ");
        book.setPublishedYear(scanner.nextInt());
        return book;
    }
    

    
    
}
