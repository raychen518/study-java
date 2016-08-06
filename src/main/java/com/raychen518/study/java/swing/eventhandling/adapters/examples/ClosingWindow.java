package com.raychen518.study.java.swing.eventhandling.adapters.examples;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ClosingWindow {

	private static final String FRAME_TITLE = "Example - Closing Window";
	private static final int FRAME_DEFAULT_WIDTH = 400;
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

				JButton closingWindowButton = new JButton("Close Window");
				closingWindowButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						System.exit(0);
					}

				});

				frame.add(closingWindowButton);

				// =========================================
				// Normal Approach
				// Directly implementing the WindowListener interface causes
				// that methods not concerned have to be implemented
				// (using empty blocks) together with those concerned ones.
				// =========================================
				// frame.addWindowListener(new WindowListener() {
				//
				// @Override
				// public void windowOpened(WindowEvent e) {
				// }
				//
				// @Override
				// public void windowIconified(WindowEvent e) {
				// }
				//
				// @Override
				// public void windowDeiconified(WindowEvent e) {
				// }
				//
				// @Override
				// public void windowDeactivated(WindowEvent e) {
				// }
				//
				// @Override
				// public void windowClosing(WindowEvent e) {
				// System.out.println("Do some things before closing window.");
				// }
				//
				// @Override
				// public void windowClosed(WindowEvent e) {
				// }
				//
				// @Override
				// public void windowActivated(WindowEvent e) {
				// }
				//
				// });

				// =========================================
				// Adapter Approach
				// The WindowAdapter class implements all methods of the
				// WindowListener interface, so it becomes enough for the
				// anonymous inner class to extend
				// the WindowAdapter class and only override concerned methods.
				// =========================================
				frame.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosing(WindowEvent e) {
						System.out.println("Do some things before closing window.");
					}

				});

				frame.setVisible(true);
			}

		});
	}

}
