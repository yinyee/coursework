package gui;

import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import record.Consultation;
import record.util.Diseases;

/**
 * 
 * 
 * @author yinyee
 *
 */

public class ViewEditRecord {
	
	private static ViewEditRecord instance = null;
	private static Diseases diseases;
	private Consultation record;
	
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	private JPanel pCard, pView, pEdit;
	private JFrame frame;
	private JLabel lPatient, l2Patient, lRecordDate,  l2RecordDate, lDoctor, l2Doctor, lNotes, l2Notes, lDiagnosis, l2Diagnosis, lAttachment, l2Attachment;
	private JLabel lePatient, le2Patient, leRecordDate, leDoctor, leNotes, leDiagnosis, leAttachment, le2Attachment;
	private JTextField le2RecordDate, le2Doctor, le2Notes;
	private JComboBox<String> cboxDiagnosis;
	private JSeparator sHorizontal, seHorizontal;
	private JButton bEdit, bGet, bCancel, bSave;
	private CardController cardController;
	private ButtonListener bListener;
	
	private ViewEditRecord(Consultation record) {
		this.record = record;
		draw(record);
	}
	
	/**
	 * The getInstance() method enforces the Singleton design pattern.
	 * @param record
	 */
	public static ViewEditRecord getInstance(Consultation record) {
		if (instance == null) {
			instance = new ViewEditRecord(record);
		}
		return instance;
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	public void draw(Consultation record) {
	
		frame = new JFrame("View and Edit Record");
		pCard = new JPanel(new CardLayout());
		pView = new JPanel(new GridBagLayout());
		pEdit = new JPanel(new GridBagLayout());
		
		// View card
		
		lPatient = new JLabel("Patient");
		l2Patient = new JLabel(record.getPatient().getFullName());
		lRecordDate = new JLabel("Date");
		l2RecordDate = new JLabel(record.getRecordDate());
		lDoctor = new JLabel("Doctor");
		l2Doctor = new JLabel(record.getDoctor());
		sHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		lNotes = new JLabel("Notes");
		l2Notes = new JLabel(record.getNotes());
		lDiagnosis = new JLabel("Diagnosis");
		l2Diagnosis = new JLabel(record.getDiagnosis());
		lAttachment = new JLabel("Attachment");
		l2Attachment = new JLabel("WIP");
		bEdit = new JButton("Edit");
		cardController = new CardController();
		bEdit.addActionListener(cardController);
		bEdit.setActionCommand("Edit");
		
		GridBagConstraints clPatient = new GridBagConstraints();
		GridBagConstraints cl2Patient = new GridBagConstraints();
		GridBagConstraints clRecordDate = new GridBagConstraints();
		GridBagConstraints cl2RecordDate = new GridBagConstraints();
		GridBagConstraints clDoctor = new GridBagConstraints();
		GridBagConstraints cl2Doctor = new GridBagConstraints();
		GridBagConstraints csHorizontal = new GridBagConstraints();
		GridBagConstraints clNotes = new GridBagConstraints();
		GridBagConstraints cl2Notes = new GridBagConstraints();
		GridBagConstraints clDiagnosis = new GridBagConstraints();
		GridBagConstraints cl2Diagnosis = new GridBagConstraints();
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

		cl2RecordDate.gridx = 1;
		cl2RecordDate.gridy = 1;
		cl2RecordDate.gridwidth = 1;
		cl2RecordDate.gridheight = 1;
		cl2RecordDate.fill = GridBagConstraints.HORIZONTAL;
		cl2RecordDate.insets = standardInsets;
		
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

		cl2Diagnosis.gridx = 1;
		cl2Diagnosis.gridy = 5;
		cl2Diagnosis.gridwidth = 1;
		cl2Diagnosis.gridheight = 1;
		cl2Diagnosis.fill = GridBagConstraints.HORIZONTAL;
		cl2Diagnosis.insets = standardInsets;

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

		pView.add(lPatient, clPatient);
		pView.add(l2Patient, cl2Patient);
		pView.add(lRecordDate, clRecordDate);
		pView.add(l2RecordDate, cl2RecordDate);
		pView.add(lDoctor, clDoctor);
		pView.add(l2Doctor, cl2Doctor);
		pView.add(sHorizontal, csHorizontal);
		pView.add(lNotes, clNotes);
		pView.add(l2Notes, cl2Notes);
		pView.add(lDiagnosis, clDiagnosis);
		pView.add(l2Diagnosis, cl2Diagnosis);
		pView.add(lAttachment, clAttachment);
		pView.add(l2Attachment, cl2Attachment);
		pView.add(bEdit, cbEdit);
		
		// Edit card
		
		lePatient = new JLabel("Patient");
		le2Patient = new JLabel(record.getPatient().getFullName());
		leRecordDate = new JLabel("Date");
		le2RecordDate = new JTextField(record.getRecordDate());
		leDoctor = new JLabel("Doctor");
		le2Doctor = new JTextField(record.getDoctor());
		seHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		leNotes = new JLabel("Notes");
		le2Notes = new JTextField(record.getNotes());
		leDiagnosis = new JLabel("Diagnosis");
		diseases = new Diseases();
		cboxDiagnosis = new JComboBox<String>(diseases.getList());
		bGet = new JButton("Get information");
		bListener = new ButtonListener();
		bGet.addActionListener(bListener);
		leAttachment = new JLabel("Attachment");
		le2Attachment = new JLabel("WIP");
		bCancel = new JButton("Cancel");
		bCancel.addActionListener(cardController);
		bCancel.setActionCommand("Cancel");
		bSave = new JButton("Save");
		bSave.addActionListener(cardController);
		bSave.setActionCommand("Save");

		GridBagConstraints cbGet = new GridBagConstraints();
		GridBagConstraints cbCancel = new GridBagConstraints();
		GridBagConstraints cbSave = new GridBagConstraints();

		cbGet.gridx = 2;
		cbGet.gridy = 5;
		cbGet.gridwidth = 1;
		cbGet.gridheight = 1;
		cbGet.fill = GridBagConstraints.HORIZONTAL;
		cbGet.insets = standardInsets;
		
		cbCancel.gridx = 0;
		cbCancel.gridy = 7;
		cbCancel.gridwidth = 1;
		cbCancel.gridheight = 1;
		cbCancel.fill = GridBagConstraints.HORIZONTAL;
		cbCancel.insets = standardInsets;

		cbSave.gridx = 1;
		cbSave.gridy = 7;
		cbSave.gridwidth = 1;
		cbSave.gridheight = 1;
		cbSave.fill = GridBagConstraints.HORIZONTAL;
		cbSave.insets = standardInsets;
		
		pEdit.add(lePatient, clPatient);
		pEdit.add(le2Patient, cl2Patient);
		pEdit.add(leRecordDate, clRecordDate);
		pEdit.add(le2RecordDate, cl2RecordDate);
		pEdit.add(leDoctor, clDoctor);
		pEdit.add(le2Doctor, cl2Doctor);
		pEdit.add(seHorizontal, csHorizontal);
		pEdit.add(leNotes, clNotes);
		pEdit.add(le2Notes, cl2Notes);
		pEdit.add(leDiagnosis, clDiagnosis);
		pEdit.add(cboxDiagnosis, cl2Diagnosis);
		pEdit.add(bGet, cbGet);
		pEdit.add(leAttachment, clAttachment);
		pEdit.add(le2Attachment, cl2Attachment);
		pEdit.add(bCancel, cbCancel);
		pEdit.add(bSave, cbSave);
		
		pCard.add(pView, "View");
		pCard.add(pEdit, "Edit");
		
		frame.getContentPane().add(pCard);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
		
	private class CardController implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			CardLayout layout = (CardLayout)(pCard.getLayout());
			switch(e.getActionCommand()) {
			case "Edit" : 
				layout.show(pCard, "Edit");
				break;
			case "Cancel" :
				layout.show(pCard, "View");
				break;
			case "Save" :
				// Save to file!!
				layout.show(pCard, "View");
				break;
			}
		}	
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			openWebpage(diseases.getDiseases().get(cboxDiagnosis.getSelectedItem()));
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
