package com.Rsuygun.localTeamManager.scheduler;

import java.util.Date;

public class Game {
    private int id;
    private Date date;
    private String time;
    private String location;
    private String opponent;

    public Game(int id, Date date, String time, String location, String opponent) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.location = location;
        this.opponent = opponent;
    }

    // Getter metotları
    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getOpponent() {
        return opponent;
    }

    // Setter metotları
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
}
