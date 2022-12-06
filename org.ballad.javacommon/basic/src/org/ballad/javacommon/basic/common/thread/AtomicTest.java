package org.ballad.javacommon.basic.common.thread;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest extends Thread {
	/*
	 * ��Servlet�п���ʹ��AtomicLongͳ����������
	 * private final AtomicLong count = new AtomicLong (0) //java.util.concurrent.atomic
	 * 
	 * ���������ɲ���
	 * ������Servlet�в���  ��Ϊÿ�ζ�Ҫ�����µĶ��� AtomicLong ���û���κ����� ����ֻ�Ǳ���һ���������
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
