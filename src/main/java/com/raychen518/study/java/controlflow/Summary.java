package com.raychen518.study.java.controlflow;

public class Summary {

	public static void main(String[] args) {
		System.out.println("====================");
		System.out.println("Summary");
		System.out.println("====================");
		System.out.println("There are following control flow statements.");
		System.out.println("- Block");
		System.out.println("- Condition");
		System.out.println("    - If-Else");
		System.out.println("    - Switch");
		System.out.println("- Loop");
		System.out.println("    - For");
		System.out.println("    - For-Each");
		System.out.println("    - While");
		System.out.println("    - Do-While");
		System.out.println();

		System.out.println("Notes:");
		System.out.println(
				"- For loop statements, the \"break [Label];\" statement can be used to break the control flow.");
		System.out.println(
				"- For loop statements, the \"continue [Label];\" statement can be used to break (continue next loop) the control flow.");
		System.out.println();

		System.out.println("====================");
		System.out.println("Block");
		System.out.println("====================");
		System.out.println("{");
		System.out.println("    ...");
		System.out.println("}");
		System.out.println();

		System.out.println("====================");
		System.out.println("If-Else");
		System.out.println("====================");
		System.out.println("if (<Check>) {");
		System.out.println("    ...");
		System.out.println("} else {");
		System.out.println("    ...");
		System.out.println("}");
		System.out.println();

		System.out.println("====================");
		System.out.println("Switch");
		System.out.println("====================");
		System.out.println("switch (key) {");
		System.out.println("case value1:");
		System.out.println("    ...");
		System.out.println("    break;");
		System.out.println("case value2:");
		System.out.println("    ...");
		System.out.println("    break;");
		System.out.println(":   :   :");
		System.out.println("default:");
		System.out.println("    ...");
		System.out.println("    break;");
		System.out.println("}");
		System.out.println();
		System.out.println("Notes:");
		System.out.println("- A case value can be any of the following data.");
		System.out.println(
				"    - A constant of the data type char (Character), byte (Byte), short (Short) or int (Integer).");
		System.out.println("    - A constant of an Enum.");
		System.out.println("    - A string literal.");
		System.out.println();

		System.out.println("====================");
		System.out.println("For");
		System.out.println("====================");
		System.out.println("for (<Initialize>; <Check>; <Update>) {");
		System.out.println("    ...");
		System.out.println("}");
		System.out.println();

		System.out.println("====================");
		System.out.println("For-Each");
		System.out.println("====================");
		System.out.println("for (<ElementType> <ElementVariable> : <ElementCollection>) {");
		System.out.println("    ...");
		System.out.println("}");
		System.out.println();

		System.out.println("====================");
		System.out.println("While");
		System.out.println("====================");
		System.out.println("while (<Check>) {");
		System.out.println("    ...");
		System.out.println("}");
		System.out.println();

		System.out.println("====================");
		System.out.println("Do-While");
		System.out.println("====================");
		System.out.println("do {");
		System.out.println("    ...");
		System.out.println("} while (<Check>);");
		System.out.println();
	}

}
