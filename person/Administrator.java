package person;

public class Administrator extends Person {

	// Write a method to assign a userID
	private String username;
	private String password;
	
	public Administrator (String firstName, String lastName, String emailAddress, String username, String password) {
		super(firstName, lastName, emailAddress);
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
		return enteredPassword.equals(password);
	}
	
}
