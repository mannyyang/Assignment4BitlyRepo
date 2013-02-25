package uci.inf122.assignment3.tests;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import uci.inf122.assignment3.BitlyCommandHandler;
import uci.inf122.assignment3.commands.LoginCommand;
import uci.inf122.assignment3.commands.LogoutCommand;

public class CommandTests 
{

	@Ignore
	public void LoginLogoutTest() 
	{
		BitlyCommandHandler bch = new BitlyCommandHandler();
		LoginCommand lgC = new LoginCommand("heyitsmanuel@gmail.com", "azn1pride");
		assertEquals("Result", "Welcome!", bch.execute(lgC));
		lgC = new LoginCommand("heyitsmanuel@gmail.com", "wrongpassword");
		assertEquals("Result", "Invalid." +
					"\nID/Password combination is incorrect. Please try again.", bch.execute(lgC));
		LogoutCommand logoutC = new LogoutCommand();
		assertEquals("Result", "User is logged out.", bch.execute(logoutC));
		assertEquals("Result", "No user is currently logged in. Please login first.", bch.execute(logoutC));
	}
	
	@Test
	public void getBitMarkTest()
	{
		BitlyCommandHandler bch = new BitlyCommandHandler();
		LoginCommand lgC = new LoginCommand("heyitsmanuel@gmail.com", "azn1pride");
		bch.execute(lgC);
		assertEquals("Result", "", bch.getBitMark("httpsdf://www.google.com"));
	}

}
