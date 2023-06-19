package server.context;

import server.impl.*;
import server.service.*;


public class ServiceContext {
    private static DoctorService doctorService;
    private static PatientService patientService;
    private static UserService userService;
    private static AdminService adminService;
    private static AppointmentService appointmentService;
    private static ScheduleService scheduleService;

    private ServiceContext(){
    }

    public static DoctorService getDoctorService(){
        if (doctorService == null){
            synchronized (ServiceContext.class){
                if (doctorService == null){
                    doctorService = new DoctorServiceImpl();
                }
            }
        }
        return doctorService;
    }

    public static UserService getUserService(){
        if (userService == null){
            synchronized (ServiceContext.class){
                if (userService == null){
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }

    public static PatientService getPatientService(){
        if (patientService == null){
            synchronized (ServiceContext.class){
                if (patientService == null){
                    patientService = new PatientServiceImpl();
                }
            }
        }
        return patientService;
    }


    public static AdminService getAdminService(){
        if(adminService == null){
            synchronized (ServiceContext.class){
                if(adminService == null){
                    adminService = new AdminServiceImpl();
                }
            }
        }
        return adminService;
    }

    public static AppointmentService getAppointmentService(){
        if(appointmentService == null){
            synchronized (ServiceContext.class){
                if(appointmentService == null){
                    appointmentService = new AppointmentServiceImpl();
                }
            }
        }
        return appointmentService;
    }

    public static ScheduleService getScheduleService(){
        if(scheduleService == null){
            synchronized (ServiceContext.class){
                if(scheduleService == null){
                    scheduleService = new ScheduleServiceImpl();
                }
            }
        }
        return scheduleService;
    }



}
