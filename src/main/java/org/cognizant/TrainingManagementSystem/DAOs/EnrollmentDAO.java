package org.cognizant.TrainingManagementSystem.DAOs;
import org.cognizant.TrainingManagementSystem.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class EnrollmentDAO {
    public void enrollStudent(int studentId, int courseId) {
        String sql = "INSERT INTO enrollments (student_id, course_id, status) VALUES (?, ?, 'ENROLLED')";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.executeUpdate();
            System.out.println("Successfully enrolled!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllEnrollments() {
        // 1. Define the SQL query (Joining tables makes the output readable)
        String sql = "SELECT e.id, u.name AS student_name, c.title AS course_name, e.status " +
                "FROM enrollments e " +
                "JOIN users u ON e.student_id = u.id " +
                "JOIN courses c ON e.course_id = c.id";

        // 2. Use try-with-resources for automatic closing of connection and statement
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Current Enrollments ---");
            System.out.printf("%-5s | %-15s | %-20s | %-10s%n", "ID", "Student", "Course", "Status");
            System.out.println("------------------------------------------------------------");

            // 3. Iterate through the results
            while (rs.next()) {
                int id = rs.getInt("id");
                String studentName = rs.getString("student_name");
                String courseName = rs.getString("course_name");
                String status = rs.getString("status");

                System.out.printf("%-5d | %-15s | %-20s | %-10s%n", id, studentName, courseName, status);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching enrollments: " + e.getMessage());
        }
    }
}