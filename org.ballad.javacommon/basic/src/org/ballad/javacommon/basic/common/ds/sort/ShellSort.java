package org.ballad.javacommon.basic.common.ds.sort;

/**
 * ShellSortл������orϣ������<br>
 * ShellSortʱDonald Shell��1959���InsertionSort�Ľ�����<br>
 * �������ģ������ǽϿ��㷨����򵥵ģ�����ƽ��ʱ���㷨<br>
 * �Ǻ���Ĵ������������ѡ��<br>
 * 
 * Shell����ʹ��Increamment Squence ����������<br>
 * �Ƚ��������¼���зָ��Ϊ���������зֱ����ֱ�Ӳ�������<br>
 * �����������еļ�¼�����������ȫ�����һ��ֱ�Ӳ�������<br>
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
		// i����gap
		// ����汾��û����~!!!!!!!!!!!!!!!!!!!!
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
		 * ����汾����ʦ�μ��ģ��Ƚ��׶�
		 */
		int tmp;
		int gap = a.length / 2;// gap�������м��
		while (gap != 0) { // ѭ��,ֱ��gapΪ��
			for (int i = gap; i < a.length; i++) {
				tmp = a[i]; // ֱ�Ӳ�������
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
