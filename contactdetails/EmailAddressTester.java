package contactdetails;

public class EmailAddressTester {

	public static void main (String[] args) {
		
		EmailAddress validEmailAddress1 = new EmailAddress("abcd@gmail.com");
		System.out.println(validEmailAddress1.getEmailAddress());
		
		EmailAddress validEmailAddress2 = new EmailAddress("abcd@gmail.net"); // Should be accepted but currently throws an error
		System.out.println(validEmailAddress2.getEmailAddress());
		
		EmailAddress invalidEmailAddress1 = new EmailAddress("abcd@gmailcom");
		System.out.println(invalidEmailAddress1.getEmailAddress());
		
		EmailAddress invalidEmailAddress2 = new EmailAddress("abcdgmail.com");
		System.out.println(invalidEmailAddress2.getEmailAddress());
		
	}
}
