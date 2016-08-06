package com.raychen518.study.java.multithreading.examples.banktransfer;

/**
 * <pre>
 * This class represents a bank transfer process.
 * </pre>
 */
public class BankTransferProcess implements Runnable {

	private static int THREAD_DELAY = 1000;

	private Bank bank;
	private int fromAccount;
	private double maxTransferAmount;

	/**
	 * Construct a bank transfer process.
	 * 
	 * @param bank
	 *            The target bank to perform the transfer.
	 * @param fromAccount
	 *            The account to transfer from.
	 * @param maxTransferAmount
	 *            The maximum amount in each transfer.
	 */
	public BankTransferProcess(Bank bank, int fromAccount, double maxTransferAmount) {
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxTransferAmount = maxTransferAmount;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int toAccount = (int) (bank.getAccountCount() * Math.random());
				double amount = maxTransferAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep(THREAD_DELAY);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
