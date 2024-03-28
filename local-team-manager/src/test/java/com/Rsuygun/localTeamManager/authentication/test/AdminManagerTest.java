package com.Rsuygun.localTeamManager.authentication.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Rsuygun.localTeamManager.authentication.AdminManager;

public class AdminManagerTest {
    private AdminManager adminManager;

    @Before
    public void setUp() {
        adminManager = new AdminManager();
    }

    @Test
    public void testLoginAdmin_Successful() {
        assertTrue(adminManager.loginAdmin("admin", "admin"));
    }

    @Test
    public void testLoginAdmin_IncorrectUsername() {
        assertFalse(adminManager.loginAdmin("wrongusername", "admin123"));
    }

    @Test
    public void testLoginAdmin_IncorrectPassword() {
        assertFalse(adminManager.loginAdmin("admin", "wrongpassword"));
    }
}
