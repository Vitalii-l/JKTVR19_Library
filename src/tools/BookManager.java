/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import entity.Book;
import java.util.Arrays;
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
        System.out.println("Input year: ");
        book.setPublishedYear(scanner.nextInt());
        do {
            String publishedYear = scanner.nextLine();
            try {
                book.setPublishedYear(Integer.parseInt(publishedYear));
                break;
            } catch (Exception e){
                System.out.println("Введите цифру");
            }
        } while (true);
        return book;
    }

    public void addBookToArray(Book book, Book[] books) {
        for (int j = 0; j < books.length; j++) {
            if (books[j] == null) {
                books[j] = book;
                break;
            }
        }
    }

    public void printListBooks(Book[] books) {
        System.out.println("Вывод списка книг");
        System.out.println(Arrays.toString(books));
        
        int i = 0;
        for (Book r : books) {
            if(r != null){
                System.out.println(i+1+". "+r.toString());
                i++;}
        }
    }
}
