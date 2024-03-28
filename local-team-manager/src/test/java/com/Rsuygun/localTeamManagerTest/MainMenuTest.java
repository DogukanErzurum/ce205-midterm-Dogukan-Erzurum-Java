package com.Rsuygun.localTeamManagerTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Rsuygun.localTeamManager.MainMenu;


public class MainMenuTest {
    
    private InputStream sysInBackup;

    @BeforeEach
    public void setUpStreams() {
        sysInBackup = System.in; 
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(sysInBackup); 
    }

    @Test
    void main_RegisterCase_SuccessfulRegistration() {

        String input = "1\ntestUser\ntestPassword\n5"; 
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> MainMenu.main(new String[0]));
    }

    @Test
    void main_LoginCase_SuccessfulLogin() {

        String input = "2\ntestUser\ntestPassword\n5"; 
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> MainMenu.main(new String[0]));
    }

    @Test
    void main_AdminLoginCase_SuccessfulAdminLogin() {

        String input = "3\nadmin\nadminPassword\n5"; 
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> MainMenu.main(new String[0]));
    }
}