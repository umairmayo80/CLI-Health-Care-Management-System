package server.context;

import server.service.*;
import server.service.impl.Database.AppointmentServiceV1DBImpl;
import server.service.impl.Database.SlotsServiceDBImpl;
import server.service.impl.Database.UserServiceDBImpl;
import server.service.impl.FileSystem.*;
import server.service.version1.AppointmentServiceV1;
import server.utilities.DatabaseConnection;

import java.sql.Connection;
import java.util.Scanner;


/**

 The ServiceContext class provides access to various service implementations and resources.
 It follows the Singleton design pattern to ensure only one instance of each service is created.
 The class also manages the database connection and provides a scanner for user input.
 *
 */
public class ServiceContext {
    private static DoctorService doctorService;
    private static PatientService patientService;
    private static UserService userService;
    private static AdminService adminService;
    private static AppointmentService appointmentService;
    private static ScheduleService scheduleService;

    private static SlotService slotService; // it replaces scheduleService

    private static AppointmentServiceV1 appointmentServiceV1;

    private static Connection databaseConnection;

    private static Scanner scanner;

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

    public static UserService getUserServiceDB(){
        if (userService == null){
            synchronized (ServiceContext.class){
                if (userService == null){
                    userService = new UserServiceDBImpl();
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

    public static Connection getDatabaseConnection(){
        if(databaseConnection == null){
            synchronized (ServiceContext.class){
                if(databaseConnection == null){
                    databaseConnection = new DatabaseConnection().getConnection();
                }
            }
        }
        return databaseConnection;
    }


    public static Scanner getScanner(){
        if(scanner == null){
            synchronized (ServiceContext.class){
                if(scanner == null){
                    scanner = new Scanner(System.in);
                }
            }
        }
        return scanner;
    }


    public static SlotService getSlotService(){
        if(slotService == null){
            synchronized (ServiceContext.class){
                if(slotService == null){
                    slotService = new SlotsServiceDBImpl();
                }
            }
        }
        return slotService;
    }


    public static AppointmentServiceV1 getAppointmentServiceV1(){
        if(appointmentServiceV1 == null){
            synchronized (ServiceContext.class){
                if(appointmentServiceV1 == null){
                    appointmentServiceV1 = new AppointmentServiceV1DBImpl();
                }
            }
        }
        return appointmentServiceV1;
    }


}
