package com.raychen518.study.java._util;

public final class Numbers {

	public static double findMinValue(double... values) {
		double minValue = Double.MAX_VALUE;

		for (double value : values) {
			if (value < minValue) {
				minValue = value;
			}
		}

		return minValue;
	}

	public static double findMaxValue(double... values) {
		double maxValue = Double.MIN_VALUE;

		for (double value : values) {
			if (value > maxValue) {
				maxValue = value;
			}
		}

		return maxValue;
	}

	public static void main(String[] args) {
		System.out.println("Numbers.findMinValue(1.2, 2.3): " + Numbers.findMinValue(1.2, 2.3));
		System.out.println("Numbers.findMaxValue(1.2, 2.3): " + Numbers.findMaxValue(1.2, 2.3));
		System.out.println();

		System.out.println("Numbers.findMinValue(1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9): "
				+ Numbers.findMinValue(1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9));
		System.out.println("Numbers.findMaxValue(1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9): "
				+ Numbers.findMaxValue(1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9));
		System.out.println();

		System.out.println(
				"Numbers.findMinValue(new double[] { 1.2, 2.3 }): " + Numbers.findMinValue(new double[] { 1.2, 2.3 }));
		System.out.println(
				"Numbers.findMaxValue(new double[] { 1.2, 2.3 }): " + Numbers.findMaxValue(new double[] { 1.2, 2.3 }));
		System.out.println();

		System.out.println("Numbers.findMinValue(1, 2): " + Numbers.findMinValue(1, 2));
		System.out.println("Numbers.findMaxValue(1, 2): " + Numbers.findMaxValue(1, 2));
		System.out.println();
	}

}
