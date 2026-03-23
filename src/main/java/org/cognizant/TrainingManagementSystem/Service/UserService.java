package org.cognizant.TrainingManagementSystem.Service;

import org.cognizant.TrainingManagementSystem.DAOs.UserDAO;
import org.cognizant.TrainingManagementSystem.Entity.User;
import java.util.Scanner;

public class UserService {
    private Scanner sc = new Scanner(System.in);
    private UserDAO userDAO = new UserDAO();

    public void addUser() {
        User user = new User();

        System.out.println("\n--- Register New User ---");
        System.out.print("Enter Name: ");
        user.setName(sc.next());

        // Note: If your DB uses Auto-Increment for ID, you can skip asking for ID here.
        System.out.print("Enter ID: ");
        user.setId(sc.nextInt());

        System.out.print("Enter Role (STUDENT/TRAINER): ");
        user.setRole(sc.next());

        // Save to DB via DAO
        userDAO.addUser(user);
    }

    public void viewAllUsers() {
        System.out.println("\nFetching all users from database...");
        // Calls the method we implemented in the UserDAO previously
        userDAO.getAllUsers();
    }
}