package com.raychen518.study.java.swing.gui.toolbars;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBarTest {

	private static final String FRAME_TITLE = "Test - Tool Bar";
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

				JToolBar toolBarNorth = new JToolBar();
				frame.add(toolBarNorth, BorderLayout.NORTH);

				JButton buttonN1 = new JButton("Button N1");
				buttonN1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						System.out.println("Executing the Action for the Tool Bar Button - Button N1");
					}

				});
				toolBarNorth.add(buttonN1);

				Action buttonN2Action = new AbstractAction("Button N2") {

					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent event) {
						System.out.println("Executing the Action for the Tool Bar Button - Button N2");
					}

				};
				buttonN2Action.putValue(Action.SHORT_DESCRIPTION, "This is the button N2.");
				toolBarNorth.add(buttonN2Action);
				toolBarNorth.addSeparator();

				JButton buttonN3 = createToolBarButton("Button N3");
				buttonN3.setToolTipText("This is the button N3.");
				toolBarNorth.add(buttonN3);

				JButton buttonN4 = createToolBarButton("Button N4");
				buttonN4.setEnabled(false);
				toolBarNorth.add(buttonN4);

				JToolBar toolBarSouth = new JToolBar("Tool Bar - South");
				toolBarSouth.add(createToolBarButton("Button S1"));
				toolBarSouth.add(new JComboBox<String>(new String[] { "Item 1", "Item 2", "Item 3" }));
				toolBarSouth.add(new JCheckBox("Some Option"));
				frame.add(toolBarSouth, BorderLayout.SOUTH);

				JToolBar toolBarWest = new JToolBar("Tool Bar - West", SwingConstants.VERTICAL);
				toolBarWest.add(createToolBarButton("Button W1"));
				toolBarWest.add(createToolBarButton("Button W2"));
				frame.add(toolBarWest, BorderLayout.WEST);

				frame.setVisible(true);
			}

		});
	}

	private static JButton createToolBarButton(String name) {
		JButton button = new JButton(name);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Executing the Action for the Tool Bar Button - " + name);
			}

		});

		return button;
	}

}
