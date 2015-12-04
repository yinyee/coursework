package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * After successfully logging in, the Administrator will be directed to this screen,
 * which presents the following options:
 * 1.	Create, edit, delete a patient
 * 2.	Create, edit, delete a record
 * 3.	Search patients based on Patient instance variables
 * (4.)	Export list of patients to file
 * (5.) Import list of patients from file 
 * 
 * @author yinyee
 *
 */

public class Dashboard {
	
	private static Dashboard instance = null;
	
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	private final static String[] searchFields = {"First name", "Last name", "Birth date", "Gender"};
	
	private String searchField, searchText;
	
	private JFrame frame;
	private JLabel lWelcome, lSearch, lRegister, lResults;
	private JTextField tSearch;
	private JComboBox<String> cboxSearch;
	private JButton bSearch, bRegister, bOpen;
	private JSeparator sVertical, sHorizontal;
	private JTable tbResults;
	private ButtonListener bListener;
	
	private Dashboard() {
		draw();
	}
	
	/**
	 * The getInstance() method enforces the Singleton design pattern.
	 */
	
	public static Dashboard getInstance() {
		if (instance == null) {
			instance = new Dashboard();
		}
		return instance;
	}
	
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	private void draw() {
		
		frame = new JFrame("Dashboard");
		lWelcome = new JLabel("Welcome, Administrator");
		lSearch = new JLabel("Search");
		cboxSearch = new JComboBox<String>(searchFields);
		tSearch = new JTextField();
		bSearch = new JButton("Search");
		sVertical = new JSeparator(JSeparator.VERTICAL);
		lRegister = new JLabel("New patient");
		bRegister = new JButton("Register");
		sHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		lResults = new JLabel("Search Results");
		tbResults = new JTable(10, 4);
		bOpen = new JButton("Open patient profile");
		
		bSearch.addActionListener(bListener);
		bSearch.setActionCommand("Search");
		bRegister.addActionListener(bListener);
		bRegister.setActionCommand("Register");
		bOpen.addActionListener(bListener);
		bOpen.setActionCommand("Open");
		
		Container panel = frame.getContentPane();
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints clWelcome = new GridBagConstraints();
		GridBagConstraints clSearch = new GridBagConstraints();
		GridBagConstraints ccboxSearch = new GridBagConstraints();
		GridBagConstraints ctSearch = new GridBagConstraints();
		GridBagConstraints cbSearch = new GridBagConstraints();
		GridBagConstraints csVertical = new GridBagConstraints();
		GridBagConstraints clRegister = new GridBagConstraints();
		GridBagConstraints cbRegister = new GridBagConstraints();
		GridBagConstraints csHorizontal = new GridBagConstraints();
		GridBagConstraints clResults = new GridBagConstraints();
		GridBagConstraints ctbResults = new GridBagConstraints();
		GridBagConstraints cbOpen = new GridBagConstraints();
		
		clWelcome.gridx = 0;
		clWelcome.gridy = 0;
		clWelcome.gridwidth = 2;
		clWelcome.gridheight = 1;
		clWelcome.fill = GridBagConstraints.HORIZONTAL;
		clWelcome.insets = standardInsets;
		
		clSearch.gridx = 0;
		clSearch.gridy = 2;
		clSearch.gridwidth = 1;
		clSearch.gridheight = 1;
		clSearch.fill = GridBagConstraints.HORIZONTAL;
		clSearch.insets = standardInsets;
		
		ccboxSearch.gridx = 0;
		ccboxSearch.gridy = 3;
		ccboxSearch.gridwidth = 1;
		ccboxSearch.gridheight = 1;
		ccboxSearch.fill = GridBagConstraints.HORIZONTAL;
		ccboxSearch.insets = standardInsets;
		
		ctSearch.gridx = 1;
		ctSearch.gridy = 3;
		ctSearch.gridwidth = 1;
		ctSearch.gridheight = 1;
		ctSearch.fill = GridBagConstraints.HORIZONTAL;
		ctSearch.insets = standardInsets;
		
		cbSearch.gridx = 1;
		cbSearch.gridy = 4;
		cbSearch.gridwidth = 1;
		cbSearch.gridheight = 1;
		cbSearch.fill = GridBagConstraints.HORIZONTAL;
		cbSearch.insets = standardInsets;

		csVertical.gridx = 2;
		csVertical.gridy = 2;
		csVertical.gridwidth = 1;
		csVertical.gridheight = 3;
		csVertical.fill = GridBagConstraints.VERTICAL;
		csVertical.insets = standardInsets;
		
		clRegister.gridx = 3;
		clRegister.gridy = 2;
		clRegister.gridwidth = 1;
		clRegister.gridheight = 1;
		clRegister.fill = GridBagConstraints.HORIZONTAL;
		clRegister.insets = standardInsets;
		
		cbRegister.gridx = 3;
		cbRegister.gridy = 3;
		cbRegister.gridwidth = 1;
		cbRegister.gridheight = 1;
		cbRegister.fill = GridBagConstraints.HORIZONTAL;
		cbRegister.insets = standardInsets;		

		csHorizontal.gridx = 0;
		csHorizontal.gridy = 5;
		csHorizontal.gridwidth = 5;
		csHorizontal.gridheight = 1;
		csHorizontal.fill = GridBagConstraints.HORIZONTAL;
		csHorizontal.insets = standardInsets;
		
		clResults.gridx = 0;
		clResults.gridy = 6;
		clResults.gridwidth = 1;
		clResults.gridheight = 1;
		clResults.fill = GridBagConstraints.HORIZONTAL;
		clResults.insets = standardInsets;
		
		ctbResults.gridx = 0;
		ctbResults.gridy = 7;
		ctbResults.gridwidth = 5;
		ctbResults.gridheight = 1;
		ctbResults.fill = GridBagConstraints.HORIZONTAL;
		ctbResults.fill = GridBagConstraints.VERTICAL;
		ctbResults.insets = standardInsets;
		
		cbOpen.gridx = 3;
		cbOpen.gridy = 9;
		cbOpen.gridwidth = 2;
		cbOpen.gridheight = 1;
		cbOpen.fill = GridBagConstraints.HORIZONTAL;
		cbOpen.insets = standardInsets;
		
		panel.add(lWelcome, clWelcome);
		panel.add(lSearch, clSearch);
		panel.add(cboxSearch, ccboxSearch);
		panel.add(tSearch, ctSearch);
		panel.add(bSearch, cbSearch);
		panel.add(sVertical, csVertical);
		panel.add(lRegister, clRegister);
		panel.add(bRegister, cbRegister);
		panel.add(sHorizontal, csHorizontal);
		panel.add(lResults, clResults);
		panel.add(tbResults, ctbResults);
		panel.add(bOpen, cbOpen);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Search":
				searchField = cboxSearch.getSelectedItem().toString();
				searchText = tSearch.getText();
				break;
			case "Register":
				try {
					Registration registration = Registration.getInstance();
				} catch (Exception f) {
					f.printStackTrace();
				}
				break;
			case "Open":
				try {
//					tbResults.getSelectedRow();
//					Profile profile = Profile.getInstance(Patient patient);
				} catch (Exception f) {
					f.printStackTrace();
				}
				break;
			}
		}
	}
	
}
