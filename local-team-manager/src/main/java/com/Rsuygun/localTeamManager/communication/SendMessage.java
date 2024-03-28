package com.Rsuygun.localTeamManager.communication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The SendMessage class facilitates sending messages to players.
 */
public class SendMessage {
	/**
	 * Sends a message to the player with the specified ID.
	 * 
	 * @param playerId The ID of the player to whom the message will be sent.
	 * @param message  The message to be sent.
	 */
	public void sendMessageToPlayer(int playerId, String message) {
		try {
			String playerName = "";
			String playerSurname = "";
			try (BufferedReader reader = new BufferedReader(new FileReader("player.txt"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split(",");
					int id = Integer.parseInt(parts[0]);
					if (id == playerId) {
						playerName = parts[1];
						playerSurname = parts[2];
						break;
					}
				}
			}

			if (playerName.isEmpty()) {
				return;
			}

			try (PrintWriter writer = new PrintWriter(new FileWriter("userMessage.txt", true))) {
				writer.print("Player ID: " + playerId + ", ");
				writer.print("Player Name: " + playerName + ", ");
				writer.print("Player Surname: " + playerSurname + ", ");
				writer.print("Message: " + message + "\n");
			}

			System.out.println("\nThe message was sent successfully.\n");
		} catch (IOException | NumberFormatException e) {
		}
	}
}
