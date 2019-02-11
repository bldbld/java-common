/**
 * 
 */
package ballad.learn.concurrency.collection.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ConditionSample2.java
 * 
 * @author ballad
 * @version 2018
 * 
 */
public class ConditionSample2 {
	private Lock lock = new ReentrantLock();
	private Condition condtion = lock.newCondition();

	public void get(String threadName) {
		lock.lock();
		try {
			System.out.println(threadName + "等待 BALABALA 中");
			condtion.await();
			System.out.println(threadName + "得到 BALABALA");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void put(String threadName) {
		lock.lock();
		try {
			System.out.println(threadName + "提供 BALABALA");
			condtion.signal();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ConditionSample2 sample = new ConditionSample2();
		Thread thread1 = new Thread() {
			public void run() {
				sample.get("Thread 1 ");
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				sample.put("Thread 2 ");
			}
		};
		thread1.start();
		thread2.start();
	}

}
