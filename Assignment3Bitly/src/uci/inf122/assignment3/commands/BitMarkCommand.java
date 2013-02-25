package uci.inf122.assignment3.commands;

import uci.inf122.assignment3.BitlyCommandHandler;
import uci.inf122.assignment3.XMLParser;

public class BitMarkCommand implements Command
{
	private String longURL;
	private String xml;
	private XMLParser xmlParser;

	public BitMarkCommand(String longURL)
	{
		this.longURL = longURL;
	}
	
	public String execute(BitlyCommandHandler bch) 
	{
		String results = "wot";
		
		if (!bch.getLoggedIn())
		{
			results = "Error. No user is currently logged in. Please login to get started.";
		}
		else
		{
			xml = bch.getBitMark(longURL);
			xmlParser = new XMLParser(xml);
			results = xmlParser.getInfo("hash");
		}
		
		return results;
	}

}
