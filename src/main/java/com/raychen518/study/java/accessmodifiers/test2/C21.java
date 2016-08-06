package com.raychen518.study.java.accessmodifiers.test2;

import com.raychen518.study.java.accessmodifiers.test1.C11;

public class C21 {

	public void doSomething() {
		C11 c11 = new C11();
		c11.doSomethingPublic();
		// c11.doSomethingProtected(); // Not Visible.
		// c11.doSomethingDefault(); // Not Visible.
		// c11.doSomethingPrivate(); // Not Visible.
	}

	public static void main(String[] args) {
		C21 c21 = new C21();
		c21.doSomething();
	}

}
