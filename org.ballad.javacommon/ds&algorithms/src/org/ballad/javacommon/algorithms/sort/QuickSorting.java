package org.ballad.javacommon.algorithms.sort;

/**
 * QuickSort ��������<br>
 * ���ڷ����㷨<br>
 * 
 * ������ O(N Log N)<br>
 * ���� O(N��)<br>
 * ƽ����� O(N Log N)<br>
 * C++�ж�����������������㷨<br>
 * 
 * ԭ��<br>
 * �㷨��Ĭ�����ĵ�pivotȡa[begin]��<br>
 * Ȼ��Ӷ�β��ʼ�ж� �Ƿ����С��pivot�� �����򸳸�a[begin]��<br>
 * Ȼ��Ӷ��׿�ʼ�ж� �Ƿ���ڴ���pivot�� �����򸳸�a[right]����Ȼleft!=right<br>
 * Ȼ����ִ�����϶��� ֱ��left == right ʹ�� left�����涼С��pivot ���涼����pivot<br>
 * 
 * Ȼ��ֱ�������Ӷ��еݹ�������Ϸ���<br>
 * 
 * @author ballad
 * @version 2010/04/27 initial
 * @version 2012/04/29 code format
 */
public class QuickSorting {

	public static void quickSorting(int[] a) {
		int n = 6;// ����Pivot��
		quickSort(a, 0, a.length - 1, n);
	}

	public static void quickSort(int[] a, int begin, int end, int n) {
		int pivot = a[begin];// ����pivot
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