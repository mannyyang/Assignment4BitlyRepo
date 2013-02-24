package uci.inf122.assignment3;

import uci.inf122.assignment3.main.BitlyConsole;

public class CommandParser 
{
	private BitlyCommandHandler bch;
	private BitlyConsole console;
	
	public CommandParser()
	{
		bch = new BitlyCommandHandler();
	}
	
	public void run()
	{
		console = new BitlyConsole(this);
		console.run();
	}
	
	public boolean authenticate(String command)
	{
		String c = "";
		boolean isCommand = false;
		
		if (command.contains(" "))
		{
			c = command.substring(0, command.indexOf(' ')).toUpperCase();
		}
		else
		{
			c = command.toUpperCase();
		}
		
		if (c.equals(Commands.LOGIN.toString()))
		{
			isCommand = true;
		}
		else if (c.equals(Commands.LOGOUT.toString()))
		{
			isCommand = true;
		}
		else if (c.equals(Commands.BITMARK.toString()))
		{
			isCommand = true;
		}
		else if (c.equals(Commands.EXPAND.toString()))
		{
			isCommand = true;
		}
		else if (c.equals(Commands.WATCH.toString()))
		{
			isCommand = true;
		}
		else if (c.equals(Commands.UNWATCH.toString()))
		{
			isCommand = true;
		}
		else if (c.equals(Commands.HOUR.toString()))
		{
			isCommand = true;
		}
		else if (c.equals(Commands.WEEK.toString()))
		{
			isCommand = true;
		}
		else
		{
			isCommand = false;
		}
		
		return isCommand;
	}
	
}
