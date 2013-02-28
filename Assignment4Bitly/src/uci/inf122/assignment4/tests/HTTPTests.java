package uci.inf122.assignment4.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import uci.inf122.assignment4.BitlyCommandHandler;

public class HTTPTests 
{
	@Test
	public void connectionTest() throws IOException 
	{
		BitlyCommandHandler bch = new BitlyCommandHandler();
		assertEquals("Result", "e6d3309606f28fcce9b6654fb83666c1da0ff162", bch.login("heyitsmanuel@gmail.com", "azn1pride"));
		assertEquals("Result", "Invalid", bch.login("heyitsmanuel@gmail.com", "azn1pride1"));
	}

}
