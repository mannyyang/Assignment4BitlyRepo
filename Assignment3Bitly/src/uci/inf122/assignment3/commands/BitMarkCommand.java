package uci.inf122.assignment3.commands;

import uci.inf122.assignment3.BitlyCommandHandler;

public class BitMarkCommand implements Command
{
	private String longURL;

	public BitMarkCommand(String longURL)
	{
		this.longURL = longURL;
	}
	
	public String execute(BitlyCommandHandler bch) 
	{
		String results = "";
		
		if (!bch.getLoggedIn())
		{
			results = "No user is currently logged in. Please login to get started.";
		}
		else
		{
			
		}
		return null;
	}

}
