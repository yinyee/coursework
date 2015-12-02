package gui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * The Registration screen triggers when the "Register" button
 * in the Dashboard is clicked.
 *  
 * @author yinyee
 *
 */

public class Registration {

	
	
	
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
		
		
		
		
		
		
		
	}
	
	
}
