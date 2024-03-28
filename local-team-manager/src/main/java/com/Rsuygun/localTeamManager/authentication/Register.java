package com.Rsuygun.localTeamManager.authentication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Register class handles user registration.
 */
public class Register {
	/**
	 * The file to store registered user information.
	 */
	public final static String USER_FILE = "users.txt";

	/**
	 * Registers a new user with the provided username and password.
	 * 
	 * @param username The username of the user to register.
	 * @param password The password of the user to register.
	 * @return true if registration is successful, false otherwise.
	 */
	public boolean registerUser(String username, String password) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
			writer.write(username + "," + password);
			writer.newLine();
			System.out.println("\nThe user has been successfully registered.\n");
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
