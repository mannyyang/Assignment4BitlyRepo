package uci.inf122.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import sun.misc.BASE64Encoder;

import uci.inf122.assignment3.commands.Command;

@SuppressWarnings("restriction")
public class BitlyCommandHandler 
{
	//	private final String clientID = "5349b46c53033e0ef55e03426203469e2bdae2a5";
	//	private final String clientSecret = "f91e4e4196b86f9f38444156e4162617ea6b1ae4";

	private URL url;
	private HttpURLConnection connection;
	private OAuth token;
	private boolean loggedIn = false;

	private ArrayList<String> bitlyList;
	
	public BitlyCommandHandler()
	{
		bitlyList = new ArrayList<String>();
	}

	public String execute(Command command)
	{
		String result = command.execute(this);
		return result;
	}

	public String login(String user, String pass)
	{
		BASE64Encoder encoder = new BASE64Encoder();
		String accessToken = "";

		try 
		{
			url = new URL ("https://api-ssl.bitly.com/oauth/access_token");
			byte[] encodedPassword = (user+":"+pass).getBytes();
			String encoding = encoder.encode (encodedPassword);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty  ("Authorization", "Basic " + encoding);
			InputStream content = connection.getInputStream();
			BufferedReader in = new BufferedReader (new InputStreamReader (content));
			accessToken = in.readLine();
		} 
		catch(IOException ioe) 
		{
			accessToken = "Invalid";
		}

		return accessToken;
	}

	public String getBitMark(String longURL)
	{
		String result = getURL("shorten", "longUrl", longURL);
		return result;
	}
	
	public String expand(String shortURL)
	{
		String result = getURL("expand", "shortUrl", shortURL);
		return result;
	}

	public String verifyBitly(String shortURL)
	{
		String result = getURL("info", "shortUrl", shortURL);
		return result;
	}
	
	public boolean removeBitly(String shortURL)
	{
		for (int i = 0; i < bitlyList.size(); i++)
		{
			if (shortURL.equals(bitlyList.get(i)))
			{
				bitlyList.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public String getClicks(String shortURL, String sortType)
	{
		String stringURL = "https://api-ssl.bitly.com/v3/link/clicks";
		String accessToken = token.getToken();
		String charset = "UTF-8";
		String format = "xml";
		String timezone = "America/New_York";
		String units = "1";
		String result = "";
		
		try 
		{
			String queryToken = String.format("access_token=%s&link=%s&timezone=%s&unit=%s&units=%s&format=%s",
					URLEncoder.encode(accessToken, charset),
					URLEncoder.encode(shortURL, charset),
					URLEncoder.encode(timezone, charset),
					URLEncoder.encode(sortType, charset),
					URLEncoder.encode(units, charset),
					URLEncoder.encode(format, charset));

			url = new URL(stringURL + "?" + queryToken);
			
			result = url.toString();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return result;
	}
	
	public String getURL(String URLAction, String URLType, String actualURL)
	{
		String stringURL = "https://api-ssl.bitly.com/v3/" + URLAction;
		String accessToken = token.getToken();
		String charset = "UTF-8";
		String format = "xml";
		String result = "";
		
		try 
		{
			String queryToken = String.format("access_token=%s&"+URLType+"=%s&format=%s",
					URLEncoder.encode(accessToken, charset),
					URLEncoder.encode(actualURL, charset),
					URLEncoder.encode(format, charset));

			url = new URL(stringURL + "?" + queryToken);
			
			result = url.toString();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return result;
	}
	
	public void setOAuthToken(OAuth token)
	{
		this.token = token;
	}

	public void setLoggedIn(boolean loggedIn)
	{
		this.loggedIn = loggedIn;
	}

	public boolean getLoggedIn()
	{
		return loggedIn;
	}

	public ArrayList<String> getBitlyList()
	{
		return bitlyList;
	}
	
	public void addBitly(String shortURL)
	{
		bitlyList.add(shortURL);
	}
	
	public void clearList()
	{
		bitlyList.clear();
	}
}
