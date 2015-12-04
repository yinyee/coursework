package record;

import person.Patient;

public class Consultation extends Record {
	
	private String notes;
	private String diagnosis;
	private String attachment;
	
	public Consultation(Patient patient, String recordDate, String recordMonth, String recordYear, String doctor, String notes, String diagnosis, String attachment) {
		super(patient, recordDate, recordMonth, recordYear, doctor);
		this.notes = notes;
		this.diagnosis = diagnosis;
		this.attachment = attachment;
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
