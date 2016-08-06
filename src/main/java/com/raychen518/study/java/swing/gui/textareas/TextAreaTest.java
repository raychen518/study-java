package com.raychen518.study.java.swing.gui.textareas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaTest {

	private static final String FRAME_TITLE = "Test - Text Area";
	private static final int FRAME_DEFAULT_WIDTH = 540;
	private static final int FRAME_DEFAULT_HEIGHT = 400;
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

				JTextArea textArea1 = new JTextArea("Text Area 1");
				panel.add(textArea1);

				JTextArea textArea2 = new JTextArea("Text Area 2\nxxx\nxxx", 4, 5);
				panel.add(textArea2);

				JTextArea textArea3 = new JTextArea("Text Area 3\nxxx\nxxx", 4, 5);
				textArea3.setEditable(false);
				panel.add(textArea3);

				JTextArea textArea4 = new JTextArea("Text Area 4\nxxx\nxxx", 4, 5);
				textArea4.setEnabled(false);
				panel.add(textArea4);

				JTextArea textArea5 = new JTextArea("Text Area 5\nxxx\nxxx", 4, 5);
				textArea5.setForeground(Color.RED);
				textArea5.setBackground(Color.CYAN);
				panel.add(textArea5);

				JTextArea textArea6 = new JTextArea(
						"Text Area 6 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.",
						2, 4);
				panel.add(textArea6);

				JTextArea textArea7 = new JTextArea(
						"Text Area 7 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.", 2, 4);
				textArea7.setLineWrap(true);
				panel.add(textArea7);

				JTextArea textArea8 = new JTextArea(
						"Text Area 8 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.", 3, 5);
				JScrollPane scrollPaneForTextArea8 = new JScrollPane(textArea8);
				panel.add(scrollPaneForTextArea8);

				frame.setVisible(true);
			}

		});
	}

}
