package com.raychen518.study.java.swing.gui.filechooser;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Test {

	private static final String FRAME_TITLE = "Test - File Chooser";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final String BUTTON_TEXT_PREFIX = "Button ";

	public static void main(String[] args) {
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

				int buttonCounter = 0;

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							fileChooser.showOpenDialog(null);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
							fileChooser.showOpenDialog(frame);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home")));
							fileChooser.showOpenDialog(button);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
							fileChooser.showOpenDialog(null);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"),
									FileSystemView.getFileSystemView());
							int fileChooserState = fileChooser.showOpenDialog(null);
							System.out.println("fileChooserState: " + fileChooserState);
							System.out.println("fileChooserState == JFileChooser.CANCEL_OPTION: "
									+ (fileChooserState == JFileChooser.CANCEL_OPTION));
							System.out.println("fileChooserState == JFileChooser.APPROVE_OPTION: "
									+ (fileChooserState == JFileChooser.APPROVE_OPTION));
							System.out.println("fileChooserState == JFileChooser.ERROR_OPTION: "
									+ (fileChooserState == JFileChooser.ERROR_OPTION));
							System.out.println();

							if (fileChooserState == JFileChooser.APPROVE_OPTION) {
								String filePath = fileChooser.getSelectedFile().getPath();
								System.out.println("The file " + filePath + " has been selected.");
							}
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							System.out
									.println("fileChooser.getCurrentDirectory(): " + fileChooser.getCurrentDirectory());
							fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
							System.out
									.println("fileChooser.getCurrentDirectory(): " + fileChooser.getCurrentDirectory());
							fileChooser.showOpenDialog(null);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
							File file = new File(".project");
							if (file.exists()) {
								fileChooser.setSelectedFile(file);
							}
							fileChooser.showOpenDialog(null);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							fileChooser.setMultiSelectionEnabled(true);
							int fileChooserState = fileChooser.showOpenDialog(null);
							if (fileChooserState == JFileChooser.APPROVE_OPTION) {
								System.out.println("The following files have been selected.");
								for (File file : fileChooser.getSelectedFiles()) {
									System.out.println("\t" + file.getPath());
								}
							}
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
							int fileChooserState = fileChooser.showOpenDialog(null);
							if (fileChooserState == JFileChooser.APPROVE_OPTION) {
								File file = fileChooser.getSelectedFile();

								String fileTypeDescription = "<Unknown>";

								if (file.isDirectory()) {
									fileTypeDescription = "directory";
								}

								if (file.isFile()) {
									fileTypeDescription = "file";
								}

								System.out.println(
										"The " + fileTypeDescription + " " + file.getPath() + " has been selected.");
							}
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							fileChooser.setFileFilter(
									new FileNameExtensionFilter("Documents (*.doc, *.txt)", "doc", "txt"));
							fileChooser.showOpenDialog(null);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							fileChooser.setAcceptAllFileFilterUsed(false);
							fileChooser.setFileFilter(new FileNameExtensionFilter("Documents (*.doc)", "doc"));
							fileChooser.showOpenDialog(null);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							fileChooser.addPropertyChangeListener(new PropertyChangeListener() {

								@Override
								public void propertyChange(PropertyChangeEvent event) {
									if (event.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
										File file = (File) event.getNewValue();
										if (file != null) {
											System.out.println(
													"The selected file has been changed to " + file.getPath() + ".");
										}
									}
								}

							});

							fileChooser.showOpenDialog(null);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							fileChooser.showSaveDialog(null);
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							int fileChooserState = fileChooser.showSaveDialog(frame);
							System.out.println("fileChooserState: " + fileChooserState);
							System.out.println("fileChooserState == JFileChooser.CANCEL_OPTION: "
									+ (fileChooserState == JFileChooser.CANCEL_OPTION));
							System.out.println("fileChooserState == JFileChooser.APPROVE_OPTION: "
									+ (fileChooserState == JFileChooser.APPROVE_OPTION));
							System.out.println("fileChooserState == JFileChooser.ERROR_OPTION: "
									+ (fileChooserState == JFileChooser.ERROR_OPTION));
							System.out.println();

							if (fileChooserState == JFileChooser.APPROVE_OPTION) {
								String filePath = fileChooser.getSelectedFile().getPath();
								System.out.println("The file " + filePath + " has been selected.");
								System.out.println();
							}
						}

					});
					panel.add(button);
				}

				{
					JButton button = new JButton(BUTTON_TEXT_PREFIX + (++buttonCounter));
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							JFileChooser fileChooser = new JFileChooser();
							int fileChooserState = fileChooser.showDialog(null, "Choose Some File");

							System.out.println("fileChooserState: " + fileChooserState);
							System.out.println("fileChooserState == JFileChooser.CANCEL_OPTION: "
									+ (fileChooserState == JFileChooser.CANCEL_OPTION));
							System.out.println("fileChooserState == JFileChooser.APPROVE_OPTION: "
									+ (fileChooserState == JFileChooser.APPROVE_OPTION));
							System.out.println("fileChooserState == JFileChooser.ERROR_OPTION: "
									+ (fileChooserState == JFileChooser.ERROR_OPTION));
							System.out.println();

							if (fileChooserState == JFileChooser.APPROVE_OPTION) {
								String filePath = fileChooser.getSelectedFile().getPath();
								System.out.println("The file " + filePath + " has been selected.");
								System.out.println();
							}
						}

					});
					panel.add(button);
				}

				frame.setVisible(true);
			}

		});
	}

}
