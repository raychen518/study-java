package com.raychen518.study.java.swing.lookandfeels.examples;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SettingLookAndFeel {

	private static final String FRAME_TITLE = "Example - Set Look and Feel";
	private static final int FRAME_DEFAULT_WIDTH = 800;
	private static final int FRAME_DEFAULT_HEIGHT = 400;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	public static void main(String[] args) {
		showInstalledLookAndFeels();
		System.out.println();

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setSize(FRAME_DEFAULT_WIDTH, FRAME_DEFAULT_HEIGHT);
				frame.setLocation(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel mainPanel = new JPanel();

				for (UIManager.LookAndFeelInfo lookAndFeel : UIManager.getInstalledLookAndFeels()) {
					mainPanel.add(createLookAndFeelSettingButton(lookAndFeel.getName(), lookAndFeel.getClassName(),
							mainPanel));
				}

				frame.add(mainPanel);

				frame.setVisible(true);
			}

		});
	}

	private static void showInstalledLookAndFeels() {
		UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();

		System.out.println("Count of Installed LookAndFeels: " + installedLookAndFeels.length);
		System.out.println("----------------------------------------------------");
		for (UIManager.LookAndFeelInfo lookAndFeel : installedLookAndFeels) {
			System.out.println("Name: " + lookAndFeel.getName() + " | Class Name: " + lookAndFeel.getClassName());
		}
	}

	private static JButton createLookAndFeelSettingButton(String lookAndFeelName, String lookAndFeelClassName,
			JComponent buttonContainer) {
		JButton button = new JButton(lookAndFeelName);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					UIManager.setLookAndFeel(lookAndFeelClassName);
					SwingUtilities.updateComponentTreeUI(buttonContainer);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			}

		});

		return button;
	}

}
