package com.Rsuygun.localTeamManager.scheduler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ViewSchedule {
    private List<Game> games;

    public ViewSchedule() {
        this.games = new ArrayList<>();
    }
    
    public List<Game> getGames() {
        return games;
    }

    public void loadGamesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]); // ID değerini ekleyelim
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(parts[1]); // Tarih indeksi 1 oldu
                String time = parts[2];
                String location = parts[3];
                String opponent = parts[4];
                Game game = new Game(id, date, time, location, opponent);
                games.add(game);
            }
        } catch (IOException | ParseException e) {
        } 
    }

    public void displaySchedule() {
        System.out.println("Match Schedule:");
        System.out.println("ID\tDate\t\tHour\tLocation\t\tOpponent Team");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Yeni tarih formatı
        for (Game game : games) {
            System.out.println(game.getId() + "\t" + dateFormat.format(game.getDate()) + "\t" + game.getTime() + "\t" +
                               game.getLocation() + "\t" + game.getOpponent());
        }
    }
    
    
    
    
    
    
    private static final String GAME_FILE = "game.txt";

	public static void setReminders() {
		System.out.println("Upcoming Matches : ");

		try (BufferedReader reader = new BufferedReader(new FileReader(GAME_FILE))) {
			String line;
			List<String> reminders = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				String[] gameInfo = line.split(",");
				String gameId = gameInfo[0];
				String gameDate = gameInfo[1];
				String gameHour = gameInfo[2];
				String gameLocation = gameInfo[2];
				String gameOpponent = gameInfo[2];
				
					LocalDate gameDatee = LocalDate.parse(gameDate);
					LocalDate today = LocalDate.now();
					LocalDate oneWeekFromNow = today.plusWeeks(1); // Calculate one week from now
					if (gameDatee.isAfter(today) && gameDatee.isBefore(oneWeekFromNow)) {
						reminders.add("Game Id" + gameId + "Game Date:" + gameDate + "Game Hour:" + gameHour + gameLocation + gameOpponent);
					}
				
			}

			if (reminders.isEmpty()) {
				System.out.println("No upcoming Game reminders within one week.");
			} else {
				for (String reminder : reminders) {
					System.out.println(reminder);
				}
			}
		} catch (IOException e) {
		}
	} 
    }

