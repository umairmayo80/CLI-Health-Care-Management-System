package server.service;
import server.domain.User;


public interface AdminService {

    //rename to add(Admin)
    boolean addUser(User user);

    boolean setUserAccountStatus(String username,boolean status);


}
