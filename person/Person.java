package person;

import person.util.EmailAddress;

public class Person {

	private String firstName;
	private String lastName;
	private EmailAddress emailAddress;
	
	public Person (String firstName, String lastName, String emailAddress){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = new EmailAddress(emailAddress);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
	public String getEmailAddress() {
		return emailAddress.toString();
	}
	
	public void setEmailAddress(String newEmailAddress) {
		this.emailAddress.setEmailAddress(newEmailAddress);
	}
	
}
