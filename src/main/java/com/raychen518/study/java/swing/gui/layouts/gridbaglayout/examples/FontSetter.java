package com.raychen518.study.java.swing.gui.layouts.gridbaglayout.examples;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FontSetter {

	private static final String FRAME_TITLE = "Font Setter";
	private static final int FRAME_DEFAULT_WIDTH = 560;
	private static final int FRAME_DEFAULT_HEIGHT = 240;
	private static final int FRAME_DEFAULT_COORDINATE_X = 300;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 160;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JLabel fontFaceLabel = new JLabel("Face: ");

				JComboBox<String> fontFaceComboBox = new JComboBox<>(
						new String[] { "Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput" });

				JLabel fontSizeLabel = new JLabel("Size: ");

				JComboBox<Integer> fontSizeComboBox = new JComboBox<>(new Integer[] { 8, 10, 12, 15, 18, 24, 36, 48 });

				JCheckBox fontStyleBoldCheckBox = new JCheckBox("Bold");

				JCheckBox fontStyleItalicCheckBox = new JCheckBox("Italic");

				JTextArea messageTextArea = new JTextArea(10, 20);
				messageTextArea.setText("The quick brown fox jumps over the lazy dog.");
				messageTextArea.setEditable(false);
				messageTextArea.setLineWrap(true);
				messageTextArea.setBorder(BorderFactory.createEtchedBorder());

				// =============================================================
				// Add Components Using Settings of GridBag Layout
				// =============================================================
				// ---------------------------------------------------------------------------------
				frame.setLayout(new GridBagLayout());

				GridBagConstraints gbcForFontFaceLabel = new GridBagConstraints();
				gbcForFontFaceLabel.gridx = 0;
				gbcForFontFaceLabel.gridy = 0;
				gbcForFontFaceLabel.anchor = GridBagConstraints.EAST;
				frame.add(fontFaceLabel, gbcForFontFaceLabel);

				GridBagConstraints gbcForFontFaceComboBox = new GridBagConstraints();
				gbcForFontFaceComboBox.gridx = 1;
				gbcForFontFaceComboBox.gridy = 0;
				gbcForFontFaceComboBox.fill = GridBagConstraints.HORIZONTAL;
				gbcForFontFaceComboBox.weightx = 100;
				gbcForFontFaceComboBox.weighty = 0;
				gbcForFontFaceComboBox.insets = new Insets(1, 1, 1, 1);
				frame.add(fontFaceComboBox, gbcForFontFaceComboBox);

				GridBagConstraints gbcForFontSizeLabel = new GridBagConstraints();
				gbcForFontSizeLabel.gridx = 0;
				gbcForFontSizeLabel.gridy = 1;
				gbcForFontSizeLabel.anchor = GridBagConstraints.EAST;
				frame.add(fontSizeLabel, gbcForFontSizeLabel);

				GridBagConstraints gbcForFontSizeComboBox = new GridBagConstraints();
				gbcForFontSizeComboBox.gridx = 1;
				gbcForFontSizeComboBox.gridy = 1;
				gbcForFontSizeComboBox.fill = GridBagConstraints.HORIZONTAL;
				gbcForFontSizeComboBox.weightx = 100;
				gbcForFontSizeComboBox.weighty = 0;
				gbcForFontSizeComboBox.insets = new Insets(1, 1, 1, 1);
				frame.add(fontSizeComboBox, gbcForFontSizeComboBox);

				GridBagConstraints gbcForFontStyleBoldCheckBox = new GridBagConstraints();
				gbcForFontStyleBoldCheckBox.gridx = 0;
				gbcForFontStyleBoldCheckBox.gridy = 2;
				gbcForFontStyleBoldCheckBox.gridwidth = 2;
				gbcForFontStyleBoldCheckBox.gridheight = 1;
				gbcForFontStyleBoldCheckBox.anchor = GridBagConstraints.CENTER;
				gbcForFontStyleBoldCheckBox.weightx = 100;
				gbcForFontStyleBoldCheckBox.weighty = 100;
				frame.add(fontStyleBoldCheckBox, gbcForFontStyleBoldCheckBox);

				GridBagConstraints gbcForFontStyleItalicCheckBox = new GridBagConstraints();
				gbcForFontStyleItalicCheckBox.gridx = 0;
				gbcForFontStyleItalicCheckBox.gridy = 3;
				gbcForFontStyleItalicCheckBox.gridwidth = 2;
				gbcForFontStyleItalicCheckBox.gridheight = 1;
				gbcForFontStyleItalicCheckBox.anchor = GridBagConstraints.CENTER;
				gbcForFontStyleItalicCheckBox.weightx = 100;
				gbcForFontStyleItalicCheckBox.weighty = 100;
				frame.add(fontStyleItalicCheckBox, gbcForFontStyleItalicCheckBox);

				GridBagConstraints gbcForMessageTextArea = new GridBagConstraints();
				gbcForMessageTextArea.gridx = 2;
				gbcForMessageTextArea.gridy = 0;
				gbcForMessageTextArea.gridwidth = 1;
				gbcForMessageTextArea.gridheight = 4;
				gbcForMessageTextArea.fill = GridBagConstraints.BOTH;
				gbcForMessageTextArea.weightx = 100;
				gbcForMessageTextArea.weighty = 100;
				frame.add(messageTextArea, gbcForMessageTextArea);
				// ---------------------------------------------------------------------------------

				ActionListener actionListener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						String fontFace = (String) fontFaceComboBox.getSelectedItem();
						int fontSize = fontSizeComboBox.getItemAt(fontSizeComboBox.getSelectedIndex());
						int fontStyle = (fontStyleBoldCheckBox.isSelected() ? Font.BOLD : 0)
								+ (fontStyleItalicCheckBox.isSelected() ? Font.ITALIC : 0);
						Font font = new Font(fontFace, fontStyle, fontSize);

						messageTextArea.setFont(font);
						messageTextArea.repaint();
					}

				};

				fontFaceComboBox.addActionListener(actionListener);
				fontSizeComboBox.addActionListener(actionListener);
				fontStyleBoldCheckBox.addActionListener(actionListener);
				fontStyleItalicCheckBox.addActionListener(actionListener);

				actionListener.actionPerformed(null);

				frame.setVisible(true);
			}

		});
	}

}