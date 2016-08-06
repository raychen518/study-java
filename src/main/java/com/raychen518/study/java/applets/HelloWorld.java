package com.raychen518.study.java.applets;

import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HelloWorld extends JApplet {

	private static final long serialVersionUID = 7166917587271970528L;

	@Override
	public void init() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JLabel label = new JLabel("Hello, World!", SwingConstants.CENTER);
				add(label);
			}

		});
	}

}
