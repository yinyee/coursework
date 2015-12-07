package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import io.Interpreter;

import obj.Patient;

import javax.swing.JSeparator;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * The Dashboard class is implemented based on the Singleton design pattern.
 * 
 * After successfully logging in, the Administrator will be directed to this screen,
 * which presents the following options:
 * 1.	Search patients based on specified search fields
 * 2.	Register a new patient 
 * 
 * References:
 * - http://stackoverflow.com/questions/10321038/jtable-clickable-column-sorting-sorting-sorts-content-of-cells-but-doesnt-upd
 * - https://www.clear.rice.edu/comp310/JavaResources/frame_close.html
 * - http://stackoverflow.com/questions/9919230/disable-user-edit-in-jtable
 * - https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
 * - https://moodle.ucl.ac.uk/pluginfile.php/3177853/mod_resource/content/1/GC02-week7-DesignPatterns-2015-16.pdf
 * - https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html
 * @author yinyee
 *
 */

public class Dashboard extends JFrame implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	private static Dashboard instance = null;
	private JFileChooser fChooser = new JFileChooser();
	public final static String PATIENT = "data/patient.xml";
	public final static String EXPORT = "data/export.xml";
	
	private final static Logger LOGGER = Logger.getLogger(Dashboard.class.getName());
	private final static Insets STANDARDINSETS = new Insets(5, 5, 5, 5);
	private final static String[] SEARCHFIELDS = {"First name", "Last name", "Gender", "Birth date", "Birth month", "Birth year", "Email address", "Mobile phone number", "Home phone number", "House number or name", "Street", "City", "Postal code", "Country"};
	private final static String[] HEADER = {"First name", "Last name", "Gender", "Birth date", "Birth month", "Birth year",
			"Email address", "Mobile number", "Home number", "House number or name", "Street", "City", "Postal code", "Country", "Photo"};
	
	private String searchField, searchText;
	private String[][] searchResults;
	
	private JFrame small;
	private Container panel;
	private JLabel lWelcome, lSearch, lRegister, lResults;
	private JTextField tSearch;
	private JComboBox<String> cboxSearch;
	private JButton bSearch, bRegister, bOpen, bLogout, bImport, bExport;
	private JSeparator sVertical, sHorizontal;
	private JScrollPane scrResults;
	private JTable tbResults;
	private ButtonListener bListener;
	
	private GridBagConstraints clWelcome, clSearch, ccboxSearch, ctSearch, cbSearch, csVertical, clRegister, cbRegister, 
			csHorizontal, clResults, cscrResults, cbOpen, cbLogout, cbImport, cbExport;

	private Dashboard() {
		
		this.addMouseListener(this);
		
		// Inititalise GUI elements
		this.setTitle("Patient Management System -- Dashboard");
		this.setLocationRelativeTo(null);
		panel = this.getContentPane();
		panel.setLayout(new GridBagLayout());
		lWelcome = new JLabel("Welcome, Administrator");
		lSearch = new JLabel("Search patients");
		cboxSearch = new JComboBox<String>(SEARCHFIELDS);
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
		bImport = new JButton("Import");
		bExport = new JButton("Export");	
		bListener = new ButtonListener();
		bSearch.addActionListener(bListener);
		bSearch.setActionCommand("Search");
		bRegister.addActionListener(bListener);
		bRegister.setActionCommand("Register");
		bOpen.addActionListener(bListener);
		bOpen.setActionCommand("Open");
		bLogout.addActionListener(bListener);
		bLogout.setActionCommand("Logout");
		bImport.addActionListener(bListener);
		bImport.setActionCommand("Import");
		bExport.addActionListener(bListener);
		bExport.setActionCommand("Export");

		clWelcome = new GridBagConstraints();
		clSearch = new GridBagConstraints();
		ccboxSearch = new GridBagConstraints();
		ctSearch = new GridBagConstraints();
		cbSearch = new GridBagConstraints();
		csVertical = new GridBagConstraints();
		clRegister = new GridBagConstraints();
		cbRegister = new GridBagConstraints();
		csHorizontal = new GridBagConstraints();
		clResults = new GridBagConstraints();
		cscrResults = new GridBagConstraints();
		cbOpen = new GridBagConstraints();
		cbLogout = new GridBagConstraints();
		cbImport = new GridBagConstraints();
		cbExport = new GridBagConstraints();

		draw();
	}
	
	/**
	 * The getInstance() method enforces the Singleton design pattern.
	 * @return instance The only instance of the Dashboard
	 */
	public static Dashboard getInstance() {
		if (instance == null) {
			instance = new Dashboard();
		}
		return instance;
	}

	/**
	 * The newPatient() method launches a new NewPatient screen.
	 */
	private void newPatient() {
		try {
			NewPatient npWindow = new NewPatient();
			npWindow.setVisible(true);
		} catch (Exception f) {
			f.printStackTrace();
		}
	}
	
	/**
	 * The importData() method allows the user to import patient data from an appropriate .xml
	 * file into the patient database.
	 */
	private void importData() {
		try {
			fChooser.setCurrentDirectory(new File(NewRecord.class.getClassLoader().getResource("data/").getPath()));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
			fChooser.setFileFilter(filter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int m = this.fChooser.showOpenDialog(new JFrame());
		switch(m) {
		case JFileChooser.APPROVE_OPTION :
			try {
				URI file = fChooser.getSelectedFile().toURI();
				Interpreter interpreter = new Interpreter();
				interpreter.importPatients(Dashboard.class.getClassLoader().getResource(PATIENT).toURI(), file);
			} catch (URISyntaxException urise) {
				urise.printStackTrace();
			}
			draw();
			break;
		case JFileChooser.CANCEL_OPTION :
			break;
		}
	}
	
	/**
	 * The exportData() method exports the selected patient records to "export.xml" in the bin/ folder.
	 */
	private void exportData() {
		
		int[] rows = tbResults.getSelectedRows();
		
		String[][] exportData = new String[rows.length][HEADER.length];
		System.out.println(rows.length);
		for (int j = 0; j < rows.length; j++) {
			exportData[j] = searchResults[rows[j]];
		}
		
		try {
			Interpreter interpreter = new Interpreter();
			interpreter.exportPatientData(Dashboard.class.getClassLoader().getResource(PATIENT).toURI(), Dashboard.class.getClassLoader().getResource(EXPORT).toURI(), exportData);
		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		}
	}

	/**
	 * The search() method searches the database for patients based the
	 * the search field specified and the desired search term.
	 */
	private void search() {
		
		searchField = cboxSearch.getSelectedItem().toString();
		searchText = tSearch.getText();
		LOGGER.info("Searching patient database for " + searchField + " containing " + searchText);
		
		try {
			Interpreter interpreter = new Interpreter();	
			if (interpreter.searchPatients(Dashboard.class.getClassLoader().getResource(PATIENT).toURI(), searchField, searchText) == null) {
				JOptionPane.showMessageDialog(small, "There are no matches for\n" + searchField + " containing " + searchText);
			} else {
				searchResults = interpreter.searchPatients(Dashboard.class.getClassLoader().getResource(PATIENT).toURI(), searchField, searchText);
				tbResults = new JTable(searchResults, HEADER) {
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
				
				this.validate();
			} 
		} catch (URISyntaxException urise) {
				urise.printStackTrace();
		}		
	}
	
	/**
	 * The viewEditPatient() method launches a new ViewEditPatient screen 
	 * and populates it with the selected patient.
	 */
	private void viewEditPatient() {
		try {
			String[] selection = searchResults[tbResults.getSelectedRow()];
			ViewEditPatient vepWindow = new ViewEditPatient(new Patient(selection));
			vepWindow.setVisible(true);
		} catch (Exception f) {
			JOptionPane.showMessageDialog(small, "Please select a patient from\nthe search results table.");
			f.printStackTrace();
		}
	}
		
	/**
	 * The logout option exits the program with a goodbye message.
	 */
	private void logout() {
		JOptionPane.showMessageDialog(small, "You have logged out successfully.\n Thank you for using the patient\nregistry system.");
		System.exit(0);
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
			case "Search":
				search();
				break;
			case "Register":
				newPatient();
				break;
			case "Open":
				viewEditPatient();
				break;
			case "Logout":
				logout();
				break;
			case "Import":
				importData();
				break;
			case "Export":
				exportData();
				break;
			}
		}
	}
		
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	private void draw() {
		
		panel = this.getContentPane();
		
		clWelcome.gridx = 0;
		clWelcome.gridy = 0;
		clWelcome.gridwidth = 2;
		clWelcome.gridheight = 1;
		clWelcome.fill = GridBagConstraints.HORIZONTAL;
		clWelcome.insets = STANDARDINSETS;
		
		clSearch.gridx = 0;
		clSearch.gridy = 2;
		clSearch.gridwidth = 1;
		clSearch.gridheight = 1;
		clSearch.fill = GridBagConstraints.HORIZONTAL;
		clSearch.insets = STANDARDINSETS;
		
		ccboxSearch.gridx = 0;
		ccboxSearch.gridy = 3;
		ccboxSearch.gridwidth = 1;
		ccboxSearch.gridheight = 1;
		ccboxSearch.fill = GridBagConstraints.HORIZONTAL;
		ccboxSearch.insets = STANDARDINSETS;
		
		ctSearch.gridx = 1;
		ctSearch.gridy = 3;
		ctSearch.gridwidth = 1;
		ctSearch.gridheight = 1;
		ctSearch.fill = GridBagConstraints.HORIZONTAL;
		ctSearch.insets = STANDARDINSETS;
		
		cbSearch.gridx = 1;
		cbSearch.gridy = 4;
		cbSearch.gridwidth = 1;
		cbSearch.gridheight = 1;
		cbSearch.fill = GridBagConstraints.HORIZONTAL;
		cbSearch.insets = STANDARDINSETS;

		csVertical.gridx = 2;
		csVertical.gridy = 2;
		csVertical.gridwidth = 1;
		csVertical.gridheight = 3;
		csVertical.fill = GridBagConstraints.VERTICAL;
		csVertical.insets = STANDARDINSETS;
		
		clRegister.gridx = 3;
		clRegister.gridy = 2;
		clRegister.gridwidth = 1;
		clRegister.gridheight = 1;
		clRegister.fill = GridBagConstraints.HORIZONTAL;
		clRegister.insets = STANDARDINSETS;
		
		cbRegister.gridx = 3;
		cbRegister.gridy = 3;
		cbRegister.gridwidth = 1;
		cbRegister.gridheight = 1;
		cbRegister.fill = GridBagConstraints.HORIZONTAL;
		cbRegister.insets = STANDARDINSETS;		

		csHorizontal.gridx = 0;
		csHorizontal.gridy = 5;
		csHorizontal.gridwidth = 5;
		csHorizontal.gridheight = 1;
		csHorizontal.fill = GridBagConstraints.HORIZONTAL;
		csHorizontal.insets = STANDARDINSETS;
		
		clResults.gridx = 0;
		clResults.gridy = 6;
		clResults.gridwidth = 1;
		clResults.gridheight = 1;
		clResults.fill = GridBagConstraints.HORIZONTAL;
		clResults.insets = STANDARDINSETS;
		
		cscrResults.gridx = 0;
		cscrResults.gridy = 7;
		cscrResults.gridwidth = 5;
		cscrResults.gridheight = 1;
		cscrResults.fill = GridBagConstraints.HORIZONTAL;
		cscrResults.fill = GridBagConstraints.VERTICAL;
		cscrResults.insets = STANDARDINSETS;
		
		cbOpen.gridx = 3;
		cbOpen.gridy = 9;
		cbOpen.gridwidth = 1;
		cbOpen.gridheight = 1;
		cbOpen.fill = GridBagConstraints.HORIZONTAL;
		cbOpen.insets = STANDARDINSETS;

		cbImport.gridx = 1;
		cbImport.gridy = 9;
		cbImport.gridwidth = 1;
		cbImport.gridheight = 1;
		cbImport.weighty = 0.7;
		cbImport.anchor = GridBagConstraints.FIRST_LINE_END;
		cbImport.insets = STANDARDINSETS;
		
		cbExport.gridx = 2;
		cbExport.gridy = 9;
		cbExport.gridwidth = 1;
		cbExport.gridheight = 1;
		cbExport.weighty = 0.7;
		cbExport.anchor = GridBagConstraints.FIRST_LINE_END;
		cbExport.insets = STANDARDINSETS;
		
		cbLogout.gridx = 3;
		cbLogout.gridy = 0;
		cbLogout.gridwidth = 1;
		cbLogout.gridheight = 1;
		cbLogout.weighty = 0.7;
		cbLogout.anchor = GridBagConstraints.FIRST_LINE_END;
		cbLogout.insets = STANDARDINSETS;
		
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
		panel.add(bImport, cbImport);
		panel.add(bExport, cbExport);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
	}

	/**
	 * When mouseClicked event occurs, the Dashboard GUI is refreshed.
	 * @param e user clicks mouse
	 */
	public void mouseClicked(MouseEvent e) {
		search();
		draw();
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
	 * Not implemented
	 */
	public void mouseEntered(MouseEvent e) {
		;
	}

	/**
	 * Not implemented
	 */
	public void mouseExited(MouseEvent e) {
		;
	}
			
}
