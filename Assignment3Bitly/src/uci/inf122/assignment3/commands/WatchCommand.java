package uci.inf122.assignment3.commands;

import uci.inf122.assignment3.BitlyCommandHandler;
import uci.inf122.assignment3.XMLParser;

public class WatchCommand implements Command
{
	private String shortURL;
	private String xml;
	private XMLParser xmlParser;

	public WatchCommand(String shortURL)
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
			xml = bch.verifyBitly(shortURL);
			xmlParser = new XMLParser(xml);
			
			try
			{
				xmlParser.getInfo("global_hash");
				bch.addBitly(shortURL);
				results = "Bitly: " + shortURL + " added to the Watch list.";
			}
			catch (NullPointerException npe)
			{
				results = "Bitly URL does not exist! Please try again.";
			}
		}

		return results;
	}
}
