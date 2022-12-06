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
		
		// Executors.newCachedThreadPool(); //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
		// Executors.newSingleThreadExecutor(); //创建容量为1的缓冲池
		// Executors.newFixedThreadPool(int); //创建固定容量大小的缓冲池
		
		
		// (1)corePoolSize： 线程池维护线程的最少数量
		// (2)maximumPoolSize： 线程池维护线程的最大数量
		// (3)keepAliveTime： 线程池维护线程所允许的空闲时间
		// (4)unit： 线程池维护线程所允许的空闲时间的单位
		// (5)workQueue： 线程池所使用的缓冲队列
		// (6)handler： 线程池对拒绝任务的处理策略
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
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
		System.out.println("正在执行task " + taskNum);
		try {
			//Thread.currentThread();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "执行完毕");
	}
}