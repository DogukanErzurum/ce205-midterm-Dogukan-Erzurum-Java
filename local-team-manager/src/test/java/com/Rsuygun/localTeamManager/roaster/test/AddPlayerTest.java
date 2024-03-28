package com.Rsuygun.localTeamManager.roaster.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.Rsuygun.localTeamManager.roaster.AddPlayer;
import com.Rsuygun.localTeamManager.roaster.Player;

public class AddPlayerTest {

    private List<Player> playerList;
    private AddPlayer addPlayer;

    @Before
    public void setUp() {
        playerList = new ArrayList<>();
        addPlayer = new AddPlayer(playerList);
    }

    @Test
    public void testAddPlayer() {
        // Önceki oyuncu sayısı
        int previousSize = playerList.size();

        // Yeni oyuncu ekle
        addPlayer.addPlayer("John", "Doe", "1990-05-15", "USA", "Forward", 1000000.0);

        // Yeni oyuncu eklenmiş mi kontrol et
        assertEquals(previousSize + 1, playerList.size());

        // Dosyadan son eklenen oyuncuyu oku ve doğrula
        try (BufferedReader reader = new BufferedReader(new FileReader("player.txt"))) {
            String line;
            int lastPlayerId = -1;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                lastPlayerId = Integer.parseInt(parts[0]);
            }
            // Son oyuncu ID'si doğru mu kontrol et
            assertNotEquals(previousSize, lastPlayerId);
        } catch (IOException | NumberFormatException e) {
        }
    }
}