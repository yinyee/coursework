package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.Node;

import reader.Interpreter;

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
	private static File login;
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	private final static JLabel lUsernameError = new JLabel("Username does not exist");
	private final static JLabel lPasswordError = new JLabel("Password is incorrect");
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
	
	/**
	 * The verify() method checks:
	 * 1 - that the username exists in the database
	 * 2 - that the password matches the username provided
	 */
	
	private void verify() {
		 try {
			 login = new File(Login.class.getClassLoader().getResource("data/login.xml").toURI());
		 } catch (URISyntaxException e) {
			 e.printStackTrace();
		 }
		 
		 username = tUsername.getText();
		 password = tPassword.getText();
		 
		Interpreter interpreter = new Interpreter();
		ArrayList<Node> results = interpreter.search(login, "username", username);
		
		if (results != null) {
			for (Node node : results) {
				if(password.equals(node.getLastChild().getTextContent())) {
					Dashboard window = Dashboard.getInstance();
				} else {
					lMessage.setVisible(false);
					lPasswordError.setVisible(true);
				}
			}
		} else {
			lMessage.setVisible(false);
			lUsernameError.setVisible(true);
		}
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	
	private void draw() {
		
		frame = new JFrame("Patient Registry System");
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
		panel.add(lUsernameError, clMessage);
		panel.add(lPasswordError, clMessage);
		panel.add(lUsername, clUsername);
		panel.add(lPassword, clPassword);
		panel.add(tUsername, ctUsername);
		panel.add(tPassword, ctPassword);
		panel.add(bLogin, cbLogin);
		
		lUsernameError.setVisible(false);
		lPasswordError.setVisible(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			verify();
		}
	}
	
}
