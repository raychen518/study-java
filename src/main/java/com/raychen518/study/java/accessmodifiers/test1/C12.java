package com.raychen518.study.java.accessmodifiers.test1;

public class C12 {

	public void doSomething() {
		C11 c11 = new C11();
		c11.doSomethingPublic();
		c11.doSomethingProtected();
		c11.doSomethingDefault();
	}

	public static void main(String[] args) {
		C12 c12 = new C12();
		c12.doSomething();
	}

}
