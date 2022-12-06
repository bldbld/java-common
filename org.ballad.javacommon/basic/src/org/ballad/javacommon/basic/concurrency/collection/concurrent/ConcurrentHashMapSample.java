package org.ballad.javacommon.basic.concurrency.collection.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap���̰߳�ȫ��HashMap��ʵ��
 * 
 * <p>
 * ConcurrentHashMap����concurrencyLevel���ֳ��˶��Segment����key-value���д洢���Ӷ�����ÿ��put����������ס�������顣<br>
 * ��Ĭ�ϵ�����£��������¿�����16���̲߳����������Ĳ������϶��󣬾����ܵؼ��ٲ���ʱ����������
 * </p>
 * 
 * @author ballad
 * @version 2018-05-16
 */
public class ConcurrentHashMapSample {

	public static void main(String[] args) {
		
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();

		// ��ʾ�����Զ��̰߳�ȫ�Ĳ���ConcurrentHashMap��δģ�⾺�����
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
