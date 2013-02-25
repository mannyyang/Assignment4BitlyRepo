package uci.inf122.assignment3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uci.inf122.assignment3.CommandParser;

public class ConsoleTests {

	@Test
	public void authenticateTest() 
	{
		CommandParser cp = new CommandParser();
		
		assertEquals("Result", false, cp.authenticate("login"));
		assertEquals("Result", false, cp.authenticate("LOGIN"));
		assertEquals("Result", false, cp.authenticate("login      "));
		assertEquals("Result", true, cp.authenticate("loGiN user pass"));
		assertEquals("Result", false, cp.authenticate("login user"));
		assertEquals("Result", false, cp.authenticate("login user "));
		assertEquals("Result", false, cp.authenticate("   login"));
		
		assertEquals("Result", true, cp.authenticate("logout"));
		assertEquals("Result", true, cp.authenticate("bitmark"));
		assertEquals("Result", true, cp.authenticate("expand"));
		assertEquals("Result", true, cp.authenticate("watch"));
		assertEquals("Result", true, cp.authenticate("unwatch"));
		assertEquals("Result", true, cp.authenticate("hour"));
		assertEquals("Result", true, cp.authenticate("week"));
	}

}
