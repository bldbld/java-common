package org.ballad.javacommon.basic.concurrency.collection.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSample {

	final Lock lock = new ReentrantLock();

	final Condition condition = lock.newCondition();

	public static void main(String[] args) {

		/**
		 * ���н�� <br>
		 * ���ڵ�һ�����ź�Thread-1 <br>
		 * ���õ���Thread-0 <br>
		 * �ҷ�����һ���źţ�Thread-0 <br>
		 * �õ�һ���ź�Thread-1
		 */
		ConditionSample test = new ConditionSample();
		Producer producer = test.new Producer();
		Consumer consumer = test.new Consumer();

		consumer.start();
		producer.start();
	}

	class Consumer extends Thread {

		@Override
		public void run() {
			consume();
		}

		private void consume() {

			try {
				lock.lock();
				System.out.println("���ڵ�һ�����ź�" + Thread.currentThread().getName());
				condition.await();

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("�õ�һ���ź�" + Thread.currentThread().getName());
				// ��ʼ����
				lock.unlock();
			}

		}
	}

	class Producer extends Thread {

		@Override
		public void run() {
			produce();
		}

		private void produce() {
			try {
				lock.lock();
				System.out.println("���õ���" + Thread.currentThread().getName());
				// ��ʼ����
				// condition.signalAll();
				condition.signal();
				System.out.println("�ҷ�����һ���źţ�" + Thread.currentThread().getName());
			} finally {
				lock.unlock();
			}
		}
	}

}
