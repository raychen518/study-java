package com.raychen518.study.java.accessmodifiers.test2;

public class C11Grandchild extends C11Child {
	public void doSomething() {
		doSomethingPublic();
		doSomethingProtected();
		// doSomethingDefault(); // Not Visible.
		// doSomethingPrivate(); // Not Visible.
	}
}
