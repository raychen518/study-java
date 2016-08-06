package com.raychen518.study.java.swing.gui.menus;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MenuTest2 {

	private static final String FRAME_TITLE = "Test - Menu - 2";
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
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				frame.add(panel);

				// -----------------------------------------
				// Popup Menu
				// -----------------------------------------
				JPopupMenu popupMenu = new JPopupMenu();
				panel.setComponentPopupMenu(popupMenu);

				// -----------------------------------------
				// Menu Items Cut, Copy and Paste
				// -----------------------------------------
				popupMenu.add(createMenuItem("Cut"));
				popupMenu.add(createMenuItem("Copy"));
				popupMenu.add(createMenuItem("Paste"));

				frame.setVisible(true);
			}

		});
	}

	private static JMenuItem createMenuItem(String name) {
		JMenuItem menuItem = new JMenuItem(name);

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Processing the Action Event of the Menu Item - " + name);
			}

		});

		return menuItem;
	}

}
