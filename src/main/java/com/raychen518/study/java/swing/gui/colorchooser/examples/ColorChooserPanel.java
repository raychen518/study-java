package com.raychen518.study.java.swing.gui.colorchooser.examples;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooserPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final String COLOR_CHOOSER_DIALOG_TITLE_PREFIX = "Color Chooser Dialog (";
	private static final String COLOR_CHOOSER_DIALOG_TITLE_SUFFIX = ")";

	private static final String COLOR_CHOOSER_DIALOG_TYPE_DESC_MODAL = "Modal";
	private static final String COLOR_CHOOSER_DIALOG_TYPE_DESC_MODELESS = "Modeless";
	private static final String COLOR_CHOOSER_DIALOG_TYPE_DESC_MODELESS_IMMEDIATE = "Modeless Immediate";

	public ColorChooserPanel() {
		JButton modalButton = new JButton("Modal");
		modalButton.addActionListener(new ModalActionListener());
		add(modalButton);

		JButton modelessButton = new JButton("Modeless");
		modelessButton.addActionListener(new ModelessActionListener());
		add(modelessButton);

		JButton modelessImmediateButton = new JButton("Modeless Immediate");
		modelessImmediateButton.addActionListener(new ModelessImmediateActionListener());
		add(modelessImmediateButton);
	}

	private static String generateDialogTitle(String dialogTypeDesc) {
		return COLOR_CHOOSER_DIALOG_TITLE_PREFIX + dialogTypeDesc + COLOR_CHOOSER_DIALOG_TITLE_SUFFIX;
	}

	private class ModalActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			Color defaultBackgroundColor = getBackground();

			Color chosenColor = JColorChooser.showDialog(ColorChooserPanel.this,
					generateDialogTitle(COLOR_CHOOSER_DIALOG_TYPE_DESC_MODAL), defaultBackgroundColor);

			if (chosenColor != null) {
				setBackground(chosenColor);
			}
		}

	}

	private class ModelessActionListener implements ActionListener {

		private JDialog dialog;
		private JColorChooser colorChooser;

		public ModelessActionListener() {
			colorChooser = new JColorChooser();
			dialog = JColorChooser.createDialog(ColorChooserPanel.this,
					generateDialogTitle(COLOR_CHOOSER_DIALOG_TYPE_DESC_MODELESS), false, colorChooser,
					new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							setBackground(colorChooser.getColor());
						}

					}, null);
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			colorChooser.setColor(getBackground());
			dialog.setVisible(true);
		}

	}

	private class ModelessImmediateActionListener implements ActionListener {

		private JDialog dialog;
		private JColorChooser colorChooser;

		public ModelessImmediateActionListener() {
			colorChooser = new JColorChooser();
			colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent event) {
					setBackground(colorChooser.getColor());
				}

			});

			dialog = new JDialog((Frame) null, generateDialogTitle(COLOR_CHOOSER_DIALOG_TYPE_DESC_MODELESS_IMMEDIATE),
					false);
			dialog.add(colorChooser);
			dialog.pack();
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			colorChooser.setColor(getBackground());
			dialog.setVisible(true);
		}

	}

	private static final String FRAME_TITLE = "Color Chooser Panel";
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

				frame.add(new ColorChooserPanel());

				frame.setVisible(true);
			}

		});
	}

}
