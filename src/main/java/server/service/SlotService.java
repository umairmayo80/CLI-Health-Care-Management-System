package server.service;

import server.domain.Slot;
import server.domain.User;

import java.util.List;

public interface SlotService {
    //rename to getAll
    //^
    List<Slot> getSlots();
    //rename to getById
    //^
    Slot getSlotBySlotId(int slotID);
    //rename to add
    //^
    boolean addSlotEntry(Slot slot);
    //use or remove
    void viewAllSlots();
    //getById
    void viewSlotsById(int userId);
    //getByUserId
    List<Slot> getSlotsById(int userId);
    void viewBookedSlotsById(int userId);

    void viewFreeSlots();

    //viewFreeSlotsByUserId
    //^
    void viewFreeSlotsById(int userId);
    //add or addForUser
    //^
    boolean addSlot(Slot newSlot, User currentUser);
}
