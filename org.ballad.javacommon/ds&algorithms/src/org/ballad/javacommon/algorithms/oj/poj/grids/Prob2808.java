package org.ballad.javacommon.algorithms.oj.poj.grids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * POJ - 2808 У�������<br>
 * �������� <br>
 * ĳУ�����ⳤ��Ϊ L ����·����һ������ÿ�������ڵ���֮��ļ������ 1 �ס��� ���԰���·����һ�����ᣬ��·��һ�������� 0 ��λ�ã���һ���� L
 * ��λ�ã������ϵ� �������㣬�� 0��1��2��������L��������һ������ <br>
 * ������·����һЩ����Ҫ��������������Щ�����������������ϵ���ʼ�����ֹ���ʾ����֪��һ�������ʼ�����ֹ������궼������������֮��������غϵĲ��֡�����Ҫ��
 * �����е�������������˵㴦�������������ߡ���������Ǽ��㽫��Щ�������ߺ󣬻��ж��ٿ����� <br>
 * �������� <br>
 * ����ĵ�һ������������ L��1 <= L <= 10000���� M��1 <= M <= 100����L ������ �ĳ��ȣ�M�����������Ŀ��L ��M
 * ֮����һ���ո�������������� M ��ÿ�а����� ͬ����������һ���ո��������ʾһ���������ʼ�����ֹ������ꡣ <br>
 * ���Ҫ�� <br>
 * �������һ�У���һ��ֻ����һ����������ʾ��·��ʣ���������Ŀ�� <br>
 * ��������:<br>
 * 500 3<br>
 * 100 200<br>
 * 150 300<br>
 * 400 471<br>
 * �������:<br>
 * 298<br>
 * 
 * @author Ballad
 * @date 2011-08-19
 */
public class Prob2808 {

	/**
	 * ����(1):˼·������ϲ�<br>
	 * ͨ��һ�������¼�������еĵ������䣬����󣬽�������Ҫ�Ƴ���ľ�����䡣
	 * 
	 * �˷������ڱ������Ѿ�ָ������·���ȷ�Χ������1000�����������Ч<br>
	 * ��Զ��Ը���������������Ļ���ֵ�ܴ��ҵ����ε���Ŀ�����ر��������<br>
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

			// ��¼��������ʼ��'S'���value
			int tmpTreeStart = 0;
			// �Ƿ��ڼ����У����ڹ��˵������з���ʼ��'S'��
			boolean isCalc = false;

			for (int i = 0; i < points.length; i++) {
				if (points[i].type == 'S' && isCalc == false) {
					tmpTreeStart = points[i].value;
					isCalc = true;
				} else if (points[i].type == 'E' && isCalc == true) {
					if (i == points.length - 1) {
						// ����һ�������㣬�ҵ��������β������ֹ������жϳ�������Խ��
						totalTree = totalTree
								- (points[i].value - tmpTreeStart + 1);
						isCalc = false;
					} else if (points[i + 1].type == 'S') {
						// ����һ�������㣬�Һ��滹���µĶ��ж�
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
	 * ����(2):������Ӧ�ڲ��������ϣ������ľ�ڵ��������ϣ�����Ϊ�٣����ͨ���жϲ���ֵ�����ȷʵ��ľ������<br>
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
	 * Array.sort��Ĭ�ϰ��Ӵ�С����<br>
	 * Ϊ��ɴ�С��������,�˴��ıȽ��߼��������෴��Ϊ��1 С�ڣ�0 ���ڣ�-1 ����<br>
	 * ����value��ͬ�ĵ㣬��S��ǰ�ţ�E����ţ�����ΪS����E������-1�����type��ͬ���򷵻�1�뷵��0û������<br>
	 * ����value��ͬ�ĵ㣬S��ǰ�ţ�E����ŵ�ԭ��Ϊ��<br>
	 * ���������γ�S(SE)E������S(ES)E����ʽ�������S(ES)E��ʽ���൱���ظ������˵㡣<br>
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
