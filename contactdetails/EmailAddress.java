package contactdetails;

public class EmailAddress {
	
	private String emailAddress;
	
	public EmailAddress (String emailAddress) {
		if (checkValidEmailAddress(emailAddress) == true) {
			this.emailAddress = emailAddress;
		} else {
			System.out.println("Email address is invalid");
		}
	}
	
	private boolean checkValidEmailAddress(String emailAddress) {
		if (emailAddress.contains("@") && emailAddress.contains(".com")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getEmailAddress () {
		return emailAddress;
	}
	
	public void setEmailAddress (String newEmailAddress) {
		this.emailAddress = newEmailAddress;
	}

}
