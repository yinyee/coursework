package obj;

public class Patient {

	private String firstName;
	private String lastName;
	private String gender;
	private String birthDate;
	private String birthMonth;
	private String birthYear; 
	private String emailAddress;
	private String mobilePhoneNumber;
	private String homePhoneNumber;
	private String houseNumberOrName;
	private String street;
	private String city;
	private String postalCode;
	private String country;
	private String photo;
	private String[] patientData;
	
	public Patient (String[] patientData) {
		this.firstName = patientData[0];
		this.lastName = patientData[1];
		this.gender = patientData[2];
		this.birthDate = patientData[3];
		this.birthMonth = patientData[4];
		this.birthYear = patientData[5];
		this.emailAddress = patientData[6];
		this.mobilePhoneNumber = patientData[7];
		this.homePhoneNumber = patientData[8];
		this.houseNumberOrName = patientData[9];
		this.street = patientData[10];
		this.city = patientData[11];
		this.postalCode = patientData[12];
		this.country = patientData[13];
		this.photo = patientData[14];
		this.patientData = patientData;
	}
		
	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public String getBirthMonth() {
		return birthMonth;
	}
	
	public String getBirthYear() {
		return birthYear;
	}
	
	public String getFormattedBirthDate() {
		return birthMonth + " " + birthDate + ", " + birthYear;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
		
	public String getHouseNumberOrName() {
		return houseNumberOrName;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public String[] getPatientData() {
		return patientData;
	}
}
