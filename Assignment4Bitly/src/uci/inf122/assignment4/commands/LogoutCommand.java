package uci.inf122.assignment4.commands;

import uci.inf122.assignment4.BitlyCommandHandler;

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
			bch.clearList();
			result = "User is logged out.";
		}
		else
		{
			result = "No user is currently logged in. Please login first.";
		}
		return result;
	}

}
