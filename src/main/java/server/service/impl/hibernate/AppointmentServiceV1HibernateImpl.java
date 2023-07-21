package server.service.impl.hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.dao.impl.hibernate.AppointmentRepoHibernate;
import server.domain.User;
import server.domain.Appointment;
import server.service.AppointmentServiceV1;
import static server.utilities.DisplayFormatting.displayAppointmentData;


import java.util.List;

@Component //change this annotation to @Service
public class AppointmentServiceV1HibernateImpl implements AppointmentServiceV1 {
    private final AppointmentRepoHibernate appointmentRepoHibernate;


    @Autowired
    public AppointmentServiceV1HibernateImpl(AppointmentRepoHibernate appointmentRepoHibernate) {
        this.appointmentRepoHibernate = appointmentRepoHibernate;
    }

    @Override
    public void saveAppointmentsToStorage(List<Appointment> appointmentList) {
        appointmentList.forEach(this::addAppointmentEntry);
    }

    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepoHibernate.getAll();
    }

    @Override
    public void viewAllAppointments() {
        displayAppointmentData(getAppointments());
    }

    @Override
    public void viewAppointmentsByPatientId(int patientId) {
       displayAppointmentData(appointmentRepoHibernate.getAppointmentsByPatientId(patientId));
    }

    @Override
    public void viewAppointmentsByDoctorId(int doctorId) {
       displayAppointmentData(appointmentRepoHibernate.getAppointmentsByDoctorId(doctorId));
    }

    @Override
    public boolean addAppointmentEntry(Appointment appointment) {
        return appointmentRepoHibernate.add(appointment);
    }

    @Override
    public boolean addAppointment(Appointment appointmentV1, User currentUser) {
        // now associate the new appointment with the parents
        currentUser.addAppointmentV1(appointmentV1);
        return addAppointmentEntry(appointmentV1);
    }
}
