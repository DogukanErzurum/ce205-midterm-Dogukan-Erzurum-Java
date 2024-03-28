package com.Rsuygun.localTeamManager.authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.Rsuygun.localTeamManager.scheduler.ViewSchedule;

/**
 * The Login class handles user authentication.
 */
public class Login {
	private final String USER_FILE = "users.txt";
	private Map<String, User> users;

	/**
	 * Constructs a Login object and initializes the user map by loading users from
	 * a file.
	 */
	public Login() {
		this.users = new HashMap<>();
		loadUsers();
	}

	/**
	 * Loads users from the specified file and populates the user map.
	 */
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

	/**
	 * Authenticates a user with the given username and password.
	 * 
	 * @param username The username to authenticate.
	 * @param password The password to authenticate.
	 * @return true if authentication is successful, false otherwise.
	 */
	public boolean loginUser(String username, String password) {
		User user = users.get(username);
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("Login successful. Welcome, " + username + "!");
			// Perform additional actions upon successful login, such as setting reminders
			ViewSchedule viewSchedule = new ViewSchedule();
			ViewSchedule.setReminders();
			return true;
		} else {
			System.out.println("\nUsername or password is incorrect!\n");
			return false;
		}
	}
}
