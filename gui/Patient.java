package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public abstract class Patient {

	protected final Dimension dimension = new Dimension(500, 450);
	protected final Insets standardInsets = new Insets(5, 5, 5, 5);
	
	protected JTabbedPane tabbedPane;
	protected JPanel pPersonalDetails, pContactDetails;
	protected JLabel lContactDetails, lEmailAddress, lMobilePhoneNumber, lHomeAddress, lHomePhoneNumber, lHomeNumberOrName, lHomeStreet, lHomeCity, lHomePostalCode, lHomeCountry;
	protected JTextField tEmailAddress, tMobilePhoneNumber, tHomePhoneNumber, tHomeNumberOrName, tHomeStreet, tHomeCity, tHomePostalCode, tHomeCountry;	
	protected JSeparator sHorizontal;
	
	protected GridBagConstraints ctName, ccboxGender, ccboxBirthMonth;
	
	protected GridBagConstraints clContactDetails, clEmailAddress, cl2EmailAddress, clMobilePhoneNumber, cl2MobilePhoneNumber,
	clHomePhoneNumber, cl2HomePhoneNumber, csHorizontal, clHomeAddress, clHomeNumberOrName, cl2HomeNumberOrName, clHomeStreet, 
	cl2HomeStreet, clHomeCity, cl2HomeCity, clHomePostalCode, cl2HomePostalCode, clHomeCountry, cl2HomeCountry, cbCancel1, cbEditSave;

	public Patient() {
		
		tabbedPane = new JTabbedPane();		
		
		pPersonalDetails = new JPanel(new GridBagLayout());
		pContactDetails = new JPanel(new GridBagLayout());
		
		// Personal details tab
		ctName = new GridBagConstraints();
		ccboxGender = new GridBagConstraints();
		ccboxBirthMonth = new GridBagConstraints();
	
		ctName.gridx = 1;
		ctName.gridy = 0;
		ctName.gridwidth = 1;
		ctName.gridheight = 1;
		ctName.weightx = 1.;
		ctName.fill = GridBagConstraints.HORIZONTAL;
		ctName.insets = standardInsets;

		ccboxGender.gridx = 1;
		ccboxGender.gridy = 1;
		ccboxGender.gridwidth = 1;
		ccboxGender.gridheight = 1;
		ccboxGender.anchor = GridBagConstraints.LINE_START;
		ccboxGender.insets = standardInsets;

		ccboxBirthMonth.gridx = 1;
		ccboxBirthMonth.gridy = 2;
		ccboxBirthMonth.gridwidth = 1;
		ccboxBirthMonth.gridheight = 1;
		ccboxBirthMonth.anchor = GridBagConstraints.LINE_START;
		ccboxBirthMonth.insets = standardInsets;

		// Contact details tab
		lContactDetails = new JLabel("CONTACT DETAILS");
		lEmailAddress = new JLabel("Email address");
		lMobilePhoneNumber = new JLabel("Mobile phone number");
		lHomePhoneNumber = new JLabel("Home phone number");
		sHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		lHomeAddress = new JLabel("HOME ADDRESS");
		lHomeNumberOrName = new JLabel("House number and name");
		lHomeStreet = new JLabel("Street");
		lHomeCity = new JLabel("City or town");
		lHomePostalCode = new JLabel("Postal code");
		lHomeCountry = new JLabel("Country");
		tEmailAddress = new JTextField();
		tMobilePhoneNumber = new JTextField();
		tHomePhoneNumber = new JTextField();
		tHomeNumberOrName = new JTextField();
		tHomeStreet = new JTextField();
		tHomeCity = new JTextField();
		tHomePostalCode = new JTextField();
		tHomeCountry = new JTextField();
		
		clContactDetails = new GridBagConstraints();
		clEmailAddress = new GridBagConstraints();
		cl2EmailAddress = new GridBagConstraints();
		clMobilePhoneNumber = new GridBagConstraints();
		cl2MobilePhoneNumber = new GridBagConstraints();
		clHomePhoneNumber = new GridBagConstraints();
		cl2HomePhoneNumber = new GridBagConstraints();
		csHorizontal = new GridBagConstraints();
		clHomeAddress = new GridBagConstraints();
		clHomeNumberOrName = new GridBagConstraints();
		cl2HomeNumberOrName = new GridBagConstraints();
		clHomeStreet = new GridBagConstraints();
		cl2HomeStreet = new GridBagConstraints();
		clHomeCity = new GridBagConstraints();
		cl2HomeCity = new GridBagConstraints();
		clHomePostalCode = new GridBagConstraints();
		cl2HomePostalCode = new GridBagConstraints();
		clHomeCountry = new GridBagConstraints();
		cl2HomeCountry = new GridBagConstraints();
		cbCancel1 = new GridBagConstraints();
		cbEditSave = new GridBagConstraints();

		clContactDetails.gridx = 0;
		clContactDetails.gridy = 0;
		clContactDetails.gridwidth = 1;
		clContactDetails.gridheight = 1;
		clContactDetails.fill = GridBagConstraints.HORIZONTAL;
		clContactDetails.insets = standardInsets;

		clEmailAddress.gridx = 0;
		clEmailAddress.gridy = 1;
		clEmailAddress.gridwidth = 1;
		clEmailAddress.gridheight = 1;
		clEmailAddress.fill = GridBagConstraints.HORIZONTAL;
		clEmailAddress.insets = standardInsets;
				
		cl2EmailAddress.gridx = 1;
		cl2EmailAddress.gridy = 1;
		cl2EmailAddress.gridwidth = 2;
		cl2EmailAddress.gridheight = 1;
		cl2EmailAddress.weightx = 0.6;
		cl2EmailAddress.fill = GridBagConstraints.HORIZONTAL;
		cl2EmailAddress.insets = standardInsets;
		
		clMobilePhoneNumber.gridx = 0;
		clMobilePhoneNumber.gridy = 2;
		clMobilePhoneNumber.gridwidth = 1;
		clMobilePhoneNumber.gridheight = 1;
		clMobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clMobilePhoneNumber.insets = standardInsets;
		
		cl2MobilePhoneNumber.gridx = 1;
		cl2MobilePhoneNumber.gridy = 2;
		cl2MobilePhoneNumber.gridwidth = 2;
		cl2MobilePhoneNumber.gridheight = 1;
		cl2MobilePhoneNumber.weightx = 0.6;
		cl2MobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		cl2MobilePhoneNumber.insets = standardInsets;
		
		clHomePhoneNumber.gridx = 0;
		clHomePhoneNumber.gridy = 3;
		clHomePhoneNumber.gridwidth = 1;
		clHomePhoneNumber.gridheight = 1;
		clHomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clHomePhoneNumber.insets = standardInsets;
		
		cl2HomePhoneNumber.gridx = 1;
		cl2HomePhoneNumber.gridy = 3;
		cl2HomePhoneNumber.gridwidth = 2;
		cl2HomePhoneNumber.gridheight = 1;
		cl2HomePhoneNumber.weightx = 0.6;
		cl2HomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		cl2HomePhoneNumber.insets = standardInsets;

		csHorizontal.gridx = 0;
		csHorizontal.gridy = 4;
		csHorizontal.gridwidth = 4;
		csHorizontal.gridheight = 1;
		csHorizontal.fill = GridBagConstraints.HORIZONTAL;
		csHorizontal.insets = standardInsets;

		clHomeAddress.gridx = 0;
		clHomeAddress.gridy = 5;
		clHomeAddress.gridwidth = 1;
		clHomeAddress.gridheight = 1;
		clHomeAddress.fill = GridBagConstraints.HORIZONTAL;
		clHomeAddress.insets = standardInsets;
		
		clHomeNumberOrName.gridx = 0;
		clHomeNumberOrName.gridy = 6;
		clHomeNumberOrName.gridwidth = 1;
		clHomeNumberOrName.gridheight = 1;
		clHomeNumberOrName.fill = GridBagConstraints.HORIZONTAL;
		clHomeNumberOrName.insets = standardInsets;

		cl2HomeNumberOrName.gridx = 1;
		cl2HomeNumberOrName.gridy = 6;
		cl2HomeNumberOrName.gridwidth = 2;
		cl2HomeNumberOrName.gridheight = 1;
		cl2HomeNumberOrName.weightx = 0.6;
		cl2HomeNumberOrName.fill = GridBagConstraints.HORIZONTAL;
		cl2HomeNumberOrName.insets = standardInsets;

		clHomeStreet.gridx = 0;
		clHomeStreet.gridy = 7;
		clHomeStreet.gridwidth = 1;
		clHomeStreet.gridheight = 1;
		clHomeStreet.fill = GridBagConstraints.HORIZONTAL;
		clHomeStreet.insets = standardInsets;

		cl2HomeStreet.gridx = 1;
		cl2HomeStreet.gridy = 7;
		cl2HomeStreet.gridwidth = 2;
		cl2HomeStreet.gridheight = 1;
		cl2HomeStreet.weightx = 0.6;
		cl2HomeStreet.fill = GridBagConstraints.HORIZONTAL;
		cl2HomeStreet.insets = standardInsets;
		
		clHomeCity.gridx = 0;
		clHomeCity.gridy = 8;
		clHomeCity.gridwidth = 1;
		clHomeCity.gridheight = 1;
		clHomeCity.fill = GridBagConstraints.HORIZONTAL;
		clHomeCity.insets = standardInsets;

		cl2HomeCity.gridx = 1;
		cl2HomeCity.gridy = 8;
		cl2HomeCity.gridwidth = 2;
		cl2HomeCity.gridheight = 1;
		cl2HomeCity.weightx = 0.6;
		cl2HomeCity.fill = GridBagConstraints.HORIZONTAL;
		cl2HomeCity.insets = standardInsets;

		clHomePostalCode.gridx = 0;
		clHomePostalCode.gridy = 9;
		clHomePostalCode.gridwidth = 1;
		clHomePostalCode.gridheight = 1;
		clHomePostalCode.fill = GridBagConstraints.HORIZONTAL;
		clHomePostalCode.insets = standardInsets;

		cl2HomePostalCode.gridx = 1;
		cl2HomePostalCode.gridy = 9;
		cl2HomePostalCode.gridwidth = 2;
		cl2HomePostalCode.gridheight = 1;
		cl2HomePostalCode.weightx = 0.6;
		cl2HomePostalCode.fill = GridBagConstraints.HORIZONTAL;
		cl2HomePostalCode.insets = standardInsets;

		clHomeCountry.gridx = 0;
		clHomeCountry.gridy = 10;
		clHomeCountry.gridwidth = 1;
		clHomeCountry.gridheight = 1;
		clHomeCountry.fill = GridBagConstraints.HORIZONTAL;
		clHomeCountry.insets = standardInsets;

		cl2HomeCountry.gridx = 1;
		cl2HomeCountry.gridy = 10;
		cl2HomeCountry.gridwidth = 2;
		cl2HomeCountry.gridheight = 1;
		cl2HomeCountry.weightx = 0.6;
		cl2HomeCountry.fill = GridBagConstraints.HORIZONTAL;
		cl2HomeCountry.insets = standardInsets;
			
		cbCancel1.gridx = 2;
		cbCancel1.gridy = 11;
		cbCancel1.gridwidth = 1;
		cbCancel1.gridheight = 1;
		cbCancel1.anchor = GridBagConstraints.LINE_END;
		cbCancel1.insets = standardInsets;
		
		cbEditSave.gridx = 2;
		cbEditSave.gridy = 12;
		cbEditSave.gridwidth = 1;
		cbEditSave.gridheight = 1;
		cbEditSave.anchor = GridBagConstraints.LINE_END;
		cbEditSave.insets = standardInsets;

	}
	
}
