package org.ballad.javacommon.algorithms.unsorted;

/**
 * 二维数组的旋转<br>
 * 题目来源：网络<br>
 * 将二维数组：<br>
 * 1,2<br>
 * 3,4<br>
 * 顺时针旋转为<br>
 * 3,1<br>
 * 4,2<br>
 * 思路<br>
 * 其实就是将坐标轴旋转，方法是：先沿着对角线对折，（即2，3换位），然后X轴的坐标作翻转即可。
 * 
 * @author Ballad
 * @date 2011-12-02
 * 
 */
public class DimensionArrayRevolve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int xLen = 2;
		int yLen = 2;
		int[][] array = { { 1, 2 }, { 3, 4 } };
		int[][] tmp = new int[xLen][yLen];
		for (int i = 0; i < xLen; i++) {
			for (int j = 0; j < yLen; j++) {
				tmp[j][xLen - 1 - i] = array[i][j];
			}
		}
		// OUTPUT
		for (int i = 0; i < xLen; i++) {
			for (int j = 0; j < yLen; j++) {
				System.out.print(tmp[i][j] + ",");
			}
			System.out.println();
		}
	}
}
