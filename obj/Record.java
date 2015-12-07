package obj;

public class Record {
	
	private String patientFirstName;
	private String patientLastName;
	private String recordDate;
	private String recordMonth;
	private String recordYear;
	private String doctor;	
	private String diagnosis;
	private String notes;
	private String attachment;
	
	public Record(String[] recordData) {
		this.patientFirstName = recordData[0];
		this.patientLastName = recordData[1];
		this.recordDate = recordData[2];
		this.recordMonth = recordData[3];
		this.recordYear = recordData[4];
		this.doctor = recordData[5];
		this.diagnosis = recordData[6];
		this.notes = recordData[7];
		this.attachment = recordData[8];
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}
	
	public String getPatientLastName() {
		return patientLastName;
	}
	
	public String getPatientFullName() {
		return patientLastName + ", " + patientFirstName;
	}
	
	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String newRecordDate) {
		recordDate = newRecordDate;
	}

	public String getRecordMonth() {
		return recordMonth;
	}

	public void setRecordMonth(String newRecordMonth) {
		recordMonth = newRecordMonth;
	}

	public String getRecordYear() {
		return recordYear;
	}

	public void setRecordYear(String newRecordYear) {
		recordYear = newRecordYear;
	}

	public String getFormattedDate() {
		return recordMonth + " " + recordDate + ", " + recordYear;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String newDoctor) {
		doctor = newDoctor;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String newDiagnosis) {
		diagnosis = newDiagnosis;
	}
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String editedNotes) {
		notes = editedNotes;
	}
	
	public void addNotes(String additionalNotes) {
		StringBuilder str = new StringBuilder(notes);
		str.append(additionalNotes);
		notes = str.toString();
	}
	
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String newAttachment) {
		attachment = newAttachment;
	}

}
