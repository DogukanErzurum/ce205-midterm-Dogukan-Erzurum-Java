package com.Rsuygun.localTeamManager.communication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SendMessage {
    public void sendMessageToPlayer(int playerId, String message) {
        // Oyuncuya mesaj gönderme
        try {
            // Oyuncunun bilgilerini player.txt dosyasından oku
            String playerName = "";
            String playerSurname = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("player.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0]);
                    if (id == playerId) {
                        playerName = parts[1];
                        playerSurname = parts[2];
                        break;
                    }
                }
            }

            // Eğer oyuncu bulunamadıysa hata mesajı göster
            if (playerName.isEmpty()) {
                return;
            }

            // Mesajı userMessage.txt dosyasına kaydet
            try (PrintWriter writer = new PrintWriter(new FileWriter("userMessage.txt", true))) {
                writer.print("Player ID: " + playerId + ", ");
                writer.print("Player Name: " + playerName + ", ");
                writer.print("Player Surname: " + playerSurname + ", ");
                writer.print("Message: " + message + "\n"); // Satır sonu karakteri elle ekleniyor
            }

            System.out.println("\nThe message was sent successfully.\n");
        } catch (IOException | NumberFormatException e) {
        }
    }
}
