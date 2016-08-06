package com.raychen518.study.java.object.hashcode;

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

	/**
	 * <pre>
	 * The "hashCode" method inherited should been changed,
	 * if the corresponding "equals" method inherited has been changed.
	 * Notes:
	 * - If 2 objects are verified as same by the "equals" method,
	 *   they should return same hash codes.
	 * - The methods such as Objects.hash(...), Arrays.hashCode(...) and Arrays.deepHashCode(...) can be used to generate hash codes conveniently.
	 * </pre>
	 */
	@Override
	public int hashCode() {
		return Objects.hash(field1, field2);
	}

	public static void main(String[] args) {
		A a1 = new A(1, 2);
		A a2 = new A(1, 2);
		A a3 = new A(3, 4);

		System.out.println("A a1 = new A(1, 2);");
		System.out.println("A a2 = new A(1, 2);");
		System.out.println("A a3 = new A(3, 4);");
		System.out.println();

		System.out.println(
				"a1.equals(a2): " + a1.equals(a2) + "\t (Hash Codes: " + a1.hashCode() + " vs. " + a2.hashCode() + ")");
		System.out.println(
				"a1.equals(a3): " + a1.equals(a3) + "\t (Hash Codes: " + a1.hashCode() + " vs. " + a3.hashCode() + ")");
	}

}
