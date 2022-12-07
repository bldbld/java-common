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
		// shutdown()     终止前，允许执行以前提交的任务
		// shutdownNow()  方法阻止等待任务启动并试图停止当前正在执行的任务
		executor.shutdown();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("主线程在执行任务");

		try {
			System.out.println("task运行结果" + result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("所有任务执行完毕");
	}
}

class SampleThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("子线程在进行计算");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}
}
