package com.raychen518.study.java.multithreading.examples.testinginterruption;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <pre>
 * This class demonstrates how to interrupt a running thread.
 * </pre>
 */
public class Test1 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle("Interruption Test");
				frame.setLocation(650, 150);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				frame.add(panel, BorderLayout.CENTER);
				panel.setPreferredSize(new Dimension(270, 50));

				final Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						long timeCounter = 0;
						while (!Thread.currentThread().isInterrupted()) {
							if (++timeCounter == 2000000000L) {
								System.out.println(new Date() + ": The thread is doing something...");
								timeCounter = 0;
							}
						}
					}

				});

				JButton buttonStartThread = new JButton("Start Thread");
				panel.add(buttonStartThread);
				buttonStartThread.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						System.out.println("thread: " + thread);
						System.out.println("thread.isInterrupted()\t\t\t: " + thread.isInterrupted());
						System.out.println("thread.getState() <before Starting>\t: " + thread.getState());
						thread.start();
						System.out.println("thread.getState() <after Starting>\t: " + thread.getState());
						System.out.println("thread.isInterrupted()\t\t\t: " + thread.isInterrupted());
						System.out.println();
					}

				});

				JButton buttonInterruptThread = new JButton("Interrupt Thread");
				panel.add(buttonInterruptThread);
				buttonInterruptThread.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						System.out.println();
						System.out.println("thread: " + thread);
						System.out.println("thread.isInterrupted()\t\t\t: " + thread.isInterrupted());
						System.out.println("thread.getState() <before Interrupting>\t: " + thread.getState());
						thread.interrupt();
						System.out.println("thread.getState() <after Interrupting>\t: " + thread.getState());
						System.out.println("thread.isInterrupted()\t\t\t: " + thread.isInterrupted());
					}

				});

				frame.pack();
				frame.setVisible(true);
			}

		});
	}

}
