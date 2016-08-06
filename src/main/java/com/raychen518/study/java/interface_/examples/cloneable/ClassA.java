package com.raychen518.study.java.interface_.examples.cloneable;

public class ClassA implements Cloneable {

	int field1;
	String field2;
	boolean field3;
	TestClass field4;

	public ClassA(int field1, String field2, boolean field3, TestClass field4) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
	}

	@Override
	public String toString() {
		String result = "";

		result += getClass().getSimpleName() + "[";
		result += "field1: " + field1 + ", ";
		result += "field2: " + field2 + ", ";
		result += "field3: " + field3 + ", ";
		result += "field4: " + field4;
		result += "]";

		return result;
	}

	public TestClass getField4() {
		return field4;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		ClassA objectA1 = new ClassA(123, "abc", true, new TestClass("XXX"));
		System.out.println("objectA1: " + objectA1);
		System.out.println();

		System.out.println("// The \"assignment (=)\" copy is not a content copy, it is just an address copy.");
		ClassA objectA2 = objectA1;
		System.out.println("ClassA objectA2 = objectA1;");
		System.out.println("objectA2: " + objectA2);
		System.out.println("objectA2 == objectA1: " + (objectA2 == objectA1));
		System.out.println();

		System.out.println("// The \"clone() method\" copy is a content copy, but only a shallow one.");
		ClassA objectA3 = (ClassA) objectA1.clone();
		System.out.println("ClassA objectA3 = (ClassA) objectA1.clone();");
		System.out.println("objectA3: " + objectA3);
		System.out.println("objectA3 == objectA1: " + (objectA3 == objectA1));
		objectA1.getField4().setField1("YYY");
		System.out.println("objectA1.getField4().setField1(\"YYY\");");
		System.out.println("objectA3: " + objectA3);
		System.out.println();
	}

}
