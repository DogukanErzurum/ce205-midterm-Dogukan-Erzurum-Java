package com.Rsuygun.localTeamManager.scheduler.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Rsuygun.localTeamManager.scheduler.AddGame;
import com.Rsuygun.localTeamManager.scheduler.Game;

public class AddGameTest {
    private AddGame addGame;

    @Before
    public void setUp() {
        addGame = new AddGame();
    }

    @Test
    public void testAddMultipleGames() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date1 = new java.util.Date();
        Date date2 = new java.util.Date(date1.getTime() + 3600 * 1000); 
        Date date3 = new java.util.Date(date2.getTime() + 3600 * 1000); 

        String time = "15:00";
        String location = "Stadium";

        addGame.addGame(date1, time, location);

        addGame.addGame(date2, time, location);
        
        addGame.addGame(date3, time, location);

        List<Game> games = addGame.getGames();
        assertEquals("Three games should be added to the list", 3, games.size());


        assertEquals(false, isGameInfoSavedToFile(1, dateFormat.format(date1), time, location));
        assertEquals(false, isGameInfoSavedToFile(2, dateFormat.format(date2), time, location));
        assertEquals(false, isGameInfoSavedToFile(3, dateFormat.format(date3), time, location));
    }




    private boolean isGameInfoSavedToFile(int id, String date, String time, String location) {
 
        String gameInfoToFind = id + "," + date + "," + time + "," + location;

        try (BufferedReader reader = new BufferedReader(new FileReader("game.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.trim().equals(gameInfoToFind)) {
                    return true; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}

