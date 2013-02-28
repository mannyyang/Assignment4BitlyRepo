package uci.inf122.assignment4.commands;

import uci.inf122.assignment4.BitlyCommandHandler;

public interface Command 
{
	String execute(BitlyCommandHandler bch);
}
