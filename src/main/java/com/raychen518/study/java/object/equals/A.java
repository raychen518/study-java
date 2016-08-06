package com.raychen518.study.java.object.equals;

import java.util.Objects;

public class A {

	private Integer field1;
	private Integer field2;

	public A(Integer field1, Integer field2) {
		this.field1 = field1;
		this.field2 = field2;
	}

	public Integer getField1() {
		return field1;
	}

	public Integer getField2() {
		return field2;
	}

	/**
	 * <pre>
	 * Override the "equals" method inherited from the Object class.
	 * Note: If the "equals" method inherited has been changed, 
	 *       the corresponding "hashCode" method inherited should also been changed.
	 * </pre>
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		A anotherA = (A) object;

		return Objects.equals(field1, anotherA.field1) && Objects.equals(field2, anotherA.field2);
	}

	public static void main(String[] args) {
		A a1 = new A(1, 2);
		A a2 = a1;
		A a3 = new A(1, 2);

		System.out.println(a1.equals(a2));
		System.out.println(a1.equals(a3));

		System.out.println(a1.equals(null));
		System.out.println(a1.equals(new Object()));
		System.out.println(a1.equals(new A(1, 3)));

		System.out.println((new A(null, null)).equals(new A(1, 2)));
		System.out.println((new A(null, null)).equals(new A(null, null)));
	}

}
