package org.ballad.javacommon.algorithms.oj.poj.grids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * POJ - 2808 校门外的树<br>
 * 问题描述 <br>
 * 某校大门外长度为 L 的马路上有一排树，每两棵相邻的树之间的间隔都是 1 米。我 可以把马路看成一个数轴，马路的一端在数轴 0 的位置，另一端在 L
 * 的位置；数轴上的 个整数点，即 0，1，2，……，L，都种有一棵树。 <br>
 * 由于马路上有一些区域要用来建地铁。这些区域用它们在数轴上的起始点和终止点表示，已知任一区域的起始点和终止点的坐标都是整数，区域之间可能有重合的部分。现在要把
 * 区域中的树（包括区域端点处的两棵树）移走。你的任务是计算将这些树都移走后，还有多少棵树。 <br>
 * 输入数据 <br>
 * 输入的第一行有两个整数 L（1 <= L <= 10000）和 M（1 <= M <= 100），L 代表马 的长度，M代表区域的数目，L 和M
 * 之间用一个空格隔开。接下来的 M 行每行包含两 同的整数，用一个空格隔开，表示一个区域的起始点和终止点的坐标。 <br>
 * 输出要求 <br>
 * 输出包括一行，这一行只包含一个整数，表示马路上剩余的树的数目。 <br>
 * 输入样例:<br>
 * 500 3<br>
 * 100 200<br>
 * 150 300<br>
 * 400 471<br>
 * 输出样例:<br>
 * 298<br>
 * 
 * @author Ballad
 * @date 2011-08-19
 */
public class Prob2808 {

	/**
	 * 方法(1):思路：区间合并<br>
	 * 通过一个数组记录下来所有的地铁区间，排序后，解析出需要移除树木的区间。
	 * 
	 * 此方法对于本题中已经指定了马路长度范围不超过1000的情况并不高效<br>
	 * 相对而言更适用于输入的树的基础值很大且地铁段的数目不是特别大的情况。<br>
	 * 
	 * @author Ballad
	 * @see Point
	 */
	public static void runMethod1() {

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String bufStr = input.readLine();
			String[] bufStrArray = bufStr.split(" ");
			int totalLen = Integer.parseInt(bufStrArray[0]);
			int maxLoop = Integer.parseInt(bufStrArray[1]);
			Point pStart;
			Point pEnd;
			Point[] points = new Point[maxLoop * 2];
			int totalTree = totalLen + 1;

			for (int i = 0; i < maxLoop; i++) {
				bufStr = input.readLine();
				bufStrArray = bufStr.split(" ");

				pStart = new Point();
				pStart.type = 'S';
				pStart.value = Integer.parseInt(bufStrArray[0]);
				points[2 * i] = pStart;

				pEnd = new Point();
				pEnd.type = 'E';
				pEnd.value = Integer.parseInt(bufStrArray[1]);
				points[2 * i + 1] = pEnd;
			}
			Arrays.sort(points);

			// 记录队列中起始的'S'点的value
			int tmpTreeStart = 0;
			// 是否处于计算中，用于过滤掉队列中非起始的'S'点
			boolean isCalc = false;

			for (int i = 0; i < points.length; i++) {
				if (points[i].type == 'S' && isCalc == false) {
					tmpTreeStart = points[i].value;
					isCalc = true;
				} else if (points[i].type == 'E' && isCalc == true) {
					if (i == points.length - 1) {
						// 到达一个结束点，且到达数组结尾，并防止下面的判断出现数组越界
						totalTree = totalTree
								- (points[i].value - tmpTreeStart + 1);
						isCalc = false;
					} else if (points[i + 1].type == 'S') {
						// 到达一个结束点，且后面还有新的队列段
						totalTree = totalTree
								- (points[i].value - tmpTreeStart + 1);
						isCalc = false;
					}
				}
			}
			System.out.println(totalTree);
		} catch (IOException e) {
		}
	}

	/**
	 * 方法(2):将树对应在布尔数组上，如果树木在地铁区间上，则置为假，最后通过判断布尔值真假来确实树木数量。<br>
	 * 
	 * @author Ballad
	 */
	public static void runMethod2() {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String bufStr = input.readLine();
			String[] bufStrArray = bufStr.split(" ");
			int totalLen = Integer.parseInt(bufStrArray[0]);
			int maxLoop = Integer.parseInt(bufStrArray[1]);
			boolean[] trees = new boolean[totalLen + 1];

			for (int i = 0; i < trees.length; i++) {
				trees[i] = true;
			}
			for (int i = 0; i < maxLoop; i++) {
				bufStr = input.readLine();
				bufStrArray = bufStr.split(" ");

				int max = Integer.parseInt(bufStrArray[1]);

				for (int j = Integer.parseInt(bufStrArray[0]); j <= max; j++) {
					trees[j] = false;
				}
			}
			int count = 0;
			for (int i = 0; i < trees.length; i++) {
				if (trees[i] == true) {
					count++;
				}
			}
			System.out.println(count);
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {

		// Q2808.runMethod1();

		Prob2808.runMethod2();
	}
}

class Point implements Comparable<Point> {
	char type;
	int value;

	/**
	 * Array.sort是默认按从大到小排序<br>
	 * 为完成从小到大排序,此处的比较逻辑于正常相反，为：1 小于；0 等于；-1 大于<br>
	 * 对于value相同的点，则S向前排，E向后排，即认为S大于E，返回-1；如果type相同，则返回1与返回0没有区别。<br>
	 * 对于value相同的点，S向前排，E向后排的原因为：<br>
	 * 这样可以形成S(SE)E而不是S(ES)E的形式，如果是S(ES)E形式，相当于重复计算了点。<br>
	 */
	@Override
	public int compareTo(Point o) {
		if (o.value > this.value) {
			return -1;
		} else if (o.value == this.value) {
			if (this.type == 'S') {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
}
