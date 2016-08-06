package com.raychen518.study.java.deployment.resources;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {

	private static final String TEXT_RESOURCE_NAME = "test.txt";
	private static final String IMAGE_RESOURCE_NAME = "test.png";
	private static final String TEXT_RESOURCE_2_NAME = "temp/test.txt";

	public String getTextResource() {
		URL textResourceUrl = Test.class.getResource(TEXT_RESOURCE_NAME);
		System.out.println("textResourceUrl.toString(): " + textResourceUrl.toString());

		InputStream textResourceStream = Test.class.getResourceAsStream(TEXT_RESOURCE_NAME);
		Scanner textResourceScanner = new Scanner(textResourceStream);

		String text = null;
		while (textResourceScanner.hasNext()) {
			text = textResourceScanner.next();
		}
		textResourceScanner.close();

		return text;
	}

	public Image getImageResource() {
		URL imageResourceUrl = Test.class.getResource(IMAGE_RESOURCE_NAME);
		System.out.println("imageResourceUrl.toString(): " + imageResourceUrl.toString());

		Image image = new ImageIcon(imageResourceUrl).getImage();
		// Another alternative to get the image from image URL is as follows.
		// Image image = ImageIO.read(imageResourceUrl);

		return image;
	}

	public String getTextResource2() {
		URL textResourceUrl = Test.class.getResource(TEXT_RESOURCE_2_NAME);
		System.out.println("textResourceUrl.toString(): " + textResourceUrl.toString());

		InputStream textResourceStream = Test.class.getResourceAsStream(TEXT_RESOURCE_2_NAME);
		Scanner textResourceScanner = new Scanner(textResourceStream);

		String text = null;
		while (textResourceScanner.hasNext()) {
			text = textResourceScanner.next();
		}
		textResourceScanner.close();

		return text;
	}

	private static final String FRAME_TITLE = "Test - Resources";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 360;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 200;

	public static void main(String[] args) {
		Test test = new Test();

		System.out.println("test.getTextResource2(): " + test.getTextResource2());
		System.out.println();

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				frame.add(panel);

				JLabel textLabel = new JLabel(test.getTextResource());
				panel.add(textLabel);

				JLabel imageLabel = new JLabel(new ImageIcon(test.getImageResource()));
				panel.add(imageLabel);

				frame.setVisible(true);
			}

		});
	}

}
