package com.raychen518.study.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * The Proxy mechanism can create a new class in runtime.
 */
public class TraceHandler implements InvocationHandler {

	private Object target;

	public TraceHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.print(target);
		System.out.print("." + method.getName() + "(");

		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1) {
					System.out.print(", ");
				}
			}
		}

		System.out.println(")");

		return method.invoke(target, args);
	}

	public static void main(String[] args) {
		Object[] objects = new Object[1000];

		for (int i = 0; i < objects.length; i++) {
			// The class loader to define the proxy class.
			ClassLoader classLoader = null;

			// The list of interfaces for the proxy class to implement.
			Class<?>[] interfaces = new Class<?>[] { Comparable.class };

			// The invocation handler to dispatch method invocations to.
			InvocationHandler invocationHandler = new TraceHandler(Integer.valueOf(i + 1));

			// Create a proxy instance using then specified class loader,
			// interfaces and invocation handler.
			// A proxy instance is returned.
			// It is defined by the specified class loader.
			// It implements the specified interfaces.
			// It dispatches method invocations to the specified invocation
			// handler.
			// So, the return proxy instance has all methods defined by the
			// specified interfaces, plus the methods inherited from the Object
			// class.
			Object proxy = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

			// Set the created proxy instance.
			objects[i] = proxy;
		}

		// From now on, every method invocation of one element in this object
		// array causes a proxy process.

		// Generate the integer to search.
		Integer integerToSearch = new Random().nextInt(objects.length) + 1;

		// Search the integer.
		/**
		 * <pre>
		 * When the method "compareTo(T)" from the interface "Comparable" is invoked,
		 * the method invocation is dispatched to an instance of the class "TraceHandler",
		 * then the method "invoke(Object, Method, Object[])" in that instance is invoked.
		 * </pre>
		 */
		// This "binarySearch(Object[], Object)" method needs many invocations
		// of the method "compareTo(T)" of elements in the object array, so many
		// proxy processes occur accordingly.
		int searchResult = Arrays.binarySearch(objects, integerToSearch);

		// Print the search result.
		if (searchResult >= 0) {
			// The invocation of the method "toString()" of the result element
			// in the object array occurs here.
			// Although the method "toString() is not belonging to the interface
			// "Comparable", a proxy process still occurs.
			// Some methods in the Object class behave like this.
			System.out.println(objects[searchResult]);
		}
	}

}
