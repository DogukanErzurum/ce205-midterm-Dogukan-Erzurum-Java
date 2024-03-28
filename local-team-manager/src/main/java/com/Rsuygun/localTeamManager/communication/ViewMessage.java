package com.Rsuygun.localTeamManager.communication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The ViewMessage class displays all sent messages.
 */
public class ViewMessage {
	/**
	 * Displays all sent messages.
	 */
	public void displayAllMessages() {
		try (BufferedReader reader = new BufferedReader(new FileReader("userMessage.txt"))) {
			String line;
			System.out.println("\nSent Messages:");

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
		}
	}
}
