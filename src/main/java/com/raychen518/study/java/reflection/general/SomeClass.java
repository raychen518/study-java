package com.raychen518.study.java.reflection.general;

public class SomeClass {

	private int field1;
	private boolean field2;
	private Object field3;

	@Override
	public String toString() {
		String result = "";

		result += getClass().getName() + "[";
		result += "field1=" + field1 + ", ";
		result += "field2=" + field2 + ", ";
		result += "field3=" + field3;
		result += "]";

		return result;
	}

	public int getField1() {
		return field1;
	}

	public boolean isField2() {
		return field2;
	}

	public Object getField3() {
		return field3;
	}

}
