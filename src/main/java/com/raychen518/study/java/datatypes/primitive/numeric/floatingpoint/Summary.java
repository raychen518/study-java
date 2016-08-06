package com.raychen518.study.java.datatypes.primitive.numeric.floatingpoint;

public class Summary {

	public static void main(String[] args) {
		System.out.println("There are 2 floating-point data types in primitive data types: float (Float) and double (Double).");
		System.out.println("Note: The content in the round brackets is the wrapper class of the primitive data type.");
		System.out.println();

		System.out.println("Type" + "\t" + "Size (Byte)" + "\t" + "Min Value" + "\t" + "Max Value" + "\t\t" + "Suffix");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(
				"float" + "\t" + "4" + "\t\t" + Float.MIN_VALUE + "\t\t" + Float.MAX_VALUE + "\t\t" + "F (e.g. 123.45F)");
		System.out.println(
				"double" + "\t" + "8" + "\t\t" + Double.MIN_VALUE + "\t" + Double.MAX_VALUE + "\t" + "D (e.g. 123.45D)");
		System.out.println();

		System.out.println("Notes:");
		System.out.println(
				"- A floating-point type cannot indicate a numeric exactly sometimes due to its accuracy issue.");
		System.out.println("  e.g. 2.0 - 1.1 = " + (2.0 - 1.1) + " // Should be 0.9.");
		System.out.println("  The class BigDecimal can be used to solve this kind of issues.");
	}

}