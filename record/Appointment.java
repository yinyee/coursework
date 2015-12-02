package record;

import person.Doctor;
import person.Patient;

public class Appointment extends Record {

	private Doctor doctor;
	
	public Appointment (Patient patient, int appointmentDate, int appointmentMonth, int appointmentYear, Doctor doctor) {
		super(patient, appointmentDate, appointmentMonth, appointmentYear);
		this.doctor = doctor;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
}
