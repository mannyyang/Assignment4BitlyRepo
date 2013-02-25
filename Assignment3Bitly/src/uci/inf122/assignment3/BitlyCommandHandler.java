package uci.inf122.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
	
	public BitlyCommandHandler()
	{

	}

	public String execute(Command command)
	{
		command.execute(this);
		return "";
	}

	public String login(String user, String pass)
	{
		final String urlString = "https://api-ssl.bitly.com/oauth/access_token";
		BASE64Encoder encoder = new BASE64Encoder();
		String accessToken = "";

		try 
		{
			url = new URL (urlString);
			byte[] encodedPassword = (user+":"+pass).getBytes();
			String encoding = encoder.encode (encodedPassword);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty  ("Authorization", "Basic " + encoding);
			InputStream content = (InputStream)connection.getInputStream();
			BufferedReader in = new BufferedReader (new InputStreamReader (content));
			accessToken = in.readLine();
		} 
		catch(IOException ioe) 
		{
			accessToken = "Invalid";
		}
		
		return accessToken;
	}
	
	public void setOAuthToken(OAuth token)
	{
		this.token = token;
	}

}
