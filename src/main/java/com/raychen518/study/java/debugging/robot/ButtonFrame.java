package com.raychen518.study.java.debugging.robot;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {

	private static final long serialVersionUID = 5237062639125775058L;

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	private JPanel buttonPanel;

	public ButtonFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		JButton buttonRed = new JButton("Red");
		JButton buttonGreen = new JButton("Green");
		JButton buttonBlue = new JButton("Blue");

		buttonRed.addActionListener(new ButtonAction(Color.RED));
		buttonGreen.addActionListener(new ButtonAction(Color.GREEN));
		buttonBlue.addActionListener(new ButtonAction(Color.BLUE));

		buttonPanel = new JPanel();
		buttonPanel.add(buttonRed);
		buttonPanel.add(buttonGreen);
		buttonPanel.add(buttonBlue);

		add(buttonPanel);
	}

	private class ButtonAction implements ActionListener {

		private Color backgroundColor;

		public ButtonAction(Color backgroundColor) {
			this.backgroundColor = backgroundColor;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			buttonPanel.setBackground(backgroundColor);
		}

	}
}