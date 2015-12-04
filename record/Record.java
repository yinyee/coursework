package record;

import person.Patient;
import record.util.Date;

public class Record {
	
	private Patient patient;
	private Date date;
	private String doctor;	
	private String notes;
	private String diagnosis;
	private String attachment;
	
	public Record(Patient patient, String recordDate, String recordMonth, String recordYear, String doctor, String notes, String diagnosis, String attachment) {
		this.patient = patient;
		this.date = new Date(recordDate, recordMonth, recordYear);
		this.doctor = doctor;
		this.notes = notes;
		this.diagnosis = diagnosis;
		this.attachment = attachment;
	}

	public Patient getPatient() {
		return patient;
	}
	
	public String getRecordDate() {
		return date.getFormalFormattedDate();
	}
	
	public String getDoctor() {
		return doctor;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void addNotes(String additionalNotes) {
		StringBuilder str = new StringBuilder(notes);
		str.append(additionalNotes);
		notes = str.toString();
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	
	public String getAttachment() {
		return attachment;
	}
	
}
