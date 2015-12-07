package gui;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import obj.Record;

/**
 * The ViewEditRecord screen displays the selected record, which the user can view, edit and save edits, or delete.
 * 
 * References:
 * - http://stackoverflow.com/questions/26420428/how-to-word-wrap-text-in-jlabel
 * - https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/DialogDemoProject/src/components/DialogDemo.java
 * - http://stackoverflow.com/questions/9596468/open-only-xml-file-in-jfilechooser
 * @author yinyee
 *
 */

public class ViewEditRecord extends gui.Record {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(ViewEditRecord.class.getName());
	private obj.Record record;
	
	private JFrame small;
	private int n;
	private JPanel pCard, pView, pEdit;
	private CardLayout layout;
	private JLabel l2Patient, l2RecordDate, l2Doctor, l2Diagnosis, l2Attachment;
	private JLabel lePatient, le2Patient, leRecordDate, leDoctor, leDiagnosis, leNotes, leAttachment;
	private JTextField tDoctor, tAttachment;
	private JTextArea tNotes, t2Notes;
	private JSeparator seHorizontal;
	private JButton bEdit, bGet, b2Get, bDelete, bUpload, bCancel, bSave;
	private ButtonListener bListener;
	private ImageIcon iAttachment;
	
	public ViewEditRecord(Record record) {
		this.record = record;
		draw();
	}
	
	/**
	 * The cancel() method prompts the user for confirmation before discarding edits.
	 */
	private void cancel() {
		n = JOptionPane.showConfirmDialog(small, "Changes will be discarded.\nCancel anyway?", "Discard edits", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			LOGGER.info("Edits discarded");
			layout.show(pCard, "View");
			pCard.validate();
		}
	}
	
