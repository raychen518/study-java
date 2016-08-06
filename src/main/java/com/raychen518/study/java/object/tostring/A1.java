package com.raychen518.study.java.object.tostring;

public class A1 extends A {

	private double field4;

	public A1(int field1, String field2, boolean field3, double field4) {
		super(field1, field2, field3);
		this.field4 = field4;
	}

	@Override
	public String toString() {
		return super.toString() + "[field4=" + field4 + "]";
	}

	public double getField4() {
		return field4;
	}

	public static void main(String[] args) {
		A1 a11 = new A1(123, "abc", true, 123.456);
		System.out.println(a11.toString());

		A1 a12 = new A1(456, null, false, 456.789);
		System.out.println(a12.toString());
	}

}
