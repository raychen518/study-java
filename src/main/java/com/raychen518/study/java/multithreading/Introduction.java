package com.raychen518.study.java.multithreading;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * This class introduces the thread basics.
 * 
 * =================
 * Contents
 * =================
 * Points
 * Hierarchy Graph
 * Class/Interface Summary
 * Class/Interface Details
 *   java.lang.Runnable
 *   java.lang.Thread
 *   java.util.concurrent.locks.Lock
 *   java.util.concurrent.locks.ReentrantLock
 *   java.util.concurrent.locks.ReadWriteLock
 *   java.util.concurrent.locks.ReentrantReadWriteLock
 *   java.util.concurrent.locks.Condition
 *   java.lang.ThreadLocal<T>
 * Ways to Create a Thread
 *   1. Declaring a Class Extending the java.lang.Thread Class
 *   2. Declaring a Class Implementing the java.lang.Runnable Interface
 * Interrupting the Thread
 * Thread States
 * Thread Synchronization
 * Ways to Achieve Thread Synchronization
 *   1. Using the Lock Object in Methods
 *   2. Using the Lock Object in Methods with the Condition Object
 *   3. Using the synchronized Modifier on Methods
 *   4. Using the synchronized Modifier on Methods with the Object Intrinsic Condition Object
 *   5. Using the synchronized Block in Methods
 *   6. Using the volatile Modifier on Fields
 *   7. Using the final Modifier on Fields
 * Cases Easy to Produce Dead Lock
 *   1. The Lock Is Kept Unreleased
 *   2. The Process Is Certain/Easier to Make All Threads Blocked
 *   3. Only One instead of All Sleeping Threads Is Notified to Wake up
 * References
 * 
 * =====================================
 * Points
 * =====================================
 * - A thread is a thread of execution in a program.
 * 
 * - A program can have multiple threads running concurrently.
 * 
 * - Every thread has a priority.
 *   Threads with higher priorities are executed in preference to threads with lower priorities.
 * 
 * - A thread can be marked as a daemon.
 * 
 * - When a thread is created in some thread,
 *   the created thread has its priority initially set equal to the priority of the host thread,
 *   and the created thread is a daemon thread if and only if the host thread is a daemon thread.
 * 
 * - When JVM starts up, there is usually a single non-daemon thread (which typically invokes the "main(...)" method of some designated class).
 * 
 * - Every thread has a name, for identification purposes.
 *   Multiple threads can have the same name.
 *   If a name is not specified when a thread is created, a new name is generated for it.
 * 
 * - The dead lock occurs, even after the locks and conditions are used.
 * 
 * - The java.lang.ThreadLocal<T> class provides thread-local variables to achieve the thread safety.
 * 
 *   Example
 *   ---------------------------------------------------------------------------
 *   // Not Using ThreadLocal and Not Thread-safe
 *   public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
 *   
 *   // Using ThreadLocal and Thread-safe
 *   public static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
 *-  	@Override
 *   	protected SimpleDateFormat initialValue() {
 *   		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
 *   	}
 *   }
 *   ---------------------------------------------------------------------------
 * 
 * - The java.util.concurrent.ThreadLocalRandom generate random numbers in multi-threading efficiently.
 *   Note: Though the java.util.Random class is also thread-safe, it is not efficient in multi-threading.
 * 
 *   Example
 *   ---------------------------------------------------------------------------
 *   ThreadLocalRandom.current().nextInt(100)
 *   ---------------------------------------------------------------------------
 * 
 * - Many threading issues can be solved safely and elegantly by using queues.
 * 
 *   For example, the producer threads insert the product elements into a queue,
 *   and the consumer threads retrieve the product elements from the queue and use them.
 * 
 *   By using a queue, data can be safely transferred from one thread to another thread.
 *   
 *   If a queue is full when adding an element into it,
 *   or a queue contains no elements when retrieving an element from it,
 *   all related threads are blocked. 
 * 
 * =====================================
 * Hierarchy Graph
 * =====================================
 * 
 * 				|------ java.lang.Runnable
 * 				|
 * 		java.lang.Thread
 * 
 * 		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 
 * 		java.util.concurrent.locks.Lock
 * 				|
 * 				|------ java.util.concurrent.locks.ReentrantLock
 * 
 * 		java.util.concurrent.locks.ReadWriteLock
 * 				|
 * 				|------ java.util.concurrent.locks.ReentrantReadWriteLock
 * 		
 * 		java.util.concurrent.locks.Condition
 * 
 * 		java.lang.Object
 * 
 * 		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 
 * 		java.lang.ThreadLocal<T>
 * 
 * 		java.util.concurrent.ThreadLocalRandom
 * 
 * =====================================
 * Class/Interface Summary
 * =====================================
 * Class/Interface			Brief
 * -------------------------------------------------------------------------------------------------
 * java.lang.Runnable		An interface that is designed to provide a common protocol for objects which wish to execute code while active.
 * java.lang.Thread			A class that represents a thread of execution in a program.
 * 
 * java.util.concurrent.locks.Lock
 * 							An interface that represents a mutual exclusion lock, for controlling access to a shared resource by multiple threads.
 * java.util.concurrent.locks.ReentrantLock
 * 							A class as a reentrant Lock implementation.
 * java.util.concurrent.locks.ReadWriteLock
 * 							An interface that represents a pair of associated Read and Write locks, for controlling access to a shared resource by multiple threads.
 * java.util.concurrent.locks.ReentrantReadWriteLock
 * 							A class as a reentrant ReadWriteLock implementation.
 * 
 * java.util.concurrent.locks.Condition
 * 							An interface that represents a condition providing a means for one thread to suspend execution until notified by another thread.
 * 
 * java.lang.Object			The class as the root of the class hierarchy. Every class has this class as a superclass.
 * 
 * java.lang.ThreadLocal<T>	A class that provides thread-local variables.
 * java.util.concurrent.ThreadLocalRandom
 * 							A class acting as a random number generator isolated to the current thread.
 * 
 * =====================================
 * Class/Interface Details
 * =====================================
 * java.lang.Runnable
 * java.lang.Runnable is an interface that is designed to provide a common protocol for objects which wish to execute code while active.
 * This interface should be implemented by any class whose instances are intended to be executed by a thread.
 * It has main public members as follows.
 * Member									Description
 * -------------------------------------------------------------------------------------------------
 * void run();								Run the process inside this method (normally this method should not be invoked since it won't start a new thread as possibly expected).
 * 
 * java.lang.Thread
 * java.lang.Thread is a class that represents a thread of execution in a program.
 * It has main public members as follows.
 * Field/Method								Description
 * -------------------------------------------------------------------------------------------------
 * public final static int MIN_PRIORITY = ...;
 * public final static int NORM_PRIORITY = ...;
 * public final static int MAX_PRIORITY = ...;
 * 											The minimum/normal (default)/maximum thread priority.
 * -------------------------------------
 * public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {...}
 * 											Return the default handler invoked when a thread abruptly terminates due to an uncaught exception.
 * public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {...}
 * 											Set the default handler invoked when a thread abruptly terminates due to an uncaught exception.
 * public static int activeCount() {...}	Return an estimate of the number of active threads in the current thread's thread group and its subgroups. (This method should be used primarily for debugging and monitoring)
 * public static int enumerate(Thread[] threadArray) {...}
 * 											Copy into the specified array every active thread in the current thread's thread group and its subgroups. (It is recommended that this method is used only for debugging and monitoring.)
 * public static Map<Thread, StackTraceElement[]> getAllStackTraces() {...}
 * 											Return a map of stack traces for all live threads.
 * public static native Thread currentThread();
 * 											Return the current thread.
 * public static native void sleep(long milliseconds) throws InterruptedException;
 * 											Cause the current thread to sleep for the specified number of milliseconds.
 * public static void sleep(long milliseconds, int nanoseconds) throws InterruptedException {...}
 * 											Cause the current thread to sleep for the specified number of milliseconds plus the specified number of nanoseconds.
 * public static boolean interrupted() {...}
 * 											Return whether the current thread has been interrupted. Note: The interrupted status of the current thread is cleared by this method.
 * public static native boolean holdsLock(Object object);
 * 											Return whether the current thread holds the monitor lock on the specified object.
 * public static void dumpStack() {...}		Print a stack trace of the current thread. (This method is used only for debugging.)
 * public static native void yield();		Send a hint to the scheduler that the current thread is willing to yield its current use of a processor. (It is rarely appropriate to use this method. This method may be useful for debugging or testing, and for designing concurrency control constructs.)
 * -------------------------------------
 * public Thread() {...}					Allocate a new thread.
 * public Thread(Runnable target) {...}		Allocate a new thread for the specified runnable object.
 * public Thread(Runnable target, String name) {...}
 * 											Allocate a new thread with the specified name and for the specified runnable object.
 * public Thread(String name) {...}			Allocate a new thread with the specified name.
 * public Thread(ThreadGroup group, Runnable target) {...}
 * 											Allocate a new thread for the specified runnable object, and as the member of the specified thread group.
 * public Thread(ThreadGroup group, Runnable target, String name) {...}
 * 											Allocate a new thread with the specified name and for the specified runnable object, and as the member of the specified thread group.
 * public Thread(ThreadGroup group, Runnable target, String name, long stackSize) {...}
 * 											Allocate a new thread with the specified name and stack size, and for the specified runnable object, and as the member of the specified thread group.
 * public Thread(ThreadGroup group, String name) {...}
 * 											Allocate a new thread with the specified name, and as the member of the specified thread group.
 * public long getId() {...}				Return the ID of this thread.
 * public final String getName() {...}		Return the name of this thread.
 * public final synchronized void setName(String name) {...}
 * 											Set the name of this thread using the specified name.
 * public final int getPriority() {...}		Return the priority of this thread.
 * public final void setPriority(int priority) {...}
 * 											Set the priority of this thread using the specified priority.
 * public State getState() {...}			Return the state of this thread.
 * public final native boolean isAlive();	Return whether this thread is alive.
 * public final boolean isDaemon() {...}	Return whether this thread is a daemon thread.
 * public final void setDaemon(boolean on) {...}
 * 											Mark this thread as either a daemon thread or a user thread.
 * public boolean isInterrupted() {...}		Return whether this thread has been interrupted. The interrupted status of this thread is unaffected by this method.
 * public final ThreadGroup getThreadGroup() {...}
 * 											Return the thread group of this thread.
 * public ClassLoader getContextClassLoader() {...}
 * 											Return the context class loader for this thread.
 * public void setContextClassLoader(ClassLoader classLoader) {...}
 * 											Set the context class loader for this thread.
 * public UncaughtExceptionHandler getUncaughtExceptionHandler() {...}
 * 											Return the handler invoked when this thread abruptly terminates due to an uncaught exception.
 * public void setUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {...}
 * 											Set the handler invoked when this thread abruptly terminates due to an uncaught exception.
 * public StackTraceElement[] getStackTrace() {...}
 * 											Return an array of stack trace elements representing the stack dump of this thread.
 * public synchronized void start() {...}	Start this thread. 
 * public void interrupt() {...}			Interrupt this thread.
 * public final void checkAccess() {...}	Check whether the current thread has permission to modify this thread.
 * public final void join() throws InterruptedException {...}
 * 											Wait for this thread to die.
 * public final synchronized void join(long milliseconds) throws InterruptedException {...}
 * 											Wait at most the specified milliseconds for this thread to die.
 * public final synchronized void join(long milliseconds, int nanoseconds) throws InterruptedException {...}
 * 											Wait at most the specified milliseconds plus the specified nanoseconds for this thread to die.
 * 
 * java.util.concurrent.locks.Lock
 * java.util.concurrent.locks.Lock is an interface that represents a mutual exclusion lock, for controlling access to a shared resource by multiple threads.
 * Commonly, a lock provides exclusive access to a shared resource: only one thread at a time can acquire the lock
 * and all access to the shared resource requires that the lock be acquired first.
 * However, some locks may allow concurrent access to a shared resource, such as the read lock of a ReadWriteLock.
 * It has main public members as follows.
 * Member									Description
 * -------------------------------------------------------------------------------------------------
 * void lock();								Acquire the lock.
 * void unlock();							Release the lock.
 * Condition newCondition();				Return a new Condition instance that is bound to this Lock instance.
 * void lockInterruptibly() throws InterruptedException;
 * 											Acquire the lock unless the current thread is interrupted.
 * boolean tryLock();						Acquire the lock only if it is free at the time of invocation.
 * boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
 * 											Acquire the lock if it is free within the given waiting time and the current thread has not been interrupted.
 * 
 * java.util.concurrent.locks.ReentrantLock
 * java.util.concurrent.locks.ReentrantLock is a class as a reentrant Lock implementation.
 * It has main public members as follows.
 * Member									Description
 * -------------------------------------------------------------------------------------------------
 * public ReentrantLock() {...}				Create an instance of ReentrantLock.
 * public ReentrantLock(boolean fair) {...}	Create an instance of ReentrantLock with the given fairness policy.
 * public int getHoldCount() {...}			Query the number of holds on this lock by the current thread.
 * public final int getQueueLength() {...}	Return an estimate of the number of threads waiting to acquire this lock.
 * public final boolean hasQueuedThread(Thread thread) {...}
 * 											Query whether the given thread is waiting to acquire this lock.
 * public final boolean hasQueuedThreads() {...}
 * 											Query whether any threads are waiting to acquire this lock.
 * public int getWaitQueueLength(Condition condition) {...}
 * 											Return an estimate of the number of threads waiting on the given condition associated with this lock.
 * public boolean hasWaiters(Condition condition) {...}
 * 											Query whether any threads are waiting on the given condition associated with this lock.
 * public final boolean isFair() {...}		Return true if this lock has fairness set true.
 * public boolean isHeldByCurrentThread() {...}
 * 											Query if this lock is held by the current thread.
 * public boolean isLocked() {...}			Query if this lock is held by any thread.
 * 
 * java.util.concurrent.locks.ReadWriteLock
 * java.util.concurrent.locks.ReadWriteLock is an interface that represents a pair of associated Read and Write locks, for controlling access to a shared resource by multiple threads.
 * The Write lock is still exclusive, while the Read lock may be held simultaneously by multiple threads.
 * The pair of the Read and Write locks may have better performance than the mutual exclusion lock.
 * It has main public members as follows.
 * Member									Description
 * -------------------------------------------------------------------------------------------------
 * Lock readLock();							Return the Read lock used for reading.
 * Lock writeLock();						Return the Write lock used for writing.
 * 
 * java.util.concurrent.locks.ReentrantReadWriteLock
 * java.util.concurrent.locks.ReentrantReadWriteLock is a class as a reentrant ReadWriteLock implementation.
 * It has main public members as follows.
 * Member									Description
 * -------------------------------------------------------------------------------------------------
 * public ReentrantReadWriteLock() {...}	Create an instance of ReentrantReadWriteLock.
 * public ReentrantReadWriteLock(boolean fair) {...}
 * 											Create an instance of ReentrantReadWriteLock with the given fairness policy.
 * public final boolean isFair() {...}		Return true if this lock has fairness set true.
 * public final boolean hasQueuedThreads() {...}
 * 											Query whether any threads are waiting to acquire the read or write lock.
 * public final boolean hasQueuedThread(Thread thread) {...}
 * 											Query whether the given thread is waiting to acquire either the read or write lock.
 * public final int getQueueLength() {...}	Return an estimate of the number of threads waiting to acquire either the read or write lock.
 * public boolean isWriteLocked() {...}		Query if the write lock is held by any thread.
 * public boolean isWriteLockedByCurrentThread() {...}
 * 											Query if the write lock is held by the current thread.
 * public int getReadHoldCount() {...}		Query the number of reentrant read holds on this lock by the current thread.
 * public int getWriteHoldCount() {...}		Query the number of reentrant write holds on this lock by the current thread.
 * public int getReadLockCount() {...}		Query the number of read locks held for this lock.
 * public boolean hasWaiters(Condition condition) {...}
 * 											Query whether any threads are waiting on the given condition associated with the write lock.
 * public int getWaitQueueLength(Condition condition) {...}
 * 											Return an estimate of the number of threads waiting on the given condition associated with the write lock.
 * 
 * java.util.concurrent.locks.Condition
 * java.util.concurrent.locks.Condition is an interface that represents a condition providing a means for one thread to suspend execution until notified by another thread.
 * A Condition instance is intrinsically bound to a lock.
 * It has main public members as follows.
 * Member									Description
 * -------------------------------------------------------------------------------------------------
 * void await() throws InterruptedException;
 * 											Cause the current thread to wait until it is signaled or interrupted.
 * boolean await(long time, TimeUnit unit) throws InterruptedException;
 * 											Cause the current thread to wait until it is signaled or interrupted, or the specified waiting time elapses.
 * long awaitNanos(long nanosTimeout) throws InterruptedException;
 * 											Cause the current thread to wait until it is signaled or interrupted, or the specified waiting time elapses.
 * void awaitUninterruptibly();				Cause the current thread to wait until it is signaled.
 * boolean awaitUntil(Date deadline) throws InterruptedException;
 * 											Cause the current thread to wait until it is signaled or interrupted, or the specified deadline elapses.
 * void signalAll();						Wake up all waiting threads.
 * void signal();							Wake up one waiting thread.
 * 
 * java.lang.Object
 * java.lang.Object is the class as the root of the class hierarchy. Every class has this class as a superclass.
 * It has main public members about multi-threading as follows.
 * Member									Description
 * -------------------------------------------------------------------------------------------------
 * public final native void notify();		Wake up one waiting thread.
 * public final native void notifyAll();	Wake up all waiting threads.
 * public final void wait() throws InterruptedException {...}
 * 											Cause the current thread to wait until it is notified.
 * public final native void wait(long timeout) throws InterruptedException;
 * 											Cause the current thread to wait until it is notified, or the specified waiting time elapses.
 * public final void wait(long timeout, int nanos) throws InterruptedException {...}
 * 											Cause the current thread to wait until it is notified, or the specified waiting time elapses.
 * 
 * java.lang.ThreadLocal<T>
 * java.lang.ThreadLocal<T> is a class that provides thread-local variables.
 * ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread (e.g., a user ID or Transaction ID). 
 * It has main public members as follows.
 * Member									Description
 * -------------------------------------------------------------------------------------------------
 * public T get() {...}						Return the value in the current thread's copy of this thread-local variable.
 * public void remove() {...}				Remove the current thread's value for this thread-local variable.
 * public void set(T value) {...}			Set the current thread's copy of this thread-local variable to the specified value.
 * 
 * =====================================
 * Ways to Create a Thread
 * =====================================
 * There are 2 ways to create threads, as follows.
 * 
 * 1. Declaring a Class Extending the java.lang.Thread Class
 * 		Steps
 * 		1. Declare a class extending the java.lang.Thread class, and override the "run()" method in that class as needed.
 * 		2. Instantiate that class and invoke the "start()" method of the instance.
 * 
 * 		Example
 * 		------------------------------------------------------------------------
 * 		public class SomeThread extends Thread {
 * 			...
 * -		@Override
 * 			public void run() {
 * 				...
 * 			}
 * 			...
 * 		}
 * 		----------------------------------------------------
 * 		new SomeThread().start();
 * 		------------------------------------------------------------------------
 * 
 * 		Remarks
 * 		This way to create threads is not recommended when there are many tasks to handle,
 * 		because it will cost much to create a thread for every task.
 * 
 * 2. Declaring a Class Implementing the java.lang.Runnable Interface
 * 		Steps
 * 		1. Declare a class implementing the java.lang.Runnable interface, and override the "run()" method in that class as needed.
 * 		2. Instantiate the java.lang.Thread class with an instance of that class as the constructor argument,
 * 		   then invoke the "start()" method of the instance of the java.lang.Thread class.
 * 
 * 		Example
 * 		------------------------------------------------------------------------
 * 		public class SomeRunnable implements Runnable {
 * 			...
 * -		@Override
 * 			public void run() {
 * 				...
 * 			}
 * 			...
 * 		}
 * 		----------------------------------------------------
 * 		new Thread(new SomeRunnable()).start();
 * 		------------------------------------------------------------------------
 * 
 * =====================================
 * Interrupting the Thread
 * =====================================
 * The java.lang.Thread.interrupt() method is used to interrupt the thread.
 * 
 * If the thread is blocked in an invocation of the following methods,
 * - java.lang.Object.wait(...)
 * - java.lang.Thread.join(...)
 * - java.lang.Thread.sleep(...)
 * then its interrupt status will be cleared and it will receive a java.lang.InterruptedException.
 * 
 * If the thread is blocked in an I/O operation upon a java.nio.channels.InterruptibleChannel,
 * then the channel will be closed, the thread's interrupt status will be set,
 * and the thread will receive a java.nio.channels.ClosedByInterruptException.
 * 
 * If the thread is blocked in a java.nio.channels.Selector,
 * then the thread's interrupt status will be set
 * and it will return immediately from the selection operation
 * 
 * If none of the previous conditions hold then the thread's interrupt status will be set.
 * 
 * Interrupting a thread that is not alive need not have any effect.
 * 
 * THERE IS NO REQUIREMENT THAT AN INTERRUPTED THREAD SHOULD BE TERMINATED.
 * BUT GENERALLY, THAT IS THE CASE.
 * 
 * A way to run a thread able to detect the interruption is as follows.
 * -------------------------------------------------------------------------------------------------
 * public void run() {
 *     ...
 *     try {
 *         ...
 *         while (!Thread.currentThread().isInterrupted() && SOME_BUSINESS_CONDITIONS) {
 *             ...
 *         }
 *         ...
 *     } catch (InterruptedException e) {
 *         // The InterruptedException exception is thrown when current thread is interrupted
 *         // and meanwhile, current thread is also blocked by a Sleep, Join or Wait operation.
 * 
 *         // Perform the exception handling here.
 *     } finally {
 *         // Perform the cleanup here (if necessary).
 *     }
 *     ...
 * }
 * -------------------------------------------------------------------------------------------------
 * 
 * =====================================
 * Thread States
 * =====================================
 * A thread can have 6 states as follows.
 * State			Description
 * -----------------------------------------------------------------------------
 * NEW				This state indicates that the thread has not started.
 * 
 * RUNNABLE			This state indicates that the thread is executing
 * 					but it may be waiting for other resources from the OS such as the processor.
 * 
 * BLOCKED			This state indicates that the thread is blocked due to waiting for a monitor lock,
 * 					to enter a synchronized block/method or reenter a synchronized block/method
 * 					after calling the java.lang.Object.wait(...) method.
 * 
 * WAITING			This state indicates that the thread is waiting for another thread to perform a particular action.
 * 
 * 					For example, a thread that has called the java.lang.Object.wait(...) method on an object is waiting for
 * 					another thread to call the java.lang.Object.notify() method or the java.lang.Object.notifyAll() method on that object.
 * 
 * 					For example, a thread that has called the java.lang.Thread.join(...) method is waiting for the specified thread to terminate.
 * 
 * 					A thread is of the WAITING state due to calling one of the following methods.
 * 					- java.lang.Object.wait(...) with no timeout
 * 					- java.lang.Thread.join(...) with no timeout
 * 					- java.util.concurrent.locks.LockSupport.park(...)
 * 
 * TIMED_WAITING	This state indicates that the thread is waiting for another thread to perform a particular action, within a specified waiting time.
 * 
 * 					A thread is of the TIMED_WAITING state due to calling one of the following methods.
 * 					- java.lang.Thread.sleep(...)
 * 					- java.lang.Object.wait(...) with timeout
 * 					- java.lang.Thread.join(...) with timeout
 * 					- java.util.concurrent.locks.LockSupport.parkNanos(...)
 * 					- java.util.concurrent.locks.LockSupport.parkUntil(...)
 * 
 * TERMINATED		This state indicates that the thread has completed its execution and is terminated.
 * 
 * =====================================
 * Thread Synchronization
 * =====================================
 * Thread synchronization is defined as a mechanism which ensures that multiple concurrent threads do not simultaneously
 * execute some particular program segment known as Critical Section.
 * 
 * When one thread starts executing the critical section (serialized segment of the program)
 * the other threads should wait until the first thread finishes.
 * 
 * If proper synchronization techniques are not applied, it may cause a Race Condition where,
 * the values of variables may be unpredictable and vary depending on the timings of context switches of the threads.
 * 
 * Synchronization Requirements
 * 1. If multiple threads try to access the same resource, only one thread should be allowed to access that resource at a time.
 * 2. The order of the threads to be executed should also be considered.
 * 
 * =====================================
 * Ways to Achieve Thread Synchronization
 * =====================================
 * 1. Using the Lock Object in Methods
 * 		Steps
 * 		1. Declare a lock.
 * 		2. Initialize the lock.
 * 		3. Acquire the lock, before executing the critical section.
 * 		4. Surround the critical section with the try/finally block.
 * 		5. Release the lock, in the finally sub-block.
 * 
 * 		Example
 * 		------------------------------------------------------------------------
 * 		public class SomeObject {
 * 			// Declare and initialize the lock.
 * 			private Lock lock = new ReentrantLock();
 * 
 * 			public void doSomething() {
 * 				// Acquire the lock.
 * 				lock.lock();
 * 
 * 				try {
 * 					... Critical Section ...
 * 				} finally {
 * 					// Release the lock.
 * 					lock.unlock();
 * 				}
 * 			}
 * 		}
 * 		------------------------------------------------------------------------
 * 
 * 2. Using the Lock Object in Methods with the Condition Object
 * 		Steps
 * 		1. Declare a lock and a condition.
 * 		2. Initialize the lock and the condition.
 * 		3. Acquire the lock, before executing the critical section.
 * 		4. Surround the critical section with the try/finally block.
 * 		5. Make current thread wait per the condition, in the try sub-block and before the critical section.
 * 		6. Wake up all waiting threads per the condition, in the try sub-block and after the critical section.
 * 		7. Release the lock, in the finally sub-block.
 * 
 * 		Example
 * 		------------------------------------------------------------------------
 * 		public class SomeObject {
 * 			// Declare and initialize the lock and the condition.
 * 			private Lock lock = new ReentrantLock();
 * 			private Condition condition = lock.newCondition();
 * 
 * 			public void doSomething() {
 * 				// Acquire the lock.
 * 				lock.lock();
 * 
 * 				try {
 * 					while (...) {
 * 						// Make current thread wait per the condition.
 * 						condition.await();
 * 					}
 * 
 * 					... Critical Section ...
 * 
 * 					// Wake up all waiting threads per the condition.
 * 					condition.signalAll();
 * 				} finally {
 * 					// Release the lock.
 * 					lock.unlock();
 * 				}
 * 			}
 * 		}
 * 		------------------------------------------------------------------------
 * 
 * 3. Using the synchronized Modifier on Methods
 * 		Steps
 * 		1. Add the synchronized modifier to all methods which are critical sections.
 * 
 * 		Example
 * 		------------------------------------------------------------------------
 * 		public class SomeObject {
 * 			public synchronized void doSomething() {
 * 				... Critical Section ...
 * 			}
 * 		}
 * 		------------------------------------------------------------------------
 * 
 * 		Remarks
 * 		------------------------------------------------------------------------
 * 		The method with the synchronized modifier as follows
 * 			public synchronized void doSomething() {
 * 				...
 * 			}
 * 		is equivalent to the following method.
 * 			public void doSomething() {
 * 				this.<intrinsicLock>.lock()
 * 
 * 				try {
 * 					...
 * 				} finally {
 * 					this.<intrinsicLock>.unlock();
 * 				}
 * 			}
 * 		Here, this.<intrinsicLock> is the intrinsic lock of every object.
 * 		------------------------------------------------------------------------
 * 
 * 4. Using the synchronized Modifier on Methods with the Object Intrinsic Condition Object
 * 		Steps
 * 		1. Add the synchronized modifier to all methods which are critical sections.
 * 		2. In a method, cause the thread to wait (per the object intrinsic condition), in some condition block and before the critical section.
 * 		3. In a method, wake up all waiting threads (per the object intrinsic condition), after the critical section.
 * 
 * 		Example
 * 		------------------------------------------------------------------------
 * 		public class SomeObject {
 * 			public synchronized void doSomething() {
 * 				while (...) {
 * 					// Cause the thread to wait (per the object intrinsic condition).
 * 					// wait() -> java.lang.Object.wait()
 * 					// Equivalent Statement for the Thread Condition: condition.await();
 * 					wait();
 * 				}
 * 
 * 				... Critical Section ...
 * 
 * 				// Wake up all waiting threads (per the object intrinsic condition).
 * 				// notifyAll() -> java.lang.Object.notifyAll()
 * 				// Equivalent Statement for the Thread Condition: condition.signalAll();
 * 				notifyAll();
 * 			}
 * 		}
 * 		------------------------------------------------------------------------
 * 
 * 5. Using the synchronized Block in Methods
 * 		Steps
 * 		1. Add the synchronized block in methods to surround the critical sections.
 * 
 * 		Example
 * 		------------------------------------------------------------------------
 * 		public class SomeObject {
 * 			public void doSomething() {
 * 				synchronized (VARIABLE_OF_THE_CRITICAL_SECTION) {
 * 					... Critical Section ...
 * 				}
 * 			}
 * 		}
 * 		------------------------------------------------------------------------
 * 
 * 6. Using the volatile Modifier on Fields
 * 		Steps
 * 		1. Add the volatile modifier on fields, that may be accessed by multiple threads.
 * 
 * 		Example
 * 		------------------------------------------------------------------------
 * 		public class SomeObject {
 * 			private volatile boolean done;
 * 
 * 			public boolean isDone() {
 * 				return done;
 * 			}
 * 
 * 			public void setDone(boolean done) {
 * 				this.done = done;
 * 			}
 * 		}
 * 		------------------------------------------------------------------------
 * 
 * 		Remarks
 * 		- This approach only works for synchronization on the access methods (the getter and setter).
 * 		- Here is an equivalent example to the above one, using the synchronized modifier.
 * 		------------------------------------------------------------------------
 * 		public class SomeObject {
 * 			private boolean done;
 * 
 * 			public synchronized boolean isDone() {
 * 				return done;
 * 			}
 * 
 * 			public synchronized void setDone(boolean done) {
 * 				this.done = done;
 * 			}
 * 		}
 * 		------------------------------------------------------------------------
 * 
 * 7. Using the final Modifier on Fields
 * 		Steps
 * 		1. Add the final modifier on fields, that may be accessed by multiple threads.
 * 
 * 		Example
 * 		------------------------------------------------------------------------
 * 		public class SomeObject {
 * 			private final Map<String, Double> accounts = new HashMap<>();
 * 		}
 * 		------------------------------------------------------------------------
 * 
 * 		Remarks
 * 		- This approach only works for synchronization on the initialization of fields in their declaration.
 * 		- When the accounts field is modified by the final modifier,
 * 		  all other threads can see the accounts field only after the accounts field is initialized using new HashMap<>().
 * 		  If without the final modifier, some other threads may see the accounts field before it is initialized.
 * 
 * =====================================
 * Cases Easy to Produce Dead Lock
 * =====================================
 * 1. The Lock Is Kept Unreleased
 *    If a lock is not released after a critical section is executed,
 *    then other threads will be ALWAYS blocked (at least for this critical section).
 * 
 * 2. The Process Is Certain/Easier to Make All Threads Blocked
 *    Sometimes a process badly implemented may cause that all threads are certain/easier to be locked after running for a period.
 * 
 * 3. Only One instead of All Sleeping Threads Is Notified to Wake up
 *    Assuming the only awake thread finishes its execution now and then notifies only one instead of all sleeping threads to wake up,
 *    if unfortunately, the notified thread does not satisfy the lock condition still,
 *    and the only awake thread now becomes unsatisfied with the lock condition either,
 *    all threads will be sleeping.
 * 
 * =====================================
 * References
 * =====================================
 * Wikipedia - Synchronization (Computer Science)
 * https://en.wikipedia.org/wiki/Synchronization_(computer_science)
 * </pre>
 */
public class Introduction {

	// +++++++++++++
	// Contents
	// +++++++++++++
	// Testing the java.lang.Runnable Interface
	// Testing the java.lang.Thread Class
	// Testing the java.util.concurrent.locks.Lock Interface
	// Testing the java.util.concurrent.locks.ReentrantLock Class
	// Testing the java.util.concurrent.locks.ReadWriteLock Interface
	// Testing the java.util.concurrent.locks.ReentrantReadWriteLock Class
	// Testing the java.util.concurrent.locks.Condition Interface
	// Testing the java.lang.Object Class
	// Testing the java.lang.ThreadLocal<T> Class
	// Testing the Thread States
	// Testing the Thread Synchronization
	// Testing the Ways to Create a Thread

	private static Integer someCounter = 0;

	private static final ThreadLocal<Integer> threadLocalVariable = new ThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			return Calendar.getInstance().get(Calendar.MILLISECOND);
		}

	};

	private static class SomeThread extends Thread {

		@Override
		public void run() {
			System.out.println(this.getClass().getName() + ": Doing something...");
			// ...
		}

	}

	private static class SomeRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println(this.getClass().getName() + ": Doing something...");
			// ...
		}

	}

	// >>>>> for Testing the ReentrantLock Class >>>>>

	private static interface SomeObject {

		void doSomething();

	}

	private static class SomeObject1 implements SomeObject {

		private ReentrantLock lock;
		private List<Thread> existingThreads;

		public SomeObject1(List<Thread> existingThreads) {
			lock = new ReentrantLock();
			System.out.println(getMessagePrefix() + "lock.isFair(): " + lock.isFair());
			this.existingThreads = existingThreads;
		}

		private void printThreadsWaitingToAcquireLock() {
			List<Thread> threadsWaitingToAcquireLock = new ArrayList<>();

			synchronized (existingThreads) {
				for (Thread thread : existingThreads) {
					if (lock.hasQueuedThread(thread)) {
						threadsWaitingToAcquireLock.add(thread);
					}
				}
			}

			System.out.println(getMessagePrefix() + "threadsWaitingToAcquireLock: " + threadsWaitingToAcquireLock);
		}

		@Override
		public void doSomething() {
			String messagePrefix = getMessagePrefix();

			System.out.println(messagePrefix + "existingThreads: " + existingThreads);
			printThreadsWaitingToAcquireLock();

			System.out.println(messagePrefix + "lock.isLocked(): " + lock.isLocked());
			System.out.println(messagePrefix + "lock.getHoldCount(): " + lock.getHoldCount());
			System.out.println(messagePrefix + "lock.isHeldByCurrentThread(): " + lock.isHeldByCurrentThread());

			System.out.println(messagePrefix + "lock.getQueueLength(): " + lock.getQueueLength());
			System.out.println(messagePrefix + "lock.hasQueuedThreads(): " + lock.hasQueuedThreads());
			System.out.println();

			lock.lock();

			try {
				System.out.println(messagePrefix + "lock.isLocked(): " + lock.isLocked());
				System.out.println(messagePrefix + "lock.getHoldCount(): " + lock.getHoldCount());
				System.out.println(messagePrefix + "lock.isHeldByCurrentThread(): " + lock.isHeldByCurrentThread());

				// Do something...

				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		private String getMessagePrefix() {
			return Thread.currentThread().getName() + ": ";
		}

	}

	private static class SomeObject2 implements SomeObject {

		private ReentrantLock lock;
		private Condition condition;

		public SomeObject2() {
			lock = new ReentrantLock(true);
			condition = lock.newCondition();
			System.out.println(getMessagePrefix() + "lock.isFair(): " + lock.isFair());
		}

		@Override
		public void doSomething() {
			String messagePrefix = getMessagePrefix();

			lock.lock();

			try {
				System.out.println(
						messagePrefix + "lock.getWaitQueueLength(condition): " + lock.getWaitQueueLength(condition));
				System.out.println(messagePrefix + "lock.hasWaiters(condition): " + lock.hasWaiters(condition));

				if (Calendar.getInstance().get(Calendar.MILLISECOND) % 2 != 0) {
					condition.await();
				}

				// Do something...

				condition.signalAll();

				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		private String getMessagePrefix() {
			return Thread.currentThread().getName() + ": ";
		}

	}

	private static class SomeObjectProcess implements Runnable {

		private SomeObject someObject;

		public SomeObjectProcess(SomeObject someObject) {
			this.someObject = someObject;
		}

		@Override
		public void run() {
			someObject.doSomething();
		}

	}

	// <<<<< for Testing the ReentrantLock Class <<<<<

	// >>>>> for Testing the ReentrantReadWriteLock Class >>>>>

	private static interface SomeCoolObject {

		void doSomethingForWriting();

		void doSomethingForReading();

	}

	private static class SomeCoolObjectProcess implements Runnable {

		private SomeCoolObject someCoolObject;

		public SomeCoolObjectProcess(SomeCoolObject someCoolObject) {
			this.someCoolObject = someCoolObject;
		}

		@Override
		public void run() {
			someCoolObject.doSomethingForWriting();
			someCoolObject.doSomethingForReading();
		}

	}

	private static class SomeCoolObject1 implements SomeCoolObject {

		private ReentrantReadWriteLock lock;
		private ReentrantReadWriteLock.WriteLock writeLock;
		private ReentrantReadWriteLock.ReadLock readLock;
		private List<Thread> existingThreads;

		public SomeCoolObject1(List<Thread> existingThreads) {
			lock = new ReentrantReadWriteLock();
			writeLock = lock.writeLock();
			readLock = lock.readLock();
			System.out.println(getMessagePrefix(null) + "lock.isFair(): " + lock.isFair());
			this.existingThreads = existingThreads;
		}

		private void printThreadsWaitingToAcquireLock(String additionalInfo) {
			List<Thread> threadsWaitingToAcquireLock = new ArrayList<>();

			synchronized (existingThreads) {
				for (Thread thread : existingThreads) {
					if (lock.hasQueuedThread(thread)) {
						threadsWaitingToAcquireLock.add(thread);
					}
				}
			}

			System.out.println(
					getMessagePrefix(additionalInfo) + "threadsWaitingToAcquireLock: " + threadsWaitingToAcquireLock);
		}

		@Override
		public void doSomethingForWriting() {
			String messagePrefix = getMessagePrefix("Writing");

			System.out.println(messagePrefix + "existingThreads: " + existingThreads);
			printThreadsWaitingToAcquireLock("Writing");

			System.out.println(messagePrefix + "lock.hasQueuedThreads(): " + lock.hasQueuedThreads());
			System.out.println(messagePrefix + "lock.getQueueLength(): " + lock.getQueueLength());
			System.out.println();

			System.out.println(messagePrefix + "lock.isWriteLocked(): " + lock.isWriteLocked());
			System.out.println(
					messagePrefix + "lock.isWriteLockedByCurrentThread(): " + lock.isWriteLockedByCurrentThread());
			System.out.println(messagePrefix + "lock.getWriteHoldCount(): " + lock.getWriteHoldCount());

			writeLock.lock();

			try {
				System.out.println(messagePrefix + "lock.isWriteLocked(): " + lock.isWriteLocked());
				System.out.println(
						messagePrefix + "lock.isWriteLockedByCurrentThread(): " + lock.isWriteLockedByCurrentThread());
				System.out.println(messagePrefix + "lock.getWriteHoldCount(): " + lock.getWriteHoldCount());

				// Do something...

				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				writeLock.unlock();
			}
		}

		@Override
		public void doSomethingForReading() {
			String messagePrefix = getMessagePrefix("Reading");

			System.out.println(messagePrefix + "existingThreads: " + existingThreads);
			printThreadsWaitingToAcquireLock("Reading");

			System.out.println(messagePrefix + "lock.hasQueuedThreads(): " + lock.hasQueuedThreads());
			System.out.println(messagePrefix + "lock.getQueueLength(): " + lock.getQueueLength());
			System.out.println();

			System.out.println(messagePrefix + "lock.getReadHoldCount(): " + lock.getReadHoldCount());
			System.out.println(messagePrefix + "lock.getReadLockCount(): " + lock.getReadLockCount());

			readLock.lock();

			try {
				System.out.println(messagePrefix + "lock.getReadHoldCount(): " + lock.getReadHoldCount());
				System.out.println(messagePrefix + "lock.getReadLockCount(): " + lock.getReadLockCount());

				// Do something...

				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				readLock.unlock();
			}
		}

		private String getMessagePrefix(String additionalInfo) {
			String additionalInfoText = "";
			if (additionalInfo != null) {
				additionalInfoText = " (" + additionalInfo + ") ";
			}

			return Thread.currentThread().getName() + additionalInfoText + ": ";
		}

	}

	private static class SomeCoolObject2 implements SomeCoolObject {

		private ReentrantReadWriteLock lock;
		private ReentrantReadWriteLock.WriteLock writeLock;
		private Condition writeCondition;

		public SomeCoolObject2() {
			lock = new ReentrantReadWriteLock(true);
			writeLock = lock.writeLock();
			writeCondition = writeLock.newCondition();
			System.out.println(getMessagePrefix(null) + "lock.isFair(): " + lock.isFair());
		}

		@Override
		public void doSomethingForWriting() {
			String messagePrefix = getMessagePrefix("Writing");

			writeLock.lock();

			try {
				System.out
						.println(messagePrefix + "lock.hasWaiters(writeCondition): " + lock.hasWaiters(writeCondition));
				System.out.println(messagePrefix + "lock.getWaitQueueLength(writeCondition): "
						+ lock.getWaitQueueLength(writeCondition));

				if (Calendar.getInstance().get(Calendar.MILLISECOND) % 2 != 0) {
					writeCondition.await();
				}

				// Do something...

				writeCondition.signalAll();

				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				writeLock.unlock();
			}
		}

		@Override
		public void doSomethingForReading() {
		}

		private String getMessagePrefix(String additionalInfo) {
			String additionalInfoText = "";
			if (additionalInfo != null) {
				additionalInfoText = " (" + additionalInfo + ") ";
			}

			return Thread.currentThread().getName() + additionalInfoText + ": ";
		}

	}

	// <<<<< for Testing the ReentrantReadWriteLock Class <<<<<

	// >>>>> for Testing the java.lang.Object Class >>>>>

	private static class SomeGoodObject {

		public synchronized void doSomething1() throws InterruptedException {
			if (true) {
				wait();
			}

			// Do something...

			notifyAll();
		}

		public synchronized void doSomething2() throws InterruptedException {
			if (true) {
				wait(1000);
			}

			// Do something...

			notifyAll();
		}

		public synchronized void doSomething3() throws InterruptedException {
			if (true) {
				wait(1000, 10000);
			}

			// Do something...

			notify();
		}

	}

	private static class SomeGoodObjectProcess1 implements Runnable {

		private SomeGoodObject someGoodObject;

		public SomeGoodObjectProcess1(SomeGoodObject someGoodObject) {
			System.out.println(this);
			this.someGoodObject = someGoodObject;
		}

		@Override
		public void run() {
			try {
				someGoodObject.doSomething1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static class SomeGoodObjectProcess2 implements Runnable {

		private SomeGoodObject someGoodObject;

		public SomeGoodObjectProcess2(SomeGoodObject someGoodObject) {
			System.out.println(this);
			this.someGoodObject = someGoodObject;
		}

		@Override
		public void run() {
			try {
				someGoodObject.doSomething2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static class SomeGoodObjectProcess3 implements Runnable {

		private SomeGoodObject someGoodObject;

		public SomeGoodObjectProcess3(SomeGoodObject someGoodObject) {
			System.out.println(this);
			this.someGoodObject = someGoodObject;
		}

		@Override
		public void run() {
			try {
				someGoodObject.doSomething3();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// <<<<< for Testing the java.lang.Object Class <<<<<

	public static void main(String[] args) throws InterruptedException {
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.lang.Runnable Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					System.out.println("Runnable - Anonymous Inner Type: run(): ...");
				}

			};

			new Thread(runnable).start();

			// void run();
			// Note: The following method invocation will not start a new
			// thread.
			runnable.run();
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.lang.Thread Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{

			// public final static int MIN_PRIORITY = ...;
			// public final static int NORM_PRIORITY = ...;
			// public final static int MAX_PRIORITY = ...;
			{
				System.out.println("Thread.MIN_PRIORITY\t: " + Thread.MIN_PRIORITY);
				System.out.println("Thread.NORM_PRIORITY\t: " + Thread.NORM_PRIORITY);
				System.out.println("Thread.MAX_PRIORITY\t: " + Thread.MAX_PRIORITY);
			}

			Utils.printDelimiterLine2();

			// public static UncaughtExceptionHandler
			// getDefaultUncaughtExceptionHandler() {...}
			// public static void
			// setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler
			// uncaughtExceptionHandler) {...}
			{
				System.out.println(
						"Thread.getDefaultUncaughtExceptionHandler(): " + Thread.getDefaultUncaughtExceptionHandler());
				Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

					@Override
					public void uncaughtException(Thread thread, Throwable throwable) {
						// ...
					}

				});
				System.out.println(
						"Thread.getDefaultUncaughtExceptionHandler(): " + Thread.getDefaultUncaughtExceptionHandler());
			}

			Utils.printDelimiterLine2();

			// public static int activeCount() {...}
			{
				System.out.println("Thread.activeCount(): " + Thread.activeCount());
				new Thread().start();
				System.out.println("Thread.activeCount(): " + Thread.activeCount());
				new Thread().start();
				System.out.println("Thread.activeCount(): " + Thread.activeCount());
				new Thread().start();
				System.out.println("Thread.activeCount(): " + Thread.activeCount());
			}

			Utils.printDelimiterLine2();

			// public static int enumerate(Thread[] threadArray) {...}
			{
				// Define an array to hold all active threads.
				// Because the "Thread.activeCount()" method returns an
				// inaccurate value, the array here defines its size with a
				// buffer.
				Thread[] threads = new Thread[Thread.activeCount() + 100];

				Thread.enumerate(threads);

				for (Thread thread : threads) {
					if (thread != null) {
						System.out.println(thread);
					}
				}

				// The above statement block may print a result as follows.
				// Thread[<Name>,<Priority>,<GroupName>]
				// -----------------------------------------
				// Thread[main,5,main]
				// Thread[Thread-1,5,main]
				// Thread[Thread-2,5,main]
				// Thread[Thread-3,5,main]
				// -----------------------------------------
			}

			Utils.printDelimiterLine2();

			// public static Map<Thread, StackTraceElement[]>
			// getAllStackTraces() {...}
			{
				Map<Thread, StackTraceElement[]> allThreadStackTraces = Thread.getAllStackTraces();

				System.out.println("allThreadStackTraces.size(): " + allThreadStackTraces.size());
				System.out.println();

				System.out.println("Thread[<Name>,<Priority>,<GroupName>]");
				System.out.println();

				int threadStackTraceEntryCounter = 0;
				for (Map.Entry<Thread, StackTraceElement[]> threadStackTraceEntry : allThreadStackTraces.entrySet()) {
					threadStackTraceEntryCounter++;

					System.out.println("threadStackTraceEntry.getKey()\t\t: " + threadStackTraceEntry.getKey());
					System.out.println("threadStackTraceEntry.getValue()\t: " + threadStackTraceEntry.getValue());
					System.out.println("Arrays.toString(threadStackTraceEntry.getValue())\n\t\t\t\t\t: "
							+ Arrays.toString(threadStackTraceEntry.getValue()));

					if (threadStackTraceEntryCounter != allThreadStackTraces.size()) {
						System.out.println();
					}
				}
			}

			Utils.printDelimiterLine2();

			// public static native Thread currentThread();
			{
				System.out.println("Thread.currentThread(): " + Thread.currentThread());
			}

			Utils.printDelimiterLine2();

			// public static native void sleep(long milliseconds) throws
			// InterruptedException;
			// public static void sleep(long milliseconds, int nanoseconds)
			// throws InterruptedException {...}
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				try {
					Thread.sleep(500, 5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			Utils.printDelimiterLine2();

			// public static boolean interrupted() {...}
			{
				System.out.println("Thread.interrupted(): " + Thread.interrupted());
			}

			Utils.printDelimiterLine2();

			// public static native boolean holdsLock(Object object);
			{
				System.out.println("Thread.holdsLock(new Object()): " + Thread.holdsLock(new Object()));
			}

			Utils.printDelimiterLine2();

			// public static void dumpStack() {...}
			{
				Thread.dumpStack();
			}

			Utils.printDelimiterLine2();

			// public static native void yield();
			{
				Thread.yield();
			}

			Utils.printDelimiterLine2();

			// public Thread() {...}
			// public Thread(Runnable target) {...}
			// public Thread(Runnable target, String name) {...}
			// public Thread(String name) {...}
			// public Thread(ThreadGroup group, Runnable target) {...}
			// public Thread(ThreadGroup group, Runnable target, String name)
			// {...}
			// public Thread(ThreadGroup group, Runnable target, String name,
			// long stackSize) {...}
			// public Thread(ThreadGroup group, String name) {...}
			{
				System.out.println("new Thread(): " + new Thread());

				Runnable someRunnable = new Runnable() {

					@Override
					public void run() {
						// ...
					}

				};

				System.out.println("new Thread(someRunnable): " + new Thread(someRunnable));
				System.out.println(
						"new Thread(someRunnable, \"someThread1\"): " + new Thread(someRunnable, "someThread1"));
				System.out.println("new Thread(\"someThread2\"): " + new Thread("someThread2"));

				ThreadGroup someThreadGroup = new ThreadGroup("someThreadGroup");

				System.out.println(
						"new Thread(someThreadGroup, someRunnable): " + new Thread(someThreadGroup, someRunnable));
				System.out.println("new Thread(someThreadGroup, someRunnable, \"someThread3\"): "
						+ new Thread(someThreadGroup, someRunnable, "someThread3"));
				System.out.println("new Thread(someThreadGroup, someRunnable, \"someThread4\", 1024): "
						+ new Thread(someThreadGroup, someRunnable, "someThread4", 1024));
				System.out.println(
						"new Thread(someThreadGroup, \"someThread5\"): " + new Thread(someThreadGroup, "someThread5"));
			}

			Utils.printDelimiterLine2();

			// public long getId() {...}
			{
				System.out.println("new Thread().getId(): " + new Thread().getId());
			}

			Utils.printDelimiterLine2();

			// public final String getName() {...}
			// public final synchronized void setName(String name) {...}
			{
				Thread thread = new Thread();
				System.out.println("thread.getName(): " + thread.getName());
				thread.setName("someThread11");
				System.out.println("thread.getName(): " + thread.getName());
			}

			Utils.printDelimiterLine2();

			// public final int getPriority() {...}
			// public final void setPriority(int priority) {...}
			{
				Thread thread = new Thread();
				System.out.println("thread.getPriority(): " + thread.getPriority());
				thread.setPriority(Thread.MIN_PRIORITY);
				System.out.println("thread.getPriority(): " + thread.getPriority());
				thread.setPriority(Thread.NORM_PRIORITY);
				System.out.println("thread.getPriority(): " + thread.getPriority());
				thread.setPriority(Thread.MAX_PRIORITY);
				System.out.println("thread.getPriority(): " + thread.getPriority());
			}

			Utils.printDelimiterLine2();

			// public State getState() {...}
			{
				Thread thread = new Thread();
				System.out.println("thread.getState(): " + thread.getState());
				thread.start();
				System.out.println("thread.getState(): " + thread.getState());
				thread.interrupt();
				System.out.println("thread.getState(): " + thread.getState());
				System.out.println();

				System.out.println("Thread.currentThread().getState(): " + Thread.currentThread().getState());
			}

			Utils.printDelimiterLine2();

			// public final native boolean isAlive();
			{
				Thread thread = new Thread();
				System.out.println("thread.isAlive(): " + thread.isAlive());
				thread.start();
				System.out.println("thread.isAlive(): " + thread.isAlive());
			}

			Utils.printDelimiterLine2();

			// public final boolean isDaemon() {...}
			// public final void setDaemon(boolean on) {...}
			{
				Thread thread = new Thread();
				System.out.println("thread.isDaemon(): " + thread.isDaemon());
				thread.setDaemon(true);
				System.out.println("thread.isDaemon(): " + thread.isDaemon());
			}

			Utils.printDelimiterLine2();

			// public boolean isInterrupted() {...}
			{
				Thread thread = new Thread();
				System.out.println("thread.isInterrupted(): " + thread.isInterrupted());
				thread.start();
				thread.interrupt();
				System.out.println("thread.isInterrupted(): " + thread.isInterrupted());
			}

			Utils.printDelimiterLine2();

			// public final ThreadGroup getThreadGroup() {...}
			{
				Thread thread1 = new Thread();
				System.out.println("thread1.getThreadGroup(): " + thread1.getThreadGroup());

				Thread thread2 = new Thread(new ThreadGroup("someThreadGroup"), "someThread");
				System.out.println("thread2.getThreadGroup(): " + thread2.getThreadGroup());
			}

			Utils.printDelimiterLine2();

			// public ClassLoader getContextClassLoader() {...}
			// public void setContextClassLoader(ClassLoader classLoader) {...}
			{
				Thread thread = new Thread();
				System.out.println("thread.getContextClassLoader(): " + thread.getContextClassLoader());
				thread.setContextClassLoader(new ClassLoader() {
				});
				System.out.println("thread.getContextClassLoader(): " + thread.getContextClassLoader());
			}

			Utils.printDelimiterLine2();

			// public UncaughtExceptionHandler getUncaughtExceptionHandler()
			// {...}
			// public void setUncaughtExceptionHandler(UncaughtExceptionHandler
			// uncaughtExceptionHandler) {...}
			{
				Thread thread = new Thread();
				System.out.println("thread.getUncaughtExceptionHandler(): " + thread.getUncaughtExceptionHandler());
				thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

					@Override
					public void uncaughtException(Thread thread, Throwable throwable) {
						// ...
					}

				});
				System.out.println("thread.getUncaughtExceptionHandler(): " + thread.getUncaughtExceptionHandler());
			}

			Utils.printDelimiterLine2();

			// public StackTraceElement[] getStackTrace() {...}
			{
				Thread thread = new Thread();
				System.out
						.println("Arrays.toString(thread.getStackTrace()): " + Arrays.toString(thread.getStackTrace()));
				System.out.println("Arrays.toString(Thread.currentThread().getStackTrace()): "
						+ Arrays.toString(Thread.currentThread().getStackTrace()));
			}

			Utils.printDelimiterLine2();

			// public synchronized void start() {...}
			{
				Thread thread = new Thread();
				thread.start();
			}

			Utils.printDelimiterLine2();

			// public void interrupt() {...}
			{
				Thread thread = new Thread();
				thread.interrupt();
			}

			Utils.printDelimiterLine2();

			// public final void checkAccess() {...}
			{
				Thread thread = new Thread();
				thread.checkAccess();
			}

			Utils.printDelimiterLine2();

			// public final void join() throws InterruptedException {...}
			// public final synchronized void join(long milliseconds) throws
			// InterruptedException {...}
			// public final synchronized void join(long milliseconds, int
			// nanoseconds) throws InterruptedException {...}
			{
				Thread thread1 = new Thread();

				try {
					thread1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Thread thread2 = new Thread();

				try {
					thread2.join(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Thread thread3 = new Thread();

				try {
					thread3.join(500, 5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.concurrent.locks.Lock Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			// =============================================
			// void lock();
			// Condition newCondition();
			// void unlock();
			// =============================================
			{
				new Thread(new Runnable() {

					Lock lock = new ReentrantLock();
					Condition someCondition = lock.newCondition();

					@Override
					public void run() {
						lock.lock();
						try {
							int someValue = 1;
							while (someValue == 2) {
								someCondition.await();
							}

							// Do something...

							someCondition.signalAll();
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							lock.unlock();
						}
					}

				}).start();
			}

			// =============================================
			// void lockInterruptibly() throws InterruptedException;
			// =============================================
			{
				new Thread(new Runnable() {

					Lock lock = new ReentrantLock();

					@Override
					public void run() {
						try {
							lock.lockInterruptibly();
							// Do something...
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							lock.unlock();
						}
					}

				}).start();
			}

			// =============================================
			// boolean tryLock();
			// =============================================
			{
				new Thread(new Runnable() {

					Lock lock = new ReentrantLock();

					@Override
					public void run() {
						if (lock.tryLock()) {
							try {
								// Do something...
							} finally {
								lock.unlock();
							}
						} else {
							// Do something without locking...
						}
					}

				}).start();
			}

			// =============================================
			// boolean tryLock(long time, TimeUnit unit) throws
			// InterruptedException;
			// =============================================
			{
				new Thread(new Runnable() {

					Lock lock = new ReentrantLock();

					@Override
					public void run() {
						try {
							if (lock.tryLock(3, TimeUnit.MINUTES)) {
								try {
									// Do something...
								} finally {
									lock.unlock();
								}
							} else {
								// Do something without locking...
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}).start();
			}
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.concurrent.locks.ReentrantLock Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			// =============================================
			// public ReentrantLock() {...}
			// public ReentrantLock(boolean fair) {...}
			// public int getHoldCount() {...}
			// public final int getQueueLength() {...}
			// public final boolean hasQueuedThread(Thread thread) {...}
			// public final boolean hasQueuedThreads() {...}
			// public int getWaitQueueLength(Condition condition) {...}
			// public boolean hasWaiters(Condition condition) {...}
			// public final boolean isFair() {...}
			// public boolean isHeldByCurrentThread() {...}
			// public boolean isLocked() {...}
			// =============================================
			{
				List<Thread> existingThreads = Collections.synchronizedList(new ArrayList<>());
				SomeObject someObject = new SomeObject1(existingThreads);

				for (int i = 0; i < 5; i++) {
					Thread thread = new Thread(new SomeObjectProcess(someObject),
							"ReentrantLockTestAThread" + Utils.padNumberString(i + 1));
					existingThreads.add(thread);
					thread.start();
				}
			}

			{
				SomeObject someObject = new SomeObject2();
				for (int i = 0; i < 5; i++) {
					Thread thread = new Thread(new SomeObjectProcess(someObject),
							"ReentrantLockTestBThread" + Utils.padNumberString(i + 1));
					thread.start();
				}
			}
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.concurrent.locks.ReadWriteLock Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			// =============================================
			// Lock readLock();
			// Lock writeLock();
			// =============================================
			{
				new Thread(new Runnable() {

					ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
					Lock readLock = readWriteLock.readLock();
					Lock writeLock = readWriteLock.writeLock();

					@Override
					public void run() {
						doSomeReading();
						doSomeWriting();
					}

					private void doSomeReading() {
						readLock.lock();

						try {
							// Reading something...
						} finally {
							readLock.unlock();
						}
					}

					private void doSomeWriting() {
						writeLock.lock();

						try {
							// Writing something...
						} finally {
							writeLock.unlock();
						}
					}

				}).start();
			}

		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.concurrent.locks.ReentrantReadWriteLock Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			// =============================================
			// public ReentrantReadWriteLock() {...}
			// public ReentrantReadWriteLock(boolean fair) {...}
			// public final boolean isFair() {...}
			// public final boolean hasQueuedThreads() {...}
			// public final boolean hasQueuedThread(Thread thread) {...}
			// public final int getQueueLength() {...}
			// public boolean isWriteLocked() {...}
			// public boolean isWriteLockedByCurrentThread() {...}
			// public int getReadHoldCount() {...}
			// public int getWriteHoldCount() {...}
			// public int getReadLockCount() {...}
			// public boolean hasWaiters(Condition condition) {...}
			// public int getWaitQueueLength(Condition condition) {...}
			// =============================================
			{
				List<Thread> existingThreads = Collections.synchronizedList(new ArrayList<>());
				SomeCoolObject someCoolObject = new SomeCoolObject1(existingThreads);

				for (int i = 0; i < 5; i++) {
					Thread thread = new Thread(new SomeCoolObjectProcess(someCoolObject),
							"ReentrantReadWriteLockTestAThread" + Utils.padNumberString(i + 1));
					existingThreads.add(thread);
					thread.start();
				}
			}

			{
				SomeCoolObject someCoolObject = new SomeCoolObject2();
				for (int i = 0; i < 5; i++) {
					Thread thread = new Thread(new SomeCoolObjectProcess(someCoolObject),
							"ReentrantReadWriteLockTestBThread" + Utils.padNumberString(i + 1));
					thread.start();
				}
			}
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.concurrent.locks.Condition Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			// =============================================
			// void await() throws InterruptedException
			// boolean await(long time, TimeUnit unit) throws
			// InterruptedException;
			// long awaitNanos(long nanosTimeout) throws InterruptedException;
			// void awaitUninterruptibly();
			// boolean awaitUntil(Date deadline) throws InterruptedException;
			// void signalAll();
			// void signal();
			// =============================================
			{
				new Thread(new Runnable() {

					Lock lock = new ReentrantLock();
					Condition condition1 = lock.newCondition();
					Condition condition2 = lock.newCondition();
					Condition condition3 = lock.newCondition();
					Condition condition4 = lock.newCondition();
					Condition condition5 = lock.newCondition();

					@Override
					public void run() {
						lock.lock();
						try {
							int someValue = 1;
							while (someValue == 2) {
								condition1.await();
								System.out.println("condition2.await(3, TimeUnit.SECONDS): "
										+ condition2.await(3, TimeUnit.SECONDS));
								System.out.println("condition3.awaitNanos(3000000): " + condition3.awaitNanos(3000000));
								condition4.awaitUninterruptibly();
								Calendar calendar = Calendar.getInstance();
								calendar.add(Calendar.SECOND, 3);
								condition5.awaitUntil(calendar.getTime());
							}

							// Do something...

							condition1.signalAll();
							condition2.signal();
							condition3.signalAll();
							condition4.signalAll();
							condition5.signalAll();
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							lock.unlock();
						}
					}

				}).start();
			}
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.lang.Object Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			// =============================================
			// public final void wait() throws InterruptedException {...}
			// public final native void wait(long timeout) throws
			// InterruptedException;
			// public final void wait(long timeout, int nanos) throws
			// InterruptedException {...}
			// public final native void notify();
			// public final native void notifyAll();
			// =============================================
			new Thread(new SomeGoodObjectProcess1(new SomeGoodObject())).start();
			new Thread(new SomeGoodObjectProcess2(new SomeGoodObject())).start();
			new Thread(new SomeGoodObjectProcess3(new SomeGoodObject())).start();
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.lang.ThreadLocal<T> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			// =============================================
			// public T get() {...}
			// public void remove() {...}
			// public void set(T value) {...}
			// =============================================
			// Some threads are created and started here to get their own copies
			// of a thread local variable (name: threadLocalVariable).
			// Those copies may have different values, and the count of the
			// threads to create is bigger, the chance appearing different
			// values is bigger.
			for (int i = 0; i < 20; i++) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						System.out.println("threadLocalVariable.get(): " + threadLocalVariable.get());
					}

				}).start();
			}

			System.out.println();

			Thread.sleep(100);
			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("(1) threadLocalVariable.get(): " + threadLocalVariable.get());
					threadLocalVariable.remove();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("(2) threadLocalVariable.get(): " + threadLocalVariable.get());
					threadLocalVariable.set(123);
					System.out.println("(3) threadLocalVariable.get(): " + threadLocalVariable.get());
				}

			}).start();

			System.out.println();
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the Thread States
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println();
					long timeCounter = 0;
					while (!Thread.currentThread().isInterrupted()) {
						if (++timeCounter == 2000000000L) {
							System.out.println(new Date() + ": The thread is doing something...");
							timeCounter = 0;
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
								Thread.currentThread().interrupt();
							}
						}
					}
					System.out.println("The thread is about to terminating...");
				}

			});

			System.out.println("thread.getState(): " + thread.getState());

			thread.start();

			System.out.println("thread.getState(): " + thread.getState());

			Thread.sleep(3000);

			System.out.println("thread.getState(): " + thread.getState());

			thread.interrupt();

			Thread.sleep(100);

			System.out.println("thread.getState(): " + thread.getState());
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the Thread Synchronization
		// +++++++++++++++++++++++++++++++++++++++++++++++++

		{
			// The thread #1 adds the shared counter by 1 every some period.
			Thread thread1 = new Thread(new Runnable() {

				@Override
				public void run() {
					long timeCounter = 0;
					while (!Thread.currentThread().isInterrupted()) {
						if (++timeCounter == 2000000000L) {
							System.out.println("Thread 1 - Counter: " + (++someCounter));
							timeCounter = 0;
						}
					}
				}

			});

			thread1.start();

			// The thread #2 subtracts the shared counter by 1 every some
			// period.
			Thread thread2 = new Thread(new Runnable() {

				@Override
				public void run() {
					long timeCounter = 0;
					while (!Thread.currentThread().isInterrupted()) {
						if (++timeCounter == 2000000000L) {
							System.out.println("Thread 2 - Counter: " + (--someCounter));
							timeCounter = 0;
						}
					}
				}

			});

			thread2.start();

		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the Ways to Create a Thread
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// =====================================================================
		// Declaring a Class Extending the java.lang.Thread Class
		// =====================================================================
		{
			new SomeThread().start();
		}

		// =====================================================================
		// Declaring a Class Implementing the java.lang.Runnable Interface
		// =====================================================================
		{
			new Thread(new SomeRunnable()).start();
		}
	}

}
