package org.ballad.javacommon.algorithms.sort;

/**
 * MergeSort 归并排序<br>
 * Recursive 递归的方法实现 基于分治算法 把问题拆分为2个问题（以后递归的拆分，直至left>=right） 每个子问题开销为O(N)
 * 整个算法为O(N Log N)<br>
 * 
 * 步骤： <br>
 * 1.如果待排序的项数为0||1 返回<br>
 * 2.对等分的两部分分别递归排序 3.将排好的两部分归并成一个有序组<br>
 * 
 * 有序组的归并能在线性时间内完成<br>
 * 
 * 归并排序需要过多的拷贝 归并在所有排序算法里使用的比较次数最少 运行时间依赖于数组元素的比较和移动<br>
 * Java语言的比较的代价高，拷贝（实际是改变了引用而已）代价低 <br>
 * 是Java.util.Arrays.sort对于对象数组排序的算法<br>
 * 
 * @author ballad
 * @version 2010/04/26 initial
 * @version 2012/04/29 code format
 */
public class MergeSort {
	
	// 初始化 一个临时数列
	public static void mergeSort(int[] a) {
		int[] tmpa = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			tmpa[i] = a[i];
		}
		mergeRun(a, tmpa, 0, a.length - 1);
	}

	private static void mergeRun(int[] a, int[] tmpa, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeRun(a, tmpa, left, center);
			mergeRun(a, tmpa, center + 1, right);
			merge(a, tmpa, left, center + 1, right);
		}
	}

	private static void merge(int[] a, int[] tmpa, int leftPos, int rightPos,
			int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main Loop 左边已排好的数列与右边作比较 插入到新数列中 直到有一边截止
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (a[leftPos] < a[rightPos]) {
				tmpa[tmpPos++] = a[leftPos++];
			} else {
				tmpa[tmpPos++] = a[rightPos++];
			}
		}
		// 复制剩余的元素到新数列
		while (leftPos <= leftEnd) {
			tmpa[tmpPos++] = a[leftPos++];
		}
		while (rightPos < rightEnd) {
			tmpa[tmpPos++] = a[rightPos++];
		}
		// 将新数列复制回原数列
		for (int i = 0; i < numElements; i++, rightEnd--) {
			a[rightEnd] = tmpa[rightEnd];
		}
		SortPrint.print("MergeSort", a);
	}
	
	public static void main(String[] args) {
		int[] a = { 11, 4, 5, 74, 8, 9, 34, 24, 89, 67, 9, 21 };
		MergeSort.mergeSort(a);
	}
}
