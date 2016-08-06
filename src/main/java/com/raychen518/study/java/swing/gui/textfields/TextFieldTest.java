package com.raychen518.study.java.swing.gui.textfields;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldTest {

	private static final String FRAME_TITLE = "Test - Text Field";
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

				JTextField textField1 = new JTextField("Text Field 1");
				panel.add(textField1);

				JTextField textField2 = new JTextField("Text Field 2", 7);
				textField2.setEditable(false);
				panel.add(textField2);

				JTextField textField3 = new JTextField();
				textField3.setText("Text Field 3");
				System.out.println("textField3.getColumns(): " + textField3.getColumns());
				textField3.setEnabled(false);
				panel.add(textField3);

				JTextField textField4 = new JTextField(15);
				textField4.setText("Text Field 4");
				textField4.setFont(new Font("Courier New", Font.ITALIC, 12));
				textField4.setForeground(Color.RED);
				textField4.setBackground(Color.CYAN);
				panel.add(textField4);

				JTextField textField5 = new JTextField();
				textField5.setText("   Text Field 5   ");
				System.out.println("textField5.getText(): [" + textField5.getText() + "]");
				System.out.println("textField5.getText().trim(): [" + textField5.getText().trim() + "]");
				panel.add(textField5);

				frame.setVisible(true);
			}

		});
	}

}
