package uci.inf122.assignment3.tests;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import uci.inf122.assignment3.BitlyCommandHandler;
import uci.inf122.assignment3.commands.BitMarkCommand;
import uci.inf122.assignment3.commands.ExpandCommand;
import uci.inf122.assignment3.commands.HourCommand;
import uci.inf122.assignment3.commands.LoginCommand;
import uci.inf122.assignment3.commands.LogoutCommand;
import uci.inf122.assignment3.commands.UnwatchCommand;
import uci.inf122.assignment3.commands.WatchCommand;

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

	@Test
	public void WatchUnwatchTest()
	{
		BitlyCommandHandler bch = new BitlyCommandHandler();
		WatchCommand wc = new WatchCommand("http://bit.ly/YvQgJf");
		UnwatchCommand uwc = new UnwatchCommand("http://yhoo.it/Wm8MUR");
		assertEquals("Result", "Error. No user is currently logged in. Please login to get started.", bch.execute(wc));
		assertEquals("Result", "Error. No user is currently logged in. Please login to get started.", bch.execute(uwc));
		LoginCommand lgC = new LoginCommand("heyitsmanuel@gmail.com", "azn1pride");
		bch.execute(lgC);
		assertEquals("Result", "Bitly: http://bit.ly/YvQgJf added to the Watch list.", bch.execute(wc));
		WatchCommand wcBad = new WatchCommand("http://bit.ly/uhohspagetthio");
		assertEquals("Result", "Bitly URL does not exist! Please try again.", bch.execute(wcBad));
		WatchCommand wc1 = new WatchCommand("http://yhoo.it/Wm8MUR");
		bch.execute(wc1);
		WatchCommand wc2 = new WatchCommand("http://on.natgeo.com/YheKb9");
		bch.execute(wc2);
		assertEquals("Result", "The Bitly link: http://yhoo.it/Wm8MUR has been removed from the watch list.", bch.execute(uwc));
		UnwatchCommand uwcBad = new UnwatchCommand("http://bit.ly/THISISABADURL");
		assertEquals("Result", "The Bitly link does not exist in the list. Please try again.", bch.execute(uwcBad));
	}
	
	@Test
	public void HourTest()
	{
		BitlyCommandHandler bch = new BitlyCommandHandler();
		LoginCommand lgC = new LoginCommand("heyitsmanuel@gmail.com", "azn1pride");
		bch.execute(lgC);
		WatchCommand wc = new WatchCommand("http://bit.ly/We32BU");
		WatchCommand wc1 = new WatchCommand("http://yhoo.it/Wm8MUR");
		WatchCommand wc2 = new WatchCommand("http://on.natgeo.com/YheKb9");
		WatchCommand wc3 = new WatchCommand("http://bitly.com/YUI5ck");
		bch.execute(wc);
		bch.execute(wc1);
		bch.execute(wc2);
		bch.execute(wc3);
		HourCommand hc = new HourCommand();
		String expected = "Sorted by Clicks in the Last Hour" +
				"\n-------------------------------" +
				"\nhttp://bitly.com/YUI5ck	:	119" +
				"\nhttp://bit.ly/We32BU	:	6" +
				"\nhttp://yhoo.it/Wm8MUR	:	2" +
				"\nhttp://on.natgeo.com/YheKb9	:	1";
		assertEquals("Result", expected, bch.execute(hc));
	}
	
}
