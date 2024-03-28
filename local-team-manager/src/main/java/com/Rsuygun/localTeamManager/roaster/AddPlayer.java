package com.Rsuygun.localTeamManager.roaster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AddPlayer {
	private List<Player> playerList;
	private int nextPlayerId;

	public AddPlayer(List<Player> playerList) {
		this.playerList = playerList;
		// playerList'deki oyuncuların ID'lerini kontrol ederek
		// nextPlayerId değerini ayarla
		determineNextPlayerId();
	}

	public void addPlayer(String name, String surname, String birthDate, String nationality, String position,
			double marketValue) {
		Player player = new Player(nextPlayerId, name, surname, birthDate, nationality, position, marketValue);
		playerList.add(player);
		nextPlayerId++;
		System.out.println("\nThe player has been added successfully.\n");

		// Oyuncunun bilgilerini dosyaya kaydetme
		savePlayerToFile(player);
	}

	private void determineNextPlayerId() {
		// Dosyadan en büyük ID değerini bul
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
