package patientrecords;

public class PatientRecord {
	
	private int recordDate;
	private int recordMonth;
	private int recordYear; // Enforce 4-digit year
	
	public PatientRecord (int recordDate, int recordMonth, int recordYear) {
		this.recordDate = recordDate;
		this.recordMonth = recordMonth;
		this.recordYear = recordYear;
	}

}
