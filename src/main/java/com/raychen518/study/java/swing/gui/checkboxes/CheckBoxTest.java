package com.raychen518.study.java.swing.gui.checkboxes;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBoxTest {

	private static final String FRAME_TITLE = "Test - Check Box";
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

				JCheckBox checkbox1 = new JCheckBox("Check Box 1");
				panel.add(checkbox1);

				JCheckBox checkbox2 = new JCheckBox("Check Box 2", true);
				panel.add(checkbox2);

				JCheckBox checkbox3 = new JCheckBox("Check Box 3", true);
				checkbox3.setEnabled(false);
				panel.add(checkbox3);

				JCheckBox checkbox4 = new JCheckBox("Check Box 4");
				checkbox4.setToolTipText("Check Box 4");
				checkbox4.setForeground(Color.RED);
				checkbox4.setBackground(Color.CYAN);
				panel.add(checkbox4);

				frame.setVisible(true);
			}

		});
	}

}
