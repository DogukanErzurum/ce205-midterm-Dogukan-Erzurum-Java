package com.Rsuygun.localTeamManager.authentication.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Rsuygun.localTeamManager.authentication.Login;

public class LoginTest {
    private Login login;

    @Before
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testLoginUser_Successful() {
        assertTrue(login.loginUser("testUser", "testPassword"));
    }

    @Test
    public void testLoginUser_IncorrectUsername() {
        assertFalse(login.loginUser("wrongusername", "password1"));
    }

    @Test
    public void testLoginUser_IncorrectPassword() {
        assertFalse(login.loginUser("user1", "wrongpassword"));
    }

    @Test
    public void testLoginUser_NullCredentials() {
        Login loginWithNullCredentials = new Login();
        assertFalse(loginWithNullCredentials.loginUser("user1", "password1"));
    }
}
