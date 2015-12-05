package gui;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import person.Patient;

/**
 * Profile displays basic patient information and medical records
 * on the first tab.  Other tabs display the remaining information
 * about the patient.
 * 
 * @author yinyee
 *
 */

public class Profile {
	
	private static Profile instance = null;
	private Patient patient;
	
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel pMain, pAdditional, pView, pEdit;
	private ImageIcon photo;
	private JLabel lPhoto, lFullName, lGender, lBirthDate, lRecord;
	private JLabel lContactDetails, lEmailAddress, l2EmailAddress, lMobilePhoneNumber, l2MobilePhoneNumber, lHomePhoneNumber, l2HomePhoneNumber, lWorkPhoneNumber, l2WorkPhoneNumber;
	private JLabel lHomeAddress, lHomeNumberOrName, l2HomeNumberOrName, lHomeStreet, l2HomeStreet, lHomeCity, l2HomeCity, lHomePostalCode, l2HomePostalCode, lHomeCountry, l2HomeCountry;
	private JLabel lBillingAddress, lBillingNumberOrName, l2BillingNumberOrName, lBillingStreet, l2BillingStreet, lBillingCity, l2BillingCity, lBillingPostalCode, l2BillingPostalCode, lBillingCountry, l2BillingCountry;
	private JLabel lNextOfKin, lNOKFullName, l2NOKFullName, lNOKRelationship, l2NOKRelationship, lNOKEmailAddress, l2NOKEmailAddress, lNOKMobilePhoneNumber, l2NOKMobilePhoneNumber, lNOKHomePhoneNumber, l2NOKHomePhoneNumber;
	private JLabel leContactDetails, leEmailAddress, leMobilePhoneNumber, leHomePhoneNumber, leWorkPhoneNumber; 
	private JLabel leHomeAddress, leHomeNumberOrName, leHomeStreet, leHomeCity, leHomePostalCode, leHomeCountry;
	private JLabel leBillingAddress, leBillingNumberOrName, leBillingStreet, leBillingCity, leBillingPostalCode, leBillingCountry;
	private JLabel leNextOfKin, leNOKFullName, leNOKRelationship, leNOKEmailAddress, leNOKMobilePhoneNumber, leNOKHomePhoneNumber; 
	private JTextField le2EmailAddress, le2MobilePhoneNumber, le2HomePhoneNumber, le2WorkPhoneNumber;
	private JTextField le2HomeNumberOrName, le2HomeStreet, le2HomeCity, le2HomePostalCode, le2HomeCountry;
	private JTextField le2BillingNumberOrName, le2BillingStreet, le2BillingCity, le2BillingPostalCode, le2BillingCountry;
	private JTextField le2NOKFullName, le2NOKRelationship, le2NOKEmailAddress, le2NOKMobilePhoneNumber, le2NOKHomePhoneNumber;
	private JSeparator sMainHorizontal, sAddHorizontal1, sAddHorizontal2, seAddHorizontal1, seAddHorizontal2;
	private JTable tbRecord;
	private JButton bAdd, bView, bEdit, bCancel, bSave;
	private ButtonListener bListener;
	private CardController cardController;
	
	private Profile(Patient patient) {
		this.patient = patient;
		draw(patient);
	}
	
