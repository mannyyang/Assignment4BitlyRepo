package uci.inf122.assignment3;

public class OAuth 
{
	private String user;
	private String accessToken;
	
	public OAuth(String user, String accessToken)
	{
		this.user = user;
		this.accessToken = accessToken;
	}
	
	public String getUser()
	{
		return user;
	}
	
	public String getToken()
	{
		return accessToken;
	}
}
