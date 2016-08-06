package com.raychen518.study.java.swing.gui.filechooser.examples;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;

import com.raychen518.study.java._util.Images;

public class ImageViewer {

	private static final String FRAME_TITLE = "Image Viewer";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static class ImagePreviewer extends JLabel {

		private static final long serialVersionUID = 1L;

		public ImagePreviewer(JFileChooser fileChooser) {
			setPreferredSize(new Dimension(150, 80));
			setBorder(BorderFactory.createTitledBorder("Image Previewer"));

			fileChooser.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent event) {
					if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(event.getPropertyName())) {
						File file = (File) event.getNewValue();

						if (file == null) {
							setIcon(null);
							return;
						}

						ImageIcon imageIcon = new ImageIcon(file.getPath());

						if (imageIcon.getIconWidth() > getWidth()) {
							imageIcon = new ImageIcon(
									imageIcon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
						}

						setIcon(imageIcon);
					}
				}

			});
		}
	}

	private static class FileIconView extends FileView {

		private FileFilter fileFilter;
		private Icon icon;

		public FileIconView(FileFilter fileFilter, Icon icon) {
			this.fileFilter = fileFilter;
			this.icon = icon;
		}

		@Override
		public Icon getIcon(File file) {
			if (!file.isDirectory() && fileFilter.accept(file)) {
				return icon;
			} else {
				return null;
			}
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JMenuBar menuBar = new JMenuBar();
				frame.setJMenuBar(menuBar);

				JMenu fileMenu = new JMenu("File");
				menuBar.add(fileMenu);

				JMenuItem openMenuItem = new JMenuItem("Open");
				fileMenu.add(openMenuItem);

				JLabel imageContainer = new JLabel();
				frame.add(imageContainer);

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter fileChooserFilter = new FileNameExtensionFilter(
						"Image Files (*.jpg, *.jpeg, *.gif)", "jpg", "jpeg", "gif");
				fileChooser.setFileFilter(fileChooserFilter);
				fileChooser.setAccessory(new ImagePreviewer(fileChooser));
				fileChooser.setFileView(new FileIconView(fileChooserFilter, new ImageIcon(Images.createImage(0.25))));

				openMenuItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						int fileChooserState = fileChooser.showOpenDialog(frame);
						if (fileChooserState == JFileChooser.APPROVE_OPTION) {
							String filePath = fileChooser.getSelectedFile().getPath();
							imageContainer.setIcon(new ImageIcon(filePath));
							frame.pack();
						}
					}

				});

				JMenuItem exitMenuItem = new JMenuItem("Exit");
				fileMenu.add(exitMenuItem);

				exitMenuItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						System.exit(0);
					}

				});

				frame.setVisible(true);
			}

		});
	}

}
