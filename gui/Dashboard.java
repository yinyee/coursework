package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import io.Interpreter;
import obj.Patient;

import javax.swing.JSeparator;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Dashboard class is implemented based on the Singleton design pattern.
 * 
 * After successfully logging in, the Administrator will be directed to this screen,
 * which presents the following options:
 * 1.	Search patients based on specified search fields
 * 2.	Register a new patient 
 * 
 * References:
 * >> http://stackoverflow.com/questions/10321038/jtable-clickable-column-sorting-sorting-sorts-content-of-cells-but-doesnt-upd
 * >> https://www.clear.rice.edu/comp310/JavaResources/frame_close.html
 * >> http://stackoverflow.com/questions/9919230/disable-user-edit-in-jtable
 * @author yinyee
 *
 */

public class Dashboard {
	
	private static Dashboard instance = null;
	private final static String database = "data/patient.xml";
	
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	private final static String[] searchFields = {"First name", "Last name", "Gender", "Postal code"};
	private final static String[] header = {"First name", "Last name", "Gender", "Birth date", "Birth month", "Birth year",
			"Email address", "Mobile number", "Home number", "House number or name", "Street", "City", "Postal code", "Country", "Photo"};
	
	private String searchField, searchText;
	private String[][] searchResults;
	
	private JFrame frame;
	private JLabel lWelcome, lSearch, lRegister, lResults;
	private JTextField tSearch;
	private JComboBox<String> cboxSearch;
	private JButton bSearch, bRegister, bOpen, bLogout;
	private JSeparator sVertical, sHorizontal;
	private JScrollPane scrResults;
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
	 * The search() method searches the database for patients based the
	 * the search field specified and the desired search term.
	 */
	private void search() {
		searchField = cboxSearch.getSelectedItem().toString();
		searchText = tSearch.getText();			 
		Interpreter interpreter = new Interpreter();
		searchResults = interpreter.searchPatient(database, searchField, searchText);
		tbResults = new JTable(searchResults, header) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tbResults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbResults.setMinimumSize(tbResults.getPreferredSize());
		tbResults.setAutoCreateRowSorter(true);
		scrResults.setViewportView(tbResults);
		scrResults.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrResults.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.validate();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Search":
				search();
				break;
			case "Register":
				try {
					NewPatient rWindow = new NewPatient();
				} catch (Exception f) {
					f.printStackTrace();
				}
				break;
			case "Open":
				try {
					String[] selection = searchResults[tbResults.getSelectedRow()];					
					ViewEditPatient pWindow = new ViewEditPatient(new Patient(selection));
					break;
				} catch (Exception f) {
					f.printStackTrace();
				}
				break;
			case "Logout":
				JFrame small = new JFrame();
				JOptionPane.showMessageDialog(small, "You have logged out successfully\n Thank you for using the patient\nregistry system.");
				System.exit(0);
				break;
			}
		}
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	private void draw() {
		
		frame = new JFrame("Dashboard");
		lWelcome = new JLabel("Welcome, Administrator");
		lSearch = new JLabel("Search patients");
		cboxSearch = new JComboBox<String>(searchFields);
		tSearch = new JTextField();
		bSearch = new JButton("Search");
		sVertical = new JSeparator(JSeparator.VERTICAL);
		lRegister = new JLabel("New patient");
		bRegister = new JButton("Register");
		sHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		lResults = new JLabel("Search results");
		tbResults = new JTable(5, 10);
		tbResults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbResults.setFillsViewportHeight(true);
		scrResults = new JScrollPane(tbResults);
		scrResults.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrResults.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		bOpen = new JButton("Open patient profile");
		bLogout = new JButton("Log out");
		
		bListener = new ButtonListener();
		bSearch.addActionListener(bListener);
		bSearch.setActionCommand("Search");
		bRegister.addActionListener(bListener);
		bRegister.setActionCommand("Register");
		bOpen.addActionListener(bListener);
		bOpen.setActionCommand("Open");
		bLogout.addActionListener(bListener);
		bLogout.setActionCommand("Logout");
		
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
		GridBagConstraints cscrResults = new GridBagConstraints();
		GridBagConstraints cbOpen = new GridBagConstraints();
		GridBagConstraints cbLogout = new GridBagConstraints();
		
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
		
		cscrResults.gridx = 0;
		cscrResults.gridy = 7;
		cscrResults.gridwidth = 5;
		cscrResults.gridheight = 1;
		cscrResults.fill = GridBagConstraints.HORIZONTAL;
		cscrResults.fill = GridBagConstraints.VERTICAL;
		cscrResults.insets = standardInsets;
		
		cbOpen.gridx = 3;
		cbOpen.gridy = 9;
		cbOpen.gridwidth = 1;
		cbOpen.gridheight = 1;
		cbOpen.fill = GridBagConstraints.HORIZONTAL;
		cbOpen.insets = standardInsets;

		cbLogout.gridx = 3;
		cbLogout.gridy = 0;
		cbLogout.gridwidth = 1;
		cbLogout.gridheight = 1;
		cbLogout.fill = GridBagConstraints.HORIZONTAL;
		cbLogout.insets = standardInsets;
		
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
		panel.add(scrResults, cscrResults);
		panel.add(bOpen, cbOpen);
		panel.add(bLogout, cbLogout);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
			
}
