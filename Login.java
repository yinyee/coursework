import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Login extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JLabel lblUsername, lblPassword;
	private JTextField txtUsername, txtPassword;
	private JButton btnLogin;
	private String username, password;
	
	public static void main (String[] args)  {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Login window = new Login();
				window.setVisible(true);
			}
		});
			
	}
	
	public Login() {
		
		panel = new JPanel();
		panel.setBounds(0, 0, 400, 400);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(0, 2, 30, 20));
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(0, 0, 150, 30);
		panel.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(200, 0, 150, 30);
		panel.add(txtUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(0, 50, 150, 30);
		panel.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(200, 50, 150, 30);
		panel.add(txtPassword);
		
		btnLogin = new JButton("Log in");
		btnLogin.setBounds(200, 100, 100, 30);
		btnLogin.addActionListener(this);
		panel.add(btnLogin);
		
		this.setBounds(0, 0, 800, 600);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		username = txtUsername.getText();
		password = txtPassword.getText();
		
		// check username and password combination
	}
	
	
	
	
	

}
