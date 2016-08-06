package com.raychen518.study.java.innerclass.general;

/**
 * <pre>
 * An example of a general inner class.
 * An inner class is a class which is located in another class.
 * </pre>
 */
public class SomeClass {

	private int someField;

	public SomeClass(int someField) {
		this.someField = someField;
	}

	public void doSomething() {
		// The statement "new SomeInnerClass()" here can be replaced by either
		// of following statements.
		// - this.new SomeInnerClass()
		// - new SomeClass.SomeInnerClass()
		SomeInnerClass someInnerObject = new SomeInnerClass();
		someInnerObject.doSomething();
	}

	// Unlike normal classes, inner classes can be private.
	private class SomeInnerClass {
		public void doSomething() {
			System.out.println(
					"The inner class (SomeInnerClass) is accessing a private field (someField) of the outer class (SomeClass).");
			System.out.println("someField: " + someField);
			System.out.println("SomeClass.this.someField: " + SomeClass.this.someField);
		}
	}

	public static void main(String[] args) {
		SomeClass someObject = new SomeClass(123);
		someObject.doSomething();
	}

}
