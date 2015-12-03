package record;

import person.Patient;
import record.util.Date;

public class Record {
	
	private Patient patient;
	private Date date;
	private String doctor;
	
	public Record (Patient patient, int recordDate, int recordMonth, int recordYear, String doctor) {
		this.patient = patient;
		this.date = new Date(recordDate, recordMonth, recordYear);
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}
	
	public String getRecordDate() {
		return date.getFormattedDate();
	}
	
	public String getDoctor() {
		return doctor;
	}
	
}
