package com.raychen518.study.java.swing.gui.dialogs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.raychen518.study.java._util.Images;

/**
 * <pre>
 * JOptionPane.showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue);
 * </pre>
 */
public class OptionDialogTest {

	private static final String FRAME_TITLE = "Test - Dialog - OptionDialog";
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;

	private static final String BUTTON_TEXT_PREFIX = "Button ";

	private static final String DIALOG_DEFAULT_TITLE = "Some Title";
	private static final String DIALOG_DEFAULT_MESSAGE = "Some Message";

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
							int optionSelected = JOptionPane.showOptionDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_TITLE, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
									null, null, null);
							System.out.println("Option Selected: " + optionSelected);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							int optionSelected = JOptionPane.showOptionDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_TITLE, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
									new ImageIcon(Images.createImage()), null, null);
							System.out.println("Option Selected: " + optionSelected);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							int optionSelected = JOptionPane.showOptionDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
									null, null);
							System.out.println("Option Selected: " + optionSelected);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							Object[] options = new Object[] { "Option 1", "Option 2", "Option 3" };
							int optionSelected = JOptionPane.showOptionDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_TITLE, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
									null, options, options[1]);
							System.out.println("Option Selected: " + optionSelected);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							Object[] options = new Object[] { "Option 1", "Option 2", "Option 3", "Option 4" };
							int optionSelected = JOptionPane.showOptionDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_TITLE, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
									null, options, options[1]);
							System.out.println("Option Selected: " + optionSelected);
						}

					});
					panel.add(button);
				}

				frame.setVisible(true);
			}

		});
	}

}
