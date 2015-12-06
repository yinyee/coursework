package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import obj.Patient;

/**
 * The Registration screen triggers when the "Register" button
 * in the Dashboard is clicked.
 *  
 *  References used:
 *  >> https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html
 *  
 * @author yinyee
 *
 */

public class NewPatient extends gui.Patient {
	
	private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private final String[] gender = {"Female", "Male"};
	
	private JFrame frame;
	private JLabel lFirstName, lLastName, lGender, lBirthDate, lPhoto;
	private JTextField tFirstName, tLastName, tPhoto;
	private JButton bUpload;
	private JComboBox<String> cboxGender, cboxBirthDate, cboxBirthMonth, cboxBirthYear;
	private JButton bCancel, bCancel1, bSave;
	private ButtonListener listener;

	public NewPatient() {
		draw();
	}
	
	
	private void save() {
		
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
		newPatient[9] = tHomeNumberOrName.getText();
		newPatient[10] = tHomeStreet.getText();
		newPatient[11] = tHomeCity.getText();
		newPatient[12] = tHomePostalCode.getText();
		newPatient[13] = tHomeCountry.getText();
		newPatient[14] = tPhoto.getText();
		
		ViewEditPatient window = new ViewEditPatient(new Patient(newPatient));
		// output to string and save in database
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
//				JOptionPane uploader = new JOptionPane(fileUploader);
				break;
			case "Save" :
				save();
				break;
			case "Cancel" :
				frame.dispose();
			}
		}
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	
	private void draw() {
		
		frame = new JFrame("New Patient");
		frame.setMaximumSize(dimension);
		
		// Subclass-specific components
		// Personal details tab
		lFirstName = new JLabel("First name");
		tFirstName = new JTextField();
		lLastName = new JLabel("Last name");		
		tLastName = new JTextField();
		lGender = new JLabel("Gender");
		cboxGender = new JComboBox<String>(gender);
		lBirthDate = new JLabel("Date of birth");
		String[] dates = new String[31];
		for (int i = 0; i < 31; i++) {
			dates[i] = Integer.toString(i + 1);
		}
		cboxBirthDate = new JComboBox<String>(dates);
		cboxBirthMonth = new JComboBox<String>(months);		
		String[] years = new String[100];
		for (int i = 0; i < 100; i++) {
			years[i] = Integer.toString(i + 1916);
		}
		cboxBirthYear = new JComboBox<String>(years);
		lPhoto = new JLabel("Photo");
		tPhoto = new JTextField();
		listener = new ButtonListener();
		bUpload = new JButton("Upload");
		bUpload.addActionListener(listener);
		bUpload.setActionCommand("Upload");
		bCancel = new JButton("Cancel");
		bCancel.addActionListener(listener);
		bCancel.setActionCommand("Cancel");
		
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
		GridBagConstraints cbCancel = new GridBagConstraints();

		clFirstName.gridx = 0;
		clFirstName.gridy = 0;
		clFirstName.gridwidth = 1;
		clFirstName.gridheight = 1;
		clFirstName.fill = GridBagConstraints.HORIZONTAL;
		clFirstName.insets = standardInsets;
		
		clLastName.gridx = 2;
		clLastName.gridy = 0;
		clLastName.gridwidth = 1;
		clLastName.gridheight = 1;
		clLastName.fill = GridBagConstraints.HORIZONTAL;
		clLastName.insets = standardInsets;

		ctLastName.gridx = 3;
		ctLastName.gridy = 0;
		ctLastName.gridwidth = 1;
		ctLastName.gridheight = 1;
		ctLastName.weightx = 1.;
		ctLastName.fill = GridBagConstraints.HORIZONTAL;
		ctLastName.insets = standardInsets;

		clGender.gridx = 0;
		clGender.gridy = 1;
		clGender.gridwidth = 1;
		clGender.gridheight = 1;
		clGender.fill = GridBagConstraints.HORIZONTAL;
		clGender.insets = standardInsets;

		clBirthDate.gridx = 0;
		clBirthDate.gridy = 2;
		clBirthDate.gridwidth = 1;
		clBirthDate.gridheight = 1;
		clBirthDate.fill = GridBagConstraints.HORIZONTAL;
		clBirthDate.insets = standardInsets;

		ccboxBirthDate.gridx = 2;
		ccboxBirthDate.gridy = 2;
		ccboxBirthDate.gridwidth = 1;
		ccboxBirthDate.gridheight = 1;
		ccboxBirthDate.anchor = GridBagConstraints.CENTER;
		ccboxBirthDate.insets = standardInsets;

		ccboxBirthYear.gridx = 3;
		ccboxBirthYear.gridy = 2;
		ccboxBirthYear.gridwidth = 1;
		ccboxBirthYear.gridheight = 1;
		ccboxBirthYear.anchor = GridBagConstraints.LINE_START;
		ccboxBirthYear.insets = standardInsets;

		clPhoto.gridx = 0;
		clPhoto.gridy = 3;
		clPhoto.gridwidth = 1;
		clPhoto.gridheight = 1;
		clPhoto.fill = GridBagConstraints.HORIZONTAL;
		clPhoto.insets = standardInsets;

		ctPhoto.gridx = 1;
		ctPhoto.gridy = 3;
		ctPhoto.gridwidth = 2;
		ctPhoto.gridheight = 1;
		ctPhoto.fill = GridBagConstraints.HORIZONTAL;
		ctPhoto.insets = standardInsets;

		cbUpload.gridx = 3;
		cbUpload.gridy = 3;
		cbUpload.gridwidth = 1;
		cbUpload.gridheight = 1;
		cbUpload.anchor = GridBagConstraints.LINE_END;
		cbUpload.insets = standardInsets;

		cbCancel.gridx = 3;
		cbCancel.gridy = 4;
		cbCancel.gridwidth = 1;
		cbCancel.gridheight = 1;
		cbCancel.anchor = GridBagConstraints.LINE_END;
		cbCancel.insets = standardInsets;
		
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
		pPersonalDetails.add(bCancel, cbCancel);

		// Contact details tab
		bCancel1 = new JButton("Cancel");
		bCancel1.addActionListener(listener);
		bCancel1.setActionCommand("Cancel");
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
		pContactDetails.add(tHomeNumberOrName, cl2HomeNumberOrName);
		pContactDetails.add(lHomeStreet, clHomeStreet);
		pContactDetails.add(tHomeStreet, cl2HomeStreet);
		pContactDetails.add(lHomeCity, clHomeCity);
		pContactDetails.add(tHomeCity, cl2HomeCity);
		pContactDetails.add(lHomePostalCode, clHomePostalCode);
		pContactDetails.add(tHomePostalCode, cl2HomePostalCode);
		pContactDetails.add(lHomeCountry, clHomeCountry);		
		pContactDetails.add(tHomeCountry, cl2HomeCountry);
		pContactDetails.add(bCancel1, cbCancel1);
		pContactDetails.add(bSave, cbEditSave);
		
		tabbedPane.addTab("Personal Details", pPersonalDetails);
		tabbedPane.addTab("Contact Details", pContactDetails);
		
		frame.getContentPane().add(tabbedPane);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
}