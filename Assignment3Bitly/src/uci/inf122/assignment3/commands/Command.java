package uci.inf122.assignment3.commands;

import uci.inf122.assignment3.BitlyCommandHandler;

public interface Command 
{
	String execute(BitlyCommandHandler bch);
}
