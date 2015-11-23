package person;

import contactdetails.EmailAddress;
import contactdetails.PhoneNumber;

public class NextOfKin extends Person {

	private String relationshipToPatient;
	private PhoneNumber mobilePhoneNumber;
	private PhoneNumber homePhoneNumber;
	private EmailAddress emailAddress;
	
	public NextOfKin (String firstName, String lastName, String relationshipToPatient, 
			String mobilePhoneNumber, String homePhoneNumber, String emailAddress) {
		super(firstName, lastName);
		this.relationshipToPatient = relationshipToPatient;
		this.mobilePhoneNumber = new PhoneNumber(mobilePhoneNumber);
		this.homePhoneNumber = new PhoneNumber(homePhoneNumber);
		this.emailAddress = new EmailAddress(emailAddress);
		
	}
	
	
}
