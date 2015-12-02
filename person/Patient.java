package person;

import person.util.Address;
import person.util.Insurance;
import record.util.Date;

public class Patient extends Person {

	// Write a method to assign a patientID
	private Gender gender;
	private Date birthDate;
	private String mobilePhoneNumber;
	private String homePhoneNumber;
	private String workPhoneNumber;
	private Address homeAddress;
	private Address billingAddress;
	private Insurance insurance;
	private NextOfKin nextOfKin;

	public Patient (String firstName, String lastName, String emailAddress,
			Gender gender,
			int birthDate, int birthMonth, int birthYear,
			String mobilePhoneNumber, String homePhoneNumber, String workPhoneNumber, 
			Address homeAddress, Address billingAddress,
			Insurance insurance,
			NextOfKin nextOfKin) {
		super(firstName, lastName, emailAddress);
		this.gender = gender;
		this.birthDate = new Date(birthDate, birthMonth, birthYear);
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.homePhoneNumber = homePhoneNumber;
		this.workPhoneNumber = workPhoneNumber;
		this.homeAddress = homeAddress;
		this.billingAddress = billingAddress;
		this.insurance = insurance;
		this.nextOfKin = nextOfKin;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	
	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	
	public Insurance getInsurance() {
		return insurance;
	}
	
	public NextOfKin getNextOfKin() {
		return nextOfKin;
	}
	
	/** Helper classes */
	public enum Gender {
		FEMALE,
		MALE
	}
}
