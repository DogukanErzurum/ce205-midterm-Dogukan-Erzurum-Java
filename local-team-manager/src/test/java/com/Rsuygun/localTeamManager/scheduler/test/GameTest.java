package com.Rsuygun.localTeamManager.scheduler.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.scheduler.Game;

public class GameTest {
    @Test
    void testGameConstructorAndGetters() {
        int id = 1;
        Date date = new Date();
        String time = "12:00";
        String location = "Location";
        String opponent = "Opponent";

        Game game = new Game(id, date, time, location, opponent);

        assertEquals(id, game.getId());
        assertEquals(date, game.getDate());
        assertEquals(time, game.getTime());
        assertEquals(location, game.getLocation());
        assertEquals(opponent, game.getOpponent());
    }

    @Test
    void testSetters() {
        Game game = new Game(1, new Date(), "12:00", "Location", "Opponent");

        int newId = 2;
        Date newDate = new Date();
        String newTime = "15:00";
        String newLocation = "New Location";
        String newOpponent = "New Opponent";

        game.setId(newId);
        game.setDate(newDate);
        game.setTime(newTime);
        game.setLocation(newLocation);
        game.setOpponent(newOpponent);

        assertEquals(newId, game.getId());
        assertEquals(newDate, game.getDate());
        assertEquals(newTime, game.getTime());
        assertEquals(newLocation, game.getLocation());
        assertEquals(newOpponent, game.getOpponent());
    }
}
