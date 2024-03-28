package com.Rsuygun.localTeamManager.scheduler;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EditGame {
    private List<Game> games;

    public EditGame(List<Game> games) {
        this.games = games;
    }

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

                    saveGamesToFile(); // Oyunları dosyaya kaydet

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

    private void saveGamesToFile() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt"))) {
            for (Game game : games) {
                String dateStr = dateFormat.format(game.getDate());
                String timeStr = timeFormat.format(game.getDate());
                writer.write(game.getId() + "," + dateStr + "," + timeStr + "," + game.getLocation() + "," + game.getOpponent());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
        }
    }
}
