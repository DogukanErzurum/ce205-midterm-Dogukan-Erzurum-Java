package com.Rsuygun.localTeamManager.tracker.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.Rsuygun.localTeamManager.tracker.ViewTeamStats;

public class ViewTeamStatsTest {

    @Test
    public void testDisplayTeamStats() {

        String testFileContent = "1,John,Doe,1990-05-15,USA,Forward,1000000.0,10,5,2,1\n" +
                "3,David,Johnson,1988-03-10,England,Defender,1200000.0,10,5,2,1\n" +
                "4,John,Doe,1990-05-15,USA,Forward,1000000.0,10,5,2,1\n";

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        ViewTeamStats viewTeamStats = new ViewTeamStats();
        viewTeamStats.displayTeamStats();

        String expectedOutput = "Team Statistics:\r\n" +
                "Player ID: 1\r\n" +
                "Name: John\r\n" +
                "Surname: Doe\r\n" +
                "Number of Goals: 10\r\n" +
                "Number of Assists: 5\r\n" +
                "Number of Yellow Cards: 2\r\n" +
                "Number of Red Cards: 1\r\n" +
                "\r\n" +
                "Player ID: 3\r\n" +
                "Name: David\r\n" +
                "Surname: Johnson\r\n" +
                "Number of Goals: 10\r\n" +
                "Number of Assists: 5\r\n" +
                "Number of Yellow Cards: 2\r\n" +
                "Number of Red Cards: 1\r\n" +
                "\r\n" +
                "Player ID: 4\r\n" +
                "Name: John\r\n" +
                "Surname: Doe\r\n" +
                "Number of Goals: 10\r\n" +
                "Number of Assists: 5\r\n" +
                "Number of Yellow Cards: 2\r\n" +
                "Number of Red Cards: 1\r\n" +
                "\r\n" +
                "Total Number of Goals: 30\r\n" +
                "Total Number of Assists: 15\r\n" +
                "Total Number of Yellow Cards: 6\r\n" +
                "Total Number of Red Cards: 3\r\n";

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}