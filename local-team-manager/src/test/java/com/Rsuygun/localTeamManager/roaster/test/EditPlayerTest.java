package com.Rsuygun.localTeamManager.roaster.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.roaster.EditPlayer;
import com.Rsuygun.localTeamManager.roaster.Player;

public class EditPlayerTest {

    private static final String TEST_FILE_NAME = "player.txt";

    @Test
    void testEditPlayer() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "John", "Doe", "1990-05-15", "USA", "Forward", 1000000.0));
        players.add(new Player(3, "David", "Johnson", "1988-03-10", "England", "Defender", 1200000.0));
        players.add(new Player(4, "John", "Doe", "1990-05-15", "USA", "Forward", 1000000.0));

        EditPlayer editPlayer = new EditPlayer(players);

        editPlayer.editPlayer(1, "Michael", "Jordan", "1963-02-17", "USA", "Guard", 5000000.0);

        List<Player> updatedPlayers = readPlayersFromFile(TEST_FILE_NAME);

        assertEquals("Michael", updatedPlayers.get(0).getName());
        assertEquals("Jordan", updatedPlayers.get(0).getSurname());
        assertEquals("1963-02-17", updatedPlayers.get(0).getBirthDate());
        assertEquals("USA", updatedPlayers.get(0).getNationality());
        assertEquals("Guard", updatedPlayers.get(0).getPosition());
        assertEquals(5000000.0, updatedPlayers.get(0).getMarketValue());
    }

    private List<Player> readPlayersFromFile(String fileName) {
        List<Player> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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
                players.add(new Player(id, name, surname, birthDate, nationality, position, marketValue));
            }
        } catch (IOException e) {
        }
        return players;
    }
}
