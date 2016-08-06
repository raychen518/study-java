package com.raychen518.study.java.multithreading.examples.banktransfer;

/**
 * <pre>
 * This class demonstrates the bank transfer process.
 * 
 * Way to Produce Dead Lock Here
 * - Modify the value of the constant ACCOUNT_COUNT to a much smaller one, such as 5.
 * - Modify the maximum amount in each transfer (the 3rd parameter of the BankTransferProcess class' constructor) to a much bigger one,
 *   such as 2 times of the original value.
 * - Go to some concrete demo class and run it.
 * </pre>
 */
public abstract class _Demo {

	protected static final int ACCOUNT_COUNT = 100;
	protected static final double INITIAL_ACCOUNT_BALANCE = 1000;

	protected static void demonstrateBankTransferProcess(Bank bank) {
		// Create multiple threads to run the bank transfer process.
		// Each bank transfer process transfers random amount from a specified
		// unique FROM account to a random TO account.
		for (int i = 0; i < ACCOUNT_COUNT; i++) {
			BankTransferProcess bankTransferProcess = new BankTransferProcess(bank, i, INITIAL_ACCOUNT_BALANCE);
			Thread thread = new Thread(bankTransferProcess, "Thread" + toString(i));
			thread.start();
		}
	}

	private static String toString(int number) {
		StringBuilder result = new StringBuilder();

		int resultLengthDiff = String.valueOf(ACCOUNT_COUNT).length() - String.valueOf(number).length();
		for (int i = 0; i < resultLengthDiff; i++) {
			result.append("0");
		}
		result.append(String.valueOf(number));

		return result.toString();
	}

}