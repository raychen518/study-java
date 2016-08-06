package com.raychen518.study.java.swing.frames;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <pre>
 * This class shows how to display a simple custom frame with a content pane,
 * which contains a message.
 * 
 * Inner Structure of a Frame
 * - A frame includes the root pane, then the layered pane, then the menu bar (optional),
 *   then the content pane, and finally the glass pane.
 * - Normally the content pane is the focus of developers.
 * </pre>
 */
public class FrameC extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String TITLE = "Frame Test";

	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 300;

	private static final int DEFAULT_COORDINATE_X = 400;
	private static final int DEFAULT_COORDINATE_Y = 240;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				FrameC frame = new FrameC();

				frame.setTitle(TITLE);
				frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
				frame.setLocation(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// Add the message component into the frame.
				// The below statement is an abbreviated form of the following
				// statements.
				// =========================================
				// Container contentPane = frame.getContentPane();
				// contentPane.add(frame.new MessageComponent());
				// =========================================
				frame.add(frame.new MessageComponent());

				// The message panel can also be used for displaying messages.
				// frame.add(frame.new MessagePanel());

				// Resize the frame to fit the preferred sizes and layouts of
				// its components.
				// frame.pack();

				frame.setVisible(true);
			}

		});
	}

	/**
	 * <pre>
	 * - To draw a custom component,
	 *   create the component by extending the class "JComponent" first,
	 *   then override the method "paintComponent(Graphics)".
	 * 
	 * - The parameter "Graphics" of the method "paintComponent(Graphics)"
	 *   contains various settings used for drawings.
	 *   In Java, all drawings should be done by the parameter "Graphics".
	 * </pre>
	 */
	private class MessageComponent extends JComponent {

		private static final long serialVersionUID = 1L;

		private static final String MESSAGE = "Hello, Ray Chen!";

		private static final int DEFAULT_COORDINATE_X = 175;
		private static final int DEFAULT_COORDINATE_Y = 125;

		private static final int DEFAULT_WIDTH = 500;
		private static final int DEFAULT_HEIGHT = 300;

		/**
		 * <pre>
		 * - DON'T invoke the method "paintComponent(Graphics)" manually.
		 *   The system automatically invoke that method in proper timings.
		 *   Note: If needing to refresh the drawings indeed,
		 *         invoke another method "repaint()",
		 *         which invokes corresponding "paintComponent(Graphics)" methods using proper settings.
		 * </pre>
		 */
		@Override
		protected void paintComponent(Graphics graphics) {
			graphics.drawString(MESSAGE, DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y);
		}

		/**
		 * <pre>
		 * Set the preferred size of the message component.
		 * </pre>
		 */
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		}

	}

	/**
	 * <pre>
	 * Some developers like JPanel more for drawing things, instead of JComponent.
	 * </pre>
	 */
	@SuppressWarnings("unused")
	private class MessagePanel extends JPanel {

		private static final long serialVersionUID = 1L;

		private static final String MESSAGE = "Cool, Ray Chen!";

		private static final int DEFAULT_COORDINATE_X = 200;
		private static final int DEFAULT_COORDINATE_Y = 150;

		@Override
		public void paint(Graphics graphics) {
			// Invoke the method "paintComponent(Graphics)" from the superclass
			// to draw the panel first, since the panel is not transparent.
			super.paintComponent(graphics);

			graphics.drawString(MESSAGE, DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y);
		}

	}

}
