package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**  
 * The Login class is based on the Singleton design pattern.
 * 
 * References used for this section include:
 *  >> https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
 *  >> https://moodle.ucl.ac.uk/pluginfile.php/3177853/mod_resource/content/1/GC02-week7-DesignPatterns-2015-16.pdf
 *   */

public class Login {
	
	private static Login instance = null;
	
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	private String username, password;
	
	private JFrame frame;
	private JLabel lUsername, lPassword;
	private JTextField tUsername, tPassword;
	private JButton bLogin;
	private ButtonListener bListener;

	private Login () {
		draw();
	}

	/**
	 * The getInstance() method enforces the Singleton design pattern.
	 */
	public static Login getInstance() {
		if (instance == null) {
			instance = new Login();
		}
		return instance;
	}
	
	/**
	 * The verify() method checks:
	 * 1 - that the username exists in the database (WIP)
	 * 2 - that the password matches the username provided
	 */
	
	private Dashboard verify(String username, String password) {
//		if (tUsername.getText() == username && tPassword.getText() == password) {
			return Dashboard.getInstance();
//		} else {
//			return null;
//		}
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	
	private void draw() {
		
		frame = new JFrame("Patient Registry System -- Please log in to continue");
		Container panel = frame.getContentPane();
		lUsername = new JLabel("Username");
		lPassword = new JLabel("Password");
		tUsername = new JTextField();
		tPassword = new JTextField();
		bLogin = new JButton("Log in");
		bListener = new ButtonListener();
		bLogin.addActionListener(bListener);
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints clUsername = new GridBagConstraints();
		GridBagConstraints clPassword = new GridBagConstraints();
		GridBagConstraints ctUsername = new GridBagConstraints();
		GridBagConstraints ctPassword = new GridBagConstraints();
		GridBagConstraints cbLogin = new GridBagConstraints();
		
		clUsername.gridx = 1;
		clUsername.gridy = 1;
		clUsername.gridwidth = 2;
		clUsername.gridheight = 1;
		clUsername.fill = GridBagConstraints.HORIZONTAL;
		clUsername.insets = standardInsets;
		
		clPassword.gridx = 1;
		clPassword.gridy = 4;
		clPassword.gridwidth = 2;
		clPassword.gridheight = 1;
		clPassword.fill = GridBagConstraints.HORIZONTAL;
		clPassword.insets = standardInsets;
		
		ctUsername.gridx = 3;
		ctUsername.gridy = 1;
		ctUsername.gridwidth = 2;
		ctUsername.gridheight = 1;
		ctUsername.fill = GridBagConstraints.HORIZONTAL;
		ctUsername.insets = standardInsets;
		
		ctPassword.gridx = 3;
		ctPassword.gridy = 4;
		ctPassword.gridwidth = 2;
		ctPassword.gridheight = 1;
		ctPassword.fill = GridBagConstraints.HORIZONTAL;
		ctPassword.insets = standardInsets;
		
		cbLogin.gridx = 5;
		cbLogin.gridy = 5;
		cbLogin.gridwidth = 1;
		cbLogin.gridheight = 1;
		cbLogin.fill = GridBagConstraints.HORIZONTAL;
		cbLogin.insets = standardInsets;
		
		panel.add(lUsername, clUsername);
		panel.add(lPassword, clPassword);
		panel.add(tUsername, ctUsername);
		panel.add(tPassword, ctPassword);
		panel.add(bLogin, cbLogin);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			verify(username, password);
		}
	}
	
}
