package com.raychen518.study.java.swing.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * <pre>
 * This class shows how to display lines in 2D shapes.
 * 
 * Inheritance Hierarchy
 * - java.awt.geom.Line2D <implements> java.awt.Shape.
 * ---------------------------------------------------------
 * - java.awt.Rectangle <extends> java.awt.geom.Rectangle2D <extends> java.awt.geom.RectangularShape <implements> java.awt.Shape.
 * ---------------------------------------------------------
 * - java.awt.geom.Ellipse2D <extends> java.awt.geom.RectangularShape <implements> java.awt.Shape.
 * ---------------------------------------------------------
 * - java.awt.Point <extends> java.awt.geom.Point2D.
 * ---------------------------------------------------------
 * - java.awt.geom.Line2D, java.awt.geom.Rectangle2D, java.awt.geom.Ellipse2D
 *   java.awt.geom.Point2D and etc. all have their own Double and Float subclasses.
 * </pre>
 */
public class LineTest {

	private static final String FRAME_TITLE = "Test - Line";
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

				frame.add(new LineComponent());

				frame.setVisible(true);
			}

		});
	}

	private static class LineComponent extends JComponent {

		private static final long serialVersionUID = 1L;

		private static final int DEFAULT_COORDINATE_X_1 = 30;
		private static final int DEFAULT_COORDINATE_Y_1 = 20;
		private static final int DEFAULT_COORDINATE_X_2 = 300;
		private static final int DEFAULT_COORDINATE_Y_2 = 20;
		private static final int DEFAULT_SPACE = 20;

		@Override
		protected void paintComponent(Graphics graphics) {
			// To draw shapes by Java 2D,
			// a Graphics2D instance should be retrieved first.
			// It can be done by a simple type conversion
			// from "Graphics" to "Graphics2D".
			Graphics2D graphics2d = (Graphics2D) graphics;

			// Draw a line using 4 integral coordinates.
			graphics2d.drawLine(DEFAULT_COORDINATE_X_1, DEFAULT_COORDINATE_Y_1, DEFAULT_COORDINATE_X_2,
					DEFAULT_COORDINATE_Y_2);

			// Draw a line using a Line2D instance specified by 4 double
			// coordinates.
			graphics2d.draw(new Line2D.Double(Double.valueOf(DEFAULT_COORDINATE_X_1),
					Double.valueOf(DEFAULT_COORDINATE_Y_1 + DEFAULT_SPACE), Double.valueOf(DEFAULT_COORDINATE_X_2),
					Double.valueOf(DEFAULT_COORDINATE_Y_2 + DEFAULT_SPACE)));

			// Draw a line using a Line2D instance specified by 2 Point2D
			// instances which are defined using 2 double coordinates.
			graphics2d.draw(new Line2D.Double(
					new Point2D.Double(Double.valueOf(DEFAULT_COORDINATE_X_1),
							Double.valueOf(DEFAULT_COORDINATE_Y_1 + DEFAULT_SPACE * 2)),
					new Point2D.Double(Double.valueOf(DEFAULT_COORDINATE_X_2),
							Double.valueOf(DEFAULT_COORDINATE_Y_2 + DEFAULT_SPACE * 2))));

			// Draw another line.
			graphics2d.setColor(Color.RED);
			graphics2d.drawLine(DEFAULT_COORDINATE_X_1, DEFAULT_COORDINATE_Y_1 + DEFAULT_SPACE * 3,
					DEFAULT_COORDINATE_X_2, DEFAULT_COORDINATE_Y_2 + DEFAULT_SPACE * 4);

			// Draw another line.
			graphics2d.setStroke(new BasicStroke(2));
			graphics2d.drawLine(DEFAULT_COORDINATE_X_1, DEFAULT_COORDINATE_Y_1 + DEFAULT_SPACE * 4,
					DEFAULT_COORDINATE_X_2, DEFAULT_COORDINATE_Y_2 + DEFAULT_SPACE * 3);
		}

	}

}
