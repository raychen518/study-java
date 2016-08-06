package com.raychen518.study.java.multithreading.examples.banktransfer.nosync;

import com.raychen518.study.java.multithreading.examples.banktransfer.Bank;

/**
 * <pre>
 * The bank's transfer process has the issue
 * that the total account balance becomes incorrect occasionally when running in multi-threading scenario.
 * 
 * The transfer(...) and getTotalAccountBalance(...) methods in this class should be treated as critical sections of the thread,
 * since they are both invoked directly or indirectly in the thread process (the run() method of the BankTransferProcess class).
 * Note: Actually the getAccountCount() method is also invoked and should be a critical section,
 *       but it has only one statement, so it won't cause a synchronization issue.
 * </pre>
 */
public class ConcreteBank extends Bank {

	public ConcreteBank(int accountCount, double initialAccountBalance) {
		super(accountCount, initialAccountBalance);
	}

	@Override
	public void transfer(int fromAccount, int toAccount, double amount) {
		if (accounts[fromAccount] < amount) {
			return;
		}

		System.out.print(Thread.currentThread().getName());

		accounts[fromAccount] -= amount;
		System.out.printf("    %10.2f from %3d to %3d", amount, fromAccount, toAccount);

		accounts[toAccount] += amount;
		System.out.printf("    [Total Account Balance] %10.2f%n", getTotalAccountBalance());
	}

	@Override
	public double getTotalAccountBalance() {
		double result = 0;

		for (double account : accounts) {
			result += account;
		}

		return result;
	}

	@Override
	public int getAccountCount() {
		return accounts.length;
	}

}
