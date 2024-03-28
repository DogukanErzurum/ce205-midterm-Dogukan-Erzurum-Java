package com.Rsuygun.localTeamManager.roaster.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Rsuygun.localTeamManager.roaster.Player;

public class PlayerTest {

	    @Test
	    public void testPlayerConstructor() {
	        Player player = new Player(1, "Dogukan", "Erzurum", "2000-01-27", "TR", "Forward", 1000000.0);
	        assertNotNull(player);
	        assertEquals(1, player.getId());
	        assertEquals("Dogukan", player.getName());
	        assertEquals("Erzurum", player.getSurname());
	        assertEquals("2000-01-27", player.getBirthDate());
	        assertEquals("TR", player.getNationality());
	        assertEquals("Forward", player.getPosition());
	        assertEquals(1000000.0, player.getMarketValue(), 0.001);
	        assertEquals(0, player.getGoals());
	        assertEquals(0, player.getAssists());
	        assertEquals(0, player.getYellowCards());
	        assertEquals(0, player.getRedCards());
	    }

	    @Test
	    public void testSettersAndGetters() {
	        Player player = new Player(1, "Ömer", "Polat", "2002-05-15", "Germany", "Forward", 1000000.0);
	        player.setName("Ramazan");
	        player.setSurname("Uygun");
	        player.setBirthDate("1999-23-12");
	        player.setNationality("Turkey");
	        player.setPosition("Midfielder");
	        player.setMarketValue(1500000.0);
	        player.setGoals(10);
	        player.setAssists(5);
	        player.setYellowCards(2);
	        player.setRedCards(1);

	        assertEquals("Ramazan", player.getName());
	        assertEquals("Uygun", player.getSurname());
	        assertEquals("1999-23-12", player.getBirthDate());
	        assertEquals("Turkey", player.getNationality());
	        assertEquals("Midfielder", player.getPosition());
	        assertEquals(1500000.0, player.getMarketValue(), 0.001);
	        assertEquals(10, player.getGoals());
	        assertEquals(5, player.getAssists());
	        assertEquals(2, player.getYellowCards());
	        assertEquals(1, player.getRedCards());
	    }
	}