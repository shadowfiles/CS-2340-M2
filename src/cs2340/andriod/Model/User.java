package cs2340.andriod.Model;

public class User {

	private String username;
	private String password;
	
	public User(String usrnm, String pass) {
		username = usrnm;
		password = pass;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	//add other user stuffs
}
