package org.ballad.javacommon.algorithms.oj.poj.grids;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * POJ - 2801 ���<br>
 * 
 * �������� <br>
 * ����ĵ�һ�а����������� N�� M �� P (2 <= M, N <= 10, 0 <= P <=100)���������� N�У� ÿ�а���
 * M���ַ�������ʾ�����̡������� P �и�����Ҫ�ڷ��������ҵ��ĵ��ʡ� <br>
 * ���뱣֤�����Ϸ������һ��𰸡� �����и�������ĸ���Ǵ�д��ĸ�� <br>
 * ���Ҫ�� <br>
 * ��������ص��ʡ���ע�⡰���ص��ʡ��е���ĸҪ�����ֵ�������� <br>
 * 
 * ����ʾ����<br>
 * 3 3 2<br>
 * EBG<br>
 * GEE<br>
 * EGE<br>
 * BEG<br>
 * GEE<br>
 * ���ʾ����<br>
 * EEG<br>
 * 
 * @author Ballad
 * @date 2011-08-19
 */
public class Prob2801 {

	/**
	 * ˼·����������ĸ����26λ�����У��������д���+1������ĵ��ʰ���-1�����ͳ�Ƽ��ɡ�
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
