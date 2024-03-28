package com.Rsuygun.localTeamManager.tracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @brief Class for viewing player statistics.
 */
public class ViewPlayerStats {
	
	/**
     * @brief Displays statistics for a specific player.
     * 
     * This method reads the player.txt file to retrieve statistics for the specified player ID
     * and then displays them to the console.
     * 
     * @param playerId The ID of the player whose statistics are to be displayed.
     */
	public void displayPlayerStats(int playerId) {
		try (BufferedReader reader = new BufferedReader(new FileReader("player.txt"))) {
			String line;
			boolean playerFound = false;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
				if (id == playerId) {
				
					playerFound = true;
					String name = parts[1];
					String surname = parts[2];
					int goals = Integer.parseInt(parts[7]);
					int assists = Integer.parseInt(parts[8]);
					int yellowCards = Integer.parseInt(parts[9]);
					int redCards = Integer.parseInt(parts[10]);

					System.out.println("Player ID: " + id);
					System.out.println("Name: " + name);
					System.out.println("Surname: " + surname);
					System.out.println("Number of Goals: " + goals);
					System.out.println("Number of Assists: " + assists);
					System.out.println("Number of Yellow Cards: " + yellowCards);
					System.out.println("Number of Red Cards: " + redCards);

					break;
				}
			}
			if (!playerFound) {
				System.out.println("\nNo player with the specified ID was found.\n");
			}
		} catch (IOException | NumberFormatException e) {
		}
	}
}
