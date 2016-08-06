package com.raychen518.study.java.accessmodifiers.test1;

public class C11 {

	public void doSomethingPublic() {
		System.out.println("C11.doSomethingPublic (for C11 and all others)");
	}

	protected void doSomethingProtected() {
		System.out.println("C11.doSomethingProtected (for C11 and its package members and its children ONLY)");
	}

	void doSomethingDefault() {
		System.out.println("C11.doSomethingDefault (for C11 and its package members ONLY)");
	}

	@SuppressWarnings("unused")
	private void doSomethingPrivate() {
		System.out.println("C11.doSomethingPrivate (for C11 ONLY)");
	}
}
