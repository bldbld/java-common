package org.ballad.javacommon.algorithms.oj.poj.grids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * POJ - 2750 鸡兔同笼问题<br>
 * 问题描述:一个笼子里面关了鸡和兔子（鸡有2只脚，兔子有4只脚，没有例外）。已经知道了笼子里面脚的总数 a，问笼子里面至少有多少只动物，至多有多少只动物。<br>
 * 输入数据:第1行是测试数据的组数n，后面跟着n行输入。每组测试数据占1行，包括一个正整数a(a<32768)。<br>
 * 输出要求:n行，每行输出对应一个输入。输出是两个正整数，第一个是最少的动物数，第二个是
 * 最多的动物数，两个正整数用空格分开。如果没有满足要求的情况出现，则输出2个0。<br>
 * 输入样例:<br>
 * 2<br>
 * 3<br>
 * 20<br>
 * 输出样例:<br>
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
