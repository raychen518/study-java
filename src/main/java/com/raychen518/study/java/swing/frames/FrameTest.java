package com.raychen518.study.java.swing.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * <pre>
 * This class shows how to display a simplest frame.
 * </pre>
 */
public class FrameTest {

	private static final String FRAME_TITLE = "Test - Frame";
	private static final int FRAME_DEFAULT_WIDTH = 450;
	private static final int FRAME_DEFAULT_HEIGHT = 300;
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
				frame.setVisible(true);

			}

		});
	}

}
