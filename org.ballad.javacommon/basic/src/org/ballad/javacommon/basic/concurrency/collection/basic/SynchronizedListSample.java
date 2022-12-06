package org.ballad.javacommon.basic.concurrency.collection.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListSample {
	public static void main(String[] args) {

		List<String> list = Collections.synchronizedList(new ArrayList<String>());

		// ��ʾ�����Զ��̰߳�ȫ�Ĳ�����δģ�⾺�����
		Runnable threadA = new Runnable() {
			@Override
			public void run() {
				list.add("A");
			}
		};
		threadA.run();

		Runnable threadB = new Runnable() {
			@Override
			public void run() {
				list.add("A");
			}
		};
		threadB.run();

		System.out.println(list.size());
	}
}