	/**
	 * The getInstance() method enforces the Singleton design pattern.
	 * @param patient
	 */
	public static Profile getInstance(Patient patient) {
		if (instance == null) {
			instance = new Profile(patient);
		}
		return instance;
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	private void draw(Patient patient) {
		
		frame = new JFrame("Patient Profile - " + patient.getFullName());
		tabbedPane = new JTabbedPane();
		pMain = new JPanel(new GridBagLayout());
		pAdditional = new JPanel(new CardLayout());
		pView = new JPanel(new GridBagLayout());
		pEdit = new JPanel(new GridBagLayout());

		// Main tab
		
		photo = new ImageIcon();
		lPhoto = new JLabel(photo);
		lFullName = new JLabel(patient.getFullName());
		lGender = new JLabel(patient.getGender().toString());
		lBirthDate = new JLabel("Born " + patient.getBirthDate().getFormalFormattedDate());
		sMainHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		lRecord = new JLabel("MEDICAL RECORD");
		tbRecord = new JTable(12, 3);
		bListener = new ButtonListener();
		bAdd = new JButton("Add New Record");
		bAdd.addActionListener(bListener);
		bAdd.setActionCommand("Add");
		bView = new JButton("View Record");
		bView.addActionListener(bListener);
		bView.setActionCommand("View");

		GridBagConstraints clPhoto = new GridBagConstraints();
		GridBagConstraints clFullName = new GridBagConstraints();
		GridBagConstraints clGender = new GridBagConstraints();
		GridBagConstraints clBirthDate = new GridBagConstraints();
		GridBagConstraints csMainHorizontal = new GridBagConstraints();
		GridBagConstraints clRecord = new GridBagConstraints();
		GridBagConstraints ctbRecord = new GridBagConstraints();
		GridBagConstraints cbAdd = new GridBagConstraints();
		GridBagConstraints cbView = new GridBagConstraints();
		
		clPhoto.gridx = 0;
		clPhoto.gridy = 0;
		clPhoto.gridwidth = 1;
		clPhoto.gridheight = 3;
		clPhoto.fill = GridBagConstraints.HORIZONTAL;
		clPhoto.fill = GridBagConstraints.VERTICAL;
		clPhoto.insets = standardInsets;
		
		clFullName.gridx = 1;
		clFullName.gridy = 0;
		clFullName.gridwidth = 1;
		clFullName.gridheight = 1;
		clFullName.fill = GridBagConstraints.HORIZONTAL;
		clFullName.insets = standardInsets;
				
		clGender.gridx = 1;
		clGender.gridy = 1;
		clGender.gridwidth = 1;
		clGender.gridheight = 1;
		clGender.fill = GridBagConstraints.HORIZONTAL;
		clGender.insets = standardInsets;
		
		clBirthDate.gridx = 1;
		clBirthDate.gridy = 2;
		clBirthDate.gridwidth = 1;
		clBirthDate.gridheight = 1;
		clBirthDate.fill = GridBagConstraints.HORIZONTAL;
		clBirthDate.insets = standardInsets;
		
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

		ctbRecord.gridx = 0;
		ctbRecord.gridy = 5;
		ctbRecord.gridwidth = 3;
		ctbRecord.gridheight = 1;
		ctbRecord.fill = GridBagConstraints.HORIZONTAL;
		ctbRecord.fill = GridBagConstraints.VERTICAL;
		ctbRecord.insets = standardInsets;

		cbAdd.gridx = 1;
		cbAdd.gridy = 6;
		cbAdd.gridwidth = 1;
		cbAdd.gridheight = 1;
		cbAdd.fill = GridBagConstraints.HORIZONTAL;
		cbAdd.insets = standardInsets;

		cbView.gridx = 2;
		cbView.gridy = 6;
		cbView.gridwidth = 1;
		cbView.gridheight = 1;
		cbView.fill = GridBagConstraints.HORIZONTAL;
		cbView.insets = standardInsets;

		pMain.add(lPhoto, clPhoto);
		pMain.add(lFullName, clFullName);
		pMain.add(lGender, clGender);
		pMain.add(lBirthDate, clBirthDate);
		pMain.add(sMainHorizontal, csMainHorizontal);
		pMain.add(lRecord, clRecord);
		pMain.add(tbRecord, ctbRecord);
		pMain.add(bAdd, cbAdd);
		pMain.add(bView, cbView);
		
		// Additional tab
		// Use Card layout to switch between View and Edit
		// View card
		
		lContactDetails = new JLabel("CONTACT DETAILS");
		lEmailAddress = new JLabel("Email address");
		l2EmailAddress = new JLabel(patient.getEmailAddress());
		lMobilePhoneNumber = new JLabel("Mobile phone number");
		l2MobilePhoneNumber = new JLabel(patient.getMobilePhoneNumber());
		lHomePhoneNumber = new JLabel("Home phone number");
		l2HomePhoneNumber = new JLabel(patient.getHomePhoneNumber());
		lWorkPhoneNumber = new JLabel("Work phone number");
		l2WorkPhoneNumber = new JLabel(patient.getWorkPhoneNumber());
		sAddHorizontal1 = new JSeparator(JSeparator.HORIZONTAL);
		lHomeAddress = new JLabel("HOME ADDRESS");
		lHomeNumberOrName = new JLabel("House number and name");
//		l2HomeNumberOrName = new JLabel(patient.getHomeAddress().getHouseNumberOrName());
//		lHomeStreet = new JLabel("Street");
//		l2HomeStreet = new JLabel(patient.getHomeAddress().getStreet());
//		lHomeCity = new JLabel("City or town");
//		l2HomeCity = new JLabel(patient.getHomeAddress().getCity());
//		lHomePostalCode = new JLabel("Postal code");
//		l2HomePostalCode = new JLabel(patient.getHomeAddress().getPostalCode());
//		lHomeCountry = new JLabel("Country");
//		l2HomeCountry = new JLabel(patient.getHomeAddress().getCountry());
//		lBillingAddress = new JLabel("BILLING ADDRESS");
//		lBillingNumberOrName = new JLabel("House number and name");
//		l2BillingNumberOrName = new JLabel(patient.getBillingAddress().getHouseNumberOrName());
//		lBillingStreet = new JLabel("Street");
//		l2BillingStreet = new JLabel(patient.getBillingAddress().getStreet());
//		lBillingCity = new JLabel("City or town");
//		l2BillingCity = new JLabel(patient.getBillingAddress().getCity());
//		lBillingPostalCode = new JLabel("Postal code");
//		l2BillingPostalCode = new JLabel(patient.getBillingAddress().getPostalCode());
//		lBillingCountry = new JLabel("Country");
//		l2BillingCountry = new JLabel(patient.getBillingAddress().getCountry());
//		sAddHorizontal2 = new JSeparator(JSeparator.HORIZONTAL);
//		lNextOfKin = new JLabel("NEXT OF KIN");
//		lNOKFullName = new JLabel("Full name");
//		l2NOKFullName = new JLabel(patient.getNextOfKin().getFullName());
//		lNOKRelationship = new JLabel("Relationship to patient");
//		l2NOKRelationship = new JLabel(patient.getNextOfKin().getRelationshipToPatient());
//		lNOKEmailAddress = new JLabel("Email address");
//		l2NOKEmailAddress = new JLabel(patient.getNextOfKin().getEmailAddress());
//		lNOKMobilePhoneNumber = new JLabel("Mobile phone number");
//		l2NOKMobilePhoneNumber = new JLabel(patient.getNextOfKin().getNextOfKinMobilePhoneNumber());
//		lNOKHomePhoneNumber = new JLabel("Home phone number");
//		l2NOKHomePhoneNumber = new JLabel(patient.getNextOfKin().getNextOfKinHomePhoneNumber());
		bEdit = new JButton("Edit");
		cardController = new CardController();
		bEdit.addActionListener(cardController);
		bEdit.setActionCommand("Edit");
		
		GridBagConstraints clContactDetails = new GridBagConstraints();
		GridBagConstraints clEmailAddress = new GridBagConstraints();
		GridBagConstraints cl2EmailAddress = new GridBagConstraints();
		GridBagConstraints clMobilePhoneNumber = new GridBagConstraints();
		GridBagConstraints cl2MobilePhoneNumber = new GridBagConstraints();
		GridBagConstraints cl2HomePhoneNumber = new GridBagConstraints();
		GridBagConstraints clHomePhoneNumber = new GridBagConstraints();
		GridBagConstraints clWorkPhoneNumber = new GridBagConstraints();
		GridBagConstraints cl2WorkPhoneNumber = new GridBagConstraints();
		GridBagConstraints csAddHorizontal1 = new GridBagConstraints();
		GridBagConstraints clHomeAddress = new GridBagConstraints();
		GridBagConstraints clHomeNumberOrName = new GridBagConstraints();
		GridBagConstraints cl2HomeNumberOrName = new GridBagConstraints();
		GridBagConstraints clHomeStreet = new GridBagConstraints();
		GridBagConstraints cl2HomeStreet = new GridBagConstraints();
		GridBagConstraints clHomeCity = new GridBagConstraints();
		GridBagConstraints cl2HomeCity = new GridBagConstraints();
		GridBagConstraints clHomePostalCode = new GridBagConstraints();
		GridBagConstraints cl2HomePostalCode = new GridBagConstraints();
		GridBagConstraints clHomeCountry = new GridBagConstraints();
		GridBagConstraints cl2HomeCountry = new GridBagConstraints();
		GridBagConstraints clBillingAddress = new GridBagConstraints();
		GridBagConstraints clBillingNumberOrName = new GridBagConstraints();
		GridBagConstraints cl2BillingNumberOrName = new GridBagConstraints();
		GridBagConstraints clBillingStreet = new GridBagConstraints();
		GridBagConstraints cl2BillingStreet = new GridBagConstraints();
		GridBagConstraints clBillingCity = new GridBagConstraints();
		GridBagConstraints cl2BillingCity = new GridBagConstraints();
		GridBagConstraints clBillingPostalCode = new GridBagConstraints();
		GridBagConstraints cl2BillingPostalCode = new GridBagConstraints();
		GridBagConstraints clBillingCountry = new GridBagConstraints();
		GridBagConstraints cl2BillingCountry = new GridBagConstraints();
		GridBagConstraints csAddHorizontal2 = new GridBagConstraints();
		GridBagConstraints clNextOfKin = new GridBagConstraints();
		GridBagConstraints clNOKFullName = new GridBagConstraints();
		GridBagConstraints cl2NOKFullName = new GridBagConstraints();
		GridBagConstraints clNOKRelationship = new GridBagConstraints();
		GridBagConstraints cl2NOKRelationship = new GridBagConstraints();
		GridBagConstraints clNOKEmailAddress = new GridBagConstraints();
		GridBagConstraints cl2NOKEmailAddress = new GridBagConstraints();
		GridBagConstraints clNOKMobilePhoneNumber = new GridBagConstraints();
		GridBagConstraints cl2NOKMobilePhoneNumber = new GridBagConstraints();
		GridBagConstraints clNOKHomePhoneNumber = new GridBagConstraints();
		GridBagConstraints cl2NOKHomePhoneNumber = new GridBagConstraints();
		GridBagConstraints cbEdit = new GridBagConstraints();

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
		cl2EmailAddress.gridwidth = 1;
		cl2EmailAddress.gridheight = 1;
		cl2EmailAddress.fill = GridBagConstraints.HORIZONTAL;
		cl2EmailAddress.insets = standardInsets;
		
		clMobilePhoneNumber.gridx = 2;
		clMobilePhoneNumber.gridy = 1;
		clMobilePhoneNumber.gridwidth = 1;
		clMobilePhoneNumber.gridheight = 1;
		clMobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clMobilePhoneNumber.insets = standardInsets;
		
		cl2MobilePhoneNumber.gridx = 3;
		cl2MobilePhoneNumber.gridy = 1;
		cl2MobilePhoneNumber.gridwidth = 1;
		cl2MobilePhoneNumber.gridheight = 1;
		cl2MobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		cl2MobilePhoneNumber.insets = standardInsets;
		
		clHomePhoneNumber.gridx = 2;
		clHomePhoneNumber.gridy = 2;
		clHomePhoneNumber.gridwidth = 1;
		clHomePhoneNumber.gridheight = 1;
		clHomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clHomePhoneNumber.insets = standardInsets;
		
		cl2HomePhoneNumber.gridx = 3;
		cl2HomePhoneNumber.gridy = 2;
		cl2HomePhoneNumber.gridwidth = 1;
		cl2HomePhoneNumber.gridheight = 1;
		cl2HomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		cl2HomePhoneNumber.insets = standardInsets;

		clWorkPhoneNumber.gridx = 2;
		clWorkPhoneNumber.gridy = 3;
		clWorkPhoneNumber.gridwidth = 1;
		clWorkPhoneNumber.gridheight = 1;
		clWorkPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clWorkPhoneNumber.insets = standardInsets;

		cl2WorkPhoneNumber.gridx = 3;
		cl2WorkPhoneNumber.gridy = 3;
		cl2WorkPhoneNumber.gridwidth = 1;
		cl2WorkPhoneNumber.gridheight = 1;
		cl2WorkPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		cl2WorkPhoneNumber.insets = standardInsets;

		csAddHorizontal1.gridx = 0;
		csAddHorizontal1.gridy = 4;
		csAddHorizontal1.gridwidth = 4;
		csAddHorizontal1.gridheight = 1;
		csAddHorizontal1.fill = GridBagConstraints.HORIZONTAL;
		csAddHorizontal1.insets = standardInsets;

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
		cl2HomeNumberOrName.gridwidth = 1;
		cl2HomeNumberOrName.gridheight = 1;
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
		cl2HomeStreet.gridwidth = 1;
		cl2HomeStreet.gridheight = 1;
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
		cl2HomeCity.gridwidth = 1;
		cl2HomeCity.gridheight = 1;
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
		cl2HomePostalCode.gridwidth = 1;
		cl2HomePostalCode.gridheight = 1;
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
		cl2HomeCountry.gridwidth = 1;
		cl2HomeCountry.gridheight = 1;
		cl2HomeCountry.fill = GridBagConstraints.HORIZONTAL;
		cl2HomeCountry.insets = standardInsets;

		clBillingAddress.gridx = 2;
		clBillingAddress.gridy = 5;
		clBillingAddress.gridwidth = 1;
		clBillingAddress.gridheight = 1;
		clBillingAddress.fill = GridBagConstraints.HORIZONTAL;
		clBillingAddress.insets = standardInsets;

		clBillingNumberOrName.gridx = 2;
		clBillingNumberOrName.gridy = 6;
		clBillingNumberOrName.gridwidth = 1;
		clBillingNumberOrName.gridheight = 1;
		clBillingNumberOrName.fill = GridBagConstraints.HORIZONTAL;
		clBillingNumberOrName.insets = standardInsets;

		cl2BillingNumberOrName.gridx = 3;
		cl2BillingNumberOrName.gridy = 6;
		cl2BillingNumberOrName.gridwidth = 1;
		cl2BillingNumberOrName.gridheight = 1;
		cl2BillingNumberOrName.fill = GridBagConstraints.HORIZONTAL;
		cl2BillingNumberOrName.insets = standardInsets;
		
		clBillingStreet.gridx = 2;
		clBillingStreet.gridy = 7;
		clBillingStreet.gridwidth = 1;
		clBillingStreet.gridheight = 1;
		clBillingStreet.fill = GridBagConstraints.HORIZONTAL;
		clBillingStreet.insets = standardInsets;

		cl2BillingStreet.gridx = 3;
		cl2BillingStreet.gridy = 7;
		cl2BillingStreet.gridwidth = 1;
		cl2BillingStreet.gridheight = 1;
		cl2BillingStreet.fill = GridBagConstraints.HORIZONTAL;
		cl2BillingStreet.insets = standardInsets;

		clBillingCity.gridx = 2;
		clBillingCity.gridy = 8;
		clBillingCity.gridwidth = 1;
		clBillingCity.gridheight = 1;
		clBillingCity.fill = GridBagConstraints.HORIZONTAL;
		clBillingCity.insets = standardInsets;

		cl2BillingCity.gridx = 3;
		cl2BillingCity.gridy = 8;
		cl2BillingCity.gridwidth = 1;
		cl2BillingCity.gridheight = 1;
		cl2BillingCity.fill = GridBagConstraints.HORIZONTAL;
		cl2BillingCity.insets = standardInsets;

		clBillingPostalCode.gridx = 2;
		clBillingPostalCode.gridy = 9;
		clBillingPostalCode.gridwidth = 1;
		clBillingPostalCode.gridheight = 1;
		clBillingPostalCode.fill = GridBagConstraints.HORIZONTAL;
		clBillingPostalCode.insets = standardInsets;

		cl2BillingPostalCode.gridx = 3;
		cl2BillingPostalCode.gridy = 9;
		cl2BillingPostalCode.gridwidth = 1;
		cl2BillingPostalCode.gridheight = 1;
		cl2BillingPostalCode.fill = GridBagConstraints.HORIZONTAL;
		cl2BillingPostalCode.insets = standardInsets;

		clBillingCountry.gridx = 2;
		clBillingCountry.gridy = 10;
		clBillingCountry.gridwidth = 1;
		clBillingCountry.gridheight = 1;
		clBillingCountry.fill = GridBagConstraints.HORIZONTAL;
		clBillingCountry.insets = standardInsets;

		cl2BillingCountry.gridx = 3;
		cl2BillingCountry.gridy = 10;
		cl2BillingCountry.gridwidth = 1;
		cl2BillingCountry.gridheight = 1;
		cl2BillingCountry.fill = GridBagConstraints.HORIZONTAL;
		cl2BillingCountry.insets = standardInsets;

		csAddHorizontal2.gridx = 0;
		csAddHorizontal2.gridy = 11;
		csAddHorizontal2.gridwidth = 4;
		csAddHorizontal2.gridheight = 1;
		csAddHorizontal2.fill = GridBagConstraints.HORIZONTAL;
		csAddHorizontal2.insets = standardInsets;

		clNextOfKin.gridx = 0;
		clNextOfKin.gridy = 12;
		clNextOfKin.gridwidth = 1;
		clNextOfKin.gridheight = 1;
		clNextOfKin.fill = GridBagConstraints.HORIZONTAL;
		clNextOfKin.insets = standardInsets;
		
		clNOKFullName.gridx = 0;
		clNOKFullName.gridy = 13;
		clNOKFullName.gridwidth = 1;
		clNOKFullName.gridheight = 1;
		clNOKFullName.fill = GridBagConstraints.HORIZONTAL;
		clNOKFullName.insets = standardInsets;

		cl2NOKFullName.gridx = 1;
		cl2NOKFullName.gridy = 13;
		cl2NOKFullName.gridwidth = 1;
		cl2NOKFullName.gridheight = 1;
		cl2NOKFullName.fill = GridBagConstraints.HORIZONTAL;
		cl2NOKFullName.insets = standardInsets;

		clNOKRelationship.gridx = 0;
		clNOKRelationship.gridy = 14;
		clNOKRelationship.gridwidth = 1;
		clNOKRelationship.gridheight = 1;
		clNOKRelationship.fill = GridBagConstraints.HORIZONTAL;
		clNOKRelationship.insets = standardInsets;

		cl2NOKRelationship.gridx = 1;
		cl2NOKRelationship.gridy = 14;
		cl2NOKRelationship.gridwidth = 1;
		cl2NOKRelationship.gridheight = 1;
		cl2NOKRelationship.fill = GridBagConstraints.HORIZONTAL;
		cl2NOKRelationship.insets = standardInsets;

		clNOKEmailAddress.gridx = 0;
		clNOKEmailAddress.gridy = 15;
		clNOKEmailAddress.gridwidth = 1;
		clNOKEmailAddress.gridheight = 1;
		clNOKEmailAddress.fill = GridBagConstraints.HORIZONTAL;
		clNOKEmailAddress.insets = standardInsets;

		cl2NOKEmailAddress.gridx = 1;
		cl2NOKEmailAddress.gridy = 15;
		cl2NOKEmailAddress.gridwidth = 1;
		cl2NOKEmailAddress.gridheight = 1;
		cl2NOKEmailAddress.fill = GridBagConstraints.HORIZONTAL;
		cl2NOKEmailAddress.insets = standardInsets;
		
		clNOKMobilePhoneNumber.gridx = 2;
		clNOKMobilePhoneNumber.gridy = 13;
		clNOKMobilePhoneNumber.gridwidth = 1;
		clNOKMobilePhoneNumber.gridheight = 1;
		clNOKMobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clNOKMobilePhoneNumber.insets = standardInsets;

		cl2NOKMobilePhoneNumber.gridx = 3;
		cl2NOKMobilePhoneNumber.gridy = 13;
		cl2NOKMobilePhoneNumber.gridwidth = 1;
		cl2NOKMobilePhoneNumber.gridheight = 1;
		cl2NOKMobilePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		cl2NOKMobilePhoneNumber.insets = standardInsets;

		clNOKHomePhoneNumber.gridx = 2;
		clNOKHomePhoneNumber.gridy = 14;
		clNOKHomePhoneNumber.gridwidth = 1;
		clNOKHomePhoneNumber.gridheight = 1;
		clNOKHomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		clNOKHomePhoneNumber.insets = standardInsets;
		
		cl2NOKHomePhoneNumber.gridx = 3;
		cl2NOKHomePhoneNumber.gridy = 14;
		cl2NOKHomePhoneNumber.gridwidth = 1;
		cl2NOKHomePhoneNumber.gridheight = 1;
		cl2NOKHomePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		cl2NOKHomePhoneNumber.insets = standardInsets;
		
		cbEdit.gridx = 3;
		cbEdit.gridy = 16;
		cbEdit.gridwidth = 1;
		cbEdit.gridheight = 1;
		cbEdit.fill = GridBagConstraints.HORIZONTAL;
		cbEdit.insets = standardInsets;
		
		pView.add(lContactDetails, clContactDetails);
		pView.add(lEmailAddress, clEmailAddress);
		pView.add(l2EmailAddress, cl2EmailAddress);
		pView.add(lMobilePhoneNumber, clMobilePhoneNumber);
		pView.add(l2MobilePhoneNumber, cl2MobilePhoneNumber);
		pView.add(lHomePhoneNumber, clHomePhoneNumber);
		pView.add(l2HomePhoneNumber, cl2HomePhoneNumber);
		pView.add(lWorkPhoneNumber, clWorkPhoneNumber);
		pView.add(l2WorkPhoneNumber, cl2WorkPhoneNumber);
		pView.add(sAddHorizontal1, csAddHorizontal1);
		pView.add(lHomeAddress, clHomeAddress);
		pView.add(lHomeNumberOrName, clHomeNumberOrName);
//		pView.add(l2HomeNumberOrName, cl2HomeNumberOrName);
//		pView.add(lHomeStreet, clHomeStreet);
//		pView.add(l2HomeStreet, cl2HomeStreet);
//		pView.add(lHomeCity, clHomeCity);
//		pView.add(l2HomeCity, cl2HomeCity);
//		pView.add(lHomePostalCode, clHomePostalCode);
//		pView.add(l2HomePostalCode, cl2HomePostalCode);
//		pView.add(lHomeCountry, clHomeCountry);
//		pView.add(l2HomeCountry, cl2HomeCountry);
//		pView.add(lBillingAddress, clBillingAddress);
//		pView.add(lBillingNumberOrName, clBillingNumberOrName);
//		pView.add(l2BillingNumberOrName, cl2BillingNumberOrName);
//		pView.add(lBillingStreet, clBillingStreet);
//		pView.add(l2BillingStreet, cl2BillingStreet);
//		pView.add(lBillingCity, clBillingCity);
//		pView.add(l2BillingCity, cl2BillingCity);
//		pView.add(lBillingPostalCode, clBillingPostalCode);
//		pView.add(l2BillingPostalCode, cl2BillingPostalCode);
//		pView.add(lBillingCountry, clBillingCountry);
//		pView.add(l2BillingCountry, cl2BillingCountry);
//		pView.add(sAddHorizontal2, csAddHorizontal2);
//		pView.add(lNextOfKin, clNextOfKin);
//		pView.add(lNOKFullName, clNOKFullName);
//		pView.add(l2NOKFullName, cl2NOKFullName);
//		pView.add(lNOKRelationship, clNOKRelationship);
//		pView.add(l2NOKRelationship, cl2NOKRelationship);
//		pView.add(lNOKEmailAddress, clNOKEmailAddress);
//		pView.add(l2NOKEmailAddress, cl2NOKEmailAddress);
//		pView.add(lNOKMobilePhoneNumber, clNOKMobilePhoneNumber);
//		pView.add(l2NOKMobilePhoneNumber, cl2NOKMobilePhoneNumber);
//		pView.add(lNOKHomePhoneNumber, clNOKHomePhoneNumber);
//		pView.add(l2NOKHomePhoneNumber, cl2NOKHomePhoneNumber);
		pView.add(bEdit, cbEdit);
		
		// Edit card
		
		leContactDetails = new JLabel("CONTACT DETAILS");
		leEmailAddress = new JLabel("Email address");
		le2EmailAddress = new JTextField(patient.getEmailAddress());
		leMobilePhoneNumber = new JLabel("Mobile phone number");
		le2MobilePhoneNumber = new JTextField(patient.getMobilePhoneNumber());
		leHomePhoneNumber = new JLabel("Home phone number");
		le2HomePhoneNumber = new JTextField(patient.getHomePhoneNumber());
		leWorkPhoneNumber = new JLabel("Work phone number");
		le2WorkPhoneNumber = new JTextField(patient.getWorkPhoneNumber());
		seAddHorizontal1 = new JSeparator(JSeparator.HORIZONTAL);
		leHomeAddress = new JLabel("HOME ADDRESS");
		leHomeNumberOrName = new JLabel("House number and name");
//		le2HomeNumberOrName = new JTextField(patient.getHomeAddress().getHouseNumberOrName());
//		leHomeStreet = new JLabel("Street");
//		le2HomeStreet = new JTextField(patient.getHomeAddress().getStreet());
//		leHomeCity = new JLabel("City or town");
//		le2HomeCity = new JTextField(patient.getHomeAddress().getCity());
//		leHomePostalCode = new JLabel("Postal code");
//		le2HomePostalCode = new JTextField(patient.getHomeAddress().getPostalCode());
//		leHomeCountry = new JLabel("Country");
//		le2HomeCountry = new JTextField(patient.getHomeAddress().getCountry());
//		leBillingAddress = new JLabel("BILLING ADDRESS");
//		leBillingNumberOrName = new JLabel("House number and name");
//		le2BillingNumberOrName = new JTextField(patient.getBillingAddress().getHouseNumberOrName());
//		leBillingStreet = new JLabel("Street");
//		le2BillingStreet = new JTextField(patient.getBillingAddress().getStreet());
//		leBillingCity = new JLabel("City or town");
//		le2BillingCity = new JTextField(patient.getBillingAddress().getCity());
//		leBillingPostalCode = new JLabel("Postal code");
//		le2BillingPostalCode = new JTextField(patient.getBillingAddress().getPostalCode());
//		leBillingCountry = new JLabel("Country");
//		le2BillingCountry = new JTextField(patient.getBillingAddress().getCountry());
//		seAddHorizontal2 = new JSeparator(JSeparator.HORIZONTAL);
//		leNextOfKin = new JLabel("NEXT OF KIN");
//		leNOKFullName = new JLabel("Full name");
//		le2NOKFullName = new JTextField(patient.getNextOfKin().getFullName());
//		leNOKRelationship = new JLabel("Relationship to patient");
//		le2NOKRelationship = new JTextField(patient.getNextOfKin().getRelationshipToPatient());
//		leNOKEmailAddress = new JLabel("Email address");
//		le2NOKEmailAddress = new JTextField(patient.getNextOfKin().getEmailAddress());
//		leNOKMobilePhoneNumber = new JLabel("Mobile phone number");
//		le2NOKMobilePhoneNumber = new JTextField(patient.getNextOfKin().getNextOfKinMobilePhoneNumber());
//		leNOKHomePhoneNumber = new JLabel("Home phone number");
//		le2NOKHomePhoneNumber = new JTextField(patient.getNextOfKin().getNextOfKinHomePhoneNumber());
		bCancel = new JButton("Cancel");
		bCancel.addActionListener(cardController);
		bCancel.setActionCommand("Cancel");
		bSave = new JButton("Save");
		bSave.addActionListener(cardController);
		bSave.setActionCommand("Save");
		
		GridBagConstraints cbCancel = new GridBagConstraints();
		GridBagConstraints cbSave = new GridBagConstraints();
		
		cbCancel.gridx = 2;
		cbCancel.gridy = 16;
		cbCancel.gridwidth = 1;
		cbCancel.gridheight = 1;
		cbCancel.fill = GridBagConstraints.HORIZONTAL;
		cbCancel.insets = standardInsets;
		
		cbSave.gridx = 3;
		cbSave.gridy = 16;
		cbSave.gridwidth = 1;
		cbSave.gridheight = 1;
		cbSave.fill = GridBagConstraints.HORIZONTAL;
		cbSave.insets = standardInsets;
		
		pEdit.add(leContactDetails, clContactDetails);
		pEdit.add(leEmailAddress, clEmailAddress);
		pEdit.add(le2EmailAddress, cl2EmailAddress);
		pEdit.add(leMobilePhoneNumber, clMobilePhoneNumber);
		pEdit.add(le2MobilePhoneNumber, cl2MobilePhoneNumber);
		pEdit.add(leHomePhoneNumber, clHomePhoneNumber);
		pEdit.add(le2HomePhoneNumber, cl2HomePhoneNumber);
		pEdit.add(leWorkPhoneNumber, clWorkPhoneNumber);
		pEdit.add(le2WorkPhoneNumber, cl2WorkPhoneNumber);
		pEdit.add(seAddHorizontal1, csAddHorizontal1);
		pEdit.add(leHomeAddress, clHomeAddress);
		pEdit.add(leHomeNumberOrName, clHomeNumberOrName);
//		pEdit.add(le2HomeNumberOrName, cl2HomeNumberOrName);
//		pEdit.add(leHomeStreet, clHomeStreet);
//		pEdit.add(le2HomeStreet, cl2HomeStreet);
//		pEdit.add(leHomeCity, clHomeCity);
//		pEdit.add(le2HomeCity, cl2HomeCity);
//		pEdit.add(leHomePostalCode, clHomePostalCode);
//		pEdit.add(le2HomePostalCode, cl2HomePostalCode);
//		pEdit.add(leHomeCountry, clHomeCountry);
//		pEdit.add(le2HomeCountry, cl2HomeCountry);
//		pEdit.add(leBillingAddress, clBillingAddress);
//		pEdit.add(leBillingNumberOrName, clBillingNumberOrName);
//		pEdit.add(le2BillingNumberOrName, cl2BillingNumberOrName);
//		pEdit.add(leBillingStreet, clBillingStreet);
//		pEdit.add(le2BillingStreet, cl2BillingStreet);
//		pEdit.add(leBillingCity, clBillingCity);
//		pEdit.add(le2BillingCity, cl2BillingCity);
//		pEdit.add(leBillingPostalCode, clBillingPostalCode);
//		pEdit.add(le2BillingPostalCode, cl2BillingPostalCode);
//		pEdit.add(leBillingCountry, clBillingCountry);
//		pEdit.add(le2BillingCountry, cl2BillingCountry);
//		pEdit.add(seAddHorizontal2, csAddHorizontal2);
//		pEdit.add(leNextOfKin, clNextOfKin);
//		pEdit.add(leNOKFullName, clNOKFullName);
//		pEdit.add(le2NOKFullName, cl2NOKFullName);
//		pEdit.add(leNOKRelationship, clNOKRelationship);
//		pEdit.add(le2NOKRelationship, cl2NOKRelationship);
//		pEdit.add(leNOKEmailAddress, clNOKEmailAddress);
//		pEdit.add(le2NOKEmailAddress, cl2NOKEmailAddress);
//		pEdit.add(leNOKMobilePhoneNumber, clNOKMobilePhoneNumber);
//		pEdit.add(le2NOKMobilePhoneNumber, cl2NOKMobilePhoneNumber);
//		pEdit.add(leNOKHomePhoneNumber, clNOKHomePhoneNumber);
//		pEdit.add(le2NOKHomePhoneNumber, cl2NOKHomePhoneNumber);
		pEdit.add(bCancel, cbCancel);
		pEdit.add(bSave, cbSave);
		
		// Add cards to pAdditional
		pAdditional.add(pView, "View");
		pAdditional.add(pEdit, "Edit");
		
		tabbedPane.addTab("Main", pMain);
		tabbedPane.addTab("Additional", pAdditional);
		
		frame.getContentPane().add(tabbedPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private NewRecord addNewRecord(Patient patient) {
		return NewRecord.getInstance(patient);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Add" :
				addNewRecord(patient);
				break;
			case "Edit" :
//				tbRecord.getSelectedRow();
//				ViewEditRecord window = ViewEditRecord.getInstance(record);
				break;
			}		
		}
	}
		
	private class CardController implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			CardLayout layout = (CardLayout)(pAdditional.getLayout());
			switch(e.getActionCommand()) {
			case "Edit" : 
				layout.show(pAdditional, "Edit");
				break;
			case "Cancel" :
				layout.show(pAdditional, "View");
				break;
			case "Save" :
				// Save to file!!
				layout.show(pAdditional, "View");
				break;
			}
		}	
	}


}
