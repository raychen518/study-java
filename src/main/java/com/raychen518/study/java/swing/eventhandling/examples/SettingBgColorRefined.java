package com.raychen518.study.java.swing.eventhandling.examples;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SettingBgColorRefined {

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

				mainPanel.add(createBgColorSettingButton("RED", Color.RED, mainPanel));
				mainPanel.add(createBgColorSettingButton("GREEN", Color.GREEN, mainPanel));
				mainPanel.add(createBgColorSettingButton("BLUE", Color.BLUE, mainPanel));

				frame.add(mainPanel);

				frame.setVisible(true);
			}

		});
	}

	private static JButton createBgColorSettingButton(String buttonName, Color bgColorToSet,
			JComponent buttonContainer) {
		JButton button = new JButton(buttonName);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				buttonContainer.setBackground(bgColorToSet);
			}

		});

		return button;
	}

}
