package com.raychen518.study.java.datatypes.primitive.character;

public class Summary {

	public static void main(String[] args) {
		System.out.println("There is only 1 character data type in primitive data types: char (Character).");
		System.out.println("Note: The content in the round brackets is the wrapper class of the primitive data type.");
		System.out.println();

		System.out.println("Type" + "\t" + "Size (Byte)" + "\t" + "Min Value" + "\t" + "Max Value");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("char" + "\t" + "2" + "\t\t" + "\\u0000" + "\t\t" + "\\uFFFF");
		System.out.println();

		System.out.println("========================================");
		System.out.println("Display Formats");
		System.out.println("========================================");
		System.out.println("Character literals have 3 display formats.");
		System.out.println();

		System.out.println("Display Format" + "\t\t" + "Example");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Character" + "\t\t" + "'A'");
		System.out.println("Integer" + "\t\t\t" + "65");
		System.out.println("\\u String" + "\t\t" + "'\\u0041'");
		System.out.println("Note: \\u indicates a unicode character.");
		System.out.println();

		System.out.println("========================================");
		System.out.println("Commonly Used Characters");
		System.out.println("========================================");
		System.out.println("Here are some commonly used characters.");
		System.out.println();

		System.out.println("Character" + "\t\t" + "Unicode" + "\t\t" + "Escape");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\u03C0" + "\t\t\t" + "\\u03C0" + "\t\t" + "----");
		System.out.println("<Backspace>" + "\t\t" + "\\u0008" + "\t\t" + "\\b");
		System.out.println("<Tab>" + "\t\t\t" + "\\u0009" + "\t\t" + "\\t");
		System.out.println("<New Line>" + "\t\t" + "\\u000a" + "\t\t" + "\\n");
		System.out.println("<Carriage Return>" + "\t" + "\\u000d" + "\t\t" + "\\r");
		System.out.println();

		System.out.println("========================================");
		System.out.println("Checking Character as Identifier");
		System.out.println("========================================");
		System.out.println(
				"Here are 2 methods to check whether a chracter is valid as the start/part of a Java identifier.");
		System.out.println();

		System.out.println("Character.isJavaIdentifierStart('9'): " + Character.isJavaIdentifierStart('9'));
		System.out.println("Character.isJavaIdentifierPart('9'): " + Character.isJavaIdentifierPart('9'));
	}

}