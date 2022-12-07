package org.ballad.javacommon.algorithms.ztepc.preliminary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 中兴捧月程序设计大赛之俄罗斯套娃
 * 
 * 伊万洛夫在比武大会上力克群雄，成为新一届“草原雄鹰”，为部落赢得了莫大荣誉。首领决定要重重奖赏，他对伊万洛夫说：“孩子，你是知道的，面前的这片草原，
 * 南北向和东西向的道路纵横交错
 * 。现在，路口放着纯金打造的俄罗斯娃娃，重量大小不等，重的都能装下轻的。你可以沿着道路飞奔，拾取路口的娃娃，要求是任何时刻必须是一个套娃
 * ，装好后就不能再拆开了。注意不要走重复路。” 请你为伊万洛夫规划路线，使得他能够有最大的收获。 Input: cross.txt 输入包括多组测试用例；
 * 每个测试用例开始是一对整数<R, C>，R表示东西向道路数，C表示南北向道路总数；接下来R行，每行包括C个正整数（或0）W[r,c]，
 * 分别表示第r条东西向道路与第c条南北向道路交叉处路口放置的俄罗斯娃娃的重量（或表示没有放置娃娃）。 Output: 输出能有最大收获的路径规划。
 * 
 * 
 * 假设1： cross.txt 2 7
 * 
 * 1 2 13 6 7 12 11 14 3 4 5 8 9 10 输出： 1 2 3 4 5 6 7 8 9 10 11 12
 * 
 * 假设2： cross.txt 5 5
 * 
 * 1 16 15 14 13 2 17 24 23 12 3 18 25 22 11 4 19 20 21 10 5 6 7 8 9
 * 
 * 
 * 输出： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
 * 
 * 
 * 注释: 1)从<0,0>出发; 2)路线不能重复; 3)不要求最后回到出发点。
 * 
 * @author ballad
 */
public class RussianDolls {
	/*
	 * Q1:俄罗斯套娃奖品
	 */
	private int[][] c;
	private int maxLeft = 0;
	private int maxRight = 0;

	public RussianDolls() {
	}

	public void run(String filename) {
		this.getArray(filename);
		int[][] mark = new int[maxLeft + 1][maxRight + 1];
		for (int i = 0; i < maxLeft + 1; i++) {
			for (int j = 0; j < maxRight + 1; j++) {
				mark[i][j] = 0;
			}
		}
		int[] ans = calcRoute(0, 0, 0, mark, 0);
		for (int i = 0; i < ans.length - 2; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println(ans[ans.length - 2]);
	}

	public void getArray(String filename) {
		try {
			FileReader fr = new FileReader(new File(filename));
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			s = s.trim();
			String[] nums = s.split("\\s+");
			int maxLeftAll = Integer.parseInt(nums[0]);
			int maxRightAll = Integer.parseInt(nums[1]);
			c = new int[maxLeftAll][maxRightAll];
			maxLeft = maxLeftAll - 1;
			maxRight = maxRightAll - 1;
			for (int i = 0; i <= maxLeft; i++) {
				s = br.readLine();
				s = s.trim();
				nums = s.split("\\s+");
				for (int j = 0; j <= maxRight; j++) {
					c[i][j] = Integer.parseInt(nums[j]);
				}
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			System.err.println("Wrong Text Loaded!");
		}
	}

	public int[] calcRoute(int left, int right, int faDes, int[][] mark,
			int lastValue) {
		/*
		 * faDes Def: 0 1 i 3 2 mark is a signal array that shows 0 points we
		 * have been
		 */
		int flag = 0;
		int thisValue = c[left][right];
		if (thisValue == 0) {
			mark[left][right] = 1;
		} else {
			lastValue = thisValue;
		}
		int[][] routeLength = { { 0 }, { 0 }, { 0 } };
		int[] values = { 0, 0, 0 };
		if (faDes != 0
				&& (left - 1 >= 0)
				&& (c[left - 1][right] > lastValue || (c[left - 1][right] == 0 && getMark(
						mark, left - 1, right)))) {
			routeLength[flag] = calcRoute(left - 1, right, 2, mark, lastValue);
			flag++;
		}
		if (faDes != 1
				&& (right - 1) > 0
				&& (c[left][right - 1] > lastValue || (c[left][right - 1] == 0 && getMark(
						mark, left, right - 1)))) {
			routeLength[flag] = calcRoute(left, right - 1, 3, mark, lastValue);
			flag++;
		}
		if (faDes != 2
				&& (left + 1 <= maxLeft)
				&& (c[left + 1][right] > lastValue || (c[left + 1][right] == 0 && getMark(
						mark, left + 1, right)))) {
			routeLength[flag] = calcRoute(left + 1, right, 0, mark, lastValue);
			flag++;
		}
		if (faDes != 3
				&& (right + 1 <= maxRight)
				&& (c[left][right + 1] > lastValue || (c[left][right + 1] == 0 && getMark(
						mark, left, right + 1)))) {
			routeLength[flag] = calcRoute(left, right + 1, 1, mark, lastValue);
			flag++;
		}
		values[0] = getValues(routeLength[0]);
		values[1] = getValues(routeLength[1]);
		values[2] = getValues(routeLength[2]);
		int[] reRoute;
		if (values[0] > values[1]) {
			if (values[0] > values[2]) {
				reRoute = routeLength[0];
			} else {
				reRoute = routeLength[1];
			}
		} else {
			if (values[1] > values[2]) {
				reRoute = routeLength[1];
			} else {
				reRoute = routeLength[2];
			}
		}
		int[] re = new int[reRoute.length + 1];
		re[0] = c[left][right];
		for (int i = 0; i < reRoute.length; i++) {
			re[i + 1] = reRoute[i];
		}
		return re;
	}

	public int getValues(int[] a) {
		// return a array's total value
		int values = 0;
		for (int i = 0; i < a.length; i++) {
			values += a[i];
		}
		return values;
	}

	public boolean getMark(int[][] mark, int left, int right) {
		return mark[left][right] == 0;
	}

	public static void main(String[] args) {
		RussianDolls rt = new RussianDolls();
		rt.run("cross.txt");
	}
}
