package com.raychen518.study.java.swing.gui.dialogs.customdialogs.examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.raychen518.study.java._util.Images;

public class AboutDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private static final String TITLE = "About";
	private static final String BUTTON_OK_TEXT = "OK";

	public AboutDialog(JFrame owner) {
		super(owner, TITLE, true);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JLabel label = new JLabel(new ImageIcon(Images.createImage()));
		panel.add(label);

		JButton buttonOk = new JButton(BUTTON_OK_TEXT);
		buttonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}

		});
		panel.add(buttonOk);

		pack();
	}

	private static final String FRAME_TITLE = "About Dialog";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final String MENU_NAME_FILE = "File";
	private static final String MENU_ITEM_NAME_ABOUT = "About";
	private static final String MENU_ITEM_NAME_EXIT = "Exit";

	private static AboutDialog aboutDialog = null;

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

				JMenuBar menuBar = new JMenuBar();
				frame.setJMenuBar(menuBar);

				JMenu fileMenu = new JMenu(MENU_NAME_FILE);
				menuBar.add(fileMenu);

				JMenuItem aboutMenuItem = new JMenuItem(MENU_ITEM_NAME_ABOUT);

				aboutMenuItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						if (aboutDialog == null) {
							aboutDialog = new AboutDialog(frame);
						}
						aboutDialog.setVisible(true);
					}

				});
				fileMenu.add(aboutMenuItem);

				JMenuItem exitMenuItem = new JMenuItem(MENU_ITEM_NAME_EXIT);
				exitMenuItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						System.exit(0);
					}

				});
				fileMenu.add(exitMenuItem);

				frame.setVisible(true);
			}

		});
	}

}
