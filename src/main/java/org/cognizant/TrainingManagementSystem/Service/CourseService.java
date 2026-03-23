package org.cognizant.TrainingManagementSystem.Service;

import org.cognizant.TrainingManagementSystem.DAOs.CourseDAO;
import org.cognizant.TrainingManagementSystem.Entity.Course;
import java.util.Scanner;

public class CourseService {
    private Scanner sc = new Scanner(System.in);
    private CourseDAO courseDAO = new CourseDAO();

    public void addCourse() {
        Course course = new Course();

        System.out.println("\n--- Create New Course ---");

        System.out.print("Enter Course ID: ");
        course.setId(sc.nextInt());
        sc.nextLine(); // Consume newline left by nextInt()

        System.out.print("Enter Course Title: ");
        course.setTitle(sc.nextLine());

        System.out.print("Enter Assigned Trainer ID: ");
        course.setTrainerId(sc.nextInt());

        // Save to Database
        courseDAO.addCourse(course);
    }

    public void viewAllCourses() {
        // Fetch and display the list from the DAO
        courseDAO.getAllCourses();
    }
}