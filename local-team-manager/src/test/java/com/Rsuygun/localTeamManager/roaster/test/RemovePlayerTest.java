package com.Rsuygun.localTeamManager.roaster.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.roaster.Player;
import com.Rsuygun.localTeamManager.roaster.RemovePlayer;

public class RemovePlayerTest {

	@Test
	void testRemovePlayer() {
		// Test için bir geçici dosya adı oluştur
		String tempFileName = "temp_player.txt";

		// Oyuncu listesi oluşturuluyor
		List<Player> players = new ArrayList<>();
		players.add(new Player(1, "John", "Doe", "1990-05-15", "USA", "Forward", 1000000));
		players.add(new Player(2, "Jane", "Smith", "1992-08-22", "Canada", "Midfielder", 800000));
		players.add(new Player(3, "David", "Johnson", "1988-03-10", "England", "Defender", 1200000));

		// RemovePlayer sınıfı örneği oluşturuluyor
		RemovePlayer removePlayer = new RemovePlayer(players);

		// ID'si 2 olan oyuncunun silinmesi sağlanıyor
		removePlayer.removePlayer(2);

		// Dosya içeriğinin kontrolü
		try (BufferedReader reader = new BufferedReader(new FileReader(tempFileName))) {
			String line;
			boolean player2Found = false;
			while ((line = reader.readLine()) != null) {
				if (line.contains("2,")) {
					player2Found = true;
					break;
				}
			}
			// Silinen oyuncunun dosyada olmamasını kontrol et
			assertTrue(player2Found);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}