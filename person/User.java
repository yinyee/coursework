package person;

public class User extends Person {

	private String userID; // Write a method to assign a userID
	private String username;
	private String password;
	
	public User (String firstName, String lastName, String username, String password) {
		super(firstName, lastName);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername (){
		return username;
	}
	
	public void setPassword (String newPassword) {
		password = newPassword;
	}
	
	public boolean checkPassword (String enteredPassword) {
		if (enteredPassword == password){
			return true;
		} else {
			return false;
		}
	}
	
}
