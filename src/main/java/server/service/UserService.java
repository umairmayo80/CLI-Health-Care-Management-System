package server.service;
import server.domain.User;
import java.util.List;

//remove the context from the method name as it is already covered by class name
//getUser -> get etc
public interface UserService {
    List<User> getUsers();

    boolean addUserEntry(User user);
    void addUsersListToStorage(List<User> userList);

    User validateUserLogin(String username, String password, String userRole);

    //you may move these methods to patient service and doctor service (see interface segregation)
    List<User> getPatients();
    List<User> getDoctors();

    void viewUsers();
    //you may move these methods to patient service and doctor service (see interface segregation)
    void viewPatients();
    void viewDoctors();

    boolean deleteUser(String username);


}
