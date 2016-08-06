package com.raychen518.study.java.innerclass.anonymous;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * An example of an anonymous inner class.
 * An anonymous inner class is an inner class without name.
 * </pre>
 */
public class SomeClass {

	private int someField;

	public SomeClass(int someField) {
		this.someField = someField;
	}

	public void doSomething1() {
		// Create an instance of an anonymous class extending the Object class,
		// then invoke the doSomething method of this instance.
		new Object() {

			public void doSomething() {
				System.out.println(
						"An anonymous inner class is accessing a private field (someField) of the outer class (SomeClass).");
				System.out.println("someField: " + someField);
				System.out.println("SomeClass.this.someField: " + SomeClass.this.someField);
			}

		}.doSomething();
	}

	public void doSomething2() {
		// Create an instance of an anonymous class extending the SomeSuperClass
		// class, then invoke the doSomething method of this instance.
		new SomeSuperClass(123, true, "abc") {

			public void doSomething() {
				super.doSomething();
				System.out.println();

				System.out.println(
						"An anonymous inner class is accessing a private field (someField) of the outer class (SomeClass).");
				System.out.println("someField: " + someField);
				System.out.println("SomeClass.this.someField: " + SomeClass.this.someField);
			}

		}.doSomething();
	}

	public void doSomething3() {
		// Create an instance of an anonymous class implementing the
		// SomeInterface interface, then invoke the doSomething method of this
		// instance.
		new SomeInterface() {

			@Override
			public void doSomethingSpecial() {
				System.out.println("Something special is to be done.");
				System.out.println();
			}

			public void doSomething() {
				doSomethingSpecial();

				System.out.println(
						"An anonymous inner class is accessing a private field (someField) of the outer class (SomeClass).");
				System.out.println("someField: " + someField);
				System.out.println("SomeClass.this.someField: " + SomeClass.this.someField);
			}

		}.doSomething();
	}

	public void doSomething4() {
		List<String> someList = new ArrayList<String>();

		someList.add("Some String 1");
		someList.add("Some String 2");
		someList.add("Some String 3");

		System.out.println("someList: " + someList.toString());

		// Use "Double Brace Initialization" approach to initialize an instance
		// of an anonymous class.
		System.out.println("<An Anonymous List>: " + (new ArrayList<String>() {

			private static final long serialVersionUID = 4360493140114846155L;

			{
				add("Some String 4");
				add("Some String 5");
				add("Some String 6");
			}

		}).toString());

	}

	public static void main(String[] args) {
		SomeClass someObject = new SomeClass(123);

		someObject.doSomething1();
		System.out.println();

		someObject.doSomething2();
		System.out.println();

		someObject.doSomething3();
		System.out.println();

		someObject.doSomething4();
		System.out.println();
	}

}

class SomeSuperClass {

	private int field1;
	private boolean field2;
	private String field3;

	public SomeSuperClass(int field1, boolean field2, String field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public void doSomething() {
		System.out.println("field1: " + field1);
		System.out.println("field2: " + field2);
		System.out.println("field3: " + field3);
	}

}

interface SomeInterface {

	public void doSomethingSpecial();

}