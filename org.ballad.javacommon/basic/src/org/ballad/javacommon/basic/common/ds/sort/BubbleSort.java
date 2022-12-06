package org.ballad.javacommon.basic.common.ds.sort;

/**
 * 冒泡排序（BubbleSort）
 * <p>
 * 冒泡排序时间复杂度为O（n^2），虽然不及堆排序、快速排序的O（nlogn，底数为2），但是有两个优点：<br>
 * 1.“编程复杂度” 很低，很容易写出代码；<br>
 * 2.具有稳定性，这里的稳定性是指原序列中相同元素的相对顺序仍然保持到排序后的序列，而堆排序、快速排序均不具有稳定性。<br>
 * 不过，一路、 二路归并排序 、不平衡二叉树排序的速度均比冒泡排序快，且具有稳定性，但速度不及堆排序、快速排序。<br>
 * </p>
 * <p>
 * 冒泡排序是经过n-1趟子排序完成的，第i趟子排序从第1个数至第n -i个数，若第i个数比后一个数大（则升序，小则降序）则交换两数<br>
 * 排序方法：<br>
 * 依次比较相邻的两个数，将小数放在前面，大数放在后面。<br>
 * 即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。<br>
 * 然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前， 大数放后 。<br>
 * 至此第一趟结束，将最大的数放到了最后。<br>
 * 在第二趟：仍从第一对数开始比较（因为可能由于第2个数和第3个数的交换，使得第1个数不再小于第2个数），将小数放前 ，大数放后
 * ，一直比较到倒数第二个数（倒数第一的位置上已经是最大的），第二趟结束，在倒数第二的位置上得到一个新的最大数（其实在整个数列中是第二大的数）。<br>
 * 如此下去 ，重复以上过程，直至最终完成排序。<br>
 * 由于在排序过程中总是小数往前放，大数往后放，相当于气泡往上升，所以称作冒泡排序。
 * </p>
 * 
 * @author ballad
 * @version 2010/04/27 initial
 * @version 2012/04/29 code format
 */
public class BubbleSort {
	/**
	 * Static Bubble Sort.
	 * 
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		int tmp;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					tmp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = tmp;
				}
			}
		}
		SortPrint.print("BubbleSort Result:", a);
	}

	/**
	 * Testing function.
	 */
	public static void main(String[] args) {
		int[] a = { 11, 4, 5, 74, 8, 9, 34, 24, 89, 67, 9, 21 };
		BubbleSort.bubbleSort(a);
	}
}
