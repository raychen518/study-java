package com.raychen518.study.java.innerclass.examples;

import java.util.Arrays;
import java.util.Random;

public class Calculator {

	public static MinMax calculateMinAndMaxValues(double[] values) {
		System.out.println(Arrays.toString(values));

		double minValue = Double.MAX_VALUE;
		double maxValue = Double.MIN_VALUE;

		for (double value : values) {
			if (value < minValue) {
				minValue = value;
			}

			if (value > maxValue) {
				maxValue = value;
			}
		}

		return new MinMax(minValue, maxValue);
	}

	public static void main(String[] args) {
		System.out.println(Calculator.calculateMinAndMaxValues(generateRandomDoubles()));
		System.out.println();

		System.out.println(Calculator.calculateMinAndMaxValues(generateRandomDoubles()));
		System.out.println();

		System.out.println(Calculator.calculateMinAndMaxValues(generateRandomDoubles()));
		System.out.println();
	}

	private static int RANDOM_DOUBLE_DECIMAL_DIGITS = 3;

	private static double[] generateRandomDoubles() {
		double[] results = new double[new Random().nextInt(6) + 2];
		double doubleRoundHelpValue;

		for (int i = 0; i < results.length; i++) {
			doubleRoundHelpValue = Math.pow(10, RANDOM_DOUBLE_DECIMAL_DIGITS);
			results[i] = Math.round(new Random().nextDouble() * doubleRoundHelpValue) / doubleRoundHelpValue;
		}

		return results;
	}

	private static class MinMax {
		double minValue;
		double maxValue;

		public MinMax(double minValue, double maxValue) {
			this.minValue = minValue;
			this.maxValue = maxValue;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + "[min: " + minValue + ", max: " + maxValue + "]";
		}

	}

}
