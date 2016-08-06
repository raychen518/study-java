package com.raychen518.study.java.innerclass.static_;

/**
 * <pre>
 * An example of a static inner class.
 * An static inner class is an inner class which is static.
 * </pre>
 */
public class SomeClass {

	public void doSomething() {
		SomeInnerClass someInnerObject = new SomeInnerClass();
		someInnerObject.doSomething();
	}

	// Unlike normal classes, inner classes can be static.
	// Static inner classes can be used if there is no need to access states of
	// the outer class.
	static class SomeInnerClass {
		public void doSomething() {
			System.out.println("The inner class (SomeInnerClass) is doing something from the outer class (SomeClass).");
		}
	}

	public static void main(String[] args) {
		SomeClass someObject = new SomeClass();
		someObject.doSomething();
	}

}
