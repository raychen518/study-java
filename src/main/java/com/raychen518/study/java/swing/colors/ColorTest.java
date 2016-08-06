package com.raychen518.study.java.swing.colors;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * <pre>
 * This class shows how to paint colors on those Swing components.
 * </pre>
 */
public class ColorTest {

	private static final String FRAME_TITLE = "Test - Color";
	private static final int FRAME_DEFAULT_WIDTH = 450;
	private static final int FRAME_DEFAULT_HEIGHT = 300;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setSize(FRAME_DEFAULT_WIDTH, FRAME_DEFAULT_HEIGHT);
				frame.setLocation(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.add(new ColorComponent());

				/// Set background color for the frame's content pane, using the
				/// pink color defined as a color constant.
				frame.getContentPane().setBackground(Color.PINK);

				frame.setVisible(true);
			}

		});
	}

	private static class ColorComponent extends JComponent {

		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D graphics2d = (Graphics2D) graphics;

			// Paint some text, using the red color defined as a color constant.
			graphics2d.setPaint(Color.RED);
			graphics2d.drawString("Cool!", 30, 20);

			// Paint a line, using the green color defined as a color constant.
			graphics2d.setPaint(Color.GREEN);
			graphics2d.drawLine(30, 40, 300, 40);

			// Paint a rectangle, using the blue color represented as a color
			// instance.
			graphics2d.setPaint(new Color(0, 0, 255));
			graphics2d.drawRect(30, 60, 100, 50);

			// Paint an ellipse, using the color being used by the active
			// caption text defined as a system color constant.
			graphics2d.setPaint(SystemColor.activeCaptionText);
			graphics2d.draw(new Ellipse2D.Double(30, 130, 100, 50));

			// Fill an ellipse, using the yellow color defined as a color
			// constant.
			Ellipse2D someEllipse = new Ellipse2D.Double(30, 200, 100, 50);
			graphics2d.draw(someEllipse);
			graphics2d.setPaint(Color.YELLOW);
			graphics2d.fill(someEllipse);
		}

	}

}
