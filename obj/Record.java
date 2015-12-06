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

	public int getRecordDateAsInt() {
		return Integer.valueOf(recordDate);
	}
	
	public int getRecordMonthAsInt() {
		int i = 0;
		switch(recordMonth) {
		case "January" : 
			i = 0;
			break;
		case "February": 
			i = 1;
			break;
		case "March" : 
			i = 2;
			break;
		case "April" : 
			i = 3;
			break;
		case "May" : 
			i = 4;
			break;
		case "June" : 
			i = 5;
			break;
		case "July" : 
			i = 6;
			break;
		case "August" : 
			i = 7;
			break;
		case "September" : 
			i = 8;
			break;
		case "October" : 
			i = 9;
			break;
		case "November" : 
			i = 10;
			break;
		case "December" : 
			i = 11;
			break;
		}
		return i;
	}
	
	public int getRecordYearAsInt() {
		return Integer.valueOf(recordYear);
	}

}
