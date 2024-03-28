package com.Rsuygun.localTeamManager.authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.Rsuygun.localTeamManager.scheduler.ViewSchedule;

public class Login {
    private final String USER_FILE = "users.txt";
    private Map<String, User> users;

    public Login() {
        this.users = new HashMap<>();
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    users.put(username, new User(username, password));
                }
            }
        } catch (IOException e) {
        }
    }

    public boolean loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            ViewSchedule viewSchedule = new ViewSchedule();
            ViewSchedule.setReminders();
            return true;
        } else {
            System.out.println("\nUsername or password is incorrect!\n");
            return false;
        }
    }
}
