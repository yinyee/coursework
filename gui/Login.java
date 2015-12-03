package gui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
	
	private final static File loginFile = new File("/Users/yinyee/Documents/workspace/Coursework/doc/login.txt");
	private static String username, password;
	private static ButtonListener bListener;
	private static InputListener iListener;
	private final static Insets standardInsets = new Insets(5, 5, 5, 5);
	
	public Login () {
		draw();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}

	/**
	 * The verify() method checks:
	 * 1 - that the username exists in the database
	 * 2 - that the password matches the username provided
	 */
	
	private static void verify(String username, String password) {
		
		/* WORK IN PROGRESS
		 * Check if the file containing usernames and passwords exists.
		 * If does not exist, do not create new.  Instead, throw an error 
		 * and terminate the program.  If username and password combination
		 * is found in the file, call new screen.
		 */
		try {
			BufferedReader reader = new BufferedReader(new FileReader(loginFile));
			StringBuilder str = new StringBuilder();
			String readLine;
			while ((readLine = reader.readLine()) != null) {
				str.append(readLine + "\n");
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * The draw() method contains the code to render the GUI.	
	 */
	
	private static void draw() {
		
		JFrame frame = new JFrame();
		Container panel = frame.getContentPane();
		JLabel lUsername = new JLabel("Username");
		JLabel lPassword = new JLabel("Password");
		JTextField tUsername = new JTextField();
		JTextField tPassword = new JTextField();
		JButton bLogin = new JButton("Log in");
		
		// THESE LISTENERS HAVE NOT BEEN INITIALISED !!!
		// The following section adds listeners to certain components.
		
		bLogin.addActionListener(bListener);
		tUsername.addKeyListener(iListener);
		tUsername.setActionCommand("Username");
		tPassword.addKeyListener(iListener);
		tPassword.setActionCommand("Password");
		
		// The following section specifies the GridBagConsraints for each component.
		
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

	/**
	 * The following classes are helper classes; specifically listener classes.
	 * InputListener reads user input from tUsername and tPassword.
	 * ButtonListener fires the verify() method when bLogin is clicked.
	 */
	
	private class InputListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			switch (e.getComponent().toString()) {
			case "Username" : username = e.toString();
			case "Password" : password = e.toString();
			}
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
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				verify(username, password);
			} catch (Exception loginException) {
				loginException.printStackTrace();
			}
		}
	}
	
}
