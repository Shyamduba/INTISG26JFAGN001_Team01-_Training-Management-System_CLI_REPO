package org.cognizant.TrainingManagementSystem.Service;

import org.cognizant.TrainingManagementSystem.DAOs.EnrollmentDAO;
import java.util.Scanner;

public class EnrollmentService {
    private Scanner sc = new Scanner(System.in);
    private EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    // Connects a student to a course
    public void enrollStudent() {
        System.out.println("\n--- New Enrollment ---");

        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();

        System.out.print("Enter Course ID: ");
        int courseId = sc.nextInt();

        // Pass IDs to DAO for database insertion
        enrollmentDAO.enrollStudent(studentId, courseId);
    }

    // Displays the joined list of enrollments
    public void viewAllEnrollments() {
        System.out.println("\nFetching enrollment records...");
        enrollmentDAO.getAllEnrollments();
    }
}