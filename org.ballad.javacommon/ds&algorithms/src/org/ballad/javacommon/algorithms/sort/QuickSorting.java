package org.ballad.javacommon.algorithms.sort;

/**
 * QuickSort 快速排序<br>
 * 基于分治算法<br>
 * 
 * 最好情况 O(N Log N)<br>
 * 最坏情况 O(N方)<br>
 * 平均情况 O(N Log N)<br>
 * C++中对于所有类型排序的算法<br>
 * 
 * 原理：<br>
 * 算法中默认中心点pivot取a[begin]，<br>
 * 然后从队尾开始判断 是否存在小于pivot的 存在则赋给a[begin]，<br>
 * 然后从队首开始判断 是否存在大于pivot的 存在则赋给a[right]，当然left!=right<br>
 * 然后再执行以上动作 直至left == right 使得 left的左面都小于pivot 右面都大于pivot<br>
 * 
 * 然后分别对两边子队列递归调用以上方法<br>
 * 
 * @author ballad
 * @version 2010/04/27 initial
 * @version 2012/04/29 code format
 */
public class QuickSorting {

	public static void quickSorting(int[] a) {
		int n = 6;// 设置Pivot？
		quickSort(a, 0, a.length - 1, n);
	}

	public static void quickSort(int[] a, int begin, int end, int n) {
		int pivot = a[begin];// 设置pivot
		int left = begin;
		int right = end;
		while (left != right) {
			while (a[right] >= pivot && left != right) {
				right--;
			}
			if (left == right)
				break;
			a[left] = a[right];
			while (a[left] <= pivot && left != right) {
				left++;
			}
			if (left == right)
				break;
			a[right] = a[left];
		}
		a[left] = pivot;
		if (left > begin + 1)
			quickSort(a, begin, left - 1, n);
		if (left < end - 1)
			quickSort(a, left + 1, end, n);
		SortPrint.print("QuickSort", a);
	}

	public static void main(String[] args) {
		int[] a = { 11, 4, 5, 74, 8, 9, 34, 24, 89, 67, 9, 21 };
		QuickSorting.quickSorting(a);
	}

}