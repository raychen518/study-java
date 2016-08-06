package com.raychen518.study.java.swing.gui.radiobuttons;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonTest {

	private static final String FRAME_TITLE = "Test - Radio Button";
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

				JRadioButton radioButton1 = new JRadioButton("Radio Button 1");
				panel.add(radioButton1);

				JRadioButton radioButton2 = new JRadioButton("Radio Button 2", true);
				panel.add(radioButton2);

				JRadioButton radioButton3 = new JRadioButton("Radio Button 3", true);
				radioButton3.setEnabled(false);
				panel.add(radioButton3);

				JRadioButton radioButton4 = new JRadioButton();
				radioButton4.setText("Radio Button 4");
				radioButton4.setForeground(Color.RED);
				radioButton4.setBackground(Color.CYAN);
				radioButton4.setToolTipText("Radio Button 4");
				panel.add(radioButton4);

				ButtonGroup buttonGroup = new ButtonGroup();

				JRadioButton radioButton5 = new JRadioButton("Radio Button 5");
				buttonGroup.add(radioButton5);
				panel.add(radioButton5);

				JRadioButton radioButton6 = new JRadioButton("Radio Button 6", true);
				buttonGroup.add(radioButton6);
				panel.add(radioButton6);

				JRadioButton radioButton7 = new JRadioButton("Radio Button 7");
				buttonGroup.add(radioButton7);
				panel.add(radioButton7);

				frame.setVisible(true);
			}

		});
	}

}
