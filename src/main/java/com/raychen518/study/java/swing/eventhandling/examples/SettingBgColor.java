package com.raychen518.study.java.swing.eventhandling.examples;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <pre>
 * This class shows an example that sets different background color for a panel by clicking different buttons.
 * </pre>
 */
public class SettingBgColor {

	private static final String FRAME_TITLE = "Example - Set Different Background Color";
	private static final int FRAME_DEFAULT_WIDTH = 800;
	private static final int FRAME_DEFAULT_HEIGHT = 400;
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

				JPanel mainPanel = new JPanel();

				JButton redButton = new JButton("RED");
				JButton greenButton = new JButton("GREEN");
				JButton blueButton = new JButton("BLUE");

				redButton.addActionListener(new SettingBgColorActionListener(Color.RED, mainPanel));
				greenButton.addActionListener(new SettingBgColorActionListener(Color.GREEN, mainPanel));
				blueButton.addActionListener(new SettingBgColorActionListener(Color.BLUE, mainPanel));

				mainPanel.add(redButton);
				mainPanel.add(greenButton);
				mainPanel.add(blueButton);

				frame.add(mainPanel);

				frame.setVisible(true);
			}

		});
	}

	private static class SettingBgColorActionListener implements ActionListener {

		private Color bgColor = null;
		JComponent container = null;

		public SettingBgColorActionListener(Color bgColor, JComponent container) {
			this.bgColor = bgColor;
			this.container = container;
		}

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			container.setBackground(bgColor);
		}

	}

}
