package com.raychen518.study.java.swing.gui.comboboxes;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboBoxTest {

	private static final String FRAME_TITLE = "Test - Combo Box";
	private static final int FRAME_DEFAULT_WIDTH = 420;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

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

				{
					JComboBox<String> comboBox = new JComboBox<>();
					comboBox.addItem("Item 1");
					comboBox.addItem("Item 2");
					comboBox.addItem("Item 3");
					panel.add(comboBox);
				}

				{
					JComboBox<Integer> comboBox = new JComboBox<>();
					comboBox.addItem(1);
					comboBox.addItem(2);
					comboBox.addItem(3);
					comboBox.setSelectedItem(2);
					panel.add(comboBox);
				}

				{
					JComboBox<String> comboBox = new JComboBox<>(new String[] { "Item 1", "Item 2", "Item 3" });
					comboBox.setSelectedIndex(1);
					panel.add(comboBox);
				}

				{
					JComboBox<String> comboBox = new JComboBox<>(new String[] { "Item 1", "Item 2", "Item 3" });
					comboBox.setForeground(Color.RED);
					comboBox.setBackground(Color.CYAN);
					panel.add(comboBox);
				}

				{
					JComboBox<String> comboBox = new JComboBox<>(new String[] { "Item 1", "Item 2", "Item 3" });
					comboBox.setEditable(true);
					panel.add(comboBox);
				}

				{
					JComboBox<String> comboBox = new JComboBox<>(new String[] { "Item 1", "Item 2", "Item 3" });
					System.out.println("comboBox.getSelectedIndex(): " + comboBox.getSelectedIndex());
					System.out.println("comboBox.getSelectedItem(): " + comboBox.getSelectedItem());
					System.out.println("comboBox.getItemAt(comboBox.getSelectedIndex()): "
							+ comboBox.getItemAt(comboBox.getSelectedIndex()));
					panel.add(comboBox);
				}

				{
					JComboBox<String> comboBox = new JComboBox<>(
							new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" });
					comboBox.removeItemAt(3);
					comboBox.removeItem("Item 2");
					panel.add(comboBox);
				}

				{
					JComboBox<String> comboBox = new JComboBox<>(new String[] { "Item 1", "Item 2", "Item 3" });
					comboBox.insertItemAt("Item 21", 2);
					panel.add(comboBox);
				}

				{
					JComboBox<String> comboBox = new JComboBox<>(new String[] { "Item 1", "Item 2", "Item 3" });
					comboBox.removeAllItems();
					comboBox.setEnabled(false);
					panel.add(comboBox);
				}

				frame.setVisible(true);
			}

		});
	}

}
