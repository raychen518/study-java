package com.raychen518.study.java.swing.gui.borders;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class BorderTest {

	private static final String FRAME_TITLE = "Test - Border";
	private static final int FRAME_DEFAULT_WIDTH = 540;
	private static final int FRAME_DEFAULT_HEIGHT = 320;
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

				{
					JTextField textField = new JTextField("No Border", 14);
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Bevel Border (Lowered)", 14);
					textField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Bevel Border (Raised)", 14);
					textField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField(
							"Bevel Border (Lowered, Colors for Highlights and Shadows Set)", 32);
					textField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.RED, Color.CYAN));
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Dashed Border", 14);
					textField.setBorder(BorderFactory.createDashedBorder(null));
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Dashed Border (Relative Length and Spacing Set)", 32);
					textField.setBorder(BorderFactory.createDashedBorder(null, 3.2F, 5.4F));
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Etched Border", 14);
					textField.setBorder(BorderFactory.createEtchedBorder());
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Empty Border", 14);
					textField.setBorder(BorderFactory.createEmptyBorder());
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Line Border (Black)", 14);
					textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Line Border (Black, Thickness Set)", 18);
					textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Line Border (Black, Thickness Set, Rounded)", 24);
					textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Matte Border (Width and Color Set)", 18);
					textField.setBorder(BorderFactory.createMatteBorder(1, 2, 3, 4, Color.RED));
					panel.add(textField);
				}

				{
					JTextField textField = new JTextField("Titled Border", 14);
					textField.setBorder(BorderFactory.createTitledBorder("Some Titled Border"));
					panel.add(textField);
				}

				frame.setVisible(true);
			}

		});
	}

}
