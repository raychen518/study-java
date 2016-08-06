package com.raychen518.study.java.innerclass.local;

/**
 * <pre>
 * An example of a local inner class.
 * A local inner class is an inner class which is located in a method.
 * </pre>
 */
public class SomeClass {

	private int someField;

	public SomeClass(int someField) {
		this.someField = someField;
	}

	public void doSomething() {
		int someVariable = 456;

		// No code outside this method can access this inner class,
		// even the code is of other methods in the outer class.
		class SomeInnerClass {
			public void doSomething() {
				System.out.println(
						"The inner class (SomeInnerClass) is accessing a private field (someField) of the outer class (SomeClass).");
				System.out.println("someField: " + someField);
				System.out.println("SomeClass.this.someField: " + SomeClass.this.someField);
				System.out.println();

				System.out.println(
						"The inner class (SomeInnerClass) is accessing a local variable (someVariable) of the outer method (doSomething).");
				System.out.println("someVariable: " + someVariable);
			}
		}

		SomeInnerClass someInnerObject = new SomeInnerClass();
		someInnerObject.doSomething();
	}

	public void doSomething2() {
		// Error occurs when executing the following statement.
		// Error: SomeInnerClass cannot be resolved to a type
		// ---------------------------------------------------------------------
		// SomeInnerClass someInnerObject = new SomeInnerClass();
	}

	public static void main(String[] args) {
		SomeClass someObject = new SomeClass(123);
		someObject.doSomething();
	}

}
