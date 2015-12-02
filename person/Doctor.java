package person;

public class Doctor extends Person {
	
	// Write a method to assign a DoctorID
	private String specialisation;
	
	public Doctor (String firstName, String lastName, String emailAddress, String specialisation) {
		super(firstName, lastName, emailAddress);
		this.specialisation = specialisation;
	}
	
	public String getSpecialisation() {
		return specialisation;
	}

}
