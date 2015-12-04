package person;

import person.util.Address;
import record.util.Date;

public class Patient extends Person {

	// Write a method to assign a patientID
	private String gender;
	private Date birthDate;
	private String mobilePhoneNumber;
	private String homePhoneNumber;
	private String workPhoneNumber;
	private Address homeAddress;
	private Address billingAddress;
	private NextOfKin nextOfKin;

	public Patient (String firstName, String lastName, String emailAddress,
			String gender,
			String birthDate, String birthMonth, String birthYear,
			String mobilePhoneNumber, String homePhoneNumber, String workPhoneNumber, 
			Address homeAddress, Address billingAddress,
			NextOfKin nextOfKin) {
		super(firstName, lastName, emailAddress);
		this.gender = gender;
		this.birthDate = new Date(birthDate, birthMonth, birthYear);
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.homePhoneNumber = homePhoneNumber;
		this.workPhoneNumber = workPhoneNumber;
		this.homeAddress = homeAddress;
		this.billingAddress = billingAddress;
		this.nextOfKin = nextOfKin;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.getFirstName());
		str.append(", ");
		str.append(this.getLastName());
		str.append(", ");
		str.append(this.getEmailAddress());
		str.append(", ");
		str.append(this.getGender());
		str.append(", ");
		str.append(this.getBirthDate().getFormattedDate());
		str.append(", ");
		str.append(this.getMobilePhoneNumber());
		str.append(", ");
		str.append(this.getHomePhoneNumber());
		str.append(", ");
		str.append(this.getWorkPhoneNumber());
		str.append(", ");
		str.append(this.homeAddress.getFullAddress());
		str.append(", ");
		str.append(this.billingAddress.getFullAddress());
		str.append(", ");
		str.append(this.getNextOfKin().toString());
		return str.toString();
	}
	
	public String getGender() {
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
	
	public NextOfKin getNextOfKin() {
		return nextOfKin;
	}
	
}
