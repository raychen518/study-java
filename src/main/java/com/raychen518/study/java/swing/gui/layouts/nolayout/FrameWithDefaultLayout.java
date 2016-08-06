package com.raychen518.study.java.swing.gui.layouts.nolayout;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameWithDefaultLayout {

	private static final String FRAME_TITLE = "Frame with Default Layout";
	private static final int FRAME_DEFAULT_WIDTH = 480;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 300;
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

				JButton buttonOk = new JButton("OK");
				buttonOk.setBounds(30, 40, 80, 50);
				frame.add(buttonOk);

				System.out.println("Current Layout: " + frame.getLayout().toString());

				frame.setVisible(true);
			}

		});
	}

}