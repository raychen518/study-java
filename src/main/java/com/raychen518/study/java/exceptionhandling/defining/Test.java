package com.raychen518.study.java.exceptionhandling.defining;

public class Test {

	public void doSomething(int processId) throws Exception1, Exception2 {
		if (processId == 1) {
			throw new Exception1();
		}

		if (processId == 2) {
			throw new Exception2();
		}

		if (processId == 3) {
			throw new Exception1("Some exception occurred.");
		}
	}

	public static void main(String[] args) {
		Test test = new Test();

		try {
			test.doSomething(1);
		} catch (Exception1 e) {
			e.printStackTrace();
		} catch (Exception2 e) {
			e.printStackTrace();
		}

		try {
			test.doSomething(2);
		} catch (Exception1 e) {
			e.printStackTrace();
		} catch (Exception2 e) {
			e.printStackTrace();
		}

		try {
			test.doSomething(3);
		} catch (Exception1 | Exception2 e) {
			e.printStackTrace();
		}
	}

}
