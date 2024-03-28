package com.Rsuygun.localTeamManager.tracker.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.Rsuygun.localTeamManager.tracker.ViewPlayerStats;

public class ViewPlayerStatsTest {

    private ViewPlayerStats viewPlayerStats;
    private File playerFile;

    @BeforeEach
    public void setUp() {
        viewPlayerStats = new ViewPlayerStats();
        playerFile = new File("player.txt");
        try (PrintWriter writer = new PrintWriter(playerFile)) {
            writer.println("1,John,Doe,1990-05-15,USA,Forward,1000000.0,10,5,2,1");
            writer.println("3,David,Johnson,1988-03-10,England,Defender,1200000.0,10,5,2,1");
            writer.println("4,John,Doe,1990-05-15,USA,Forward,1000000.0,10,5,2,1");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDisplayPlayerStats() {

        int playerId = 1;

        viewPlayerStats.displayPlayerStats(playerId);

        try (BufferedReader reader = new BufferedReader(new FileReader(playerFile))) {
            String line;
            boolean playerFound = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                if (id == playerId) {
                    playerFound = true;
                    assertEquals(11, parts.length); 
                    assertEquals("1", parts[0]);
                    assertEquals("John", parts[1]); 
                    assertEquals("Doe", parts[2]); 
                    assertEquals("10", parts[7]);
                    assertEquals("5", parts[8]); 
                    assertEquals("2", parts[9]); 
                    assertEquals("1", parts[10]); 
                    break;
                }
            }

            assertTrue(playerFound, "Specified player not found in the file");
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred while reading player file");
        }
    }
}
