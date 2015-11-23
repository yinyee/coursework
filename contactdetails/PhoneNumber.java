package contactdetails;

public class PhoneNumber {
	
	private String phoneNumber;
	
	public PhoneNumber (String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPhoneNumber (String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}
	
	public String getPhoneNumber () {
		return phoneNumber;
	}
}
