package uci.inf122.assignment3.commands;

import uci.inf122.assignment3.BitlyCommandHandler;

public class LogoutCommand implements Command
{
	public LogoutCommand()
	{
		
	}
	
	public String execute(BitlyCommandHandler bch) 
	{
		String result = "";
		
		if (bch.getLoggedIn())
		{
			bch.setOAuthToken(null);
			bch.setLoggedIn(false);
			result = "User is logged out.";
		}
		else
		{
			result = "No user is currently logged in. Please login first.";
		}
		return result;
	}

}
