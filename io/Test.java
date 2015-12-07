package io;

import gui.ViewEditPatient;

public class Test {

	public static void main(String[] args) {
		
		String[] record = new String[9];
		record[0] = "Alex";
		record[1] = "Nair";
		record[2] = "19";
		record[3] = "October";
		record[4] = "2015";
		record[5] = "Dr.Andrews";
		record[6] = "Mesothelioma";
		record[7] = "Chest pain, shortness of breath, tiredness (fatigue), sweating and high temperatures, persistent cough, losing weight when not dieting, loss of appetite, difficulty swallowing, hhoarse or husky voice.";
		record[8] = "data/img5.jpg";
		System.out.println("Hello");
		Interpreter interpreter = new Interpreter();
		interpreter.deleteRecord(ViewEditPatient.RECORDS, record);

	}

}
