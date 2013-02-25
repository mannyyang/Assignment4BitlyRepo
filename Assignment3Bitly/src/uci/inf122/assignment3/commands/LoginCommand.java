package uci.inf122.assignment3.commands;

import uci.inf122.assignment3.BitlyCommandHandler;

public class LoginCommand implements Command
{
	private String user;
	private String pass;
	
	public LoginCommand(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
	}

	@Override
	public void execute(BitlyCommandHandler bch) 
	{
		
	}

}
