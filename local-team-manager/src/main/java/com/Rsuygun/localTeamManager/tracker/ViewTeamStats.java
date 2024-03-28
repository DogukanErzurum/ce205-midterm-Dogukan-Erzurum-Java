package com.Rsuygun.localTeamManager.tracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @brief Class for viewing team statistics.
 */
public class ViewTeamStats {
	
	/**
     * @brief Displays statistics for the entire team.
     * 
     * This method reads the player.txt file to retrieve statistics for each player
     * and then calculates the total statistics for the entire team.
     */
	public void displayTeamStats() {
		int totalGoals = 0;
		int totalAssists = 0;
		int totalYellowCards = 0;
		int totalRedCards = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader("player.txt"))) {
			String line;
			System.out.println("Team Statistics:");

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
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
				System.out.println();

				totalGoals += goals;
				totalAssists += assists;
				totalYellowCards += yellowCards;
				totalRedCards += redCards;
			}

			System.out.println("Total Number of Goals: " + totalGoals);
			System.out.println("Total Number of Assists: " + totalAssists);
			System.out.println("Total Number of Yellow Cards: " + totalYellowCards);
			System.out.println("Total Number of Red Cards: " + totalRedCards);
		} catch (IOException | NumberFormatException e) {
		}
	}
}
