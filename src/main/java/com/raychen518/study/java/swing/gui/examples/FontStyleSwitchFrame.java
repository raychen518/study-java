package com.raychen518.study.java.swing.gui.examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FontStyleSwitchFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String FRAME_TITLE = "Font Style Switch Frame";
	private static final int FRAME_DEFAULT_WIDTH = 540;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final String TEXT = "The quick brown fox jumps over the lazy dog.";

	private static final String DEFAULT_FONT_NAME = "Serif";
	private static final int DEFAULT_FONT_STYLES = Font.BOLD;
	private static final int DEFAULT_FONT_SIZE = 24;

	private JLabel textLabel;
	private JCheckBox boldCheckBox;
	private JCheckBox italicCheckBox;

	public FontStyleSwitchFrame() {
		textLabel = new JLabel(TEXT, JLabel.CENTER);
		textLabel.setFont(new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLES, DEFAULT_FONT_SIZE));
		add(textLabel, BorderLayout.CENTER);

		ActionListener actionListener = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				int fontStyles = 0;

				if (boldCheckBox.isSelected()) {
					fontStyles += Font.BOLD;
				}

				if (italicCheckBox.isSelected()) {
					fontStyles += Font.ITALIC;
				}

				textLabel.setFont(new Font(DEFAULT_FONT_NAME, fontStyles, DEFAULT_FONT_SIZE));
			}

		};

		JPanel panel = new JPanel();

		boldCheckBox = new JCheckBox("Bold");
		boldCheckBox.addActionListener(actionListener);
		boldCheckBox.setSelected(true);
		panel.add(boldCheckBox);

		italicCheckBox = new JCheckBox("Italic");
		italicCheckBox.addActionListener(actionListener);
		panel.add(italicCheckBox);

		add(panel, BorderLayout.SOUTH);
		pack();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new FontStyleSwitchFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}

		});
	}

}
