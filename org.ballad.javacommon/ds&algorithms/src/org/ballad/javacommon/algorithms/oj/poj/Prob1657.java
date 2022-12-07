package org.ballad.javacommon.algorithms.oj.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * POJ - 1657 棋盘上的距离<br>
 * 
 * Description<br>
 * 王、后、车、象的走子规则如下：<br>
 * 王：横、直、斜都可以走，但每步限走一格。<br>
 * 后：横、直、斜都可以走，每步格数不受限制。<br>
 * 车：横、竖均可以走，不能斜走，格数不限。<br>
 * 象：只能斜走，格数不限。<br>
 * 写一个程序，给定起始位置和目标位置，计算王、后、车、象从起始位置走到目标位置 所需的最少步数。<br>
 * 
 * 输入样例:<br>
 * 2 <br>
 * a1 c3 <br>
 * f5 f8 <br>
 * 
 * 输出样例:<br>
 * 2 1 2 1 <br>
 * 3 1 1 Inf<br>
 * 
 * @author Ballad
 * @date 2011-08-19
 */
public class Prob1657 {
	/**
	 * DESC: 此方法未作输入数据正确性判断。
	 * 
	 * @author Ballad
	 */
	public static void runMethod() {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String bufStr = input.readLine();
			int maxLoop = Integer.parseInt(bufStr);

			String[] coordinates = null;
			int xLen = 0;
			int yLen = 0;

			int kingLeastStep = 0;
			int queenLeastStep = 0;
			int rookLeastStep = 0;
			int bishopLeastStep = 0;

			for (int i = 0; i < maxLoop; i++) {
				bufStr = input.readLine();
				coordinates = bufStr.split(" ");
				xLen = Math.abs(coordinates[0].charAt(0)
						- coordinates[1].charAt(0));
				yLen = Math.abs(coordinates[0].charAt(1)
						- coordinates[1].charAt(1));

				// 国王可以横、直、斜走，步数是最大坐标差值
				kingLeastStep = (xLen > yLen) ? xLen : yLen;

				// 皇后需要判断起点与终点是否在一直线或是斜线上
				queenLeastStep = (xLen == yLen || xLen == 0 || yLen == 0) ? 1
						: 2;

				// 车需要判断起点与终点是否在一直线上
				rookLeastStep = (xLen == 0 || yLen == 0) ? 1 : 2;

				// 象只能斜走，只能在棋盘上的白色区域或黑色区域内走，同一颜色区域内坐标满足(x-y),(x+y)的奇偶一致
				// 对于(x1,y1)与(x2,y2)，由(x1-y1)-(x2-y2)=(x1-x2)-(y1-y2)，则存在xLen与yLen奇偶一致
				// xLen与yLen奇偶一致可以用表达式(xLen - yLen) % 2 == 0判断
				if ((xLen - yLen) % 2 == 0) {
					bishopLeastStep = (xLen == yLen) ? 1 : 2;
					System.out.println(kingLeastStep + " " + queenLeastStep
							+ " " + rookLeastStep + " " + bishopLeastStep);
				} else {
					System.out.println(kingLeastStep + " " + queenLeastStep
							+ " " + rookLeastStep + " Inf");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Prob1657.runMethod();
	}
}