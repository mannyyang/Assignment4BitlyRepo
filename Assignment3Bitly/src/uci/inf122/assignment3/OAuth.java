package uci.inf122.assignment3;

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
