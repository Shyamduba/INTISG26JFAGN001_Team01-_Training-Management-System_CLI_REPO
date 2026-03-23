package org.cognizant.TrainingManagementSystem.DAOs;

import org.cognizant.TrainingManagementSystem.DBConnection;
import org.cognizant.TrainingManagementSystem.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    // Implementation for "Add User"
    public void addUser(User user) {
        String sql = "INSERT INTO users (id, name, role) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getRole());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User '" + user.getName() + "' added to database successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    // Implementation for "View All Users"
    public void getAllUsers() {
        String sql = "SELECT id, name, role FROM users";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Registered Users ---");
            System.out.printf("%-5s | %-20s | %-25s%n", "ID", "Name", "Role");
            System.out.println("-------------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String role = rs.getString("role");

                System.out.printf("%-5d | %-20s | %-25s%n", id, name, role);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
    }
}