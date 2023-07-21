package server.service;
//import server.domain.Appointment;
import server.domain.User;
import server.domain.Appointment;

import java.util.List;

public interface AppointmentServiceV1 {


    // Save appointments to storage
    // remove unused method
    void saveAppointmentsToStorage(List<Appointment> appointmentList);

    //get
    List<Appointment> getAppointments();

    void viewAllAppointments();

    void viewAppointmentsByPatientId(int patientId);

    void viewAppointmentsByDoctorId(int doctorId);

    //remove entry
    //add(Appointment) is sufficed
    boolean addAppointmentEntry(Appointment appointment);
    //add(Appointment,User) is sufficed
    boolean addAppointment(Appointment appointmentV1, User currentUser);


}
