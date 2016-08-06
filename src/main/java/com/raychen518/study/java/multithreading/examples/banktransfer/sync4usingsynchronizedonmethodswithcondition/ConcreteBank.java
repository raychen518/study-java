package com.raychen518.study.java.multithreading.examples.banktransfer.sync4usingsynchronizedonmethodswithcondition;

import com.raychen518.study.java.multithreading.examples.banktransfer.Bank;

/**
 * <pre>
 * The bank's transfer process has no issue when running in multi-threading scenario
 * because the synchronized modifier is used on the transfer(...), getTotalAccountBalance(...) and getAccountCount() methods in this class,
 * which are the critical sections of the thread.
 * 
 * Furthermore, the object intrinsic condition is used (by invoking the java.lang.Object.wait() method) to make the synchronization more efficient.
 * </pre>
 */
public class ConcreteBank extends Bank {

	public ConcreteBank(int accountCount, double initialAccountBalance) {
		super(accountCount, initialAccountBalance);
	}

	@Override
	public synchronized void transfer(int fromAccount, int toAccount, double amount) {
		try {
			while (accounts[fromAccount] < amount) {
				// #################################
				// Cause the thread to wait (per the object intrinsic
				// condition).
				// #################################
				// Here is the equivalent statement for the thread condition.
				// condition.await();
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.print(Thread.currentThread().getName());

		accounts[fromAccount] -= amount;
		System.out.printf("    %10.2f from %3d to %3d", amount, fromAccount, toAccount);

		accounts[toAccount] += amount;
		System.out.printf("    [Total Account Balance] %10.2f%n", getTotalAccountBalance());

		// #################################
		// Wake up all waiting threads (per the object intrinsic condition).
		// #################################
		// Here is the equivalent statement for the thread condition.
		// condition.signalAll();
		notifyAll();
	}

	@Override
	public synchronized double getTotalAccountBalance() {
		double result = 0;

		for (double account : accounts) {
			result += account;
		}

		return result;
	}

	@Override
	public synchronized int getAccountCount() {
		return accounts.length;
	}

}
