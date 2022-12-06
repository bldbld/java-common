package org.ballad.javacommon.basic.common.ds.sort;

import ballad.coding.ds.heap.MinHeap;

/**
 * 内排序:堆排序<br>
 * 
 * @author ballad
 * @see MinHeap
 * @version 2010/06/04 initial
 * @version 2012/04/29 code format
 */
public class HeapSort {
	/**
	 * 注:MinHeap对于字符串比较采用了ASIC码比较 所以11要比2小
	 */
	public static void heapSort() {

		int[] a = { 11, 4, 5, 74, 8, 9, 34, 24, 89, 67, 9, 21 };
		String[] s = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			s[i] = new Integer(a[i]).toString();
		}
		MinHeap mh = new MinHeap(s);
		mh.buildHeap();
		for (int i = 0; i < s.length; i++) {
			System.out.print(mh.remove() + " ");
		}
	}

	public static void main(String[] args) {
		HeapSort.heapSort();
	}
}
