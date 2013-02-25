package uci.inf122.assignment3;

import uci.inf122.assignment3.commands.Command;
import uci.inf122.assignment3.commands.LoginCommand;
import uci.inf122.assignment3.main.BitlyConsole;

public class CommandParser 
{
	private BitlyCommandHandler bch;
	private BitlyConsole console;
	private Command currCommand;

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
		String rest = "";
		boolean isCommand = false;

		if (command.contains(" "))
		{
			c = command.substring(0, command.indexOf(' ')).toUpperCase();
			rest = command.substring(command.indexOf(' ')+1);
		}
		else
		{
			c = command.toUpperCase();
		}

		if (c.equals(Commands.LOGIN.toString()))
		{
			if (!rest.contains(" "))
			{
				isCommand = false;
			}
			else
			{
				String user = rest.substring(0, rest.indexOf(' '));
				String pass = rest.substring(rest.indexOf(' ')+1);

				if (user.length() == 0 || pass.length() == 0)
				{
					isCommand = false;
				}
				else
				{
					currCommand = new LoginCommand(user, pass);
					isCommand = true; 
				}
			}
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

	public String executeCommand()
	{
		
		return "";
	}
}
