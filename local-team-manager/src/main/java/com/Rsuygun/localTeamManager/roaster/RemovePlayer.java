package com.Rsuygun.localTeamManager.roaster;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * The RemovePlayer class facilitates removing players from the roster.
 */
public class RemovePlayer {
	private List<Player> players;

	/**
	 * Constructs a RemovePlayer object with the given list of players.
	 * 
	 * @param players The list of players from which players can be removed.
	 */
	public RemovePlayer(List<Player> players) {
		this.players = players;
	}

	/**
	 * Removes the player with the specified ID from the roster.
	 * 
	 * @param id The ID of the player to be removed.
	 */
	public void removePlayer(int id) {
		for (Player player : players) {
			if (player.getId() == id) {
				players.remove(player);
				System.out.println("\nThe player has been successfully deleted.\n");
				updateFile();
				return;
			}
		}
		System.out.println("\nNo player with the specified ID was found.\n");
	}

	/**
	 * Updates the file containing player information after a player is removed.
	 */
	private void updateFile() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("player.txt"))) {
			for (Player player : players) {
				writer.println(player.getId() + "," + player.getName() + "," + player.getSurname() + ","
						+ player.getBirthDate() + "," + player.getNationality() + "," + player.getPosition() + ","
						+ player.getMarketValue());
			}
		} catch (IOException e) {
		}
	}
}
