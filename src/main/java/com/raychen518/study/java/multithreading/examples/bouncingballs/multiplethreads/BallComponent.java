package com.raychen518.study.java.multithreading.examples.bouncingballs.multiplethreads;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * <pre>
 * This class represents a component that draws the balls.
 * </pre>
 */
public class BallComponent extends JComponent {

	private static final long serialVersionUID = -3418578688809523541L;

	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;

	private java.util.List<Ball> balls = new ArrayList<>();

	/**
	 * Add the specified ball to the component.
	 * 
	 * @param ball
	 *            The ball to add.
	 */
	public void add(Ball ball) {
		balls.add(ball);
	}

	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		for (Ball ball : balls) {
			graphics2D.fill(ball.getShape());
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

}
