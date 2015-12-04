package record;

import person.Patient;

public class Prescription extends Record {
	
	private String drugName;
	private int dosage;
	private Times times;
	private Frequency frequency;
	private Instruction instruction;
	
	public Prescription(Patient patient, String recordDate, String recordMonth, String recordYear, String doctor,
			String drugName, int dosage, Times times, Frequency frequency, Instruction instruction) {
		super(patient, recordDate, recordMonth, recordYear, doctor);
		this.drugName = drugName;
		this.dosage = dosage;
		this.times = times;
		this.frequency = frequency;
		this.instruction = instruction;
	}

	public String getDrugName() {
		return drugName;
	}
	
	public int getDosage() {
		return dosage;
	}
	
	public Times getTimes() {
		return times;
	}
	
	public Frequency getFrequency() {
		return frequency;
	}
	
	public Instruction getInstruction() {
		return instruction;
	}
	
	/** Helper enum classes */
	
	public enum Times {
		ONCE,
		TWICE,
		THRICE;
	}
	
	public enum Frequency {
		DAILY,
		WEEKLY;
	}

	public enum Instruction {
		BEFORE_MEALS,
		AFTER_MEALS;
	}
}
