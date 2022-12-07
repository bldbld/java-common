package org.ballad.javacommon.algorithms.sort;

/**
 * MergeSort �鲢����<br>
 * Recursive �ݹ�ķ���ʵ�� ���ڷ����㷨 ��������Ϊ2�����⣨�Ժ�ݹ�Ĳ�֣�ֱ��left>=right�� ÿ�������⿪��ΪO(N)
 * �����㷨ΪO(N Log N)<br>
 * 
 * ���裺 <br>
 * 1.��������������Ϊ0||1 ����<br>
 * 2.�Եȷֵ������ֱַ�ݹ����� 3.���źõ������ֹ鲢��һ��������<br>
 * 
 * ������Ĺ鲢��������ʱ�������<br>
 * 
 * �鲢������Ҫ����Ŀ��� �鲢�����������㷨��ʹ�õıȽϴ������� ����ʱ������������Ԫ�صıȽϺ��ƶ�<br>
 * Java���ԵıȽϵĴ��۸ߣ�������ʵ���Ǹı������ö��ѣ����۵� <br>
 * ��Java.util.Arrays.sort���ڶ�������������㷨<br>
 * 
 * @author ballad
 * @version 2010/04/26 initial
 * @version 2012/04/29 code format
 */
public class MergeSort {
	
	// ��ʼ�� һ����ʱ����
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

		// Main Loop ������źõ��������ұ����Ƚ� ���뵽�������� ֱ����һ�߽�ֹ
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (a[leftPos] < a[rightPos]) {
				tmpa[tmpPos++] = a[leftPos++];
			} else {
				tmpa[tmpPos++] = a[rightPos++];
			}
		}
		// ����ʣ���Ԫ�ص�������
		while (leftPos <= leftEnd) {
			tmpa[tmpPos++] = a[leftPos++];
		}
		while (rightPos < rightEnd) {
			tmpa[tmpPos++] = a[rightPos++];
		}
		// �������и��ƻ�ԭ����
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
