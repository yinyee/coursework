package person;

import contactdetails.EmailAddress;

public class Person {

	private String firstName;
	private String lastName;
	private EmailAddress emailAddress;
	
	public Person (String firstName, String lastName, String emailAddress){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = new EmailAddress(emailAddress);
	}
	
	public String fullName () {
		return firstName + " " + lastName;
	}
	
	public void setEmailAddress(String newEmailAddress) {
		this.emailAddress.setEmailAddress(newEmailAddress);
	}
	
}
