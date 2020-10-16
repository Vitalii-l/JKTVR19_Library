/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.IOException;

/**
 *
 * @author pupil
 */
public class SystemTools {
    public void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").start().waitFor(); 
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {}
    }
    
    public void clearConsole2() {
        
    }
        
    
}
