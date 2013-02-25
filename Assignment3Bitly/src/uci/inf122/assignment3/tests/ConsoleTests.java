package uci.inf122.assignment3.tests;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import uci.inf122.assignment3.CommandParser;
import uci.inf122.assignment3.commands.LogoutCommand;

public class ConsoleTests 
{

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
		assertEquals("Result", true, cp.authenticate("LOGIN Manny1 pass123"));
		
		assertEquals("Result", true, cp.authenticate("logout"));
		assertEquals("Result", false, cp.authenticate("bitmark"));
		assertEquals("Result", false, cp.authenticate("bitmark  "));
		assertEquals("Result", true, cp.authenticate("bitmark http://www.google.com"));
		
		assertEquals("Result", false, cp.authenticate("expand"));
		assertEquals("Result", false, cp.authenticate("expand  "));
		assertEquals("Result", true, cp.authenticate("expand http://bit.ly/YvQgJf"));
		
		assertEquals("Result", true, cp.authenticate("watch"));
		assertEquals("Result", true, cp.authenticate("unwatch"));
		assertEquals("Result", true, cp.authenticate("hour"));
		assertEquals("Result", true, cp.authenticate("week"));
	}
	
	@Test
	public void consoleTest()
	{
		CommandParser cp = new CommandParser();
		cp.setCommand(new LogoutCommand());
		assertEquals("Result", "No user is currently logged in. Please login first.", cp.executeCommand());
	}

}
