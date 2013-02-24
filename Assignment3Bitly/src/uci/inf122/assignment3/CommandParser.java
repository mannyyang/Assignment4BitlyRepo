package uci.inf122.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uci.inf122.assignment3.main.BitlyConsole;

public class CommandParser 
{
	private BitlyCommandHandler bch;
	private BufferedReader inConsole;
	
	private BitlyConsole console;
	
	public CommandParser()
	{
		bch = new BitlyCommandHandler();
		console = new BitlyConsole();
	}
	
	public void run()
	{
		inConsole = new BufferedReader(new InputStreamReader(System.in));
		print("Welcome to the Bitly Watcher! Enter in a command to begin.");
		
		while(true)
		{
			try 
			{
				String in = inConsole.readLine();
				
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public String authenticate(String command)
	{
		return "";
	}
	
	public void print(String s)
	{
		System.out.println(s);
	}
	
}
