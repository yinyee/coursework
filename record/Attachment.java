package record;

import java.io.File;

import person.Patient;

public class Attachment extends Record {

	private String notes;
	private File attachment;
	
	public Attachment(Patient patient, String recordDate, String recordMonth, String recordYear, String doctor, String notes, File attachment) {
		super(patient, recordDate, recordMonth, recordYear, doctor);
		this.notes = notes;
		this.attachment = attachment;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void addNotes(String additionalNotes) {
		StringBuilder str = new StringBuilder(this.notes);
		str.append(additionalNotes);
		notes = str.toString();
	}
	
	public File getAttachment() {
		return attachment;
	}
	
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}
}
