package com.Rsuygun.localTeamManager.authentication.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Rsuygun.localTeamManager.authentication.User;

public class UserTest {

    @Test
    public void testUserConstructorAndGetters() {
        String username = "testuser";
        String password = "testpassword";
        User user = new User(username, password);

        assertEquals("Username should match", username, user.getUsername());
        assertEquals("Password should match", password, user.getPassword());
    }
}
