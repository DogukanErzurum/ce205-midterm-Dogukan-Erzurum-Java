package com.Rsuygun.localTeamManager.tracker.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.tracker.RecordStatistics;

public class RecordStatisticsTest {

    private RecordStatistics recordStatistics;
    private File playerFile;

    @BeforeEach
    public void setUp() {
        recordStatistics = new RecordStatistics();
        playerFile = new File("player.txt");

        try (PrintWriter writer = new PrintWriter(playerFile)) {
            writer.println("1,John,Doe,1990-05-15,USA,Forward,1000000.0");
            writer.println("3,David,Johnson,1988-03-10,England,Defender,1200000.0");
            writer.println("4,John,Doe,1990-05-15,USA,Forward,1000000.0");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddStatistics() {

        int goals = 10;
        int assists = 5;
        int yellowCards = 2;
        int redCards = 1;
        recordStatistics.addStatistics(1, goals, assists, yellowCards, redCards);
        recordStatistics.addStatistics(3, goals, assists, yellowCards, redCards);
        recordStatistics.addStatistics(4, goals, assists, yellowCards, redCards);

        try (BufferedReader reader = new BufferedReader(new FileReader(playerFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                assertEquals(11, parts.length); 
                int playerId = Integer.parseInt(parts[0]);
                assertEquals(goals, Integer.parseInt(parts[7]));
                assertEquals(assists, Integer.parseInt(parts[8]));
                assertEquals(yellowCards, Integer.parseInt(parts[9]));
                assertEquals(redCards, Integer.parseInt(parts[10]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
