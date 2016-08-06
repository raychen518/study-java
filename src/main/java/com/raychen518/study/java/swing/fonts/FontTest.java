package com.raychen518.study.java.swing.fonts;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * <pre>
 * This class shows how to use fonts on those Swing components.
 * 
 * - Configuration about fonts can be found at the file <JRE_HOME>/lib/fontconfig.properties.src.
 * </pre>
 */
public class FontTest {

	private static final String FRAME_TITLE = "Test - Font";
	private static final int FRAME_DEFAULT_WIDTH = 800;
	private static final int FRAME_DEFAULT_HEIGHT = 400;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	public static void main(String[] args) {
		showAvailableFonts();
		System.out.println();

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setSize(FRAME_DEFAULT_WIDTH, FRAME_DEFAULT_HEIGHT);
				frame.setLocation(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.add(new FontComponent());

				frame.setVisible(true);
			}

		});
	}

	private static void showAvailableFonts() {
		String[] availableFontFamilyNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();

		System.out.println("Count of Available Font Families: " + availableFontFamilyNames.length);
		System.out.println("----------------------------------------------------");
		for (String getAvailableFontFamilyName : availableFontFamilyNames) {
			System.out.println(getAvailableFontFamilyName);
		}
	}

	private static class FontComponent extends JComponent {

		private static final long serialVersionUID = 1L;

		private static final int DEFAULT_COORDINATE_X = 10;
		private static final int DEFAULT_COORDINATE_Y = 20;
		private static final int DEFAULT_LINE_HEIGHT = 14;
		private static final int DEFAULT_LINE_SPACE = 5;

		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D graphics2d = (Graphics2D) graphics;
			int lineCounter = 0;

			graphics2d.drawString("Text using default font setting.", DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y);

			graphics2d.setFont(new Font("Arial", Font.BOLD, 11));
			graphics2d.drawString("Text using the font setting: Arial & BOLD & 11.", DEFAULT_COORDINATE_X,
					DEFAULT_COORDINATE_Y + (DEFAULT_LINE_HEIGHT + DEFAULT_LINE_SPACE) * ++lineCounter);

			graphics2d.setFont(new Font("Courier New", Font.ITALIC, 12));
			graphics2d.drawString("Text using the font setting: Courier New & ITALIC & 12.", DEFAULT_COORDINATE_X,
					DEFAULT_COORDINATE_Y + (DEFAULT_LINE_HEIGHT + DEFAULT_LINE_SPACE) * ++lineCounter);

			graphics2d.setFont(new Font("Microsoft Sans Serif", Font.BOLD + Font.ITALIC, 13));
			graphics2d.drawString("Text using the font setting: Microsoft Sans Serif & BOLD + ITALIC & 13.",
					DEFAULT_COORDINATE_X,
					DEFAULT_COORDINATE_Y + (DEFAULT_LINE_HEIGHT + DEFAULT_LINE_SPACE) * ++lineCounter);

			graphics2d.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			graphics2d.drawString("Text using the font setting: Times New Roman & PLAIN & 14.", DEFAULT_COORDINATE_X,
					DEFAULT_COORDINATE_Y + (DEFAULT_LINE_HEIGHT + DEFAULT_LINE_SPACE) * ++lineCounter);

			graphics2d.setFont(new Font("Verdana", Font.PLAIN, 15));
			graphics2d.drawString("Text using the font setting: Verdana & PLAIN & 15.", DEFAULT_COORDINATE_X,
					DEFAULT_COORDINATE_Y + (DEFAULT_LINE_HEIGHT + DEFAULT_LINE_SPACE) * ++lineCounter);
		}

	}

}
