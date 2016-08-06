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
 * JOptionPane.showInputDialog(message);
 * JOptionPane.showInputDialog(parentComponent, message);
 * JOptionPane.showInputDialog(message, initialSelectionValue);
 * JOptionPane.showInputDialog(parentComponent, message, initialSelectionValue);
 * JOptionPane.showInputDialog(parentComponent, message, title, messageType);
 * JOptionPane.showInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue);
 * </pre>
 */
public class InputDialogTest {

	private static final String FRAME_TITLE = "Test - Dialog - InputDialog";
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;

	private static final String BUTTON_TEXT_PREFIX = "Button ";

	private static final String DIALOG_DEFAULT_TITLE = "Some Title";
	private static final String DIALOG_DEFAULT_MESSAGE = "Some Message";
	private static final String DIALOG_DEFAULT_INITIAL_INPUT = "Please input something here.";

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
							String input = JOptionPane.showInputDialog(DIALOG_DEFAULT_MESSAGE);
							System.out.println("Input: " + input);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							String input = JOptionPane.showInputDialog(frame, DIALOG_DEFAULT_MESSAGE);
							System.out.println("Input: " + input);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							String input = JOptionPane.showInputDialog(DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_INITIAL_INPUT);
							System.out.println("Input: " + input);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							String input = JOptionPane.showInputDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_INITIAL_INPUT);
							System.out.println("Input: " + input);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							String input = JOptionPane.showInputDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_TITLE, JOptionPane.WARNING_MESSAGE);
							System.out.println("Input: " + input);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							String input = (String) JOptionPane.showInputDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_TITLE, JOptionPane.ERROR_MESSAGE, null, null,
									DIALOG_DEFAULT_INITIAL_INPUT);
							System.out.println("Input: " + input);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							String input = (String) JOptionPane.showInputDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_TITLE, JOptionPane.ERROR_MESSAGE,
									new ImageIcon(Images.createImage()), null, DIALOG_DEFAULT_INITIAL_INPUT);
							System.out.println("Input: " + input);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							Object[] possibleInputs = new String[] { "Input 1", "Input 2", "Input 3" };
							String input = (String) JOptionPane.showInputDialog(frame, DIALOG_DEFAULT_MESSAGE,
									DIALOG_DEFAULT_TITLE, JOptionPane.ERROR_MESSAGE, null, possibleInputs,
									possibleInputs[1]);
							System.out.println("Input: " + input);
						}

					});
					panel.add(button);
				}

				frame.setVisible(true);
			}

		});
	}

}
