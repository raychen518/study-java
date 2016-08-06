package com.raychen518.study.java.swing.eventhandling.mouse.examples;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class SimpleGraphEditor {

	private static final String FRAME_TITLE = "Example - Simple Graph Editor";
	private static final int FRAME_DEFAULT_WIDTH = 600;
	private static final int FRAME_DEFAULT_HEIGHT = 300;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final int SQUARE_LENGTH = 10;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setSize(FRAME_DEFAULT_WIDTH, FRAME_DEFAULT_HEIGHT);
				frame.setLocation(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.add(new MouseComponent());

				frame.setVisible(true);
			}

		});
	}

	private static class MouseComponent extends JComponent {

		private static final long serialVersionUID = 1L;

		private ArrayList<Rectangle2D> squares;
		private Rectangle2D currentSquare;

		public MouseComponent() {
			squares = new ArrayList<Rectangle2D>();
			currentSquare = null;

			addMouseListener(new MouseHandler());
			addMouseMotionListener(new MouseMotionHandler());
		}

		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D graphics2D = (Graphics2D) graphics;

			for (Rectangle2D square : squares) {
				graphics2D.draw(square);
			}
		}

		public Rectangle2D findSquare(Point2D point) {
			Rectangle2D result = null;

			for (Rectangle2D square : squares) {
				if (square.contains(point)) {
					result = square;
					break;
				}
			}

			return result;
		}

		public void addSquare(Point2D point) {
			double x = point.getX();
			double y = point.getY();

			currentSquare = new Rectangle2D.Double(x - SQUARE_LENGTH / 2, y - SQUARE_LENGTH / 2, SQUARE_LENGTH,
					SQUARE_LENGTH);
			squares.add(currentSquare);
			repaint();
		}

		public void removeSquare(Rectangle2D square) {
			if (square == null) {
				return;
			}

			if (square == currentSquare) {
				currentSquare = null;
			}

			squares.remove(square);
			repaint();
		}

		private class MouseHandler extends MouseAdapter {

			@Override
			public void mousePressed(MouseEvent mouseEvent) {
				currentSquare = findSquare(mouseEvent.getPoint());
				if (currentSquare == null) {
					addSquare(mouseEvent.getPoint());
				}
			}

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				currentSquare = findSquare(mouseEvent.getPoint());
				if (currentSquare != null && mouseEvent.getClickCount() >= 2) {
					removeSquare(currentSquare);
				}
			}

		}

		private class MouseMotionHandler implements MouseMotionListener {

			@Override
			public void mouseMoved(MouseEvent mouseEvent) {
				if (findSquare(mouseEvent.getPoint()) == null) {
					setCursor(Cursor.getDefaultCursor());
				} else {
					setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				}
			}

			@Override
			public void mouseDragged(MouseEvent mouseEvent) {
				if (currentSquare != null) {
					double x = mouseEvent.getX();
					double y = mouseEvent.getY();

					currentSquare.setFrame(x - SQUARE_LENGTH / 2, y - SQUARE_LENGTH / 2, SQUARE_LENGTH, SQUARE_LENGTH);
					repaint();
				}
			}

		}

	}

}
