/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import entity.Book;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
class App {
    private Scanner scanner = new Scanner(System.in);
    private Reader[] readers = new Reader[10];
    
    
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
                    Book book = new Book("Master i Magrarita", "M. Bulgakov", 2010);
                    System.out.println("Book name:"+book.getName());
                    System.out.println(book.toString());
                    
                    break;
                case "2":
                    System.out.println("--- 2. List of books ---");
                    break;
                case "3":
                    System.out.println("--- 3. Give a book ---");
                    break;
                case "4":
                    System.out.println("4. Take a book");
                    break;
                case "5":
                    System.out.println("5. Add readrer");
                    Reader reader = new Reader("Zinaida", "Kavi", "57432209");
                    readers[0] = reader;
                    Reader reader1 = new Reader("Peter", "Pervyi","45589898");
                    readers[1] = reader1;
                    System.out.println("Reader: " + reader.getFirstName()+" "+reader.getLastName());
                    System.out.println(reader.toString());
                    
                    break;
                case "6":
                    System.out.println("6. List of readers");
                    int i = 0;
                    for (Reader r : readers) {
                        if(r != null){
                            System.out.println(i+1+". "+r.toString());
                            i++;
                        }
                    }
                    
                    break;
                case "7":

                    break;            
            } 
        }while (repeat);

    }
}
