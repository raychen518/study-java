package com.raychen518.study.java.datatypes.primitive.numeric;

public class Summary {

	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println("Display Formats");
		System.out.println("========================================");
		System.out.println("Numeric literals have 4 display formats.");
		System.out.println();

		System.out.println("Display Format" + "\t\t" + "Default" + "\t\t" + "Prefix" + "\t\t" + "Example");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Hexadecimal (16)" + "\t" + "No" + "\t\t" + "0x" + "\t\t" + "0xF");
		System.out.println("Decimal (10)" + "\t\t" + "Yes" + "\t\t" + "<None>" + "\t\t" + "15");
		System.out.println("Octal (8)" + "\t\t" + "No" + "\t\t" + "0" + "\t\t" + "017");
		System.out.println("Binary (2)" + "\t\t" + "No" + "\t\t" + "0b" + "\t\t" + "0b1111");
		System.out.println();

		System.out.println("========================================");
		System.out.println("Adding Underscores for Readability");
		System.out.println("========================================");
		System.out.println("Numeric literals can get better readability by adding underscores into them.");
		System.out.println();

		System.out.println("1_000_000: " + 1_000_000);
		System.out.println("123_456.12_34: " + 123_456.12_34);
		System.out.println();

		System.out.println("========================================");
		System.out.println("Type Conversion");
		System.out.println("========================================");
		System.out.println("Numeric primitive data types can convert to each other.");
		System.out.println();

		System.out.println("Legend");
		System.out.println("-->: The type conversion won't cause information loss.");
		System.out.println(">>>: The type conversion may cause information loss.");
		System.out.println();

		System.out.println("byte --> short --> int --> long");
		System.out.println("char --> int");
		System.out.println("int >>> float");
		System.out.println("int --> double");
		System.out.println("double >>> float");
		System.out.println("double >>> double");
		System.out.println();

		System.out.println("e.g.");
		int intValue = 123456789;
		float floatValue = intValue;
		System.out.println("int intValue = 123456789;");
		System.out.println("float floatValue = intValue;");
		System.out.println("floatValue: " + floatValue + " (should be 1.23456789E8)");
		System.out.println();

		System.out
				.println("Here is the type conversion process in Java for binary operations between 2 numeric values.");
		System.out.println("1. If one operand is double, the other operand is converted to double;");
		System.out.println("2. Otherwise, if one operand is float, the other operand is converted to float;");
		System.out.println("3. Otherwise, if one operand is long, the other operand is converted to long;");
		System.out.println("4. Otherwise, both operands are converted to int.");
		System.out.println();
	}

}