package org.ballad.javacommon.algorithms.unsorted;

/**
 * 很多成对出现数字保存在磁盘文件中，注意成对的数字不一定是相邻的，如2, 3, 4, 3, 4,
 * 2……，由于意外有一个数字消失了，如何尽快的找到是哪个数字消失了？
 * <p>
 * 方式，如果是有序的，可以采用二分法，既然是无序的，可以采取累计相加然后算差值，如果数据量大使用此方法
 * </p>
 * 
 * @author ballad
 * 
 */
public class FindLostNumber {

	public static void main(String[] args) {
		System.out.println(FindLostNumber.foo(new int[] { 1, 3, 6, 2 },
				new int[] { 1, 6, 2 })); // expected : 3
	}

	/**
	 * 使用异或的方式，因为a^b=c -> b=c^a
	 * 
	 * @see XORBasic
	 * @param values
	 * @return
	 */
	public static int foo(int[] valuesBeforeLost, int[] valuesAfterLost) {
		int retBeforeLost = getXORResult(valuesBeforeLost);
		int retAfterLost = getXORResult(valuesAfterLost);
		return retBeforeLost ^ retAfterLost;
	}

	public static int getXORResult(int[] values) {
		int ret = 0;
		for (int value : values) {
			ret ^= value;
		}
		return ret;
	}
}
