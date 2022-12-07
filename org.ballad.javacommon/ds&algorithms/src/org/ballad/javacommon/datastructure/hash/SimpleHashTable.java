package org.ballad.javacommon.datastructure.hash;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 一个简单的数字存储散列表
 * 
 * @author ballad
 * @version 2010/06/01 initial
 * @version 2012/04/30 code format
 */
public class SimpleHashTable {

	public SimpleHashTable() {

	}

	public boolean find(int num) {
		int tmp = num % length;
		if (a[tmp] == 0) {
			return false;
		} else {
			LinkedList<Integer> list = m.get(new Integer(tmp));
			if (list.contains(new Integer(num))) {
				return true;
			} else {
				return false;
			}
		}
	}

	public void add(int num) {
		int tmp = num % length;
		if (a[tmp] == 0) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(new Integer(num));
			m.put(tmp, list);
		} else {
			LinkedList<Integer> list = m.get(new Integer(tmp));
			list.add(new Integer(num));
		}
		a[tmp]++;
	}

	public HashMap<Integer, LinkedList<Integer>> m = new HashMap<Integer, LinkedList<Integer>>();
	public int[] a = new int[length];

	public static final int maxLength = Integer.MAX_VALUE;
	public static final int length = 1280;

	public static void main(String[] args) {

		SimpleHashTable sh = new SimpleHashTable();
		sh.add(7803);
		sh.add(123);

		System.out.println(sh.a[123]);
		System.out.println(sh.find(7803));
		System.out.println(sh.find(1231321));

	}
}
