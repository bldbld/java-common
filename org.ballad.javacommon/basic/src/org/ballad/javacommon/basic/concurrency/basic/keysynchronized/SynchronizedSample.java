package org.ballad.javacommon.basic.concurrency.basic.keysynchronized;

public class SynchronizedSample {

	private int count = 0;

	public void countplus(String threadName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (this) {
			count++;
			System.out.println(threadName + count);
		}
	}

	public static void main(String[] args) {
		SynchronizedSample sample = new SynchronizedSample();
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
