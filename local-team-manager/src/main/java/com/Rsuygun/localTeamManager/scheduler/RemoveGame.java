package com.Rsuygun.localTeamManager.scheduler;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The RemoveGame class is responsible for removing a game from the schedule.
 */
public class RemoveGame {
	private List<Game> games;

	/**
	 * Constructs a RemoveGame object.
	 */
	public RemoveGame() {
		this.games = new ArrayList<>();
	}

	/**
	 * Removes a game with the specified ID from the schedule.
	 * 
	 * @param gameId The ID of the game to be removed.
	 */
	public void removeGame(int gameId) {
		loadGamesFromFile(); // Load games from file
		games.removeIf(game -> game.getId() == gameId); // Remove the game with the specified ID
		saveGamesToFile(); // Save the updated games to file
	}

	/**
	 * Loads games from the file and populates the games list.
	 */
	private void loadGamesFromFile() {
		games.clear(); // Clear the existing games list
		try (BufferedReader reader = new BufferedReader(new FileReader("game.txt"))) {
			String line;
			// Read each line from the file
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 5) {
					int id = Integer.parseInt(parts[0]);
					// Parse the date and time from the string
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date gameDate = dateFormat.parse(parts[1] + " " + parts[2]);
					String location = parts[3];
					String opponent = parts[4];
					// Create a new Game object and add it to the games list
					Game game = new Game(id, gameDate, parts[2], location, opponent);
					games.add(game);
				}
			}
		} catch (IOException | java.text.ParseException e) {
			// Handle IO and parsing exceptions
		}
	}

	/**
	 * Saves the games in the list to the file.
	 */
	private void saveGamesToFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt"))) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			// Write each game to the file
			for (Game game : games) {
				String dateStr = dateFormat.format(game.getDate());
				String timeStr = timeFormat.format(game.getDate());
				writer.write(game.getId() + "," + dateStr + "," + timeStr + "," + game.getLocation() + ","
						+ game.getOpponent());
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
		}
	}
}
