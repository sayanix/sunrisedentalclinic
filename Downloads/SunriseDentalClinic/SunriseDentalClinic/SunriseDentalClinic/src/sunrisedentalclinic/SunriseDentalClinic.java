/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sunrisedentalclinic;

import java.util.Scanner;

/**
 *
 * @author janid
 */
public class SunriseDentalClinic {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // This is the line that was failing. With the code above, it will now work.
        IAuthentication authService = new FileAuthenticationService();
        
        System.out.println("=== Welcome to Sunrise Dental Clinic ===");
        System.out.print("Enter Username: ");
        String user = input.nextLine();
        
        System.out.print("Enter Password: ");
        String pass = input.nextLine();
        
        if (authService.login(user, pass)) {
            System.out.println("\nLogin Successful!");
            System.out.println("Welcome, " + authService.getLoggedInUser().getUsername());
            System.out.println("Role: " + authService.getLoggedInUser().getRole());
            
            authService.logout();
        } else {
            System.out.println("\nInvalid credentials. Access Denied.");
        }
        
        input.close();
    }
}
