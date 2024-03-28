package com.Rsuygun.localTeamManager.scheduler;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The EditGame class handles the editing of existing games in the schedule.
 */
public class EditGame {
	private List<Game> games;

	/**
	 * Constructs an EditGame object with the given list of games.
	 * 
	 * @param games The list of games to be edited.
	 */
	public EditGame(List<Game> games) {
		this.games = games;
	}

	/**
	 * Edits the details of a game with the specified ID.
	 * 
	 * @param gameId      The ID of the game to be edited.
	 * @param newDateStr  The new date of the game.
	 * @param newTime     The new time of the game.
	 * @param newLocation The new location of the game.
	 * @param newOpponent The new opponent of the game.
	 */
	public void editGame(int gameId, String newDateStr, String newTime, String newLocation, String newOpponent) {
		boolean found = false;

		for (Game game : games) {
			if (game.getId() == gameId) {
				found = true;
				try {
					SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date newDateTime = dateTimeFormat.parse(newDateStr + " " + newTime);

					game.setDate(newDateTime);
					game.setLocation(newLocation);
					game.setOpponent(newOpponent);

					saveGamesToFile();

					System.out.println("\nThe game has been updated successfully.\n");
				} catch (Exception e) {
					System.out.println("\nInvalid login!\n");
				}
				break;
			}
		}

		if (!found) {
			System.out.println("\nNo game with the specified ID was found.\n");
		}
	}

	/**
	 * Saves the updated list of games to the file.
	 */
	private void saveGamesToFile() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt"))) {
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
