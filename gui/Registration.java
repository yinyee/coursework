package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

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

public class Registration {

	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					draw();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	
	private static void draw() {
		
		JFrame frame = new JFrame("Register New Patient");
		JTabbedPane tabbedPane = new JTabbedPane();		
		
		// THESE LISTENERS HAVE NOT BEEN INITIALISED !!!
		// The following section adds listeners to certain components.
		
		// The following section specifies the GridBagConsraints for each component.

		// Personal tab
		JPanel pPersonal = new JPanel();
		pPersonal.setLayout(new GridBagLayout());
		
		JLabel lPersonal = new JLabel("PERSONAL DETAILS");
		JLabel lFirstName = new JLabel("First name");
		JLabel lLastName = new JLabel("Last name");
		JLabel lGender = new JLabel("Gender");
		JLabel lBirthDate = new JLabel("Date of birth (dd/mm/yyyy)");
		JLabel lEmailAddress = new JLabel("Email address");
		JLabel lMobilePhoneNumber = new JLabel("Mobile phone number");
		JLabel lHomePhoneNumber = new JLabel("Home phone number");
		JLabel lWorkPhoneNumber = new JLabel("Work phone number");
		JTextField tFirstName = new JTextField();
		JTextField tLastName = new JTextField();
		String[] gender = {"Female", "Male"};
		JComboBox tGender = new JComboBox(gender);
		JTextField tBirthDate = new JTextField();
		JTextField tEmailAddress = new JTextField();
		JTextField tMobilePhoneNumber = new JTextField();
		JTextField tHomePhoneNumber = new JTextField();
		JTextField tWorkPhoneNumber = new JTextField();				
		JButton bAddresses = new JButton("Addresses >>");
		
		GridBagConstraints clPersonal = new GridBagConstraints();
		GridBagConstraints clFirstName = new GridBagConstraints();
		GridBagConstraints clLastName = new GridBagConstraints();
		GridBagConstraints clGender = new GridBagConstraints();
		GridBagConstraints clBirthDate = new GridBagConstraints();
		GridBagConstraints clEmailAddress = new GridBagConstraints();
		GridBagConstraints clMobilePhoneNumber = new GridBagConstraints();
		GridBagConstraints clHomePhoneNumber = new GridBagConstraints();
		GridBagConstraints clWorkPhoneNumber = new GridBagConstraints();
		GridBagConstraints ctFirstName = new GridBagConstraints();
		GridBagConstraints ctLastName = new GridBagConstraints();
		GridBagConstraints ctGender = new GridBagConstraints();
		GridBagConstraints ctBirthDate = new GridBagConstraints();
		GridBagConstraints ctEmailAddress = new GridBagConstraints();
		GridBagConstraints ctMobilePhoneNumber = new GridBagConstraints();
		GridBagConstraints ctHomePhoneNumber = new GridBagConstraints();
		GridBagConstraints ctWorkPhoneNumber = new GridBagConstraints();
		GridBagConstraints cbAddresses = new GridBagConstraints();

		clPersonal.gridx = 0;
		clPersonal.gridy = 0;
		clPersonal.gridwidth = 1;
		clPersonal.gridheight = 1;
		clPersonal.fill = GridBagConstraints.HORIZONTAL;
		clPersonal.insets = standardInsets;
		
		clFirstName.gridx = 0;
		clFirstName.gridy = 1;
		clFirstName.gridwidth = 1;
		clFirstName.gridheight = 1;
		clFirstName.fill = GridBagConstraints.HORIZONTAL;
		clFirstName.insets = standardInsets;
		
		clLastName.gridx = 0;
		clLastName.gridy = 2;
		clLastName.gridwidth = 1;
		clLastName.gridheight = 1;
		clLastName.fill = GridBagConstraints.HORIZONTAL;
		clLastName.insets = standardInsets;
		
		clGender.gridx = 0;
		clGender.gridy = 3;
		clGender.gridwidth = 1;
		clGender.gridheight = 1;
		clGender.fill = GridBagConstraints.HORIZONTAL;
		clGender.insets = standardInsets;
		
		clBirthDate.gridx = 0;
		clBirthDate.gridy = 4;
		clBirthDate.gridwidth = 1;
		clBirthDate.gridheight = 1;
		clBirthDate.fill = GridBagConstraints.HORIZONTAL;
		clBirthDate.insets = standardInsets;
		
		clEmailAddress.gridx = 3;
		clEmailAddress.gridy = 1;
		clEmailAddress.gridwidth = 1;
		clEmailAddress.gridheight = 1;
		clEmailAddress.fill = GridBagConstraints.HORIZONTAL;
		clEmailAddress.insets = standardInsets;
		
		clMobilePhoneNumber.gridx = 3;
		clMobilePhoneNumber.gridy = 2;
		clMobilePhoneNumber.gridwidth = 1;
		clMobilePhoneNumber.gridheight = 1;
		clMobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clMobilePhoneNumber.insets = standardInsets;
		
		clHomePhoneNumber.gridx = 3;
		clHomePhoneNumber.gridy = 3;
		clHomePhoneNumber.gridwidth = 1;
		clHomePhoneNumber.gridheight = 1;
		clHomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clHomePhoneNumber.insets = standardInsets;
		
		clWorkPhoneNumber.gridx = 3;
		clWorkPhoneNumber.gridy = 4;
		clWorkPhoneNumber.gridwidth = 1;
		clWorkPhoneNumber.gridheight = 1;
		clWorkPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clWorkPhoneNumber.insets = standardInsets;
		
		ctFirstName.gridx = 1;
		ctFirstName.gridy = 1;
		ctFirstName.gridwidth = 1;
		ctFirstName.gridheight = 1;
		ctFirstName.fill = GridBagConstraints.HORIZONTAL;
		ctFirstName.insets = standardInsets;
		
		ctLastName.gridx = 1;
		ctLastName.gridy = 2;
		ctLastName.gridwidth = 1;
		ctLastName.gridheight = 1;
		ctLastName.fill = GridBagConstraints.HORIZONTAL;
		ctLastName.insets = standardInsets;
		
		ctGender.gridx = 1;
		ctGender.gridy = 3;
		ctGender.gridwidth = 1;
		ctGender.gridheight = 1;
		ctGender.fill = GridBagConstraints.HORIZONTAL;
		ctGender.insets = standardInsets;
		
		ctBirthDate.gridx = 1;
		ctBirthDate.gridy = 4;
		ctBirthDate.gridwidth = 1;
		ctBirthDate.gridheight = 1;
		ctBirthDate.fill = GridBagConstraints.HORIZONTAL;
		ctBirthDate.insets = standardInsets;

		ctEmailAddress.gridx = 4;
		ctEmailAddress.gridy = 1;
		ctEmailAddress.gridwidth = 1;
		ctEmailAddress.gridheight = 1;
		ctEmailAddress.fill = GridBagConstraints.HORIZONTAL;
		ctEmailAddress.insets = standardInsets;
		
		ctMobilePhoneNumber.gridx = 4;
		ctMobilePhoneNumber.gridy = 2;
		ctMobilePhoneNumber.gridwidth = 1;
		ctMobilePhoneNumber.gridheight = 1;
		ctMobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		ctMobilePhoneNumber.insets = standardInsets;
		
		ctHomePhoneNumber.gridx = 4;
		ctHomePhoneNumber.gridy = 3;
		ctHomePhoneNumber.gridwidth = 1;
		ctHomePhoneNumber.gridheight = 1;
		ctHomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		ctHomePhoneNumber.insets = standardInsets;
		
		ctWorkPhoneNumber.gridx = 4;
		ctWorkPhoneNumber.gridy = 4;
		ctWorkPhoneNumber.gridwidth = 1;
		ctWorkPhoneNumber.gridheight = 1;
		ctWorkPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		ctWorkPhoneNumber.insets = standardInsets;

		cbAddresses.gridx = 4;
		cbAddresses.gridy = 5;
		cbAddresses.gridwidth = 1;
		cbAddresses.gridheight = 1;
		cbAddresses.fill = GridBagConstraints.HORIZONTAL;
		cbAddresses.insets = standardInsets;
		
		pPersonal.add(lPersonal, clPersonal);
		pPersonal.add(lFirstName, clFirstName);
		pPersonal.add(lLastName, clLastName);
		pPersonal.add(lGender, clGender);
		pPersonal.add(lBirthDate, clBirthDate);
		pPersonal.add(lEmailAddress, clEmailAddress);
		pPersonal.add(lMobilePhoneNumber, clMobilePhoneNumber);
		pPersonal.add(lHomePhoneNumber, clHomePhoneNumber);
		pPersonal.add(lWorkPhoneNumber, clWorkPhoneNumber);
		pPersonal.add(tFirstName, ctFirstName);
		pPersonal.add(tLastName, ctLastName);
		pPersonal.add(tGender, ctGender);
		pPersonal.add(tBirthDate, ctBirthDate);
		pPersonal.add(tEmailAddress, ctEmailAddress);
		pPersonal.add(tMobilePhoneNumber, ctMobilePhoneNumber);
		pPersonal.add(tHomePhoneNumber, ctHomePhoneNumber);
		pPersonal.add(tWorkPhoneNumber, ctWorkPhoneNumber);
		pPersonal.add(bAddresses, cbAddresses);
		
		// Addresses tab
		JPanel pAddress = new JPanel();
		pAddress.setLayout(new GridBagLayout());
		
		JLabel lHomeAddress = new JLabel("HOME ADDRESS");
		JLabel lHomeNumberOrName = new JLabel("House number and name");
		JLabel lHomeStreet = new JLabel("Street");
		JLabel lHomeCity = new JLabel("City or town");
		JLabel lHomePostalCode = new JLabel("Postal code");
		JLabel lHomeCountry = new JLabel("Country");
		JSeparator sVertical = new JSeparator(JSeparator.VERTICAL);
		JLabel lBillingAddress = new JLabel("BILLING ADDRESS");
		JCheckBox ckBillingSameAsHome = new JCheckBox("Copy from home address?");
		JLabel lBillingNumberOrName = new JLabel("House number and name");
		JLabel lBillingStreet = new JLabel("Street");
		JLabel lBillingCity = new JLabel("City or town");
		JLabel lBillingPostalCode = new JLabel("Postal code");
		JLabel lBillingCountry = new JLabel("Country");
		JTextField tHomeNumberOrName = new JTextField();
		JTextField tHomeStreet = new JTextField();
		JTextField tHomeCity = new JTextField();
		JTextField tHomePostalCode = new JTextField();
		JTextField tHomeCountry = new JTextField();
		JTextField tBillingNumberOrName = new JTextField();
		JTextField tBillingStreet = new JTextField();
		JTextField tBillingCity = new JTextField();
		JTextField tBillingPostalCode = new JTextField();
		JTextField tBillingCountry = new JTextField();
		JButton bNextOfKin = new JButton("Next of kin >>");
		
		GridBagConstraints clHomeAddress = new GridBagConstraints();
		GridBagConstraints clHomeNumberOrName = new GridBagConstraints();
		GridBagConstraints clHomeStreet = new GridBagConstraints();
		GridBagConstraints clHomeCity = new GridBagConstraints();
		GridBagConstraints clHomePostalCode = new GridBagConstraints();
		GridBagConstraints clHomeCountry = new GridBagConstraints();
		GridBagConstraints csVertical = new GridBagConstraints();
		GridBagConstraints clBillingAddress = new GridBagConstraints();
		GridBagConstraints cckBillingSameAsHome = new GridBagConstraints();
		GridBagConstraints clBillingNumberOrName = new GridBagConstraints();
		GridBagConstraints clBillingStreet = new GridBagConstraints();
		GridBagConstraints clBillingCity = new GridBagConstraints();
		GridBagConstraints clBillingPostalCode = new GridBagConstraints();
		GridBagConstraints clBillingCountry = new GridBagConstraints();
		GridBagConstraints ctHomeNumberOrName = new GridBagConstraints();
		GridBagConstraints ctHomeStreet = new GridBagConstraints();
		GridBagConstraints ctHomeCity = new GridBagConstraints();
		GridBagConstraints ctHomePostalCode = new GridBagConstraints();
		GridBagConstraints ctHomeCountry = new GridBagConstraints();
		GridBagConstraints ctBillingNumberOrName = new GridBagConstraints();
		GridBagConstraints ctBillingStreet = new GridBagConstraints();
		GridBagConstraints ctBillingCity = new GridBagConstraints();
		GridBagConstraints ctBillingPostalCode = new GridBagConstraints();
		GridBagConstraints ctBillingCountry = new GridBagConstraints();
		GridBagConstraints cbNextOfKin = new GridBagConstraints();
		
		clHomeAddress.gridx = 0;
		clHomeAddress.gridy = 0;
		clHomeAddress.gridwidth = 1;
		clHomeAddress.gridheight = 1;
		clHomeAddress.fill = GridBagConstraints.HORIZONTAL;
		clHomeAddress.insets = standardInsets;
		
		clHomeNumberOrName.gridx = 0;
		clHomeNumberOrName.gridy = 2;
		clHomeNumberOrName.gridwidth = 1;
		clHomeNumberOrName.gridheight = 1;
		clHomeNumberOrName.fill = GridBagConstraints.HORIZONTAL;
		clHomeNumberOrName.insets = standardInsets;

		clHomeStreet.gridx = 0;
		clHomeStreet.gridy = 3;
		clHomeStreet.gridwidth = 1;
		clHomeStreet.gridheight = 1;
		clHomeStreet.fill = GridBagConstraints.HORIZONTAL;
		clHomeStreet.insets = standardInsets;

		clHomeCity.gridx = 0;
		clHomeCity.gridy = 4;
		clHomeCity.gridwidth = 1;
		clHomeCity.gridheight = 1;
		clHomeCity.fill = GridBagConstraints.HORIZONTAL;
		clHomeCity.insets = standardInsets;

		clHomePostalCode.gridx = 0;
		clHomePostalCode.gridy = 5;
		clHomePostalCode.gridwidth = 1;
		clHomePostalCode.gridheight = 1;
		clHomePostalCode.fill = GridBagConstraints.HORIZONTAL;
		clHomePostalCode.insets = standardInsets;

		clHomeCountry.gridx = 0;
		clHomeCountry.gridy = 6;
		clHomeCountry.gridwidth = 1;
		clHomeCountry.gridheight = 1;
		clHomeCountry.fill = GridBagConstraints.HORIZONTAL;
		clHomeCountry.insets = standardInsets;

		csVertical.gridx = 2;
		csVertical.gridy = 0;
		csVertical.gridwidth = 1;
		csVertical.gridheight = 7;
		csVertical.fill = GridBagConstraints.HORIZONTAL;
		csVertical.fill = GridBagConstraints.VERTICAL;
		csVertical.insets = standardInsets;
		
		clBillingAddress.gridx = 3;
		clBillingAddress.gridy = 0;
		clBillingAddress.gridwidth = 1;
		clBillingAddress.gridheight = 1;
		clBillingAddress.fill = GridBagConstraints.HORIZONTAL;
		clBillingAddress.insets = standardInsets;

		cckBillingSameAsHome.gridx = 3;
		cckBillingSameAsHome.gridy = 1;
		cckBillingSameAsHome.gridwidth = 1;
		cckBillingSameAsHome.gridheight = 1;
		cckBillingSameAsHome.fill = GridBagConstraints.HORIZONTAL;
		cckBillingSameAsHome.insets = standardInsets;

		clBillingNumberOrName.gridx = 3;
		clBillingNumberOrName.gridy = 2;
		clBillingNumberOrName.gridwidth = 1;
		clBillingNumberOrName.gridheight = 1;
		clBillingNumberOrName.fill = GridBagConstraints.HORIZONTAL;
		clBillingNumberOrName.insets = standardInsets;

		clBillingStreet.gridx = 3;
		clBillingStreet.gridy = 3;
		clBillingStreet.gridwidth = 1;
		clBillingStreet.gridheight = 1;
		clBillingStreet.fill = GridBagConstraints.HORIZONTAL;
		clBillingStreet.insets = standardInsets;

		clBillingCity.gridx = 3;
		clBillingCity.gridy = 4;
		clBillingCity.gridwidth = 1;
		clBillingCity.gridheight = 1;
		clBillingCity.fill = GridBagConstraints.HORIZONTAL;
		clBillingCity.insets = standardInsets;

		clBillingPostalCode.gridx = 3;
		clBillingPostalCode.gridy = 5;
		clBillingPostalCode.gridwidth = 1;
		clBillingPostalCode.gridheight = 1;
		clBillingPostalCode.fill = GridBagConstraints.HORIZONTAL;
		clBillingPostalCode.insets = standardInsets;

		clBillingCountry.gridx = 3;
		clBillingCountry.gridy = 6;
		clBillingCountry.gridwidth = 1;
		clBillingCountry.gridheight = 1;
		clBillingCountry.fill = GridBagConstraints.HORIZONTAL;
		clBillingCountry.insets = standardInsets;

		ctHomeNumberOrName.gridx = 1;
		ctHomeNumberOrName.gridy = 2;
		ctHomeNumberOrName.gridwidth = 1;
		ctHomeNumberOrName.gridheight = 1;
		ctHomeNumberOrName.fill = GridBagConstraints.HORIZONTAL;
		ctHomeNumberOrName.insets = standardInsets;

		ctHomeStreet.gridx = 1;
		ctHomeStreet.gridy = 3;
		ctHomeStreet.gridwidth = 1;
		ctHomeStreet.gridheight = 1;
		ctHomeStreet.fill = GridBagConstraints.HORIZONTAL;
		ctHomeStreet.insets = standardInsets;

		ctHomeCity.gridx = 1;
		ctHomeCity.gridy = 4;
		ctHomeCity.gridwidth = 1;
		ctHomeCity.gridheight = 1;
		ctHomeCity.fill = GridBagConstraints.HORIZONTAL;
		ctHomeCity.insets = standardInsets;
		
		ctHomePostalCode.gridx = 1;
		ctHomePostalCode.gridy = 5;
		ctHomePostalCode.gridwidth = 1;
		ctHomePostalCode.gridheight = 1;
		ctHomePostalCode.fill = GridBagConstraints.HORIZONTAL;
		ctHomePostalCode.insets = standardInsets;

		ctHomeCountry.gridx = 1;
		ctHomeCountry.gridy = 6;
		ctHomeCountry.gridwidth = 1;
		ctHomeCountry.gridheight = 1;
		ctHomeCountry.fill = GridBagConstraints.HORIZONTAL;
		ctHomeCountry.insets = standardInsets;

		ctBillingNumberOrName.gridx = 4;
		ctBillingNumberOrName.gridy = 2;
		ctBillingNumberOrName.gridwidth = 1;
		ctBillingNumberOrName.gridheight = 1;
		ctBillingNumberOrName.fill = GridBagConstraints.HORIZONTAL;
		ctBillingNumberOrName.insets = standardInsets;

		ctBillingStreet.gridx = 4;
		ctBillingStreet.gridy = 3;
		ctBillingStreet.gridwidth = 1;
		ctBillingStreet.gridheight = 1;
		ctBillingStreet.fill = GridBagConstraints.HORIZONTAL;
		ctBillingStreet.insets = standardInsets;

		ctBillingCity.gridx = 4;
		ctBillingCity.gridy = 4;
		ctBillingCity.gridwidth = 1;
		ctBillingCity.gridheight = 1;
		ctBillingCity.fill = GridBagConstraints.HORIZONTAL;
		ctBillingCity.insets = standardInsets;

		ctBillingPostalCode.gridx = 4;
		ctBillingPostalCode.gridy = 5;
		ctBillingPostalCode.gridwidth = 1;
		ctBillingPostalCode.gridheight = 1;
		ctBillingPostalCode.fill = GridBagConstraints.HORIZONTAL;
		ctBillingPostalCode.insets = standardInsets;

		ctBillingCountry.gridx = 4;
		ctBillingCountry.gridy = 6;
		ctBillingCountry.gridwidth = 1;
		ctBillingCountry.gridheight = 1;
		ctBillingCountry.fill = GridBagConstraints.HORIZONTAL;
		ctBillingCountry.insets = standardInsets;
	
		cbNextOfKin.gridx = 4;
		cbNextOfKin.gridy = 7;
		cbNextOfKin.gridwidth = 1;
		cbNextOfKin.gridheight = 1;
		cbNextOfKin.fill = GridBagConstraints.HORIZONTAL;
		cbNextOfKin.insets = standardInsets;

		pAddress.add(lHomeAddress, clHomeAddress);
		pAddress.add(lHomeNumberOrName, clHomeNumberOrName);
		pAddress.add(lHomeStreet, clHomeStreet);
		pAddress.add(lHomeCity, clHomeCity);
		pAddress.add(lHomePostalCode, clHomePostalCode);
		pAddress.add(lHomeCountry, clHomeCountry);
		pAddress.add(sVertical, csVertical);
		pAddress.add(lBillingAddress, clBillingAddress);
		pAddress.add(ckBillingSameAsHome, cckBillingSameAsHome);
		pAddress.add(lBillingNumberOrName, clBillingNumberOrName);
		pAddress.add(lBillingStreet, clBillingStreet);
		pAddress.add(lBillingCity, clBillingCity);
		pAddress.add(lBillingPostalCode, clBillingPostalCode);
		pAddress.add(lBillingCountry, clBillingCountry);
		pAddress.add(tHomeNumberOrName, ctHomeNumberOrName);
		pAddress.add(tHomeStreet, ctHomeStreet);
		pAddress.add(tHomeCity, ctHomeCity);
		pAddress.add(tHomePostalCode, ctHomePostalCode);
		pAddress.add(tHomeCountry, ctHomeCountry);
		pAddress.add(tBillingNumberOrName, ctBillingNumberOrName);
		pAddress.add(tBillingStreet, ctBillingStreet);
		pAddress.add(tBillingCity, ctBillingCity);
		pAddress.add(tBillingPostalCode, ctBillingPostalCode);
		pAddress.add(tBillingCountry, ctBillingCountry);
		pAddress.add(bNextOfKin, cbNextOfKin);
		
		// Next Of Kin tab
		JPanel pNextOfKin = new JPanel();
		pNextOfKin.setLayout(new GridBagLayout());

		JLabel lNextOfKin = new JLabel("NEXT OF KIN");
		JLabel lNOKFirstName = new JLabel("First name");
		JLabel lNOKLastName = new JLabel("Last name");
		JLabel lNOKRelationship = new JLabel("Relationship to patient");
		JLabel lNOKEmailAddress = new JLabel("Email address");
		JLabel lNOKMobilePhoneNumber = new JLabel("Mobile phone number");
		JLabel lNOKHomePhoneNumber = new JLabel("Home phone number");
		JTextField tNOKFirstName = new JTextField();
		JTextField tNOKLastName = new JTextField();
		String[] relationship = {"Spouse", "Parent", "Sibling", "Child", "Friend", "Lawyer"};
		JComboBox cboxNOKRelationship = new JComboBox(relationship);
		JTextField tNOKEmailAddress = new JTextField();
		JTextField tNOKMobilePhoneNumber = new JTextField();
		JTextField tNOKHomePhoneNumber = new JTextField();
		JButton bSave = new JButton("Save");
		
		GridBagConstraints clNextOfKin = new GridBagConstraints();
		GridBagConstraints clNOKFirstName = new GridBagConstraints();
		GridBagConstraints clNOKLastName = new GridBagConstraints();
		GridBagConstraints clNOKRelationship = new GridBagConstraints();
		GridBagConstraints clNOKEmailAddress = new GridBagConstraints();
		GridBagConstraints clNOKMobilePhoneNumber = new GridBagConstraints();
		GridBagConstraints clNOKHomePhoneNumber = new GridBagConstraints();
		GridBagConstraints ctNOKFirstName = new GridBagConstraints();
		GridBagConstraints ctNOKLastName = new GridBagConstraints();
		GridBagConstraints ccboxNOKRelationship = new GridBagConstraints();
		GridBagConstraints ctNOKEmailAddress = new GridBagConstraints();
		GridBagConstraints ctNOKMobilePhoneNumber = new GridBagConstraints();
		GridBagConstraints ctNOKHomePhoneNumber = new GridBagConstraints();
		GridBagConstraints cbSave = new GridBagConstraints();
		
		clNextOfKin.gridx = 0;
		clNextOfKin.gridy = 0;
		clNextOfKin.gridwidth = 1;
		clNextOfKin.gridheight = 1;
		clNextOfKin.fill = GridBagConstraints.HORIZONTAL;
		clNextOfKin.insets = standardInsets;
		
		clNOKFirstName.gridx = 0;
		clNOKFirstName.gridy = 1;
		clNOKFirstName.gridwidth = 1;
		clNOKFirstName.gridheight = 1;
		clNOKFirstName.fill = GridBagConstraints.HORIZONTAL;
		clNOKFirstName.insets = standardInsets;

		clNOKLastName.gridx = 0;
		clNOKLastName.gridy = 2;
		clNOKLastName.gridwidth = 1;
		clNOKLastName.gridheight = 1;
		clNOKLastName.fill = GridBagConstraints.HORIZONTAL;
		clNOKLastName.insets = standardInsets;

		clNOKRelationship.gridx = 0;
		clNOKRelationship.gridy = 3;
		clNOKRelationship.gridwidth = 1;
		clNOKRelationship.gridheight = 1;
		clNOKRelationship.fill = GridBagConstraints.HORIZONTAL;
		clNOKRelationship.insets = standardInsets;

		clNOKEmailAddress.gridx = 2;
		clNOKEmailAddress.gridy = 1;
		clNOKEmailAddress.gridwidth = 1;
		clNOKEmailAddress.gridheight = 1;
		clNOKEmailAddress.fill = GridBagConstraints.HORIZONTAL;
		clNOKEmailAddress.insets = standardInsets;

		clNOKMobilePhoneNumber.gridx = 2;
		clNOKMobilePhoneNumber.gridy = 2;
		clNOKMobilePhoneNumber.gridwidth = 1;
		clNOKMobilePhoneNumber.gridheight = 1;
		clNOKMobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clNOKMobilePhoneNumber.insets = standardInsets;

		clNOKHomePhoneNumber.gridx = 2;
		clNOKHomePhoneNumber.gridy = 3;
		clNOKHomePhoneNumber.gridwidth = 1;
		clNOKHomePhoneNumber.gridheight = 1;
		clNOKHomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clNOKHomePhoneNumber.insets = standardInsets;

		ctNOKFirstName.gridx = 1;
		ctNOKFirstName.gridy = 1;
		ctNOKFirstName.gridwidth = 1;
		ctNOKFirstName.gridheight = 1;
		ctNOKFirstName.fill = GridBagConstraints.HORIZONTAL;
		ctNOKFirstName.insets = standardInsets;

		ctNOKLastName.gridx = 1;
		ctNOKLastName.gridy = 2;
		ctNOKLastName.gridwidth = 1;
		ctNOKLastName.gridheight = 1;
		ctNOKLastName.fill = GridBagConstraints.HORIZONTAL;
		ctNOKLastName.insets = standardInsets;

		ccboxNOKRelationship.gridx = 1;
		ccboxNOKRelationship.gridy = 3;
		ccboxNOKRelationship.gridwidth = 1;
		ccboxNOKRelationship.gridheight = 1;
		ccboxNOKRelationship.fill = GridBagConstraints.HORIZONTAL;
		ccboxNOKRelationship.insets = standardInsets;

		ctNOKEmailAddress.gridx = 3;
		ctNOKEmailAddress.gridy = 1;
		ctNOKEmailAddress.gridwidth = 1;
		ctNOKEmailAddress.gridheight = 1;
		ctNOKEmailAddress.fill = GridBagConstraints.HORIZONTAL;
		ctNOKEmailAddress.insets = standardInsets;

		ctNOKMobilePhoneNumber.gridx = 3;
		ctNOKMobilePhoneNumber.gridy = 2;
		ctNOKMobilePhoneNumber.gridwidth = 1;
		ctNOKMobilePhoneNumber.gridheight = 1;
		ctNOKMobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		ctNOKMobilePhoneNumber.insets = standardInsets;

		ctNOKHomePhoneNumber.gridx = 3;
		ctNOKHomePhoneNumber.gridy = 3;
		ctNOKHomePhoneNumber.gridwidth = 1;
		ctNOKHomePhoneNumber.gridheight = 1;
		ctNOKHomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		ctNOKHomePhoneNumber.insets = standardInsets;

		cbSave.gridx = 3;
		cbSave.gridy = 4;
		cbSave.gridwidth = 1;
		cbSave.gridheight = 1;
		cbSave.fill = GridBagConstraints.HORIZONTAL;
		cbSave.insets = standardInsets;

		pNextOfKin.add(lNextOfKin, clNextOfKin);
		pNextOfKin.add(lNOKFirstName, clNOKFirstName);
		pNextOfKin.add(lNOKLastName, clNOKLastName);
		pNextOfKin.add(lNOKRelationship, clNOKRelationship);
		pNextOfKin.add(lNOKEmailAddress, clNOKEmailAddress);
		pNextOfKin.add(lNOKMobilePhoneNumber, clNOKMobilePhoneNumber);
		pNextOfKin.add(lNOKHomePhoneNumber, clNOKHomePhoneNumber);
		pNextOfKin.add(tNOKFirstName, ctNOKFirstName);
		pNextOfKin.add(tNOKLastName, ctNOKLastName);
		pNextOfKin.add(cboxNOKRelationship, ccboxNOKRelationship);
		pNextOfKin.add(tNOKEmailAddress, ctNOKEmailAddress);
		pNextOfKin.add(tNOKMobilePhoneNumber, ctNOKMobilePhoneNumber);
		pNextOfKin.add(tNOKHomePhoneNumber, ctNOKHomePhoneNumber);
		pNextOfKin.add(bSave, cbSave);
		
		tabbedPane.addTab("Personal Details", pPersonal);
		tabbedPane.addTab("Addresses", pAddress);
		tabbedPane.addTab("Next Of Kin", pNextOfKin);
		frame.getContentPane().add(tabbedPane);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
}
