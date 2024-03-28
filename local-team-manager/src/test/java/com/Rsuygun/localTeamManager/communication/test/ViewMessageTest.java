package com.Rsuygun.localTeamManager.communication.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.communication.ViewMessage;

public class ViewMessageTest {
	private static final String TEST_MESSAGE_FILE = "userMessage.txt";

	@Test
    public void testDisplayAllMessages() {
        // ViewMessage nesnesini oluşturalım
        ViewMessage viewer = new ViewMessage();

        // Tüm mesajları ekrana yazdıralım
        viewer.displayAllMessages();

        // Ekrana yazdırılan mesajların doğru olduğunu kontrol edelim
        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_MESSAGE_FILE))) {
            String line = reader.readLine();
            assertTrue(line.contains("Player ID: 1"));
            assertTrue(line.contains("Player Name: John"));
            assertTrue(line.contains("Player Surname: Doe"));
            assertTrue(line.contains("Message: Test message"));
        } catch (IOException e) {
        }
    }
}
