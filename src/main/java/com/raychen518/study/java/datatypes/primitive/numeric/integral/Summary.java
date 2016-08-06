package com.raychen518.study.java.datatypes.primitive.numeric.integral;

public class Summary {

	public static void main(String[] args) {
		System.out.println(
				"There are 4 integral data types in primitive data types: byte (Byte), short (Short), int (Integer) and long (Long).");
		System.out.println("Note: The content in the round brackets is the wrapper class of the primitive data type.");
		System.out.println();

		System.out.println("Type" + "\t" + "Size (Byte)" + "\t" + "Min Value" + "\t\t" + "Max Value" + "\t\t" + "Suffix");
		System.out.println("--------------------------------------------------------------------------------");
		System.out
				.println("byte" + "\t" + "1" + "\t\t" + Byte.MIN_VALUE + "\t\t\t" + Byte.MAX_VALUE + "\t\t\t" + "<None>");
		System.out.println(
				"short" + "\t" + "2" + "\t\t" + Short.MIN_VALUE + "\t\t\t" + Short.MAX_VALUE + "\t\t\t" + "<None>");
		System.out.println(
				"int" + "\t" + "4" + "\t\t" + Integer.MIN_VALUE + "\t\t" + Integer.MAX_VALUE + "\t\t" + "<None>");
		System.out
				.println("long" + "\t" + "8" + "\t\t" + Long.MIN_VALUE + "\t" + Long.MAX_VALUE + "\t" + "L (e.g. 123L)");
	}

}