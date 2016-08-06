package com.raychen518.study.java.swing.gui.examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AccountFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String FRAME_TITLE = "Account Frame";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final int TEXTAREA_ROWS = 8;
	private static final int TEXTAREA_COLUMNS = 20;

	public AccountFrame() {
		// -----------------------------
		// Create the Account Panel
		// -----------------------------
		final JTextField textField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();

		JPanel accountPanel = new JPanel();
		accountPanel.setLayout(new GridLayout(2, 2));
		accountPanel.add(new JLabel("Username: ", SwingConstants.RIGHT));
		accountPanel.add(textField);
		accountPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
		accountPanel.add(passwordField);

		add(accountPanel, BorderLayout.NORTH);

		// -----------------------------
		// Create the Text Area
		// -----------------------------
		final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(textArea);

		add(scrollPane, BorderLayout.CENTER);

		// -----------------------------
		// Create the Insert Panel
		// -----------------------------
		JPanel insertPanel = new JPanel();

		JButton insertButton = new JButton("Insert");
		insertPanel.add(insertButton);

		insertButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				textArea.append("Username: " + textField.getText() + "\nPassword: "
						+ new String(passwordField.getPassword()) + "\n");
			}

		});

		add(insertPanel, BorderLayout.SOUTH);

		pack();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new AccountFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}

		});
	}

}