	/**
	 * The validDate() method imposes constraints on the input dates.
	 */
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
		}
		
		if (cboxRecordMonth.getSelectedItem().toString() == "February" && (cboxRecordDate.getSelectedItem().toString() == "30" ||
				cboxRecordDate.getSelectedItem().toString() == "31")) {
			JOptionPane.showMessageDialog(small, "There are no 30th or 31st days in February");
			check = false;
		}
				
		return check;
	}
	
	/**
	 * The save() method logs the edits made before saving.
	 */
	private void save() {
		
		if (validDate()) {
			
			if (!cboxRecordDate.getSelectedItem().toString().equals(record.getRecordDate())) {
				LOGGER.info("Record date: changed from " + record.getRecordDate() + " to " + cboxRecordDate.getSelectedItem().toString());
			}
			
			if (!cboxRecordMonth.getSelectedItem().toString().equals(record.getRecordMonth())) {
				LOGGER.info("Record month: changed from " + record.getRecordMonth() + " to " + cboxRecordMonth.getSelectedItem().toString());
			}
			
			if (!cboxRecordYear.getSelectedItem().toString().equals(record.getRecordYear())) {
				LOGGER.info("Record year: changed from " + record.getRecordYear() + " to " + cboxRecordYear.getSelectedItem().toString());
			}
			
			if (!tDoctor.getText().equals(record.getDoctor())) {
				LOGGER.info("Doctor: changed from " + record.getDoctor() + " to " + tDoctor.getText());
			}
			
			if (!cboxDiagnosis.getSelectedItem().toString().equals(record.getDiagnosis())) {
				LOGGER.warning("Diagnosis: changed from " + record.getDiagnosis() + " to " + cboxDiagnosis.getSelectedItem().toString());
			}
			
			if (!tNotes.getText().equals(record.getNotes())) {
				LOGGER.info("Notes: changed from " + record.getNotes() + " to " + tNotes.getText());
			}
			
			if (!tAttachment.getText().equals(record.getAttachment())) {
				LOGGER.info("Attachment: changed from " + record.getAttachment() + " to " + tAttachment.getText());
			}
			
			String[] editedRecord = new String[9];
			editedRecord[0] = record.getPatientFirstName();
			editedRecord[1] = record.getPatientLastName();
			editedRecord[2] = cboxRecordDate.getSelectedItem().toString();
			editedRecord[3] = cboxRecordMonth.getSelectedItem().toString();
			editedRecord[4] = cboxRecordYear.getSelectedItem().toString();
			editedRecord[5] = tDoctor.getText();
			editedRecord[6] = cboxDiagnosis.getSelectedItem().toString();
			editedRecord[7] = t2Notes.getText();
			editedRecord[8] = tAttachment.getText();
			
			record = new obj.Record(editedRecord);
			// Save to database
			draw();
			layout.show(pCard, "View");
			
			LOGGER.info("Saved edits to record for " + record.getPatientFullName());
		}
	}
	/**
	 * The delete() method prompts the user for confirmation before deleting the record.
	 */
	private void delete() {
		n = JOptionPane.showConfirmDialog(small, "Are you sure you want\n to delete this record?", "Delete Record", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			// Delete from database
			JOptionPane.showMessageDialog(small, "Record deleted");
			LOGGER.severe("Record for " + record.getPatientFullName() + " has been deleted");
			this.dispose();					
		}
		if (n == JOptionPane.NO_OPTION) {
			small.dispose();
		}		
	}
	
	/**
	 * The upload() method allows the user to upload an attachment to the record.
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
	 * The ButtonListener class is a helper class that directs the program to 
	 * perform certain actions, e.g. get information or save changes, depending 
	 * on the buttons that the user clicks on.
	 */
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch(e.getActionCommand()) {
			case "Edit" : 
				layout.show(pCard, "Edit");
				break;
			case "Cancel" :
				cancel();
				break;
			case "Save" :		
				save();
				break;
			case "Delete" :
				delete();
				break;
			case "Get" :
				openWebpage(diseases.getDiseases().get(cboxDiagnosis.getSelectedItem()));
				break;
			case "Upload":
				upload();
				break;
			}
		}	
	}
	
	/**
	 * The scalePhoto() method loads and scales the patient's photo.
	 */
	private void scalePhoto() {
		
		try {
			File file = new File(ViewEditPatient.class.getClassLoader().getResource(record.getAttachment()).toURI());
			ImageIcon original = new ImageIcon(file.toString());
			Image unscaled = original.getImage();
			Image scaled = unscaled.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
			iAttachment = new ImageIcon(scaled);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			LOGGER.info("Cannot load photo");
		}
	}
		
	/**
	 * The draw() method contains code specific to this
	 * particular subclass.	
	 */
	public void draw() {
	
		this.setTitle("View/Edit Record -- " + record.getPatientFullName());
		this.setMinimumSize(DIMENSION);
		layout = new CardLayout();
		pCard = new JPanel(layout);
		pView = new JPanel(new GridBagLayout());
		pEdit = new JPanel(new GridBagLayout());
		
		// View card
		scalePhoto();
		l2Patient = new JLabel(record.getPatientFullName());
		l2RecordDate = new JLabel(record.getFormattedDate());
		l2Doctor = new JLabel(record.getDoctor());
		l2Diagnosis = new JLabel(record.getDiagnosis());
		bListener = new ButtonListener();
		bGet = new JButton("Info");
		bGet.addActionListener(bListener);
		bGet.setActionCommand("Get");
		tNotes = new JTextArea(record.getNotes());
		tNotes.setEditable(false);
		tNotes.setLineWrap(true);
		tNotes.setBackground(UIManager.getColor("Label.background"));
		l2Attachment = new JLabel(iAttachment);
		bEdit = new JButton("Edit");
		bEdit.addActionListener(bListener);
		bEdit.setActionCommand("Edit");
		
		pView.add(lPatient, clPatient);
		pView.add(l2Patient, cl2Patient);
		pView.add(lRecordDate, clRecordDate);
		pView.add(l2RecordDate, ccboxRecordMonth);
		pView.add(lDoctor, clDoctor);
		pView.add(l2Doctor, cl2Doctor);
		pView.add(sHorizontal, csHorizontal);
		pView.add(lDiagnosis, clDiagnosis);
		pView.add(l2Diagnosis, ccboxDiagnosis);
		pView.add(bGet, cbGet);
		pView.add(lNotes, clNotes);
		pView.add(tNotes, cl2Notes);
		pView.add(lAttachment, clAttachment);
		pView.add(l2Attachment, cl2Attachment);
		pView.add(bEdit, cbEditSave);
		
		// Edit card
		
		bDelete = new JButton("Delete Record");
		bDelete.addActionListener(bListener);
		bDelete.setActionCommand("Delete");		
		lePatient = new JLabel("Patient");
		le2Patient = new JLabel(record.getPatientFullName());
		leRecordDate = new JLabel("Date");
		cboxRecordDate.setSelectedItem(record.getRecordDate());
		cboxRecordMonth.setSelectedItem(record.getRecordMonth());
		cboxRecordYear.setSelectedItem(record.getRecordYear());
		leDoctor = new JLabel("Doctor");
		tDoctor = new JTextField(record.getDoctor());
		seHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		leDiagnosis = new JLabel("Diagnosis");
		cboxDiagnosis.setSelectedItem(record.getDiagnosis());
		b2Get = new JButton("Info");
		b2Get.addActionListener(bListener);
		b2Get.setActionCommand("Get");
		leNotes = new JLabel("Notes");
		t2Notes = new JTextArea(record.getNotes());
		t2Notes.setLineWrap(true);
		leAttachment = new JLabel("Attachment");
		tAttachment = new JTextField(record.getAttachment());
		bUpload = new JButton("Upload");
		bUpload.addActionListener(bListener);
		bUpload.setActionCommand("Upload");
		bCancel = new JButton("Cancel");
		bCancel.addActionListener(bListener);
		bCancel.setActionCommand("Cancel");
		bSave = new JButton("Save");
		bSave.addActionListener(bListener);
		bSave.setActionCommand("Save");
		
		pEdit.add(bDelete, cbDelete);
		pEdit.add(lePatient, clPatient);
		pEdit.add(le2Patient, cl2Patient);
		pEdit.add(leRecordDate, clRecordDate);
		pEdit.add(cboxRecordDate, ccboxRecordDate);
		pEdit.add(cboxRecordMonth, ccboxRecordMonth);
		pEdit.add(cboxRecordYear, ccboxRecordYear);
		pEdit.add(leDoctor, clDoctor);
		pEdit.add(tDoctor, cl2Doctor);
		pEdit.add(seHorizontal, csHorizontal);
		pEdit.add(leDiagnosis, clDiagnosis);
		pEdit.add(cboxDiagnosis, ccboxDiagnosis);
		pEdit.add(b2Get, cbGet);
		pEdit.add(leNotes, clNotes);
		pEdit.add(t2Notes, cl2Notes);
		pEdit.add(leAttachment, clAttachment);
		pEdit.add(tAttachment, cl2Attachment);
		pEdit.add(bUpload, cbUpload);
		pEdit.add(bCancel, cbCancel);
		pEdit.add(bSave, cbEditSave);
		
		pCard.add(pView, "View");
		pCard.add(pEdit, "Edit");
		
		this.getContentPane().add(pCard);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		
	}

}
