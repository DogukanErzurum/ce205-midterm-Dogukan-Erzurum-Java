package com.Rsuygun.localTeamManager.communication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewMessage {
	public void displayAllMessages() {
		// Bütün mesajları userMessage.txt dosyasından okuyarak ekrana yazdırma
		try (BufferedReader reader = new BufferedReader(new FileReader("userMessage.txt"))) {
			String line;
			System.out.println("\nSent Messages:");

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
		}
	}
}
