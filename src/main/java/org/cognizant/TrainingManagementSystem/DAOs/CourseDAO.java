package org.cognizant.TrainingManagementSystem.DAOs;

import org.cognizant.TrainingManagementSystem.DBConnection;
import org.cognizant.TrainingManagementSystem.Entity.Course;

import java.sql.*;

public class CourseDAO {

    public void addCourse(Course course) {
        String sql = "INSERT INTO courses (id, title, trainer_id) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, course.getId());
            stmt.setString(2, course.getTitle());
            stmt.setInt(3, course.getTrainerId());

            stmt.executeUpdate();
            System.out.println("Course '" + course.getTitle() + "' created successfully!");
        } catch (SQLException e) {
            System.out.println("Error saving course: " + e.getMessage());
        }
    }

    public void getAllCourses() {
        String sql = "SELECT * FROM courses";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Course Catalog ---");
            System.out.printf("%-5s | %-20s | %-10s%n", "ID", "Title", "Trainer ID");
            System.out.println("------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d | %-20s | %-10d%n",
                        rs.getInt("id"), rs.getString("title"), rs.getInt("trainer_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching courses: " + e.getMessage());
        }
    }
}