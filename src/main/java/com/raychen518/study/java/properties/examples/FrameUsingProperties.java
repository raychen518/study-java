package com.raychen518.study.java.properties.examples;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameUsingProperties extends JFrame {

	private static final long serialVersionUID = -3146197131248379645L;

	private static final String PROPERTIES_FILE_DIRECTORY_BASE = System.getProperty("user.home");
	private static final String PROPERTIES_FILE_DIRECTORY_RELATIVE = ".propertiestest";
	private static final String PROPERTIES_FILE_NAME = "application.properties";
	private static final String PROPERTIES_FILE_COMMENT = "Application Properties";

	private static final String PROPERTY_KEY_FRAME_TITLE = "frame.title";
	private static final String PROPERTY_KEY_FRAME_LEFT = "frame.left";
	private static final String PROPERTY_KEY_FRAME_TOP = "frame.top";
	private static final String PROPERTY_KEY_FRAME_WIDTH = "frame.width";
	private static final String PROPERTY_KEY_FRAME_HEIGHT = "frame.height";

	private static final String FRAME_DEFAULT_TITLE = "";
	private static final int FRAME_DEFAULT_LEFT = 300;
	private static final int FRAME_DEFAULT_TOP = 80;
	private static final int FRAME_DEFAULT_WIDTH = 400;
	private static final int FRAME_DEFAULT_HEIGHT = 250;

	private static final String MESSAGE_PROVIDE_FRAME_TITLE = "Please provide a frame title:";

	private File propertiesFile;
	private Properties properties;

	public FrameUsingProperties() {
		// =================================================
		// Initialize Properties Using Defaults
		// =================================================
		Properties defaultProperties = new Properties();
		defaultProperties.put(PROPERTY_KEY_FRAME_TITLE, FRAME_DEFAULT_TITLE);
		defaultProperties.put(PROPERTY_KEY_FRAME_LEFT, String.valueOf(FRAME_DEFAULT_LEFT));
		defaultProperties.put(PROPERTY_KEY_FRAME_TOP, String.valueOf(FRAME_DEFAULT_TOP));
		defaultProperties.put(PROPERTY_KEY_FRAME_WIDTH, String.valueOf(FRAME_DEFAULT_WIDTH));
		defaultProperties.put(PROPERTY_KEY_FRAME_HEIGHT, String.valueOf(FRAME_DEFAULT_HEIGHT));
		properties = new Properties(defaultProperties);

		// =================================================
		// Load Properties from File
		// =================================================
		File propertiesFileDirectory = new File(PROPERTIES_FILE_DIRECTORY_BASE, PROPERTIES_FILE_DIRECTORY_RELATIVE);
		if (!propertiesFileDirectory.exists()) {
			propertiesFileDirectory.mkdir();
		}
		propertiesFile = new File(propertiesFileDirectory, PROPERTIES_FILE_NAME);

		if (propertiesFile.exists()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(propertiesFile);
				properties.load(fileInputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// =================================================
		// Apply Properties
		// =================================================
		String frameTitle = properties.getProperty(PROPERTY_KEY_FRAME_TITLE);
		if ("".equals(frameTitle)) {
			frameTitle = JOptionPane.showInputDialog(MESSAGE_PROVIDE_FRAME_TITLE);
		}
		if (frameTitle == null) {
			frameTitle = "";
		}
		setTitle(frameTitle);

		int frameLeft = Integer.parseInt(properties.getProperty(PROPERTY_KEY_FRAME_LEFT));
		int frameTop = Integer.parseInt(properties.getProperty(PROPERTY_KEY_FRAME_TOP));
		int frameWidth = Integer.parseInt(properties.getProperty(PROPERTY_KEY_FRAME_WIDTH));
		int frameHeight = Integer.parseInt(properties.getProperty(PROPERTY_KEY_FRAME_HEIGHT));
		setBounds(frameLeft, frameTop, frameWidth, frameHeight);

		// =================================================
		// Update Properties
		// =================================================
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent event) {
				properties.put(PROPERTY_KEY_FRAME_TITLE, getTitle());
				properties.put(PROPERTY_KEY_FRAME_LEFT, String.valueOf(getX()));
				properties.put(PROPERTY_KEY_FRAME_TOP, String.valueOf(getY()));
				properties.put(PROPERTY_KEY_FRAME_WIDTH, String.valueOf(getWidth()));
				properties.put(PROPERTY_KEY_FRAME_HEIGHT, String.valueOf(getHeight()));

				try {
					FileOutputStream fileOutputStream = new FileOutputStream(propertiesFile);
					properties.store(fileOutputStream, PROPERTIES_FILE_COMMENT);
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.exit(0);
			}

		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new FrameUsingProperties();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}

		});
	}

}
