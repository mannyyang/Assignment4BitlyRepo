package uci.inf122.assignment3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uci.inf122.assignment3.BitlyCommandHandler;
import uci.inf122.assignment3.commands.LoginCommand;

public class CommandTests 
{

	@Test
	public void LoginTest() 
	{
		BitlyCommandHandler bch = new BitlyCommandHandler();
		LoginCommand lgC = new LoginCommand("heyitsmanuel@gmail.com", "azn1pride");
		assertEquals("Result", "Welcome!", bch.execute(lgC));
	}

}
