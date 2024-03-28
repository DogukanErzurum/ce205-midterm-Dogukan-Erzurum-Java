package com.Rsuygun.localTeamManager.tracker;

import java.io.*;
import java.util.List;
import com.Rsuygun.localTeamManager.roaster.Player;

public class RecordStatistics {
	public void addStatistics(int playerId, int goals, int assists, int yellowCards, int redCards) {
		// Oyuncunun istatistiklerini player.txt dosyasına ekleme
		try {
			File inputFile = new File("player.txt");
			File tempFile = new File("tempPlayer.txt");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
				if (id == playerId) {
					// Oyuncunun satırını bulduk, istatistikleri ekle
					String updatedLine = line + "," + goals + "," + assists + "," + yellowCards + "," + redCards;
					writer.write(updatedLine + System.getProperty("line.separator"));
				} else {
					// Oyuncunun satırını bulamadık, aynen yazmaya devam et
					writer.write(line + System.getProperty("line.separator"));
				}
			}

			writer.close();
			reader.close();

			// Geçici dosyayı asıl dosya olarak değiştir
			if (!inputFile.delete()) {
				return;
			}
			if (!tempFile.renameTo(inputFile)) {
			}
		} catch (IOException | NumberFormatException e) {
		}
	}
}
