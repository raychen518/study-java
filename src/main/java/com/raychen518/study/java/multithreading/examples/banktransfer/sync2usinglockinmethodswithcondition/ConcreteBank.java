package com.raychen518.study.java.multithreading.examples.banktransfer.sync2usinglockinmethodswithcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.raychen518.study.java.multithreading.examples.banktransfer.Bank;

/**
 * <pre>
 * The bank's transfer process has no issue when running in multi-threading scenario
 * because a thread lock is used on both the transfer(...) and getTotalAccountBalance(...) methods in this class,
 * which are the critical sections of the thread.
 * 
 * Furthermore, a thread condition is used to make the synchronization more efficient.
 * </pre>
 */
public class ConcreteBank extends Bank {

	// #################################
	// Declare a lock and a condition.
	// #################################
	private Lock bankLock;
	private Condition sufficientAmountCondition;

	public ConcreteBank(int accountCount, double initialAccountBalance) {
		super(accountCount, initialAccountBalance);

		// #################################
		// Initialize the lock and the condition.
		// #################################
		bankLock = new ReentrantLock();
		sufficientAmountCondition = bankLock.newCondition();
	}

	@Override
	public void transfer(int fromAccount, int toAccount, double amount) {
		// #################################
		// Acquire the lock.
		// #################################
		bankLock.lock();

		try {
			while (accounts[fromAccount] < amount) {
				// #################################
				// Cause the thread to wait per the condition.
				// #################################
				sufficientAmountCondition.await();
			}

			System.out.print(Thread.currentThread().getName());

			accounts[fromAccount] -= amount;
			System.out.printf("    %10.2f from %3d to %3d", amount, fromAccount, toAccount);

			accounts[toAccount] += amount;
			System.out.printf("    [Total Account Balance] %10.2f%n", getTotalAccountBalance());

			// #################################
			// Wake up all waiting threads per the condition.
			// #################################
			sufficientAmountCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// #################################
			// Release the lock.
			// #################################
			// Make sure to release the lock after the process is done, even if
			// an exception is thrown in the process.
			// Otherwise, other threads will be ALWAYS blocked.
			bankLock.unlock();
		}
	}

	@Override
	public double getTotalAccountBalance() {
		bankLock.lock();

		try {
			double result = 0;
			for (double account : accounts) {
				result += account;
			}
			return result;
		} finally {
			bankLock.unlock();
		}
	}

	@Override
	public int getAccountCount() {
		return accounts.length;
	}

}
