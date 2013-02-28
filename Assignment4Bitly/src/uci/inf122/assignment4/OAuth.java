package uci.inf122.assignment4;

public class OAuth 
{
	private String accessToken;
	
	public OAuth(String accessToken)
	{
		this.accessToken = accessToken;
	}
	
	public String getToken()
	{
		return accessToken;
	}
}
