package org.ballad.javacommon.basic.common.ds.sort;

/**
 * InsertionSort插入排序<br>
 * 最坏和平均的运行时间是开平方的，最好情况则很快 适合少量数据<br>
 * 对于a[i]=tmp来说，前面都是已经排好的，依次和前面的比较，<br>
 * 如果比前面的小，则前面的元素向后移，直到它不比前面的元素小<br>
 * 
 * @author ballad
 * @version 2010/04/26 initial
 * @version 2012/04/29 code format
 */
public class InsertionSort {

	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			int j = i;
			for (; j > 0 && tmp < a[j - 1]; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
		SortPrint.print("InsertionSort", a);
	}

	/**
	 * Testing function.
	 */
	public static void main(String[] args) {
		int[] a = { 11, 4, 5, 74, 8, 9, 34, 24, 89, 67, 9, 21 };
		InsertionSort.insertionSort(a);
	}
}
