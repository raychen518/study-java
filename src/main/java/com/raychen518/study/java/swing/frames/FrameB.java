package com.raychen518.study.java.swing.frames;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * <pre>
 * This class shows how to display a simple custom frame with common settings.
 * </pre>
 */
public class FrameB extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String TITLE = "Frame Test";
	private static final String ICON_IMAGE_PATH = "icon.gif";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				FrameB frame = new FrameB();

				// =========================================
				// Set the Title
				// =========================================
				frame.setTitle(TITLE);

				// =========================================
				// Set the Default Close Operation
				// =========================================
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// =========================================
				// Set the Size
				// =========================================
				// The following statements set a proper size for the frame.
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setSize(screenSize.width / 2, screenSize.height / 2);

				// The following statement makes the frame fully maximized (both
				// horizontally and vertically).
				// frame.setExtendedState(Frame.MAXIMIZED_BOTH);

				// =========================================
				// Set the Location
				// =========================================
				frame.setLocationByPlatform(true);

				// =========================================
				// Set the Icon Image
				// =========================================
				// The following statements to set an icon image
				// actually don't work
				// since the icon image is not put in proper location.
				// These statements just show how to set an icon image for an
				// frame.
				Image image = new ImageIcon(ICON_IMAGE_PATH).getImage();
				frame.setIconImage(image);

				// =========================================
				// Set the Resizable Feature
				// =========================================
				frame.setResizable(false);

				// =========================================
				// Set the Visibility
				// =========================================
				frame.setVisible(true);
			}

		});
	}

}
