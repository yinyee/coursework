package person;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

public class Test {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtNationalID;
	private JTextField txtMobileNumber;
	private JTextField txtHomeNumber;
	private JTextField txtWorkNumber;
	private JTextField txtGender;
	private JTextField txtEmailAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Design for LHS
		JPanel panelLHS = new JPanel();
		panelLHS.setBounds(0, 50, 400, 700);
		frame.getContentPane().add(panelLHS);
		panelLHS.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Avenir Next", Font.PLAIN, 12));
		lblFirstName.setBounds(5, 0, 90, 30);
		panelLHS.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(95, 0, 300, 30);
		panelLHS.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Avenir Next", Font.PLAIN, 12));
		lblLastName.setBounds(5, 40, 90, 30);
		panelLHS.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(95, 40, 300, 30);
		panelLHS.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblNationalID = new JLabel("National ID");
		lblNationalID.setFont(new Font("Avenir Next", Font.PLAIN, 12));
		lblNationalID.setBounds(5, 80, 90, 30);
		panelLHS.add(lblNationalID);
		
		txtNationalID = new JTextField();
		txtNationalID.setBounds(95, 80, 300, 30);
		panelLHS.add(txtNationalID);
		txtNationalID.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Avenir Next", Font.PLAIN, 12));
		lblGender.setBounds(5, 120, 90, 30);
		panelLHS.add(lblGender);
		
		txtGender = new JTextField();
		txtGender.setBounds(95, 120, 300, 30);
		panelLHS.add(txtGender);
		txtGender.setColumns(10);
		
		JLabel lblDOB = new JLabel("Date of birth");
		lblDOB.setFont(new Font("Avenir Next", Font.PLAIN, 12));
		lblDOB.setBounds(5, 160, 90, 30);
		panelLHS.add(lblDOB);
		
		JComboBox comboBoxDOBDate = new JComboBox();
		comboBoxDOBDate.setBounds(95, 160, 50, 27);
		panelLHS.add(comboBoxDOBDate);
		
		JComboBox comboBoxDOBMonth = new JComboBox();
		comboBoxDOBMonth.setBounds(150, 160, 150, 27);
		panelLHS.add(comboBoxDOBMonth);
		
		JComboBox comboBoxDOBYear = new JComboBox();
		comboBoxDOBYear.setBounds(305, 160, 90, 27);
		panelLHS.add(comboBoxDOBYear);
		
		// Design for RHS
		JPanel panelRHS = new JPanel();
		panelRHS.setBounds(400, 50, 400, 700);
		frame.getContentPane().add(panelRHS);
		panelRHS.setLayout(null);
		
		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setFont(new Font("Avenir Next", Font.PLAIN, 12));
		lblMobileNumber.setBounds(5, 0, 90, 30);
		panelRHS.add(lblMobileNumber);
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setBounds(95, 0, 130, 30);
		panelRHS.add(txtMobileNumber);
		txtMobileNumber.setColumns(10);
		
		JLabel lblHomeNumber = new JLabel("Home number");
		lblHomeNumber.setFont(new Font("Avenir Next", Font.PLAIN, 12));
		lblHomeNumber.setBounds(5, 40, 90, 30);
		panelRHS.add(lblHomeNumber);
		
		txtHomeNumber = new JTextField();
		txtHomeNumber.setBounds(95, 40, 130, 30);
		panelRHS.add(txtHomeNumber);
		txtHomeNumber.setColumns(10);
		
		JLabel lblWorkNumber = new JLabel("Work number");
		lblWorkNumber.setFont(new Font("Avenir Next", Font.PLAIN, 12));
		lblWorkNumber.setBounds(5, 80, 90, 30);
		panelRHS.add(lblWorkNumber);
		
		txtWorkNumber = new JTextField();
		txtWorkNumber.setBounds(95, 80, 130, 30);
		panelRHS.add(txtWorkNumber);
		txtWorkNumber.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("Email address");
		lblEmailAddress.setFont(new Font("Avenir Next", Font.PLAIN, 12));
		lblEmailAddress.setBounds(5, 120, 90, 30);
		panelRHS.add(lblEmailAddress);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setBounds(95, 120, 130, 30);
		panelRHS.add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
	}
}
