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
        // Admin kullanıcı adı ve parolası doğruysa başarılı bir giriş olmalıdır
        assertTrue(adminManager.loginAdmin("admin", "admin"));
    }

    @Test
    public void testLoginAdmin_IncorrectUsername() {
        // Admin kullanıcı adı yanlışsa giriş başarısız olmalıdır
        assertFalse(adminManager.loginAdmin("wrongusername", "admin123"));
    }

    @Test
    public void testLoginAdmin_IncorrectPassword() {
        // Admin parolası yanlışsa giriş başarısız olmalıdır
        assertFalse(adminManager.loginAdmin("admin", "wrongpassword"));
    }
}
