package com.Rsuygun.localTeamManager.roaster;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EditPlayer {

    private List<Player> playerList;

    public EditPlayer(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void editPlayer(int editPlayerId, String newPlayerName, String newPlayerSurname, String newPlayerBirthDate, String newPlayerNationality, String newPlayerPosition, double newPlayerMarketValue) {
        // Oyuncuyu bul ve düzenle
        for (Player player : playerList) {
            if (player.getId() == editPlayerId) {
                player.setName(newPlayerName);
                player.setSurname(newPlayerSurname);
                player.setBirthDate(newPlayerBirthDate);
                player.setNationality(newPlayerNationality);
                player.setPosition(newPlayerPosition);
                player.setMarketValue(newPlayerMarketValue);
                System.out.println("\nThe player has been successfully edited.\n");
                
                // Oyuncu bilgilerini dosyaya kaydetme
                savePlayersToFile(playerList);
                return;
            }
        }
        System.out.println("\nNo player with the specified ID was found.\n");
    }

    private void savePlayersToFile(List<Player> playerList) {
        String fileName = "player.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Player player : playerList) {
                writer.println(player.getId() + "," + player.getName() + "," + player.getSurname() + "," +
                        player.getBirthDate() + "," + player.getNationality() + "," +
                        player.getPosition() + "," + player.getMarketValue());
            }
        } catch (IOException e) {
        }
    }
}
