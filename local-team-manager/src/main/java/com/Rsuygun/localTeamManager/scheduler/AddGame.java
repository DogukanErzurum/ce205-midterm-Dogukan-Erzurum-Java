package com.Rsuygun.localTeamManager.scheduler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AddGame {
    private List<Game> games;
    private int lastGameId; // Son kullanılan oyun ID'si

    public AddGame() {
        this.games = new ArrayList<>();
        this.lastGameId = 0; // Başlangıç değeri
    }

    public void addGame(Date date, String time, String location) {
        String opponent = generateRandomOpponent(); // Random rakip oluştur
        lastGameId++; // Yeni bir oyun eklediğinizde ID artırılır
        Game game = new Game(lastGameId, date, time, location, opponent); // Oyunu ID ile oluştur
        games.add(game);
        saveGamesToFile();
    }

    private String generateRandomOpponent() {
        String[] opponents = {"Team A", "Team B", "Team C", "Team D", "Team E"}; // Örnek rakip takımlar
        Random random = new Random();
        int index = random.nextInt(opponents.length);
        return opponents[index];
    }

    public List<Game> getGames() {
        return games;
    }

    private void saveGamesToFile() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt", true))) { // Dosyaya eklemek için true parametresi kullanılır
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
