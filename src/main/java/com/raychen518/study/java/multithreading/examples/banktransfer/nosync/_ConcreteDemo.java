package com.raychen518.study.java.multithreading.examples.banktransfer.nosync;

import com.raychen518.study.java.multithreading.examples.banktransfer._Demo;

/**
 * <pre>
 * In this demonstration, the data corruption issue in multi-threading scenario
 * can be observed by seeing the total account balance's becoming incorrect.
 * 
 * The output in console often becomes format broken.
 * This is because some other thread jumps the queue to output before current thread finishes its output.
 * </pre>
 */
public class _ConcreteDemo extends _Demo {

	public static void main(String[] args) {
		demonstrateBankTransferProcess(new ConcreteBank(ACCOUNT_COUNT, INITIAL_ACCOUNT_BALANCE));
	}

}
