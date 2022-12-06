package org.ballad.javacommon.basic.concurrency.collection.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListSample {
	public static void main(String[] args) {

		List<String> list = Collections.synchronizedList(new ArrayList<String>());

		// 仅示例可以多线程安全的操作，未模拟竞争情况
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
