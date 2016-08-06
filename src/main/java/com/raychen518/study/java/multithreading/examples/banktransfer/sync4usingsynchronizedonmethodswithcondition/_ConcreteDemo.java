package com.raychen518.study.java.multithreading.examples.banktransfer.sync4usingsynchronizedonmethodswithcondition;

import com.raychen518.study.java.multithreading.examples.banktransfer._Demo;

/**
 * <pre>
 * The synchronized modifier and the object intrinsic condition are used in this demonstration.
 * </pre>
 */
public class _ConcreteDemo extends _Demo {

	public static void main(String[] args) {
		demonstrateBankTransferProcess(new ConcreteBank(ACCOUNT_COUNT, INITIAL_ACCOUNT_BALANCE));
	}

}
