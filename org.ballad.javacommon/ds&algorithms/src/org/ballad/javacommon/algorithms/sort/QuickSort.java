package org.ballad.javacommon.algorithms.sort;

/**
 * QuickSort 快速排序<br>
 * 
 * 最好情况 O(N Log N)<br>
 * 最坏情况 O(N方)<br>
 * 平均情况 O(N Log N)<br>
 * C++中对于所有类型排序的算法<br>
 * 
 * @author ballad
 * @version 2010/04/26 initial
 * @version 2012/04/29 code format
 * 
 */
public class QuickSort {
	// 这个版本目前问题多多

	// 如果小于某个值 执行插入排序
	public static int CUTOFF = 10;

	public static void quickSort(int[] a) {
		quickSortCore(a, 0, a.length - 1);
	}

	private static void quickSortCore(int[] a, int low, int high) {
		// CUTOFF
		if (low + CUTOFF > high) {
			InsertionSort.insertionSort(a);
		} else {
			// sort low,middle,high
			int middle = (low + high) / 2;

			if (a[middle] < a[low]) {
				swapReferences(a, low, middle);
			}
			if (a[high] < a[low]) {
				swapReferences(a, low, high);
			}
			if (a[high] < a[middle]) {
				swapReferences(a, middle, high);
			}
			swapReferences(a, middle, high - 1);

			int pivot = a[high - 1];
			// begin parittioning
			int i, j;
			for (i = low, j = high - 1;;) {
				while (a[++i] < pivot) {
					;
				}
				while (pivot < a[--j]) {
					;
				}
				if (i >= j) {
					break;
				}
				swapReferences(a, i, j);
				quickSortCore(a, low, i - 1);
				quickSortCore(a, i + 1, high);
			}
		}
	}

	public static void swapReferences(int[] a, int i, int j) {

	}

}
