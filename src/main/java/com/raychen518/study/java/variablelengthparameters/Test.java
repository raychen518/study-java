package com.raychen518.study.java.variablelengthparameters;

public class Test {

	public static double findMaxValue(double... values) {
		double largest = Double.MIN_VALUE;

		for (double value : values) {
			if (value > largest) {
				largest = value;
			}
		}

		return largest;
	}

	// The method "main" has been changed
	// by replacing "String[]" with "String...".
	public static void main(String... args) {
		System.out.println("Variable-length parameters in the method signatures are writen as \"<Type>...\".");
		System.out.println();

		System.out.println("e.g.");
		System.out.println("    public void doSomething(Object...) { ... } ");
		System.out.println("    public void doSomething(double...) { ... } ");
		System.out.println("    public void doSomething(Person...) { ... } ");
		System.out.println();

		System.out.println("Variable-length parameters are actually converted to <Type>[] when the code runs.");
		System.out.println();

		System.out.println("e.g.");
		System.out.println("    doSomething(Object[])");
		System.out.println("    doSomething(double[])");
		System.out.println("    doSomething(Person[])");
		System.out.println();

		System.out.println("---------------------------------------------------");
		System.out.println();

		System.out.println("findMaxValue(double... values)");
		System.out.println("findMaxValue(1.2, 3.4, 2.3): " + findMaxValue(1.2, 3.4, 2.3));
		System.out.println("findMaxValue(1.2, 3.4, 2.3, 4.5, 6.7, 5.6): " + findMaxValue(1.2, 3.4, 2.3, 4.5, 6.7, 5.6));
		System.out.println("findMaxValue(1.2, 3.4, 2.3, 4.5, 6.7, 5.6, 7.8, 9.9, 8.9): "
				+ findMaxValue(1.2, 3.4, 2.3, 4.5, 6.7, 5.6, 7.8, 9.9, 8.9));
		System.out.println(
				"findMaxValue(new double[] { 1.2, 3.4, 2.3 }): " + findMaxValue(new double[] { 1.2, 3.4, 2.3 }));
	}

}
