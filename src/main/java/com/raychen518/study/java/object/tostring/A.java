package com.raychen518.study.java.object.tostring;

public class A {

	private int field1;
	private String field2;
	private boolean field3;

	public A(int field1, String field2, boolean field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	@Override
	public String toString() {
		String content = "";

		content += "field1=" + field1 + ", ";
		content += "field2=\"" + (field2 == null ? "" : field2) + "\", ";
		content += "field3=" + field3;

		return getClass().getName() + "[" + content + "]";
	}

	public int getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public boolean isField3() {
		return field3;
	}

	public static void main(String[] args) {
		System.out.println("Most toString() methods return results by either of following formats.");
		System.out.println("CLASS_NAME@HASH_CODE_IN_BASE_16");
		System.out.println("CLASS_NAME[FIELD_1_NAME=FIELD_1_VALUE,FIELD_2_NAME=FIELD_2_VALUE,...]");
		System.out.println();

		System.out.println(new Object().toString());

		A a1 = new A(123, "abc", true);
		System.out.println(a1.toString());

		A a2 = new A(456, null, false);
		System.out.println(a2.toString());
		System.out.println();

		System.out.println("----------------------------------------");
		System.out.println();

		System.out.println("As long as an object is concatenated by the plus sign (+),");
		System.out.println("its toString() method will be automatically invoked.");
		System.out.println();

		A a3 = new A(123, "abc", true);
		A a4 = new A(456, null, false);

		System.out.println("|" + a3 + "|");
		System.out.println("|" + a4 + "|");

		System.out.println("----------------------------------------");
		System.out.println();

		System.out.println("The toString() methods of arrays return results by following formats.");
		System.out.println(
				"Note: To print out the array content, use the static methods toString() or deepToString() of the Arrays class.");
		System.out.println();
		System.out.println("Arrays in Primitive Data Types");
		System.out.println("    Format");
		System.out.println("        [SYMBOL@HASH_CODE_IN_BASE_16");
		System.out.println("    Examples");
		System.out.println("        int[]\t\t: [I@HASH_CODE_IN_BASE_16");
		System.out.println("        long[]\t\t: [J@HASH_CODE_IN_BASE_16");
		System.out.println("        double[]\t: [D@HASH_CODE_IN_BASE_16");
		System.out.println("        ...");
		System.out.println();
		System.out.println("Arrays in Other Data Types");
		System.out.println("    Format");
		System.out.println("        [LCLASS_NAME;@HASH_CODE_IN_BASE_16");
		System.out.println("    Examples");
		System.out.println("        String[]\t: [Ljava.lang.String;@HASH_CODE_IN_BASE_16");
		System.out.println("        Integer[]\t: [Ljava.lang.Integer;@HASH_CODE_IN_BASE_16");
		System.out.println("        ...");
		System.out.println();

		int[] arrayInt = { 123, 456, 789 };
		long[] arrayLong = { 123L, 456L, 789L };
		double[] arrayDouble = { 123D, 456D, 789D };
		String[] arrayString = { "abc", "def", "ghi" };
		Integer[] arrayInteger = { 123, 456, 789 };

		System.out.println(arrayInt.toString());
		System.out.println(arrayLong.toString());
		System.out.println(arrayDouble.toString());
		System.out.println(arrayString.toString());
		System.out.println(arrayInteger.toString());
	}

}
