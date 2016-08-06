package com.raychen518.study.java.swing.gui.dialogs.customdialogs.examples;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UserInfoDialogTest {

	private static final String FRAME_TITLE = "User Info Dialog Test";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final String MENU_NAME_FILE = "File";
	private static final String MENU_ITEM_NAME_CONNECT = "Connect";
	private static final String MENU_ITEM_NAME_EXIT = "Exit";

	private static UserInfoDialogContainer userInfoDialogContainer;
	private static JTextArea userInfoBoard;

	private static class ConnectAction implements ActionListener {

		Component component;

		public ConnectAction(Component component) {
			this.component = component;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if (userInfoDialogContainer == null) {
				userInfoDialogContainer = new UserInfoDialogContainer();
			}

			userInfoDialogContainer.setUser(new User("Ray Chen", "a1b2c3".toCharArray()));

			if (userInfoDialogContainer.showDialog(component, "Connect")) {
				User user = userInfoDialogContainer.getUser();
				userInfoBoard.append("User Name: " + user.getName() + ", Password: " + new String(user.getPassword()));
			}
		}

	}

	private static class UserInfoDialogContainer extends JPanel {

		private static final long serialVersionUID = 1L;

		private JTextField userNameField;
		private JPasswordField passwordField;
		private JButton okButton;
		private JDialog dialog;
		private boolean ok;

		public UserInfoDialogContainer() {
			setLayout(new BorderLayout());

			JPanel userInfoPanel = new JPanel();
			userInfoPanel.setLayout(new GridLayout(2, 2));

			userInfoPanel.add(new JLabel("User Name:"));
			userNameField = new JTextField("");
			userInfoPanel.add(userNameField);

			userInfoPanel.add(new JLabel("Password:"));
			passwordField = new JPasswordField("");
			userInfoPanel.add(passwordField);

			add(userInfoPanel, BorderLayout.CENTER);

			okButton = new JButton("Ok");
			okButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					ok = true;
					dialog.setVisible(false);
				}

			});

			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					dialog.setVisible(false);
				}

			});

			JPanel buttonsPanel = new JPanel();
			buttonsPanel.add(okButton);
			buttonsPanel.add(cancelButton);
			add(buttonsPanel, BorderLayout.SOUTH);
		}

		public User getUser() {
			return new User(userNameField.getText(), passwordField.getPassword());
		}

		public void setUser(User user) {
			userNameField.setText(user.getName());
			passwordField.setText(new String(user.getPassword()));
		}

		public boolean showDialog(Component dialogParent, String dialogTitle) {
			ok = false;

			Frame owner = null;
			if (dialogParent instanceof Frame) {
				owner = (Frame) dialogParent;
			} else {
				owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, dialogParent);
			}

			if (dialog == null || dialog.getOwner() != owner) {
				dialog = new JDialog(owner, true);
				dialog.add(UserInfoDialogContainer.this);
				dialog.getRootPane().setDefaultButton(okButton);
				dialog.pack();
			}

			dialog.setTitle(dialogTitle);
			dialog.setVisible(true);

			return ok;
		}

	}

	private static class User {

		private String name;
		private char[] password;

		public User(String name, char[] password) {
			this.name = name;
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public char[] getPassword() {
			return password;
		}

	}

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

				JMenuItem connectMenuItem = new JMenuItem(MENU_ITEM_NAME_CONNECT);
				connectMenuItem.addActionListener(new ConnectAction(frame));
				fileMenu.add(connectMenuItem);

				JMenuItem exitMenuItem = new JMenuItem(MENU_ITEM_NAME_EXIT);
				exitMenuItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						System.exit(0);
					}

				});
				fileMenu.add(exitMenuItem);

				userInfoBoard = new JTextArea();
				frame.add(new JScrollPane(userInfoBoard), BorderLayout.CENTER);

				frame.setVisible(true);
			}

		});
	}

}
