package org.ballad.javacommon.basic.concurrency.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutorSample.java
 * 
 * @author ballad
 * @version 2018
 * 
 */
public class ThreadPoolExecutorSample {

	public static void main(String[] args) {
		
		// Executors.newCachedThreadPool(); //����һ������أ������������СΪInteger.MAX_VALUE
		// Executors.newSingleThreadExecutor(); //��������Ϊ1�Ļ����
		// Executors.newFixedThreadPool(int); //�����̶�������С�Ļ����
		
		
		// (1)corePoolSize�� �̳߳�ά���̵߳���������
		// (2)maximumPoolSize�� �̳߳�ά���̵߳��������
		// (3)keepAliveTime�� �̳߳�ά���߳�������Ŀ���ʱ��
		// (4)unit�� �̳߳�ά���߳�������Ŀ���ʱ��ĵ�λ
		// (5)workQueue�� �̳߳���ʹ�õĻ������
		// (6)handler�� �̳߳ضԾܾ�����Ĵ������
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("�̳߳����߳���Ŀ��" + executor.getPoolSize() + "�������еȴ�ִ�е�������Ŀ��" + executor.getQueue().size()
					+ "����ִ������������Ŀ��" + executor.getCompletedTaskCount());
		}
		executor.shutdown();

	}

}

class MyTask implements Runnable {
	private int taskNum;

	public MyTask(int num) {
		this.taskNum = num;
	}

	@Override
	public void run() {
		System.out.println("����ִ��task " + taskNum);
		try {
			//Thread.currentThread();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "ִ�����");
	}
}