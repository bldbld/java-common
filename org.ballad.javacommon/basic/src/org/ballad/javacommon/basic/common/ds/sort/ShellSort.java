package org.ballad.javacommon.basic.common.ds.sort;

/**
 * ShellSort谢尔排序or希尔排序<br>
 * ShellSort时Donald Shell在1959年对InsertionSort改进而来<br>
 * 不是最快的，但是是较快算法里最简单的，是亚平方时间算法<br>
 * 是合理的大量输入的良好选择<br>
 * 
 * Shell排序使用Increamment Squence 即增量序列<br>
 * 先将待排序记录序列分割成为若干子序列分别进行直接插入排序，<br>
 * 待整个序列中的记录基本有序后，再全体进行一次直接插入排序。<br>
 * 
 * @author ballad
 * @version 2010/04/26 initial
 * @version 2012/04/29 code format
 */
public class ShellSort {
	/*
	 * 
	 */
	public static void shellSort(int[] a) {
		// i就是gap
		// 这个版本还没看懂~!!!!!!!!!!!!!!!!!!!!
		for (int i = a.length / 2; i > 0; i = (i == 2 ? 1 : (int) (i / 2.2))) {
			for (int j = i; j < a.length; j++) {
				int tmp = a[j];
				int k = j;
				for (; k >= i && tmp < a[k - i]; k -= i) {
					a[k] = a[k - i];
				}
				a[k] = tmp;
			}

		}
		SortPrint.print("ShellSort", a);
	}

	public static void shellSortEasy(int[] a) {
		/*
		 * 这个版本是老师课件的，比较易懂
		 */
		int tmp;
		int gap = a.length / 2;// gap是子序列间隔
		while (gap != 0) { // 循环,直到gap为零
			for (int i = gap; i < a.length; i++) {
				tmp = a[i]; // 直接插入排序
				for (int j = i; j >= gap; j -= gap) {
					if (tmp < a[j - gap])
						a[j] = a[j - gap];
					else
						break;
					a[j - gap] = tmp;
				}
			}
			gap = gap / 2;
		}
		SortPrint.print("ShellSort", a);
	}

	public static void main(String[] args) {
		int[] a = { 11, 4, 5, 74, 8, 9, 34, 24, 89, 67, 9, 21 };
		ShellSort.shellSortEasy(a);
	}
}
