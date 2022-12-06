package org.ballad.javacommon.algorithms.oj.poj.grids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * POJ - 2750 ����ͬ������<br>
 * ��������:һ������������˼������ӣ�����2ֻ�ţ�������4ֻ�ţ�û�����⣩���Ѿ�֪������������ŵ����� a�����������������ж���ֻ��������ж���ֻ���<br>
 * ��������:��1���ǲ������ݵ�����n���������n�����롣ÿ���������ռ1�У�����һ��������a(a<32768)��<br>
 * ���Ҫ��:n�У�ÿ�������Ӧһ�����롣�������������������һ�������ٵĶ��������ڶ�����
 * ���Ķ������������������ÿո�ֿ������û������Ҫ���������֣������2��0��<br>
 * ��������:<br>
 * 2<br>
 * 3<br>
 * 20<br>
 * �������:<br>
 * 0 0<br>
 * 5 10<br>
 * 
 * @author Ballad
 * @date 2011-08-18
 */
public class Prob2750 {

	/**
	 * @author Ballad
	 */
	public static void runMethod() {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String bufStr = input.readLine();
			int maxLoop = Integer.parseInt(bufStr);

			int maxAnimalNum = 0;
			int minAnimalNum = 0;
			int totalFeet = 0;
			int tmpRabbitNum = 0;
			int tmpChickenNum = 0;

			for (int i = 0; i < maxLoop; i++) {
				bufStr = input.readLine();
				totalFeet = Integer.parseInt(bufStr);

				if (totalFeet % 2 == 0) {
					tmpRabbitNum = totalFeet / 4;
					tmpChickenNum = (totalFeet % 4) / 2;
					minAnimalNum = tmpRabbitNum + tmpChickenNum;

					tmpRabbitNum = 0;
					tmpChickenNum = totalFeet / 2;
					maxAnimalNum = tmpRabbitNum + tmpChickenNum;
				} else {
					minAnimalNum = 0;
					maxAnimalNum = 0;
				}

				System.out.println(minAnimalNum + " " + maxAnimalNum);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Prob2750.runMethod();
	}
}
