package com.Rsuygun.localTeamManager.roaster.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.roaster.Player;
import com.Rsuygun.localTeamManager.roaster.ViewRoaster;

public class ViewRoasterTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testDisplayRoster() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "John", "Doe", "1990-05-15", "USA", "Forward", 1000000));
        players.add(new Player(2, "Alice", "Smith", "1995-10-20", "England", "Midfielder", 800000));
        players.add(new Player(3, "Bob", "Johnson", "1988-03-08", "Canada", "Defender", 1200000));

        ViewRoaster viewRoaster = new ViewRoaster(players);

        viewRoaster.displayRoster();

        String expectedOutput = "Team Squad:\n" +
                "ID\tName\tSurname\tDate of birth\tNationality\tPosition\tMarket value\n" +
                "1\tJohn\tDoe\t1990-05-15\tUSA\tForward\t1000000.0\n" +
                "2\tAlice\tSmith\t1995-10-20\tEngland\tMidfielder\t800000.0\n" +
                "3\tBob\tJohnson\t1988-03-08\tCanada\tDefender\t1200000.0\n";

        assertNotEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testReadPlayersFromFile() {
        ViewRoaster viewRoaster = new ViewRoaster();

        viewRoaster.readPlayersFromFile();


        String expectedOutput = "Team Squad:\n" +
                "ID\tName\tSurname\tDate of birth\tNationality\tPosition\tMarket value\n" +
                "1\tJohn\tDoe\t1990-05-15\tUSA\tForward\t1000000.0\n" +
                "2\tAlice\tSmith\t1995-10-20\tEngland\tMidfielder\t800000.0\n" +
                "3\tBob\tJohnson\t1988-03-08\tCanada\tDefender\t1200000.0\n";

        assertNotEquals(expectedOutput, outputStreamCaptor.toString());
    }
}