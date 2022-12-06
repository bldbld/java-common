package org.ballad.javacommon.basic.common.thread;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest extends Thread {
	/*
	 * 在Servlet中可以使用AtomicLong统计请求数：
	 * private final AtomicLong count = new AtomicLong (0) //java.util.concurrent.atomic
	 * 
	 * ！！！不可测试
	 * 必须在Servlet中测试  因为每次都要建立新的对象 AtomicLong 变得没有任何意义 这里只是表现一下如何运用
	 */
	private final AtomicLong count = new AtomicLong (0);

	public void increment (){
		count.incrementAndGet();
		System.out.print(count.get());
	}
	
	public void run (){
		
	}
	public static void main (String [] args){

		AtomicTest[] at = new AtomicTest[5];
		for (int i = 0 ;i<5;i++){
			at[i] = new AtomicTest();
			at[i].start();

		}
		
	}

}
