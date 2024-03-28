package com.Rsuygun.localTeamManager.roaster;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RemovePlayer {
    private List<Player> players;

    public RemovePlayer(List<Player> players) {
        this.players = players;
    }

    public void removePlayer(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                players.remove(player);
                System.out.println("\nThe player has been successfully deleted.\n");
                updateFile(); // Dosyayı güncelle
                return;
            }
        }
        System.out.println("\nNo player with the specified ID was found.\n");
    }

    // Oyuncu silindiği durumda dosyayı güncelleyen metot
    private void updateFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("player.txt"))) {
            for (Player player : players) {
                writer.println(player.getId() + "," + player.getName() + "," + player.getSurname() + "," +
                        player.getBirthDate() + "," + player.getNationality() + "," + player.getPosition() + "," +
                        player.getMarketValue());
            }
        } catch (IOException e) {
        }
    }
}
