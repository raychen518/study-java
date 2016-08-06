package com.raychen518.study.java.swing.gui.examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FontNameSwitchFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String FRAME_TITLE = "Font Name Switch Frame";
	private static final int FRAME_DEFAULT_WIDTH = 720;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final String TEXT = "The quick brown fox jumps over the lazy dog.";

	private static final String DEFAULT_FONT_NAME = "Serif";
	private static final int DEFAULT_FONT_STYLES = Font.PLAIN;
	private static final int DEFAULT_FONT_SIZE = 24;

	private JLabel textLabel;
	private JPanel panel;

	public FontNameSwitchFrame() {
		textLabel = new JLabel(TEXT, JLabel.CENTER);
		textLabel.setFont(new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLES, DEFAULT_FONT_SIZE));
		add(textLabel, BorderLayout.CENTER);

		panel = new JPanel();

		JComboBox<String> fontList = new JComboBox<>();
		fontList.addItem("Arial");
		fontList.addItem("Courier New");
		fontList.addItem("Microsoft Sans Serif");
		fontList.addItem("Times New Roman");
		fontList.addItem("Verdana");

		fontList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				textLabel.setFont(new Font(fontList.getItemAt(fontList.getSelectedIndex()), DEFAULT_FONT_STYLES,
						DEFAULT_FONT_SIZE));
			}

		});

		panel.add(fontList);

		add(panel, BorderLayout.SOUTH);
		pack();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new FontNameSwitchFrame();
				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}

		});
	}

}
