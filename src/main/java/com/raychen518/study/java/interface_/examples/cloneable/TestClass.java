package com.raychen518.study.java.interface_.examples.cloneable;

public class TestClass {

	private String field1 = "";

	public TestClass(String field1) {
		this.field1 = field1;
	}

	@Override
	public String toString() {
		String result = "";

		result += getClass().getSimpleName() + "[";
		result += "field1: " + field1;
		result += "]";

		return result;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

}
