package com.raychen518.study.java.swing.gui.examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FontSizeSwitchFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String FRAME_TITLE = "Font Size Switch Frame";
	private static final int FRAME_DEFAULT_WIDTH = 720;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final String TEXT = "The quick brown fox jumps over the lazy dog.";

	private static final String DEFAULT_FONT_NAME = "Serif";
	private static final int DEFAULT_FONT_STYLES = Font.PLAIN;
	private static final int DEFAULT_FONT_SIZE = 24;

	private JLabel textLabel;
	private ButtonGroup radioButtonGroup;
	private JPanel panel;

	public FontSizeSwitchFrame() {
		textLabel = new JLabel(TEXT, JLabel.CENTER);
		textLabel.setFont(new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLES, DEFAULT_FONT_SIZE));
		add(textLabel, BorderLayout.CENTER);

		panel = new JPanel();
		radioButtonGroup = new ButtonGroup();

		addRadioButton("Very Small", 12);
		addRadioButton("Small", 18);
		addRadioButton("Medium", 24);
		addRadioButton("Large", 30);
		addRadioButton("Very Large", 36);

		add(panel, BorderLayout.SOUTH);
		pack();
	}

	public void addRadioButton(String radioButtonName, final int fontSize) {
		boolean radioButtonSelected = (fontSize == DEFAULT_FONT_SIZE);
		JRadioButton radioButton = new JRadioButton(radioButtonName, radioButtonSelected);
		radioButtonGroup.add(radioButton);
		panel.add(radioButton);

		ActionListener actionListener = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				textLabel.setFont(new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLES, fontSize));
			}

		};

		radioButton.addActionListener(actionListener);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new FontSizeSwitchFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}

		});
	}

}
