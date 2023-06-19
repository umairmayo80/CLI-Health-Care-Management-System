package server.service;
import server.domain.User;

//docs
//check any IntelliJ warnings
// no need of public modifier
public interface AdminService {

    public boolean addUser(User user);

    public void setUserAccountStatus(String username,boolean status);


}
