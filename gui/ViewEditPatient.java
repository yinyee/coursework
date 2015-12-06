package gui;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import io.Interpreter;
import obj.Patient;
import obj.Record;

/**
 * The Profile class displays patient information and medical records
 * on the first tab and the patient's contact details on the second tab.
 * 
 * In addition to viewing the profile, the user can edit and save the 
 * edited profile, as well as delete the patient's profile.
 * 
 * @author yinyee
 *
 */

public class ViewEditPatient extends gui.Patient {
	
	private Patient patient;
	private String[][] records;
	
	private final static String database = "data/records.xml";
	private final static String[] header = {"First name", "Last name", "Record date", "Record month", "Record year", "Doctor", "Diagnosis", "Notes", "Attachment"};
	
	private JFrame frame;
	private JPanel pView, pEdit;
	private CardLayout layout;
	private JLabel lPhoto, lFullName, lGender, lBirthDate, lRecord;
	private JLabel leContactDetails, leEmailAddress, leMobilePhoneNumber, leHomePhoneNumber, leHomeAddress, leHomeNumberOrName, leHomeStreet, leHomeCity, leHomePostalCode, leHomeCountry;
	private JSeparator sMainHorizontal, seAddHorizontal;
	private JTable tbRecord;
	private JScrollPane scrRecord;
	private JButton bAdd, bView, bEdit, bCancel, bSave, bDelete;
	private ButtonListener bListener;
	
	public ViewEditPatient(Patient patient) {
		this.patient = patient;
		this.records = loadRecords(patient);
		draw(patient);
	}
	
	/**
	 * The loadRecords() method fetches the records associated with
	 * this patient from the database.
	 */
	private String[][] loadRecords(Patient patient) {
		Interpreter interpreter = new Interpreter();
		return interpreter.retrieveRecords(database, patient.getFirstName(), patient.getLastName());
	}
	
