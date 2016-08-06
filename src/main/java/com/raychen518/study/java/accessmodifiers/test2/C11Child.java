package com.raychen518.study.java.accessmodifiers.test2;

import com.raychen518.study.java.accessmodifiers.test1.C11;

public class C11Child extends C11 {
	public void doSomething() {
		doSomethingPublic();
		doSomethingProtected();
		// doSomethingDefault(); // Not Visible.
		// doSomethingPrivate(); // Not Visible.
	}

	public static void main(String[] args) {
		C11Child c11Child = new C11Child();
		c11Child.doSomething();
	}
}
