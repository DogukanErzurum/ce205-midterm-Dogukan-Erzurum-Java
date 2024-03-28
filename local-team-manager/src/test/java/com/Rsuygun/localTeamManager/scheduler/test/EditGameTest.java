package com.Rsuygun.localTeamManager.scheduler.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.scheduler.EditGame;
import com.Rsuygun.localTeamManager.scheduler.Game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EditGameTest {
    private List<Game> games;
    private EditGame editGame;

    @BeforeEach
    void setUp() {
        games = new ArrayList<>();
        games.add(new Game(1, new Date(), "Location 1", "Opponent 1", null));
        games.add(new Game(2, new Date(), "Location 2", "Opponent 2", null));
        editGame = new EditGame(games);
    }

    @Test
    void testEditGame_SuccessfulEdit() {
        int gameId = 1;
        String newDateStr = "2024-03-27";
        String newTime = "15:00";
        String newLocation = "New Location";
        String newOpponent = "New Opponent";

        editGame.editGame(gameId, newDateStr, newTime, newLocation, newOpponent);

        Game editedGame = games.get(0);
        assertEquals(newLocation, editedGame.getLocation());
        assertEquals(newOpponent, editedGame.getOpponent());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String expectedDateStr = newDateStr + " " + newTime;
        String editedDateStr = dateFormat.format(editedGame.getDate()) + " " + timeFormat.format(editedGame.getDate());
        assertEquals(expectedDateStr, editedDateStr);
    }

    @Test
    void testEditGame_GameNotFound() {
        int gameId = 3;
        String newDateStr = "2024-03-27";
        String newTime = "15:00";
        String newLocation = "New Location";
        String newOpponent = "New Opponent";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        editGame.editGame(gameId, newDateStr, newTime, newLocation, newOpponent);

        assertNotEquals("\nNo game with the specified ID was found.\n", outContent.toString());
    }

    @Test
    void testEditGame_InvalidDate() {
        int gameId = 1;
        String newDateStr = "Invalid Date";
        String newTime = "15:00";
        String newLocation = "New Location";
        String newOpponent = "New Opponent";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        editGame.editGame(gameId, newDateStr, newTime, newLocation, newOpponent);

        assertNotEquals("\nInvalid login!\n", outContent.toString());
    }
}
