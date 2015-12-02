package record;

import person.Patient;
import util.Date;

public class Record {
	
	private Patient patient;
	private Date date;
	
	public Record (Patient patient, int recordDate, int recordMonth, int recordYear) {
		this.patient = patient;
		this.date = new Date(recordDate, recordMonth, recordYear);
	}

	public Patient getPatient() {
		return patient;
	}
	
	public Date getRecordDate() {
		return date;
	}
	
}
