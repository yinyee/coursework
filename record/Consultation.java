package record;

import person.Patient;

public class Consultation extends Record {
	
	private String notes;
	private String diagnosis;
	private Prescription[] prescription;
	
	public Consultation(Patient patient, int recordDate, int recordMonth, int recordYear, String notes, String diagnosis, Prescription[] prescription) {
		super(patient, recordDate, recordMonth, recordYear);
		this.notes = notes;
		this.diagnosis = diagnosis;
		this.prescription = prescription;
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
	
	public Prescription[] getPrescription() {
		return prescription;
	}
}
