package com.raychen518.study.java.swing.gui.menus;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuTest1 {

	private static final String FRAME_TITLE = "Test - Menu - 1";
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

				// -----------------------------------------
				// Menu Bar
				// -----------------------------------------
				JMenuBar menuBar = new JMenuBar();
				frame.setJMenuBar(menuBar);

				// -----------------------------------------
				// Menu - File
				// -----------------------------------------
				JMenu menuFile = new JMenu("File");
				menuBar.add(menuFile);

				// -----------------------------------------
				// Menu Item - File > New
				// -----------------------------------------
				JMenuItem menuItemNew = new JMenuItem("New");
				menuItemNew.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						System.out.println("Processing the Action Event of the Menu Item - New");
					}

				});
				menuFile.add(menuItemNew);

				// -----------------------------------------
				// Menu Item - File > Open
				// -----------------------------------------
				JMenuItem menuItemOpen = createMenuItem("Open");
				menuItemOpen.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
				menuFile.add(menuItemOpen);
				menuFile.addSeparator();

				// -----------------------------------------
				// Menu Item - File > Save & Save As
				// -----------------------------------------
				JMenuItem menuItemSave = createMenuItem("Save");
				JMenuItem menuItemSaveAs = createMenuItem("Save As");
				menuFile.add(menuItemSave);
				menuFile.add(menuItemSaveAs);
				menuFile.addSeparator();

				// -----------------------------------------
				// Menu Item - File > Recent Files
				// -----------------------------------------
				JMenu submenuRecentFiles = new JMenu("Recent Files");
				submenuRecentFiles.add(new JMenuItem("File 1"));
				submenuRecentFiles.add(new JMenuItem("File 2"));
				submenuRecentFiles.add(new JMenuItem("File 3"));
				menuFile.add(submenuRecentFiles);

				menuFile.addSeparator();

				// -----------------------------------------
				// Menu Item - Exit
				// -----------------------------------------
				JMenuItem menuItemExit = new JMenuItem("Exit");
				menuItemExit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						System.out.println("Processing the Action Event of the Menu Item - Exit");
						System.exit(0);
					}

				});
				menuFile.add(menuItemExit);

				// -----------------------------------------
				// Menu - Edit
				// -----------------------------------------
				JMenu menuEdit = new JMenu("Edit");
				menuBar.add(menuEdit);

				// -----------------------------------------
				// Menu Item - Edit > Cut
				// -----------------------------------------
				menuEdit.add(createMenuItem("Cut"));

				// -----------------------------------------
				// Menu Item - Edit > Copy
				// -----------------------------------------
				Action copyAction = new AbstractAction("Copy") {

					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent event) {
						System.out.println("Processing the Action Event of the Menu Item - Copy");
					}

				};

				menuEdit.add(new JMenuItem(copyAction));

				frame.add(new JButton(copyAction), BorderLayout.SOUTH);

				// -----------------------------------------
				// Menu Item - Edit > Paste
				// -----------------------------------------
				menuEdit.add(createMenuItem("Paste"));
				menuEdit.addSeparator();

				// -----------------------------------------
				// Menu Item - Edit > Options
				// -----------------------------------------
				JMenu submenuOptions = new JMenu("Options");
				menuEdit.add(submenuOptions);

				submenuOptions.add(new JCheckBoxMenuItem("Automatic Backup", true));

				JMenuItem menuItemReadOnly = new JCheckBoxMenuItem("Read Only");
				submenuOptions.add(menuItemReadOnly);

				menuFile.addMenuListener(new MenuListener() {

					@Override
					public void menuSelected(MenuEvent event) {
						menuItemSave.setEnabled(!menuItemReadOnly.isSelected());
						menuItemSaveAs.setEnabled(!menuItemReadOnly.isSelected());
					}

					@Override
					public void menuDeselected(MenuEvent event) {
					}

					@Override
					public void menuCanceled(MenuEvent event) {
					}
				});

				submenuOptions.addSeparator();

				JRadioButtonMenuItem menuItemEncodingAnsi = new JRadioButtonMenuItem("ANSI", true);
				JRadioButtonMenuItem menuItemEncodingUTF8 = new JRadioButtonMenuItem("UTF-8");
				ButtonGroup buttonGroupEncoding = new ButtonGroup();
				buttonGroupEncoding.add(menuItemEncodingAnsi);
				buttonGroupEncoding.add(menuItemEncodingUTF8);
				submenuOptions.add(menuItemEncodingAnsi);
				submenuOptions.add(menuItemEncodingUTF8);

				frame.setVisible(true);

				// -----------------------------------------
				// Menu - Help
				// -----------------------------------------
				JMenu menuHelp = new JMenu("Help");
				menuHelp.setMnemonic('H');
				menuBar.add(menuHelp);

				// -----------------------------------------
				// Menu Item - Help > About
				// -----------------------------------------
				menuHelp.add(createMenuItem("About", 'A'));
				menuHelp.add(createMenuItem("Check for Updates", 'U'));

				JMenuItem menuItemWebsite = new JMenuItem("Website");
				menuItemWebsite.setDisplayedMnemonicIndex(3);
				menuItemWebsite.setEnabled(false);
				menuHelp.add(menuItemWebsite);

				Action actionHelpContents = new AbstractAction("Help Contents") {

					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Processing the Action Event of the Menu Item - Help Contents");
					}

				};
				actionHelpContents.putValue(Action.MNEMONIC_KEY, Integer.valueOf('C'));
				menuHelp.add(actionHelpContents);
			}

		});
	}

	private static JMenuItem createMenuItem(String name) {
		return createMenuItem(name, null);
	}

	private static JMenuItem createMenuItem(String name, Character mnemonic) {
		JMenuItem menuItem;

		if (mnemonic == null) {
			menuItem = new JMenuItem(name);
		} else {
			menuItem = new JMenuItem(name, mnemonic);
		}

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Processing the Action Event of the Menu Item - " + name);
			}

		});

		return menuItem;
	}

}
