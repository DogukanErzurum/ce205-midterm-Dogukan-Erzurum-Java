package com.Rsuygun.localTeamManager.authentication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register {
    public final static String USER_FILE = "users.txt";

    public boolean registerUser(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            // Kullanıcıyı dosyaya ekle
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("\nThe user has been successfully registered.\n");
            return true;
        } catch (IOException e) {
            System.out.println("\nAn error occurred while registering the user: " + e.getMessage());
            return false;
        }
    }
}
