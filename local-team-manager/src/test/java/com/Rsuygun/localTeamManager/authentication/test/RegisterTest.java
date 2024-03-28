package com.Rsuygun.localTeamManager.authentication.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.Rsuygun.localTeamManager.authentication.Register;

public class RegisterTest {
    private Register register;

    @Before
    public void setUp() {
        register = new Register();
    }

    @Test
    public void testRegisterUser() {
        String username = "testUser";
        String password = "testPassword";
        
        boolean result = register.registerUser(username, password);
        
        assertTrue(result);
        
        // Dosyayı kontrol et
        try (BufferedReader reader = new BufferedReader(new FileReader(Register.USER_FILE))) {
            String line = reader.readLine();
            assertNotNull(line);
            assertEquals("testUser,testPassword", line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
