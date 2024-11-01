package com.Rsuygun.localTeamManager.roaster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ViewRoaster class is responsible for displaying the team roster.
 */
public class ViewRoaster {
	private List<Player> players;

	/**
	 * Constructs a ViewRoaster object with an empty player list.
	 */
	public ViewRoaster() {
		this.players = new ArrayList<>();
	}

	/**
	 * Constructs a ViewRoaster object with the given player list.
	 * 
	 * @param players The list of players to be displayed.
	 */
	public ViewRoaster(List<Player> players) {
		this.players = players;
	}

	/**
	 * Displays the team roster.
	 */
	public void displayRoster() {
		System.out.println("Team Squad:");
		System.out.println("ID\tName\tSurname\tDate of birth\tNationality\tPosition\tMarket value");
		for (Player player : players) {
			System.out.println(player.getId() + "\t" + player.getName() + "\t" + player.getSurname() + "\t"
					+ player.getBirthDate() + "\t" + player.getNationality() + "\t" + player.getPosition() + "\t"
					+ player.getMarketValue());
		}
	}

	/**
	 * Reads player information from a file and populates the player list.
	 */
	public void readPlayersFromFile() {
		players.clear();

		try (BufferedReader reader = new BufferedReader(new FileReader("player.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
				String name = parts[1];
				String surname = parts[2];
				String birthDate = parts[3];
				String nationality = parts[4];
				String position = parts[5];
				double marketValue = Double.parseDouble(parts[6]);
				Player player = new Player(id, name, surname, birthDate, nationality, position, marketValue);
				players.add(player);
			}

			displayRoster();
		} catch (IOException e) {
		}
	}
}
