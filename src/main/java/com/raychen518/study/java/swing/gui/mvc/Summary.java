package com.raychen518.study.java.swing.gui.mvc;

public class Summary {

	public static void main(String[] args) {
		System.out.println("================================");
		System.out.println("MVC Basics");
		System.out.println("================================");
		System.out.println("- MVC is Model, View and Controller.");
		System.out.println("- Model is used to store data.");
		System.out.println("- View is used to display data.");
		System.out.println("- Controller is used to handle input.");
		System.out.println("- Model must implement searching and updating data.");
		System.out
				.println("- One advantage of MVC is that one Model can have multiple Views which display differently.");
		System.out.println();

		System.out.println("================================");
		System.out.println("MVC Example: Button");
		System.out.println("================================");
		System.out.println(
				"- The model of a button is represented by the class javax.swing.DefaultButtonModel (button.getModel()).");
		System.out.println(
				"- A view of a button is represented by the class javax.swing.plaf.basic.BasicButtonUI (button.getUI()).");
		System.out.println(
				"- A controller of a button is represented by any of the following event listener classes (button.getXxxListeners()).");
		System.out.println("  - java.awt.event.ActionListener");
		System.out.println("  - javax.swing.event.ChangeListener");
		System.out.println("  - java.awt.event.ItemListener");
	}

}
