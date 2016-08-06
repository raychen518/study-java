package com.raychen518.study.java.object.equals;

import java.util.Objects;

public class A1 extends A {

	private Integer field3;

	public A1(Integer field1, Integer field2, Integer field3) {
		super(field1, field2);
		this.field3 = field3;
	}

	public Integer getField3() {
		return field3;
	}

	/*
	 * Override the "equals" method inherited from the A class.
	 */
	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}

		A1 anotherA1 = (A1) object;

		return Objects.equals(field3, anotherA1.field3);
	}

	public static void main(String[] args) {
		A1 a11 = new A1(1, 2, 3);
		A1 a12 = a11;
		A1 a13 = new A1(1, 2, 3);

		System.out.println(a11.equals(a12));
		System.out.println(a11.equals(a13));

		System.out.println(a11.equals(null));
		System.out.println(a11.equals(new Object()));
		System.out.println(a11.equals(new A1(1, 2, 4)));

		System.out.println((new A1(null, null, null)).equals(new A1(1, 2, 3)));
		System.out.println((new A1(null, null, null)).equals(new A1(null, null, null)));
	}

}
