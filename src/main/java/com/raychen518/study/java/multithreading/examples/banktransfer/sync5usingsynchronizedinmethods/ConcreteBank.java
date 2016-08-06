package com.raychen518.study.java.multithreading.examples.banktransfer.sync5usingsynchronizedinmethods;

import com.raychen518.study.java.multithreading.examples.banktransfer.Bank;

/**
 * <pre>
 * The bank's transfer process has no issue when running in multi-threading scenario
 * because the synchronized block is used in the transfer(...), getTotalAccountBalance(...) and getAccountCount() methods in this class,
 * which are the critical sections of the thread.
 * </pre>
 */
public class ConcreteBank extends Bank {

	public ConcreteBank(int accountCount, double initialAccountBalance) {
		super(accountCount, initialAccountBalance);
	}

	@Override
	public void transfer(int fromAccount, int toAccount, double amount) {
		synchronized (accounts) {
			if (accounts[fromAccount] < amount) {
				return;
			}

			System.out.print(Thread.currentThread().getName());

			accounts[fromAccount] -= amount;
			System.out.printf("    %10.2f from %3d to %3d", amount, fromAccount, toAccount);

			accounts[toAccount] += amount;
			System.out.printf("    [Total Account Balance] %10.2f%n", getTotalAccountBalance());
		}
	}

	@Override
	public double getTotalAccountBalance() {
		synchronized (accounts) {
			double result = 0;
			for (double account : accounts) {
				result += account;
			}
			return result;
		}
	}

	@Override
	public int getAccountCount() {
		synchronized (accounts) {
			return accounts.length;
		}
	}

}
