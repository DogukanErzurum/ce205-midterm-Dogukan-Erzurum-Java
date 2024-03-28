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
        // Doğru kullanıcı adı ve parola ile giriş yapılırsa başarılı olmalıdır
        assertTrue(login.loginUser("testUser", "testPassword"));
    }

    @Test
    public void testLoginUser_IncorrectUsername() {
        // Yanlış kullanıcı adı ile giriş yapılırsa başarısız olmalıdır
        assertFalse(login.loginUser("wrongusername", "password1"));
    }

    @Test
    public void testLoginUser_IncorrectPassword() {
        // Yanlış parola ile giriş yapılırsa başarısız olmalıdır
        assertFalse(login.loginUser("user1", "wrongpassword"));
    }

    @Test
    public void testLoginUser_NullCredentials() {
        // Kullanıcı bilgileri yüklenemediğinde giriş başarısız olmalıdır
        Login loginWithNullCredentials = new Login();
        assertFalse(loginWithNullCredentials.loginUser("user1", "password1"));
    }
}
