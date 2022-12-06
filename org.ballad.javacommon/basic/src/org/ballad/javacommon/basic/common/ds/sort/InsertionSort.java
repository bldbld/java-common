package org.ballad.javacommon.basic.common.ds.sort;

/**
 * InsertionSort��������<br>
 * ���ƽ��������ʱ���ǿ�ƽ���ģ���������ܿ� �ʺ���������<br>
 * ����a[i]=tmp��˵��ǰ�涼���Ѿ��źõģ����κ�ǰ��ıȽϣ�<br>
 * �����ǰ���С����ǰ���Ԫ������ƣ�ֱ��������ǰ���Ԫ��С<br>
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
