package com.raychen518.study.java.exceptionhandling.defining;

public class Exception2 extends Exception {

	private static final long serialVersionUID = -8873944568554283172L;

	public Exception2() {
		super();
		// ...
	}

	public Exception2(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// ...
	}

	public Exception2(String message, Throwable cause) {
		super(message, cause);
		// ...
	}

	public Exception2(String message) {
		super(message);
		// ...
	}

	public Exception2(Throwable cause) {
		super(cause);
		// ...
	}

}
