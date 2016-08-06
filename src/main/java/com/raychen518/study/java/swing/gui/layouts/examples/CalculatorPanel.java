package com.raychen518.study.java.swing.gui.layouts.examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton displayContainer;
	private JPanel panel;
	private double operationResult;
	private String lastOperation;
	private boolean newlyStarted;

	public CalculatorPanel() {
		setLayout(new BorderLayout());

		operationResult = 0;
		lastOperation = "=";
		newlyStarted = true;

		displayContainer = new JButton("0");
		displayContainer.setEnabled(false);
		add(displayContainer, BorderLayout.NORTH);

		ActionListener operandActionListener = new OperandActionListener();
		ActionListener operationActionListener = new OperationActionListener();

		panel = new JPanel();

		// Add the buttons in a 4x4 grid.
		panel.setLayout(new GridLayout(4, 4));

		addButton("7", operandActionListener);
		addButton("8", operandActionListener);
		addButton("9", operandActionListener);
		addButton("/", operationActionListener);

		addButton("4", operandActionListener);
		addButton("5", operandActionListener);
		addButton("6", operandActionListener);
		addButton("*", operationActionListener);

		addButton("1", operandActionListener);
		addButton("2", operandActionListener);
		addButton("3", operandActionListener);
		addButton("-", operationActionListener);

		addButton("0", operandActionListener);
		addButton(".", operandActionListener);
		addButton("=", operationActionListener);
		addButton("+", operationActionListener);

		add(panel, BorderLayout.CENTER);
	}

	/**
	 * <pre>
	 * Create a button using specified label and action listener,
	 * and then add it into the panel.
	 * </pre>
	 */
	private void addButton(String label, ActionListener actionListener) {
		JButton button = new JButton(label);
		button.addActionListener(actionListener);
		panel.add(button);
	}

	/**
	 * <pre>
	 * This class represents an action listener to update the operand.
	 * </pre>
	 */
	private class OperandActionListener implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) {
			String actionCommand = actionEvent.getActionCommand();

			if (newlyStarted) {
				displayContainer.setText("");
				newlyStarted = false;
			}

			displayContainer.setText(displayContainer.getText() + actionCommand);
		}
	}

	/**
	 * <pre>
	 * This class represents an action listener to perform the operation.
	 * </pre>
	 */
	private class OperationActionListener implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) {
			String actionCommand = actionEvent.getActionCommand();

			if (newlyStarted) {
				if (actionCommand.equals("-")) {
					displayContainer.setText(actionCommand);
					newlyStarted = false;
				} else
					lastOperation = actionCommand;
			} else {
				performOperation(Double.parseDouble(displayContainer.getText()));
				lastOperation = actionCommand;
				newlyStarted = true;
			}
		}
	}

	public void performOperation(double operand) {
		if (lastOperation.equals("+"))
			operationResult += operand;
		else if (lastOperation.equals("-"))
			operationResult -= operand;
		else if (lastOperation.equals("*"))
			operationResult *= operand;
		else if (lastOperation.equals("/"))
			operationResult /= operand;
		else if (lastOperation.equals("="))
			operationResult = operand;
		displayContainer.setText("" + operationResult);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setBounds(500, 320, 450, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new CalculatorPanel());
				frame.pack();
				frame.setVisible(true);
			}

		});
	}
}