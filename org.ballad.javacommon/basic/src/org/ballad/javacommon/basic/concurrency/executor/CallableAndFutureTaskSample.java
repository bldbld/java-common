/**
 * 
 */
package org.ballad.javacommon.basic.concurrency.executor;

import java.util.concurrent.*;

/**
 * CallableAndFutureTaskSample.java
 * 
 * @author ballad
 * @version 2018
 * 
 */
public class CallableAndFutureTaskSample {

	public static void main(String[] args) {

		// ��һ�ַ�ʽ
		ExecutorService executor = Executors.newCachedThreadPool();
		CallableAndFutureSampleThread threadImpl = new CallableAndFutureSampleThread();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(threadImpl);
		executor.submit(futureTask);
		executor.shutdown();

		// �ڶ��ַ�ʽ��ע�����ַ�ʽ�͵�һ�ַ�ʽЧ�������Ƶģ�ֻ����һ��ʹ�õ���ExecutorService��һ��ʹ�õ���Thread
		// Task task = new Task();
		// FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
		// Thread thread = new Thread(futureTask);
		// thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("���߳���ִ������");

		try {
			System.out.println("task���н��" + futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("��������ִ�����");
	}
}

class CallableAndFutureSampleThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("���߳��ڽ��м���");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}
}
