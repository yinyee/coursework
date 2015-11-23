package person;

import contactdetails.EmailAddress;
import contactdetails.PhoneNumber;

public class Patient extends Person {

	private String patientID; // Write a method to assign a clientID;
	private String nationalID;
	private int birthDate;
	private int birthMonth;
	private int birthYear; // Impose 4-digit year
	private PhoneNumber mobilePhoneNumber;
	private PhoneNumber homePhoneNumber;
	private PhoneNumber workPhoneNumber;
	private EmailAddress emailAddress;
	private NextOfKin nextOfKin;
	
	
	public Patient (String firstName, String lastName, String nationalID, int birthDate,
			int birthMonth, int birthYear, String mobilePhoneNumber, String homePhoneNumber, 
			String workPhoneNumber, String emailAddress, NextOfKin nextOfKin) {
		super(firstName, lastName);
		this.nationalID = nationalID;
		this.birthDate = birthDate;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.mobilePhoneNumber = new PhoneNumber(mobilePhoneNumber);
		this.homePhoneNumber = new PhoneNumber(homePhoneNumber);
		this.workPhoneNumber = new PhoneNumber(workPhoneNumber);
		this.emailAddress = new EmailAddress(emailAddress);
		this.nextOfKin = nextOfKin;
		
	}
	
	public NextOfKin getNextOfKin() {
		return nextOfKin;
	}
}
