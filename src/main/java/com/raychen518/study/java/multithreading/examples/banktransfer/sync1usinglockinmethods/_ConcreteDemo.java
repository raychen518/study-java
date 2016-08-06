package com.raychen518.study.java.multithreading.examples.banktransfer.sync1usinglockinmethods;

import com.raychen518.study.java.multithreading.examples.banktransfer._Demo;

/**
 * <pre>
 * A thread lock is used in this demonstration.
 * </pre>
 */
public class _ConcreteDemo extends _Demo {

	public static void main(String[] args) {
		demonstrateBankTransferProcess(new ConcreteBank(ACCOUNT_COUNT, INITIAL_ACCOUNT_BALANCE));
	}

}
