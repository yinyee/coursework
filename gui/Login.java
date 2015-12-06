package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import io.Interpreter;

/**  
 * The Login class is based on the Singleton design pattern.
 * 
 * References used for this section include:
 *  >> https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
 *  >> https://moodle.ucl.ac.uk/pluginfile.php/3177853/mod_resource/content/1/GC02-week7-DesignPatterns-2015-16.pdf
 *  >> http://stackoverflow.com/questions/2850674/where-to-put-a-textfile-i-want-to-use-in-eclipse
 *   */

public class Login {
	
	private static Login instance = null;
	private final static String file = "data/login.xml";
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	private String username, password;
	
	private JFrame frame;
	private JLabel lMessage, lUsername, lPassword;
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
	
	
	private void login() {		 
		username = tUsername.getText();
		password = tPassword.getText(); 
		Interpreter interpreter = new Interpreter();
		lMessage.setText(interpreter.verify(file, username, password, this.frame));
		lMessage.validate();
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	
	private void draw() {
		
		frame = new JFrame("Patient Registry System");
		frame.setMinimumSize(new Dimension(300, 300));
		Container panel = frame.getContentPane();
		lMessage = new JLabel("Please log in to continue:");
		lUsername = new JLabel("Username");
		lPassword = new JLabel("Password");
		tUsername = new JTextField();
		tPassword = new JTextField();
		bLogin = new JButton("Log in");
		bListener = new ButtonListener();
		bLogin.addActionListener(bListener);
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints clMessage = new GridBagConstraints();
		GridBagConstraints clUsername = new GridBagConstraints();
		GridBagConstraints clPassword = new GridBagConstraints();
		GridBagConstraints ctUsername = new GridBagConstraints();
		GridBagConstraints ctPassword = new GridBagConstraints();
		GridBagConstraints cbLogin = new GridBagConstraints();

		clMessage.gridx = 0;
		clMessage.gridy = 0;
		clMessage.gridwidth = 2;
		clMessage.gridheight = 1;
		clMessage.fill = GridBagConstraints.HORIZONTAL;
		clMessage.insets = standardInsets;

		clUsername.gridx = 0;
		clUsername.gridy = 1;
		clUsername.gridwidth = 1;
		clUsername.gridheight = 1;
		clUsername.fill = GridBagConstraints.HORIZONTAL;
		clUsername.insets = standardInsets;
		
		clPassword.gridx = 0;
		clPassword.gridy = 2;
		clPassword.gridwidth = 1;
		clPassword.gridheight = 1;
		clPassword.fill = GridBagConstraints.HORIZONTAL;
		clPassword.insets = standardInsets;
		
		ctUsername.gridx = 1;
		ctUsername.gridy = 1;
		ctUsername.gridwidth = 1;
		ctUsername.gridheight = 1;
		ctUsername.fill = GridBagConstraints.HORIZONTAL;
		ctUsername.insets = standardInsets;
		
		ctPassword.gridx = 1;
		ctPassword.gridy = 2;
		ctPassword.gridwidth = 1;
		ctPassword.gridheight = 1;
		ctPassword.fill = GridBagConstraints.HORIZONTAL;
		ctPassword.insets = standardInsets;
		
		cbLogin.gridx = 1;
		cbLogin.gridy = 3;
		cbLogin.gridwidth = 1;
		cbLogin.gridheight = 1;
		cbLogin.fill = GridBagConstraints.HORIZONTAL;
		cbLogin.insets = standardInsets;
		
		panel.add(lMessage, clMessage);
		panel.add(lUsername, clUsername);
		panel.add(lPassword, clPassword);
		panel.add(tUsername, ctUsername);
		panel.add(tPassword, ctPassword);
		panel.add(bLogin, cbLogin);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			login();
		}
	}
	
}
