package cs2340.andriod.Model;

public class User {

	private String username;
	private String password;
	private String name;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	//add other user stuffs
}
