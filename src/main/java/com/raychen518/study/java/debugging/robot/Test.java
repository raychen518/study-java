package com.raychen518.study.java.debugging.robot;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ButtonFrame();
				frame.setTitle("Button Frame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice screen = environment.getDefaultScreenDevice();

		try {
			// Attach a robot to the screen.
			Robot robot = new Robot(screen);
			robot.waitForIdle();
			new Thread() {
				public void run() {
					runTest(robot);
				};
			}.start();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void runTest(Robot robot) {
		// Simulate a Space Bar press and release over the button Red.
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);

		// TODO The button Green is clicked (pressed as Space) due to unknown
		// reason.
		// Simulate a Tab press and release over the button Green.
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		// Simulate a Space Bar press and release over the button Blue.
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);

		// Simulate a mouse click (press and release) over the button Blue.
		robot.delay(2000);
		robot.mouseMove(220, 40);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

		// Create the screenshot.
		robot.delay(2000);
		BufferedImage screenshot = robot.createScreenCapture(new Rectangle(0, 0, 400, 300));

		// Show the screenshot.
		ImageFrame frame = new ImageFrame(screenshot);
		frame.setVisible(true);
	}
}

class ImageFrame extends JFrame {

	private static final long serialVersionUID = -8705340751340546080L;

	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;

	public ImageFrame(Image image) {
		setTitle("Image Frame");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		JLabel label = new JLabel(new ImageIcon(image));
		add(label);
	}
}
