package person;

import person.PatientGUI.Gender;

public class PersonTester {
	
	public static void main (String[] args) {
		
		Person person = new Person ("Yin Yee", "Kan");
		System.out.println(person.fullName());
		
		User user = new User ("Ariel", "Neptune", "starfish", "password");
		System.out.println(user.fullName());
		user.setPassword("horlicks");
		System.out.println("Password = 'password' :" + user.checkPassword("password"));
		System.out.println("Password = 'horlicks' :" + user.checkPassword("horlicks"));
		
		// String firstName, String lastName, String nationalID, Date birthDate,
		// String mobilePhoneNumber, String homePhoneNumber, String workPhoneNumber, 
		// String emailAddress, NextOfKing nextOfKin
		NextOfKin nextOfKin = new NextOfKin("Lucy", "Liu", "Sister", "000", "999", "lucy@hollywood.com");
		PatientGUI patient = new PatientGUI ("ABCD", "XYZ", Gender.MALE, "ID", 1, 11, 1999, "1234567", 
				"9876543", "000111000", "yyy@gmail.com", nextOfKin);
		System.out.println(patient.fullName());
		String nameOfNextOfKin = patient.getNextOfKin().fullName();
		System.out.println(nameOfNextOfKin);
	}
}
