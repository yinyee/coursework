package gui;

import java.awt.Container;
import java.awt.EventQueue;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	
	private String searchField, searchText;
	private static ComboBoxListener cboxListener;
	private static TextFieldListener tListener;
	private static ButtonListener bListener;
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
		
		JFrame frame = new JFrame("Dashboard");
		Container panel = frame.getContentPane();
		JLabel lWelcome = new JLabel("Welcome, Administrator");
		JLabel lSearch = new JLabel("Search");
		String[] searchFields = {"First name", "Last name", "Birth date", "Gender"};
		JComboBox cboxSearch = new JComboBox(searchFields);
		JTextField tSearch = new JTextField();
		JButton bSearch = new JButton("Search");
		JSeparator sVertical = new JSeparator(JSeparator.VERTICAL);
		JLabel lRegister = new JLabel("New patient");
		JButton bRegister = new JButton("Register");
		JSeparator sHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		JLabel lResults = new JLabel("Search Results");
		JTable tbResults = new JTable();
		JButton bEdit = new JButton("Edit Patient Details");
		
		// THESE LISTENERS HAVE NOT BEEN INITIALISED !!!
		// The following section adds listeners to certain components.
		cboxSearch.addItemListener(cboxListener);
		tSearch.addKeyListener(tListener);
		bSearch.addActionListener(bListener);
		bSearch.setActionCommand("Search");
		bRegister.addActionListener(bListener);
		bRegister.setActionCommand("Register");
		bEdit.addActionListener(bListener);
		bEdit.setActionCommand("Edit");
		
		// The following section specifies the GridBagConsraints for each component.
		
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
		GridBagConstraints cbEdit = new GridBagConstraints();
		
		clWelcome.gridx = 0;
		clWelcome.gridy = 0;
		clWelcome.gridwidth = 2;
		clWelcome.gridheight = 1;
		clWelcome.fill = GridBagConstraints.HORIZONTAL;
		clWelcome.insets = new Insets(5, 5, 5, 5);
		
		clSearch.gridx = 0;
		clSearch.gridy = 2;
		clSearch.gridwidth = 1;
		clSearch.gridheight = 1;
		clSearch.fill = GridBagConstraints.HORIZONTAL;
		clSearch.insets = new Insets(5, 5, 5, 5);
		
		ccboxSearch.gridx = 0;
		ccboxSearch.gridy = 3;
		ccboxSearch.gridwidth = 1;
		ccboxSearch.gridheight = 1;
		ccboxSearch.fill = GridBagConstraints.HORIZONTAL;
		ccboxSearch.insets = new Insets(5, 5, 5, 5);
		
		ctSearch.gridx = 1;
		ctSearch.gridy = 3;
		ctSearch.gridwidth = 1;
		ctSearch.gridheight = 1;
		ctSearch.fill = GridBagConstraints.HORIZONTAL;
		ctSearch.insets = new Insets(5, 5, 5, 5);
		
		cbSearch.gridx = 1;
		cbSearch.gridy = 4;
		cbSearch.gridwidth = 1;
		cbSearch.gridheight = 1;
		cbSearch.fill = GridBagConstraints.HORIZONTAL;
		cbSearch.insets = new Insets(5, 5, 5, 5);

		csVertical.gridx = 2;
		csVertical.gridy = 2;
		csVertical.gridwidth = 1;
		csVertical.gridheight = 3;
		csVertical.fill = GridBagConstraints.VERTICAL;
		csVertical.insets = new Insets(5, 5, 5, 5);
		
		clRegister.gridx = 3;
		clRegister.gridy = 2;
		clRegister.gridwidth = 1;
		clRegister.gridheight = 1;
		clRegister.fill = GridBagConstraints.HORIZONTAL;
		clRegister.insets = new Insets(5, 5, 5, 5);
		
		cbRegister.gridx = 3;
		cbRegister.gridy = 3;
		cbRegister.gridwidth = 1;
		cbRegister.gridheight = 1;
		cbRegister.fill = GridBagConstraints.HORIZONTAL;
		cbRegister.insets = new Insets(5, 5, 5, 5);		

		csHorizontal.gridx = 0;
		csHorizontal.gridy = 5;
		csHorizontal.gridwidth = 5;
		csHorizontal.gridheight = 1;
		csHorizontal.fill = GridBagConstraints.HORIZONTAL;
		csHorizontal.insets = new Insets(5, 5, 5, 5);
		
		clResults.gridx = 0;
		clResults.gridy = 6;
		clResults.gridwidth = 1;
		clResults.gridheight = 1;
		clResults.fill = GridBagConstraints.HORIZONTAL;
		clResults.insets = new Insets(5, 5, 5, 5);
		
		ctbResults.gridx = 0;
		ctbResults.gridy = 7;
		ctbResults.gridwidth = 5;
		ctbResults.gridheight = 1;
		ctbResults.fill = GridBagConstraints.HORIZONTAL;
		ctbResults.fill = GridBagConstraints.VERTICAL;
		ctbResults.insets = new Insets(5, 5, 5, 5);
		
		cbEdit.gridx = 3;
		cbEdit.gridy = 9;
		cbEdit.gridwidth = 2;
		cbEdit.gridheight = 1;
		cbEdit.fill = GridBagConstraints.HORIZONTAL;
		cbEdit.insets = new Insets(5, 5, 5, 5);
		
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
		panel.add(bEdit, cbEdit);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	/**
	 * The following section contains helper listener classes.
	 */
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Search":
				;
				break;
			case "Register":
				;
				break;
			case "Edit":
				;
				break;
			}
		}
	}
	
	private class ComboBoxListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				searchField = e.getItem().toString();
			}
		}
	}
	
	private class TextFieldListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
