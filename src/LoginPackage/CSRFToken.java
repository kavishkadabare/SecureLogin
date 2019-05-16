package LoginPackage;

public class CSRFToken {

	public static String sessionId;
	public static String token;
	
	public CSRFToken (String sessionId, String token) {
		this.sessionId = sessionId;
		this.token = token;
	}
	
	public static String getToken(String sessionId) {
		return token;
	}
}
