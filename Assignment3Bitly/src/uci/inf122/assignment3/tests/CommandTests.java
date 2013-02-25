package uci.inf122.assignment3.tests;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import uci.inf122.assignment3.BitlyCommandHandler;
import uci.inf122.assignment3.commands.BitMarkCommand;
import uci.inf122.assignment3.commands.ExpandCommand;
import uci.inf122.assignment3.commands.LoginCommand;
import uci.inf122.assignment3.commands.LogoutCommand;

public class CommandTests 
{

	@Test
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
		BitMarkCommand bmc = new BitMarkCommand("https://www.google.com");
		assertEquals("Result", "Error. No user is currently logged in. Please login to get started.", bch.execute(bmc));
		LoginCommand lgC = new LoginCommand("heyitsmanuel@gmail.com", "azn1pride");
		bch.execute(lgC);
		assertEquals("Result", "http://bit.ly/YvQgJf", bch.execute(bmc));
		BitMarkCommand bmcBadURL = new BitMarkCommand("NotURL");
		assertEquals("Result", "Invalid URL format! Please try again.", bch.execute(bmcBadURL));
	}
	
	@Test
	public void expandTest()
	{
		BitlyCommandHandler bch = new BitlyCommandHandler();
		ExpandCommand ec = new ExpandCommand("http://bit.ly/YvQgJf");
		assertEquals("Result", "Error. No user is currently logged in. Please login to get started.", bch.execute(ec));
		LoginCommand lgC = new LoginCommand("heyitsmanuel@gmail.com", "azn1pride");
		bch.execute(lgC);
		assertEquals("Result", "https://www.google.com/", bch.execute(ec));
		ExpandCommand ecBad = new ExpandCommand("http://bit.ly/uhohspagetthio");
		assertEquals("Result", "Bitly URL does not exist! Please try again.", bch.execute(ecBad));

	}

}
