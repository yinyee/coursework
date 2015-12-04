package person;

public class NextOfKin extends Person {

	private String relationshipToPatient;
	private String mobilePhoneNumber;
	private String homePhoneNumber;
	
	public NextOfKin (String firstName, String lastName, String emailAddress, String relationshipToPatient, 
			String mobilePhoneNumber, String homePhoneNumber) {
		super(firstName, lastName, emailAddress);
		this.relationshipToPatient = relationshipToPatient;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.homePhoneNumber = homePhoneNumber;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.getFirstName());
		str.append(", ");
		str.append(this.getLastName());
		str.append(", ");
		str.append(this.getEmailAddress());
		str.append(", ");
		str.append(this.getRelationshipToPatient());
		str.append(", ");
		str.append(this.getNextOfKinMobilePhoneNumber());
		str.append(", ");
		str.append(this.getNextOfKinHomePhoneNumber());
		return str.toString();
	}
	
	public String getRelationshipToPatient() {
		return relationshipToPatient;
	}
	
	public String getNextOfKinMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	
	public String getNextOfKinHomePhoneNumber() {
		return homePhoneNumber;
	}
}
