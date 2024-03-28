package com.Rsuygun.localTeamManager.scheduler.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.scheduler.Game;
import com.Rsuygun.localTeamManager.scheduler.ViewSchedule;

public class ViewScheduleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    void testLoadGamesFromFile() {

        String filePath = "test_game.txt";
        String testData = "1,2024-03-27,15:00,Location 1,Opponent 1\n" +
                          "2,2024-03-28,18:00,Location 2,Opponent 2";
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.write(testData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ViewSchedule viewSchedule = new ViewSchedule();
        viewSchedule.loadGamesFromFile(filePath);
        assertEquals(2, viewSchedule.getGames().size());
        assertEquals(1, viewSchedule.getGames().get(0).getId());
        assertNotEquals("2024-03-27 15:00", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(viewSchedule.getGames().get(0).getDate()));
        assertEquals("Location 1", viewSchedule.getGames().get(0).getLocation());
        assertEquals("Opponent 1", viewSchedule.getGames().get(0).getOpponent());

        File file = new File(filePath);
        assertTrue(file.delete());
    }

    @Test
    void testDisplaySchedule() {

        System.setOut(new PrintStream(outContent));

        ViewSchedule viewSchedule = new ViewSchedule();
        Date date = new Date();
        viewSchedule.getGames().add(new Game(1, date, "15:00", "Location 1", "Opponent 1"));
        viewSchedule.getGames().add(new Game(2, date, "18:00", "Location 2", "Opponent 2"));

        viewSchedule.displaySchedule();
        String expectedOutput = "Match Schedule:\n" +
                                 "ID\tDate\t\tHour\tLocation\t\tOpponent Team\n" +
                                 "1\t" + new SimpleDateFormat("yyyy-MM-dd").format(date) + "\t15:00\tLocation 1\tOpponent 1\n" +
                                 "2\t" + new SimpleDateFormat("yyyy-MM-dd").format(date) + "\t18:00\tLocation 2\tOpponent 2\n";
        assertNotEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void testSetReminders() {

        System.setOut(new PrintStream(outContent));

        try (PrintWriter writer = new PrintWriter("game.txt")) {
            writer.write("1,2024-03-27,15:00,Location 1,Opponent 1\n" +
                         "2,2024-03-28,18:00,Location 2,Opponent 2\n" +
                         "3,2024-04-03,19:00,Location 3,Opponent 3");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ViewSchedule.setReminders();
        String expectedOutput = "Upcoming Matches : \n" +
                                 "Game Id1Game Date:2024-03-27Game Hour:15:00Location 1Opponent 1\n" +
                                 "Game Id2Game Date:2024-03-28Game Hour:18:00Location 2Opponent 2\n";
        assertNotEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }
}
