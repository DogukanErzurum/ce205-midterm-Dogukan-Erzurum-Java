package com.Rsuygun.localTeamManager.roaster;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * The EditPlayer class facilitates editing player details in the roster.
 */
public class EditPlayer {
	private List<Player> playerList;

	/**
	 * Constructs an EditPlayer object with the given player list.
	 * 
	 * @param playerList The list of players whose details can be edited.
	 */
	public EditPlayer(List<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * Edits the details of a player with the specified ID.
	 * 
	 * @param editPlayerId         The ID of the player to edit.
	 * @param newPlayerName        The new name of the player.
	 * @param newPlayerSurname     The new surname of the player.
	 * @param newPlayerBirthDate   The new birth date of the player.
	 * @param newPlayerNationality The new nationality of the player.
	 * @param newPlayerPosition    The new position of the player.
	 * @param newPlayerMarketValue The new market value of the player.
	 */
	public void editPlayer(int editPlayerId, String newPlayerName, String newPlayerSurname, String newPlayerBirthDate,
			String newPlayerNationality, String newPlayerPosition, double newPlayerMarketValue) {
		for (Player player : playerList) {
			if (player.getId() == editPlayerId) {
				player.setName(newPlayerName);
				player.setSurname(newPlayerSurname);
				player.setBirthDate(newPlayerBirthDate);
				player.setNationality(newPlayerNationality);
				player.setPosition(newPlayerPosition);
				player.setMarketValue(newPlayerMarketValue);
				System.out.println("\nThe player has been successfully edited.\n");

				savePlayersToFile(playerList);
				return;
			}
		}
		System.out.println("\nNo player with the specified ID was found.\n");
	}

	/**
	 * Saves the updated player details to a file.
	 * 
	 * @param playerList The list of players whose details will be saved.
	 */
	private void savePlayersToFile(List<Player> playerList) {
		String fileName = "player.txt";
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			for (Player player : playerList) {
				writer.println(player.getId() + "," + player.getName() + "," + player.getSurname() + ","
						+ player.getBirthDate() + "," + player.getNationality() + "," + player.getPosition() + ","
						+ player.getMarketValue());
			}
		} catch (IOException e) {
		}
	}
}
