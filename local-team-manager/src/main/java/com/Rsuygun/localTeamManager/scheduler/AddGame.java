package com.Rsuygun.localTeamManager.scheduler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The AddGame class handles the addition of new games to the schedule.
 */
public class AddGame {
	private List<Game> games;
	private int lastGameId;

	/**
	 * Constructs an AddGame object with an empty list of games and initializes the
	 * last game ID to 0.
	 */
	public AddGame() {
		this.games = new ArrayList<>();
		this.lastGameId = 0;
	}

	/**
	 * Adds a new game to the schedule.
	 * 
	 * @param date     The date of the game.
	 * @param time     The time of the game.
	 * @param location The location of the game.
	 */
	public void addGame(Date date, String time, String location) {
		String opponent = generateRandomOpponent();
		lastGameId++;
		Game game = new Game(lastGameId, date, time, location, opponent);
		games.add(game);
		saveGamesToFile();
	}

	/**
	 * Generates a random opponent for the game.
	 * 
	 * @return A randomly selected opponent from a predefined list.
	 */
	private String generateRandomOpponent() {
		String[] opponents = { "Team A", "Team B", "Team C", "Team D", "Team E" };
		Random random = new Random();
		int index = random.nextInt(opponents.length);
		return opponents[index];
	}

	/**
	 * Retrieves the list of games.
	 * 
	 * @return The list of games.
	 */
	public List<Game> getGames() {
		return games;
	}

	/**
	 * Saves the list of games to a file.
	 */
	private void saveGamesToFile() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt", true))) {
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
