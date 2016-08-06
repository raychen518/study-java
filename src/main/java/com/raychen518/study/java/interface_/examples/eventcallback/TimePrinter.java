package com.raychen518.study.java.interface_.examples.eventcallback;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimePrinter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Date currentDateTime = new Date();
		System.out.println("Current Date & Time: " + currentDateTime);
		Toolkit.getDefaultToolkit().beep();
	}

	public static void main(String[] args) {
		ActionListener actionListener = new TimePrinter();
		Timer timer = new Timer(3000, actionListener);
		timer.start();

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}
