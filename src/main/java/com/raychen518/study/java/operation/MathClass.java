package com.raychen518.study.java.operation;

public class MathClass {

	public static void main(String[] args) {
		System.out.println("To get better performance, use the Math class.");
		System.out.println("To get same results in different platforms, use the StrictMath class.");
		System.out.println();

		System.out.println("Math.E\t: " + Math.E);
		System.out.println("Math.PI\t: " + Math.PI);
		System.out.println();

		System.out.println("Math.min(1, 2)\t: " + Math.min(1, 2));
		System.out.println("Math.max(1, 2)\t: " + Math.max(1, 2));
		System.out.println();

		System.out.println("Math.ceil(1.2)\t: " + Math.ceil(1.2));
		System.out.println("Math.floor(1.2)\t: " + Math.floor(1.2));
		System.out.println();

		System.out.println("Math.random()\t: " + Math.random());
		System.out.println("Math.round(1.5)\t: " + Math.round(1.5));
		System.out.println("Math.abs(-1)\t: " + Math.abs(-1));
		System.out.println("Math.sqrt(9)\t: " + Math.sqrt(9));
		System.out.println("Math.pow(2, 3)\t: " + Math.pow(2, 3));
		System.out.println();

		System.out.println("Math.exp(2)\t: " + Math.exp(2));
		System.out.println("Math.log(3)\t: " + Math.log(3));
		System.out.println("Math.log10(3)\t: " + Math.log10(3));
		System.out.println();

		System.out.println("Math.toRadians(360)\t\t: " + Math.toRadians(360));
		System.out.println("Math.toDegrees(6.2831853)\t: " + Math.toDegrees(6.2831853));
		System.out.println();

		System.out.println("Math.sin(Math.toRadians(360))\t: " + Math.sin(Math.toRadians(360)));
		System.out.println("Math.cos(Math.toRadians(360))\t: " + Math.cos(Math.toRadians(360)));
		System.out.println("Math.tan(Math.toRadians(360))\t: " + Math.tan(Math.toRadians(360)));
		System.out.println("Math.atan(Math.toRadians(360))\t: " + Math.atan(Math.toRadians(360)));
	}

}
