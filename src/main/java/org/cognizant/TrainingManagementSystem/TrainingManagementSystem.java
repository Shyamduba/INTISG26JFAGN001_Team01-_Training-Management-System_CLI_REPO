package org.cognizant.TrainingManagementSystem;

import org.cognizant.TrainingManagementSystem.Service.CourseService;
import org.cognizant.TrainingManagementSystem.Service.EnrollmentService;
import org.cognizant.TrainingManagementSystem.Service.UserService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TrainingManagementSystem {
    private static UserService userService = new UserService();
    private static CourseService courseService  = new CourseService();
    private static EnrollmentService enrollmentService = new EnrollmentService();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("\n--- Training Management System ---");
            System.out.println("1. User Services");
            System.out.println("2. Course Services");
            System.out.println("3. Enroll Services");
            System.out.println("4. Exit");

            System.out.println("Select an option: ");

            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    handleUserServices();
                    break;
                case 2:
                    handleCourseServices();
                    break;
                case 3:
                    handleEnrollServices();
                    break;
                case 4:
                    System.out.println("Exiting Thank You..");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }



    }

    private static void handleUserServices(){

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--- User Services ---");
            System.out.println("1. Add User");
            System.out.println("2. See All Users");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    userService.addUser();
                    break;
                case 2:
                    userService.viewAllUsers();
                    break;
                case 3:
                    System.out.println("returning to home");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
    private static void handleCourseServices(){
       Scanner sc = new Scanner(System.in);

       while (true) {
           System.out.println("--- Course Services ---");
           System.out.println("1. Add Course");
           System.out.println("2. View All Courses");
           System.out.println("3. Exit");

           int choice = sc.nextInt();

           switch (choice) {
               case 1:
                   courseService.addCourse();
                   break;
               case 2:
                   courseService.viewAllCourses();
                   break;
               case 3:
                   System.out.println("returning to home");
                   return;
               default:
                   System.out.println("Invalid choice");
           }
       }

    }
    private static void handleEnrollServices(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--- Enroll Services ---");
            System.out.println("1. View Enrolled List");
            System.out.println("2. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 :
                    enrollmentService.viewAllEnrollments();
                    break;
                case 2:
                    System.out.println("returning to home");
                    return;
                default:
                    System.out.println("Invalid choice..");
            }
        }



    }

}