package com.raychen518.study.java.interface_.general;

/**
 * <pre>
 * - All fields in the interface are implicitly (and must be) public, static and final.
 *   So there is no need to add the "public static final" modifiers for the fields.
 *   
 * - All methods in the interface are implicitly (and must be) public.
 *   So there is no need to add the "public" modifier for the methods.
 * </pre>
 */
public interface SomeInterface {
	int SOME_CONSTANT_1 = 123;

	String SOME_CONSTANT_2 = "abc";

	void doSomething1();

	boolean doSomething2(int someValue1, String someValue2);

}
