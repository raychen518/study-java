package com.raychen518.study.java.multithreading.examples.bouncingballs.multiplethreads;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * <pre>
 * This class represents a ball able to move and bounce off the edges of its rectangular container.
 * </pre>
 */
public class Ball {

	/**
	 * <pre>
	 * The size on the X axis (width) of the framing rectangle of the ball.
	 * </pre>
	 */
	private static final int X_SIZE = 15;

	/**
	 * <pre>
	 * The size on the Y axis (height) of the framing rectangle of the ball.
	 * </pre>
	 */
	private static final int Y_SIZE = 15;

	/**
	 * <pre>
	 * The X coordinate of the upper-left corner of the framing rectangle of the ball.
	 * </pre>
	 */
	private double x = 0;

	/**
	 * <pre>
	 * The Y coordinate of the upper-left corner of the framing rectangle of the ball.
	 * </pre>
	 */
	private double y = 0;

	/**
	 * <pre>
	 * The move step of the ball on the X axis.
	 * </pre>
	 */
	private double moveStepX = 1;

	/**
	 * <pre>
	 * The move step of the ball on the Y axis.
	 * </pre>
	 */
	private double moveStepY = 1;

	/**
	 * <pre>
	 * Move the ball in the specified container, reversing its direction if it hits one of the edges of the container.
	 * </pre>
	 * 
	 * @param container
	 *            The ball's container.
	 */
	public void move(Rectangle2D container) {
		// Move the ball one step on the X axis.
		x += moveStepX;

		// Move the ball one step on the Y axis.
		y += moveStepY;

		// If the ball moves beyond the left edge of its container,
		// reverse its direction on the X axis.
		if (x < container.getMinX()) {
			x = container.getMinX();
			moveStepX = -moveStepX;
		}

		// If the ball moves beyond the right edge of its container,
		// reverse its direction on the X axis.
		if (x + X_SIZE >= container.getMaxX()) {
			x = container.getMaxX() - X_SIZE;
			moveStepX = -moveStepX;
		}

		// If the ball moves beyond the top edge of its container,
		// reverse its direction on the Y axis.
		if (y < container.getMinY()) {
			y = container.getMinY();
			moveStepY = -moveStepY;
		}

		// If the ball moves beyond the bottom edge of its container,
		// reverse its direction on the Y axis.
		if (y + Y_SIZE >= container.getMaxY()) {
			y = container.getMaxY() - Y_SIZE;
			moveStepY = -moveStepY;
		}
	}

	/**
	 * <pre>
	 * Get the shape of the ball at its current position.
	 * </pre>
	 * 
	 * @return The shape of the ball at its current position.
	 */
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, X_SIZE, Y_SIZE);
	}

}
