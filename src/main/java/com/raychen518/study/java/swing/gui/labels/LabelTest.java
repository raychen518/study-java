package com.raychen518.study.java.swing.gui.labels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelTest {

	private static final String FRAME_TITLE = "Test - Label";
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

				JLabel label1 = new JLabel("Label 1");
				panel.add(label1);

				JLabel label2 = new JLabel("Label 2", JLabel.RIGHT);
				label2.setEnabled(false);
				panel.add(label2);

				JLabel label3 = new JLabel(
						"<html><u><span style=\"color: red; font-family: Times New Roman;\">Label 3</span></u></html>");
				panel.add(label3);

				frame.setVisible(true);
			}

		});
	}

}
