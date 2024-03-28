package com.Rsuygun.localTeamManager.authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminManager {
    private static final String ADMIN_FILE = "admins.txt";

    private String adminUsername;
    private String adminPassword;

    public AdminManager() {
        loadAdminCredentials();
    }

    private void loadAdminCredentials() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    adminUsername = parts[0];
                    adminPassword = parts[1];
                }
            }
        } catch (IOException e) {
        }
    }

    public boolean loginAdmin(String username, String password) {
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println("\nAdmin login is successful. Welcome, " + username + "!\n");
            return true;
        } else {
            System.out.println("\nAdmin username or password is incorrect!\n");
            return false;
        }
    }
}
