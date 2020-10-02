/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
class App {
    private Scanner scanner = new Scanner(System.in);
    public void run() {
        System.out.println("--- Library");
        System.out.println("Menu:");
        boolean repeat = true;
        System.out.println("\n1. Add book");
        System.out.println("2. List of books");
        System.out.println("3. Give a book");        
        System.out.println("4. Take a book");
        System.out.println("5. Add readrer");
        System.out.println("6. List of readers");
        System.out.println("0. Exit");
        String task = scanner.nextLine();
        
        do {
            switch (task){
                case "0":
                    System.out.println("--- The End ---");
                    repeat = false;
                break;
                case "1":
                    System.out.println("1. Add book");
                break;
                case "2":
                    System.out.println("2. List of books");
                break;
                case "3":
                    System.out.println("3. Give a book");
                break;
                case "4":
                    System.out.println("4. Take a book");
                break;
                case "5":
                    System.out.println("5. Add readrer");
                break;
                case "6":
                    System.out.println("6. List of readers");
                break;
                case "7":

                break;            
            } 
        }while (repeat);

    }
}
