package com.Rsuygun.localTeamManager.scheduler;

import java.util.Date;

/**
 * The Game class represents individual games in a team's schedule.
 */
public class Game {
    private int id;
    private Date date;
    private String time;
    private String location;
    private String opponent;

    /**
     * Constructs a game with a specific date, time, location, and opponent.
     *
     * @param id       The ID of the game.
     * @param date     The date of the game.
     * @param time     The time of the game.
     * @param location The location where the game will take place.
     * @param opponent The name of the opposing team.
     */
    public Game(int id, Date date, String time, String location, String opponent) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.location = location;
        this.opponent = opponent;
    }

    /**
     * Gets the ID of the game.
     *
     * @return The ID of the game.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the date of the game.
     *
     * @return The date of the game.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the time of the game.
     *
     * @return The time of the game.
     */
    public String getTime() {
        return time;
    }

    /**
     * Gets the location of the game.
     *
     * @return The location of the game.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the opponent team's name.
     *
     * @return The opponent team's name.
     */
    public String getOpponent() {
        return opponent;
    }

    /**
     * Sets the ID of the game.
     *
     * @param id The new ID of the game.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the date of the game.
     *
     * @param date The new date of the game.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the time of the game.
     *
     * @param time The new time of the game.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Sets the location of the game.
     *
     * @param location The new location of the game.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the opponent team's name.
     *
     * @param opponent The new opponent team's name.
     */
    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
}
