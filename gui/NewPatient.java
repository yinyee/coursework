package gui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import io.Interpreter;
import obj.Patient;

/**
 * The NewPatient screen launches when the "Register" button in the Dashboard is clicked.
 *  
 *  References used:
 *  >> https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html
 *  
 * @author yinyee
 *
 */

public class NewPatient extends gui.Patient {

	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(NewPatient.class.getName());
	private final static String[] MONTHS = {"---", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private final static String[] GENDER = {"---", "Female", "Male"};
	private final JFileChooser fChooser = new JFileChooser();
	
	private JFrame small;
	private JLabel lFirstName, lLastName, lGender, lBirthDate, lPhoto;
	private JTextField tFirstName, tLastName, tPhoto;
	private JButton bUpload;
	private JComboBox<String> cboxGender, cboxBirthDate, cboxBirthMonth, cboxBirthYear;
	private JButton bCancel, bSave;
	private ButtonListener listener;

	public NewPatient() {
		draw();
	}
	
	private void cancel() {
		this.dispose();
	}
	
	private boolean validDate() {
		
		boolean check = true;
		
		if (cboxBirthDate.getSelectedItem().toString() == "31") {
			if (cboxBirthMonth.getSelectedItem().toString() == "February" ||
				cboxBirthMonth.getSelectedItem().toString() == "April" ||
				cboxBirthMonth.getSelectedItem().toString() == "June" ||
				cboxBirthMonth.getSelectedItem().toString() == "September" ||
				cboxBirthMonth.getSelectedItem().toString() == "November") {
				JOptionPane.showMessageDialog(small, "There is no 31st day in " + cboxBirthMonth.getSelectedItem().toString());
				check = false;
			}
		}
		
		if (cboxBirthMonth.getSelectedItem().toString() == "February" && cboxBirthDate.getSelectedItem().toString() == "29") {
			if (Integer.valueOf(cboxBirthYear.getSelectedItem().toString()) % 4 != 0) {
				JOptionPane.showMessageDialog(small, cboxBirthYear.getSelectedItem().toString() + " is not a leap year");
				check = false;
			}
		} else if (cboxBirthMonth.getSelectedItem().toString() == "February" && (cboxBirthDate.getSelectedItem().toString() == "30" ||
				cboxBirthDate.getSelectedItem().toString() == "31")) {
			JOptionPane.showMessageDialog(small, "There are no 30th or 31st days in February");
			check = false;
		}
				
		return check;

	}
	
	/**
	 * The save() method logs the details of the new patient before saving.
	 */
	private void save() {
		
		if (tFirstName.getText().equals("") || tLastName.getText().equals("") || cboxGender.getSelectedIndex() == 0 || cboxBirthDate.getSelectedIndex() == 0 || 
				cboxBirthMonth.getSelectedIndex() == 0 || cboxBirthYear.getSelectedIndex() == 0 || tPhoto.getText().equals("")) {
			JOptionPane.showMessageDialog(small, "The minimum information required\nto register a new patient are:\n"
					+ "- first name\n- last name\n- gender\n- birth date\n- birth month\n- birth year\n- photo");
		} else if (validDate()) {
			
			LOGGER.info("First name: " + tFirstName.getText());
			LOGGER.info("Last name: " + tLastName.getText());
			LOGGER.info("Gender: " + cboxGender.getSelectedItem().toString());
			LOGGER.info("Birth date: " + cboxBirthDate.getSelectedItem().toString());
			LOGGER.info("Birth month: " + cboxBirthMonth.getSelectedItem().toString());
			LOGGER.info("Birth year: "+ cboxBirthYear.getSelectedItem().toString());
			LOGGER.info("Email address: " + tEmailAddress.getText());
			LOGGER.info("Mobile phone number: " + tMobilePhoneNumber.getText());
			LOGGER.info("Home phone number: " + tHomePhoneNumber.getText());
			LOGGER.info("House number and name: " + tHouseNumberOrName.getText());
			LOGGER.info("Street: " + tStreet.getText());
			LOGGER.info("City: " + tCity.getText());
			LOGGER.info("Postal code: " + tPostalCode.getText());
			LOGGER.info("Country: " + tCountry.getText());
			LOGGER.info("Photo: " + tPhoto.getText());
			
			String[] newPatient = new String[15];
			newPatient[0] = tFirstName.getText();
			newPatient[1] = tLastName.getText();
			newPatient[2] = cboxGender.getSelectedItem().toString();
			newPatient[3] = cboxBirthDate.getSelectedItem().toString();
			newPatient[4] = cboxBirthMonth.getSelectedItem().toString();
			newPatient[5] = cboxBirthYear.getSelectedItem().toString();
			newPatient[6] = tEmailAddress.getText();
			newPatient[7] = tMobilePhoneNumber.getText();
			newPatient[8] = tHomePhoneNumber.getText();
			newPatient[9] = tHouseNumberOrName.getText();
			newPatient[10] = tStreet.getText();
			newPatient[11] = tCity.getText();
			newPatient[12] = tPostalCode.getText();
			newPatient[13] = tCountry.getText();
			newPatient[14] = tPhoto.getText();
			
			obj.Patient patient = new Patient(newPatient);
			
			try {
				Interpreter interpreter = new Interpreter();
				interpreter.saveNewPatient(NewPatient.class.getClassLoader().getResource(Dashboard.PATIENT).toURI(), newPatient);				
			} catch (URISyntaxException urise) {
				urise.printStackTrace();
			}
			
			LOGGER.info("New patient " + patient.getFullName() + " saved to database");
			
			ViewEditPatient vepWindow = new ViewEditPatient(patient);
			vepWindow.setVisible(true);
			this.dispose();
						
		}		
	}
	
	private void upload() {
		try {
			fChooser.setCurrentDirectory(new File(NewRecord.class.getClassLoader().toString()));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg files (*.jpg)", "jpg");
			fChooser.setFileFilter(filter);
		} catch (Exception f) {
			f.printStackTrace();
		}
		
		int m = this.fChooser.showOpenDialog(new JFrame());
		switch(m) {
		case JFileChooser.APPROVE_OPTION :
			tPhoto.setText(fChooser.getSelectedFile().toString());
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
			case "Upload" :
				upload();
				break;
			case "Save" :
				save();
				break;
			case "Cancel" :
				cancel();
			}
		}
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	
	private void draw() {
		
		this.setTitle("Register New Patient");
		this.setMaximumSize(DIMENSION);
		
		// Subclass-specific components
		// Personal details tab
		lFirstName = new JLabel("First name");
		tFirstName = new JTextField();
		lLastName = new JLabel("Last name");		
		tLastName = new JTextField();
		lGender = new JLabel("Gender");
		cboxGender = new JComboBox<String>(GENDER);
		lBirthDate = new JLabel("Date of birth");
		String[] dates = new String[32];
		dates[0] = "---";
		for (int i = 0; i < 31; i++) {
			dates[i + 1] = Integer.toString(i + 1);
		}
		cboxBirthDate = new JComboBox<String>(dates);
		cboxBirthMonth = new JComboBox<String>(MONTHS);		
		String[] years = new String[101];
		years[0] = "---";
		for (int i = 0; i < 100; i++) {
			years[i + 1] = Integer.toString(i + 1916);
		}
		cboxBirthYear = new JComboBox<String>(years);
		lPhoto = new JLabel("Photo");
		tPhoto = new JTextField();
		listener = new ButtonListener();
		bUpload = new JButton("Upload");
		bUpload.addActionListener(listener);
		bUpload.setActionCommand("Upload");
		
		GridBagConstraints clFirstName = new GridBagConstraints();
		GridBagConstraints clLastName = new GridBagConstraints();
		GridBagConstraints ctLastName = new GridBagConstraints();
		GridBagConstraints clGender = new GridBagConstraints();
		GridBagConstraints clBirthDate = new GridBagConstraints();
		GridBagConstraints ccboxBirthDate = new GridBagConstraints();
		GridBagConstraints ccboxBirthYear = new GridBagConstraints();
		GridBagConstraints clPhoto = new GridBagConstraints();
		GridBagConstraints ctPhoto = new GridBagConstraints();
		GridBagConstraints cbUpload = new GridBagConstraints();

		clFirstName.gridx = 0;
		clFirstName.gridy = 0;
		clFirstName.gridwidth = 1;
		clFirstName.gridheight = 1;
		clFirstName.fill = GridBagConstraints.HORIZONTAL;
		clFirstName.insets = STANDARDINSETS;
		
		clLastName.gridx = 2;
		clLastName.gridy = 0;
		clLastName.gridwidth = 1;
		clLastName.gridheight = 1;
		clLastName.fill = GridBagConstraints.HORIZONTAL;
		clLastName.insets = STANDARDINSETS;

		ctLastName.gridx = 3;
		ctLastName.gridy = 0;
		ctLastName.gridwidth = 1;
		ctLastName.gridheight = 1;
		ctLastName.weightx = 1.;
		ctLastName.fill = GridBagConstraints.HORIZONTAL;
		ctLastName.insets = STANDARDINSETS;

		clGender.gridx = 0;
		clGender.gridy = 1;
		clGender.gridwidth = 1;
		clGender.gridheight = 1;
		clGender.fill = GridBagConstraints.HORIZONTAL;
		clGender.insets = STANDARDINSETS;

		clBirthDate.gridx = 0;
		clBirthDate.gridy = 2;
		clBirthDate.gridwidth = 1;
		clBirthDate.gridheight = 1;
		clBirthDate.fill = GridBagConstraints.HORIZONTAL;
		clBirthDate.insets = STANDARDINSETS;

		ccboxBirthDate.gridx = 2;
		ccboxBirthDate.gridy = 2;
		ccboxBirthDate.gridwidth = 1;
		ccboxBirthDate.gridheight = 1;
		ccboxBirthDate.anchor = GridBagConstraints.CENTER;
		ccboxBirthDate.insets = STANDARDINSETS;

		ccboxBirthYear.gridx = 3;
		ccboxBirthYear.gridy = 2;
		ccboxBirthYear.gridwidth = 1;
		ccboxBirthYear.gridheight = 1;
		ccboxBirthYear.anchor = GridBagConstraints.LINE_START;
		ccboxBirthYear.insets = STANDARDINSETS;

		clPhoto.gridx = 0;
		clPhoto.gridy = 3;
		clPhoto.gridwidth = 1;
		clPhoto.gridheight = 1;
		clPhoto.fill = GridBagConstraints.HORIZONTAL;
		clPhoto.insets = STANDARDINSETS;

		ctPhoto.gridx = 1;
		ctPhoto.gridy = 3;
		ctPhoto.gridwidth = 2;
		ctPhoto.gridheight = 1;
		ctPhoto.fill = GridBagConstraints.HORIZONTAL;
		ctPhoto.insets = STANDARDINSETS;

		cbUpload.gridx = 3;
		cbUpload.gridy = 3;
		cbUpload.gridwidth = 1;
		cbUpload.gridheight = 1;
		cbUpload.anchor = GridBagConstraints.LINE_END;
		cbUpload.insets = STANDARDINSETS;

		pPersonalDetails.add(lFirstName, clFirstName);
		pPersonalDetails.add(lLastName, clLastName);
		pPersonalDetails.add(lGender, clGender);
		pPersonalDetails.add(lBirthDate, clBirthDate);
		pPersonalDetails.add(tFirstName, ctName);
		pPersonalDetails.add(tLastName, ctLastName);
		pPersonalDetails.add(cboxGender, ccboxGender);
		pPersonalDetails.add(cboxBirthDate, ccboxBirthDate);
		pPersonalDetails.add(cboxBirthMonth, ccboxBirthMonth);
		pPersonalDetails.add(cboxBirthYear, ccboxBirthYear);
		pPersonalDetails.add(lPhoto, clPhoto);
		pPersonalDetails.add(tPhoto, ctPhoto);
		pPersonalDetails.add(bUpload, cbUpload);

		// Contact details tab
		bCancel = new JButton("Cancel");
		bCancel.addActionListener(listener);
		bCancel.setActionCommand("Cancel");
		bSave = new JButton("Save");
		bSave.addActionListener(listener);
		bSave.setActionCommand("Save");
		
		pContactDetails.add(lContactDetails, clContactDetails);
		pContactDetails.add(lEmailAddress, clEmailAddress);
		pContactDetails.add(tEmailAddress, cl2EmailAddress);
		pContactDetails.add(lMobilePhoneNumber, clMobilePhoneNumber);
		pContactDetails.add(tMobilePhoneNumber, cl2MobilePhoneNumber);
		pContactDetails.add(lHomePhoneNumber, clHomePhoneNumber);
		pContactDetails.add(tHomePhoneNumber, cl2HomePhoneNumber);
		pContactDetails.add(sHorizontal, csHorizontal);
		pContactDetails.add(lHomeAddress, clHomeAddress);
		pContactDetails.add(lHomeNumberOrName, clHomeNumberOrName);
		pContactDetails.add(tHouseNumberOrName, cl2HomeNumberOrName);
		pContactDetails.add(lHomeStreet, clHomeStreet);
		pContactDetails.add(tStreet, cl2HomeStreet);
		pContactDetails.add(lHomeCity, clHomeCity);
		pContactDetails.add(tCity, cl2HomeCity);
		pContactDetails.add(lHomePostalCode, clHomePostalCode);
		pContactDetails.add(tPostalCode, cl2HomePostalCode);
		pContactDetails.add(lHomeCountry, clHomeCountry);		
		pContactDetails.add(tCountry, cl2HomeCountry);
		pContactDetails.add(bCancel, cbCancel);
		pContactDetails.add(bSave, cbEditSave);
		
		tabbedPane.addTab("Personal Details", pPersonalDetails);
		tabbedPane.addTab("Contact Details", pContactDetails);
		
		this.getContentPane().add(tabbedPane);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		
	}
	
}