package com.raychen518.study.java.swing.gui.colorchooser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

	private static final String FRAME_TITLE = "Test - Color Chooser";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final String BUTTON_TEXT_PREFIX = "Button ";
	private static final String COLOR_CHOOSER_DEFAULT_TITLE = "Color Chooser";
	private static final String COLOR_CHOOSER_DIALOG_DEFAULT_TITLE = "Color Chooser Dialog";

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

				int buttonCounter = 0;

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JColorChooser.showDialog(null, COLOR_CHOOSER_DEFAULT_TITLE, Color.RED);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JColorChooser.showDialog(frame, null, Color.GREEN);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							Color color = JColorChooser.showDialog(null, COLOR_CHOOSER_DEFAULT_TITLE, Color.RED);
							System.out.println("The chosen color is: " + color);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JColorChooser colorChooser = new JColorChooser();
							JDialog dialog = JColorChooser.createDialog(null, COLOR_CHOOSER_DIALOG_DEFAULT_TITLE, true,
									colorChooser, null, null);
							dialog.setVisible(true);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JColorChooser colorChooser = new JColorChooser();

							ActionListener oKActionListener = new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent event) {
									System.out.println("The chosen color is: " + colorChooser.getColor() + ".");
								}

							};

							ActionListener cancelActionListener = new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent event) {
									System.out.println("The color choosing is cancelled.");
								}

							};

							JDialog dialog = JColorChooser.createDialog(frame, COLOR_CHOOSER_DIALOG_DEFAULT_TITLE, true,
									colorChooser, oKActionListener, cancelActionListener);
							dialog.setVisible(true);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JColorChooser colorChooser = new JColorChooser();
							JDialog dialog = JColorChooser.createDialog(null, COLOR_CHOOSER_DIALOG_DEFAULT_TITLE, false,
									colorChooser, null, null);
							dialog.setVisible(true);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JColorChooser colorChooser = new JColorChooser();

							ActionListener oKActionListener = new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent event) {
									System.out.println("The chosen color is: " + colorChooser.getColor() + ".");
									button.setBackground(colorChooser.getColor());
								}

							};

							JDialog dialog = JColorChooser.createDialog(frame, COLOR_CHOOSER_DIALOG_DEFAULT_TITLE, true,
									colorChooser, oKActionListener, null);
							dialog.setVisible(true);
						}

					});
					panel.add(button);
				}

				frame.setVisible(true);
			}

		});
	}

}
