package com.raychen518.study.java.deployment.jar.test;

import com.raychen518.study.java.deployment.jar.test.a.A1;
import com.raychen518.study.java.deployment.jar.test.b.B1;
import com.raychen518.study.java.deployment.jar.test.c.C1;

public class Application {

	public static void main(String[] args) {
		System.out.println("Welcome to the JAR Test application.");
		System.out.println();

		A1 a1 = new A1(123);
		System.out.println("a1.getField1(): " + a1.getField1());

		B1 b1 = new B1(456);
		System.out.println("b1.getField1(): " + b1.getField1());

		C1 c1 = new C1(789);
		System.out.println("c1.getField1(): " + c1.getField1());
		System.out.println();

		for (int i = 0; i < args.length; i++) {
			System.out.println("argument[" + (i + 1) + "]: " + args[i]);
		}

	}

}
