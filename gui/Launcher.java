package gui;

import java.awt.EventQueue;

/**
 * The Launcher class contains the main() method for the application.
 * @author yinyee
 *
 */
public class Launcher {
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = Login.getInstance();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
