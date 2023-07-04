package server.service.version1;
//import server.domain.Appointment;
import server.domain.version1.AppointmentV1;
import java.util.List;

public interface AppointmentServiceV1 {


    // Save appointments to storage
     void saveAppointmentsToStorage(List<AppointmentV1> appointmentList);

     List<AppointmentV1> getAppointments();

    void viewAllAppointments();

     void viewAppointmentsByPatientId(int patientId);

     void viewAppointmentsByDoctorId(int doctorId);

     boolean addAppointmentEntry(AppointmentV1 appointment);


}
