package android.cs2340.Persistence;

import java.util.Map;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.UserModel;

/**
 * Interface for the UserDataSource.
 * @author tiff
 *
 */
public interface UserDataSource {
    
    /**
     * Creates a user.
     * @param username The user's username. 
     * @param password The password.
     * @return The UserModel for the created user. 
     */
    UserModel createUser(String username, String password);
    
    /**
     * Gets all of the users in the database. 
     * @return HashMap with all of the users modeled in UserModels.
     */
    Map<String, UserModel> getAllUsers();
    
    /**
     * Gets a user based on id. 
     * @param id The user's id.
     * @return The User.
     */
    UserModel getUser(long id);
}
