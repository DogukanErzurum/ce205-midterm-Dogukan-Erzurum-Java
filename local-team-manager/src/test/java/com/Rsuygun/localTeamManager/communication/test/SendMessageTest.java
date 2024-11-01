package com.Rsuygun.localTeamManager.communication.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.communication.SendMessage;

public class SendMessageTest {

    private static final String TEST_MESSAGE_FILE = "userMessage.txt";

    @Before

    @Test
    public void testSendMessageToPlayer() {
        int playerId = 1; 
        String message = "Test message";

        SendMessage sender = new SendMessage();

        sender.sendMessageToPlayer(playerId, message);

        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_MESSAGE_FILE))) {
            String line = reader.readLine();
            assertTrue(line.contains("Player ID: " + playerId));
            assertTrue(line.contains("Message: " + message));
        } catch (IOException e) {
        }
    }
}
