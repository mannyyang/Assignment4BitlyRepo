package uci.inf122.assignment3.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uci.inf122.assignment3.CommandParser;

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
					break;
				}
				else
				{
					break;
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
