package com.raychen518.study.java.swing.gui.dialogs.examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.raychen518.study.java._util.Images;

public class DialogTestFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	// =================================
	// Various Titles and Names
	// =================================
	private static final String TEST_OPTIONS_PANEL_TITLE_DIALOG_TYPE = "Dialog Type";
	private static final String TEST_OPTIONS_PANEL_TITLE_MESSAGE_TYPE = "Message Type";
	private static final String TEST_OPTIONS_PANEL_TITLE_MESSAGE_DATA_TYPE = "Message Data Type";
	private static final String TEST_OPTIONS_PANEL_TITLE_OPTION_TYPE = "Option Type";
	private static final String TEST_OPTIONS_PANEL_TITLE_OPTION_DATA_TYPE = "Option Data Type";
	private static final String TEST_OPTIONS_PANEL_TITLE_INPUT_FIELD_TYPE = "Input Field Type";

	private static final String DIALOG_DEFAULT_TITLE = "Dialog";
	private static final String SHOW_DIALOG_BUTTON_NAME = "Show Dialog";

	// =================================
	// Dialog Types
	// =================================
	private static final String DIALOG_TYPE_MESSAGE = "Message";
	private static final String DIALOG_TYPE_CONFIRM = "Confirm";
	private static final String DIALOG_TYPE_OPTION = "Option";
	private static final String DIALOG_TYPE_INPUT = "Input";
	private static final String[] DIALOG_TYPES = new String[] { DIALOG_TYPE_MESSAGE, DIALOG_TYPE_CONFIRM,
			DIALOG_TYPE_OPTION, DIALOG_TYPE_INPUT };

	// =================================
	// Message Types
	// =================================
	private static final String[] MESSAGE_TYPES = new String[] { "INFORMATION_MESSAGE", "WARNING_MESSAGE",
			"ERROR_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE" };

	// =================================
	// Message Data Types
	// =================================
	private static final String[] MESSAGE_DATA_TYPES = new String[] { "String", "Icon", "Component", "Other",
			"Object[]" };

	// =================================
	// Option Types
	// =================================
	private static final String[] OPTION_TYPES = new String[] { "DEFAULT_OPTION", "YES_NO_OPTION",
			"YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION" };

	// =================================
	// Option Data Types
	// =================================
	private static final String OPTION_DATA_TYPE_NULL = "null";
	private static final String[] OPTION_DATA_TYPES = new String[] { OPTION_DATA_TYPE_NULL, "String[]", "Icon[]",
			"Object[]" };

	// =================================
	// Input Field Types
	// =================================
	private static final String INPUT_FIELD_TYPE_TEXT_FIELD = "Text Field";
	private static final String INPUT_FIELD_TYPE_COMBO_BOX = "Combo Box";
	private static final String[] INPUT_FIELD_TYPES = new String[] { INPUT_FIELD_TYPE_TEXT_FIELD,
			INPUT_FIELD_TYPE_COMBO_BOX };

	// =================================
	// Message Samples
	// =================================
	private static final String MESSAGE_SAMPLE_STRING = "Sample Message";
	private static final Icon MESSAGE_SAMPLE_ICON = new ImageIcon(Images.createImage());
	private static final JComponent MESSAGE_SAMPLE_COMPONENT = new JComboBox<String>(
			new String[] { "Item 1", "Item 2", "Item 3" });
	private static final Object MESSAGE_SAMPLE_OTHER = new Date();
	private static final Object[] MESSAGE_SAMPLE_OBJECTS = new Object[] { MESSAGE_SAMPLE_STRING, MESSAGE_SAMPLE_ICON,
			MESSAGE_SAMPLE_COMPONENT, MESSAGE_SAMPLE_OTHER };
	private static final Object[] MESSAGE_SAMPLES = new Object[] { MESSAGE_SAMPLE_STRING, MESSAGE_SAMPLE_ICON,
			MESSAGE_SAMPLE_COMPONENT, MESSAGE_SAMPLE_OTHER, MESSAGE_SAMPLE_OBJECTS };

	// =================================
	// Options Samples
	// =================================
	private static final String[] OPTION_SAMPLE_STRINGS = new String[] { "Red", "Green", "Blue" };
	private static final Icon[] OPTION_SAMPLE_ICONS = new Icon[] { new ImageIcon(Images.createImage("ABC")),
			new ImageIcon(Images.createImage("DEF")), new ImageIcon(Images.createImage("GHI")) };
	private static final Object[] OPTION_SAMPLE_OBJECTS = new Object[] { "Option 1", new JButton("Option 2"),
			new JComboBox<String>(new String[] { "Option 31", "Option 32", "Option 33" }) };
	private static final Object[][] OPTION_SAMPLES = new Object[][] { null, OPTION_SAMPLE_STRINGS, OPTION_SAMPLE_ICONS,
			OPTION_SAMPLE_OBJECTS };

	private TestOptionsPanel testOptionsPanelDialogType;
	private TestOptionsPanel testOptionsPanelMessageType;
	private TestOptionsPanel testOptionsPanelMessageDataType;
	private TestOptionsPanel testOptionsPanelOptionType;
	private TestOptionsPanel testOptionsPanelOptionDataType;
	private TestOptionsPanel testOptionsPanelInputFieldType;

	public DialogTestFrame() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 3));

		testOptionsPanelDialogType = new TestOptionsPanel(TEST_OPTIONS_PANEL_TITLE_DIALOG_TYPE, DIALOG_TYPES);
		testOptionsPanelMessageType = new TestOptionsPanel(TEST_OPTIONS_PANEL_TITLE_MESSAGE_TYPE, MESSAGE_TYPES);
		testOptionsPanelMessageDataType = new TestOptionsPanel(TEST_OPTIONS_PANEL_TITLE_MESSAGE_DATA_TYPE,
				MESSAGE_DATA_TYPES);
		testOptionsPanelOptionType = new TestOptionsPanel(TEST_OPTIONS_PANEL_TITLE_OPTION_TYPE, OPTION_TYPES);
		testOptionsPanelOptionDataType = new TestOptionsPanel(TEST_OPTIONS_PANEL_TITLE_OPTION_DATA_TYPE,
				OPTION_DATA_TYPES);
		testOptionsPanelInputFieldType = new TestOptionsPanel(TEST_OPTIONS_PANEL_TITLE_INPUT_FIELD_TYPE,
				INPUT_FIELD_TYPES);

		centerPanel.add(testOptionsPanelDialogType);
		centerPanel.add(testOptionsPanelMessageType);
		centerPanel.add(testOptionsPanelMessageDataType);
		centerPanel.add(testOptionsPanelOptionType);
		centerPanel.add(testOptionsPanelOptionDataType);
		centerPanel.add(testOptionsPanelInputFieldType);

		testOptionsPanelDialogType.clickButton(DIALOG_TYPE_MESSAGE);

		JPanel southPanel = new JPanel();
		JButton showDialogButton = new JButton(SHOW_DIALOG_BUTTON_NAME);
		showDialogButton.addActionListener(new ShowingDialogAction());
		southPanel.add(showDialogButton);

		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		pack();
	}

	private class TestOptionsPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		private ButtonGroup buttonGroup;

		public TestOptionsPanel(String title, String... options) {
			setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			boolean creatingDialogTypePanel = TEST_OPTIONS_PANEL_TITLE_DIALOG_TYPE.equals(title);
			boolean creatingOptionDataTypePanel = TEST_OPTIONS_PANEL_TITLE_OPTION_DATA_TYPE.equals(title);

			buttonGroup = new ButtonGroup();
			for (String option : options) {
				JRadioButton button = new JRadioButton(option);
				button.setActionCommand(option);

				if (creatingDialogTypePanel) {
					button.addActionListener(new ChangingDialogTypeAction());
				}

				if (creatingOptionDataTypePanel) {
					button.addActionListener(new ChangingOptionDataTypeAction());
				}

				add(button);
				buttonGroup.add(button);
			}

		}

		public String getSelectionActionCommand() {
			return buttonGroup.getSelection().getActionCommand();
		}

		public void resetSelection() {
			for (Enumeration<AbstractButton> elements = buttonGroup.getElements(); elements.hasMoreElements();) {
				elements.nextElement().setSelected(true);
				break;
			}
		}

		public void clickButton(String actionCommand) {
			AbstractButton element;
			for (Enumeration<AbstractButton> elements = buttonGroup.getElements(); elements.hasMoreElements();) {
				element = elements.nextElement();
				if (element.getActionCommand().equals(actionCommand)) {
					element.doClick();
					break;
				}
			}
		}

		public void enableButtons(boolean enabled) {
			for (Enumeration<AbstractButton> elements = buttonGroup.getElements(); elements.hasMoreElements();) {
				elements.nextElement().setEnabled(enabled);
			}
		}

	}

	private void resetTestOptionsPanels(String dialogType) {
		testOptionsPanelMessageType.resetSelection();
		testOptionsPanelMessageDataType.resetSelection();
		testOptionsPanelOptionType.resetSelection();
		testOptionsPanelOptionDataType.resetSelection();
		testOptionsPanelInputFieldType.resetSelection();

		testOptionsPanelOptionType.enableButtons(false);
		testOptionsPanelOptionDataType.enableButtons(false);
		testOptionsPanelInputFieldType.enableButtons(false);

		switch (dialogType) {
		case DIALOG_TYPE_MESSAGE:
			break;

		case DIALOG_TYPE_CONFIRM:
			testOptionsPanelOptionType.enableButtons(true);
			break;

		case DIALOG_TYPE_OPTION:
			testOptionsPanelOptionType.enableButtons(true);
			testOptionsPanelOptionDataType.enableButtons(true);
			break;

		case DIALOG_TYPE_INPUT:
			testOptionsPanelInputFieldType.enableButtons(true);
			break;

		default:
			break;
		}
	}

	public int getMessageOrOptionType(TestOptionsPanel testOptionsPanel) {
		String messageOrOptionType = testOptionsPanel.getSelectionActionCommand();
		int messageOrOptionTypeValue;

		try {
			messageOrOptionTypeValue = JOptionPane.class.getField(messageOrOptionType).getInt(null);
		} catch (Exception exception) {
			messageOrOptionTypeValue = -1;
		}

		return messageOrOptionTypeValue;
	}

	public Object getMessageSample(String messageDataType) {
		int messageDataTypeIndex = Arrays.asList(MESSAGE_DATA_TYPES).indexOf(messageDataType);
		return MESSAGE_SAMPLES[messageDataTypeIndex];
	}

	public Object[] getOptionsSample(String optionDataType) {
		int optionDataTypeIndex = Arrays.asList(OPTION_DATA_TYPES).indexOf(optionDataType);
		return OPTION_SAMPLES[optionDataTypeIndex];
	}

	private class ChangingDialogTypeAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			resetTestOptionsPanels(event.getActionCommand());
		}

	}

	private class ChangingOptionDataTypeAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			switch (event.getActionCommand()) {
			case OPTION_DATA_TYPE_NULL:
				testOptionsPanelOptionType.enableButtons(true);
				break;

			default:
				testOptionsPanelOptionType.enableButtons(false);
				break;
			}
		}

	}

	private class ShowingDialogAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			Object messageSample = getMessageSample(testOptionsPanelMessageDataType.getSelectionActionCommand());

			switch (testOptionsPanelDialogType.getSelectionActionCommand()) {
			case DIALOG_TYPE_MESSAGE:
				JOptionPane.showMessageDialog(DialogTestFrame.this, messageSample, DIALOG_DEFAULT_TITLE,
						getMessageOrOptionType(testOptionsPanelMessageType));
				break;

			case DIALOG_TYPE_CONFIRM:
				JOptionPane.showConfirmDialog(DialogTestFrame.this, messageSample, DIALOG_DEFAULT_TITLE,
						getMessageOrOptionType(testOptionsPanelOptionType),
						getMessageOrOptionType(testOptionsPanelMessageType));
				break;

			case DIALOG_TYPE_OPTION:
				Object[] options = getOptionsSample(testOptionsPanelOptionDataType.getSelectionActionCommand());
				Object initialOption = (options == null) ? null : options[0];
				JOptionPane.showOptionDialog(DialogTestFrame.this, messageSample, DIALOG_DEFAULT_TITLE,
						getMessageOrOptionType(testOptionsPanelOptionType),
						getMessageOrOptionType(testOptionsPanelMessageType), null, options, initialOption);
				break;

			case DIALOG_TYPE_INPUT:
				switch (testOptionsPanelInputFieldType.getSelectionActionCommand()) {
				case INPUT_FIELD_TYPE_TEXT_FIELD:
					JOptionPane.showInputDialog(DialogTestFrame.this, messageSample, DIALOG_DEFAULT_TITLE,
							getMessageOrOptionType(testOptionsPanelMessageType));
					break;

				case INPUT_FIELD_TYPE_COMBO_BOX:
					String[] selectionValues = new String[] { "Red", "Green", "Blue" };
					JOptionPane.showInputDialog(DialogTestFrame.this, messageSample, DIALOG_DEFAULT_TITLE,
							getMessageOrOptionType(testOptionsPanelMessageType), null, selectionValues,
							selectionValues[1]);
					break;

				default:
					break;
				}
				break;

			default:
				break;
			}
		}

	}

	private static final String FRAME_TITLE = "Dialog Test";
	private static final int FRAME_DEFAULT_COORDINATE_X = 300;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 80;
	private static final int FRAME_DEFAULT_WIDTH = 600;
	private static final int FRAME_DEFAULT_HEIGHT = 400;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new DialogTestFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.setVisible(true);
			}

		});
	}

	// JOptionPane.INFORMATION_MESSAGE : 1
	// JOptionPane.WARNING_MESSAGE : 2
	// JOptionPane.ERROR_MESSAGE : 0
	// JOptionPane.QUESTION_MESSAGE : 3
	// JOptionPane.PLAIN_MESSAGE : -1

	// JOptionPane.DEFAULT_OPTION : -1
	// JOptionPane.YES_NO_OPTION : 0
	// JOptionPane.YES_NO_CANCEL_OPTION : 1
	// JOptionPane.OK_CANCEL_OPTION : 2

}
