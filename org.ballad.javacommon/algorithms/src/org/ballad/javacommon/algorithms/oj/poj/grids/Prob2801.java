package org.ballad.javacommon.algorithms.oj.poj.grids;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * POJ - 2801 填词<br>
 * 
 * 输入数据 <br>
 * 输入的第一行包括三个整数 N， M 和 P (2 <= M, N <= 10, 0 <= P <=100)。接下来的 N行， 每行包括
 * M个字符，来表示方格盘。接下来 P 行给出需要在方格盘中找到的单词。 <br>
 * 输入保证填词游戏至少有一组答案。 输入中给出的字母都是大写字母。 <br>
 * 输出要求 <br>
 * 输出“神秘单词”，注意“神秘单词”中的字母要按照字典序给出。 <br>
 * 
 * 输入示例：<br>
 * 3 3 2<br>
 * EBG<br>
 * GEE<br>
 * EGE<br>
 * BEG<br>
 * GEE<br>
 * 输出示例：<br>
 * EEG<br>
 * 
 * @author Ballad
 * @date 2011-08-19
 */
public class Prob2801 {

	/**
	 * 思路：将所有字母放在26位数组中，方格盘中存在+1，输入的单词包括-1，最后统计即可。
	 */
	public static void runMethod1() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(
					System.in));
			String bufStr = input.readLine();
			String[] bufArr = bufStr.split(" ");

			int nLen = Integer.parseInt(bufArr[0]);
			int mLen = Integer.parseInt(bufArr[1]);
			int pLen = Integer.parseInt(bufArr[2]);
			int[] dict = new int[26];

			for (int i = 0; i < nLen; i++) {
				bufStr = input.readLine();
				for (int j = 0; j < mLen; j++) {
					dict[bufStr.charAt(j) - 'A']++;
				}
			}

			for (int i = 0; i < pLen; i++) {
				bufStr = input.readLine();
				for (int j = 0; j < bufStr.length(); j++) {
					dict[bufStr.charAt(j) - 'A']--;
				}
			}

			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < dict[i]; j++) {
					System.out.print((char) (i + 65));
				}
			}

		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		Prob2801.runMethod1();
	}

}
