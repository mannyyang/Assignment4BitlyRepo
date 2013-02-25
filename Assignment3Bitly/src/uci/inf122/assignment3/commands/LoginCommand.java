package uci.inf122.assignment3.commands;

import uci.inf122.assignment3.BitlyCommandHandler;
import uci.inf122.assignment3.OAuth;

public class LoginCommand implements Command
{
	private String user;
	private String pass;
	private String accessToken;
	
	public LoginCommand(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
	}

	@Override
	public String execute(BitlyCommandHandler bch) 
	{
		String result;
		
		accessToken = bch.login(user, pass);
		if (accessToken.equals("Invalid"))
		{
			result = "Invalid." +
					"ID/Password combination is incorrect. Please try again.";
		}
		else
		{
			bch.setOAuthToken(createKey());
			bch.setLoggedIn(true);
			result = "Welcome!";
		}
		return result;
	}
	
	public OAuth createKey()
	{
		OAuth oAuth = new OAuth(user, accessToken);
		return oAuth;
	}

}
