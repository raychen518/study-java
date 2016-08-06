package com.raychen518.study.java.multithreading.examples.banktransfer;

import java.util.Arrays;

/**
 * <pre>
 * This class represents a bank with a number of accounts.
 * </pre>
 */
public abstract class Bank {

	/**
	 * The accounts.
	 */
	protected final double[] accounts;

	/**
	 * Construct the bank.
	 * 
	 * @param accountCount
	 *            The count of accounts.
	 * @param initialAccountBalance
	 *            The initial balance for each account.
	 */
	public Bank(int accountCount, double initialAccountBalance) {
		accounts = new double[accountCount];
		Arrays.fill(accounts, initialAccountBalance);
	}

	/**
	 * Transfer the specified amount from the specified FROM account to the
	 * specified TO account.
	 * 
	 * @param fromAccount
	 *            The account to transfer from.
	 * @param toAccount
	 *            The account to transfer to.
	 * @param amount
	 *            The amount to transfer.
	 */
	public abstract void transfer(int fromAccount, int toAccount, double amount);

	/**
	 * Get the total account balance.
	 * 
	 * @return The total account balance.
	 */
	public abstract double getTotalAccountBalance();

	/**
	 * Get the count of all accounts.
	 * 
	 * @return The count of all accounts.
	 */
	public abstract int getAccountCount();

}
