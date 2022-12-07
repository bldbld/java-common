package org.ballad.javacommon.basic.concurrency.executor;

import java.util.concurrent.*;

/**
 * CallableAndFutureSample.java
 * 
 * @author ballad
 * @version 2018
 * 
 */
public class CallableAndFutureSample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		SampleThread thread = new SampleThread();
		Future<Integer> result = executor.submit(thread);
		// shutdown()     ��ֹǰ������ִ����ǰ�ύ������
		// shutdownNow()  ������ֹ�ȴ�������������ͼֹͣ��ǰ����ִ�е�����
		executor.shutdown();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("���߳���ִ������");

		try {
			System.out.println("task���н��" + result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("��������ִ�����");
	}
}

class SampleThread implements Callable<Integer> {

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
