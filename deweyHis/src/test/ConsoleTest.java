package test;

import java.io.Console;

/**
 * ��������̨����
 * @author Administrator
 *
 */
public class ConsoleTest {  
   public static void main(String[] args) {  
       Console console = System.console();  
        if(console != null){  
         String username = console.readLine("Enter username:");  
           String password = new String(console.readPassword("Enter password:"));  
          System.out.println("Username is:" + username);  
        System.out.println("Password is:" + password);  
       } else {
          System.out.println("Console ������!");
      }  
   }  
}  
