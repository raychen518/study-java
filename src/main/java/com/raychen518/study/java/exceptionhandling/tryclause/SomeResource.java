package com.raychen518.study.java.exceptionhandling.tryclause;

public class SomeResource implements AutoCloseable {

	private boolean closed = true;

	public SomeResource() {
		closed = false;
	}

	public void process() throws Exception {
		System.out.println("closed: " + closed);
		throw new Exception();
	}

	@Override
	public void close() throws Exception {
		closed = true;
		System.out.println("closed: " + closed);
	}

}
