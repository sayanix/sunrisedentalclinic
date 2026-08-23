package sunrisedentalclinic;
import sunrisedentalclinic.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author janid
 */
public interface IAuthentication {
    
    // Returns true if login is successful, false if not
    boolean login(String username, String password);
    
    // Returns the currently logged-in user
    User getLoggedInUser();
    
    void logout();
    
}
