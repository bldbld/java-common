package org.ballad.javacommon.algorithms.oj.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * POJ - 1017 Packets<br>
 * 
 * Description<br>
 * A factory produces products packed in square packets of the same height h and
 * of the sizes 1*1, 2*2, 3*3, 4*4, 5*5, 6*6. These products are always
 * delivered to customers in the square parcels of the same height h as the
 * products have and of the size 6*6. Because of the expenses it is the interest
 * of the factory as well as of the customer to minimize the number of parcels
 * necessary to deliver the ordered products from the factory to the customer. A
 * good program solving the problem of finding the minimal number of parcels
 * necessary to deliver the given products according to an order would save a
 * lot of money. You are asked to make such a program.<br>
 * 
 * Input<br>
 * The input file consists of several lines specifying orders. Each line
 * specifies one order. Orders are described by six integers separated by one
 * space representing successively the number of packets of individual size from
 * the smallest size 1*1 to the biggest size 6*6. The end of the input file is
 * indicated by the line containing six zeros.<br>
 * 
 * Output<br>
 * The output file contains one line for each line in the input file. This line
 * contains the minimal number of parcels into which the order from the
 * corresponding line of the input file can be packed. There is no line in the
 * output file corresponding to the last ``null'' line of the input file.<br>
 * 
 * Sample Input<br>
 * 0 0 4 0 0 1 <br>
 * 7 5 1 0 0 0 <br>
 * 0 0 0 0 0 0 <br>
 * 
 * Sample Output<br>
 * 2 <br>
 * 1 <br>
 * 
 * @author Ballad
 * @date 20110820
 */
public class Prob1017 {
	public static void runMethod1() {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		boolean isContinue = true;
		try {
			String bufStr = null;
			String[] bufArr = null;
			int[] inputValue = null;
			int count = 0;
			do {
				count = 0;
				isContinue = false;
				bufStr = input.readLine();
				bufArr = bufStr.split(" ");
				inputValue = new int[6];
				for (int i = 0; i < 6; i++) {
					inputValue[i] = Integer.parseInt(bufArr[i]);
					if (inputValue[i] != 0) {
						isContinue = true;
					}
				}
				if (isContinue == false) {
					break;
				}
				count = inputValue[5] + inputValue[4] + inputValue[3]
						+ inputValue[2] / 4 * 4;

				int r = inputValue[2] % 4;

				int b = (int) Math.pow(2, (3 - r));

				if (r == 0) {

				} else {
					if (inputValue[2] > b) {

					}
				}

				System.out.println(count);
			} while (true);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Prob1017.runMethod1();
	}
}
