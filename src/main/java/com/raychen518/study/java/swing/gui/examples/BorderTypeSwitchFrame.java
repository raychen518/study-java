package com.raychen518.study.java.swing.gui.examples;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class BorderTypeSwitchFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String FRAME_TITLE = "Border Type Switch Frame";
	private static final int FRAME_DEFAULT_WIDTH = 540;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private JPanel operationPanel;
	private JPanel resultPanel;
	private ButtonGroup buttonGroup;

	public BorderTypeSwitchFrame() {
		resultPanel = new JPanel();
		operationPanel = new JPanel();
		buttonGroup = new ButtonGroup();

		addButton("Bevel (Lowered)", BorderFactory.createLoweredBevelBorder());
		addButton("Bevel (Raised)", BorderFactory.createRaisedBevelBorder());
		addButton("Etched", BorderFactory.createEtchedBorder());
		addButton("Line", BorderFactory.createLineBorder(Color.BLUE));
		addButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
		addButton("Empty", BorderFactory.createEmptyBorder());

		Border etchedBorder = BorderFactory.createEtchedBorder();
		Border titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Border Types");
		operationPanel.setBorder(titledBorder);

		setLayout(new GridLayout(2, 1));
		add(operationPanel);
		add(resultPanel);
		pack();
	}

	public void addButton(String name, final Border border) {
		JRadioButton button = new JRadioButton(name);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				resultPanel.setBorder(border);
			}

		});

		buttonGroup.add(button);
		operationPanel.add(button);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new BorderTypeSwitchFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}

		});
	}

}
