package com.Rsuygun.localTeamManager.scheduler;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemoveGame {
    private List<Game> games;

    public RemoveGame() {
        this.games = new ArrayList<>();
    }

    public void removeGame(int gameId) {
        loadGamesFromFile(); // Dosyadan oyunları belleğe yükle
        games.removeIf(game -> game.getId() == gameId); // ID'ye göre oyunu kaldır
        saveGamesToFile(); // Güncellenmiş oyun listesini dosyaya kaydet
    }

    private void loadGamesFromFile() {
        games.clear(); // Var olan oyunları temizle
        try (BufferedReader reader = new BufferedReader(new FileReader("game.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date gameDate = dateFormat.parse(parts[1] + " " + parts[2]);
                    String location = parts[3];
                    String opponent = parts[4];
                    Game game = new Game(id, gameDate, parts[2], location, opponent);
                    games.add(game);
                }
            }
        } catch (IOException | java.text.ParseException e) {
    }
    }

    private void saveGamesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt"))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
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
