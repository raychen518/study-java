package com.raychen518.study.java.swing.shapes;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * <pre>
 * This class shows how to display rectangles in 2D shapes.
 * </pre>
 */
public class RectangleTest {

	private static final String FRAME_TITLE = "Test - Rectangle";
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

				frame.add(new RectangleComponent());

				frame.setVisible(true);
			}

		});
	}

	private static class RectangleComponent extends JComponent {

		private static final long serialVersionUID = 1L;

		private static final int DEFAULT_COORDINATE_X = 30;
		private static final int DEFAULT_COORDINATE_Y = 20;
		private static final int DEFAULT_WIDTH = 100;
		private static final int DEFAULT_HEIGHT = 30;
		private static final int DEFAULT_SPACE_HORIZONTAL = 30;
		private static final int DEFAULT_SPACE_VERTICAL = 20;

		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D graphics2d = (Graphics2D) graphics;

			// Draw a rectangle using 2 integral coordinates, and the integral
			// width and height.
			graphics2d.drawRect(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);

			// Draw a rectangle using a Rectangle2D instance specified by 2
			// double coordinates, and the double width and height.
			graphics2d.draw(new Rectangle2D.Double(Double.valueOf(DEFAULT_COORDINATE_X),
					Double.valueOf(DEFAULT_COORDINATE_Y + DEFAULT_HEIGHT + DEFAULT_SPACE_VERTICAL),
					Double.valueOf(DEFAULT_WIDTH), Double.valueOf(DEFAULT_HEIGHT)));

			// Draw another rectangle.
			graphics2d.drawRect(DEFAULT_COORDINATE_X + DEFAULT_WIDTH + DEFAULT_SPACE_HORIZONTAL, DEFAULT_COORDINATE_Y,
					DEFAULT_WIDTH, DEFAULT_HEIGHT);

			// Draw another rectangle.
			graphics2d.drawRect(DEFAULT_COORDINATE_X + DEFAULT_WIDTH + DEFAULT_SPACE_HORIZONTAL,
					DEFAULT_COORDINATE_Y + DEFAULT_HEIGHT + DEFAULT_SPACE_VERTICAL, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		}

	}

}
