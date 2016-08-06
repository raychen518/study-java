package com.raychen518.study.java.exceptionhandling.stacktrace;

import java.util.Map;

import com.raychen518.study.java._util.Utils;

public class Test {

	public void doSomething() throws Exception {

		try {
			new SomeObject().process();
		} catch (Exception e) {
			throw new Exception("Some exception occurred in doing something about the object.", e);
		}

	}

	private static void showStackTraceElements(StackTraceElement[] stackTraceElements) {
		for (int i = 0; i < stackTraceElements.length; i++) {
			StackTraceElement stackTraceElement = stackTraceElements[i];
			System.out.println("stackTraceElement: " + stackTraceElement);
			System.out.println("stackTraceElement.getFileName(): " + stackTraceElement.getFileName());
			System.out.println("stackTraceElement.getClassName(): " + stackTraceElement.getClassName());
			System.out.println("stackTraceElement.getMethodName(): " + stackTraceElement.getMethodName());
			System.out.println("stackTraceElement.getLineNumber(): " + stackTraceElement.getLineNumber());
			System.out.println("stackTraceElement.isNativeMethod(): " + stackTraceElement.isNativeMethod());
			if (i != stackTraceElements.length - 1) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		try {
			new Test().doSomething();
		} catch (Exception e) {
			e.printStackTrace();

			Utils.printDelimiterLine1();

			showStackTraceElements(e.getStackTrace());

			Utils.printDelimiterLine1();

			Map<Thread, StackTraceElement[]> stackTraces = Thread.getAllStackTraces();
			for (Map.Entry<Thread, StackTraceElement[]> stackTraceEntry : stackTraces.entrySet()) {
				showStackTraceElements(stackTraceEntry.getValue());
			}
		}
	}

}
