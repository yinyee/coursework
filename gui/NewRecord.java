package gui;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import obj.Patient;
import obj.Record;
/**
 * The NewRecord screen launches when the "Add" button in the ViewEditPatient profile is clicked.
 * References:
 * - http://stackoverflow.com/questions/17034282/jfilechooser-regarding-the-open-and-cancel-buttons-java
 * @author yinyee
 */
public class NewRecord extends gui.Record {
	
	private static final long serialVersionUID = 1L;
	private Patient patient;
	
	private final static Logger LOGGER = Logger.getLogger(NewRecord.class.getName());
	
	private JFrame small;
	private JLabel l2Patient;
	private JTextField tDoctor, tAttachment;
	private JTextArea tNotes;
	private JButton bGet, bUpload, bCancel, bSave;
	private ButtonListener listener;
	
	public NewRecord(Patient patient) {
		this.patient = patient;
		draw(this.patient);
	}
	
	private boolean validDate() {
		
		boolean check = true;
		
		if (cboxRecordDate.getSelectedItem().toString() == "31") {
			if (cboxRecordMonth.getSelectedItem().toString() == "February" ||
				cboxRecordMonth.getSelectedItem().toString() == "April" ||
				cboxRecordMonth.getSelectedItem().toString() == "June" ||
				cboxRecordMonth.getSelectedItem().toString() == "September" ||
				cboxRecordMonth.getSelectedItem().toString() == "November") {
				JOptionPane.showMessageDialog(small, "There is no 31st day in " + cboxRecordMonth.getSelectedItem().toString());
				check = false;
			}
		}
		
		if (cboxRecordMonth.getSelectedItem().toString() == "February" && cboxRecordDate.getSelectedItem().toString() == "29") {
			if (Integer.valueOf(cboxRecordYear.getSelectedItem().toString()) % 4 != 0) {
				JOptionPane.showMessageDialog(small, cboxRecordYear.getSelectedItem().toString() + " is not a leap year");
				check = false;
			}
		} else if (cboxRecordMonth.getSelectedItem().toString() == "February" && (cboxRecordDate.getSelectedItem().toString() == "30" ||
				cboxRecordDate.getSelectedItem().toString() == "31")) {
			JOptionPane.showMessageDialog(small, "There are no 30th or 31st days in February");
			check = false;
		}
				
		return check;
	}

	/**
	 * The save() method logs the details of the new record before saving.
	 */
	private void save() {
		
		if (validDate()) {
			// Save to database
			LOGGER.info("First name: " + patient.getFirstName());
			LOGGER.info("Last name: " + patient.getLastName());
			LOGGER.info("Record date: " + cboxRecordDate.getSelectedItem().toString());
			LOGGER.info("Record month: "  + cboxRecordMonth.getSelectedItem().toString());
			LOGGER.info("Record year: " + cboxRecordYear.getSelectedItem().toString());
			LOGGER.info("Doctor: " + tDoctor.getText());
			LOGGER.info("Diagnosis: " + cboxDiagnosis.getSelectedItem().toString());
			LOGGER.info("Notes: " + tNotes.getText());
			LOGGER.info("Attachment: " + tAttachment.getText());
			
			String[] newRecord = new String[9];
			newRecord[0] = patient.getFirstName();
			newRecord[1] = patient.getLastName();
			newRecord[2] = cboxRecordDate.getSelectedItem().toString();
			newRecord[3] = cboxRecordMonth.getSelectedItem().toString();
			newRecord[4] = cboxRecordYear.getSelectedItem().toString();
			newRecord[5] = tDoctor.getText();
			newRecord[6] = cboxDiagnosis.getSelectedItem().toString();
			newRecord[7] = tNotes.getText();
			newRecord[8] = tAttachment.getText();
			
			obj.Record record = new Record(newRecord);
			ViewEditRecord verWindow = new ViewEditRecord(record);
			verWindow.setVisible(true);
			LOGGER.info("New record for " + patient.getFullName() + " saved to database");
			this.dispose();

		}
	}
	
	/**
	 * The cancel() method closes the NewRecord window.
	 */
	private void cancel() {
		this.dispose();
	}
	
	/**
	 * The upload() method allows the user to upload a file to the record.
	 */
	private void upload() {
		try {
			fChooser.setCurrentDirectory(new File(NewRecord.class.getClassLoader().toString()));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg files (*.jpg)", "jpg");
			fChooser.setFileFilter(filter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int m = this.fChooser.showOpenDialog(new JFrame());
		switch(m) {
		case JFileChooser.APPROVE_OPTION :
			tAttachment.setText(fChooser.getSelectedFile().toString());
			break;
		case JFileChooser.CANCEL_OPTION :
			break;
		}
	}
	
	/**
	 * The ButtonListener class is a helper class that directs
	 * the program to perform certain actions, e.g. get information
	 * or save changes, depending on the buttons that the user clicks on.
	 */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Get":
				openWebpage(diseases.getDiseases().get(cboxDiagnosis.getSelectedItem()));
				break;
			case "Save":
				save();
				break;
			case "Cancel":
				cancel();
				break;
			case "Upload" :
				upload();
				break;
			}	
		}	
	}
	
	/**
	 * The draw() method contains code specific to this particular subclass.	
	 */
	private void draw(Patient patient) {
		
		this.setTitle("New Record -- " + patient.getFullName());;
		this.setMinimumSize(DIMENSION);
		Container panel = this.getContentPane();
		panel.setLayout(new GridBagLayout());
		
		// Subclass-specific components
		l2Patient = new JLabel(patient.getFullName());
		tDoctor = new JTextField();		
		tNotes = new JTextArea();
		tNotes.setLineWrap(true);
		tNotes.setEditable(true);
		listener = new ButtonListener();				
		bGet = new JButton("Info");
		bGet.addActionListener(listener);
		bGet.setActionCommand("Get");
		tAttachment = new JTextField();
		bUpload = new JButton("Upload");
		bUpload.addActionListener(listener);
		bUpload.setActionCommand("Upload");
		bCancel = new JButton("Cancel");
		bCancel.addActionListener(listener);
		bCancel.setActionCommand("Cancel");
		bSave = new JButton("Save");
		bSave.addActionListener(listener);
		bSave.setActionCommand("Save");
		
		panel.add(lPatient, clPatient);
		panel.add(l2Patient, cl2Patient);
		panel.add(lRecordDate, clRecordDate);
		panel.add(cboxRecordDate, ccboxRecordDate);
		panel.add(cboxRecordMonth, ccboxRecordMonth);
		panel.add(cboxRecordYear, ccboxRecordYear);
		panel.add(lDoctor, clDoctor);
		panel.add(tDoctor, cl2Doctor);
		panel.add(sHorizontal, csHorizontal);
		panel.add(lDiagnosis, clDiagnosis);
		panel.add(cboxDiagnosis, ccboxDiagnosis);
		panel.add(bGet, cbGet);
		panel.add(lNotes, clNotes);
		panel.add(tNotes, cl2Notes);
		panel.add(lAttachment, clAttachment);
		panel.add(tAttachment, cl2Attachment);
		panel.add(bUpload, cbUpload);
		panel.add(bCancel, cbCancel);
		panel.add(bSave, cbEditSave);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		
	}
	
}
