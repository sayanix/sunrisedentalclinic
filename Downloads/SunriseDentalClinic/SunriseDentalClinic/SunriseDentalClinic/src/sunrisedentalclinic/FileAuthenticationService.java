package sunrisedentalclinic;
import java.io.File;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author janid
 */
public class FileAuthenticationService implements IAuthentication {
    
    private User loggedInUser = null;
    private final String FILE_PATH = "users.txt";

    @Override
    public boolean login(String username, String password) {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("Error: User database (users.txt) not found.");
                return false;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userDetails = line.split(","); 
                
                if (userDetails.length == 3) { // Ensure there are 3 parts
                    if (userDetails[0].equals(username) && userDetails[1].equals(password)) {
                        loggedInUser = new User(userDetails[0], userDetails[1], userDetails[2]);
                        scanner.close();
                        return true; 
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return false; 
    }

    @Override
    public User getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public void logout() {
        loggedInUser = null;
        System.out.println("You have been securely logged out.");
    }
    
}