	/**
	 * What does this do?
	 * @param patient
	 */
	private void addNewRecord(Patient patient) {
		NewRecord newRecord = new NewRecord(patient);
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
			case "Add" :
				addNewRecord(patient);
				break;
			case "View" :
				try {
					String[] selection = records[tbRecord.getSelectedRow()];
					ViewEditRecord verWindow = new ViewEditRecord(new Record(selection));					
				} catch (Exception f) {
					f.printStackTrace();
				}
				break;
			case "Edit" : 
				layout.show(pContactDetails, "Edit");
				break;
			case "Cancel" :
				layout.show(pContactDetails, "View");
				break;
			case "Save" :
				// Save to file!! lPhoto is temp
				String[] edittedPatient = new String[15];
				edittedPatient[0] = patient.getFirstName();
				edittedPatient[1] = patient.getLastName();
				edittedPatient[2] = patient.getGender();
				edittedPatient[3] = patient.getBirthDate();
				edittedPatient[4] = patient.getBirthMonth();
				edittedPatient[5] = patient.getBirthYear();
				edittedPatient[6] = tEmailAddress.getText();
				edittedPatient[7] = tMobilePhoneNumber.getText();
				edittedPatient[8] = tHomePhoneNumber.getText();
				edittedPatient[9] = tHomeNumberOrName.getText();
				edittedPatient[10] = tHomeStreet.getText();
				edittedPatient[11] = tHomeCity.getText();
				edittedPatient[12] = tHomePostalCode.getText();
				edittedPatient[13] = tHomeCountry.getText();
				edittedPatient[14] = lPhoto.getText();
				patient = new Patient(edittedPatient);
				layout.show(pContactDetails, "View");
				pContactDetails.validate();
				break;
			case "Delete" :
				JFrame small = new JFrame();
				int n = JOptionPane.showConfirmDialog(small, "Are you sure you want\n to delete this patient?", "Delete Patient", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					// Delete from database
					JOptionPane.showMessageDialog(small, "Patient deleted");
					frame.dispose();					
				}
				if (n == JOptionPane.NO_OPTION) {
					small.dispose();
				}
				break;
			}		
		}
	}
		
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	private void draw(Patient patient) {
		
		frame = new JFrame("Patient Profile - " + patient.getFullName());
		frame.setMaximumSize(dimension);
		tabbedPane = new JTabbedPane();
		pPersonalDetails = new JPanel(new GridBagLayout());
		layout = new CardLayout();
		pContactDetails = new JPanel(layout);
		pView = new JPanel(new GridBagLayout());
		pEdit = new JPanel(new GridBagLayout());

		// Main tab
		lPhoto = new JLabel();
		lFullName = new JLabel(patient.getFullName());
		lGender = new JLabel(patient.getGender());
		lBirthDate = new JLabel("Born " + patient.getFormattedBirthDate());
		sMainHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		lRecord = new JLabel("MEDICAL RECORD");
		tbRecord = new JTable(records, header) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tbRecord.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbRecord.setMinimumSize(tbRecord.getPreferredSize());
		tbRecord.setAutoCreateRowSorter(true);
		scrRecord = new JScrollPane(tbRecord);
		scrRecord.setViewportView(tbRecord);
		scrRecord.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrRecord.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		bListener = new ButtonListener();
		bDelete = new JButton("Delete Patient");
		bDelete.addActionListener(bListener);
		bDelete.setActionCommand("Delete");
		bAdd = new JButton("Add New Record");
		bAdd.addActionListener(bListener);
		bAdd.setActionCommand("Add");
		bView = new JButton("View Record");
		bView.addActionListener(bListener);
		bView.setActionCommand("View");

		GridBagConstraints clPhoto = new GridBagConstraints();
		GridBagConstraints csMainHorizontal = new GridBagConstraints();
		GridBagConstraints clRecord = new GridBagConstraints();
		GridBagConstraints cscrRecord = new GridBagConstraints();
		GridBagConstraints cbAdd = new GridBagConstraints();
		GridBagConstraints cbView = new GridBagConstraints();
		GridBagConstraints cbDelete = new GridBagConstraints();
		
		clPhoto.gridx = 0;
		clPhoto.gridy = 0;
		clPhoto.gridwidth = 1;
		clPhoto.gridheight = 3;
		clPhoto.fill = GridBagConstraints.HORIZONTAL;
		clPhoto.fill = GridBagConstraints.VERTICAL;
		clPhoto.insets = standardInsets;
		
		cbDelete.gridx = 2;
		cbDelete.gridy = 0;
		cbDelete.gridwidth = 1;
		cbDelete.gridheight = 1;
		cbDelete.insets = standardInsets;
		
		csMainHorizontal.gridx = 0;
		csMainHorizontal.gridy = 3;
		csMainHorizontal.gridwidth = 3;
		csMainHorizontal.gridheight = 1;
		csMainHorizontal.fill = GridBagConstraints.HORIZONTAL;
		csMainHorizontal.insets = standardInsets;

		clRecord.gridx = 0;
		clRecord.gridy = 4;
		clRecord.gridwidth = 1;
		clRecord.gridheight = 1;
		clRecord.fill = GridBagConstraints.HORIZONTAL;
		clRecord.insets = standardInsets;

		cscrRecord.gridx = 0;
		cscrRecord.gridy = 5;
		cscrRecord.gridwidth = 3;
		cscrRecord.gridheight = 1;
		cscrRecord.fill = GridBagConstraints.HORIZONTAL;
		cscrRecord.fill = GridBagConstraints.VERTICAL;
		cscrRecord.insets = standardInsets;

		cbAdd.gridx = 1;
		cbAdd.gridy = 6;
		cbAdd.gridwidth = 1;
		cbAdd.gridheight = 1;
		cbAdd.anchor = GridBagConstraints.LINE_END;
		cbAdd.insets = standardInsets;

		cbView.gridx = 2;
		cbView.gridy = 6;
		cbView.gridwidth = 1;
		cbView.gridheight = 1;
		cbView.anchor = GridBagConstraints.LINE_END;
		cbView.insets = standardInsets;

		pPersonalDetails.add(lPhoto, clPhoto);
		pPersonalDetails.add(lFullName, ctName);
		pPersonalDetails.add(bDelete, cbDelete);
		pPersonalDetails.add(lGender, ccboxGender);
		pPersonalDetails.add(lBirthDate, ccboxBirthMonth);
		pPersonalDetails.add(sMainHorizontal, csMainHorizontal);
		pPersonalDetails.add(lRecord, clRecord);
		pPersonalDetails.add(scrRecord, cscrRecord);
		pPersonalDetails.add(bAdd, cbAdd);
		pPersonalDetails.add(bView, cbView);
		
		// Additional tab
		// Use Card layout to switch between View and Edit
		// View card
		JLabel l2EmailAddress = new JLabel(patient.getEmailAddress());
		JLabel l2MobilePhoneNumber = new JLabel(patient.getMobilePhoneNumber());
		JLabel l2HomePhoneNumber = new JLabel(patient.getHomePhoneNumber());
		JSeparator sAddHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		JLabel l2HomeNumberOrName = new JLabel(patient.getHouseNumberOrName());
		JLabel l2HomeStreet = new JLabel(patient.getStreet());
		JLabel l2HomeCity = new JLabel(patient.getCity());
		JLabel l2HomePostalCode = new JLabel(patient.getPostalCode());	
		JLabel l2HomeCountry = new JLabel(patient.getCountry());
		bEdit = new JButton("Edit");
		bEdit.addActionListener(bListener);
		bEdit.setActionCommand("Edit");
				
		pView.add(lContactDetails, clContactDetails);
		pView.add(lEmailAddress, clEmailAddress);
		pView.add(l2EmailAddress, cl2EmailAddress);
		pView.add(lMobilePhoneNumber, clMobilePhoneNumber);
		pView.add(l2MobilePhoneNumber, cl2MobilePhoneNumber);
		pView.add(lHomePhoneNumber, clHomePhoneNumber);
		pView.add(l2HomePhoneNumber, cl2HomePhoneNumber);
		pView.add(sAddHorizontal, csHorizontal);
		pView.add(lHomeAddress, clHomeAddress);
		pView.add(lHomeNumberOrName, clHomeNumberOrName);
		pView.add(l2HomeNumberOrName, cl2HomeNumberOrName);
		pView.add(lHomeStreet, clHomeStreet);
		pView.add(l2HomeStreet, cl2HomeStreet);
		pView.add(lHomeCity, clHomeCity);
		pView.add(l2HomeCity, cl2HomeCity);
		pView.add(lHomePostalCode, clHomePostalCode);
		pView.add(l2HomePostalCode, cl2HomePostalCode);
		pView.add(lHomeCountry, clHomeCountry);
		pView.add(l2HomeCountry, cl2HomeCountry);
		pView.add(bEdit, cbEditSave);
		
		// Edit card
		
		leContactDetails = new JLabel("CONTACT DETAILS");
		leEmailAddress = new JLabel("Email address");
		tEmailAddress = new JTextField(patient.getEmailAddress());
		leMobilePhoneNumber = new JLabel("Mobile phone number");
		tMobilePhoneNumber = new JTextField(patient.getMobilePhoneNumber());
		leHomePhoneNumber = new JLabel("Home phone number");
		tHomePhoneNumber = new JTextField(patient.getHomePhoneNumber());
		seAddHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		leHomeAddress = new JLabel("HOME ADDRESS");
		leHomeNumberOrName = new JLabel("House number and name");
		tHomeNumberOrName = new JTextField(patient.getHouseNumberOrName());
		leHomeStreet = new JLabel("Street");
		tHomeStreet = new JTextField(patient.getStreet());
		leHomeCity = new JLabel("City or town");
		tHomeCity = new JTextField(patient.getCity());
		leHomePostalCode = new JLabel("Postal code");
		tHomePostalCode = new JTextField(patient.getPostalCode());
		leHomeCountry = new JLabel("Country");
		tHomeCountry = new JTextField(patient.getCountry());
		bCancel = new JButton("Cancel");
		bCancel.addActionListener(bListener);
		bCancel.setActionCommand("Cancel");
		bSave = new JButton("Save");
		bSave.addActionListener(bListener);
		bSave.setActionCommand("Save");
				
		pEdit.add(leContactDetails, clContactDetails);
		pEdit.add(leEmailAddress, clEmailAddress);
		pEdit.add(tEmailAddress, cl2EmailAddress);
		pEdit.add(leMobilePhoneNumber, clMobilePhoneNumber);
		pEdit.add(tMobilePhoneNumber, cl2MobilePhoneNumber);
		pEdit.add(leHomePhoneNumber, clHomePhoneNumber);
		pEdit.add(tHomePhoneNumber, cl2HomePhoneNumber);
		pEdit.add(seAddHorizontal, csHorizontal);
		pEdit.add(leHomeAddress, clHomeAddress);
		pEdit.add(leHomeNumberOrName, clHomeNumberOrName);
		pEdit.add(tHomeNumberOrName, cl2HomeNumberOrName);
		pEdit.add(leHomeStreet, clHomeStreet);
		pEdit.add(tHomeStreet, cl2HomeStreet);
		pEdit.add(leHomeCity, clHomeCity);
		pEdit.add(tHomeCity, cl2HomeCity);
		pEdit.add(leHomePostalCode, clHomePostalCode);
		pEdit.add(tHomePostalCode, cl2HomePostalCode);
		pEdit.add(leHomeCountry, clHomeCountry);
		pEdit.add(tHomeCountry, cl2HomeCountry);
		pEdit.add(bCancel, cbCancel1);
		pEdit.add(bSave, cbEditSave);
		
		pContactDetails.add(pView, "View");
		pContactDetails.add(pEdit, "Edit");
		
		tabbedPane.addTab("Main", pPersonalDetails);
		tabbedPane.addTab("Additional", pContactDetails);
		
		frame.getContentPane().add(tabbedPane);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}