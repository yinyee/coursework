package gui;

import java.awt.EventQueue;

public class Launcher {
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = Login.getInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
