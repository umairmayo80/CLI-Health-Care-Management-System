package server.service;
import server.domain.Slot;
import server.domain.User;

public interface DoctorService {
    //remove unused method or use it properly 
    void viewAppointments(int userID) ;
    //rename to addSlot
    boolean addSlotsEntry(Slot slot, User currentUser);
    //remove unused method or use it properly
    void viewSlots (int userID);
}
