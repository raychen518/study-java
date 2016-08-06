package com.raychen518.study.java._util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Images {
	private static final String DEFAULT_IMAGE_IDENTIFIER = null;
	private static final int DEFAULT_IMAGE_WIDTH = 100;
	private static final int DEFAULT_IMAGE_HEIGHT = 100;
	private static final int DEFAULT_IMAGE_TYPE = BufferedImage.TYPE_INT_RGB;

	public static Image createImage() {
		return createImage(DEFAULT_IMAGE_IDENTIFIER, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
	}

	public static Image createImage(String identifier) {
		return createImage(identifier, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
	}

	public static Image createImage(int width, int height) {
		return createImage(DEFAULT_IMAGE_IDENTIFIER, width, height);
	}

	public static Image createImage(double percent) {
		return createImage(DEFAULT_IMAGE_IDENTIFIER, Double.valueOf(percent * DEFAULT_IMAGE_WIDTH).intValue(),
				Double.valueOf(percent * DEFAULT_IMAGE_HEIGHT).intValue());
	}

	public static Image createImage(String identifier, double percent) {
		return createImage(identifier, Double.valueOf(percent * DEFAULT_IMAGE_WIDTH).intValue(),
				Double.valueOf(percent * DEFAULT_IMAGE_HEIGHT).intValue());
	}

	public static Image createImage(String identifier, int width, int height) {
		BufferedImage image = new BufferedImage(width, height, DEFAULT_IMAGE_TYPE);
		Graphics2D graphics = image.createGraphics();

		Rectangle2D rectangle = new Rectangle2D.Double(0.3 * width, 0.24 * height, 0.3 * width, 0.3 * height);
		graphics.setColor(Color.RED);
		graphics.draw(rectangle);
		graphics.fill(rectangle);

		Ellipse2D circle = new Ellipse2D.Double(0.45 * width, 0.39 * height, 0.3 * width, 0.3 * height);
		graphics.setColor(Color.GREEN);
		graphics.draw(circle);
		graphics.fill(circle);

		Line2D line = new Line2D.Double(0.15 * width, 0.8 * height, 0.85 * width, 0.8 * height);
		graphics.setColor(Color.BLUE);
		graphics.setStroke(new BasicStroke(3));
		graphics.draw(line);

		if (identifier != null && identifier.length() > 0) {
			graphics.setColor(Color.WHITE);
			int fontSize = Double.valueOf(0.17 * Numbers.findMinValue(width, height)).intValue();
			graphics.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, fontSize));
			graphics.drawString(identifier, Math.round(0.35 * width), Math.round(0.5 * height));
		}

		return image;
	}

	private static final String FRAME_TITLE = "Test";
	private static final int FRAME_DEFAULT_WIDTH = 720;
	private static final int FRAME_DEFAULT_HEIGHT = 640;
	private static final int FRAME_DEFAULT_COORDINATE_X = 480;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 40;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				frame.add(panel);

				panel.add(new JLabel(new ImageIcon(createImage())));

				panel.add(new JLabel(new ImageIcon(createImage("ABC"))));
				panel.add(new JLabel(new ImageIcon(createImage("DEF"))));
				panel.add(new JLabel(new ImageIcon(createImage("GHI"))));

				panel.add(new JLabel(new ImageIcon(createImage(150, 150))));
				panel.add(new JLabel(new ImageIcon(createImage(100, 100))));
				panel.add(new JLabel(new ImageIcon(createImage(50, 50))));
				panel.add(new JLabel(new ImageIcon(createImage(25, 25))));

				panel.add(new JLabel(new ImageIcon(createImage("ABC", 150, 150))));
				panel.add(new JLabel(new ImageIcon(createImage("ABC", 100, 100))));
				panel.add(new JLabel(new ImageIcon(createImage("ABC", 50, 50))));
				panel.add(new JLabel(new ImageIcon(createImage("ABC", 25, 25))));

				panel.add(new JLabel(new ImageIcon(createImage(1.5))));
				panel.add(new JLabel(new ImageIcon(createImage(1))));
				panel.add(new JLabel(new ImageIcon(createImage(0.5))));
				panel.add(new JLabel(new ImageIcon(createImage(0.25))));

				panel.add(new JLabel(new ImageIcon(createImage("ABC", 1.5))));
				panel.add(new JLabel(new ImageIcon(createImage("ABC", 1))));
				panel.add(new JLabel(new ImageIcon(createImage("ABC", 0.5))));
				panel.add(new JLabel(new ImageIcon(createImage("ABC", 0.25))));

				frame.setVisible(true);
			}

		});

	}

}
