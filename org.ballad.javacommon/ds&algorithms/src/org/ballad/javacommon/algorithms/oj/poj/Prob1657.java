package org.ballad.javacommon.algorithms.oj.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * POJ - 1657 �����ϵľ���<br>
 * 
 * Description<br>
 * �����󡢳���������ӹ������£�<br>
 * �����ᡢֱ��б�������ߣ���ÿ������һ��<br>
 * �󣺺ᡢֱ��б�������ߣ�ÿ�������������ơ�<br>
 * �����ᡢ���������ߣ�����б�ߣ��������ޡ�<br>
 * ��ֻ��б�ߣ��������ޡ�<br>
 * дһ�����򣬸�����ʼλ�ú�Ŀ��λ�ã����������󡢳��������ʼλ���ߵ�Ŀ��λ�� ��������ٲ�����<br>
 * 
 * ��������:<br>
 * 2 <br>
 * a1 c3 <br>
 * f5 f8 <br>
 * 
 * �������:<br>
 * 2 1 2 1 <br>
 * 3 1 1 Inf<br>
 * 
 * @author Ballad
 * @date 2011-08-19
 */
public class Prob1657 {
	/**
	 * DESC: �˷���δ������������ȷ���жϡ�
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

				// �������Ժᡢֱ��б�ߣ���������������ֵ
				kingLeastStep = (xLen > yLen) ? xLen : yLen;

				// �ʺ���Ҫ�ж�������յ��Ƿ���һֱ�߻���б����
				queenLeastStep = (xLen == yLen || xLen == 0 || yLen == 0) ? 1
						: 2;

				// ����Ҫ�ж�������յ��Ƿ���һֱ����
				rookLeastStep = (xLen == 0 || yLen == 0) ? 1 : 2;

				// ��ֻ��б�ߣ�ֻ���������ϵİ�ɫ������ɫ�������ߣ�ͬһ��ɫ��������������(x-y),(x+y)����żһ��
				// ����(x1,y1)��(x2,y2)����(x1-y1)-(x2-y2)=(x1-x2)-(y1-y2)�������xLen��yLen��żһ��
				// xLen��yLen��żһ�¿����ñ��ʽ(xLen - yLen) % 2 == 0�ж�
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