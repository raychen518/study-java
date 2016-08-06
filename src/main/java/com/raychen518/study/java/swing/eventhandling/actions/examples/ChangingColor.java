package com.raychen518.study.java.swing.eventhandling.actions.examples;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ChangingColor {

	private static final String FRAME_TITLE = "Example - Changing Color";
	private static final int FRAME_DEFAULT_WIDTH = 400;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	private static final String ACTION_MAP_KEY_BUTTON_RED = "buttonRed";
	private static final String ACTION_MAP_KEY_BUTTON_GREEN = "buttonGreen";
	private static final String ACTION_MAP_KEY_BUTTON_BLUE = "buttonBlue";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setSize(FRAME_DEFAULT_WIDTH, FRAME_DEFAULT_HEIGHT);
				frame.setLocation(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel buttonPanel = new JPanel();

				Action redAction = new ColorAction("Red", null, Color.RED, buttonPanel);
				Action greenAction = new ColorAction("Green", null, Color.GREEN, buttonPanel);
				Action blueAction = new ColorAction("Blue", null, Color.BLUE, buttonPanel);

				buttonPanel.add(new JButton(redAction));
				buttonPanel.add(new JButton(greenAction));
				buttonPanel.add(new JButton(blueAction));

				frame.add(buttonPanel);

				InputMap inputMap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
				inputMap.put(KeyStroke.getKeyStroke("ctrl R"), ACTION_MAP_KEY_BUTTON_RED);
				inputMap.put(KeyStroke.getKeyStroke("ctrl G"), ACTION_MAP_KEY_BUTTON_GREEN);
				inputMap.put(KeyStroke.getKeyStroke("ctrl B"), ACTION_MAP_KEY_BUTTON_BLUE);

				ActionMap actionMap = buttonPanel.getActionMap();
				actionMap.put(ACTION_MAP_KEY_BUTTON_RED, redAction);
				actionMap.put(ACTION_MAP_KEY_BUTTON_GREEN, greenAction);
				actionMap.put(ACTION_MAP_KEY_BUTTON_BLUE, blueAction);

				frame.setVisible(true);
			}

		});
	}

	private static class ColorAction extends AbstractAction {

		private static final long serialVersionUID = 1L;

		private static final String SHORT_DESCRIPTION_MAIN = "Set Panel Color to ";
		private static final String ITEM_NAME_COLOR = "color";
		private static final String ITEM_NAME_CONTAINER = "container";

		public ColorAction(String name, Icon icon, Color color, JComponent container) {
			// The value which is put into the item Action.NAME
			// is automatically used by the system to generate the name of the
			// action component (such as a button or a menu).
			putValue(Action.NAME, name);

			// The value which is put into the item Action.SMALL_ICON
			// is automatically used by the system to generate the icon of the
			// action component (such as a button or a menu).
			putValue(Action.SMALL_ICON, icon);

			// The value which is put into the item Action.SHORT_DESCRIPTION
			// is automatically used by the system to generate the tooltip of
			// the action component.
			putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION_MAIN + name);

			putValue(ITEM_NAME_COLOR, color);
			putValue(ITEM_NAME_CONTAINER, container);
		}

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			JComponent container = (JComponent) getValue(ITEM_NAME_CONTAINER);
			container.setBackground((Color) getValue(ITEM_NAME_COLOR));
		}

	}

}
