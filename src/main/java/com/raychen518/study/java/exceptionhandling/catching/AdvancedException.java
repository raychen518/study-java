package com.raychen518.study.java.exceptionhandling.catching;

public class AdvancedException extends Exception {

	private static final long serialVersionUID = -7955482822126048216L;

	public AdvancedException() {
		super();
	}

	public AdvancedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AdvancedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdvancedException(String message) {
		super(message);
	}

	public AdvancedException(Throwable cause) {
		super(cause);
	}

}
