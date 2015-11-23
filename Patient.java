/*
 * 1.
 * Management system should be implemented as a Java GUI application using frames, tables, buttons, listeners, etc.
 * 
 * 2.
 * Practitioner should be able to log in to the patient management system using a user name & password combination.
 * 
 * 3.
 * Register a new patient with minimum information consisting of last name, first name, DOB, address, emergency contact
 * number, medical condition, appointments, billing, comments, etc.  Each record might contain a profile picture of the
 * patient and a set of pictures describing his/her condition such as brain scans (any sample image is acceptable).
 * 
 * 4.
 * The field containing the medical condition should be click-able and pointing to a Wikipedia page or any URL with the
 * description of that condition.
 * 
 * 5.
 * Edit an existing patient record, by editing existing information such as appointment dates and times, uploading new
 * or deleting unwanted images.
 * 
 * 6.
 * Delete an existing patient record.  Your programme should ask for confirmation before deleting a record.
 * 
 * 7.
 * Search the list of patients based on any of the stored fields, e.g. name, DOB, address, etc. and produce a list of
 * corresponding records.
 * 
 * 8. OPTIONAL
 * Export a list of selected patient records as a comma separated file or any other format.
 * 
 * 9. OPTIONAL
 * Import a comma separated (or the format used in 8) file containing patient records into the system.  The uploaded
 * patient data will be appended to the existing records in the system.
 * 
 */

public class Patient {
	
	String 	patientNumber,
			patientFirstName,
			patientLastName,
			patientID,
			patientNHSnumber,
			patientBirthDate, // check appropriate data type
			patientPhoneNumber;
	
	String 	patientHomeAddress1,
			patientHomeAddress2,
			patientHomePostalCode,
			patientHomeCountry;
	
	String 	patientBillingAddress1,
			patientBillingAddress2,
			patientBillingPostalCode,
			patientBillingAddressCountry;
	
	String 	patientNextOfKinName,
			patientNextOfKinRelationship,
			patientNextOfKinPhone;
	
	// Link to patient's medical information (including prescriptions), possibly in another class
	// Link to WebMD database
	String 	patientDiagnosis;
	
	// Link to patient's treatment information (including appointments), possible in another class
	


}
