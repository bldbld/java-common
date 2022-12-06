package org.ballad.javacommon.basic.concurrency.collection.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap是线程安全的HashMap的实现
 * 
 * <p>
 * ConcurrentHashMap基于concurrencyLevel划分出了多个Segment来对key-value进行存储，从而避免每次put操作都得锁住整个数组。<br>
 * 在默认的情况下，最佳情况下可允许16个线程并发无阻塞的操作集合对象，尽可能地减少并发时的阻塞现象。
 * </p>
 * 
 * @author ballad
 * @version 2018-05-16
 */
public class ConcurrentHashMapSample {

	public static void main(String[] args) {
		
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();

		// 仅示例可以多线程安全的操作ConcurrentHashMap，未模拟竞争情况
		Runnable threadA = new Runnable() {
			@Override
			public void run() {
				map.put("A", "A");
			}
		};
		threadA.run();

		Runnable threadB = new Runnable() {
			@Override
			public void run() {
				map.put("A", "B");
			}
		};
		threadB.run();

		System.out.println(map.get("A"));
	}
}
