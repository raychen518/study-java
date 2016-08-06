package com.raychen518.study.java.swing.gui.passwordfields;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswordFieldTest {

	private static final String FRAME_TITLE = "Test - Password Field";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				frame.add(panel);

				JPasswordField passwordField1 = new JPasswordField("Password Field 1");
				panel.add(passwordField1);

				JPasswordField passwordField2 = new JPasswordField("Password Field 2", 9);
				passwordField2.setEditable(false);
				panel.add(passwordField2);

				JPasswordField passwordField3 = new JPasswordField(5);
				passwordField3.setText("Password Field 3");
				passwordField3.setEnabled(false);
				panel.add(passwordField3);

				JPasswordField passwordField4 = new JPasswordField("Password Field 4");
				passwordField4.setForeground(Color.RED);
				passwordField4.setBackground(Color.CYAN);
				panel.add(passwordField4);

				frame.setVisible(true);
			}

		});
	}

}
