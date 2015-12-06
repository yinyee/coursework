package gui;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import obj.Record;

/**
 * This screen displays the selected record, which the user can view, edit and save edits, or delete.
 * 
 * References:
 * >> http://stackoverflow.com/questions/26420428/how-to-word-wrap-text-in-jlabel
 * >> https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/DialogDemoProject/src/components/DialogDemo.java
 * @author yinyee
 *
 */

public class ViewEditRecord extends gui.Record {
	
	private Record record;
	
	private JFrame frame;
	private JPanel pCard, pView, pEdit;
	private CardLayout layout;
	private JLabel l2Patient, l2RecordDate, l2Doctor, l2Diagnosis, l2Attachment;
	private JLabel lePatient, le2Patient, leRecordDate, leDoctor, leDiagnosis, leNotes, leAttachment;
	private JTextField tDoctor, tAttachment;
	private JTextArea tNotes, t2Notes;
	private JSeparator seHorizontal;
	private JButton bEdit, bGet, b2Get, bDelete, bCancel, bSave;
	private ButtonListener bListener;
	
	public ViewEditRecord(Record record) {
		this.record = record;
		draw(this.record);
	}
	
	/**
	 * The ButtonListener class is a helper class that directs
	 * the program to perform certain actions, e.g. get information
	 * or save changes, depending on the buttons that the user clicks on.
	 */
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "Edit" : 
				layout.show(pCard, "Edit");
				break;
			case "Cancel" :
				layout.show(pCard, "View");
				break;
			case "Save" :
				// Save to database
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
				record = new Record(editedRecord);
				draw(record);
				layout.show(pCard, "View");
				break;
			case "Delete" :
				JFrame small = new JFrame();
				int n = JOptionPane.showConfirmDialog(small, "Are you sure you want\n to delete this record?", "Delete Record", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					// Delete from database
					JOptionPane.showMessageDialog(small, "Record deleted");
					frame.dispose();					
				}
				if (n == JOptionPane.NO_OPTION) {
					small.dispose();
				}
				break;
			case "Get" :
				openWebpage(diseases.getDiseases().get(cboxDiagnosis.getSelectedItem()));
				break;
			}
		}	
	}
		
	/**
	 * The draw() method contains code specific to this
	 * particular subclass.	
	 */
	public void draw(Record record) {
	
		frame = new JFrame("View/Edit Record -- " + record.getPatientFullName());
		frame.setMinimumSize(dimension);
		layout = new CardLayout();
		pCard = new JPanel(layout);
		pView = new JPanel(new GridBagLayout());
		pEdit = new JPanel(new GridBagLayout());
		
		// View card
		
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
		l2Attachment = new JLabel(record.getAttachment());
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
		
		lePatient = new JLabel("Patient");
		le2Patient = new JLabel(record.getPatientFullName());
		leRecordDate = new JLabel("Date");
		cboxRecordDate.setSelectedIndex(record.getRecordDateAsInt()-1);
		cboxRecordMonth.setSelectedIndex(record.getRecordMonthAsInt());
		leDoctor = new JLabel("Doctor");
		tDoctor = new JTextField(record.getDoctor());
		seHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		leDiagnosis = new JLabel("Diagnosis");
		cboxDiagnosis.setSelectedIndex(diseases.getDiseaseAsInt(record.getDiagnosis()));
		b2Get = new JButton("Info");
		b2Get.addActionListener(bListener);
		b2Get.setActionCommand("Get");
		leNotes = new JLabel("Notes");
		t2Notes = new JTextArea(record.getNotes());
		t2Notes.setLineWrap(true);
		leAttachment = new JLabel("Attachment");
		tAttachment = new JTextField(record.getAttachment());
		bCancel = new JButton("Cancel");
		bCancel.addActionListener(bListener);
		bCancel.setActionCommand("Cancel");
		bSave = new JButton("Save");
		bSave.addActionListener(bListener);
		bSave.setActionCommand("Save");
		bDelete = new JButton("Delete Record");
		bDelete.addActionListener(bListener);
		bDelete.setActionCommand("Delete");

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
		pEdit.add(bDelete, cbDelete);
		pEdit.add(bCancel, cbCancel);
		pEdit.add(bSave, cbEditSave);
		
		pCard.add(pView, "View");
		pCard.add(pEdit, "Edit");
		
		frame.getContentPane().add(pCard);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}
