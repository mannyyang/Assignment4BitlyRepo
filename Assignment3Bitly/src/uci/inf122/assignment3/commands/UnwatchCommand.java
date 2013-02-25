package uci.inf122.assignment3.commands;

import uci.inf122.assignment3.BitlyCommandHandler;

public class UnwatchCommand implements Command
{
	private String shortURL;

	public UnwatchCommand(String shortURL)
	{
		this.shortURL = shortURL;
	}

	public String execute(BitlyCommandHandler bch) 
	{
		String results = "";

		if (!bch.getLoggedIn())
		{
			results = "Error. No user is currently logged in. Please login to get started.";
		}
		else
		{
			boolean removed = bch.removeBitly(shortURL);
			
			if (removed)
			{
				results = "The Bitly link: " + shortURL + " has been removed from the watch list.";
			}
			else
			{
				results = "The Bitly link does not exist in the list. Please try again.";
			}
		}

		return results;
	}

}
