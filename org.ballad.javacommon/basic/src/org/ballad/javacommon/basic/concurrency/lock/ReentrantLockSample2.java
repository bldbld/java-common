/**
 * 
 */
package org.ballad.javacommon.basic.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockSample2.java
 * 
 * @author ballad
 * @version 2018
 * 
 */
public class ReentrantLockSample2 {

	private Lock lock = new ReentrantLock();

	private int count = 0;

	public void countplus(String threadName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.lock();
		count++;
		System.out.println(threadName + count);
		lock.unlock();
	}

	public static void main(String[] args) {
		ReentrantLockSample2 sample = new ReentrantLockSample2();
		Thread thread1 = new Thread() {
			public void run() {
				sample.countplus("Thread 1 ");
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				sample.countplus("Thread 2 ");
			}
		};
		thread1.start();
		thread2.start();
	}
}
