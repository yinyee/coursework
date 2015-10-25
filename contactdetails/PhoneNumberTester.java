package contactdetails;

public class PhoneNumberTester {

	public static void main (String[] args) {
		
		PhoneNumber phoneNumber = new PhoneNumber("123456789");
		System.out.println(phoneNumber.getPhoneNumber());
		phoneNumber.setPhoneNumber("987654321");
		System.out.println(phoneNumber.getPhoneNumber());
		
	}
	
}
