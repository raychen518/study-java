package com.raychen518.study.java.swing.images;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * <pre>
 * This class shows how to handle images in Swing.
 * </pre>
 */
public class ImageTest {

	private static final String FRAME_TITLE = "Test - Image";
	private static final int FRAME_DEFAULT_WIDTH = 800;
	private static final int FRAME_DEFAULT_HEIGHT = 400;
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

				frame.add(new ImageComponent());

				frame.setVisible(true);
			}

		});
	}

	private static class ImageComponent extends JComponent {

		private static final long serialVersionUID = 1L;

		private static final String IMAGE_PATH = "d:\\_Temp\\images\\java.png";

		private Image image = null;

		public ImageComponent() {
			this.image = new ImageIcon(IMAGE_PATH).getImage();
		}

		@Override
		protected void paintComponent(Graphics graphics) {
			if (image == null) {
				return;
			}

			Graphics2D graphics2d = (Graphics2D) graphics;

			// Draw the image in the upper-left corner.
			graphics2d.drawImage(image, 0, 0, null);

			int imageWidth = image.getWidth(this);
			int imageHeight = image.getHeight(this);

			// Tile the image across the container.
			for (int i = 0; i * imageWidth <= getWidth(); i++) {
				for (int j = 0; j * imageHeight <= getHeight(); j++) {
					if (i + j > 0) {
						graphics2d.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
					}
				}
			}
		}

	}

}
