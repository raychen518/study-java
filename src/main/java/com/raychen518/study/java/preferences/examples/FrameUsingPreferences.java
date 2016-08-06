package com.raychen518.study.java.preferences.examples;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameUsingPreferences extends JFrame {

	private static final long serialVersionUID = 4436770619438536172L;

	private static final String PREFERENCE_KEY_FRAME_TITLE = "frame.title";
	private static final String PREFERENCE_KEY_FRAME_LEFT = "frame.left";
	private static final String PREFERENCE_KEY_FRAME_TOP = "frame.top";
	private static final String PREFERENCE_KEY_FRAME_WIDTH = "frame.width";
	private static final String PREFERENCE_KEY_FRAME_HEIGHT = "frame.height";

	private static final String FRAME_DEFAULT_TITLE = "";
	private static final int FRAME_DEFAULT_LEFT = 300;
	private static final int FRAME_DEFAULT_TOP = 80;
	private static final int FRAME_DEFAULT_WIDTH = 400;
	private static final int FRAME_DEFAULT_HEIGHT = 250;

	private static final String MESSAGE_PROVIDE_FRAME_TITLE = "Please provide a frame title:";

	private Preferences preferences;

	public FrameUsingPreferences() throws HeadlessException, BackingStoreException {
		// =================================================
		// Load Preferences
		// =================================================
		preferences = Preferences.userNodeForPackage(this.getClass());

		// =================================================
		// Apply Preferences
		// =================================================
		String frameTitle = null;
		if (Arrays.binarySearch(preferences.keys(), PREFERENCE_KEY_FRAME_TITLE) < 0) {
			frameTitle = JOptionPane.showInputDialog(MESSAGE_PROVIDE_FRAME_TITLE);
			if (frameTitle == null) {
				frameTitle = FRAME_DEFAULT_TITLE;
			}
		} else {
			frameTitle = preferences.get(PREFERENCE_KEY_FRAME_TITLE, FRAME_DEFAULT_TITLE);
		}
		setTitle(frameTitle);

		int frameLeft = preferences.getInt(PREFERENCE_KEY_FRAME_LEFT, FRAME_DEFAULT_LEFT);
		int frameTop = preferences.getInt(PREFERENCE_KEY_FRAME_TOP, FRAME_DEFAULT_TOP);
		int frameWidth = preferences.getInt(PREFERENCE_KEY_FRAME_WIDTH, FRAME_DEFAULT_WIDTH);
		int frameHeight = preferences.getInt(PREFERENCE_KEY_FRAME_HEIGHT, FRAME_DEFAULT_HEIGHT);
		setBounds(frameLeft, frameTop, frameWidth, frameHeight);

		// =================================================
		// Update Preferences
		// =================================================
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent event) {
				preferences.put(PREFERENCE_KEY_FRAME_TITLE, getTitle());
				preferences.putInt(PREFERENCE_KEY_FRAME_LEFT, getX());
				preferences.putInt(PREFERENCE_KEY_FRAME_TOP, getY());
				preferences.putInt(PREFERENCE_KEY_FRAME_WIDTH, getWidth());
				preferences.putInt(PREFERENCE_KEY_FRAME_HEIGHT, getHeight());

				System.exit(0);
			}

		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					JFrame frame = new FrameUsingPreferences();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (HeadlessException | BackingStoreException e) {
					e.printStackTrace();
				}
			}

		});
	}

}
