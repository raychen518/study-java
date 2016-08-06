package com.raychen518.study.java.objectconstruction;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class StaticImport {

	static class Test {

		public void doSomeCalculation1() {
			System.out.println(
					"Math.sqrt(Math.pow(3, 2) + Math.pow(4, 2))\t: " + Math.sqrt(Math.pow(3, 2) + Math.pow(4, 2)));
			System.out.println("Math.PI\t\t\t\t\t\t: " + Math.PI);
		}

		public void doSomeCalculation2() {
			System.out.println("sqrt(pow(3, 2) + pow(4, 2))\t\t\t: " + sqrt(pow(3, 2) + pow(4, 2)));
			System.out.println("PI\t\t\t\t\t\t: " + PI);
		}

	}

	public static void main(String[] args) {
		// The Static Import feature can import static methods and fields of a
		// class.

		Test test = new Test();

		test.doSomeCalculation1();
		System.out.println();

		test.doSomeCalculation2();
		System.out.println();
	}

}
