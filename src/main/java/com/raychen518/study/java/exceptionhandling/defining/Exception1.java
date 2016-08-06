package com.raychen518.study.java.exceptionhandling.defining;

/**
 * <pre>
 * To define a custom exception, create a class extending java.lang.Exception or one of its subclasses.
 * Usually, the custom exception contains 2 constructors, one constructor is the default one without parameters,
 * the other constructor has a parameter specifying the detail message.
 * </pre>
 */
public class Exception1 extends Exception {

	private static final long serialVersionUID = -6181557793115330801L;

	public Exception1() {
		super();
		// ...
	}

	public Exception1(String message) {
		super(message);
		// ...
	}

}
