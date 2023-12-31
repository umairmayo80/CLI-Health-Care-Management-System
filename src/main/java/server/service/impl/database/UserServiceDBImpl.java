package server.service.impl.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.domain.User;
import server.service.UserService;
import server.dao.impl.database.UserRepoDbImpl;
import server.utilities.DisplayFormatting;

import java.util.List;

@Component
public class UserServiceDBImpl implements UserService {
    UserRepoDbImpl userRepoDb;


    @Autowired
    public UserServiceDBImpl(UserRepoDbImpl userRepoDb) {
        this.userRepoDb = userRepoDb;
    }

    public List<User> getUsers() {
       return userRepoDb.getAll();
    }

    // add new user to the database
    @Override
    public boolean addUserEntry(User user) {
        return userRepoDb.add(user);
    }

    @Override
    public void addUsersListToStorage(List<User> userList) {
        userList.forEach(this::addUserEntry);
    }


    public User validateUserLogin(String username, String password, String userRole) {
        User user = userRepoDb.getByUsername(username);
        if(user==null){
            return null;
        }
        else if(user.getPassword().equals(password) && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }


    @Override
    public void viewUsers() {
        List<User> users = getUsers();
        DisplayFormatting.displayUsers(users);
    }

    @Override
    public void viewPatients() {
        List<User> patients = getPatients();
        DisplayFormatting.displayUsers(patients);
    }

    @Override
    public void viewDoctors() {
        List<User> doctors = getDoctors();
        DisplayFormatting.displayUsers(doctors);
    }

    @Override
    public boolean deleteUser(String username) {
        return userRepoDb.delete(username);
    }

    public List<User> getPatients() {
        return userRepoDb.getPatients();
    }

    public List<User> getDoctors() {
        return userRepoDb.getDoctors();
    }

}
