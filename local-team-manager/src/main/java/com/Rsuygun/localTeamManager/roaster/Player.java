package com.Rsuygun.localTeamManager.roaster;

/**
 * The Player class represents a player in a team roster.
 */
public class Player {
    private int id;
    private String name;
    private String surname;
    private String birthDate;
    private String nationality;
    private String position;
    private double marketValue;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;

    /**
     * Constructs a Player object with the specified details.
     * 
     * @param id The ID of the player.
     * @param name The name of the player.
     * @param surname The surname of the player.
     * @param birthDate The birth date of the player.
     * @param nationality The nationality of the player.
     * @param position The playing position of the player.
     * @param marketValue The market value of the player.
     */
    public Player(int id, String name, String surname, String birthDate, String nationality, String position,
            double marketValue) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.position = position;
        this.marketValue = marketValue;
    }

    // Getters and setters for player attributes

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
}
