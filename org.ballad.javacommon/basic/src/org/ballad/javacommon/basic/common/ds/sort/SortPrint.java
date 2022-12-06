package org.ballad.javacommon.basic.common.ds.sort;

/** 
 * Support Class.
 * 
 * @author ballad
 * @version 2010/04/26 initial
 * @version 2012/04/30 code format
 */
public class SortPrint {

	public static void print(String sortName, int[] a) {
		System.out.print(sortName + ":");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
