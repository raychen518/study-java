package com.raychen518.study.java.reflection.analyzingclass;

import java.util.Arrays;

public class SomeClass {
	public static int publicField1 = 123;
	public static final String publicField2 = "abc";

	private boolean privateField1 = true;
	private String privateField2 = "def";
	private double[] privateField3 = { 1.2, 3.4, 5.6 };

	public SomeClass() {
	}

	public SomeClass(boolean privateField1, String privateField2, double[] privateField3)
			throws NullPointerException, ArrayIndexOutOfBoundsException {
		this.privateField1 = privateField1;
		this.privateField2 = privateField2;
		this.privateField3 = privateField3;
	}

	protected SomeClass(boolean privateField1, String privateField2, double[] privateField3, boolean someValue)
			throws NullPointerException, ArrayIndexOutOfBoundsException {
		this.privateField1 = privateField1;
		this.privateField2 = privateField2;
		this.privateField3 = privateField3;
	}

	public boolean isPrivateField1() {
		return privateField1;
	}

	public String getPrivateField2() {
		return privateField2;
	}

	public double[] getPrivateField3() {
		return privateField3;
	}

	public void setPrivateField1(boolean privateField1) {
		this.privateField1 = privateField1;
	}

	public void setPrivateField2(String privateField2) {
		this.privateField2 = privateField2;
	}

	public void setPrivateField3(double[] privateField3) {
		this.privateField3 = privateField3;
	}

	@SuppressWarnings("unused")
	private static void doSomethingInStaticPublic() {
		System.out.println("The method \"doSomethingInStaticPublic\" is invoked.");
	}

	@SuppressWarnings("unused")
	private static void doSomethingInStaticPrivate(int someValue) {
		System.out.println("The method \"doSomethingInStaticPrivate\" is invoked.");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("someValue: " + someValue);
		System.out.println("++++++++++++++++++++++++++++++++");
	}

	@SuppressWarnings("unused")
	private boolean doSomethingInPublic() {
		System.out.println("The method \"doSomethingInPublic\" is invoked.");
		return true;
	}

	@SuppressWarnings("unused")
	private Double[] doSomethingInPrivate(int someValue1, boolean someValue2, String someValue3) {
		System.out.println("The method \"doSomethingInPrivate\" is invoked.");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("someValue1: " + someValue1);
		System.out.println("someValue2: " + someValue2);
		System.out.println("someValue3: " + someValue3);
		System.out.println("++++++++++++++++++++++++++++++++");
		return new Double[] { 1.2, 3.4, 5.6 };
	}

	@SuppressWarnings("unused")
	private boolean doSomething(int someValue1, boolean someValue2, String someValue3) {
		System.out.println(
				"The method \"doSomething(int someValue1, boolean someValue2, String someValue3)\" is invoked.");

		System.out.print("someValue1: " + someValue1 + ", ");
		System.out.print("someValue2: " + someValue2 + ", ");
		System.out.print("someValue3: " + someValue3);
		System.out.println();

		return someValue2;
	}

	@SuppressWarnings("unused")
	private Object[] doSomething(int someValue1, boolean someValue2) {
		System.out.println("The method \"doSomething(int someValue1, boolean someValue2)\" is invoked.");

		System.out.print("someValue1: " + someValue1 + ", ");
		System.out.print("someValue2: " + someValue2);
		System.out.println();

		return new Object[] { someValue1, someValue2, 1.2 };
	}

	@Override
	public String toString() {
		String result = "";

		result += getClass().getSimpleName() + "[";
		result += "publicField1: " + publicField1 + ", ";
		result += "publicField2: " + publicField2 + ", ";
		result += "privateField1: " + privateField1 + ", ";
		result += "privateField2: " + privateField2 + ", ";
		result += "privateField3: " + Arrays.toString(privateField3);
		result += "]";

		return result;
	}

}
