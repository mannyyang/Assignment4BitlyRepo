package uci.inf122.assignment4.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import uci.inf122.assignment4.BitlyCommandHandler;
import uci.inf122.assignment4.XMLParser;

public class HourCommand implements Command
{
	private String xml;
	private XMLParser xmlParser;

	public HourCommand()
	{

	}

	public String execute(BitlyCommandHandler bch)
	{
		String result = "";
		ArrayList<String> bitlyList = bch.getBitlyList();
		Map<String, Integer> map = new HashMap<String, Integer>();
		ValueComparator vc = new ValueComparator();

		if (bch.getLoggedIn())
		{
			if (bitlyList.size() < 1)
			{
				return "There are no items in your watch list! Add links to view their clicks.";
			}
			else
			{
				for (String bitly : bitlyList)
				{
					xml = bch.getClicks(bitly, "hour");
					xmlParser = new XMLParser(xml);
					String clicks = xmlParser.getInfo("link_clicks");
					int nClicks = Integer.parseInt(clicks);
					map.put(bitly, nClicks);
				}
			}

			List<Entry<String, Integer>> sorted = vc.entriesSortedByValues(map);
			result += "Sorted by Clicks in the Last Hour";
			result += "\n-------------------------------";
			
			for (Entry<String, Integer> kv : sorted)
			{
				result += "\n" + kv.getKey() + "\t:\t" + kv.getValue();
			}
		}
		else
		{
			return "Error. No user is currently logged in. Please login to get started.";
		}

		return result;
	}


}
