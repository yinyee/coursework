package gui;

import java.awt.Container;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import person.Patient;
import record.util.Diseases;

public class NewRecord {
	
	private static NewRecord instance = null;
	private static Diseases diseases;
	
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	private final static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	private JFrame frame;
	private JLabel lPatient, l2Patient,lRecordDate, lDoctor, lNotes, lDiagnosis, lAttachment;
	private JTextField tDoctor, tNotes, tAttachment;
	private JComboBox<String> cboxRecordDate, cboxRecordMonth, cboxRecordYear, cboxDiagnosis;
	private JSeparator sHorizontal;
	private JButton bGet, bSave;
	private ButtonListener listener;
	
	private NewRecord(Patient patient) {
		draw(patient);
	}
	
	/**
	 * The getInstance() method enforces the Singleton design pattern.
	 * @param record
	 */
	public static NewRecord getInstance(Patient patient) {
		if (instance == null) {
			instance = new NewRecord(patient);
		}
		return instance;
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	private void draw(Patient patient) {
		
		frame = new JFrame("New Record");
		Container panel = frame.getContentPane();
		panel.setLayout(new GridBagLayout());
		
		lPatient = new JLabel("Patient");
		l2Patient = new JLabel(patient.getFullName());
		lRecordDate = new JLabel("Date");
		String[] dates = new String[31];
		for (int i = 0; i < 31; i++) {
			dates[i] = Integer.toString(i + 1);
		}
		cboxRecordDate = new JComboBox<String>(dates);
		cboxRecordMonth = new JComboBox<String>(months);
		String[] years = new String[200];
		for (int i = 0; i < 200; i++) {
			years[i] = Integer.toString(i + 1916);
		}
		cboxRecordYear = new JComboBox<String>(years);
		lDoctor = new JLabel("Doctor");
		tDoctor = new JTextField();
		sHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		lNotes = new JLabel("Notes");
		tNotes = new JTextField();
		lDiagnosis = new JLabel("Diagnosis");
		diseases = new Diseases();
		cboxDiagnosis = new JComboBox<String>(diseases.getList());
		bGet = new JButton("Get information");
		listener = new ButtonListener();
		bGet.addActionListener(listener);
		bGet.setActionCommand("Get");
		lAttachment = new JLabel("Attachment");
		tAttachment = new JTextField();
		bSave = new JButton("Save");
		bSave.addActionListener(listener);
		
		GridBagConstraints clPatient = new GridBagConstraints();
		GridBagConstraints cl2Patient = new GridBagConstraints();
		GridBagConstraints clRecordDate = new GridBagConstraints();
		GridBagConstraints ccboxRecordDate = new GridBagConstraints();
		GridBagConstraints ccboxRecordMonth = new GridBagConstraints();
		GridBagConstraints ccboxRecordYear = new GridBagConstraints();
		GridBagConstraints clDoctor = new GridBagConstraints();
		GridBagConstraints cl2Doctor = new GridBagConstraints();
		GridBagConstraints csHorizontal = new GridBagConstraints();
		GridBagConstraints clNotes = new GridBagConstraints();
		GridBagConstraints cl2Notes = new GridBagConstraints();
		GridBagConstraints clDiagnosis = new GridBagConstraints();
		GridBagConstraints ccboxDiagnosis = new GridBagConstraints();
		GridBagConstraints cbGet = new GridBagConstraints();
		GridBagConstraints clAttachment = new GridBagConstraints();
		GridBagConstraints cl2Attachment = new GridBagConstraints();
		GridBagConstraints cbEdit = new GridBagConstraints();
		
		clPatient.gridx = 0;
		clPatient.gridy = 0;
		clPatient.gridwidth = 1;
		clPatient.gridheight = 1;
		clPatient.fill = GridBagConstraints.HORIZONTAL;
		clPatient.insets = standardInsets;

		cl2Patient.gridx = 1;
		cl2Patient.gridy = 0;
		cl2Patient.gridwidth = 1;
		cl2Patient.gridheight = 1;
		cl2Patient.fill = GridBagConstraints.HORIZONTAL;
		cl2Patient.insets = standardInsets;

		clRecordDate.gridx = 0;
		clRecordDate.gridy = 1;
		clRecordDate.gridwidth = 1;
		clRecordDate.gridheight = 1;
		clRecordDate.fill = GridBagConstraints.HORIZONTAL;
		clRecordDate.insets = standardInsets;

		ccboxRecordDate.gridx = 1;
		ccboxRecordDate.gridy = 1;
		ccboxRecordDate.gridwidth = 1;
		ccboxRecordDate.gridheight = 1;
		ccboxRecordDate.fill = GridBagConstraints.HORIZONTAL;
		ccboxRecordDate.insets = standardInsets;
		
		ccboxRecordMonth.gridx = 2;
		ccboxRecordMonth.gridy = 1;
		ccboxRecordMonth.gridwidth = 1;
		ccboxRecordMonth.gridheight = 1;
		ccboxRecordMonth.fill = GridBagConstraints.HORIZONTAL;
		ccboxRecordMonth.insets = standardInsets;

		ccboxRecordYear.gridx = 3;
		ccboxRecordYear.gridy = 1;
		ccboxRecordYear.gridwidth = 1;
		ccboxRecordYear.gridheight = 1;
		ccboxRecordYear.fill = GridBagConstraints.HORIZONTAL;
		ccboxRecordYear.insets = standardInsets;		
		
		clDoctor.gridx = 0;
		clDoctor.gridy = 2;
		clDoctor.gridwidth = 1;
		clDoctor.gridheight = 1;
		clDoctor.fill = GridBagConstraints.HORIZONTAL;
		clDoctor.insets = standardInsets;

		cl2Doctor.gridx = 1;
		cl2Doctor.gridy = 2;
		cl2Doctor.gridwidth = 1;
		cl2Doctor.gridheight = 1;
		cl2Doctor.fill = GridBagConstraints.HORIZONTAL;
		cl2Doctor.insets = standardInsets;

		csHorizontal.gridx = 0;
		csHorizontal.gridy = 3;
		csHorizontal.gridwidth = 2;
		csHorizontal.gridheight = 1;
		csHorizontal.fill = GridBagConstraints.HORIZONTAL;
		csHorizontal.insets = standardInsets;

		clNotes.gridx = 0;
		clNotes.gridy = 4;
		clNotes.gridwidth = 1;
		clNotes.gridheight = 1;
		clNotes.fill = GridBagConstraints.HORIZONTAL;
		clNotes.insets = standardInsets;

		cl2Notes.gridx = 1;
		cl2Notes.gridy = 4;
		cl2Notes.gridwidth = 1;
		cl2Notes.gridheight = 1;
		cl2Notes.fill = GridBagConstraints.HORIZONTAL;
		cl2Notes.insets = standardInsets;

		clDiagnosis.gridx = 0;
		clDiagnosis.gridy = 5;
		clDiagnosis.gridwidth = 1;
		clDiagnosis.gridheight = 1;
		clDiagnosis.fill = GridBagConstraints.HORIZONTAL;
		clDiagnosis.insets = standardInsets;

		ccboxDiagnosis.gridx = 1;
		ccboxDiagnosis.gridy = 5;
		ccboxDiagnosis.gridwidth = 1;
		ccboxDiagnosis.gridheight = 1;
		ccboxDiagnosis.fill = GridBagConstraints.HORIZONTAL;
		ccboxDiagnosis.insets = standardInsets;

		cbGet.gridx = 2;
		cbGet.gridy = 5;
		cbGet.gridwidth = 1;
		cbGet.gridheight = 1;
		cbGet.fill = GridBagConstraints.HORIZONTAL;
		cbGet.insets = standardInsets;
		
		clAttachment.gridx = 0;
		clAttachment.gridy = 6;
		clAttachment.gridwidth = 1;
		clAttachment.gridheight = 1;
		clAttachment.fill = GridBagConstraints.HORIZONTAL;
		clAttachment.insets = standardInsets;

		cl2Attachment.gridx = 1;
		cl2Attachment.gridy = 6;
		cl2Attachment.gridwidth = 1;
		cl2Attachment.gridheight = 1;
		cl2Attachment.fill = GridBagConstraints.HORIZONTAL;
		cl2Attachment.insets = standardInsets;

		cbEdit.gridx = 1;
		cbEdit.gridy = 7;
		cbEdit.gridwidth = 1;
		cbEdit.gridheight = 1;
		cbEdit.fill = GridBagConstraints.HORIZONTAL;
		cbEdit.insets = standardInsets;

		panel.add(lPatient, clPatient);
		panel.add(l2Patient, cl2Patient);
		panel.add(lRecordDate, clRecordDate);
		panel.add(cboxRecordDate, ccboxRecordDate);
		panel.add(cboxRecordMonth, ccboxRecordMonth);
		panel.add(cboxRecordYear, ccboxRecordYear);
		panel.add(lDoctor, clDoctor);
		panel.add(tDoctor, cl2Doctor);
		panel.add(sHorizontal, csHorizontal);
		panel.add(lNotes, clNotes);
		panel.add(tNotes, cl2Notes);
		panel.add(lDiagnosis, clDiagnosis);
		panel.add(cboxDiagnosis, ccboxDiagnosis);
		panel.add(bGet, cbGet);
		panel.add(lAttachment, clAttachment);
		panel.add(tAttachment, cl2Attachment);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Get":
				openWebpage(diseases.getDiseases().get(cboxDiagnosis.getSelectedItem()));
				break;
			case "Save":
				//Save
				break;
			}
			
		}
		
	}

	/**
	 * Reference: http://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
	 * @param uri
	 */
	
	private void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	private void openWebpage(URL url) {
	    try {
	        openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}


}
