package server.service.impl.database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.domain.User;
import server.service.AdminService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class AdminServiceDBImpl implements AdminService {
    Connection connection;
    UserServiceDBImpl userServiceDB;

    @Autowired
    public AdminServiceDBImpl(Connection connection, UserServiceDBImpl userServiceDB) {
        this.connection = connection;
        this.userServiceDB = userServiceDB;
    }

    public boolean isUsernameAvailable(String username) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM user_table WHERE username = '"+username+"'";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return false;  // username already exists
            }
        } catch (SQLException e) {
            System.out.println("Error reading users from the Database: " + e.getMessage());
        }
        return true; // Username is available
    }


    @Override
    public boolean addUser(User user) {
        if (isUsernameAvailable(user.getUsername())) {
            return userServiceDB.addUserEntry(user);
        } else {
            System.out.println("Error: Username '" + user.getUsername() + "' already exists. Please choose a different username.");
            return false;
        }
    }

    @Override
    public boolean setUserAccountStatus(String username, boolean status) {
            try {
                Statement statement = connection.createStatement();
                String query = "UPDATE user_table SET accountLocked ="+status
                                 +" where username='"+username+"';";
                //update the user accountLocked status where username = username
                int rowsAffected = statement.executeUpdate(query);
                if(rowsAffected>0){
                    return true;
                }
                else {
                    System.out.printf("Error: No User found against this the provided '%s' username.\n",username);
                }}
            catch (SQLException e){
                System.out.println("Error: Unable to write data to database" + e.getMessage());
            }
        return false;
    }

}
