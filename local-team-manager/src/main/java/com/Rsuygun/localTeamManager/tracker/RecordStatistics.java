package com.Rsuygun.localTeamManager.tracker;

import java.io.*;
import java.util.List;
import com.Rsuygun.localTeamManager.roaster.Player;

/**
 * @brief Class for recording statistics of players.
 */
public class RecordStatistics {
	
	/**
     * @brief Adds statistics for a player.
     * 
     * This method updates the statistics of a player in the player.txt file.
     * 
     * @param playerId The ID of the player.
     * @param goals The number of goals scored by the player.
     * @param assists The number of assists made by the player.
     * @param yellowCards The number of yellow cards received by the player.
     * @param redCards The number of red cards received by the player.
     */
	public void addStatistics(int playerId, int goals, int assists, int yellowCards, int redCards) {

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

					String updatedLine = line + "," + goals + "," + assists + "," + yellowCards + "," + redCards;
					writer.write(updatedLine + System.getProperty("line.separator"));
				} else {

					writer.write(line + System.getProperty("line.separator"));
				}
			}

			writer.close();
			reader.close();

			if (!inputFile.delete()) {
				return;
			}
			if (!tempFile.renameTo(inputFile)) {
			}
		} catch (IOException | NumberFormatException e) {
		}
	}
}
