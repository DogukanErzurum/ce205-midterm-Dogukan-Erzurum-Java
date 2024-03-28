package com.Rsuygun.localTeamManager.scheduler.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.scheduler.Game;
import com.Rsuygun.localTeamManager.scheduler.RemoveGame;

public class RemoveGameTest {
    private RemoveGame removeGame;
    private List<Game> games;

    @BeforeEach
    void setUp() {
        games = new ArrayList<>();
        games.add(new Game(1, new Date(), "12:00", "Location 1", "Opponent 1"));
        games.add(new Game(2, new Date(), "15:00", "Location 2", "Opponent 2"));
        removeGame = new RemoveGame();
    }

    @Test
    void testRemoveGame_SuccessfulRemoval() {

        int gameIdToRemove = 1;
        saveGamesToFile(games);

        removeGame.removeGame(gameIdToRemove);

        List<Game> updatedGames = loadGamesFromFile();

        assertFalse(updatedGames.stream().anyMatch(game -> game.getId() == gameIdToRemove));
    }

    @Test
    void testRemoveGame_FileWriteError() {

        removeGame = new RemoveGame() {
            protected void saveGamesToFile() {
                throw new RuntimeException("Error writing to file");
            }
        };


        assertThrows(RuntimeException.class, () -> removeGame.removeGame(1));
    }

    private void saveGamesToFile(List<Game> games) {
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
            e.printStackTrace();
        }
    }

    private List<Game> loadGamesFromFile() {
        List<Game> loadedGames = new ArrayList<>();
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
                    loadedGames.add(game);
                }
            }
        } catch (IOException | java.text.ParseException e) {
            e.printStackTrace();
        }
        return loadedGames;
    }
}
