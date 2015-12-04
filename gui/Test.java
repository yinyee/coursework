package gui;

import java.awt.EventQueue;

import person.NextOfKin;
import person.Patient;
import person.util.Address;
import record.Record;

public class Test {
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = Login.getInstance();
//					Address homeAddress = new Address("15, Croydon House", "Wootton Street", "London", "SE1 8TS", "United Kingdom");
//					Address billingAddress = new Address("15, Croydon House", "Wootton Street", "London", "SE1 8TS", "United Kingdom");
//					NextOfKin nextOfKin = new NextOfKin("Yin Wei", "Kan", "kanyinwei@gmail.com", "Sibling",
//							"+640987987987", "+64090123983");
//					Patient patient = new Patient("Yin Yee", "Kan", "yin.kan.15@ucl.ac.uk.com", "Female", "8", "December", "1983",
//							"07931155585", "07931155585", "07931155585", homeAddress, billingAddress, nextOfKin);
//					Profile window = Profile.getInstance(patient);
//					Record record = new Record(patient, "5", "December", "2015", "Dr. House", "LKMLKMLK", "Ugh", "Atta");
//					ViewEditRecord window = ViewEditRecord.getInstance(record);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
