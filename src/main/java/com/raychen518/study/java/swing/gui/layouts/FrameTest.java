package com.raychen518.study.java.swing.gui.layouts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameTest {

	private static final String FRAME_TITLE = "Frame Using Border Layout (By Default)";
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
				frame.setSize(FRAME_DEFAULT_WIDTH, FRAME_DEFAULT_HEIGHT);
				frame.setLocation(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// The abbreviated form of the following statement is:
				// frame.add(new JButton("Center"));
				frame.add(new JButton("Center"), BorderLayout.CENTER);
				frame.add(new JButton("East"), BorderLayout.EAST);
				frame.add(new JButton("South"), BorderLayout.SOUTH);
				frame.add(new JButton("West"), BorderLayout.WEST);
				frame.add(new JButton("North"), BorderLayout.NORTH);

				frame.setVisible(true);
			}

		});
	}

}
