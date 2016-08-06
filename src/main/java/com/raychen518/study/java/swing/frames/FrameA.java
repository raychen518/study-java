package com.raychen518.study.java.swing.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * <pre>
 * This class shows how to display a simplest custom frame.
 * 
 * Inheritance Hierarchy
 * - javax.swing.JFrame <extends> java.awt.Frame <extends> java.awt.Window <extends> java.awt.Container.
 * - javax.swing.JPanel <extends> javax.swing.JComponent <extends> java.awt.Container.
 * - java.awt.Container <extends> java.awt.Component <extends> java.lang.Object.
 * </pre>
 */
public class FrameA extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	private static final int DEFAULT_COORDINATE_X = 500;
	private static final int DEFAULT_COORDINATE_Y = 320;

	public FrameA() {
		// The frame is 0x0 size by default.
		// So it is necessary to set proper size for the frame.
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				FrameA frame = new FrameA();

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.setLocation(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y);
				// frame.setBounds(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y,
				// DEFAULT_WIDTH, DEFAULT_HEIGHT);
				// frame.setLocationByPlatform(true);

				// The frame is invisible by default.
				// So after a frame is created,
				// there is a chance to decorate it
				// before making it visible using the statement
				// ".setVisible(true)".
				frame.setVisible(true);
			}

		});
	}

}
