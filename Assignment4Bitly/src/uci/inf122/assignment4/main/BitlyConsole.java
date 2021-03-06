package uci.inf122.assignment4.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uci.inf122.assignment4.CommandParser;

public class BitlyConsole 
{
	private BufferedReader inConsole;
	private CommandParser cp;
	
	public BitlyConsole(CommandParser cp)
	{
		this.cp = cp;
		inConsole = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void run()
	{
		print("Welcome to the Bitly Watcher! Please login to begin.");
		
		while(true)
		{
			try 
			{
				String in = inConsole.readLine().trim();
				
				if (cp.authenticate(in))
				{
					print(cp.executeCommand());
				}
				else
				{
					print("Invalid Format! Please enter a command based on these formats:" +
							"\nLOGIN [username] [password]" +
							"\nLOGOUT" +
							"\nBITMARK [URL]" +
							"\nEXPAND [shortened_URL]" +
							"\nWATCH [shortened_URL]" +
							"\nUNWATCH [shortened_URL]" +
							"\nHOUR" +
							"\nWEEK");
				}
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void print(String s)
	{
		System.out.println(s);
	}

}
