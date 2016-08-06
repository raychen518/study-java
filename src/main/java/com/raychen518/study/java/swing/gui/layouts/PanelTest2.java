package com.raychen518.study.java.swing.gui.layouts;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelTest2 {

	private static final String FRAME_TITLE = "Panel Using Grid Layout";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final String BUTTON_NAME_PREFIX = "Button ";
	private static final int BUTTON_COUNT = 9;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setSize(FRAME_DEFAULT_WIDTH, FRAME_DEFAULT_HEIGHT);
				frame.setLocation(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(3, 3));

				for (int i = 0; i < BUTTON_COUNT; i++) {
					panel.add(new JButton(BUTTON_NAME_PREFIX + (i + 1)));
				}

				frame.add(panel);
				frame.setVisible(true);
			}

		});
	}

}
