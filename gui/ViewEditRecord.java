package gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import person.NextOfKin;
import person.Patient;
import person.Patient.Gender;
import person.util.Address;
import person.util.Insurance;
import record.Consultation;

/**
 * 
 * 
 * @author yinyee
 *
 */

public class ViewEditRecord {
	
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	private static JPanel pCard = new JPanel(new CardLayout());
	private static JPanel pView = new JPanel(new GridBagLayout());
	private static JPanel pEdit = new JPanel(new GridBagLayout());
	private static CardController cardController;
	
	public ViewEditRecord() {
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Address homeAddress = new Address("15, Croydon House", "Wootton Street", "London", "SE1 8TS", "United Kingdom");
					Address billingAddress = new Address("15, Croydon House", "Wootton Street", "London", "SE1 8TS", "United Kingdom");
					Insurance insurance = new Insurance("Allianz", "ABC0988776");
					NextOfKin nextOfKin = new NextOfKin("Yin Wei", "Kan", "kanyinwei@gmail.com", "Sibling",
							"+640987987987", "+64090123983");
					Patient patient = new Patient("Yin Yee", "Kan", "yin.kan.15@ucl.ac.uk.com", Gender.FEMALE, 8, 12, 1983,
							"07931155585", "07931155585", "07931155585", homeAddress, billingAddress, insurance, nextOfKin);
					Consultation record = new Consultation(patient, 5, 12, 2015, "Dr. House", "LKMLKMLK", "Ugh");
					ViewEditRecord window = new ViewEditRecord();
					cardController = window. new CardController();
					window.draw(record);
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
	}
	
	public void draw(Consultation record) {
		
		JFrame frame = new JFrame("View and Edit Record");
		
		// View card
		
		JLabel lPatient = new JLabel("Patient");
		JLabel l2Patient = new JLabel(record.getPatient().getfullName());
		JLabel lRecordDate = new JLabel("Date (dd/mm/yyyy)");
		JLabel l2RecordDate = new JLabel(record.getRecordDate());
		JLabel lDoctor = new JLabel("Doctor");
		JLabel l2Doctor = new JLabel(record.getDoctor());
		JSeparator sHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		JLabel lNotes = new JLabel("Notes");
		JLabel l2Notes = new JLabel(record.getNotes());
		JLabel lDiagnosis = new JLabel("Diagnosis");
		JLabel l2Diagnosis = new JLabel(record.getDiagnosis());
		JLabel lAttachment = new JLabel("Attachment");
		JLabel l2Attachment = new JLabel("WIP");
		JButton bEdit = new JButton("Edit");
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
		
		JLabel lePatient = new JLabel("Patient");
		JLabel le2Patient = new JLabel(record.getPatient().getfullName());
		JLabel leRecordDate = new JLabel("Date (dd/mm/yyyy)");
		JTextField le2RecordDate = new JTextField(record.getRecordDate());
		JLabel leDoctor = new JLabel("Doctor");
		JTextField le2Doctor = new JTextField(record.getDoctor());
		JSeparator seHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		JLabel leNotes = new JLabel("Notes");
		JTextField le2Notes = new JTextField(record.getNotes());
		JLabel leDiagnosis = new JLabel("Diagnosis");
		JTextField le2Diagnosis = new JTextField(record.getDiagnosis());
		JLabel leAttachment = new JLabel("Attachment");
		JLabel le2Attachment = new JLabel("WIP");
		JButton bCancel = new JButton("Cancel");
		bCancel.addActionListener(cardController);
		bCancel.setActionCommand("Cancel");
		JButton bSave = new JButton("Save");
		bSave.addActionListener(cardController);
		bSave.setActionCommand("Save");

		GridBagConstraints cbCancel = new GridBagConstraints();
		GridBagConstraints cbSave = new GridBagConstraints();

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
		pEdit.add(le2Diagnosis, cl2Diagnosis);
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
				System.out.println("Working");
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


}
