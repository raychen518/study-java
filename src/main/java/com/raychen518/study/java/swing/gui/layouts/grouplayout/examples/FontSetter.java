package com.raychen518.study.java.swing.gui.layouts.grouplayout.examples;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

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

				JScrollPane scrollPaneForMessageTextArea = new JScrollPane(messageTextArea);

				// =============================================================
				// Add Components Using Settings of Group Layout
				// =============================================================
				// ---------------------------------------------------------------------------------
				GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
				frame.setLayout(groupLayout);

				// Set the horizontal group.
				groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(fontFaceLabel).addComponent(fontSizeLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(fontSizeComboBox).addComponent(fontFaceComboBox)))
								.addComponent(fontStyleItalicCheckBox).addComponent(fontStyleBoldCheckBox))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(scrollPaneForMessageTextArea).addContainerGap()));

				// Adjust the component sizes.
				groupLayout.linkSize(SwingConstants.HORIZONTAL,
						new java.awt.Component[] { fontFaceComboBox, fontSizeComboBox });

				// Set the vertical group.
				groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scrollPaneForMessageTextArea, GroupLayout.Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(fontFaceComboBox).addComponent(fontFaceLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(fontSizeComboBox).addComponent(fontSizeLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(fontStyleItalicCheckBox, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(fontStyleBoldCheckBox, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addContainerGap()));
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