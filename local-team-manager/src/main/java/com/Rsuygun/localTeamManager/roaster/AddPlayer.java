package com.Rsuygun.localTeamManager.roaster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * The AddPlayer class facilitates adding new players to the roster.
 */
public class AddPlayer {
	private List<Player> playerList;
	private int nextPlayerId;

	/**
	 * Constructs an AddPlayer object with the given player list.
	 * 
	 * @param playerList The list of players to which new players will be added.
	 */
	public AddPlayer(List<Player> playerList) {
		this.playerList = playerList;
		determineNextPlayerId();
	}

	/**
	 * Adds a new player to the roster with the provided details.
	 * 
	 * @param name        The name of the player.
	 * @param surname     The surname of the player.
	 * @param birthDate   The birth date of the player.
	 * @param nationality The nationality of the player.
	 * @param position    The position of the player.
	 * @param marketValue The market value of the player.
	 */
	public void addPlayer(String name, String surname, String birthDate, String nationality, String position,
			double marketValue) {
		Player player = new Player(nextPlayerId, name, surname, birthDate, nationality, position, marketValue);
		playerList.add(player);
		nextPlayerId++;
		System.out.println("\nThe player has been added successfully.\n");

		savePlayerToFile(player);
	}

	/**
	 * Determines the next player ID based on the existing players in the roster.
	 */
	private void determineNextPlayerId() {
		try (BufferedReader reader = new BufferedReader(new FileReader("player.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
				nextPlayerId = Math.max(nextPlayerId, id + 1);
			}
		} catch (IOException | NumberFormatException e) {
		}
	}

	/**
	 * Saves the details of the added player to a file.
	 * 
	 * @param player The player whose details will be saved.
	 */
	private void savePlayerToFile(Player player) {
		String fileName = "player.txt";
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
			writer.println(player.getId() + "," + player.getName() + "," + player.getSurname() + ","
					+ player.getBirthDate() + "," + player.getNationality() + "," + player.getPosition() + ","
					+ player.getMarketValue());
		} catch (IOException e) {
		}
	}
}
