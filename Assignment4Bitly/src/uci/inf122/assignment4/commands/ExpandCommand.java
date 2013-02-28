package uci.inf122.assignment4.commands;

import uci.inf122.assignment4.BitlyCommandHandler;
import uci.inf122.assignment4.XMLParser;

public class ExpandCommand implements Command
{
	private String shortURL;
	private String xml;
	private XMLParser xmlParser;

	public ExpandCommand(String shortURL)
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
			xml = bch.expand(shortURL);
			xmlParser = new XMLParser(xml);
			try
			{
				results = xmlParser.getInfo("long_url");
			}
			catch (NullPointerException npe)
			{
				results = "Bitly URL does not exist! Please try again.";
			}
		}

		return results;
	}

}
