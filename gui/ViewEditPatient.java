package gui;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
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
import obj.Record;

/**
 * The ViewEditPatient class displays patient information and medical records
 * on the first tab and the patient's contact details on the second tab.
 * 
 * In addition to viewing the profile, the user can edit and save the 
 * edited profile, as well as delete the patient's profile.
 * 
 * References:
 * http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/components/IconDemoProject/src/components/IconDemoApp.java
 * 
 * @author yinyee
 *
 */

public class ViewEditPatient extends gui.Patient implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	private obj.Patient patient;
	private String[][] records;
	
	private final static Logger LOGGER = Logger.getLogger(ViewEditPatient.class.getName());
	public final static String RECORDS = "data/records.xml";
	private final static String[] HEADER = {"First name", "Last name", "Record date", "Record month", "Record year", "Doctor", "Diagnosis", "Notes", "Attachment"};

	private JFrame small;
	private int n;
	private JPanel pView, pEdit;
	private CardLayout layout;
	private JLabel lPhoto, lFullName, lGender, lBirthDate, lRecord;
	private JLabel l2EmailAddress, l2MobilePhoneNumber, l2HomePhoneNumber, l2HomeNumberOrName, l2HomeStreet, l2HomeCity, l2HomePostalCode, l2HomeCountry;
	private JLabel leContactDetails, leEmailAddress, leMobilePhoneNumber, leHomePhoneNumber, leHomeAddress, leHomeNumberOrName, leHomeStreet, leHomeCity, leHomePostalCode, leHomeCountry;
	private JSeparator sMainHorizontal, sAddHorizontal, seAddHorizontal;
	private JTable tbRecord;
	private JScrollPane scrRecord;
	private JButton bAdd, bView, bEdit, bCancel, bSave, bDelete;
	private ButtonListener bListener;
	private ImageIcon iPhoto;
	
	private GridBagConstraints clPhoto, csMainHorizontal, clRecord, cscrRecord, cbAdd, cbView, cbDelete;
		
	public ViewEditPatient(obj.Patient patient) {
		
		this.patient = patient;
		this.addMouseListener(this);
		loadRecords();
		
		// Instantiate GUI elements
		tabbedPane = new JTabbedPane();
		pPersonalDetails = new JPanel(new GridBagLayout());
		layout = new CardLayout();
		pContactDetails = new JPanel(layout);
		pView = new JPanel(new GridBagLayout());
		pEdit = new JPanel(new GridBagLayout());
		lPhoto = new JLabel();
		lFullName = new JLabel();
		lGender = new JLabel();
		lBirthDate = new JLabel();
		sMainHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		lRecord = new JLabel("MEDICAL RECORD");
		scrRecord = new JScrollPane(tbRecord);
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
		clPhoto = new GridBagConstraints();
		csMainHorizontal = new GridBagConstraints();
		clRecord = new GridBagConstraints();
		cscrRecord = new GridBagConstraints();
		cbAdd = new GridBagConstraints();
		cbView = new GridBagConstraints();
		cbDelete = new GridBagConstraints();
		l2EmailAddress = new JLabel();
		l2MobilePhoneNumber = new JLabel();
		l2HomePhoneNumber = new JLabel();
		sAddHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		l2HomeNumberOrName = new JLabel();
		l2HomeStreet = new JLabel();
		l2HomeCity = new JLabel();
		l2HomePostalCode = new JLabel();	
		l2HomeCountry = new JLabel();
		bEdit = new JButton("Edit");
		bEdit.addActionListener(bListener);
		bEdit.setActionCommand("Edit");
		leContactDetails = new JLabel("CONTACT DETAILS");
		leEmailAddress = new JLabel("Email address");
		tEmailAddress = new JTextField();
		leMobilePhoneNumber = new JLabel("Mobile phone number");
		tMobilePhoneNumber = new JTextField();
		leHomePhoneNumber = new JLabel("Home phone number");
		tHomePhoneNumber = new JTextField();
		seAddHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		leHomeAddress = new JLabel("HOME ADDRESS");
		leHomeNumberOrName = new JLabel("House number and name");
		tHouseNumberOrName = new JTextField();
		leHomeStreet = new JLabel("Street");
		tStreet = new JTextField();
		leHomeCity = new JLabel("City or town");
		tCity = new JTextField();
		leHomePostalCode = new JLabel("Postal code");
		tPostalCode = new JTextField();
		leHomeCountry = new JLabel("Country");
		tCountry = new JTextField();
		bCancel = new JButton("Cancel");
		bCancel.addActionListener(bListener);
		bCancel.setActionCommand("Cancel");
		bSave = new JButton("Save");
		bSave.addActionListener(bListener);
		bSave.setActionCommand("Save");
		
		draw();
	}
	
	/**
	 * The loadRecords() method fetches the records associated with
	 * this patient from the database.
	 */
	private void loadRecords() {
		try {
			Interpreter interpreter = new Interpreter();
			records = interpreter.retrieveRecords(ViewEditPatient.class.getClassLoader().getResource(RECORDS).toURI(), patient.getFirstName(), patient.getLastName());
			if (records != null) {	
				tbRecord = new JTable(records, HEADER) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
			} else {
				tbRecord = new JTable(5, 10) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
			}				
		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		}

	}
	
	/**
	 * The newRecord() method launches a new NewRecord screen.
	 */
	private void newRecord() {
		NewRecord nrWindow = new NewRecord(this.patient);
		nrWindow.setVisible(true);
	}
	
	/**
	 * The viewRecord() method launches a new ViewRecord screen and populates it 
	 * with the selected record.
	 */
	private void viewRecord() {
		try {
			String[] selection = records[tbRecord.getSelectedRow()];
			ViewEditRecord verWindow = new ViewEditRecord(new Record(selection));
			verWindow.setVisible(true);
		} catch (Exception f) {
			JOptionPane.showMessageDialog(small, "Please select a record.");
			f.printStackTrace();
		}
	}

	/**
	 * The cancel() method prompts the user for confirmation before discarding edits.
	 */
	private void cancel() {
		n = JOptionPane.showConfirmDialog(small, "Changes will be discarded.\nCancel anyway?", "Discard edits", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			LOGGER.info("Edits discarded");
			layout.show(pContactDetails, "View");
		}
	}
	
	/**
	 * The save() method logs the edits made before saving.
	 */
	private void save() {

		if (!tEmailAddress.getText().equals(patient.getEmailAddress())) {
			LOGGER.info("Email address: changed from " + patient.getEmailAddress() + " to " + tEmailAddress.getText());
		}
		if (!tMobilePhoneNumber.getText().equals(patient.getMobilePhoneNumber())) {
			LOGGER.info("Mobile phone number: changed from " + patient.getMobilePhoneNumber() + " to " + tMobilePhoneNumber.getText());
		}
		if (!tHomePhoneNumber.getText().equals(patient.getHomePhoneNumber())) {
			LOGGER.info("Home phone number: changed from " + patient.getHomePhoneNumber() + " to " + tHomePhoneNumber.getText());
		}
		if (!tHouseNumberOrName.getText().equals(patient.getHouseNumberOrName())) {
			LOGGER.info("House number or name: changed from " + patient.getHouseNumberOrName() + " to " + tHouseNumberOrName.getText());
		}
		if (!tStreet.getText().equals(patient.getStreet())) {
			LOGGER.info("Street: changed from " + patient.getStreet() + " to " + tStreet.getText());
		}
		if (!tCity.getText().equals(patient.getCity())) {
			LOGGER.info("City: changed from " + patient.getCity() + " to " + tCity.getText());
		}
		if (!tPostalCode.getText().equals(patient.getPostalCode())) {
			LOGGER.info("Postal code: changed from " + patient.getPostalCode() + " to " + tPostalCode.getText());
		}
		if (!tCountry.getText().equals(patient.getCountry())) {
			LOGGER.info("Country: changed from " + patient.getCountry() + " to " + tCountry.getText());
		}
			
		String[] editedPatient = new String[15];
		editedPatient[0] = patient.getFirstName();
		editedPatient[1] = patient.getLastName();
		editedPatient[2] = patient.getGender();
		editedPatient[3] = patient.getBirthDate();
		editedPatient[4] = patient.getBirthMonth();
		editedPatient[5] = patient.getBirthYear();
		editedPatient[6] = tEmailAddress.getText();
		editedPatient[7] = tMobilePhoneNumber.getText();
		editedPatient[8] = tHomePhoneNumber.getText();
		editedPatient[9] = tHouseNumberOrName.getText();
		editedPatient[10] = tStreet.getText();
		editedPatient[11] = tCity.getText();
		editedPatient[12] = tPostalCode.getText();
		editedPatient[13] = tCountry.getText();
		editedPatient[14] = patient.getPhoto();
		
		try {
			Interpreter interpreter = new Interpreter();
			interpreter.saveEditedPatient(ViewEditPatient.class.getClassLoader().getResource(Dashboard.PATIENT).toURI(), patient.getPatientData(), editedPatient);
		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		}
				
		patient = new obj.Patient(editedPatient);
		draw();
		layout.show(pContactDetails, "View");
		
		LOGGER.info("Saved edits to patient " + patient.getFullName());
	}
	
	/**
	 * The delete() method prompts for user confirmation before deleting the patient 
	 * from the system.
	 */
	private void delete() {
		n = JOptionPane.showConfirmDialog(small, "Are you sure you want\n to delete this patient?", "Delete Patient", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			try {
				Interpreter interpreter = new Interpreter();
				interpreter.deletePatient(ViewEditPatient.class.getClassLoader().getResource(Dashboard.PATIENT).toURI(),  this.patient.getPatientData());
			} catch (URISyntaxException urise) {
				urise.printStackTrace();
			}
			
			LOGGER.severe(patient.getFullName() + "deleted");
			JOptionPane.showMessageDialog(small, "Patient deleted");
			this.dispose();					
		}
	}
	
	/**
	 * The refresh() method revalidates the GUI.
	 */
	private void refresh() {
		loadRecords();
		draw();
	}
	
	/**
	 * The ButtonListener class is a helper class that directs the program to 
	 * perform certain actions, e.g. get information or save changes, depending 
	 * on the buttons that the user clicks on.
	 */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
					
			switch (e.getActionCommand()) {
			case "Add" :
				newRecord();
				break;
			case "View" :
				viewRecord();
				break;
			case "Edit" : 
				layout.show(pContactDetails, "Edit");
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
			}		
		}
	}
		
	/**
	 * The scalePhoto() method loads and scales the patient's photo.
	 */
	private void scalePhoto() {
	
		try {
			File file = new File(ViewEditPatient.class.getClassLoader().getResource(patient.getPhoto()).toURI());
			ImageIcon original = new ImageIcon(file.toString());
			Image unscaled = original.getImage();
			Image scaled = unscaled.getScaledInstance(75, 100, java.awt.Image.SCALE_SMOOTH);
			iPhoto = new ImageIcon(scaled);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			LOGGER.info("Cannot load photo");
		}
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	private void draw() {

		this.setTitle("View/Edit -- " + patient.getFullName());
		this.setMaximumSize(DIMENSION);
		this.setLocationRelativeTo(null);

		// Main tab
		scalePhoto();
		lPhoto.setIcon(iPhoto);
		lFullName.setText(patient.getFullName());
		lGender.setText(patient.getGender());;
		lBirthDate.setText("Born " + patient.getFormattedBirthDate());;
		tbRecord.setMinimumSize(tbRecord.getPreferredSize());
		tbRecord.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbRecord.setAutoCreateRowSorter(true);
		scrRecord.setViewportView(tbRecord);
		scrRecord.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrRecord.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		clPhoto.gridx = 0;
		clPhoto.gridy = 0;
		clPhoto.gridwidth = 1;
		clPhoto.gridheight = 3;
		clPhoto.fill = GridBagConstraints.HORIZONTAL;
		clPhoto.fill = GridBagConstraints.VERTICAL;
		clPhoto.insets = STANDARDINSETS;
		
		cbDelete.gridx = 2;
		cbDelete.gridy = 0;
		cbDelete.gridwidth = 1;
		cbDelete.gridheight = 1;
		cbDelete.insets = STANDARDINSETS;
		
		csMainHorizontal.gridx = 0;
		csMainHorizontal.gridy = 3;
		csMainHorizontal.gridwidth = 3;
		csMainHorizontal.gridheight = 1;
		csMainHorizontal.fill = GridBagConstraints.HORIZONTAL;
		csMainHorizontal.insets = STANDARDINSETS;

		clRecord.gridx = 0;
		clRecord.gridy = 4;
		clRecord.gridwidth = 1;
		clRecord.gridheight = 1;
		clRecord.fill = GridBagConstraints.HORIZONTAL;
		clRecord.insets = STANDARDINSETS;

		cscrRecord.gridx = 0;
		cscrRecord.gridy = 5;
		cscrRecord.gridwidth = 3;
		cscrRecord.gridheight = 1;
		cscrRecord.fill = GridBagConstraints.HORIZONTAL;
		cscrRecord.fill = GridBagConstraints.VERTICAL;
		cscrRecord.insets = STANDARDINSETS;

		cbAdd.gridx = 1;
		cbAdd.gridy = 6;
		cbAdd.gridwidth = 1;
		cbAdd.gridheight = 1;
		cbAdd.anchor = GridBagConstraints.LINE_END;
		cbAdd.insets = STANDARDINSETS;

		cbView.gridx = 2;
		cbView.gridy = 6;
		cbView.gridwidth = 1;
		cbView.gridheight = 1;
		cbView.anchor = GridBagConstraints.LINE_END;
		cbView.insets = STANDARDINSETS;

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
		l2EmailAddress.setText(patient.getEmailAddress());
		l2MobilePhoneNumber.setText(patient.getMobilePhoneNumber());
		l2HomePhoneNumber.setText(patient.getHomePhoneNumber());
		l2HomeNumberOrName.setText(patient.getHouseNumberOrName());
		l2HomeStreet.setText(patient.getStreet());
		l2HomeCity.setText(patient.getCity());
		l2HomePostalCode.setText(patient.getPostalCode());	
		l2HomeCountry.setText(patient.getCountry());
				
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
		tEmailAddress.setText(patient.getEmailAddress());
		tMobilePhoneNumber.setText(patient.getMobilePhoneNumber());
		tHomePhoneNumber.setText(patient.getHomePhoneNumber());
		tHouseNumberOrName.setText(patient.getHouseNumberOrName());
		tStreet.setText(patient.getStreet());
		tCity.setText(patient.getCity());
		tPostalCode.setText(patient.getPostalCode());
		tCountry.setText(patient.getCountry());

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
		pEdit.add(tHouseNumberOrName, cl2HomeNumberOrName);
		pEdit.add(leHomeStreet, clHomeStreet);
		pEdit.add(tStreet, cl2HomeStreet);
		pEdit.add(leHomeCity, clHomeCity);
		pEdit.add(tCity, cl2HomeCity);
		pEdit.add(leHomePostalCode, clHomePostalCode);
		pEdit.add(tPostalCode, cl2HomePostalCode);
		pEdit.add(leHomeCountry, clHomeCountry);
		pEdit.add(tCountry, cl2HomeCountry);
		pEdit.add(bCancel, cbCancel);
		pEdit.add(bSave, cbEditSave);
		
		pContactDetails.add(pView, "View");
		pContactDetails.add(pEdit, "Edit");
		
		tabbedPane.addTab("Main", pPersonalDetails);
		tabbedPane.addTab("Additional", pContactDetails);
		
		this.getContentPane().add(tabbedPane);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		
	}

	/**
	 * Not implemented
	 */
	public void mouseClicked(MouseEvent e) {
		;
	}

	/**
	 * Not implemented
	 */
	public void mousePressed(MouseEvent e) {
		;
	}

	/**
	 * Not implemented
	 */
	public void mouseReleased(MouseEvent e) {
		;
	}

	/**
	 * When a mouseEntered event occurs, the GUI is refreshed.
	 * @param e The mouse entering the frame
	 */
	public void mouseEntered(MouseEvent e) {
		refresh();
		
	}

	/**
	 * Not implemented
	 */
	public void mouseExited(MouseEvent e) {;
		
	}
	
}
