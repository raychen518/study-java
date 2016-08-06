package com.raychen518.study.java.innerclass.examples;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TalkingClock {

	private int interval;
	private boolean beep;

	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	public void start() {
		// The complete form of below statement "new TimePrinter()" is:
		// this.new TimePrinter() or
		// new TalkingClock.TimePrinter().
		// "new TimePrinter()" is the abbreviated form.
		ActionListener actionListener = new TimePrinter();
		Timer timer = new Timer(interval, actionListener);
		timer.start();
	}

	private class TimePrinter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Date currentDateTime = new Date();
			System.out.println("Current Date & Time: " + currentDateTime);

			// The inner class can access states of its outer class.
			// Here, the private field "beep" of the class TalkingClock,
			// which is the outer class of current class TimePrinter,
			// is accessed.
			//
			// The complete form of below statement "beep" is:
			// TalkingClock.this.beep.
			// "beep" is the abbreviated form.
			if (beep) {
				Toolkit.getDefaultToolkit().beep();
			}
		}

	}

	public static void main(String[] args) {
		//ClassAnalyzer.print(TalkingClock.class);
		//ClassAnalyzer.print(TalkingClock.TimePrinter.class);

		TalkingClock talkingClock = new TalkingClock(1500, true);
		talkingClock.start();

		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
	}

}
