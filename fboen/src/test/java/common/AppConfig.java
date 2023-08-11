package common;

public class AppConfig {

	
	private String ApplicationURL="";
	private String userName ="";
	private String Password="";
	private String BrowserName="";
	
	
	public String getApplicationURL() {
		return ApplicationURL;
	}
	public void setApplicationURL(String applicationURL) {
		ApplicationURL = applicationURL;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getBrowserName() {
		return BrowserName;
	}
	public void setBrowserName(String browserName) {
		BrowserName = browserName;
	}
	
	
}
